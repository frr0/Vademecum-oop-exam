package elezioni;

public class Elettore implements Cittadino, Comparable{

	private String nome;
	private String cognome;
	boolean haVotato;
	boolean isCapolista;
	boolean isCandidato;
	int numeroVoti;
	
	public Elettore(String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
		haVotato=false;
		isCapolista=false;
		isCandidato=false;
		numeroVoti=0;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public boolean haVotato() {
		return haVotato;
	}

	public boolean isCapolista() {
		return isCapolista;
	}

	public boolean isCandidato() {
		return isCandidato;
	}

	public long getNumeroVoti() {
		return numeroVoti;
	}
	
	public void setIsCapolista(boolean isCapolista){
		this.isCapolista=isCapolista;
	}

	public void setIsCandidato(boolean isCandidato){
		this.isCandidato=isCandidato;
	}
	
	public void setHaVotato(boolean haVotato){
		this.haVotato=haVotato;
	}
	
	public void addVoto(){
		this.numeroVoti++;
	}
	
    public int compareTo(Object o) {
      	Elettore other = (Elettore)o;
        return other.numeroVoti - this.numeroVoti;
      }
	
	
}
