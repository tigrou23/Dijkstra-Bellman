package pcc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import exception.CircuitEx;
import exception.NoPathEx;
import graphe.AlgoPlusCourt;
import graphe.Arc;
import graphe.IGraphe;

public class PCCBellman implements AlgoPlusCourt {

	public void estOk(IGraphe graphe, int debut, int fin) throws NoPathEx, CircuitEx {
		cycle(graphe);
		ArrayList<Integer> cheminD = new ArrayList<>();
		ArrayList<Integer> tmpD = new ArrayList<>();
		cheminD.add(debut);
		Boolean good = false;
		while (!cheminD.isEmpty()) {
			tmpD.clear();
			Iterator<Integer> chD = cheminD.iterator();
			while (chD.hasNext()) {
				int itD = chD.next();
				chD.remove();
				for (Arc a : graphe.getArcSuccesseur(itD))
					if (!cheminD.contains(a.getSommet2()) && !tmpD.contains(a.getSommet2()))
						tmpD.add(a.getSommet2());
			}
			cheminD.addAll(tmpD);
			if (cheminD.contains(fin)) {
				good = true;
				break;
			}
		}
		if (!good)
			throw new NoPathEx();

	}

	public void cycle(IGraphe graphe) {
		for (int i = 1; i < graphe.getNbNoeuds() + 1; i++) {
			ArrayList<Integer> suivants = new ArrayList<>();
			ArrayList<Integer> tmp = new ArrayList<>();
			ArrayList<Integer> list = new ArrayList<>();
			suivants.add(i);
			// Boolean good = false;
			while (!suivants.isEmpty()) {
				tmp.clear();
				Iterator<Integer> it = suivants.iterator();
				while (it.hasNext()) {
					int sommet = it.next();
					it.remove();
					for (Arc a : graphe.getArcSuccesseur(sommet)) {
						if (!suivants.contains(a.getSommet2()) && !tmp.contains(a.getSommet2())
								&& !list.contains(a.getSommet2())) {
							tmp.add(a.getSommet2());
							list.add(a.getSommet2());
						}
					}
				}
				suivants.addAll(tmp);
				if (tmp.isEmpty())
					break;
			}
			if (list.contains(i))
				throw new CircuitEx();
		}
	}

	public int resoudre(IGraphe graphe, int debut, int fin, List<Integer> chemin) throws NoPathEx {
		
		if(debut == fin) {
			chemin.add(debut);
			return 0;
		}
		
		estOk(graphe, debut, fin);

		int distance = 0;// le poids qui va etre retourné
		int rang = 0;
		/* INITIALISATION DES TABLEAUX */
		HashMap<Integer, Integer> d = new HashMap<>(); // tableau des rangs
		HashMap<Integer, ArrayList<Integer>> p = new HashMap<>(); // tableau des predecesseurs

		/* TRI DES TABLEAUX */
		for (int i = 1; i < graphe.getNbNoeuds() + 1; i++) { // FAUDRA ADAPTER AU TYPE SOMMET -> compare le sommet i et
																// le sommet debut
			ArrayList<Arc> aTmp = graphe.getArcPredecesseur(i);
			ArrayList<Integer> tmp = new ArrayList<>();
			if (graphe.dIn(i) == 0) {
				tmp = null;
			} else {
				for (int j = 0; j < graphe.dIn(i); ++j) {
					tmp.add(aTmp.get(j).getSommet1());
				}
			}

			p.put(i, tmp);
		}
		ArrayList<Integer> tmp = new ArrayList<>();
		while (!p.isEmpty()) {
			for (Entry<Integer, ArrayList<Integer>> tab : p.entrySet())
				if (tab.getValue() == null)
					tmp.add(tab.getKey());
			for (Integer i : tmp) {
				p.remove(i);
				d.put(i, rang);
			}
			++rang;
			// FAIRE LE REMOVE APRES
			for (Integer k : tmp) {
				Iterator<Entry<Integer, ArrayList<Integer>>> iterator = p.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry<Integer, ArrayList<Integer>> j = iterator.next();
					if (j.getValue() != null) {
						int iter = j.getValue().size();
						for (int i = 0; i < iter; ++i) {
							if (Objects.equals(j.getValue().get(i), k)) {
								p.get(j.getKey()).remove(i);
								--iter;
							}
							if (j.getValue().isEmpty()) {
								p.replace(j.getKey(), null);
							}
						}
					}
				}
			}
			tmp.clear();
		}
		Iterator<Entry<Integer, Integer>> iterator = d.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> it = iterator.next();
			if (((it.getKey() != debut) && (it.getValue() <= d.get(debut)))) {
				iterator.remove();
			}
		}
		HashMap<Integer, Integer> poids = new HashMap<>();
		HashMap<Integer, Integer> predecesseur = new HashMap<>();
		tmp.add(debut);
		poids.put(debut, 0);
		predecesseur.put(debut, null);
		while (!tmp.isEmpty()) {
			ArrayList<Integer> tmp2 = new ArrayList<>();
			Iterator<Integer> iter = tmp.iterator();
			while (iter.hasNext()) {
				int sommet = iter.next();
				if (sommet != fin) {
					Iterator<Entry<Integer, Integer>> iterator1 = d.entrySet().iterator();
					while (iterator1.hasNext()) {
						Map.Entry<Integer, Integer> it = iterator1.next();
						if (graphe.aArc(sommet, it.getKey())) {
							if (poids.containsKey(it.getKey())) {
								if (poids.get(it.getKey()) > (poids.get(sommet)
										+ graphe.getArc(sommet, it.getKey()).getPoids())) {
									poids.replace(it.getKey(),
											poids.get(sommet) + graphe.getArc(sommet, it.getKey()).getPoids());
									predecesseur.replace(it.getKey(), sommet);
									tmp2.add(it.getKey());
								}
							} else if (!poids.containsKey(it.getKey())) {
								poids.put(it.getKey(),
										poids.get(sommet) + graphe.getArc(sommet, it.getKey()).getPoids());
								predecesseur.put(it.getKey(), sommet);
								tmp2.add(it.getKey());
							}
						}
					}
				}
			}
			tmp.clear();
			tmp.addAll(tmp2);
		}
		int sommet = fin;
		while (sommet != debut) {
			for (Entry<Integer, Integer> i : predecesseur.entrySet()) {
				if (i.getKey() == sommet) {
					chemin.add(sommet);
					sommet = i.getValue();
					if (chemin.size() > 1)
						distance += graphe.getArc(chemin.get(chemin.size() - 1), chemin.get(chemin.size() - 2))
								.getPoids();
					break;
				}
			}
		}
		chemin.add(debut);
		distance += graphe.getArc(chemin.get(chemin.size() - 1), chemin.get(chemin.size() - 2)).getPoids();
		Collections.reverse(chemin);
		return distance;
	}

}
