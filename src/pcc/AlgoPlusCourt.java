package pcc;

import java.util.List;

import graphe.IGraphe;

public interface AlgoPlusCourt {
	final int INFINI = Integer.MAX_VALUE;
	void estOk(IGraphe graphe, int debut, int fin);
	void cycle(IGraphe graphe);
	int resoudre(IGraphe g, int debut, int fin, List<Integer> chemin);
}