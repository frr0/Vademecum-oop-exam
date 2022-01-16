package banca;

public class Prestito {
	
	private String codC;
	private double val_prestito;
	private String tipoPrestito;
	// private double tasso;
	/* Fido f1 = new Fido(codC, val_prestito, tipoPrestito, 0); */
	/* Mutuo m1 = new Mutuo(codC, val_prestito, tipoPrestito); */



	public Prestito(String codC, double val_prestito, String tipoPrestito) {
		this.codC = codC;
		this.val_prestito = val_prestito;
		this.tipoPrestito = tipoPrestito;
	}


	public String getTipoPrestito() {
		return tipoPrestito;
	}


	public void setTipoPrestito(String tipoPrestito) {
		this.tipoPrestito = tipoPrestito;
	}


	/* public String getTipoPrestito() { */
	/*     return tipoPrestito; */
	/* } */
    /*  */
    /*  */
	/* public void setTipoPrestito(String tipoPrestito) { */
	/*     this.tipoPrestito = tipoPrestito; */
	/* } */


	public double getVal_prestito() {
		return val_prestito;
	}


	public void setVal_prestito(double val_prestito) {
		this.val_prestito = val_prestito;
	}


	public String getCodC() {
		return codC;
	}


	public void setCodC(String codC) {
		this.codC = codC;
	}


	public String descriviti() {
		return getCodC()  + " " + getVal_prestito()  + " " + getTipoPrestito();
	}
	
}

// Le classi corrispondenti ai vari tipi di prestito mettono a disposizione un metodo descriviti() che restituisce una stringa contenente codice del conto,
//  codice del cliente, tipo di prestito (F oppure M) e importo del prestito separati da uno spazio. Per la classe Fido, la stringa include – dopo il
//  tipo di prestito – anche il tasso di rischio associato al fido.