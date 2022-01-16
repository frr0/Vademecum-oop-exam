package ristorante;
import java.util.*;

public class Cuoco {
	
	private String nome;
	private String cognome;
	private String email;
	private String numeroTelefono;
	private Ordinazione[] ordinazioniAssegnate;
	
	

	public Cuoco(String nome, String cognome, String email, String numeroTelefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.ordinazioniAssegnate = new Ordinazione[2];
	}

	public boolean equals(Cuoco c2) {
		if (this.email.contentEquals(c2.getEmail())) {
			return true;
		} else {
			return false;
		}
	}
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public String getNumeroTelefono() {
		return this.numeroTelefono;	
	}
	
	public static Comparator<Cuoco> comparatorNomeCognome = new Comparator<Cuoco>(){
		public int compare(Cuoco c1, Cuoco c2) {
			int compareNome = c1.getNome().compareTo(c2.getNome());
			if (compareNome == 0) {
				int compareCognome = c1.getCognome().compareTo(c2.getCognome());
				return compareCognome;
			} else {
				return compareNome;
			}
		}
	};
	
	public Ordinazione[] getOrdinazioniAssegnate() {
		return this.ordinazioniAssegnate;
	}
		
}
