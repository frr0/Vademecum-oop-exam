package agenziaviaggi;

import java.util.*;

public class Pratica implements Comparable<Pratica>{
	private int idPratica;
	private String descrizione;
	private ArrayList<Prenotazione> prenotazioni;
	
	public Pratica(int id, String descrizione) {
		this.idPratica = id;
		this.descrizione = descrizione;
		this.prenotazioni = new ArrayList<Prenotazione>();
	}

	public int getIdPratica(){
		return this.idPratica;
	}
	
	public String getDescrizione(){
		return this.descrizione;
	}
	
	public void aggiungiPrenotazione(Prenotazione prenotazione){
		this.prenotazioni.add(prenotazione);
	}
	
	public double getImportoTotale(){
		double res = 0;
		for (Prenotazione p: this.prenotazioni) {
			res += p.getImporto();
		}
		return res;
	}
	
	public int compareTo(Pratica p2) {
		double diff = this.getImportoTotale() - p2.getImportoTotale();
		if (diff > 0){
			return -1;
		} else if (diff < 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public Collection<Prenotazione> elencoPrenotazioniPerImporto()
	{
		Collections.sort(this.prenotazioni, Prenotazione.importoComparator);
		return this.prenotazioni;
	}

	public Collection<Prenotazione> elencoPrenotazioniPerData()
	{
		Collections.sort(this.prenotazioni, Prenotazione.dataComparator);
		return this.prenotazioni;
	}
}
