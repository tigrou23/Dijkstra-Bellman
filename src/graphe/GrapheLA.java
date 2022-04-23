package graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GrapheLA implements IGraph{
	
	// Pour chaque noeuds (represente par un entier) une ArrayList d'entier (liste
	// de tous ses successeurs)
	private HashMap<Object, ArrayList<Object>> LA;

	private Boolean isStr;
	
    private static final int NUM = 31;

	// ArrayList d'arcs qui stocke tous les arcs du graphes 
	private ArrayList<Arc> arc;
	
	// Le nombre de noeuds du graphe
	private int nb_noeuds;
	
	private int positions(Object str)
    {

		return (((String) str).charAt(0) & NUM);
        
    }
 
	private String lettre(Object o) {
		int i = (int) o;
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}

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
			Sommet s = new Sommet(i);
			LA.put(s.getSommet(), new ArrayList<>());
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
		LA.get(arcTMP.getSommet1().getSommet()).add(arcTMP.getSommet2().getSommet());
		isStr = false;
	}
	
	public void ajouterArc(String n1, String n2, int poids) {
		//assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		Arc arcTMP = new Arc(n1, n2, poids);
		arc.add(arcTMP);
		LA.get(positions(arcTMP.getSommet1().getSommet())).add(positions(arcTMP.getSommet2().getSommet()));
		isStr = true;
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
		Arc arcTMP = new Arc(n1, n2, 0);
		if(LA.containsKey(arcTMP.getSommet1().getSommet()))
			return LA.get(arcTMP.getSommet1().getSommet()).contains(arcTMP.getSommet2().getSommet());
		else
			return false;
	}

	public boolean aArc(String n1, String n2) {
		//assert(n1>0 && n1<=nb_noeuds && n2>0 && n2<=nb_noeuds);
		Arc arcTMP = new Arc(n1, n2, 0);
		if(LA.containsKey(positions(arcTMP.getSommet1().getSommet())))
			return LA.get(positions(arcTMP.getSommet1().getSommet())).contains(positions(arcTMP.getSommet2().getSommet()));
		else
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
		Sommet s = new Sommet(n);
		if(LA.containsKey(s.getSommet()))
			return LA.get(s.getSommet()).size();
		else
			return 0; 
	}
	
	public int dOut(String n) {
		//assert(n>0 && n<=nb_noeuds);
		Sommet s = new Sommet(n);
		if(LA.containsKey(positions(s.getSommet())))
			return LA.get(positions(s.getSommet())).size();
		else
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
		}
		return nbdIn;
	}
	
	public int dIn(String n) {
		//assert(n>0 && n<=nb_noeuds);
		int nbdIn = 0;
		for (Entry<Object, ArrayList<Object>> entry : LA.entrySet()) {
			if (entry.getValue().contains(positions(n)))
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
		if(!isStr) {
			for (Entry<Object, ArrayList<Object>> entry : LA.entrySet()) {
				sb.append(entry.getKey());
				sb.append(" -> ");
				for (Object i : entry.getValue())
					sb.append(i + " ");
				sb.append("\n");
			}
		}
		else {
			for (Entry<Object, ArrayList<Object>> entry : LA.entrySet()) {
				sb.append(lettre(entry.getKey()));
				sb.append(" -> ");
				for (Object i : entry.getValue())
					sb.append(lettre(i) + " ");
				sb.append("\n");
			}
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
