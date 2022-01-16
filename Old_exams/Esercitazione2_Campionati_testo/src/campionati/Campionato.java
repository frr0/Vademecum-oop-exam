package campionati;

import campionati.Squadra;
import campionati.Incontro;

public class Campionato {
	private String lega;
	private String denominazione;
	private String stagione;
	private int numeroSquadre;
	private int numeroRetrocessioni;
	private Squadra squadreIscritte[];
	private int numeroSquadreIscritte = 0;
	private Incontro listaIncontri[];
	private int numeroIncontri;
	
	public Campionato(String lega, String denominazione, String stagione, int numeroSquadre) {
		this.lega = lega;
		this.denominazione = denominazione;
		this.stagione = stagione;
		this.numeroSquadre = numeroSquadre;
		this.squadreIscritte = new Squadra[numeroSquadre];
		this.numeroIncontri = 0;
		for (int i=1; i<numeroSquadre; i++) {
			this.numeroIncontri += i*2;
		}
		this.listaIncontri = new Incontro[this.numeroIncontri];
	}

	public String getLega() {
		return this.lega;
	}

	public String getDenominazione() {
		return this.denominazione;
	}

	public String getStagione() {
		return this.stagione;
	}
	
	public int getNumeroSquadre() {
		return this.numeroSquadre;
	}
	
	public void setNumeroRetrocessioni(int numeroRetrocessioni){
		this.numeroRetrocessioni = numeroRetrocessioni;
	}
	
	public String regolamento() {
		String res = new String(this.numeroSquadre + " (" + this.numeroRetrocessioni + ")");
		return res;
	}
	
	public int iscriviSquadra(String nome, String stadio, String presidente ) {
		int i;
		if (numeroSquadreIscritte == numeroSquadre) {
			return -1;
		}
		for (i=0; i<this.numeroSquadreIscritte; i++) {
			if (squadreIscritte[i].getNome() == nome && squadreIscritte[i].getPresidente() == presidente && squadreIscritte[i].getStadio() == stadio) {
				break;
			}
		}
		if (i == this.numeroSquadreIscritte) {
			// Iscrivi squadra
			this.squadreIscritte[numeroSquadreIscritte] = new Squadra(nome, stadio, presidente);
			this.numeroSquadreIscritte++;
			return this.numeroSquadreIscritte;
		} else {
			// Squadra già iscritta
			return i + 1;
		}
	}
	
	public String squadra(int identificativoSquadra) {
		Squadra selezionata = this.squadreIscritte[identificativoSquadra - 1];
		return new String(selezionata.getNome()+";"+selezionata.getStadio()+";"+selezionata.getPresidente());
	}
	

	public String[] squadreIscritte() {
		String reportSquadreIscritte [] = new String[this.numeroSquadreIscritte];
		for (int i = 0; i<this.numeroSquadreIscritte; i++) {
			reportSquadreIscritte[i] = new String((i+1) + " " + this.squadreIscritte[i].getNome());
		}
		return reportSquadreIscritte;
	}

	public String aggiungiIncontro(int identificativoSquadraCasa, int identificativoSquadraOspite) {
		Incontro nuovoIncontro = new Incontro(identificativoSquadraCasa, identificativoSquadraOspite);
		if (identificativoSquadraCasa == identificativoSquadraOspite) {
			return null;
		}
		for (int i=0; i < this.numeroIncontri; i++) {
			if (listaIncontri[i] == null) {
				// inserisci incontro
				listaIncontri[i] = nuovoIncontro;
				return listaIncontri[i].getIdentificativo();
			} else if (nuovoIncontro.getIdentificativo().equals(listaIncontri[i].getIdentificativo())) {
				return nuovoIncontro.getIdentificativo();
			}
		}
		return null;
	}

	public void impostaEsito(String identificativoIncontro, String esito) {
		for (int i=0; i < this.numeroIncontri; i++) {
			if (listaIncontri[i] == null) {
				break;
			} else if (listaIncontri[i].getIdentificativo().equals(identificativoIncontro)) {
				listaIncontri[i].setEsito(esito);
				break;
			}
		}
	}
	
	
	public String incontro(String identificativoIncontro) {
		for (int i=0; i < this.numeroIncontri; i++) {
			if (listaIncontri[i] == null) {
				return null;
			} else if (listaIncontri[i].getIdentificativo().equals(identificativoIncontro)) {
				String squadraCasa = squadreIscritte[listaIncontri[i].getSquadraCasa()-1].getNome();
				String squadraTrasferta = squadreIscritte[listaIncontri[i].getSquadraTrasferta()-1].getNome();
				return new String(squadraCasa+" vs "+squadraTrasferta+" "+listaIncontri[i].getEsito());
			}
		}
		return null;
	}

	public String incontri() {
		String res = new String();
		for (int i=0; i < this.numeroIncontri; i++) {
			if (this.listaIncontri[i] == null) {
				break;
			}
			res += this.incontro(listaIncontri[i].getIdentificativo());
			res += "\n";
		}
		return res.substring(0, res.length()-1);
	}
	
	public String incontriTerminati() {
		String res = new String();
		for (int i=0; i < this.numeroIncontri; i++) {
			if (this.listaIncontri[i] == null) {
				break;
			}
			if (!(this.listaIncontri[i].getEsito().equals("N/D"))) {
				res += this.incontro(listaIncontri[i].getIdentificativo());
				res += "\n";
			}
		}
		return res.substring(0, res.length()-1);
	}
	
	public String incontriSquadra(int identificativoSquadra) {
		String res = new String();
		for (int i=0; i < this.numeroIncontri; i++) {
			if (this.listaIncontri[i] == null) {
				return res.substring(0, res.length()-1);
			}
			if((this.listaIncontri[i].getSquadraCasa()==identificativoSquadra) || (this.listaIncontri[i].getSquadraTrasferta() == identificativoSquadra)) {
				res += this.incontro(listaIncontri[i].getIdentificativo());
				res += "\n";
			}		
		}
		return res.substring(0, res.length()-1);	
	}
}

