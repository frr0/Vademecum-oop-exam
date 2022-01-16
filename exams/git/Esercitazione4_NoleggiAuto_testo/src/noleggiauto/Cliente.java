package noleggiauto;

public class Cliente {
	private String cognome;
	private String nome;
	private String nazionalita;
	private String numeroPatente;
	
	

	public Cliente(String cognome, String nome, String nazionalita, String numeroPatente) {	
		this.cognome = cognome;
		this.nome = nome;
		this.nazionalita = nazionalita;
		this.numeroPatente = numeroPatente;
	}

	public String getCodice() {
		String codice;
		
		String nomeCodice;
		String cognomeCodice;
		String nazionalitaCodice;
		String patenteCodice;
		
		if (this.nome.length() > 2) {
			nomeCodice = this.nome.substring(0,3).toUpperCase();
		} else {
			nomeCodice = this.nome.toUpperCase();
			while (nomeCodice.length() < 3) {
				nomeCodice += '*';
			}
		}
		
		if (this.cognome.length() > 2) {
			cognomeCodice = this.cognome.substring(0,3).toUpperCase();
		} else {
			cognomeCodice = this.cognome.toUpperCase();
			while (cognomeCodice.length() < 3) {
				cognomeCodice += '*';
			}
		}
		
		if (this.nazionalita.length() > 2) {
			nazionalitaCodice = this.nazionalita.substring(0,3).toUpperCase();
		} else {
			nazionalitaCodice = this.nazionalita.toUpperCase();
			while (nazionalitaCodice.length() < 3) {
				nazionalitaCodice += '*';
			}
		}
		
		patenteCodice = this.numeroPatente;
		while (patenteCodice.length() < 10) {
			patenteCodice += '*';
		}
		
		
		codice = cognomeCodice + "-" + nomeCodice + "-" + nazionalitaCodice + "-" + patenteCodice;
		
		return codice;
	}

	public String getCognome() {
		return this.cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNazionalita() {
		return this.nazionalita;
	}

	public String getNumeroPatente() {
		return this.numeroPatente;
	}
	
}
