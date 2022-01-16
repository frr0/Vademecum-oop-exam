package portoturistico;

public class Pagamento {
	private Spazio spazio;
	private String data;
	private double importo;
	
	public Pagamento(Spazio spazio, String data, double importo) {
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
	
	public int getTrimestre() {
		int mese = Integer.parseInt(this.data.substring(4, 6));
		return (mese - 1) / 3;
	}
	
	public int getAnno() {
		return Integer.parseInt(this.data.substring(0, 4));
	}
	
	
}
