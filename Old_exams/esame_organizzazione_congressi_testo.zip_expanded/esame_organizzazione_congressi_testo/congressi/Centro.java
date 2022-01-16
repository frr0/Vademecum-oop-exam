package congressi;

import java.util.*;

public class Centro{
	
	private int numeroSeriale;
	private String nome;
	private String indirizzo;
	
	private Map<String, Sala> sale;
	
	

	public Centro(int numeroSeriale, String nome, String indirizzo) {
		this.numeroSeriale = numeroSeriale;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.sale = new TreeMap<String, Sala>();
	}

	public String getId() {
		return this.nome.toUpperCase().substring(0,2) + numeroSeriale;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}
	
	public static Comparator<Centro> comparatorSeriale = new Comparator<Centro>() {
		public int compare(Centro c1, Centro c2) {
			return c1.numeroSeriale - c2.numeroSeriale;
		}
	};
	
	public void putSala(Sala s) {
		this.sale.put(s.getNome(), s);
	}
	
	public Sala getSala(String nome) {
		return this.sale.get(nome);
	}
	
	public Map<String, Sala> getAllSale() {
		return this.sale;
	}
}
