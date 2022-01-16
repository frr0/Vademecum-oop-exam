package palestra;

public class CorpoLibero extends Esercizio {
	private int ripetizioni;
	private int carico;
	
	public CorpoLibero(String codice, String descrizione, int carico) {
		super(codice, descrizione);
		this.carico = carico;
	}

	@Override
	public String toString() {
		return "CorpoLibero [ripetizioni=" + ripetizioni + ", carico=" + carico + "]";
	}

	public int getRipetizioni() {
		return ripetizioni;
	}

	public void setRipetizioni(int ripetizioni) {
		this.ripetizioni = ripetizioni;
	}

	public int getCarico() {
		return carico;
	}

	public void setCarico(int carico) {
		this.carico = carico;
	}

	public String descriviti() {
		return getCodice() + " " + getDescrizione() + " " + ripetizioni + " " + carico;
	}

}