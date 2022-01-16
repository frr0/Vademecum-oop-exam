package serviziospedizioni;

public class Collo {
	
	String codice;
	String citta;
	String dataDeposito;
	String indirizzoMittente;
	String indirizzoDestinatario;

	public Collo(String codice, String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario) {
		this.codice = codice;
		this.citta = citta;
		this.dataDeposito = dataDeposito;
		this.indirizzoMittente = indirizzoMittente;
		this.indirizzoDestinatario = indirizzoDestinatario;
	}

	public String getCodiceCollo() {
		return this.codice;
	}
	
	public String getCitta() {
		return this.citta;
	}
	
	public String getDataDeposito() {
		return this.dataDeposito;
	}
	
	public String getIndirizzoDestinatario() {
		return this.indirizzoDestinatario;
	}
	
	public String getIndirizzoMittente() {
		return this.indirizzoMittente;
	}
}
