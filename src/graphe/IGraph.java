package graphe;

import java.util.ArrayList;

public interface IGraph {

	void ajouterArc(int n1, int n2, int poids);
	
	void ajouterArc(String n1, String n2, int poids);

	int getNbNoeuds();

	boolean aArc(int n1, int n2);
	
	boolean aArc(String n1, String n2);

	int dOut(String n);
	
	int dOut(int n);
				
	int dIn(int n);
	
	int dIn(String n);

	String toString();
	
	Arc getArc(Sommet s1, Sommet s2);

	ArrayList<Arc> getArcPredecesseur(Sommet s);
	
	ArrayList<Arc> getArcSuccesseur(Sommet s);

}
