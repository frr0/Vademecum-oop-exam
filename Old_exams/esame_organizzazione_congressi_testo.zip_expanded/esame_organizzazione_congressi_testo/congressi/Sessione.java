package congressi;

import java.util.Comparator;

public class Sessione {
	
	protected int numeroSeriale;
	protected Congresso congresso;
	protected Sala sala;
	protected String nome;
	protected String data;
	protected String daOra;
	protected String adOra;
	
	

	public Sessione(int numeroSeriale, Congresso congresso, Sala sala, String nome, String data, String daOra,
			String adOra) {
		this.numeroSeriale = numeroSeriale;
		this.congresso = congresso;
		this.sala = sala;
		this.nome = nome;
		this.data = data;
		this.daOra = daOra;
		this.adOra = adOra;
	}

	public int getNumero() {
		return this.numeroSeriale;
	}
	
	public String getNomeCongresso() {
		return this.congresso.getNome();
	}

	public String getNomeSala() {
		return this.sala.getNome();
	}

	public String getNome() {
		return this.nome;
	}

	public String getData() {
		return this.data;
	}

	public String getDaOra() {
		return this.daOra;
	}

	public String getAdOra() {
		return this.adOra;
	}
	
	public void allocaOratore(String cognomeNome) {
		return;
	}
	
	public void allocaOratore(String cognomeNome, String ora) {
		return;
	}
	
	public static Comparator<Sessione> comparatorDataOra = new Comparator<Sessione>() {
		public int compare(Sessione s1, Sessione s2) {
			int compareGiorno = s1.getData().compareTo(s2.getData());
			if (compareGiorno != 0) {
				return compareGiorno;
			} else {
				int compareOra = s1.getDaOra().compareTo(s2.getDaOra());
				return compareOra;
			}
		}
	};

}
