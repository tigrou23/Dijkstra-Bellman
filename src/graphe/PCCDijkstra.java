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
		
		// /!\ mon code est vraiment basé sur le tableau qu'on a pu faire pour résoudre Djikstra
		
		// TODO : faire des méthodes privates pour alléger la méthode.
		// TODO : faire des tests
		
		int poids = 0, tmp = 0, debutStatic = debut;
		ArrayList<Integer> chemin = new ArrayList<>(); //va recevoir le chemin final pour accèder de début à fin
		ArrayList<Arc> listeArc = new ArrayList<Arc>(); //va nous servir à récupérer une liste avec tous les arcs d'un sommet
		HashMap<Integer, Integer> tabPoids = new HashMap<>(); //clé : un sommet --- valeur : le cout pour arriver à se sommet
		HashMap<Integer, Integer> tabPredecesseur = new HashMap<>(); //clé : un sommet --- valeur : le prédecesseur pour y arriver
		
		for (int i = 0; i < graphe.getNbNoeuds(); i++) //on initialise tous les couts pour arriver aux arcs à -1 (je simule le +infini du tableau)
			tabPoids.put(i, -1);
		
		tabPoids.put(debut - 1, 0);//on met le sommet de départ à 0 (comme dans le tableau)
		
		debut -= 1;//ça simplifie pour utiliser comme index dans les tableaux
		while (debut + 1 != fin) {
			tabPoids.put(debut, 0); //on met le sommet qu'on vient d'entourer à 0 pour pas qu'il soit pris dans nos calculs. Je ne pouvais pas le supprimer de la Hashmap car ça faussait les boucles (qui se basent sur le nombre de sommets dans la Hashmap)
			listeArc = graphe.getArcSommet(debut + 1); //on récupère tous les arcs qui partent de notre sommet qu'on vient d'entourer
			for (int i = 0; i < listeArc.size() - 1; i++) { // c'est juste un algo qui trie tous les arcs par leur poids. 
				while (listeArc.get(i).getPoids() > listeArc.get(i + 1).getPoids()) {
					Collections.swap(listeArc, i, i + 1);
					i = 0;
				}
			}
			tmp = 0;
			for (int i = 0; i < graphe.getNbNoeuds(); i++) { 
				if (listeArc.contains(graphe.getArc(debut + 1, i + 1))) { // on regarde si l'arc qu'on crée avec la boucle est un arc qui part du sommet (c-a-d qu'il se trouve dans l'ArrayList des arcs du sommet)
					if (tabPoids.get(i) == -1 && tabPoids.get(i) != 0) { // si il y a un + infini dans la case (-1) et que ce n'est pas égal à 0 (ça voudrait dire que le sommet est barré) alors on met comme valeur le poids (cf. ligne 68)
						tabPoids.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1,
								poids + graphe.getArc(debut + 1, i + 1).getPoids()); // on ajoute donc le poids + le poids de l'arc.
						tabPredecesseur.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1, debut); // on marque le sommet précédent pour retrouver le chemin après
					}
					if (poids + listeArc.get(tmp).getPoids() < tabPoids.get(i) && tabPoids.get(i) != 0) { // si il y a déjà une valeur dans la case. On vérifié que si on additionne le poids avec le poid de l'arc c'est plus petit que la valeur de la case. Si c'est plus petit on remplace la valeur et on remplace le sommet précédent par le nouveau
						tabPoids.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1,
								poids + graphe.getArc(debut + 1, i + 1).getPoids());
						tabPredecesseur.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1, debut);
					}
					tmp += 1; //le tmp sert à regarder dans un ordre croissant les arcs dans la liste d'arc. Par exemple, on va regarder le plus petit (à l'indice 0) mais si cet arc n'est pas utilisable (par exemple parce que B est entouré (=0)) bah on va augmenter le compteur pour voir à 1, etc...
				}
			}
			
			//Cette liste va récupérer tous les poids d'une ligne pour enlever tous les cases de la ligne inutilisables (celles qui sont à 0 ou -1)
			ArrayList<Integer> tmp2 = new ArrayList<>(); //faudra qu'on la déclare en haut et qu'on supprime son contenu mais j'ai pas le temps je dois partir.
			tmp2.addAll(tabPoids.values());
			
			for (int i = 0; i < tabPoids.size(); i++) { //ici on supprime tous les -1 et 0. Alors je savais pas mais pour supprimer dans une liste c'est juste un enfer (à cause des index). Donc faudra voir comme on peut améliorer ça mais sur internet j'ai rien trouvé
				tmp2.remove(new Integer(0));
				tmp2.remove(new Integer(-1));
			}
			for (int i = 0; i < graphe.getNbNoeuds(); i++) {
				if (tabPoids.get(i) == Collections.min(tmp2)) { //on cherche à quel sommet appartient le plus petit poids de la ligne
					debut = i; //une fois trouvé, on remplace debut par le sommet (i)
					break;
				}
			}
			poids = tabPoids.get(debut); //on ajoute au poids la valeur du sommet qu'on vient de choisir (celui qu'on entoure parce qu'il a la plus petite valeur)
		}
		
		//c'est ici qu'on se sert du tableau des prédécesseurs. On va remonter tout le tableau... Jvous jure ça marche.
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
