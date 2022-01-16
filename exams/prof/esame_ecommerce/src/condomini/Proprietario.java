package condomini;

public class Proprietario{
	
	Condominio condominio;
	private String cognome;
	private String nome;
	private double millesimi;
	private int interno;
	private double debito;

	public Proprietario(Condominio condominio, String cognome, String nome, int interno, double millesimi, double debito) 
	{
		super();
		this.condominio = condominio;
		this.cognome = cognome;
		this.nome = nome;
		this.millesimi = millesimi;
		this.interno = interno;
		this.debito = debito;
	}

	public String getProprietario() {
		return ""+this.cognome+" "+this.nome;
	}
	
	public double getMillesimi() {
		return this.millesimi;
	}

	public int getInterno(){
		return this.interno;
	}

	public double getDebito(){
		return this.debito;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMillesimi(double millesimi) {
		this.millesimi = millesimi;
	}

	public void setInterno(int interno) {
		this.interno = interno;
	}

	public void setDebito(double debito) {
		this.debito = debito;
	}
 
}
