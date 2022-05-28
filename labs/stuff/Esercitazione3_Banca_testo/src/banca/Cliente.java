package banca;

public class Cliente {
  private String codiceFiscale;
  private String cognome;
  private String nome;
  private String professione;
  Conto c[] = new Conto[10];
  Prestito pc[] = new Prestito[2];
  Prestito pc1[] = new Prestito[4];
  Fido fc[] = new Fido[10];
  Mutuo mc[] = new Mutuo[10];
  int n_of_conti = 0;

  public Cliente(String codiceFiscale, String cognome, String nome, String professione) {
    //super();
    this.codiceFiscale = codiceFiscale;
    this.cognome = cognome;
    this.nome = nome;
    this.professione = professione;
  }

  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public String getCognome() {
    return cognome;
  }

  public String getNome() {
    return nome;
  }

  public String getProfessione() {
    return professione;
  }

  public String descriviti() {
    return codiceFiscale  + " " + cognome  + " " + nome  + " " + professione;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setProfessione(String professione) {
    this.professione = professione;
  }
}
