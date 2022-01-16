package piscine;

public class PostoBordo extends Posto {

	boolean ombrellone;
	int numLettini;
	
	public PostoBordo(String numero) {
		super(numero);
		ombrellone = false;
		numLettini = 0;
	}

	public boolean getOmbrellone() {
		return ombrellone;
	}
	
	public int getNumLettini() {
		return numLettini;
	}



}
