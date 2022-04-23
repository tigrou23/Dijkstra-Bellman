package graphe;

public class Sommet {
	
	private int sommetInt = 0;
	private String sommetStr = null;
	
	public Sommet(int s) {
		sommetInt = s;
	}
	
	public Sommet(String s) {
		sommetStr = s;
	}
	
	public Object getSommet() {
		if(sommetInt != 0)
			return getSommetInt();
		else 
			return getSommetStr();
	}
	
	private String getSommetStr() {
		return sommetStr;
	}
	
	private int getSommetInt() {
		return sommetInt;
	}
	
	public String toString() {
		if(sommetInt != 0)
			return "" + sommetInt;
		else
			return sommetStr; 
	}
	
}
