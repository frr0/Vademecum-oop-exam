package noleggiauto;

public class Compatta extends Auto{

	public Compatta(String targa, String marca, String modello, String colore) {
		super(targa, marca, modello, colore);
		// TODO Auto-generated constructor stub
		this.tipologia = 'C';
		this.numeroValigieGrandi = 0;
		this.numeroValigiePiccole = 2;
		this.costoGiornaliero = 50;
	}
	
}
