package graphe;

import java.util.ArrayList;

public class GrapheMA implements IGraph{

	// Double tableau de booleens qui represente la matrice adjacente du graphe
	private boolean[][] MA;
	
	// ArrayList d'arcs qui stocke tous les arcs du graphes 
	private ArrayList<Arc> arc;

	// Le nombre de noeuds du graphe
	private int nb_noeuds;

	/**
	 * Creation d'un graphe en fonction d'un nombre de noeuds
	 * 
	 * @param nb_noeuds le nombre de noeuds
	 */
	public GrapheMA(int nb_noeuds) {
		arc = new ArrayList<>();
		MA = new boolean[nb_noeuds][nb_noeuds];
		this.nb_noeuds = nb_noeuds;
		for (int i = 0; i < nb_noeuds; ++i) {
			for (int j = 0; j < nb_noeuds; ++j) {
				MA[i][j] = false;
			}
		}
	}

	/**
	 * Creation d'un arc d'un noeud n1 a un noeud n2
	 * 
	 * @param n1 le noeud n1
	 * @param n2 le noeud n2
	 */
	public void ajouterArc(int n1, int n2, int poids) {
		assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		MA[n1 - 1][n2 - 1] = true;
		arc.add(new Arc(n1, n2, poids));
	}

	/**
	 * Getter qui retourne le nombre de noeuds du graphe
	 * 
	 * @return nb_noeuds le nombre de noeuds
	 */
	public int getNbNoeuds() {
		return nb_noeuds;
	}

	/**
	 * Methode qui retourne si un arc existe entre un noeud n1 et un noeud n2
	 * 
	 * @param n1 le noeud n1
	 * @param n2 le noeud n2
	 * @return true si l'arc existe
	 */
	public boolean aArc(int n1, int n2) {
		assert(n1>0 && n1<=nb_noeuds && n2>=0 && n2<=nb_noeuds);
		return MA[n1 - 1][n2 - 1];
	}


	/**
	 * Methode qui permet de connaitre le nombre de successeurs pour un noeud donne
	 * 
	 * @param n le noeud
	 * @return nbdOut le nombre de sucesseurs
	 */
	public int dOut(int n) {
		assert(n>0 && n<=nb_noeuds);
		int nbdOut = 0;
		for (int i = 0; i < nb_noeuds; ++i) {
			if (MA[n - 1][i])
				nbdOut++;
		}
		return nbdOut;
	}

	/**
	 * Methode qui permet de connaitre le nombre de predecesseur pour un noeud
	 * donne
	 * 
	 * @param n le noeud
	 * @return nbdOut le nombre de predecesseur
	 */
	public int dIn(int n) {
		assert(n>0 && n<=nb_noeuds);
		int nbdIn = 0;
		for (int i = 0; i < nb_noeuds; ++i) {
			if (MA[i][n - 1])
				nbdIn++;
		}
		return nbdIn;
	}

	/**
	 * Methode qui retourne une chaine de caracteres qui represente la matrice
	 * adjacente du graphe
	 * 
	 * @return s la chaine de caractere
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nb_noeuds; ++i) {
			for (int j = 0; j < nb_noeuds; ++j) {
				if (MA[i][j])
					sb.append("1 ");
				else
					sb.append("0 ");

			}
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public Arc getArc(int s1, int s2) {
		for ( int i = 0; i<arc.size()-1; i++){
			if (arc.get(i).getSommet1() == s1 && arc.get(i).getSommet1() == s2){
				return arc.get(i);
			}
		}
		return null;
	}
	
	//test
	public ArrayList<Arc> getArcSommet(int s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for(int i = 0; i<arc.size()-1 ; i++) {
			if(arc.get(i).getSommet1() == s){
				listArc.add(arc.get(i));
			}	
		}return listArc;
	}
}
