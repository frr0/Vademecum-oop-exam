package tripjavisor;

import java.util.*;


public class Recensione {
	
	private int codice;
	private String data;
	private String titolo;
	private String testo;
	private double votoHotel;
	private Utente utente;
	private Hotel hotel;
	private Map<String,Utente> utentiReazione;
	
	
	public Recensione(int codice, String data, String titolo, String testo,
			double voto, Utente utente, Hotel hotel) {
		super();
		this.codice = codice;
		this.data = data;
		this.titolo = titolo;
		this.testo = testo;
		this.votoHotel = voto;
		this.utente = utente;
		this.hotel = hotel;
		utentiReazione = new TreeMap<String,Utente>();
	}

	public String getData() {
		return data;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getTesto() {
		return testo;
	}

	public double getVoto() {
		return votoHotel;
	}

	public int getCodice() {
		return codice;
	}
	
	public Utente getUtente() {
		return utente;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Map<String, Utente> getUtentiReazione() {
		return utentiReazione;
	}

	public void addReazione(Utente u, boolean miPiace) {
		if((u.getUsername().compareTo(utente.getUsername())==0) || (utentiReazione.keySet().contains(u.getUsername())))
			return;
		
		utentiReazione.put(u.getUsername(), u);
		this.utente.aggiornaPunteggio(miPiace);
	}
}
