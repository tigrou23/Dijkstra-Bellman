package graphe;

import java.util.ArrayList;

public abstract class PlusCourtChemin {
	
	protected IGraph graphe;
	
	public abstract Boolean estOk();
	
	public abstract ArrayList<Integer> resoudre(int debut, int fin);

}
