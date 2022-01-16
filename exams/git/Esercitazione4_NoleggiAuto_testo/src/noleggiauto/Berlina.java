package noleggiauto;

public class Berlina extends Auto{

	public Berlina(String targa, String marca, String modello, String colore) {
		super(targa, marca, modello, colore);
		// TODO Auto-generated constructor stub
		this.tipologia = 'B';
		this.numeroValigieGrandi = 1;
		this.numeroValigiePiccole = 3;
		this.costoGiornaliero = 75;
	}

	

}
