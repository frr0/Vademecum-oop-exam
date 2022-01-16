package campionati;

public class Squadra {
	private String nome;
	private String stadio;
	private String presidente;
	
	public Squadra(String nome, String stadio, String presidente) {
		this.nome = nome;
		this.stadio = stadio;
		this.presidente = presidente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStadio() {
		return stadio;
	}

	public void setStadio(String stadio) {
		this.stadio = stadio;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
	
	
}
