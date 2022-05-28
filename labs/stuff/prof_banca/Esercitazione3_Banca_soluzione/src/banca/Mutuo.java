package banca;

public class Mutuo extends Prestito{

	int numeroMesi;
	
	public Mutuo(Conto cn, Cliente c, double importo, double rataMensile, int numeroMesi) {
		super(cn, c, importo, rataMensile);
		this.numeroMesi = numeroMesi;
		// TODO Auto-generated constructor stub
	}

	public String descriviti() {
		return this.conto.getCodice() + " " + this.cliente.getCodiceFiscale() + " M " + importo;
	}

}
