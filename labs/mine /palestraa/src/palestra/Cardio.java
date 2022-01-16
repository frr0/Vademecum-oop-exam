package palestra;

public class Cardio extends Esercizio {
	private int minuti;

	public Cardio(String codice, String descrizione, int minuti) {
		super(codice, descrizione);
		this.minuti = minuti;
	}

	public int getMinuti() {
		return minuti;
	}

	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}

	public String descriviti() {
		return getCodice() + " " + getDescrizione() + " " + minuti;
	}
}