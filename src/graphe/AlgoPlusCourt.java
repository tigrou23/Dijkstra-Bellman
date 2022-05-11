package graphe;

import java.util.List;

public interface AlgoPlusCourt {
	void estOk(int debut, int fin);
	void cycle();
	List<Integer> resoudre(int debut, int fin);
	int getPoids();
}
