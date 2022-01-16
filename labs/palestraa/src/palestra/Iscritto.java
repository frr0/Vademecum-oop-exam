package palestra;


public class Iscritto implements Comparable<Iscritto> {
	private String nome, cognome, sesso;
	private int eta;
	private double peso;
	private int codice;
		

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public Iscritto(String nome, String cognome, String sesso, int eta, double peso) {
//		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.eta = eta;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String descriviti() {
		return nome + " " + cognome + " " + sesso + " " + eta  + " " + peso;
	}

	@Override
	public int compareTo(Iscritto o) {
		// TODO Auto-generated method stub
//		return Integer.compare(this.nome, o.nome);
		return 0;
	}

}