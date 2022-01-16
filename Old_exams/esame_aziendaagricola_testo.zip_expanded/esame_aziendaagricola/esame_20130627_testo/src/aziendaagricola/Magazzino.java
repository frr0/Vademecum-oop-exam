package aziendaagricola;

public class Magazzino {
	private String nome;
	private String prodotto;
	private int quantitaStoccabile;
	private int quantitaStoccata;
	
	

	public Magazzino(String nome, String prodotto, int quantitaStoccabile) {
		this.nome = nome;
		this.prodotto = prodotto;
		this.quantitaStoccabile = quantitaStoccabile;
		this.quantitaStoccata = 0;
	}

	public String getNome() {
		return this.nome;
	}

	public String getProdotto() {
		return this.prodotto;
	}
	
	public int getQuantitaStoccabile() {
		return this.quantitaStoccabile;
	}

	public int getQuantitaStoccata() {
		return this.quantitaStoccata;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setQuantitaStoccabile(int quantitaStoccabile) {
		this.quantitaStoccabile = quantitaStoccabile;
	}

	public void setQuantitaStoccata(int quantitaStoccata) {
		this.quantitaStoccata = quantitaStoccata;
	}	
	
	public int stocca(Raccolto raccolto) throws ProdottoNonCompatibileException{
		boolean prodottoCompatibile = this.prodotto.equals(raccolto.getProdotto());
		if (prodottoCompatibile) {
			int qtaRimanente = this.quantitaStoccabile - this.quantitaStoccata - raccolto.getQuantita();
			if (qtaRimanente > 0) {
				this.quantitaStoccata += raccolto.getQuantita();
				return qtaRimanente;
			} else {
				this.quantitaStoccata = this.quantitaStoccabile;
				return qtaRimanente;
			}
		} else {
			throw new ProdottoNonCompatibileException();
		}
	}
	
	public void preleva(int quantita){
		int qtaRimanente = this.quantitaStoccata - quantita;
		if (qtaRimanente >= 0) {
			this.quantitaStoccata = qtaRimanente;
		} else {
			this.quantitaStoccata = 0;
		}
	}
	
}
