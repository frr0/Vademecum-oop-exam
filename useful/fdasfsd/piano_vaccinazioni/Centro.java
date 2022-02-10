package piano_vaccinazioni;

public class Centro {
	
	String regione;
	int numeroMassimoDosi;
	String codice;
	int numREgione = 0;
	int numA = 0;
	int numB = 0;
	int tot = numA+numB;
	boolean consegnato = false;

	public int getNumA() {
		return numA;
	}

	public void setNumA(int numA) {
		this.numA = numA;
	}

	public int getNumB() {
		return numB;
	}

	public void setNumB(int numB) {
		this.numB = numB;
	}

	public Centro(String regione, int numeroMassimoDosi, String codice, int numREgione) {
		super();
		this.regione = regione;
		this.numeroMassimoDosi = numeroMassimoDosi;
		this.codice = codice;
		this.numREgione = numREgione;
	}

	public int getNumREgione() {
		return numREgione;
	}

	public void setNumREgione(int numREgione) {
		this.numREgione = numREgione;
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

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public void setNumeroMassimoDosi(int numeroMassimoDosi) {
		this.numeroMassimoDosi = numeroMassimoDosi;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}


}
