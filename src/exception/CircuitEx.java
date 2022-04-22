package exception;

@SuppressWarnings("serial")
public class CircuitEx extends IllegalArgumentException {
	public CircuitEx() {
		super("Bellman n'est pas utilisable sur ce graphe, il y a un ou plusieurs cycle(s)");
	}
}
