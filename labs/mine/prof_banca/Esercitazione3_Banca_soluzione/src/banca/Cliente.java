package banca;

public class Cliente {
	
	String codiceFiscale;
	String cognome;
	String nome;
	String professione;
	Conto[] conti;
	int numConti;
	Prestito[] prestiti;
	int numPrestiti;
	
	public Cliente(String codiceFiscale, String cognome, String nome, String professione) {
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
		this.professione = professione;
		this.conti = new Conto[100];
		this.numConti = 0;
		this.prestiti = new Prestito[100];
		this.numPrestiti = 0;
	}
	
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public String getNome() {
		return this.nome;
	}
	

	public String getProfessione() {
		return this.professione;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProfessione(String professione) {
		this.professione = professione;
	}

	public String descriviti() {
		return this.codiceFiscale + " " + this.cognome + " " + this.nome + " " + this.professione;
	}

	public void aggiungiConto(Conto conto) {
		this.conti[numConti++] = conto;
	}
	
	public Conto[] getConti() {
		
		Conto[] cc = null;
		
		if (this.numConti > 0) {
			cc = new Conto[this.numConti];
			for (int i = 0; i < this.numConti; i++) {
				cc[i] = this.conti[i];
			}
		}
		
		return cc;
	}

	public boolean contieneConto(Conto cn) {

		boolean res = false;
		
		if (this.numConti > 0) {
			for (Conto ci : this.getConti()) {
				if (ci.equals(cn)) {
					res = true;
				}
			}			
		}
		
		return res;
	}
	
	public void aggiungiPrestito(Prestito prestito) {
		this.prestiti[numPrestiti++] = prestito;
	}
	
	public Prestito[] getPrestiti() {
		
		Prestito[] pp = null;
		
		if (this.numPrestiti > 0) {
			pp = new Prestito[this.numPrestiti];
			for (int i = 0; i < this.numPrestiti; i++) {
				pp[i] = this.prestiti[i];
			}
		}
		
		return pp;
	}
	
	public Prestito[] getPrestiti(String tipo) {
		
		Prestito[] pp = null;
		int j = 0;
		
		if (this.numPrestiti > 0) {
			for (int i = 0; i < this.numPrestiti; i++) {
				if (tipo == "M" && this.prestiti[i] instanceof Mutuo) {
					j++;
				}
				else if (tipo == "F" && this.prestiti[i] instanceof Fido) {
					j++;
				}
			}
		}
		
		if (j > 0) {
			int k = 0;
			pp = new Prestito[j];
			for (int i = 0; i < this.numPrestiti; i++) {
				if (tipo == "M" && this.prestiti[i] instanceof Mutuo) {
					pp[k++] = this.prestiti[i];
				}
				else if (tipo == "F" && this.prestiti[i] instanceof Fido) {
					pp[k++] = this.prestiti[i];
				}
			}
		}
		
		return pp;
	}
}
