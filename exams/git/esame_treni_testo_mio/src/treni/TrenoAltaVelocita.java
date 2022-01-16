package treni;

public class TrenoAltaVelocita extends Treno{
	private int postiRimanenti;

	public TrenoAltaVelocita(int numero, Linea l) {
		super(numero, "AV", l);
		this.postiRimanenti = 500;
	}

	public int getPostiRimanenti() {
		return postiRimanenti;
	}

	public void setPostiRimanenti(int postiRimanenti) {
		this.postiRimanenti = postiRimanenti;
	}
	
	
	
	

}
