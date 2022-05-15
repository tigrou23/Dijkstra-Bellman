package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.CircuitEx;
import exception.NoPathEx;
import graphe.AlgoPlusCourt;
import graphe.IGraphe;
import graphe.types.GrapheLA;
import graphe.types.GrapheMA;
import pcc.PCCBellman;

public class PCCBellmanTest {

	@Test
	void resoudreTest() {
		IGraphe g;
		List<Integer> reponseAttendue = new ArrayList<>();
		List<Integer> reponse = new ArrayList<>();

		// Exercice 3.2
		g = new GrapheLA(10);
		g.ajouterArc(1, 3, 4);
		g.ajouterArc(1, 8, 2);
		g.ajouterArc(2, 5, 5);
		g.ajouterArc(2, 4, 3);
		g.ajouterArc(3, 5, 9);
		g.ajouterArc(3, 1, 6);
		g.ajouterArc(4, 1, 10);
		g.ajouterArc(4, 2, 5);
		g.ajouterArc(5, 2, 9);
		g.ajouterArc(5, 3, 7);
		g.ajouterArc(6, 5, 8);
		g.ajouterArc(7, 4, 8);
		g.ajouterArc(9, 2, 8);
		g.ajouterArc(10, 6, 6);
		AlgoPlusCourt a = new PCCBellman();
		// test 1 -> 6
		reponseAttendue.add(1);
		reponseAttendue.add(4);
		reponseAttendue.add(10);
		reponseAttendue.add(6);
		a.resoudre(g, 1, 6, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 2 -> 7
		reponseAttendue.add(2);
		reponseAttendue.add(5);
		reponseAttendue.add(7);
		a.resoudre(g, 2, 7, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 1 -> 3
		reponseAttendue.add(1);
		reponseAttendue.add(2);
		reponseAttendue.add(3);
		a.resoudre(g, 1, 3, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
	}

	@Test
	void cycleTest() {
		// graphe du sujet
		IGraphe g = new GrapheMA(4);
		AlgoPlusCourt a = new PCCBellman();
		g.ajouterArc(1, 5, 2);
		g.ajouterArc(1, 4, 3);
		g.ajouterArc(3, -6, 2);
		g.ajouterArc(2, 3, 4);
		g.ajouterArc(4, 2, 3);
		assertThrows(CircuitEx.class, () -> a.estOk(g, 1, 1));

	}

	@Test
	void estOkTest() {
		// graphe insipiré du sujet
		IGraphe g = new GrapheMA(4);
		AlgoPlusCourt a = new PCCBellman();
		g.ajouterArc(1, 5, 2);
		g.ajouterArc(1, 4, 3);
		g.ajouterArc(3, -6, 2);
		g.ajouterArc(4, 2, 3);
		assertThrows(NoPathEx.class, () -> a.estOk(g, 4, 1));
	}
}
