package ristorante;

public class Bevanda extends Prodotto{
	
	private int gradi;

	public Bevanda(String nome, int prezzo) {
		super(nome, prezzo);
		this.gradi = -1;
	}

	public void setGradi(int gradi) {
		this.gradi = gradi;
	}	
	
	public int getGradi() {
		return this.gradi;
	}
	
	public String toString() {
		return this.nome + ", servire a " + this.gradi + " gradi";
	}
}
