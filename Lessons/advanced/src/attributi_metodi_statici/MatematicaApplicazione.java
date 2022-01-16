package attributi_metodi_statici;

public class MatematicaApplicazione {

	// Costanti definite utilizzando final static
	// Occorre specificare anche il tipo di dato (es. double)

	final static double PI_GRECO = 3.14; 
	// In C 
	// #define PI_GRECO 3.14
	// #define PI_GRECO trevirgolaquattordici
	
	
	public static void main(String[] args) {

		Numero n = new Numero();

		double x = n.quadrato(5); 
		
		// Non particolarmente utile creare un oggetto di classe Numero
        // per invocare un metodo che poi riceve come parametro il valore
		
		// Per evitare l'ovehead di creare un'istanza di quella classe 
		// posso usare la parola chiave static nel definire il metodo quadrato()

		// Se il metodo e' definito static (quindi ne esiste 
		// una sola copia per l'intra applicazione) che bisogno c'e' di 
		// invocarlo su un particolare oggetto?

		// Metodo statico, posso invocarlo SENZA creare prima
		// un oggetto di quella classe, uso direttamente Numero.metodo()
		
		x = Numero.quadrato(5); // Numero al posto di n
		
		System.out.println(x);
		
		// Non e' raro trovarli in Java, metodi/Funzioni di utilita'

		// Es. metodi della classe java.math.Math

		double y = Math.pow(5, 2);
		
		System.out.println(y);
				
	}

}
