package treni;

public class Linea {
	private String cittaPartenza;
	private String cittaArrivo;
	
	public Linea(String cittaPartenza, String cittaArrivo) {
		this.cittaPartenza = cittaPartenza;
		this.cittaArrivo = cittaArrivo;
	}
	
	public String toString() {
		return cittaPartenza + "-" + cittaArrivo;
	}
	
	public String reverseToString() {
		return cittaArrivo + "-" + cittaPartenza;
	}
	
	

}
