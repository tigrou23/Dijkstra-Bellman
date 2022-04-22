package graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import exception.ArcNegatifNulException;

public class PCCBellman {
		
	private static Boolean estOk(IGraph graphe) {
		ArrayList<Arc> test = new ArrayList<>(); 
		for(int i = 0; i < graphe.getNbNoeuds(); i++) {
			test = graphe.getArcSuccesseur(i+1);
			for (int j = 0; j < test.size(); j++ ) {
				if(test.get(j).getPoids() <= 0)
					return false;
			}
		}return true;
	}
	
	public static List<Integer> resoudre(IGraph graphe ,int debut, int fin) throws ArcNegatifNulException{
				
		if(Boolean.TRUE.equals(estOk(graphe)))
		{
			
			ArrayList<Integer> chemin = new ArrayList<>(); //va recevoir le chemin final pour accèder de début à fin
			final int inf = Integer.MAX_VALUE;

			
			return chemin;
		}
		else
			throw new ArcNegatifNulException();
	}
}
