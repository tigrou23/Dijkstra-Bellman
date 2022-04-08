package appli;
import graphe.GrapheLA;
import graphe.GrapheMA;
import graphe.IGraph;
import graphe.PCCDijkstra;

public class Appli{

	public static void main(String[] args){
		final int NB_NOEUDS = 5;
		//GrapheLA g = new GrapheLA(NB_NOEUDS);
		
		/*g.ajouterArc(1,2);
		g.ajouterArc(1,3);
		g.ajouterArc(1,4);
		g.ajouterArc(1,5);
		g.ajouterArc(2,5);
		g.ajouterArc(4,4);
		g.ajouterArc(5,1);*/
		
		
		/*g.ajouterArc(1,3,7);
		g.ajouterArc(1,4,15);
		g.ajouterArc(2,4,21);
		g.ajouterArc(3,2,13);
		g.ajouterArc(3,5,3);
		g.ajouterArc(5,1,1);
		g.ajouterArc(5,2,9);
		g.ajouterArc(5,4,17);
		
		PCCDijkstra p = new PCCDijkstra(g);
		if(p.estOk())p.resoudre(1,5);*/
		
		IGraph g = new GrapheMA(9);
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
		
		PCCDijkstra.resoudre(g,9,8);
				
	}

}
