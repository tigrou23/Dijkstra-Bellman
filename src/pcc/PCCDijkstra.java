package pcc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import exception.ArcNegatifNulException;
import exception.NoPathEx;
import graphe.AlgoPlusCourt;
import graphe.Arc;
import graphe.IGraphe;

public class PCCDijkstra implements AlgoPlusCourt {

	public void estOk(IGraphe graphe, int debut, int fin) throws ArcNegatifNulException, NoPathEx {

		ArrayList<Arc> test = new ArrayList<>();
		for (int i = 0; i < graphe.getNbNoeuds(); i++) {
			test = graphe.getArcSuccesseur(i + 1);
			for (int j = 0; j < test.size(); j++) {
				if (test.get(j).getPoids() <= 0)
					throw new ArcNegatifNulException();
			}
		}
		test.clear();

		ArrayList<Integer> cheminD = new ArrayList<>();
		ArrayList<Integer> tmpD = new ArrayList<>();
		ArrayList<Integer> passe = new ArrayList<>();
		cheminD.add(debut);
		Boolean good = false;
		while (!cheminD.isEmpty()) {
			tmpD.clear();
			Iterator<Integer> chD = cheminD.iterator();
			while (chD.hasNext()) {
				int itD = chD.next();
				chD.remove();
				passe.add(itD);
				for (Arc a : graphe.getArcSuccesseur(itD))
					if (!cheminD.contains(a.getSommet2()) && !tmpD.contains(a.getSommet2())
							&& !passe.contains(a.getSommet2()))
						tmpD.add(a.getSommet2());
			}
			cheminD.addAll(tmpD);
			if (cheminD.contains(fin)) {
				good = true;
				break;
			}
		}
		if (Boolean.FALSE.equals(good))
			throw new NoPathEx();
	}

	public int resoudre(IGraphe graphe, int debut, int fin, List<Integer> chemin) {

		if(debut == fin) {
			chemin.add(debut);
			return 0;
		}
		
		// /!\ mon code est vraiment basé sur le tableau qu'on a pu faire pour résoudre
		// en cours de maths

		estOk(graphe, debut, fin);
		
		int poids = 0;
		int debutStatic = debut;
		int somme;
		ArrayList<Arc> listeArc = new ArrayList<Arc>(); // va nous servir à récupérer une liste avec tous les arcs d'un
														// sommet
		ArrayList<Integer> tmp = new ArrayList<>();// Cette liste va récupérer tous les poids d'une ligne pour enlever
													// tous les cases de la ligne inutilisables (celles qui sont à 0 ou
													// -1)
		HashMap<Integer, Integer> tabPoids = new HashMap<>(); // clé : un sommet --- valeur : le cout pour arriver à se
																// sommet
		HashMap<Integer, Integer> tabPredecesseur = new HashMap<>(); // clé : un sommet --- valeur : le prédecesseur
																		// pour y arriver
		for (int i = 0; i < graphe.getNbNoeuds(); i++) // on initialise tous les couts pour arriver aux arcs à -1 (je
														// simule l+infini du tableau)
			tabPoids.put(i, -1);
		tabPoids.put(debut - 1, 0);// on met le sommet de départ à 0 (comme dans le tableau)
		debut -= 1;// ça simplifie pour utiliser comme index dans les tableaux
		while (debut + 1 != fin) {
			tabPoids.put(debut, 0); // on met le sommet qu'on vient d'entourer à 0 pour pas qu'il soit pris dans nos
									// calculs. Je ne pouvais pas le supprimer de la Hashmap car ça faussait les
									// boucles (qui se basent sur le nombre de sommets dans la Hashmap)
			listeArc = graphe.getArcSuccesseur(debut + 1); // on récupère tous les arcs qui partent de notre sommet
															// qu'on vient d'entourer
			for (int i = 0; i < graphe.getNbNoeuds(); i++) {
				if (listeArc.contains(graphe.getArc(debut + 1, i + 1))) { // on regarde si l'arc qu'on crée avec la
																			// boucle est un arc qui part du sommet
																			// (c-a-d qu'il se trouve dans l'ArrayList
																			// des arcs du sommet)
					somme = poids + graphe.getArc(debut + 1, i + 1).getPoids(); // cf. ligne 58
					if (tabPoids.get(i) == -1 || somme < tabPoids.get(i)) { // si il y a un + infini dans la case (-1)
																			// et que ce n'est pas égal à 0 (ça voudrait
																			// dire que le sommet est barré) alors on
																			// met comme valeur le poids (cf. ligne 68)
						tabPoids.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1,
								poids + graphe.getArc(debut + 1, i + 1).getPoids()); // on ajoute donc le poids + le
																						// poids de l'arc.
						tabPredecesseur.put(graphe.getArc(debut + 1, i + 1).getSommet2() - 1, debut); // on marque le
																										// sommet
																										// précédent
																										// pour
																										// retrouver le
																										// chemin après
					}
				}
			}
			tmp.clear();
			tmp.addAll(tabPoids.values());
			for (int i = 0; i < tabPoids.size(); i++) { // ici on supprime tous les -1 et 0. Alors je savais pas mais
														// pour supprimer dans une liste c'est juste un enfer (à cause
														// des index). Donc faudra voir comme on peut améliorer ça mais
														// sur internet j'ai rien trouvé
				tmp.remove(new Integer(0));
				tmp.remove(new Integer(-1));
			}
			for (int i = 0; i < graphe.getNbNoeuds(); i++) {
				if (Objects.equals(tabPoids.get(i), Collections.min(tmp))) { // on cherche à quel sommet appartient le
																				// plus petit poids de la ligne
					debut = i; // une fois trouvé, on remplace debut par le sommet (i)
					break;
				}
			}
			poids = tabPoids.get(debut); // on ajoute au poids la valeur du sommet qu'on vient de choisir (celui qu'on
											// entoure parce qu'il a la plus petite valeur)
			// System.out.println(tabPoids); //si on décommente on peut voir le fameux
			// tableau de Djikstra !
		}

		// c'est ici qu'on se sert du tableau des prédécesseurs. On va remonter tout le
		// tableau... .
		int temporaire = fin - 1;
		chemin.add(temporaire + 1);
		while (temporaire + 1 != debutStatic) {
			temporaire = tabPredecesseur.get(temporaire);
			chemin.add(temporaire + 1);
		}
		Collections.reverse(chemin); // explicite
		return poids;

	}

	public void cycle(IGraphe graphe) {
	}

}
