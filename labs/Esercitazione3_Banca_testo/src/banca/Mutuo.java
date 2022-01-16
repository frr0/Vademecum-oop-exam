package banca;

public class Mutuo extends Prestito {

	// private String codC;
	// private double val_prestito;
	// private String tipoPrestito;
	/* private double tasso; */

	// public Mutuo(String codC, double val_prestito, String tipoPrestito) {
	//   this.setCodC(codC);
	//   this.setVal_prestito(val_prestito);
	//   this.setTipoPrestito(tipoPrestito);
		/* this.setTasso(tasso); */
	// }

	public Mutuo(String codC, double val_prestito, String tipoPrestito, String CF) {
		super(codC, val_prestito, tipoPrestito, CF);
	}

	// public String getCodC() {
	//   return codC;
	// }
  //
	// public void setCodC(String codC) {
	//   this.codC = codC;
	// }
  //
	// public double getVal_prestito() {
	//   return val_prestito;
	// }
  //
	// public void setVal_prestito(double val_prestito) {
	//   this.val_prestito = val_prestito;
	// }
  //
	// public String getTipoPrestito() {
	//   return tipoPrestito;
	// }

	// public void setTipoPrestito(String tipoPrestito) {
	//   this.tipoPrestito = tipoPrestito;
	// }

	/* public double getTasso() { */
	/*     return tasso; */
	/* } */
    /*  */
	/* public void setTasso(double tasso) { */
	/*     this.tasso = tasso; */
	/* } */

	public String descriviti() {
		return getCodC()+" "+CF  + " " + getTipoPrestito()  + " " + getVal_prestito();
	}

}
