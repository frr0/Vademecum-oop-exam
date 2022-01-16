package serviziospedizioni;

public class Prioritario extends Collo {
	
	String mailMittente;

	public Prioritario(String codice, String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario, String mailMittente) {
		super(codice, citta, dataDeposito, indirizzoMittente, indirizzoDestinatario);
		this.mailMittente = mailMittente;
	}

	public String descriviti() {
		return super.getCodiceCollo() + " " + super.getCitta() + " " + super.getDataDeposito() + " " + super.getIndirizzoMittente() + " " + super.getIndirizzoDestinatario() + " " + mailMittente;
	}

	public String getMailMittente() {
		return this.mailMittente;
	}

}
