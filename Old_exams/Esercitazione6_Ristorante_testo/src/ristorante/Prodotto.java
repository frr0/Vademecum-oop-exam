package ristorante;
import java.util.*;

public class Prodotto {
	protected String nome;
	protected int prezzo;
	
	public Prodotto(String nome, int prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public String getNome() {
		return this.nome;
	}
	
	public int getPrezzo() {
		return this.prezzo;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	public static Comparator<Prodotto> comparatorNome = new Comparator<Prodotto>() {
		public int compare(Prodotto p1, Prodotto p2) {
			return p1.getNome().compareTo(p2.getNome());
		}
	};
	
}
