package banca;

public class Conto {
  private String codice;
  private double tassoInteresse;
  private double capitale;
  /* private double capitale2; */
  private String dataApertura;
  private String nomeOperatore;
  private String nomeFiliale;

  public Conto(String codice, double tassoInteresse, double capitale, String dataApertura, String nomeOperatore, String nomeFiliale) {
    /* super(); */
    this.codice = codice;
    this.tassoInteresse = tassoInteresse;
    this.capitale = capitale;
    this.dataApertura = dataApertura;
    this.nomeOperatore = nomeOperatore;
    this.nomeFiliale = nomeFiliale;
  }

  public void setCapitale(double capitale) {
    this.capitale = capitale;
  }

  public String getCodice() {
    return codice;
  }

  public double getTassoInteresse() {
    return tassoInteresse;
  }

  public double getCapitale() {
    return capitale;
  }

  public String getDataApertura() {
    return dataApertura;
  }

  public String getNomeOperatore() {
    return nomeOperatore;
  }

  public String getNomeFiliale() {
    return nomeFiliale;
  }

  public String descriviti() {
    // System.err.println("hjklghsdlghsdlghsdfl " + codice);
    return codice + " " + tassoInteresse  + " " + capitale + " " + dataApertura  + " " + nomeOperatore  + " " + nomeFiliale;
  }

  /* public void setCapitale(double capitale2) { */
  /*   this.capitale2 = capitale2; */
  /* } */

}
