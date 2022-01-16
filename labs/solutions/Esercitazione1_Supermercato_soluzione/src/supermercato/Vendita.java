package supermercato;

public class Vendita {
	
	String nome;
	String marca;
	int unita;
	double prezzo;
	
	public Vendita(String nome, String marca, int unita, double prezzo) {
		this.nome = nome;
		this.marca = marca;
		this.unita = unita;
		this.prezzo = prezzo;
	}

	public String stampaVendita() {		
		return this.nome + ", " + this.marca + ", " + this.unita + ", " +this.prezzo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public int getUnita() {
		return this.unita;
	}
	
	public double getPrezzo() {
		return this.prezzo;
	}
}
