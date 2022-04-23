package appli;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import graphe.GrapheLA;
import graphe.GrapheMA;
import graphe.IGraph;
import graphe.PCCDijkstra;

public class Appli{

	public static void main(String[] args){
		
		GrapheLA g = new GrapheLA(6);
		g.ajouterArc(1, 2, 0);
		g.ajouterArc(1, 3, 0);
		g.ajouterArc(1, 4, 0);
		g.ajouterArc(1, 5, 0);
		g.ajouterArc(2, 5, 0);
		g.ajouterArc(4, 4, 0);
		g.ajouterArc(5, 1, 0);

		
	}
}
