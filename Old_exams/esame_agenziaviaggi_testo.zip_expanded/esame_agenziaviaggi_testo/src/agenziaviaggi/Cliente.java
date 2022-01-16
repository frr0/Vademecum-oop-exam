package agenziaviaggi;

import java.util.*;

public class Cliente implements Comparable<Cliente>{
	private String cognome;
	private String nome;
	private String indirizzo;
	private ArrayList<String> contatti;
	private ArrayList<Pratica> pratiche;
	
	public Cliente(String cognome, String nome, String indirizzo) {
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.contatti = new ArrayList<String>();
		this.pratiche = new ArrayList<Pratica>();
	}

	public String getCognome(){
		return this.cognome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getIndirizzo(){
		return this.indirizzo;
	}

	public void aggiungiContatto(String contatto){
		for (String c: this.contatti) {
			if (c.contentEquals(contatto)) {
				return;
			}
		}
		contatti.add(contatto);
	}
	
	public int compareTo(Cliente c2) {
		int compareCognome = this.cognome.compareToIgnoreCase(c2.getCognome());
		int compareNome = this.nome.compareToIgnoreCase(c2.getNome());
		
		if (compareCognome == 0) {
			if (compareNome == 0){
				return this.indirizzo.compareToIgnoreCase(c2.getIndirizzo());
			} else {
				return compareNome;
			}
		} else {
			return compareCognome;
		}
	}
	
	public void addPratica(Pratica pratica) {
		this.pratiche.add(pratica);
	}
	
	public void removePratica(Pratica pratica) {
		this.pratiche.remove(pratica);
	}
	public Collection<String> elencoContatti(){
		return this.contatti;
	}

	public Collection<Pratica> elencoPratiche(){
		Collections.sort(this.pratiche);
		return this.pratiche;
	}
	
	public double getImportoTotale() {
		double res = 0;
		for (Pratica p: this.pratiche) {
			res += p.getImportoTotale();
		}
		return res;
	}
}
