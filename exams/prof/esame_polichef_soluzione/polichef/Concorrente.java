package polichef;

public class Concorrente {

	private String nome;
	private String cognome;
	private String professione;
	private String id;
	
	public Concorrente(String nome, String cognome, String professione) {
		this.nome = nome;
		this.cognome=cognome;
		this.professione = professione;
		this.id = ""+nome+" "+cognome.charAt(0)+".";
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getProfessione() {
		return professione;
	}

	public String getId() {
		return id;
	}
	
}
