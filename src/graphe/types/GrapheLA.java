package graphe.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import graphe.Arc;
import graphe.IGraphe;

public class GrapheLA implements IGraphe{
	
	// Pour chaque noeuds (represente par un entier) une ArrayList d'entier (liste
	// de tous ses successeurs)
	private HashMap<Object, ArrayList<Object>> LA;

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
		//assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		Arc arcTMP = new Arc(n1, n2, poids);
		arc.add(arcTMP);
		LA.get(arcTMP.getSommet1()).add(arcTMP.getSommet2());
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
		//assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		Arc arcTMP = new Arc(n1, 0, n2);
		if(LA.containsKey(arcTMP.getSommet1()))
			return LA.get(arcTMP.getSommet1()).contains(arcTMP.getSommet2());
		return false;
	}

	/**
	 * Methode qui permet de connaitre le nombre de successeurs pour un noeud donne
	 * 
	 * @param n le noeud
	 * @return nbdOut le nombre de sucesseurs
	 */
	public int dOut(int n) {
		//assert(n>0 && n<=nb_noeuds);
		if(LA.containsKey(n))
			return LA.get(n).size();
		return 0; 
	}
	
	/**
	 * Methode qui permet de connaitre le nombre de predecesseur pour un noeud
	 * donne
	 * 
	 * @param n le noeud
	 * @return nbdIn le nombre de predecesseur
	 */
	public int dIn(int n) {
		//assert(n>0 && n<=nb_noeuds);
		int nbdIn = 0;
		for (Entry<Object, ArrayList<Object>> entry : LA.entrySet()) {
			if (entry.getValue().contains(n))
				nbdIn++;
		}return nbdIn;
	}

	/**
	 * Methode toString qui represente pour chaque noeud sa liste de successeurs
	 * 
	 * @return sb la chaine de caractere
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<Object, ArrayList<Object>> entry : LA.entrySet()) {
			sb.append(entry.getKey());
			sb.append(" -> ");
			for (Object i : entry.getValue())
				sb.append(i + " ");
			sb.append("\n");
		}return sb.toString();
	}
	
	/**
	 * Mehode qui retourne l'arc entre deux sommets
	 * 
	 * @param s1 le sommet d'où part l'arc
	 * @param s2 le sommet où arrive l'arc
	 * @return l'arc en question
	 */
	public Arc getArc(int s1, int s2) {
		for ( int i = 0; i<arc.size(); i++){
			if (arc.get(i).getSommet1() == s1 && arc.get(i).getSommet2() == s2)
				return arc.get(i);
		}return null;
	}
	
	/**
	 * Mehode fournit un liste d'arcs qui arrivent au sommet s
	 * 
	 * @param s le sommet
	 * @return la liste d'arc
	 */
	public ArrayList<Arc> getArcPredecesseur(int s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for(int i = 0; i<arc.size() ; i++) {
			if(arc.get(i).getSommet2() == s)
				listArc.add(arc.get(i));
		
		}return listArc;
	}
	
	/**
	 * Mehode fournit un liste d'arcs qui partent du sommet s
	 * 
	 * @param s le sommet
	 * @return la liste d'arc
	 */
	public ArrayList<Arc> getArcSuccesseur(int s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for(int i = 0; i<arc.size() ; i++) {
			if(arc.get(i).getSommet1() == s)
				listArc.add(arc.get(i));
		}return listArc;
	}

	public ArrayList<Arc> getArc(){
		return arc;
	}

	@Override
	public int getNbSommets() {
		return nb_noeuds;
	}

	@Override
	public int distance(ArrayList<Integer> cheminCalcule) {
		int cpt=0;
		for(int i=0; i<cheminCalcule.size()-1;++i) {
			int j = i+1;
			cpt+= getArc(cheminCalcule.get(i),cheminCalcule.get(j)).getPoids();
		}
		return cpt;
	}

}
