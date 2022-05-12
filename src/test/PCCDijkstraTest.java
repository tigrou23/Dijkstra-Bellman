package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.*;
import graphe.*;

public class PCCDijkstraTest {
/*	
	@Test
	void resoudreTest() {
		
		IGraphe g = new GrapheMA(9);
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
		AlgoPlusCourt a = new PCCDijkstra();
		//test 1 -> 6
		reponse.add(1); reponse.add(3); reponse.add(8); reponse.add(7); reponse.add(6);
		ArrayList<Integer> list1 = new ArrayList<>();
		assertTrue(reponse.equals(a.resoudre(g,1,6,list1)));
		reponse.clear();
		//test 1 -> 7
		reponse.add(1); reponse.add(3); reponse.add(8); reponse.add(7);
		assertTrue(reponse.equals(a.resoudre(g,1,7,list1)));
		reponse.clear();
		//test 4 -> 5
		reponse.add(4); reponse.add(5);
		assertTrue(reponse.equals(a.resoudre(g,4,5,list1)));
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
		AlgoPlusCourt a2 = new PCCDijkstra();
		ArrayList<Integer> list2 = new ArrayList<>();
		//test 1 -> 6
		reponse.add(1); reponse.add(4); reponse.add(10); reponse.add(6);
		assertTrue(reponse.equals(a2.resoudre(g,1,6,list2)));
		reponse.clear();
		//test 2 -> 7
		reponse.add(2); reponse.add(5); reponse.add(7);
		assertTrue(reponse.equals(a2.resoudre(g,2,7,list2)));
		reponse.clear();
		//test 1 -> 3
		reponse.add(1); reponse.add(2); reponse.add(3);
		assertTrue(reponse.equals(a2.resoudre(g,1,3,list2)));
		reponse.clear();
		
		//Exercice trouvé sur internet
		g = new GrapheLA(6);
		g.ajouterArc(1,2,8);
		g.ajouterArc(1,5,3);	
		g.ajouterArc(2,1,7);
		g.ajouterArc(2,6,10);
		g.ajouterArc(2,3,7);
		g.ajouterArc(3,2,6);
		g.ajouterArc(3,4,3);	
		g.ajouterArc(4,1,12);
		g.ajouterArc(4,6,3);		
		g.ajouterArc(5,2,6);
		g.ajouterArc(5,4,11);
		g.ajouterArc(6,5,11);
		g.ajouterArc(6,3,1);
		AlgoPlusCourt a3 = new PCCDijkstra();
		ArrayList<Integer> list3 = new ArrayList<>();
		//test 1 -> 6
		reponse.add(1); reponse.add(5); reponse.add(4); reponse.add(6);
		assertTrue(reponse.equals(a3.resoudre(g,1,6,list3)));
		reponse.clear();
		//test 1 -> 5
		reponse.add(1); reponse.add(5);
		assertTrue(reponse.equals(a3.resoudre(g,1,5,list3)));
		reponse.clear();
		//test 2 -> 3
		reponse.add(2); reponse.add(3);
		assertTrue(reponse.equals(a3.resoudre(g,2,3,list3)));
		reponse.clear();
	}
	
	@Test
	void estOkTest() {
		
		IGraphe g = new GrapheMA(8);
		
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
		AlgoPlusCourt a = new PCCDijkstra();
		ArrayList<Integer> list1 = new ArrayList<>();
		assertThrows(ArcNegatifNulException.class, () -> a.resoudre(g,1,3,list1));
						
		/*IGraph g2 = new GrapheMA(9);
		g2.ajouterArc(1,4,1);
		g2.ajouterArc(1,3,2);
		g2.ajouterArc(2,7,3);
		g2.ajouterArc(3,8,2);
		g2.ajouterArc(4,2,3);
		g2.ajouterArc(4,5,3);
		g2.ajouterArc(4,3,5);
		g2.ajouterArc(5,7,3);
		g2.ajouterArc(5,8,7);
		g2.ajouterArc(5,3,1);
		g2.ajouterArc(7,2,2);
		g2.ajouterArc(7,6,1);
		g2.ajouterArc(8,7,2);
		g2.ajouterArc(8,6,4);
		g2.ajouterArc(9,8,10);
		assertThrows(NoPathEx.class, () -> graphe.PCCDijkstra.resoudre(g2,1,9));
}
*/

}

