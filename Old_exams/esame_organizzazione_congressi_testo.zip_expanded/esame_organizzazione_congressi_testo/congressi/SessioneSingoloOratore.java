package congressi;

public class SessioneSingoloOratore extends Sessione{
	
	private String oratore;

	public SessioneSingoloOratore(int numeroSeriale, Congresso congresso, Sala sala, String nome, String data,
			String daOra, String adOra) {
		super(numeroSeriale, congresso, sala, nome, data, daOra, adOra);
		// TODO Auto-generated constructor stub
	}
	
	public void allocaOratore(String cognomeNome) {
		this.oratore = cognomeNome;
	}
	
	public String getOratore() {
		return this.oratore;
	}
}
