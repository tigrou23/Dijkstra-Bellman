package graphe;

public class Arc {
	
	private int sommet1;
	private int sommet2;
	private int poids;
	
	public Arc(int s1, int s2, int p) {
		sommet1 = s1;
		sommet2 = s2;
		poids = p;
	}
	
	public Arc(int s1, int s2) {
		this(s1, s2, 0);
	}
	
	public int getPoids() {
		return poids;
	}
}
