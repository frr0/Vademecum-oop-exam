package casaeditrice;

import java.util.*;

public class Autore{
	private String nome;
	private String cognome;
	private String email;
	private int codice;
	private ArrayList<Pubblicazione> pubblicazioni;
	
	

	public Autore(String nome, String cognome, String email, int codice) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.codice = codice;
		this.pubblicazioni = new ArrayList<Pubblicazione>();
	}

	public String getNome(){
		return this.nome;
	}

	public String getCognome(){
		return this.cognome;
	}

	public String getEmail(){
		return this.email;
	}
	
	public int getCodice(){
		return this.codice;
	}
	
	public Pubblicazione aggiungiPubblicazione(String titolo, char tipologia, String volume, int anno, int contributo) {
		switch(tipologia) {
		case 'P':
			Pubblicazione p = new Pubblicazione(titolo, volume, anno, this, contributo);
			this.pubblicazioni.add(p);
			return p;
		case 'R':
			Rivista r = new Rivista(titolo, volume, anno, this, contributo);
			this.pubblicazioni.add(r);
			return r;
		case 'C':
			Conferenza c = new Conferenza(titolo, volume, anno, this, contributo);
			this.pubblicazioni.add(c);
			return c;
			default:
				break;
		}
		return null;
	}
	
	public Collection<Pubblicazione> elencoPubblicazioni(){
		Collections.sort(this.pubblicazioni, Pubblicazione.comparatorAnno);
		return this.pubblicazioni;
	}
	
	public static Comparator<Autore> comparatorCognomeNome = new Comparator<Autore>() {
		public int compare(Autore a1, Autore a2) {
			int compareCognome = a1.getCognome().compareToIgnoreCase(a2.getCognome());
			if (compareCognome == 0) {
				return a1.getNome().compareToIgnoreCase(a1.getNome());
			} else {
				return compareCognome;
			}
		}
	};
	
}
