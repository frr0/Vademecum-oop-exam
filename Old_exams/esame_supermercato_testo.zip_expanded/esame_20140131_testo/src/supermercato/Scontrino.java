package supermercato;

import java.util.*;

public class Scontrino {
	private int codice;
	private Map<Prodotto, Integer> prodotti;
	public Scontrino(int codice) {
		this.codice = codice;
		this.prodotti = new HashMap<Prodotto, Integer>();
	}
	public int getCodice() {
		return codice;
	}
	public Map<Prodotto, Integer> getProdotti() {
		return prodotti;
	}
	
	public void addProdotto(Prodotto p, int quantita) {
		this.prodotti.put(p, quantita);
	}
	
	
	
	
	
}
