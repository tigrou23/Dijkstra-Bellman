package appli;
import graphe.GrapheLA;

public class Appli {

	public static void main(String[] args) {
		final int NB_NOEUDS = 6;
		GrapheLA g = new GrapheLA(NB_NOEUDS);
		
		/*g.ajouterArc(1,2);
		g.ajouterArc(1,3);
		g.ajouterArc(1,4);
		g.ajouterArc(1,5);
		g.ajouterArc(2,5);
		g.ajouterArc(4,4);
		g.ajouterArc(5,1);*/
		System.out.println(g);
	}

}
