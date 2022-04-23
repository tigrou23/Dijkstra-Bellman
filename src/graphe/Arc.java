package graphe;

public class Arc {
	
	private Sommet sommet1;
	private Sommet sommet2;
	private int poids;
	
	public Arc(int s1, int s2, int p) {
		sommet1 = new Sommet(s1);
		sommet2 = new Sommet(s2);
		poids = p;
	}
	
	public Arc(String s1, String s2, int p) {
		sommet1 = new Sommet(s1);
		sommet2 = new Sommet(s2);
		poids = p;
	}
	
	public int getPoids() {
		return poids;
	}

	public Sommet getSommet1(){
		return sommet1;
	}

	public Sommet getSommet2(){
		return sommet2;
	}
	
	public String toString() {
		return sommet1 + " -> " + sommet2;
	}
}
