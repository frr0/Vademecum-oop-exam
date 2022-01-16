package exceptions;

public class CalcolaSommaConEccezioniApproccioChirurgico {

	public static void main(String[] args) throws ErroreNellaStringaException{ 
			
			String array[] = {"12", "5", "otto", "7"};
			int somma = 0;
			for(int i=0;i<array.length;i++) {
				int v = 0;
				
				try { // APPROCCIO DI GESTIONE DELL'ECCEZIONE "CHIRURGICO"
					  // try-catch SOLO INTORNO ALLA/E ISTRUZIONE/I VERAMENTE CRITICA/HE 
					
				    // Riga che può scatenare eccezioni NumberFormatException
				    v = Integer.parseInt(array[i]);
				    
					// In caso di anomalie nel blocco try, viene eseguito il codice nel blocco catch 

				} catch( NumberFormatException nfe ) {
					System.err.println("Eccezione!");
				}
				
				somma = somma + v;
			}
			System.out.println("La somma vale: "+somma);

		
		System.out.println("Programma finito");
		
		
	}

}
