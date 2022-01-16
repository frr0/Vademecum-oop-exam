package palestra;

public class Cardio extends Esercizio {

	private int minuti;

	public Cardio(String codice, String descrizione, int minuti) {
		// TODO Auto-generated constructor stub
		super(codice, descrizione);
		this.minuti = minuti;
	}

	public String descriviti() {
		return super.descriviti() + " CAR " + minuti;
	}
}
