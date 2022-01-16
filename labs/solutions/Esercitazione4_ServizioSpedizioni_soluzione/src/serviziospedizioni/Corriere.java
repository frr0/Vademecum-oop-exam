package serviziospedizioni;

import java.util.ArrayList;

public class Corriere {
	
	String codiceCorriere;
	String nome;
	String cognome;
	int eta;
	String citta;
	ArrayList<Spedizione> spedizioni;
	
	public Corriere(String codiceCorriere, String nome, String cognome, int eta, String citta) {
		this.codiceCorriere = codiceCorriere;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.citta = citta;
		this.spedizioni = new ArrayList<>();
	}
	
	public String getCodiceCorriere() {
		return this.codiceCorriere;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public int getEta() {
		return this.eta;
	}
	
	public String getCitta() {
		return this.citta;
	}
	
	public String descriviti() {
		return codiceCorriere + " " + nome + " " + cognome + " " + eta + " " + citta;
	}

	public ArrayList<Spedizione> getSpedizioniPerData(String dataConsegna) {
		
		ArrayList<Spedizione> ss = new ArrayList<>();
		
		for (Spedizione si : this.spedizioni) {
			if (si.dataConsegna.equals(dataConsegna)) {
				ss.add(si);
			}
		}
		
		return ss;
	}

	public void assegnaSpedizione(Spedizione s) {
		this.spedizioni.add(s);
	}
}
