package treni;

import java.util.*;

public class Treno {
	
	protected int numero;
	protected String tipologia;
	protected Linea linea;
	protected TreeMap<String, Stazione> fermateTreno;

	public Treno(int numero, String tipologia, Linea linea) {
		this.numero = numero;
		this.tipologia = tipologia;
		this.linea = linea;
		this.fermateTreno = new TreeMap<String, Stazione>();
	}

	public int getNumero() {
		return this.numero;
	}

	public String getTipologia(){
		return this.tipologia;
	
	}

	public String getNomeLinea() {
		return this.linea.toString();
	}

	public String fermate(){
		String s = "";
		ArrayList<String> orari = new ArrayList<String>(this.fermateTreno.keySet());
 		for (int i = 0; i<this.fermateTreno.size(); i++) {
 			s += this.fermateTreno.get(orari.get(i)).getNome() + "," +  orari.get(i)+ ";";
		}
 		if (s.length() == 0) {
 			return "";
 		} else {
 			return s.substring(0, s.length() - 1);
 		}
	}	
	
	public boolean viaggiaTra(Stazione partenza, Stazione arrivo) {
		ArrayList<String> orari = new ArrayList<String>(this.fermateTreno.keySet());
		int j = -1;
 		for (int i = 0; i<this.fermateTreno.size(); i++) {
 			if (this.fermateTreno.get(orari.get(i)).getNome().contentEquals(partenza.getNome())) {
 				j = i;
 				break;
 			}
		}
 		
 		if (j != -1) {
 			for (int i = j; i<this.fermateTreno.size(); i++) {
 				if (this.fermateTreno.get(orari.get(i)).getNome().contentEquals(arrivo.getNome())) {
 	 				return true;
 	 			}
 			}
 		}
 		
 		return false;
	}
	
	public void aggiungiFermata(String orario, Stazione stazione) {
		this.fermateTreno.put(orario, stazione);
	}
	
	public boolean equals(Treno t) {
		if (this.numero == t.getNumero() && this.tipologia.contentEquals(t.getTipologia())) {
			return true;
		} else {
			return false;
		}
	}
}
