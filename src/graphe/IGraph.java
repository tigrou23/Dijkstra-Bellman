package graphe;

import java.util.ArrayList;

public interface IGraph {
	
	void ajouterArc(int n1, int n2, int poids);
	
	int getNbNoeuds();

	boolean aArc(int n1, int n2);

	Arc getArc(int n1, int n2);

	int dOut(int n);
				
	int dIn(int n);

	String toString();
	
	ArrayList<Arc> getArcSommet(int s);

}
