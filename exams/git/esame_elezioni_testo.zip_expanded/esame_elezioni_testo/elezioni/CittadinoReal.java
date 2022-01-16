package elezioni;

public class CittadinoReal implements Cittadino{
	
	private String nome;
	private String cognome;
	private boolean haVotatoV;
	private boolean capolista;
	private boolean candidato;
	private int numeroVoti;
	
	public CittadinoReal(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.haVotatoV = false;
		this.capolista = false;
		this.candidato = false;
		this.numeroVoti = 0;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getCognome() {
		return this.cognome;
	}

	@Override
	public boolean haVotato() {
		return this.haVotatoV;
	}

	@Override
	public boolean isCapolista() {
		return this.capolista;
	}
	
	public void setCapolista(boolean b) {
		this.capolista = b;
	}

	@Override
	public boolean isCandidato() {
		return this.candidato;
	}

	public void setCandidato(boolean b) {
		this.candidato = b;
	}
	@Override
	public long getNumeroVoti() {
		return this.numeroVoti;
	}

	public void vota() {
		this.haVotatoV = true;
	}

	@Override
	public void addVoto() {
		this.numeroVoti++;
	}

}
