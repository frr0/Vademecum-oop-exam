package aeroporto;

public class Viaggio {
	String nomeTratta;
	int numeroPasseggeri;
	int chilometriTratta;
	int id;
		
	public Viaggio(String nomeTratta, int numeroPasseggeri, int chilometriTratta, int id) {
		this.nomeTratta = nomeTratta;
		this.numeroPasseggeri = numeroPasseggeri;
		this.chilometriTratta = chilometriTratta;
		this.id = id;
	}
	
	public String stampaViaggio() {
		return this.id + ";" + this.nomeTratta + ";" + this.numeroPasseggeri + ";" + this.chilometriTratta;
	}
}
