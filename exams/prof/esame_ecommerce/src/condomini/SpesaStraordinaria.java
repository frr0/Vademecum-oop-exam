package condomini;

public class SpesaStraordinaria extends Spesa{
	
	private double percentualeAmministratore;
	boolean pagata = false;
	
	
	



	public SpesaStraordinaria(Condominio condominio, String descrizione,
			double importo, String data, boolean pagaSubito, double percentualeAmministratore) {
		super(condominio, descrizione, importo, data, pagaSubito);
		this.percentualeAmministratore = percentualeAmministratore;
	}






	public double getPercentualeAmministratore() {
		return this.percentualeAmministratore;
	}
	
}
