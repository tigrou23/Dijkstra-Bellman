package graphe;

import java.util.ArrayList;

public interface IGraph {

	void ajouterArc(int n1, int n2, int poids);
	
	int getNbNoeuds();

	boolean aArc(int n1, int n2);
		
	int dOut(int n);
				
	int dIn(int n);
	
	String toString();
	
	Arc getArc(int s1, int s2);

	ArrayList<Arc> getArcPredecesseur(int s);
	
	ArrayList<Arc> getArcSuccesseur(int s);

}
