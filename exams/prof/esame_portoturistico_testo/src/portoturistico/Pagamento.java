package portoturistico;

public class Pagamento {
	private Spazio spazio;
	private String data;
	private double importo;
	
	public Pagamento(Spazio spazio, String data, double importo) {
		super();
		this.spazio = spazio;
		this.data = data;
		this.importo = importo;
	}

	public Spazio getSpazio() {
		return spazio;
	}

	public String getData() {
		return data;
	}

	public double getImporto() {
		return importo;
	}
	
	

}
