package ecommerce;

import java.util.*;

public class UtenteRegistrato extends Utente{
	
	private String username;
	private String password;
	private boolean loggedIn;
	private ArrayList<String> storico;

	public UtenteRegistrato(String nome, String cognome, String email, String indirizzo, String username, String password, int codice) {
		super(nome, cognome, email, indirizzo, codice);
		this.username = username;
		this.password = password;
		this.loggedIn = false;
		this.storico = new ArrayList<String>();
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public void login(String username, String password) throws EccezioneLoginFallito{
		if (this.username.contentEquals(username) &&
				this.password.contentEquals(password)) {
			this.loggedIn = true;
		} else {
			throw new EccezioneLoginFallito();
		}
	}

	public void logout(){
		this.loggedIn = false;
	}
	
	public boolean isLoggato() {
		return this.loggedIn;
	}
	
	public double paga(String data){
		double sum = 0;
		for (Prodotto p: this.carrello.keySet()) {
			sum += p.getPrezzo() * this.carrello.get(p);
		}
		this.storico.add(data + " " + sum);
		this.carrello = new HashMap<Prodotto, Integer>();
		return sum;
	}
	
	public String storicoAcquisti(){
		Collections.sort(this.storico);
		String res = "";
		for (String s: this.storico) {
			res += s + ";";
		}
		return res;
	}
	
}
