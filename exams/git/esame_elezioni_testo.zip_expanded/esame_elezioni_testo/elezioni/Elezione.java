package elezioni;

import java.util.*;

public class Elezione {
	
	private ArrayList<Cittadino> cittadini;
	private ArrayList<Lista> liste;

	public Elezione(){
		this.cittadini = new ArrayList<Cittadino>();
		this.liste = new ArrayList<Lista>();
	}
	
	public Cittadino aggiungiElettore(String nome, String cognome){
		Cittadino nuovoCittadino = new CittadinoReal(nome, cognome);
		this.cittadini.add(nuovoCittadino);
		return nuovoCittadino;
	}
	
	public Collection getElettori(){
		return this.cittadini;
	}
	
	public Cittadino getElettore(String nome, String cognome){
		for (Cittadino c: this.cittadini) {
			if(c.getNome().contentEquals(nome) && c.getCognome().contentEquals(cognome)) {
				return c;
			}
		}
		return null;
	}
	
	public void registraLista(Lista lista){
		this.liste.add(lista);
	}
	
	public Lista cercaLista(String nome) {
		for (Lista l: this.liste) {
			if (l.getNome().contentEquals(nome)) {
				return l;
			}
		}
		return null;
	}

	public void vota(Cittadino votante, String lista, String nome, String cognome)
		throws TentatoDoppioVoto, TaglioNonPermesso{
		
		if (votante.haVotato()) {
			throw new TentatoDoppioVoto();
		}
		
		Lista l = this.cercaLista(lista);
		Cittadino candidato = this.getElettore(nome, cognome);
		
		if (l == null || candidato == null || !candidato.isCandidato()) {
			return;
		}
		
		if (l.getCandidati().contains(candidato)) {
			votante.vota();
			candidato.addVoto();
		} else {
			throw new TaglioNonPermesso();
		}
	}

	public void vota(Cittadino votante, String lista)
		throws TentatoDoppioVoto{
		if (votante.haVotato()) {
			throw new TentatoDoppioVoto();
		}
		
		Lista l = this.cercaLista(lista);
		if (l == null) {
			return;
		}
		
		Cittadino candidato = l.getCapolista();
		
		votante.vota();
		candidato.addVoto();
	}
	
	public long getNumeroVotanti(){
		long counter = 0;
		for (Cittadino c: this.cittadini) {
			if (c.haVotato()) {
				counter++;
			}
		}
		return counter;
	}
	
	public Collection getRisultatiListe(){
		Collections.sort(this.liste, Lista.comparatorVoti);
		return this.liste;
	}

	public Collection getRisultatiCandidati(){
		ArrayList<Cittadino> candidati = new ArrayList<Cittadino>();
		for (Cittadino c: this.cittadini) {
			if (c.isCandidato()) {
				candidati.add(c);
			}
		}
		
		Collections.sort(candidati, Elezione.comparatorVoti);
		return candidati;
	}
	
	public static Comparator<Cittadino> comparatorVoti = new Comparator<Cittadino>() {
		public int compare(Cittadino c1, Cittadino c2) {
			return (int) (c2.getNumeroVoti() - c1.getNumeroVoti());
		}
	};

	
	
}
