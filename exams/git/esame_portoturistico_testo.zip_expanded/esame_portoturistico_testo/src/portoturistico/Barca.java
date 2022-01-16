package portoturistico;

import java.util.*;

public class Barca {
	
	private String numeroImmatricolazione;
	private String nome;
	private double lunghezza;
	private double larghezza;

	public Barca(String numeroImmatricolazione, String nome, double lunghezza, double larghezza) {
		this.numeroImmatricolazione = numeroImmatricolazione;
		this.nome = nome;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
	}

	public String getNumeroImmatricolazione() {
		return this.numeroImmatricolazione;
	}

	public String getNome() {
		return this.nome;
	}

	public double getLunghezza() {
		return this.lunghezza;
	}

	public double getLarghezza() {
		return this.larghezza;
	}
	
	public double getDimensioni() {
		return this.larghezza * this.lunghezza;
	}
	
	public boolean equals(Barca b) {
		if (b.numeroImmatricolazione.contentEquals(this.numeroImmatricolazione)) {
			return true;
		}
		return false;
	}
	
	public static Comparator<Barca> comparatorNomeDimensione = new Comparator<Barca>() {
		public int compare(Barca b1, Barca b2) {
			int compareNome = b1.getNome().compareTo(b2.getNome());
			if (compareNome == 0) {
				return (int) (b1.getDimensioni() - b2.getDimensioni());
			} else {
				return compareNome;
			}
		}
	};
	
	public static Comparator<Barca> comparatorDimensioneNome = new Comparator<Barca>() {
		public int compare(Barca b1, Barca b2) {
			int compareDimensione = (int) (b1.getDimensioni() - b2.getDimensioni());
			if (compareDimensione == 0) {
				return b1.getNome().compareTo(b2.getNome());
			} else {
				return compareDimensione;
			}
		}
	};
}
