package banca;

public class Conto {
	
	double tassoInteresse;
	double capitale;
	String dataApertura;
	String nomeOperatore;
	String nomeFIliale;
	String codiceConto;
	Cliente[] clienti;
	int numClienti;

	public Conto(double tassoInteresse, double capitale, String dataApertura, String nomeOperatore, String nomeFiliale, String codiceConto) {
		this.tassoInteresse = tassoInteresse;
		this.capitale = capitale;
		this.dataApertura = dataApertura;
		this.nomeOperatore = nomeOperatore;
		this.nomeFIliale = nomeFiliale;
		this.codiceConto = codiceConto;
		this.clienti = new Cliente[100];
		this.numClienti = 0;
	}
	
	public String getCodice() {
		return this.codiceConto;
	}

	public double getTassoInteresse() {
		return this.tassoInteresse;
	}

	public double getCapitale() {
		return this.capitale;
	}

	public String getDataApertura() {
		return this.dataApertura;
	}

	public String getNomeOperatore() {
		return this.nomeOperatore;
	}

	public String getNomeFiliale() {
		return this.nomeFIliale;
	}

	public String descriviti() {
		return this.codiceConto + " " + this.tassoInteresse + " " + this.capitale + " " + this.dataApertura + " " + this.nomeOperatore + " " + this.nomeFIliale;
	}

	public void aggiungiCliente(Cliente cliente) {
		this.clienti[numClienti++] = cliente;
	}
	
	public Cliente getIntestatario() {
		Cliente c = null;
		
		if(this.numClienti > 0) {
			c = this.clienti[0];
		}
		
		return c;
	}
	
	public Cliente[] getClienti() {
		
		Cliente[] cc = null;
		
		if (this.numClienti > 0) {
			cc = new Cliente[this.numClienti];
			for (int i = 0; i < this.numClienti; i++) {
				cc[i] = this.clienti[i];
			}
		}
		
		return cc;
	}
	
}
