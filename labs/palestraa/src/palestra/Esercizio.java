package palestra;

public class Esercizio implements Comparable<Esercizio>{
	private String codice;
	private String descrizione;
	
	public String descriviti() {
		return codice + " " + descrizione;
	}

	public Esercizio(String codice, String descrizione) {
//		super();
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Esercizio [codice=" + codice + ", descrizione=" + descrizione + "]";
	}

	@Override
	public int compareTo(Esercizio o) {
		// TODO Auto-generated method stub
//		return o.getCodice().compareTo(this.codice);
		return this.codice.compareTo(o.getCodice());
	}
}