package graphe.types;

import java.util.ArrayList;

import graphe.Arc;
import graphe.IGraphe;

public class GrapheMA implements IGraphe {

	// Double tableau de booleens qui represente la matrice adjacente du graphe
	private boolean[][] MA;

	// ArrayList d'arcs qui stocke tous les arcs du graphes
	private ArrayList<Arc> arc;

	// Le nombre de noeuds du graphe
	private int nb_noeuds;

	public GrapheMA(int nb_noeuds) {
		arc = new ArrayList<>();
		MA = new boolean[nb_noeuds][nb_noeuds];
		this.nb_noeuds = nb_noeuds;
		for (int i = 0; i < nb_noeuds; ++i) {
			for (int j = 0; j < nb_noeuds; ++j) {
				MA[i][j] = false;
			}
		}
	}

	public void ajouterArc(int n1, int poids, int n2) {
		assert (n1 > 0 && n1 <= nb_noeuds && n2 > 0 && n2 <= nb_noeuds);
		Arc arcTMP = new Arc(n1, poids, n2);
		MA[n1 - 1][n2 - 1] = true;
		arc.add(arcTMP);
	}

	public int getNbNoeuds() {
		return nb_noeuds;
	}

	public boolean aArc(int n1, int n2) {
		assert (n1 > 0 && n1 <= nb_noeuds && n2 >= 0 && n2 <= nb_noeuds);
		return MA[n1 - 1][n2 - 1];
	}

	public int dOut(int n) {
		assert (n > 0 && n <= nb_noeuds);
		int nbdOut = 0;
		for (int i = 0; i < nb_noeuds; ++i) {
			if (MA[n - 1][i])
				nbdOut++;
		}
		return nbdOut;
	}

	public int dIn(int n) {
		assert (n > 0 && n <= nb_noeuds);
		int nbdIn = 0;
		for (int i = 0; i < nb_noeuds; ++i) {
			if (MA[i][n - 1])
				nbdIn++;
		}
		return nbdIn;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nb_noeuds; ++i) {
			for (int j = 0; j < nb_noeuds; ++j) {
				if (MA[i][j])
					sb.append("1 ");
				else
					sb.append("0 ");

			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public Arc getArc(int s1, int s2) {
		for (int i = 0; i < arc.size(); i++) {
			if (arc.get(i).getSommet1() == s1 && arc.get(i).getSommet2() == s2)
				return arc.get(i);
		}
		return null;
	}

	public ArrayList<Arc> getArcPredecesseur(int s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for (int i = 0; i < arc.size(); i++) {
			if (arc.get(i).getSommet2() == s)
				listArc.add(arc.get(i));
		}
		return listArc;
	}

	public ArrayList<Arc> getArcSuccesseur(int s) {
		ArrayList<Arc> listArc = new ArrayList<>();
		for (int i = 0; i < arc.size(); i++) {
			if (arc.get(i).getSommet1() == s)
				listArc.add(arc.get(i));
		}
		return listArc;
	}

	public ArrayList<Arc> getArc() {
		return arc;
	}

	@Override
	public int distance(ArrayList<Integer> cheminCalcule) {
		int cpt = 0;
		for (int i = 0; i < cheminCalcule.size() - 1; ++i)
			for (int j = 1; j < cheminCalcule.size(); ++j)
				cpt += getArc(cheminCalcule.get(i), cheminCalcule.get(j)).getPoids();
		return cpt;
	}

}
