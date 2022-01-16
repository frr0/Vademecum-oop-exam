package studiomedico;

public class Orario {

	Medico medico;
	String giorno;
	int orarioInizio;
	int orarioFine;
	
	public Orario(Medico medico, String giorno, int orarioInizio, int orarioFine) {
		this.medico = medico;
		this.giorno = giorno;
		this.orarioInizio = orarioInizio;
		this.orarioFine = orarioFine;
	}
	
	
	public String descriviti() {
		return giorno + " " + orarioInizio + "-" + orarioFine;
	}
}
