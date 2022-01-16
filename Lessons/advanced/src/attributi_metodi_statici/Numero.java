package attributi_metodi_statici;

public class Numero {

	// double valore;

	// Classe che non possiede attributi (dati) 
    // ma solo metodi ("funzioni") di utilita'
	
	// Non una vera e propria classe, per come definita in OOP 
	// (astrazione, encapsulation, ecc.)

	// E non dei veri e propri metodi, perche' non
	// operano su dati della classe
	
	/**
	 * Metodo per calcolare il quadrato di un numero
	 * @param v numero da elevare al quadrato
	 * @return valore di ritorno del metodo
	 */
	
	// Creo documentazione JavaDoc per il mio codice

	public static double quadrato(double v) {
		return v*v;
	}
	
	public static double inverso(double v) {
		
		return 1/v;
	}
	
}
