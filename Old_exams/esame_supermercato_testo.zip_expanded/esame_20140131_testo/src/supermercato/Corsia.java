package supermercato;

import java.util.*;

public class Corsia {
	private String nomeCorsia;
	private int capienzaMassima;
	private HashMap<Prodotto, Integer> prodottiEsposti;
	
	public Corsia(String nomeCorsia, int capienzaMassima) {
		this.nomeCorsia = nomeCorsia;
		this.capienzaMassima = capienzaMassima;
		this.prodottiEsposti = new HashMap<Prodotto, Integer>();
	}
	
	public String getNomeCorsia() {
		return nomeCorsia;
	}
	public int getCapienzaMassima() {
		return capienzaMassima;
	}
	
	public int capienzaOccupata() {
		int sum = 0;
		for (Prodotto p: this.prodottiEsposti.keySet()) {
			sum += p.getVolume() * this.prodottiEsposti.get(p);
		}
		return sum;
	}
	
	public void addProdotto(Prodotto p, int quantita) {
		for (int i = quantita; i>0; i--) {
			if (i * p.getVolume() <= this.capienzaMassima - this.capienzaOccupata()) {
				this.prodottiEsposti.put(p, i);
				return;
			}
		}
	}
	
	public Collection<Prodotto> getProdotti(){
		return this.prodottiEsposti.keySet();
	}

	public int getQuantita(Prodotto p) {
		if (this.prodottiEsposti.get(p) == null) {
			return 0;
		}
		return this.prodottiEsposti.get(p);
	}
	
	public void modificaQuantita(Prodotto p, int quantita) {
		int nuovaQta = this.prodottiEsposti.get(p) - quantita;
		this.prodottiEsposti.remove(p);
		this.prodottiEsposti.put(p, nuovaQta);
	}
}
