package graphe;

import java.util.List;

public interface AlgoPlusCourt {

	final int INFINI = Integer.MAX_VALUE;

	/**
	 * Verifie la validite d'un graphe suivant l'algorithme qui va etre utilise
	 * 
	 * @param graphe le graphe a etudier
	 * @param debut
	 * @param fin
	 */
	void estOk(IGraphe graphe, int debut, int fin);

	/**
	 * Verifie que le graphe ne comporte pas de cycle
	 * 
	 * @param graphe le graphe a etudier
	 */
	void cycle(IGraphe graphe);

	/**
	 * Methode qui va resoudre le probleme mathematiques, a savoir le chemin le plus
	 * court dans un graphe
	 * 
	 * @param g      le graphe a etudier
	 * @param debut  depart du chemin
	 * @param fin    arrivee du chemin
	 * @param chemin liste d'entiers qui va recuperer le chemin le plus court entre
	 *               debut et fin
	 * @return le cout du chemin
	 */
	int resoudre(IGraphe g, int debut, int fin, List<Integer> chemin);
}