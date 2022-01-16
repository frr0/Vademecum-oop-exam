package supermercato;

public class Prodotto implements Comparable<Prodotto>{

	String codice;
	String nome;
	int volume;

	double prezzoListino;
	int percentualeSconto;
	
	public Prodotto(String codice, String nome, int volume){
		this.codice=codice;
		this.nome = nome;
		this.volume = volume;
		
		prezzoListino = 0.0;
		percentualeSconto = 0;
	}
	
	public String getCodice(){
		return codice;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getVolume(){
		return volume;
	}

	public void setPrezzoListino(double prezzo) {
		this.prezzoListino = prezzo;
	}

	public double getPrezzoListino() {
		return prezzoListino;
	}

	public void setPercentualeSconto(int percentualeSconto) {
		this.percentualeSconto = percentualeSconto;
	}

	public int getPercentualeSconto() {
		return percentualeSconto;
	}

	public boolean isDaFrigo(){
		if (this instanceof ProdottoDaFrigo)
			return true;
		else
			return false;
	}

	public int compareTo(Prodotto altro) {

		double differenza = this.prezzoListino - altro.prezzoListino;
		if(differenza<0)
			return +1;
		else if (differenza>0)
			return -1;

		return 0;
	}
	
	
	
	
}
