package ecommerce;

import java.util.*;

public class Utente {
	
	protected int codice;
	protected String nome;
	protected String cognome;
	protected String email;
	protected String indirizzo;
	protected Map<Prodotto, Integer> carrello;

	public Utente(String nome, String cognome, String email, String indirizzo, int codice) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.indirizzo = indirizzo;
		this.carrello = new HashMap<Prodotto, Integer>();
		this.codice = codice;
	}



	public int getCodice() {
		return this.codice;
	}

	

	public void selezionaProdotto(Prodotto prodotto){
		if (this.carrello.get(prodotto) == null) {
			this.carrello.put(prodotto, 1);
		} else {
			this.carrello.put(prodotto, carrello.get(prodotto) + 1);
		}
	}
	
	public double paga(String data){
		double sum = 0;
		for (Prodotto p: this.carrello.keySet()) {
			sum += p.getPrezzo() * this.carrello.get(p);
		}
		this.carrello = new HashMap<Prodotto, Integer>();
		return sum;
	}



	public String getNome() {
		return nome;
	}



	public String getCognome() {
		return cognome;
	}



	public String getEmail() {
		return email;
	}



	public String getIndirizzo() {
		return indirizzo;
	}
	
	public boolean equals(Utente u2) {
		if (this.getEmail().contentEquals(u2.getEmail())) {
			return true;
		} else {
			return false;
		}
	}
	
	public Map<Prodotto, Integer> getCarrello(){
		return this.carrello;
	}

}
