package agenzia_immobiliare;

public class Cliente {

	String codiceFiscale;
	String cognome;
	String nome;
	
	boolean piuDiUnaTransazione = false;
	
	public Cliente(String codiceFiscale, String cognome, String nome) {
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}
}
