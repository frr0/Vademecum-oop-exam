package treni;

public class TrenoInterregionale extends Treno{
	
	private String regioneOrigine;
	private String regioneDestinazione;
	
	public TrenoInterregionale(int numero, Linea l) {
		super(numero, "IR", l);
	}

	public String getRegioneOrigine() {
		return this.regioneOrigine;
	}

	public String getRegioneDestinazione() {
		return this.regioneDestinazione;
	}

	public void setRegioneOrigine(String regioneOrigine) {
		this.regioneOrigine = regioneOrigine;
	}

	public void setRegioneDestinazione(String regioneDestinazione) {
		this.regioneDestinazione = regioneDestinazione;
	}
}
