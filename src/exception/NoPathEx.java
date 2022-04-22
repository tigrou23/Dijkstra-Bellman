package exception;

@SuppressWarnings("serial")
public class NoPathEx extends IllegalArgumentException {
	public NoPathEx() {
		super("Il n'existe aucun chemin entre les deux sommets choisis");
	}
}
