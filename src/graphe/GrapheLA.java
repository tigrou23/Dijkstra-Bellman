package graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrapheLA implements IGraph{
	
	// Pour chaque noeuds (represente par un entier) une ArrayList d'entier (liste
	// de tous ses successeurs)
	private HashMap<Integer, ArrayList<Integer>> LA;

	// ArrayList d'arcs qui stocke tous les arcs du graphes 
	private ArrayList<Arc> arc;
	
	// Le nombre de noeuds du graphe
	private int nb_noeuds;

	/**
	 * Creation d'un graphe en fonction d'un nombre de noeuds
	 * 
	 * @param nb_noeuds le nombre de noeuds
	 */
	public GrapheLA(int nb_noeuds) {
		arc = new ArrayList<>();
		LA = new HashMap<>(nb_noeuds);
		this.nb_noeuds = nb_noeuds;
		for (int i = 1; i <= nb_noeuds; ++i) {
			LA.put(i, new ArrayList<>());
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
		arc.add(new Arc(n1, n2, poids));
		
		LA.get(n1).add(n2);
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
		assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		return LA.get(n1).contains(n2);
	}

	/**
	 * Methode qui permet de connaitre le nombre de successeurs pour un noeud donne
	 * 
	 * @param n le noeud
	 * @return nbdOut le nombre de sucesseurs
	 */
	public int dOut(int n) {
		assert(n>0 && n<=nb_noeuds);
		return LA.get(n).size();
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
		for (Map.Entry<Integer, ArrayList<Integer>> entry : LA.entrySet()) {
			if (entry.getValue().contains(n))
				nbdIn++;
		}
		return nbdIn;
	}

	/**
	 * Methode toString qui represente pour chaque noeud sa liste de successeurs
	 * 
	 * @return sb la chaine de caractere
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, ArrayList<Integer>> entry : LA.entrySet()) {
			sb.append(entry.getKey());
			sb.append(" -> ");
			for (Integer i : entry.getValue())
				sb.append(i + " ");
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public Arc getArc(int s1, int s2) {
		for ( int i = 0; i<arc.size(); i++){
			
			if (arc.get(i).getSommet1() == s1 && arc.get(i).getSommet2() == s2){
				
				return arc.get(i);
			}
		}
		return null;
	}
	
	//test
	public ArrayList<Arc> getArcSommet(int s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for(int i = 0; i<arc.size() ; i++) {
			if(arc.get(i).getSommet1() == s){
				listArc.add(arc.get(i));
			}	
		}return listArc;
	}


}
