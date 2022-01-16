package tennis;

public class Giocatore {

	private String  nome;
	private String  cognome;
	private Squadra squadra;

	public Giocatore(String nome, String cognome, Squadra squadra){
		this.nome=nome;
		this.cognome=cognome;
		this.squadra=squadra;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public String toString(){
		return ""+nome+" "+cognome+" ("+squadra+")";
	}

}
