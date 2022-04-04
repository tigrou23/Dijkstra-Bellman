package graphe;

public interface IGraph {
	
	void ajouterArc(int n1, int n2);
	
	int getNbNoeuds();

	boolean aArc(int n1, int n2);

	int dOut(int n);
				
	int dIn(int n);

	String toString();

}
