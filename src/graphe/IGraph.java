package graphe;

public interface IGraph {
	
	public void ajouterArc(int n1, int n2);
	
	public int getNbNoeuds();

	public boolean aArc(int n1, int n2);

	public int dOut(int n);
				
	public int dIn(int n);

	public String toString();

}
