package graphe;
public class GrapheMA {

	// Double tableau de booleens qui represente la matrice adjacente du graphe
	private boolean[][] MA;

	// Le nombre de noeuds du graphe
	private int nb_noeuds;

	/**
	 * Creation d'un graphe en fonction d'un nombre de noeuds
	 * 
	 * @param nb_noeuds le nombre de noeuds
	 */
	public GrapheMA(int nb_noeuds) {
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
	public void ajouterArc(int n1, int n2) {
		assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		MA[n1 - 1][n2 - 1] = true;
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
}
