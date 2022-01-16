package aziendaagricola;

import java.util.*;

public class Raccolto {
	private String prodotto;
	private String data;
	private int quantita;
	private double prezzoIngrosso;

	public Raccolto(String prodotto, String data, int quantita) {
		this.prodotto = prodotto;
		this.data = data;
		this.quantita = quantita;
	}

	public double getPrezzoIngrosso() {

		return this.prezzoIngrosso;
	}

	public String getProdotto() {

		return this.prodotto;
	}
	
	public String getData() {

		return this.data;
	}
	
	public int getQuantita() {

		return this.quantita;
	}
	
	public void setPrezzoIngrosso(int prezzoIngrosso) {
		this.prezzoIngrosso = prezzoIngrosso;
	}
	
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setQuantita(int quantita) {
this.quantita = quantita;
	}
	
	public boolean equals(Raccolto r2) {
		if (this.prodotto.contentEquals(r2.getProdotto()) &&
				this.data.contentEquals(r2.getData())) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Comparator<Raccolto> comparatorDataQuantita = new Comparator<Raccolto>() {
		public int compare(Raccolto r1, Raccolto r2) {
			int compareData = r1.getData().compareTo(r2.getData());
			int compareQta = r1.getQuantita() - r2.getQuantita();
			if (compareData == 0) {
				return compareQta;
			} else {
				return compareData;
			}
		}
	};
	
}
