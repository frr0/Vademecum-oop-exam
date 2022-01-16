package piano_vaccinazioni;

public class Centro {

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public void setNumeroMassimoDosi(int numeroMassimoDosi) {
		this.numeroMassimoDosi = numeroMassimoDosi;
	}

	private String codice;
	private String regione;
	private int numeroMassimoDosi;
	int dosiA;
	int dosiB;

	public Centro(String codice, String regione, int numeroMassimoDosi) {
		this.codice = codice;
		this.regione = regione;
		this.numeroMassimoDosi = numeroMassimoDosi;
		// TODO Auto-generated constructor stub
		dosiA = 0;
		dosiB = 0;
	}

	public String getCodice() {
		return codice;
	}

	public String getRegione() {
		return regione;
	}

	public int getNumeroMassimoDosi() {
		return numeroMassimoDosi;
	}

	public void aggiungiDosi(char tipoVaccino, int numeroDosi) throws EccezioneConsegnateMenoDosi {
		
		if (tipoVaccino == 'A') {
			if (numeroDosi + dosiA + dosiB > numeroMassimoDosi) {
				dosiA = numeroMassimoDosi - dosiB;
				throw new EccezioneConsegnateMenoDosi(numeroMassimoDosi - dosiB);
			}
			else {
				dosiA = dosiA + numeroDosi;
			}
		}
		else {
			if (numeroDosi + dosiA + dosiB > numeroMassimoDosi) {
				dosiB = numeroMassimoDosi - dosiA;
				throw new EccezioneConsegnateMenoDosi(numeroMassimoDosi - dosiA);
			}
			else {
				dosiB = dosiB + numeroDosi;
			}			
		}
		
	}
}
