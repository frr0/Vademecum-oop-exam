package banca;

public class Fido extends Prestito{
	double tassoRischio;

	public Fido(Conto cn, Cliente c, double importo, double rataMensile, double tassoRischio) {
		super(cn, c, importo, rataMensile);
		this.tassoRischio = tassoRischio;
	}

	public String descriviti() {
		return this.conto.getCodice() + " " + this.cliente.getCodiceFiscale() + " F " + tassoRischio + " "  + importo;
	}

}
