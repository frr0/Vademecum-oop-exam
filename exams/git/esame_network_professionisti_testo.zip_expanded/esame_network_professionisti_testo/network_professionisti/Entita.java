package network_professionisti;

import java.util.Comparator;

public class Entita {
	
	protected String nome;
	protected String nazione;
	protected String indirizzo;
	protected char tipologia;

	
	public Entita(String nome, String nazione, String indirizzo) {
		this.nome = nome;
		this.nazione = nazione;
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNazione() {
		return this.nazione;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}
	
	public char getTipologia() {
		return this.tipologia;
	}
	
	public static Comparator<Entita> comparatorNome = new Comparator<Entita>() {
		public int compare(Entita e1, Entita e2) {
			int compareNome = e1.getNome().compareTo(e2.getNome());
			if (compareNome == 0) {
				if (e1.getTipologia() == e2.getTipologia()) {
					return 0;
				} else if (e1.getTipologia() == 'A') {
					return -1;
				} else {
					return 1;
				}
			} else {
				return compareNome;
			}
		}
	};
}
