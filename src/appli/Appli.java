package appli;
import graphe.GrapheLA;
import graphe.IGraph;
import graphe.PCCDijkstra;

public class Appli {

	public static void main(String[] args) {
		final int NB_NOEUDS = 5;
		//GrapheLA g = new GrapheLA(NB_NOEUDS);
		
		/*g.ajouterArc(1,2);
		g.ajouterArc(1,3);
		g.ajouterArc(1,4);
		g.ajouterArc(1,5);
		g.ajouterArc(2,5);
		g.ajouterArc(4,4);
		g.ajouterArc(5,1);*/
		
		//tests à partir du 3.2
		IGraph g = new GrapheLA(5);
		g.ajouterArc(1,3,7);
		g.ajouterArc(1,4,15);
		g.ajouterArc(2,4,21);
		g.ajouterArc(3,2,13);
		g.ajouterArc(3,5,3);
		g.ajouterArc(5,1,1);
		g.ajouterArc(5,2,9);
		g.ajouterArc(5,4,17);
		
		PCCDijkstra p = new PCCDijkstra(g);
		if(p.estOk())p.resoudre(1,2);
				
	}

}
