package graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PCCDijkstra {

	private IGraph graphe;

	public PCCDijkstra(IGraph g) {
		graphe = g;
	}

	public ArrayList<Integer> resoudre(int debut, int fin) {
		
		// /!\ mon code est vraiment bas� sur le tableau qu'on a pu faire pour r�soudre Djikstra
		
		// TODO : faire des m�thodes privates pour all�ger la m�thode.
		// TODO : faire des tests
		
		int poids = 0, tmp = 0, debutStatic = debut;
		ArrayList<Integer> chemin = new ArrayList<>(); //va recevoir le chemin final pour acc�der de d�but � fin
		ArrayList<Arc> listeArc = new ArrayList<Arc>(); //va nous servir � r�cup�rer une liste avec tous les arcs d'un sommet
		HashMap<Integer, Integer> tabPoids = new HashMap<>(); //cl� : un sommet --- valeur : le cout pour arriver � se sommet
		HashMap<Integer, Integer> tabPredecesseur = new HashMap<>(); //cl� : un sommet --- valeur : le pr�decesseur pour y arriver
		
		for (int i = 0; i < graphe.getNbNoeuds(); i++) //on initialise tous les couts pour arriver aux arcs � -1 (je simule le +infini du tableau)
			tabPoids.put(i, -1);
		
		tabPoids.put(debut - 1, 0);//on met le sommet de d�part � 0 (comme dans le tableau)
		
		debut -= 1;//�a simplifie pour utiliser comme index dans les tableaux
		while (debut + 1 != fin) {
			tabPoids.put(debut, 0); //on met le sommet qu'on vient d'entourer � 0 pour pas qu'il soit pris dans nos calculs. Je ne pouvais pas le supprimer de la Hashmap car �a faussait les boucles (qui se basent sur le nombre de sommets dans la Hashmap)
			listeArc = graphe.getArcSommet(debut + 1); //on r�cup�re tous les arcs qui partent de notre sommet qu'on vient d'entourer
			for (int i = 0; i < listeArc.size() - 1; i++) { // c'est juste un algo qui trie tous les arcs par leur poids. 
				while (listeArc.get(i).getPoids() > listeArc.get(i + 1).getPoids()) {
					Collections.swap(listeArc, i, i + 1);
					i = 0;
				}
			}
			tmp = 0;
			for (int i = 0; i < graphe.getNbNoeuds(); i++) { 
				if (listeArc.contains(graphe.getArc(debut + 1, i + 1))) { // on regarde si l'arc qu'on cr�e avec la boucle est un arc qui part du sommet (c-a-d qu'il se trouve dans l'ArrayList des arcs du sommet)
					if (tabPoids.get(i) == -1 && tabPoids.get(i) != 0) { // si il y a un + infini dans la case (-1) et que ce n'est pas �gal � 0 (�a voudrait dire que le sommet est barr�) alors on met comme valeur le poids (cf. ligne 68)
						tabPoids.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1,
								poids + graphe.getArc(debut + 1, i + 1).getPoids()); // on ajoute donc le poids + le poids de l'arc.
						tabPredecesseur.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1, debut); // on marque le sommet pr�c�dent pour retrouver le chemin apr�s
					}
					if (poids + listeArc.get(tmp).getPoids() < tabPoids.get(i) && tabPoids.get(i) != 0) { // si il y a d�j� une valeur dans la case. On v�rifi� que si on additionne le poids avec le poid de l'arc c'est plus petit que la valeur de la case. Si c'est plus petit on remplace la valeur et on remplace le sommet pr�c�dent par le nouveau
						tabPoids.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1,
								poids + graphe.getArc(debut + 1, i + 1).getPoids());
						tabPredecesseur.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1, debut);
					}
					tmp += 1; //le tmp sert � regarder dans un ordre croissant les arcs dans la liste d'arc. Par exemple, on va regarder le plus petit (� l'indice 0) mais si cet arc n'est pas utilisable (par exemple parce que B est entour� (=0)) bah on va augmenter le compteur pour voir � 1, etc...
				}
			}
			
			//Cette liste va r�cup�rer tous les poids d'une ligne pour enlever tous les cases de la ligne inutilisables (celles qui sont � 0 ou -1)
			ArrayList<Integer> tmp2 = new ArrayList<>(); //faudra qu'on la d�clare en haut et qu'on supprime son contenu mais j'ai pas le temps je dois partir.
			tmp2.addAll(tabPoids.values());
			
			for (int i = 0; i < tabPoids.size(); i++) { //ici on supprime tous les -1 et 0. Alors je savais pas mais pour supprimer dans une liste c'est juste un enfer (� cause des index). Donc faudra voir comme on peut am�liorer �a mais sur internet j'ai rien trouv�
				tmp2.remove(new Integer(0));
				tmp2.remove(new Integer(-1));
			}
			for (int i = 0; i < graphe.getNbNoeuds(); i++) {
				if (tabPoids.get(i) == Collections.min(tmp2)) { //on cherche � quel sommet appartient le plus petit poids de la ligne
					debut = i; //une fois trouv�, on remplace debut par le sommet (i)
					break;
				}
			}
			poids = tabPoids.get(debut); //on ajoute au poids la valeur du sommet qu'on vient de choisir (celui qu'on entoure parce qu'il a la plus petite valeur)
		}
		
		//c'est ici qu'on se sert du tableau des pr�d�cesseurs. On va remonter tout le tableau... Jvous jure �a marche.
		int temporaire = fin - 1;
		chemin.add(temporaire + 1);
		while (temporaire + 1 != debutStatic) {
			temporaire = tabPredecesseur.get(temporaire);
			chemin.add(temporaire + 1);
		}
		Collections.reverse(chemin); //explicite
		
		//juste pour afficher (pour mes tests perso)
		for (int i = 0; i < chemin.size(); i++) {
			System.out.print(chemin.get(i) + " ");
		}
		
		return chemin;
	}
}
