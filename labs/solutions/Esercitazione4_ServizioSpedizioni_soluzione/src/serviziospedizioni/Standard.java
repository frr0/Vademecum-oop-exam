package serviziospedizioni;

public class Standard extends Collo {
	public Standard(String codice, String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario) {
		super(codice, citta, dataDeposito, indirizzoMittente, indirizzoDestinatario);
	}

	public String descriviti() {
		return super.getCodiceCollo() + " " + super.getCitta() + " " + super.getDataDeposito() + " " + super.getIndirizzoMittente() + " " + super.getIndirizzoDestinatario();
	}
}
