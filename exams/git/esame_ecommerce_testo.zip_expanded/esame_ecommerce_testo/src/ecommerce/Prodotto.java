package ecommerce;

import java.util.*;
import java.lang.*;

public class Prodotto {
	private String nome;
	private String categoria;
	private String descrizione;
	private double prezzo;
	private String codice;
	
	

	public Prodotto(String nome, String categoria, String descrizione, double prezzo, int numProgressivo) {
		this.nome = nome;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.codice = String.valueOf(numProgressivo);
		
		while (this.codice.length() < 5) {
			this.codice = "0" + this.codice;
		}
		
		this.codice = this.categoria.toUpperCase().charAt(0) + this.codice;
		
	}
	
	public String getCategoria() {
		return this.categoria;
	}

	public String getCodice() {
		return this.codice;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public double getPrezzo() {
		return this.prezzo;
	}
	
	public String toString() {
		return this.codice + " " + this.prezzo;
	}
	
	public static Comparator<Prodotto> comparatorCodice = new Comparator<Prodotto>() {
		public int compare(Prodotto p1, Prodotto p2) {
			return p1.getCodice().compareTo(p2.getCodice());
		}
	};
	
	public static Comparator<Prodotto> comparatorNome = new Comparator<Prodotto>() {
		public int compare(Prodotto p1, Prodotto p2) {
			return p1.getNome().compareTo(p2.getNome());
		}
	};
	
	public static Comparator<Prodotto> comparatorPrezzo = new Comparator<Prodotto>() {
		public int compare(Prodotto p1, Prodotto p2) {
			double diff = p1.getPrezzo() - p2.getPrezzo();
			double abs = Math.abs(diff);
			return (int) (diff/abs);
		}
	};
	
}


