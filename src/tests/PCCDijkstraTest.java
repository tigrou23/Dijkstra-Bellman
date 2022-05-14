package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.ArcNegatifNulException;
import exception.NoPathEx;
import graphe.AlgoPlusCourt;
import graphe.IGraphe;
import graphe.types.GrapheLA;
import graphe.types.GrapheMA;
import pcc.PCCDijkstra;

public class PCCDijkstraTest {

	@Test
	void resoudreTest() {

		IGraphe g = new GrapheMA(9);
		List<Integer> reponseAttendue = new ArrayList<>();
		List<Integer> reponse = new ArrayList<>();

		// Exercice 3.1
		g.ajouterArc(1, 1, 4);
		g.ajouterArc(1, 2, 3);
		g.ajouterArc(2, 3, 7);
		g.ajouterArc(3, 2, 8);
		g.ajouterArc(4, 3, 2);
		g.ajouterArc(4, 3, 5);
		g.ajouterArc(4, 5, 3);
		g.ajouterArc(5, 3, 7);
		g.ajouterArc(5, 7, 8);
		g.ajouterArc(5, 1, 3);
		g.ajouterArc(7, 2, 2);
		g.ajouterArc(7, 1, 6);
		g.ajouterArc(8, 2, 7);
		g.ajouterArc(8, 4, 6);
		g.ajouterArc(9, 10, 8);
		AlgoPlusCourt a = new PCCDijkstra();
		// test 1 -> 6
		reponseAttendue.add(1);
		reponseAttendue.add(3);
		reponseAttendue.add(8);
		reponseAttendue.add(7);
		reponseAttendue.add(6);
		a.resoudre(g, 1, 6, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 1 -> 7
		reponseAttendue.add(1);
		reponseAttendue.add(3);
		reponseAttendue.add(8);
		reponseAttendue.add(7);
		a.resoudre(g, 1, 7, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 4 -> 5
		reponseAttendue.add(4);
		reponseAttendue.add(5);
		a.resoudre(g, 4, 5, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();

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
		AlgoPlusCourt a2 = new PCCDijkstra();
		// test 1 -> 6
		reponseAttendue.add(1);
		reponseAttendue.add(4);
		reponseAttendue.add(10);
		reponseAttendue.add(6);
		a2.resoudre(g, 1, 6, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 2 -> 7
		reponseAttendue.add(2);
		reponseAttendue.add(5);
		reponseAttendue.add(7);
		a2.resoudre(g, 2, 7, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 1 -> 3
		reponseAttendue.add(1);
		reponseAttendue.add(2);
		reponseAttendue.add(3);
		a2.resoudre(g, 1, 3, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();

		// Exercice trouvé sur internet
		g = new GrapheLA(6);
		g.ajouterArc(1, 8, 2);
		g.ajouterArc(1, 3, 5);
		g.ajouterArc(2, 7, 1);
		g.ajouterArc(2, 10, 6);
		g.ajouterArc(2, 7, 3);
		g.ajouterArc(3, 6, 2);
		g.ajouterArc(3, 3, 4);
		g.ajouterArc(4, 12, 1);
		g.ajouterArc(4, 3, 6);
		g.ajouterArc(5, 6, 2);
		g.ajouterArc(5, 11, 4);
		g.ajouterArc(6, 11, 5);
		g.ajouterArc(6, 1, 3);
		AlgoPlusCourt a3 = new PCCDijkstra();
		// test 1 -> 6
		reponseAttendue.add(1);
		reponseAttendue.add(5);
		reponseAttendue.add(4);
		reponseAttendue.add(6);
		a3.resoudre(g, 1, 6, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 1 -> 5
		reponseAttendue.add(1);
		reponseAttendue.add(5);
		a3.resoudre(g, 1, 5, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
		// test 2 -> 3
		reponseAttendue.add(2);
		reponseAttendue.add(3);
		a3.resoudre(g, 2, 3, reponse);
		assertTrue(reponseAttendue.equals(reponse));
		reponseAttendue.clear();
		reponse.clear();
	}

	@Test
	void estOkTest() {
		IGraphe g = new GrapheMA(8);

		// Exercice 3.6
		g.ajouterArc(1, 1, 3);
		g.ajouterArc(1, 7, 2);
		g.ajouterArc(2, -3, 6);
		g.ajouterArc(2, 2, 5);
		g.ajouterArc(2, 4, 4);
		g.ajouterArc(3, 5, 2);
		g.ajouterArc(3, 7, 6);
		g.ajouterArc(3, 2, 5);
		g.ajouterArc(4, 4, 7);
		g.ajouterArc(5, 10, 7);
		g.ajouterArc(6, 5, 4);
		g.ajouterArc(6, 3, 5);
		g.ajouterArc(7, 4, 8);
		AlgoPlusCourt a = new PCCDijkstra();
		assertThrows(ArcNegatifNulException.class, () -> a.estOk(g, 1, 3));

		IGraphe g2 = new GrapheMA(9);
		g2.ajouterArc(1, 1, 4);
		g2.ajouterArc(1, 2, 3);
		g2.ajouterArc(2, 3, 7);
		g2.ajouterArc(3, 2, 8);
		g2.ajouterArc(4, 3, 2);
		g2.ajouterArc(4, 3, 5);
		g2.ajouterArc(4, 5, 3);
		g2.ajouterArc(5, 3, 7);
		g2.ajouterArc(5, 7, 8);
		g2.ajouterArc(5, 1, 3);
		g2.ajouterArc(7, 2, 2);
		g2.ajouterArc(7, 1, 6);
		g2.ajouterArc(8, 2, 7);
		g2.ajouterArc(8, 4, 6);
		g2.ajouterArc(9, 10, 8);
		assertThrows(NoPathEx.class, () -> a.estOk(g2, 1, 9));
	}
}
