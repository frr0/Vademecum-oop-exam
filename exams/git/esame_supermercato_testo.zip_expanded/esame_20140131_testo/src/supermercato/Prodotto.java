package supermercato;

import java.util.*;

public class Prodotto{
	
	protected String codice;
	protected String nome;
	protected int volume;
	protected double prezzo;
	protected int percentualeSconto;
	

	public Prodotto(String codice, String nome, int volume) {
		this.codice = codice;
		this.nome = nome;
		this.volume = volume;
		this.prezzo = 0;
		this.percentualeSconto = 0;
	}

	public String getCodice(){
		return this.codice;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getVolume(){
		return this.volume;
	}

	public void setPrezzoListino(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getPrezzoListino() {
		return this.prezzo;
	}

	public void setPercentualeSconto(int percentualeSconto) {
		this.percentualeSconto = percentualeSconto;
	}

	public int getPercentualeSconto() {
		return this.percentualeSconto;
	}

	public boolean isDaFrigo(){
		return false;
	}
	
	public static Comparator<Prodotto> comparatorPrezzo = new Comparator<Prodotto>() {
		public int compare(Prodotto p1, Prodotto p2) {
			if (p1.getPrezzoListino() - p2.getPrezzoListino() < 0) {
				return -1;
			} else if (p1.getPrezzoListino() - p2.getPrezzoListino() == 0) {
				return 0;
			} else {
				return 1;
			}
		}
	};
	
}
