package webservice;
import java.util.ArrayList;
import java.util.Collections;

public class WebService {
	ArrayList<Utente> utenti;
	ArrayList<Connessione> connessioni;

	public WebService(){
		this.utenti = new ArrayList<>();
		this.connessioni = new ArrayList<>();
	}

	public Utente registraUtente(String nome, String cognome, String email, String password, String dataNascita) {
		/*
		 * si assuma per semplicità che un’email sia valida qualora contenga il
		 * carattere @
		 */		
		boolean mailValida = email.contains("@");
		/*
		 * non sia già presente fra quelle degli utenti registrati
		 */		
		int iEmail = 0;
		boolean mailUnica = true;
		for (Utente utente: this.utenti) {
			if (utente.getEmail().contentEquals(email)){
				mailUnica = false;
				break;
			}
			iEmail++;
		}
		/*
		 * password sia valida, ovvero che sia lunga non meno di 8 caratteri e che
		 * contenga almeno un carattere maiuscolo e un numero
		 */		
		boolean passwordLunghezza = password.length() >= 8;
		boolean passwordMaiuscola = false;
		boolean passwordNumero = false;
		for (int i=0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))){
				passwordMaiuscola = true;
			} else if (Character.isDigit(password.charAt(i))) {
				passwordNumero = true;
			}
		}


		if (mailValida && mailUnica && passwordLunghezza && passwordMaiuscola && passwordNumero) {
			/*
			 * nel caso di nuova registrazione, il valore di ritorno sarà invece
			 * rappresentato da un oggetto rappresentante il nuovo utente, della tipologia
			 * appropriata e con password a null.
			 */
			if (utenti.size() == 0) {
				utenti.add(new Admin(nome, cognome, email, password, dataNascita));
				Admin noPwAdmin = new Admin(nome, cognome, email, null, dataNascita);
				return noPwAdmin;
			} else {
				utenti.add(new Acquirente(nome, cognome, email, password, dataNascita));
				Acquirente noPwAcquirente = new Acquirente(nome, cognome, email, null, dataNascita);
				return noPwAcquirente;
			}
		} else {
			if (!mailUnica) {
				/*
				 * Nel caso di utente già registrato, il metodo restituisce un oggetto
				 * corrispondente all’utente registrato
				 */				
				return utenti.get(iEmail);
			} else {
				/*
				 * In caso di password o di email non valide, il metodo non sortirà alcun
				 * effetto ed il valore di ritorno sarà null
				 */				
				return null;
			}
		}
	}

	public Utente cercaUtente(String email) {
		/*
		 * Attraverso il metodo cercaUtente() è possibile cercare un certo utente fra
		 * quelli registrati; il metodo riceve come parametro l’email dell’utente da
		 * cercare e ritorna l’utente desiderato se esistente, null altrimenti.
		 */		
		for (Utente utente: this.utenti) {
			if (utente.getEmail().contentEquals(email)){
				return utente;
			}
		}
		return null;
	}

	public Utente loginUtente(String email, String password, String timestamp) {
		Utente questoUtente = this.cercaUtente(email);
		boolean utenteConnesso = false;

		if (questoUtente != null) {
			if (questoUtente.getPassword().contentEquals(password)) {
				for (Connessione conn: connessioni) {
					if (conn.getUtente().equals(questoUtente) && conn.isConnected()) {
						utenteConnesso = true;
					}
				}
				if (!utenteConnesso) {
					connessioni.add(new Connessione(questoUtente, timestamp));
					return connessioni.get(connessioni.size() - 1).getUtente();
				}
			} else {
				return null;
			}

		}
		/*		
		 * 		in caso di utente non registrato, di password non corrispondente a quella impostata in fase di registrazione 
		 * 		o di utente già  connesso, il metodo restituisce null
		 */	
		return null;
	}

	public Utente logoutUtente(String email, String timestamp) {
		Utente questoUtente = this.cercaUtente(email);
		/*
		 * controlla che l’utente esista e che l’utente non sia disconnesso
		 */
		if (questoUtente != null) {
			for (Connessione conn: this.connessioni) {
				if (conn.getUtente().equals(questoUtente) && conn.isConnected()) {
					conn.setTimestampLogout(timestamp);
					return conn.getUtente();
				}
			}
		}
		return null;
	}

	public Utente verificaConnessioneUtente(String email) {
		Utente questoUtente = this.cercaUtente(email);
		if (questoUtente != null) {
			for (Connessione conn: this.connessioni) {
				if (conn.getUtente().equals(questoUtente) && conn.isConnected()) {
					return conn.getUtente();
				}
			}
		}
		return null;
	}

	public Utente eliminaUtente(String email, String password, String emailUtenteDaEliminare ) {
		/*
		 * Il metodo verifica l’esistenza degli utenti, la correttezza della password, i
		 * permessi lo stato di connessione dell’utente che sta effettuando la richiesta
		 * di eliminazione: affinché l’operazione possa andare a buon fine è necessario
		 * infatti che la richiesta venga effettuata da un utente con privilegi Admin o
		 * da un Acquirente che cerchi di eliminare sé stesso e, in entrambi i casi, che
		 * il richiedente sia attualmente connesso al Web Service. Nel caso in cui tali
		 * condizioni siano rispettate, il metodo restituisce un riferimento all’utente
		 * eliminato, altrimenti null. Si noti infine che un utente eliminato non
		 * risulterà più connesso anche in mancanza di un logout esplicito.
		 */
		Utente richiedente = this.cercaUtente(email);
		Utente destinatario = this.cercaUtente(emailUtenteDaEliminare);
		
		boolean richiedenteEsiste = richiedente != null;
		boolean destinatarioEsiste = destinatario != null;
		boolean richiedenteConnesso = this.verificaConnessioneUtente(email) != null;
		
		
		if ((richiedenteEsiste && destinatarioEsiste && richiedenteConnesso) && (richiedente instanceof Admin || (richiedente.equals(destinatario)))) {
			int iRic = utenti.indexOf(richiedente);
			if (utenti.get(iRic).getPassword().contentEquals(password)) {
				int iDest = utenti.indexOf(destinatario);
				for (Connessione con: this.connessioni) {
					if (con.getUtente().equals(destinatario) && con.isConnected()) {
						//TODO MODIFICA CON LOGOUT
						this.logoutUtente(emailUtenteDaEliminare, "deleted account");
						con.setTimestampLogout("deleted account");
						break;
					}
				}
				utenti.remove(iDest);
				return destinatario;
			}
		}
		return null;
	}

	public String elencoUtentiPerEmail() {
		/*
		 * L’elenco è ordinato per email, in ordine alfabetico inverso.
		 */		
		ArrayList<Utente> utentiNew = (ArrayList<Utente>) this.utenti.clone();
		Collections.sort(utentiNew, Utente.reverseEmailComparator);
		String res = "";
		for (Utente utente: utentiNew) {
			res += utente + "\n";
		}
		if (res.length() == 0) {
			return res;
		} else {
		return res.substring(0, res.length() - 1);
		}
	}	

	public String elencoAccessiUtentePerTimestamp(String email) {
		/*
		 * Il metodo riceve come parametro l’email dell’utente e restituisce una stringa
		 * con gli accessi riportati su righe diverse nel formato login: timestamp
		 * oppure logout: timestamp a seconda del tipo di accesso, ordinati per
		 * timestamp crescenti (dal più vecchio al più recente).
		 */	
		Utente questoUtente = this.cercaUtente(email);
		ArrayList<String> listaAzioni = new ArrayList<String>();
		if (questoUtente != null) {
			for (Connessione c: this.connessioni) {
				if (c.getUtente().equals(questoUtente)){
					listaAzioni.add(c.getTimestampLogin()+"i");
					if (c.getTimestampLogout() != null) {
						listaAzioni.add(c.getTimestampLogout() + "o");
					}
				}
			}
		}
		String res = "";
		Collections.sort(listaAzioni);
		for (String s: listaAzioni) {
			if (s.charAt(s.length() - 1) == 'i') {
				res += "login: " + s.substring(0, s.length() - 1) + "\n";
			} else {
				res += "logout: " + s.substring(0, s.length() - 1) + "\n";
			}
		}
		if (res.length() == 0) {
			return res;
		} else {
		return res.substring(0, res.length() - 1);
		}
	}

	public String elencoUtentiConnessiPerDataNascita() {
		ArrayList<Utente> utentiNew = new ArrayList<Utente>();
		for (Utente utente: this.utenti) {
			for (Connessione conn:connessioni) {
				if (conn.getUtente().equals(utente) && conn.isConnected()) {
					utentiNew.add(utente);
					break;
				}
			}
		}
		
		Collections.sort(utentiNew, Utente.ageComparator);
		String res = "";
		for (Utente utente: utentiNew) {
			res += utente + "\n";
		}
		
		if (res.length() == 0) {
			return res;
		} else {
		return res.substring(0, res.length() - 1);
		}
	}

	public String elencoUtentiPerCognome() {
		ArrayList<Utente> utentiNew = (ArrayList<Utente>) this.utenti.clone();
		Collections.sort(utentiNew, Utente.surnameComparator);
		String res = "";
		for (Utente utente: utentiNew) {
			res += utente + "\n";
		}
		if (res.length() == 0) {
			return res;
		} else {
		return res.substring(0, res.length() - 1);
		}
	}		
}