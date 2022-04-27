package appli;

import static org.junit.Assert.assertThrows;

import exception.CircuitEx;
import graphe.GrapheMA;
import graphe.IGraphe;

public class Appli{

	public static void main(String[] args){
		
		IGraphe g = new GrapheMA(4);
		g.ajouterArc(1,2,5);
		g.ajouterArc(1,3,4);
		g.ajouterArc(3,2,6);
		g.ajouterArc(2,4,3);
		g.ajouterArc(4,3,2);
		graphe.PCCBellman.resoudre(g,1,3);
	}
}
