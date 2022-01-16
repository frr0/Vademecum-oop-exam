package didattica;

public class Docente {
	 private int codice;
	 private String cognome;
	 private String nome;
	 private String ruolo;
	 private Corso corsi [];
	 private int numeroCorsi;
	

	public Docente(int codice, String cognome, String nome, String ruolo) {
		this.codice = codice;
		this.cognome = cognome;
		this.nome = nome;
		this.ruolo = ruolo;
		this.numeroCorsi = 0;
		this.corsi = new Corso[5];
	}

	public int getCodice() {
		return this.codice;
	}

	public String getCognome() {
		return this.cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getRuolo() {
		return this.ruolo;
	}

	public String descriviti() {
		String sp = " ";
		return this.codice + sp + this.cognome + sp + this.nome + sp + this.ruolo;
	}
	
	public void inserisciCorso(Corso nuovoCorso) {
		if (this.numeroCorsi < 5) {
			this.corsi[this.numeroCorsi] = nuovoCorso;
			this.numeroCorsi++;
		}
	}
	
	public int getNumeroCorsi() {
		return this.numeroCorsi;
	}
	
	public Corso [] getCorsi() {
		return this.corsi;
	}
	
}
