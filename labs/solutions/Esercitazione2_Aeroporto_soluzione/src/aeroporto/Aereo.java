package aeroporto;

public class Aereo {
	
	int id;
	String modello;
	int capienza;
	int chilometriAutonomia;
	Viaggio viaggio;
	
	public Aereo(int id, String modello, int capienza, int chilometriAutonomia) {
		this.id = id;
		this.modello = modello;
		this.capienza = capienza;
		this.chilometriAutonomia = chilometriAutonomia;
	}
	
	public void setViaggio(Viaggio viaggio) {
		this.viaggio = viaggio;
	}
	
	public Viaggio getViaggio() {
		return this.viaggio;
	}

}
