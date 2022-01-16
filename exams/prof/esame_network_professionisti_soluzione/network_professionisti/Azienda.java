package network_professionisti;

public class Azienda extends Entita implements Comparable<Azienda>{

	private String settore;
	private int numeroDipendenti;
	
	public Azienda(String nome, String nazione, String indirizzo, String settore, int numeroDipendenti) {
		super(nome, nazione, indirizzo);
		this.settore=settore;
		this.numeroDipendenti=numeroDipendenti;
	}

	public String getSettore() {
		return settore;
	}

	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}

	@Override
	public int compareTo(Azienda o) {
		return this.getNumeroDipendenti()-o.getNumeroDipendenti();
	}

	
	
	
}
