package elezioni;

import java.util.*;

public class Lista {
	
	private String nome;
	private String motto;
	private Cittadino capolista;
	private List<Cittadino> candidati;

	public Lista(String nome, String motto){
		this.nome = nome;
		this.motto = motto;
		this.capolista = null;
		this.candidati = new ArrayList<Cittadino>();
	}
	
	public String getNome(){
		return this.nome;
	}

	public String getMotto(){
		return this.motto;
	}
	
	public void assegnaCapolista(Cittadino capolista)
			throws CandidatoNonValido {
		if(!capolista.isCandidato()) {
			this.capolista = capolista;
			capolista.setCapolista(true);
			capolista.setCandidato(true);
		} else {
			throw new CandidatoNonValido();
		}
	}

	public void aggiungiCandidato(Cittadino capolista)
			throws CandidatoNonValido {
		if(!capolista.isCandidato()) {
			this.candidati.add(capolista);
			capolista.setCandidato(true);
		} else {
			throw new CandidatoNonValido();
		}
		
	}

	public Cittadino getCapolista(){
		return this.capolista;
	}

	public Collection getCandidati(){
		return this.candidati; // Restuisce la collezione dei candidati (non include il capolista)
	}
	
	public long getNumeroVoti(){
		long counter = this.capolista.getNumeroVoti();
		for (Cittadino c: this.candidati) {
			counter += c.getNumeroVoti();
		}
		return counter;
	}

	public double getPercentualeVoti(){
		return -1.1;
	}
	
	public static Comparator<Lista> comparatorVoti = new Comparator<Lista>() {
		public int compare(Lista l1, Lista l2) {
			return (int) (l2.getNumeroVoti() - l1.getNumeroVoti());
		}
	};
}
