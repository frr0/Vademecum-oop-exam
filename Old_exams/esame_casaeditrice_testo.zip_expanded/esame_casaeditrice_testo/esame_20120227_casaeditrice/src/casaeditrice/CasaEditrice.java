package casaeditrice;

import java.util.*;
import java.io.*;

public class CasaEditrice {
	private ArrayList<Autore> autori;
	private int prossimoCodice;
	
	
	public CasaEditrice() {
		this.autori = new ArrayList<Autore>();
		this.prossimoCodice = 10000;
	}

	public Autore definisciAutore(String nome, String cognome, String email){
		Autore nuovoAutore = new Autore(nome, cognome, email, this.prossimoCodice);
		this.autori.add(nuovoAutore);
		this.prossimoCodice++;
		return nuovoAutore;
	}
	
	public Collection<Autore> elencoAutori(){
		Collections.sort(this.autori, Autore.comparatorCognomeNome);
		return this.autori;
	}
	
	public Autore getAutore(int codice){
		for (Autore a: this.autori) {
			if (a.getCodice() == codice) {
				return a;
			}
		}
		return null;
    }

	public Autore getAutore(String nome, String cognome){
		for (Autore a: this.autori) {
			if (a.getCognome().contentEquals(cognome) &&
					a.getNome().contentEquals(nome)) {
				return a;
			}
		}
     	return null;
	}

	public Collection<Pubblicazione> pubblicazioniAutore(String nome, String cognome) throws AutoreInesistenteException {
		Autore questoAutore = this.getAutore(nome, cognome);
		if (questoAutore == null) {
			throw new AutoreInesistenteException();
		}
		ArrayList<Pubblicazione> res = new ArrayList<Pubblicazione>();
		for (Autore a: this.autori) {
			for (Pubblicazione p: a.elencoPubblicazioni()) {
				for (Autore a2: p.elencoAutori()) {
					if (questoAutore.getCodice() == a2.getCodice()) {
						res.add(p);
					}
				}
			}
		}
		Collections.sort(res, Pubblicazione.comparatorAnno);
		return res;
	}
	
	public void leggiPubblicazioni(String nomeFile) throws IOException {
	}

}
