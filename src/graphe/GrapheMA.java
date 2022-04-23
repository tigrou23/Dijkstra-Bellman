package graphe;

import java.util.ArrayList;

public class GrapheMA implements IGraph{

	// Double tableau de booleens qui represente la matrice adjacente du graphe
	private boolean[][] MA;
    
	private static final int NUM = 31;

	// ArrayList d'arcs qui stocke tous les arcs du graphes 
	private ArrayList<Arc> arc;

	// Le nombre de noeuds du graphe
	private int nb_noeuds;

	/**
	 * Creation d'un graphe en fonction d'un nombre de noeuds
	 * 
	 * @param nb_noeuds le nombre de noeuds
	 */
	
	private int positions(Object str)
    {

		return (((String) str).charAt(0) & NUM);
        
    }
 
	private String lettre(Object o) {
		int i = (int) o;
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
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
		//assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		Arc arcTMP = new Arc(n1, n2, poids);
		MA[n1 - 1][n2 - 1] = true;
		arc.add(arcTMP);
	}
	
	public void ajouterArc(String n1, String n2, int poids) {
		//assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		Arc arcTMP = new Arc(n1, n2, poids);
		MA[positions(arcTMP.getSommet1().getSommet()) - 1][positions(arcTMP.getSommet2().getSommet()) - 1] = true;
		arc.add(arcTMP);
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
	
	public boolean aArc(String n1, String n2) {
		//assert(n1>0 && n1<=nb_noeuds && n2>=0 && n2<=nb_noeuds);
		Arc arcTMP = new Arc(n1, n2, 0);
		return MA[positions(arcTMP.getSommet1().getSommet()) - 1][positions(arcTMP.getSommet2().getSommet()) - 1];
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
	
	public int dOut(String n) {
		//assert(n>0 && n<=nb_noeuds);
		Arc arcTMP = new Arc(n, "A", 0);
		int nbdOut = 0;
		for (int i = 0; i < nb_noeuds; ++i) {
			if (MA[positions(arcTMP.getSommet1().getSommet()) - 1][i])
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
	
	public int dIn(String n) {
		//assert(n>0 && n<=nb_noeuds);
		Arc arcTMP = new Arc(n, "A", 0);
		int nbdIn = 0;
		for (int i = 0; i < nb_noeuds; ++i) {
			if (MA[i][positions(arcTMP.getSommet1().getSommet()) - 1])
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

	/**
	 * Mehode qui retourne l'arc entre deux sommets
	 * 
	 * @param s1 le sommet d'où part l'arc
	 * @param s2 le sommet où arrive l'arc
	 * @return l'arc en question
	 */
	public Arc getArc(Sommet s1, Sommet s2) {
		for ( int i = 0; i<arc.size(); i++){
			
			if (arc.get(i).getSommet1().getSommet() == s1.getSommet() && arc.get(i).getSommet2().getSommet() == s2.getSommet()){
				return arc.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Mehode fournit un liste d'arcs qui arrivent au sommet s
	 * 
	 * @param s le sommet
	 * @return la liste d'arc
	 */
	public ArrayList<Arc> getArcPredecesseur(Sommet s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for(int i = 0; i<arc.size() ; i++) {
			if(arc.get(i).getSommet2().getSommet() == s.getSommet()){
				listArc.add(arc.get(i));
			}	
		}
		return listArc;
	}
	
	/**
	 * Mehode fournit un liste d'arcs qui partent du sommet s
	 * 
	 * @param s le sommet
	 * @return la liste d'arc
	 */
	public ArrayList<Arc> getArcSuccesseur(Sommet s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for(int i = 0; i<arc.size() ; i++) {
			if(arc.get(i).getSommet1().getSommet() == s.getSommet()){
				listArc.add(arc.get(i));
			}	
		}return listArc;
	}
	
}
