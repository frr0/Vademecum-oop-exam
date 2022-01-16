package piano_vaccinazioni;

public class Richiamo extends Vaccinazione{

	public Richiamo(char tipo, Cittadino cittadino, Centro centro, String data) {
		super(tipo, cittadino, centro, data);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString() + " (R)";
	}

}
