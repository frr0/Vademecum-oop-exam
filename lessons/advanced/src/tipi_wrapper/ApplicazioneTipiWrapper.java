package tipi_wrapper;

public class ApplicazioneTipiWrapper {

	public static void main(String[] args) {

		// Potrei utilizzare la mia classe "contenitore" Intero
		
		// Intero i = new Intero(5);
		// System.out.println(i.getValore());
		
		// Non un'idea del tutto assurda, la usa anche Java con i tipi "wrapper"

		Integer i = 5; // = new Integer(5);
		
		int j = 6;
		
		int k = i + j; // Java gestisce le conversione di tipo
		               // tra tipi primitivi e tipi wrapper
		               // Automatic boxing & unboxing
		
		// Per convertire un intero in stringa non mi serve necessariamente un metodo

		String s = ""+i;
		
		// Volendo, c'è anche il metodo
		
		       s = i.toString();
		
	    // Per convertire una stringa in intero, invece?
		       
		s = "33";
		
		// In C avrei potuto usare la funzione atoi()

		// In Java, il metodo parseInt(), metodo statico, di Integer
		
		int v = Integer.parseInt(s); 

	}

}
