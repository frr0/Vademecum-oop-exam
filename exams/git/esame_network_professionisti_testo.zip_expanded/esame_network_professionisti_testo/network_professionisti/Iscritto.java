package network_professionisti;

import java.util.*;

public class Iscritto {
	private String id;
	private String nome;
	private String cognome;
	private String web;
	private String email;
	private String descrizione;
	
	private ArrayList<Periodo> periodi;
	private ArrayList<Iscritto> connessi;
	
	

	public Iscritto(String id, String nome, String cognome, String web, String email, String descrizione) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.web = web;
		this.email = email;
		this.descrizione = descrizione;
		this.periodi = new ArrayList<Periodo>();
		this.connessi = new ArrayList<Iscritto>();
	}

	public String getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public String getWeb() {
		return this.web;
	}

	public String getEmail() {
		return this.email;
	}

	public String getDescrizione() {
		return this.descrizione;
	}
	
	public void addPeriodo(Entita e, String da, String a, String titolo) {
		this.periodi.add(new Periodo(e, da, a, titolo));
	}
	
	public ArrayList<Periodo> getPeriodi(){
		return this.periodi;
	}
	
	public ArrayList<Periodo> getPeriodiAzienda(){
		ArrayList<Periodo> res = new ArrayList<Periodo>();
		for (Periodo p: this.periodi) {
			if (p.getEntita().getTipologia() == 'A') {
				res.add(p);
			}
		}
		return res;
	}
	
	public ArrayList<Periodo> getPeriodiCentro(){
		ArrayList<Periodo> res = new ArrayList<Periodo>();
		for (Periodo p: this.periodi) {
			if (p.getEntita().getTipologia() == 'C') {
				res.add(p);
			}
		}
		return res;
	}
	
	public boolean isConnesso(Iscritto i) {
		return this.connessi.contains(i);
	}
	public void addConnessione(Iscritto i) {
		this.connessi.add(i);
	}
	public ArrayList<Iscritto> getConnessi() {
		return this.connessi;
	}
	
	
}
