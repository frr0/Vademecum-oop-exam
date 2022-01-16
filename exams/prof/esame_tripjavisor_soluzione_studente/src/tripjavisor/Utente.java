package tripjavisor;


public class Utente implements Comparable<Utente>{
	
	private String username;
	private int punteggio=0;
	

	public Utente(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void aggiornaPunteggio(boolean miPiace) {
		if(miPiace==true)
			punteggio++;
		else
			punteggio--;
	}

	public int compareTo(Utente u) {
		return -(this.punteggio-u.getPunteggio());
	}
}
