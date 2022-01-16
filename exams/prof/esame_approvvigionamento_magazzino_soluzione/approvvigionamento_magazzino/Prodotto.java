package approvvigionamento_magazzino;

import java.util.*;

public class Prodotto{

	int codiceProdotto;
	String descrizione;

	int quantita;
	
	TreeMap<String, Double> mappaFornitoriCosto = new TreeMap<String, Double>();

	public Prodotto(int codiceProdotto, String descrizione) {
		this.codiceProdotto = codiceProdotto;
		this.descrizione = descrizione;
		this.quantita = 0;
	}

	public int getCodiceProdotto() {
		return codiceProdotto;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
}
