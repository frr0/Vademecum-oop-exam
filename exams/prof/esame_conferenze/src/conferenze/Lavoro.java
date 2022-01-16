package conferenze;

import java.util.Collection;
import java.util.LinkedList;

public class Lavoro implements Comparable<Lavoro> {
	private String titolo;
	private String id;
	private Conferenza conferenza;
	private Utente  utente;
	private LinkedList<Utente> autori;
	private LinkedList<Integer> revisioni;
	
	

	public Lavoro(String titolo, String id, Conferenza conferenza, Utente utente) {
		this.titolo = titolo;
		this.id = id;
		this.conferenza = conferenza;
		this.utente=utente;
		autori=new LinkedList<Utente>();
		autori.add(utente);
		revisioni=new LinkedList<Integer>();
	}

	public String getTitolo() {
		return titolo;
	}

	public String getId() {
		return id;
	}

	public double calcolaPunteggioMedio(){
		int punteggio=0;
		for(Integer i:revisioni)
			punteggio=punteggio+i;
		double ritorno=punteggio/(revisioni.size()+0.0);
		return ritorno;
	}

	public void aggiungiAutore(Utente utente) {
		autori.add(utente);
	}

	public Collection<Utente> collezioneAutori() {
		
		return autori;
	}

	public void aggiungiRevisione(int punteggio) {
		revisioni.add(punteggio);
		
	}

	
	public int compareTo(Lavoro arg0) {
		if(this.calcolaPunteggioMedio()>arg0.calcolaPunteggioMedio())
			return -1;
		if(this.calcolaPunteggioMedio()<arg0.calcolaPunteggioMedio())
			return 1;
		
		return 0;
	}

}
