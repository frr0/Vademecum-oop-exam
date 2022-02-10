package palestra;

public class Esercizio {
	
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

	private String codice;
	private String descrizione;

	public Esercizio(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
		// TODO Auto-generated constructor stub
	}

	public String descriviti() {
		return codice + " " + descrizione;
	}
}
