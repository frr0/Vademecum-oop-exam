package network_professionisti;

import java.util.Comparator;

public class Periodo {
	private Entita entita;
	private String da;
	private String a;
	private String titolo;
	public Periodo(Entita entita, String da, String a, String titolo) {
		this.entita = entita;
		this.da = da;
		this.a = a;
		this.titolo = titolo;
	}
	
	public String getData() {
		return this.da;
	}
	
	public Entita getEntita() {
		return this.entita;
	}
	
	
	public String getDa() {
		return da;
	}

	public String getA() {
		return a;
	}

	public String getTitolo() {
		return titolo;
	}
	
	public static Comparator<Periodo> comparatorData = new Comparator<Periodo>() {
		public int compare(Periodo p1, Periodo p2) {
			return -p1.getDa().compareTo(p2.getDa());
		}
	};
	
}
