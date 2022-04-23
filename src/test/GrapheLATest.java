package test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import graphe.Arc;
import graphe.GrapheLA;
import graphe.GrapheMA;
import graphe.IGraph;
import graphe.Sommet;

class GrapheLATest {
	
	private static final int NB_NOEUDS = 6;

	@Test
	void test() {
		GrapheLA g = new GrapheLA(NB_NOEUDS);
		assertEquals(NB_NOEUDS, g.getNbNoeuds());
		g.ajouterArc(1, 2, 0);
		g.ajouterArc(1, 3, 0);
		g.ajouterArc(1, 4, 0);
		g.ajouterArc(1, 5, 0);
		g.ajouterArc(2, 5, 0);
		g.ajouterArc(4, 4, 0);
		g.ajouterArc(5, 1, 0);

		assertTrue(g.aArc(1, 3));
		assertTrue(g.aArc(4, 4));
		assertTrue(g.aArc(5, 1));
		assertFalse(g.aArc(4, 1));
		assertFalse(g.aArc(6, 2));

		assertEquals(4, g.dOut(1)); // degre sortant
		assertEquals(1, g.dOut(2));
		assertEquals(0, g.dOut(3));
		assertEquals(1, g.dOut(5));
		assertEquals(0, g.dOut(6));
		assertEquals(1, g.dIn(1)); // degre entrant
		assertEquals(2, g.dIn(4));
		assertEquals(2, g.dIn(5));
		assertEquals(0, g.dIn(6));
		assertTrue(g.toString()
				.contentEquals("1 -> 2 3 4 5 \n" + "2 -> 5 \n" + "3 -> \n" + "4 -> 4 \n" + "5 -> 1 \n" + "6 -> \n"));
		
		

		
		


	}
	
	@Test
	void test2() {
		GrapheLA g = new GrapheLA(NB_NOEUDS);
		assertEquals(NB_NOEUDS, g.getNbNoeuds());
		g.ajouterArc("A", "B", 0);
		g.ajouterArc("A", "C", 0);
		g.ajouterArc("A", "D", 0);
		g.ajouterArc("A", "E", 0);
		g.ajouterArc("B", "E", 0);
		g.ajouterArc("D", "D", 0);
		g.ajouterArc("E", "A", 0);

		assertTrue(g.aArc("A", "C"));
		assertTrue(g.aArc("D", "D"));
		assertTrue(g.aArc("E", "A"));
		assertFalse(g.aArc("D", "A"));
		assertFalse(g.aArc("F", "B"));
		
		assertEquals(4, g.dOut("A")); // degre sortant
		assertEquals(1, g.dOut("B"));
		assertEquals(0, g.dOut("C"));
		assertEquals(1, g.dOut("E"));
		assertEquals(0, g.dOut("F"));
		assertEquals(1, g.dIn("A")); // degre entrant
		assertEquals(2, g.dIn("D"));
		assertEquals(2, g.dIn("E"));
		assertEquals(0, g.dIn("F"));
		assertTrue(g.toString()
				.contentEquals("A -> B C D E \n" + "B -> E \n" + "C -> \n" + "D -> D \n" + "E -> A \n" + "F -> \n"));
		

	}
}
