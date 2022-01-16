package studiomedico;

public class Prenotazione {
	Medico medico;
	Orario orario;
	Assistito assistito;
	String codicePrenotazione;
	
	public Prenotazione(String codicePrenotazione, Medico medico, Orario orario, Assistito assistito) {
		this.medico = medico;
		this.orario = orario;
		this.assistito = assistito;
		this.codicePrenotazione = codicePrenotazione;
	}
}
