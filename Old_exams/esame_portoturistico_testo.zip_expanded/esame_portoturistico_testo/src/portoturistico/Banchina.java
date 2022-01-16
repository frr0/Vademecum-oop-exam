package portoturistico;

import java.util.*;

public class Banchina {
	
	private char lettera;
	private int numeroMassimoSpazi;
	private ArrayList<Spazio> spazi;

	public Banchina(char lettera, int numeroMassimoSpazi) {
		this.lettera = lettera;
		this.numeroMassimoSpazi = numeroMassimoSpazi;
		this.spazi = new ArrayList<Spazio>();
	}

	public char getLetteraBanchina(){
		return this.lettera;
	}

	public int getNumeroMassimoSpazi(){
		return this.numeroMassimoSpazi;
	}

	public ArrayList<Spazio> getSpazi() {
		return spazi;
	}
	
	public void addSpazio(Spazio s) {
		this.spazi.add(s);
	}
	
	public Spazio cercaSpazio(int codice) {
		for (Spazio s: this.spazi) {
			if (s.getCodiceSpazio().contentEquals("" + this.lettera + codice)) {
				return s;
			}
		}
		return null;
	}
}
