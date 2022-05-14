package graphe;

import java.util.ArrayList;

public interface IGraphe {

	/**
	 * ajout d'un arc au graphe
	 * 
	 * @param n1    le sommet de depart de l'arc
	 * @param n2    le sommet d'arrivee de l'arc
	 * @param poids le poids de l'arc
	 */
	void ajouterArc(int n1, int n2, int poids);

	/**
	 * Methode qui permet de connaitre le nombre de sommets que comporte le graphe
	 * 
	 * @return le nombre de sommets
	 */
	int getNbNoeuds();

	/**
	 * 
	 * @param n1 le sommet de depart de l'arc
	 * @param n2 le sommet d'arrivee de l'arc
	 * @return true si le graphe a l'arc
	 * @return false si le graphe n'a pas l'arc
	 */
	boolean aArc(int n1, int n2);

	/**
	 * Methode qui permet de connaitre le nombre d'arcs sortant du sommet
	 * 
	 * @param n le sommet en question
	 * @return le nombre de successeurs
	 */
	int dOut(int n);

	/**
	 * Methode qui permet de connaitre le nombre d'arcs entrant du sommet
	 * 
	 * @param n le sommet en question
	 * @return le nombre de predecesseurs
	 */
	int dIn(int n);

	/**
	 * Methode qui sert a representer le graphe
	 * 
	 * @return la chaine de caracteres du graphe
	 */
	String toString();

	/**
	 * recuperation d'un arc du graphe
	 * 
	 * @param s1 le sommet de depart de l'arc
	 * @param s2 le sommet de d'arrivee de l'arc
	 * @return l'arc en question
	 */
	Arc getArc(int s1, int s2);

	/**
	 * Mehode fournit un liste d'arc(s) qui arrivent du sommet s
	 * 
	 * @param s le sommet
	 * @return la liste d'arc(s)
	 */
	ArrayList<Arc> getArcPredecesseur(int s);

	/**
	 * Mehode fournit un liste d'arc(s) qui partent du sommet s
	 * 
	 * @param s le sommet
	 * @return la liste d'arc(s)
	 */
	ArrayList<Arc> getArcSuccesseur(int s);

	/**
	 * Methode qui permet de recuperer l'integralite des arcs d'un graphe
	 * 
	 * @return la liste d'arcs
	 */
	public ArrayList<Arc> getArc();

	/**
	 * Methode qui calcule le cout d'un chemin du graphe
	 * 
	 * @param cheminCalcule le chemin sur lequel on va calculer le cout
	 * @return le cout pour parcourir le chemin
	 */
	int distance(ArrayList<Integer> cheminCalcule);

}
