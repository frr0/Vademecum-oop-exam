package serviziospedizioni;

public class Spedizione {
	
	String codice;
	Collo collo;
	Corriere corriere;
	String citta;
	String dataConsegna;
	
	public Spedizione(String codice, Collo collo, Corriere corriere, String citta, String dataConsegna) {
		this.codice = codice;
		this.collo = collo;
		this.corriere = corriere;
		this.citta = citta;
		this.dataConsegna = dataConsegna;
	}

	public String descriviti() {
		return codice +  " " +  corriere.codiceCorriere + " " + collo.codice + " " + dataConsegna;
	}
}
