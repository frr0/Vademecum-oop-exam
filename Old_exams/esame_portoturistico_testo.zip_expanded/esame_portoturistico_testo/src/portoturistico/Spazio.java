package portoturistico;

public class Spazio {
	
	protected char codiceBanchina;
	protected int codiceSpazio;
	protected double lunghezza;
	protected double larghezza;
	protected double costo;
	

	public Spazio(char codiceBanchina, int codiceSpazio, double lunghezza, double larghezza) {
		this.codiceBanchina = codiceBanchina;
		this.codiceSpazio = codiceSpazio;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.costo = 0;
	}

	public String getCodiceSpazio(){
		String res = "" + codiceBanchina + codiceSpazio;
		return res;
	}
	
	public double getLunghezza(){
		return this.lunghezza;
	}
	
	public double getLarghezza(){
		return this.larghezza;
	}

	public double getCosto(){
		return this.costo;
	}
	
	public void setCosto(double costo){
		this.costo = costo;
	}

}
