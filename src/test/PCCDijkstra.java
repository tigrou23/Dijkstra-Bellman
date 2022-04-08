package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.ArcNegatifNulException;
import graphe.*;

public class PCCDijkstra {
	
	@Test
	void resoudreTest() {
		
		IGraph g = new GrapheMA(9);
		List<Integer> reponse = new ArrayList<>();
		
		//Exercice 3.1
		g.ajouterArc(1,4,1);
		g.ajouterArc(1,3,2);
		g.ajouterArc(2,7,3);
		g.ajouterArc(3,8,2);
		g.ajouterArc(4,2,3);
		g.ajouterArc(4,5,3);
		g.ajouterArc(4,3,5);
		g.ajouterArc(5,7,3);
		g.ajouterArc(5,8,7);
		g.ajouterArc(5,3,1);
		g.ajouterArc(7,2,2);
		g.ajouterArc(7,6,1);
		g.ajouterArc(8,7,2);
		g.ajouterArc(8,6,4);
		g.ajouterArc(9,8,10);
		//test 1 -> 6
		reponse.add(1); reponse.add(3); reponse.add(8); reponse.add(7); reponse.add(6);
		assertTrue(reponse.equals(graphe.PCCDijkstra.resoudre(g,1,6)));
		reponse.clear();
		//test 1 -> 7
		reponse.add(1); reponse.add(3); reponse.add(8); reponse.add(7);
		assertTrue(reponse.equals(graphe.PCCDijkstra.resoudre(g,1,7)));
		reponse.clear();
		//test 4 -> 5
		reponse.add(4); reponse.add(5);
		assertTrue(reponse.equals(graphe.PCCDijkstra.resoudre(g,4,5)));
		reponse.clear();
		
		//Exercice 3.2
		g = new GrapheLA(10);
		g.ajouterArc(1,4,3);
		g.ajouterArc(1,2,8);
		g.ajouterArc(2,5,5);
		g.ajouterArc(2,3,4);
		g.ajouterArc(3,9,5);
		g.ajouterArc(3,6,1);
		g.ajouterArc(4,10,1);
		g.ajouterArc(4,5,2);
		g.ajouterArc(5,9,2);
		g.ajouterArc(5,7,3);
		g.ajouterArc(6,8,5);
		g.ajouterArc(7,8,4);
		g.ajouterArc(9,8,2);
		g.ajouterArc(10,6,6);
		//test 1 -> 6
		reponse.add(1); reponse.add(4); reponse.add(10); reponse.add(6);
		assertTrue(reponse.equals(graphe.PCCDijkstra.resoudre(g,1,6)));
		reponse.clear();
		//test 2 -> 7
		reponse.add(2); reponse.add(5); reponse.add(7);
		assertTrue(reponse.equals(graphe.PCCDijkstra.resoudre(g,2,7)));
		reponse.clear();
		//test 1 -> 3
		reponse.add(1); reponse.add(2); reponse.add(3);
		assertTrue(reponse.equals(graphe.PCCDijkstra.resoudre(g,1,3)));
		reponse.clear();
	}
	
	@Test
	void estOkTest() {
		
		IGraph g = new GrapheMA(8);
		
		//Exercice 3.6
		g.ajouterArc(1,3,1);
		g.ajouterArc(1,2,7);
		g.ajouterArc(2,6,-3);
		g.ajouterArc(2,5,2);
		g.ajouterArc(2,4,4);
		g.ajouterArc(3,2,5);
		g.ajouterArc(3,6,7);
		g.ajouterArc(3,5,2);
		g.ajouterArc(4,7,4);
		g.ajouterArc(5,7,10);
		g.ajouterArc(6,4,5);
		g.ajouterArc(6,5,3);
		g.ajouterArc(7,8,4);
		assertThrows(ArcNegatifNulException.class, () -> graphe.PCCDijkstra.resoudre(g,1,3));
	}


}

