package exception;

@SuppressWarnings("serial")
public class ArcNegatifNulException extends IllegalArgumentException {
	public ArcNegatifNulException() {
		super("Dijsktra n'est pas utilisable sur ce graphe, il y a un ou plusieurs arc(s) n�gatif(s) et/ou non valu�(s)");
	}
}
