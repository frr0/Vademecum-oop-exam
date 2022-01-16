package banca;

public class Fido extends Prestito{

	/* private String codC; */
	/* private double val_prestito; */
	/* private String tipoPrestito; */
	private double tasso;

	public Fido(String codC, double val_prestito, String tipoPrestito,String CF, double tasso) {
		super(codC, val_prestito, tipoPrestito, CF);
		this.tasso = tasso;
	}


	/* public String getCodC() { */
	/*   return codC; */
	/* } */
  /*  */
	/* public void setCodC(String codC) { */
	/*   this.codC = codC; */
	/* } */
  /*  */
	/* public double getVal_prestito() { */
	/*   return val_prestito; */
	/* } */
  /*  */
	/* public void setVal_prestito(double val_prestito) { */
	/*   this.val_prestito = val_prestito; */
	/* } */
  /*  */
	/* public String getTipoPrestito() { */
	/*   return tipoPrestito; */
	/* } */
  /*  */
	/* public void setTipoPrestito(String tipoPrestito) { */
	/*   this.tipoPrestito = tipoPrestito; */
	/* } */

	public double getTasso() {
		return tasso;
	}

	public void setTasso(double tasso) {
		this.tasso = tasso;
	}

	public String descriviti() {
		return getCodC() +" "+CF + " " + getTipoPrestito()  + " " + getTasso()  + " " + getVal_prestito();
	}

}

// Le classi corrispondenti ai vari tipi di prestito mettono a disposizione un metodo descriviti() che restituisce una stringa contenente codice del conto,
//  codice del cliente, tipo di prestito (F oppure M) e importo del prestito separati da uno spazio. Per la classe Fido, la stringa include – dopo il
//  tipo di prestito – anche il tasso di rischio associato al fido.