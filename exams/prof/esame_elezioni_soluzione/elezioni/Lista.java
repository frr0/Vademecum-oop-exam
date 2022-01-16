package elezioni;

import java.util.*;

public class Lista implements Comparable<Lista>{

	private String nome;
	private String motto;
	
	private Cittadino capolista;
	
	private int numeroVoti=0;
	
	private Map<String,Cittadino> candidati = new HashMap<String,Cittadino>();
	
	Elezione e;
	
	public Lista(String nome, String motto){
		this.nome=nome;
		this.motto=motto;
	}

	public void setElezione(Elezione e){
		this.e=e;
	}
	
	
	public String getNome(){
		return nome;
	}

	public String getMotto(){
		return motto;
	}
	
	public void assegnaCapolista(Cittadino capolista)
			throws CandidatoNonValido {
		
		Elettore e = (Elettore)capolista;
		if(e.isCandidato())
			throw new CandidatoNonValido();
		
		// Se sono qui il capolista è valido
		this.capolista=capolista;
		
		// Imposto anche gli attributi isCapolista e isCandidato
		e.setIsCandidato(true);
		e.setIsCapolista(true);
		
	}

	public void aggiungiCandidato(Cittadino c)
			throws CandidatoNonValido {
		
		Elettore e = (Elettore)c;
		if(e.isCandidato())
			throw new CandidatoNonValido();
		
		// Se sono qui significa che il candidato è valido
		candidati.put( c.getNome()+" "+c.getCognome() , c);
		
		// Imposto anche l'attributo ilCandidato
		e.setIsCandidato(true);
		
	}

	public Cittadino getCapolista(){
		return capolista;
	}

	public Collection getCandidati(){
		return candidati.values(); 
		// Restuisce la collezione dei candidati (non include il capolista)
	}
	
	public long getNumeroVoti(){
		return numeroVoti;
	}
	
	public void addVoto(){
		this.numeroVoti++;
	}

	public Elettore getElettore(String nome, String cognome){
		Elettore c = (Elettore)candidati.get(nome+" "+cognome);
		
		if(c!=null)
			return c;
		else
		{
		    if(capolista.getNome().equals(nome) &&
		       capolista.getCognome().equals(cognome))
		    	return (Elettore)capolista;
		}
		
		return null;
	}
	
	public double getPercentualeVoti(){
		return (double)this.numeroVoti/(double)e.numeroVotanti;
	}

	public int compareTo(Lista altra) {
		
		return -(this.numeroVoti-(int)altra.getNumeroVoti());
	}
}
