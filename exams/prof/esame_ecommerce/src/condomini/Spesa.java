package condomini;

public class Spesa {
	
	Condominio condominio;
	private String descrizione;
	private double importo;
	private String data;
	private boolean pagaSubito;
	boolean pagata = false;
	
	

	public Spesa(Condominio condominio, String descrizione, double importo, String data, boolean pagaSubito) {
		super();
		this.condominio = condominio;
		this.descrizione = descrizione;
		this.importo = importo;
		this.data = data;
		this.pagaSubito = pagaSubito;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public double getImporto() {
		return this.importo;
	}

	public String getData() {
		return this.data;
	}

	public boolean isPagaSubito() {
		return pagaSubito;
	}

	public void setPagaSubito(boolean pagaSubito) {
		this.pagaSubito = pagaSubito;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public void setData(String data) {
		this.data = data;
	}

}
