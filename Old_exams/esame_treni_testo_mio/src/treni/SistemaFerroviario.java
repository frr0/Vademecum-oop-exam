package treni;

import java.util.*;

public class SistemaFerroviario {
	
	private ArrayList<Linea> linee;
	private ArrayList<Stazione> stazioni;
	private ArrayList<Treno> treni;
	private ArrayList<Biglietto> biglietti;
	private int prossimoBiglietto = 10000;
	
	public SistemaFerroviario() {
		this.linee = new ArrayList<Linea>();
		this.stazioni = new ArrayList<Stazione>();
		this.treni = new ArrayList<Treno>();
		this.biglietti = new ArrayList<Biglietto>();
		
	}

	public void nuovaLinea(String nomeLinea) {
		String[] stazioni = nomeLinea.split("-");
		this.linee.add(new Linea(stazioni[0], stazioni[1]));
	}
	
	public Linea cercaLinea(String nomeLinea) {
		for (Linea l: this.linee) {
			if (l.toString().contentEquals(nomeLinea) || l.reverseToString().contentEquals(nomeLinea)) {
				return l;
			}
		}
		return null;
		
	}
	
	public Stazione cercaStazione(String nomeStazione) {
		for (Stazione s: this.stazioni) {
			if (s.getNome().contentEquals(nomeStazione)) {
				return s;
			}
		}
		return null;
	}
	
	public Stazione nuovaStazione(String nomeStazione, String nomeLinea, String chilometro){
		Linea l = this.cercaLinea(nomeLinea);
		if (l == null) {
			this.nuovaLinea(nomeLinea);
			l = this.cercaLinea(nomeLinea);
		}
		Stazione s = new Stazione(nomeStazione, chilometro, l);
		this.stazioni.add(s);
		return s;
	}
	
	public String lunghezzaLinea(String nomeLinea){
		Linea l = this.cercaLinea(nomeLinea);
		if (l == null) {
			return "-1+0";
		} 
		ArrayList<Stazione> stazioniLinea = new ArrayList<Stazione>();
		for (Stazione s: this.stazioni) {
			if (s.getNomeLinea().contentEquals(l.toString())) {
				stazioniLinea.add(s);
			}
		}
		Collections.sort(stazioniLinea, Stazione.comparatorDistanza);
		return stazioniLinea.get(stazioniLinea.size() - 1).getChilometro();
	}

	public Collection<Stazione> elencoStazioni(){
		Collections.sort(this.stazioni, Stazione.comparatorAlfabetico);
		return this.stazioni;
	}

	public Collection<Stazione> elencoStazioni(String direzione){
		Linea l = this.cercaLinea(direzione);
		if (l == null) {
			return null;
		} 
		ArrayList<Stazione> stazioniLinea = new ArrayList<Stazione>();
		for (Stazione s: this.stazioni) {
			if (s.getNomeLinea().contentEquals(l.toString())) {
				stazioniLinea.add(s);
			}
		}
		Collections.sort(stazioniLinea, Stazione.comparatorDistanza);
		if (direzione.contentEquals(l.reverseToString())) {
			Collections.reverse(stazioniLinea);
		}
		return stazioniLinea;
	}
	
	public void nuovoTreno(int numero, String tipologia, String nomeLinea){
		Linea l = this.cercaLinea(nomeLinea);
		if (l == null) {
			return;
		}
		
		Treno provTreno = new Treno(numero, tipologia, null);
		for (Treno t: this.treni) {
			if (provTreno.equals(t)) {
				return;
			}
		}
		
		switch (tipologia.charAt(0)) {
		case 'R':
			this.treni.add(new TrenoRegionale(numero, l));
			return;
		case 'I':
			this.treni.add(new TrenoInterregionale(numero, l));
			return;
		case 'A':
			this.treni.add(new TrenoAltaVelocita(numero, l));
			return;
		default:
			return;
		}
		
	}
	
	public Treno treno(int numeroTreno, String tipologia){
		Treno provTreno = new Treno(numeroTreno, tipologia, null);
		for (Treno t: this.treni) {
			if (provTreno.equals(t)) {
				return t;
			}
		}
		return null;
	}
	
	public void aggiungiFermata(int numeroTreno, String tipologia, String nomeStazione, String ora){
		Treno t = this.treno(numeroTreno, tipologia);
		Stazione s = this.cercaStazione(nomeStazione);
		
		if (t == null || s == null) {
			return;
		}
		
		t.aggiungiFermata(ora, s);
	}

	public Collection<Treno> cerca(String nomeStazionePartenza, String nomeStazioneArrivo) {
		Stazione s1 = this.cercaStazione(nomeStazionePartenza);
		Stazione s2 = this.cercaStazione(nomeStazioneArrivo);
		
		if (s1 == null || s2 == null) {
			return null;
		}
		
		ArrayList<Treno> treniScelti = new ArrayList<Treno>();
		
		for (Treno t: this.treni) {
			if (t.viaggiaTra(s1, s2)) {
				treniScelti.add(t);
			}
		}
		if (treniScelti.size() == 0) {
			return null;
		}
		return treniScelti;
	}
	
	public Biglietto emettiBiglietto(String nomeStazionePartenza, String nomeStazioneArrivo, String data, int numeroTreno, String tipologia) throws PostiEsauritiException{
		Stazione s1 = this.cercaStazione(nomeStazionePartenza);
		Stazione s2 = this.cercaStazione(nomeStazioneArrivo);
		Treno t = this.treno(numeroTreno, tipologia);
		
		if (t == null || this.cerca(nomeStazionePartenza, nomeStazioneArrivo) == null || !this.cerca(nomeStazionePartenza, nomeStazioneArrivo).contains(t)) {
			return null;
		}
		if (tipologia.contentEquals("AV")) {
			TrenoAltaVelocita tav = (TrenoAltaVelocita) t;
			int pr = tav.getPostiRimanenti();
			if (pr > 0) {
				Biglietto b = new Biglietto(this.prossimoBiglietto, s1, s2, data, tav);
				tav.setPostiRimanenti(pr - 1);
				this.prossimoBiglietto++;
				return b;
			} else {
				throw new PostiEsauritiException();
			}
		} else {
			Biglietto b = new Biglietto(this.prossimoBiglietto, s1, s2, data, t);
			this.prossimoBiglietto++;
			return b;
		}
	}
}
