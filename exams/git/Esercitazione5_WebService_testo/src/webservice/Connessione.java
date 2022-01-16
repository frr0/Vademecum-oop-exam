package webservice;

public class Connessione {
	private Utente utente;
	private String timestampLogin;
	private String timestampLogout;

	public Connessione(Utente utente, String timestampLogin) {
		this.utente = utente;
		this.timestampLogin = timestampLogin;
		this.timestampLogout = null;
	}
	
	public Utente getUtente() {
		return utente;
	}

	public String getTimestampLogin() {
		return timestampLogin;
	}

	public String getTimestampLogout() {
		return timestampLogout;
	}

	public void setTimestampLogout(String timestampLogout) {
		this.timestampLogout = timestampLogout;
	}
	
	public boolean isConnected() {
		if (this.timestampLogout == null) {
			return true;
		} else {
			return false;
		}
	}

	
}
