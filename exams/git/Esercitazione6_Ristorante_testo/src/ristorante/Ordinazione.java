package ristorante;
import java.util.*;

public class Ordinazione {
	
	private int numeroTavolo;
	private ArrayList<Prodotto> prodotti;
	
	
	public Ordinazione(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
		this.prodotti = new ArrayList<Prodotto>();
	}
	
	public void addProdotto(Prodotto p) {
		this.prodotti.add(p);
	}

	public ArrayList<Prodotto> getProdotti(){
		return this.prodotti;
	}

	public int getNumeroTavolo() {
		return this.numeroTavolo;
	}
	
}
