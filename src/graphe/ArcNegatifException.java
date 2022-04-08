package graphe;

@SuppressWarnings("serial")
public class ArcNegatifException extends IllegalArgumentException{
	public ArcNegatifException(){
		super("Dijsktra n'est pas utilisable sur ce graphe, il y a un ou plusieurs arcs négatifs");
	}
}
