package exceptions;

public class CalcolaSommaConEccezioniApproccioTuttoONiente {

	// Programma che somma un certo numero di valori
	// numerici memorizzati in un array di stringhe

						// Un metodo che scatena una eccezione deve DICHIARARLO con throwS
	public static void main(String[] args) throws ErroreNellaStringaException{ 
			
		// Posso scegliere di mettere il blocco try-catch intorno a tutte le istruzioni / 
		// a tutto il codice "funzionale" (approccio di tipo "TUTTO O NIENTE") oppure 
		// intorno alle istruzioni "critiche" che so in anticipo possono 
		// scatenare eccezioni (approccio di tipo "ignoro gli errori puntuali", o
		// "CHIRURGICO")
		
		try { // APPROCCIO "TUTTO O NIENTE", TUTTO IL CODICE FUNZIONALE NEL BLOCCO TRY

			// ****** INIZIA IL CODICE FUNZIONALE *****
			String array[] = {"12", "5", "otto", "7"};
			int somma = 0;
			for(int i=0;i<array.length;i++) {
				
				// Convertire una stringa nell'intero corrispondente				
				
				// Il codice che segue funziona se la stringa contiene un intero...
				
				// ... se pero' contiene caratteri diversi NumberFormatException
				
				int v = Integer.parseInt(array[i]);
				somma = somma + v;
			}
			System.out.println("La somma vale: "+somma);
			// ****** FINISCE IL CODICE FUNZIONALE *****
		
		}catch(NumberFormatException nfe ) { // nfe rappresenta il nome che do all'eccezione, una sorta di "variabile"
			
			// Qui posso fare qualcosa per risolvere il problema

			// CODICE DI GESTIONE DELL'ECCEZIONE
			
			// Potrei anche non fare nulla, ma ... 
			
			// E' BUONA NORMA *** NON *** LASCIARE QUESTO BLOCCO VUOTO 
			
			// Magari posso almeno informare l'utente 
			System.out.println("Si è scatenata una eccezione :-( "+nfe);
			
			// nfe.printStackTrace(); // Stampa nella console tutto ciò che si sa dell'eccezione

			// POTREI ANCHE, DOPO AVER INTERCETTATO L'ECCEZIONE, PROPAGARLA
			
			// LA STESSA
			// throw nfe;

			// UN'ALTRA DELLO STESSO TIPO
		    // throw new NumberFormatException(); // nfe

			// OPPURE ANCORA UN'ALTRA, AD ESEMPIO DEFINITA DA ME
			throw new ErroreNellaStringaException();
			
			// Scatenando una eventuale eccezione, la gestione passera' 
			// al chiamante (main), e quindi il programma si arrestera'
			// non essendoci altro codice di gestione delle eccezioni

		}
		
		System.out.println("Programma finito");
		
	}

}
