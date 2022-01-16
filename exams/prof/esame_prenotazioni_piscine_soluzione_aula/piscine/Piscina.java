package piscine;
import java.util.*;

public class Piscina {

	String codice;
	String indirizzo;
	int numPostiBordoPiscina;
	int numPostiPrato;
	int maxOccupantiPosto;
	
	TreeMap<String, Posto> mappaPosti = new TreeMap<String, Posto>();
	LinkedList<Posto> listaPostiBordo = new LinkedList<Posto>();
	LinkedList<Posto> listaPostiPrato = new LinkedList<Posto>();
	
	LinkedList<Prenotazione> listaPrenotazioni = new LinkedList<Prenotazione>();
	TreeMap<String,Prenotazione> mappaPrenotazioni = new TreeMap<String, Prenotazione>();
	
	public Piscina(String codice, String indirizzo, int numPostiBordoPiscina, int numPostiPrato, int maxOccupantiPosto) {
		this.codice = codice;
		this.indirizzo = indirizzo;
		this.numPostiBordoPiscina = numPostiBordoPiscina;
		this.numPostiPrato = numPostiPrato;
		this.maxOccupantiPosto = maxOccupantiPosto;
		
		// Creo i posti con la creazione della piscina
		
		for(int i=1; i<=numPostiBordoPiscina; i++) {
			PostoBordo p = new PostoBordo("B"+i);
			mappaPosti.put("B"+i, p);
			listaPostiBordo.add(p);
		}
		
		for(int i=1; i<=numPostiPrato; i++) {
			PostoPrato p = new PostoPrato("P"+i);
			mappaPosti.put("P"+i, p);
			listaPostiPrato.add(p);
		}
		
	}

	public String getCodice() {
		return codice;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public int getNumPostiBordoPiscina() {
		return numPostiBordoPiscina;
	}

	public int getNumPostiPrato() {
		return numPostiPrato;
	}

	public int getMaxOccupantiPosto() {
		return maxOccupantiPosto;
	}

}
