package approvvigionamento_magazzino;

public class Ordinazione implements Comparable<Ordinazione>{

	String codiceOrdinazione;
	Fornitore fornitore;
	Prodotto prodotto;
	int quantita;
	
	public boolean consegnata;
	
	public Ordinazione(String codiceOrdinazione, Fornitore fornitore, Prodotto prodotto, int quantita) {
		this.codiceOrdinazione = codiceOrdinazione;
		this.fornitore = fornitore;
		this.prodotto = prodotto;
		this.quantita = quantita;
		
		this.consegnata = false;
	}

	
	@Override
	public int compareTo(Ordinazione altra) {
		return altra.codiceOrdinazione.compareTo(this.codiceOrdinazione);
	}

	
	public String toString() {
		return this.codiceOrdinazione+";"+this.fornitore.codiceFornitore+";"+this.prodotto.codiceProdotto+";"+this.prodotto.descrizione+";"+this.quantita;
	}


	
	
}
