package network_professionisti;

import java.util.*;

public class Azienda extends Entita {
	
	private String settore;
	private int numeroDipendenti;

	public Azienda(String nome, String nazione, String indirizzo, String settore, int numeroDipendenti) {
		super(nome, nazione, indirizzo);
		this.settore = settore;
		this.numeroDipendenti = numeroDipendenti;
		this.tipologia = 'A';
	}

	public String getSettore() {
		return this.settore;
	}

	public int getNumeroDipendenti() {
		return this.numeroDipendenti;
	}
	
	public static Comparator<Azienda> comparatorDipendenti = new Comparator<Azienda>() {
		public int compare(Azienda a1, Azienda a2) {
			return a1.getNumeroDipendenti() - a2.getNumeroDipendenti();
		}
	};
	
}
