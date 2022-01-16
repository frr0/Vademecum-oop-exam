package congressi;

import java.util.Comparator;

public class Sala {
	
	private String nome;
	private int capienza;
	
	
	
	public Sala(String nome, int capienza) {
		this.nome = nome;
		this.capienza = capienza;
	}

	public String getNome() {
		return this.nome;
	}

	public int getCapienza() {
		return this.capienza;
	}
	
	public static Comparator<Sala> comparatorCapienza = new Comparator<Sala>() {
		public int compare(Sala s1, Sala s2) {
			return s1.getCapienza() - s2.getCapienza();
		}
	};
}
