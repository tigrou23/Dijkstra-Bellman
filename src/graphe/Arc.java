package graphe;

public class Arc {

	private int sommet1;
	private int sommet2;
	private int poids;

	public Arc(int s1, int p, int s2) {
		sommet1 = s1;
		sommet2 = s2;
		poids = p;
	}

	public Arc() {
		this(0, 0, 0);
	}

	public int getPoids() {
		return poids;
	}

	public int getSommet1() {
		return sommet1;
	}

	public int getSommet2() {
		return sommet2;
	}

	public String toString() {
		return sommet1 + " -> " + sommet2;
	}

	public void set(Arc a) {
		sommet1 = a.getSommet1();
		sommet2 = a.getSommet2();
		poids = a.getPoids();
	}
}
