package network_professionisti;

import java.util.*;

public class Iscritto {

	private String id;
	
	private String nome;
	private String cognome;
	private String web;
	private String email;
	private String descrizione;

	LinkedList<Periodo> listaPeriodiDiFormazione = new LinkedList<Periodo>();
	LinkedList<Periodo> listaPeriodiInAzienda = new LinkedList<Periodo>();
	
	TreeMap<String, Iscritto> mappaConnessioni = new TreeMap<String, Iscritto>();
	
	
	public Iscritto(String id, String nome, String cognome, String web, String email, String descrizione) {
		this.id=id;
		this.nome=nome;
		this.cognome=cognome;
		this.web=web;
		this.email=email;
		this.descrizione=descrizione;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getWeb() {
		return web;
	}

	public String getEmail() {
		return email;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public void nuovoPeriodoDiFormazione(Entita enteFormazione,String da, String a, String titolo) {
		Periodo ptemp = new Periodo(enteFormazione, da, a, titolo);
		listaPeriodiDiFormazione.add(ptemp);
	}

	public void nuovoPeriodoInAzienda(Entita azienda,String da, String a, String ruolo) {
		Periodo ptemp = new Periodo(azienda, da, a, ruolo);
		listaPeriodiInAzienda.add(ptemp);
	}
	
	public void nuovaConnessione(Iscritto iscritto) {
		mappaConnessioni.put(iscritto.getId(), iscritto);
	}

    
	
}
