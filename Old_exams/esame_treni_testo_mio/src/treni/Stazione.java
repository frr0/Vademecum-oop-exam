package treni;

import java.util.*;

public class Stazione {
	
	private String nome;
	private String chilometro;
	private Linea linea;

	public Stazione(String nome, String chilometro, Linea linea) {
		this.nome = nome;
		this.chilometro = chilometro;
		this.linea = linea;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNomeLinea() {
		return this.linea.toString();
	}

	public String getChilometro() {
		return this.chilometro;
	}
	
	public double getChilometroNumero() {
		String[] km1 = this.getChilometro().split("\\+");
		double res = Integer.parseInt(km1[0]) + Integer.parseInt(km1[1])/1000;
		return res;
	}
	
	public static Comparator<Stazione> comparatorDistanza = new Comparator<Stazione>() {
		public int compare(Stazione s1, Stazione s2) {
			String[] km1 = s1.getChilometro().split("\\+");
			String[] km2 = s2.getChilometro().split("\\+");
			int diffKm = Integer.parseInt(km1[0]) - Integer.parseInt(km2[0]);
			if (diffKm == 0) {
				int diffMt = Integer.parseInt(km1[1]) - Integer.parseInt(km2[1]);
				return diffMt;
			} else {
				return diffKm;
			}
		}
	};
	
	public static Comparator<Stazione> comparatorAlfabetico = new Comparator<Stazione>() {
		public int compare(Stazione s1, Stazione s2) {
			return s1.getNome().compareTo(s2.getNome());
		}
	};
}
