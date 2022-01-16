package portoturistico;

public class Spazio implements Comparable<Spazio>{
	private String codice;
	private double lunghezza;
	private double larghezza;
	private double costo;

	public Spazio(String codice, double lunghezza, double larghezza) {
		super();
		this.codice = codice;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
	}

	public String getCodiceSpazio(){
		return codice;
	}
	
	public double getLunghezza(){
		return lunghezza;
	}
	
	public double getLarghezza(){
		return larghezza;
	}

	public double getCosto(){
		return costo;
	}
	
	public void setCosto(double costo){
       this.costo = costo;
	}

	@Override
	public int compareTo(Spazio altro) {
		
		return this.codice.compareTo(altro.getCodiceSpazio());
	}

}
