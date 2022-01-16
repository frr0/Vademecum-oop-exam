package banca;

public class Prestito {
	
	Conto conto;
	Cliente cliente;
	double importo;
	double rataMensile;
	
	public Prestito(Conto cn, Cliente c, double importo, double rataMensile) {
		this.conto = cn;
		this.cliente = c;
		this.importo = importo;
		this.rataMensile = rataMensile;
	}

	public String descriviti() {
		return null;
	}
	
}
