package noleggiauto;

public class Auto {
	protected String targa;
	protected String marca;
	protected String modello;
	protected String colore;
	protected char tipologia;
	protected int numeroValigieGrandi;
	protected int numeroValigiePiccole;
	protected int costoGiornaliero;

	public Auto(String targa, String marca, String modello, String colore) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.colore = colore;
	}

	public String getTarga() {
		return this.targa;
	}

	public String getMarca() {
		return this.marca;
	}

	public String getModello() {
		return this.modello;
	}

	public String getColore() {
		return this.colore;
	}
	
	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getNumeroValigieGrandi() {
		return this.numeroValigieGrandi;
	}
	
	public int getNumeroValigiePiccole() {
		return this.numeroValigiePiccole;
	}
	
	public int getCostoGiornaliero() {
		return this.costoGiornaliero;
	}

	public char getTipologia() {
		return this.tipologia;
	}
	
	
}
