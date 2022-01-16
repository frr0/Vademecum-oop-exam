package basic;

public class Array {

	public static void main(String[] args) {
		
		// Dichiarazione di un array di interi in C

		// int array[100];		
		
		// In Java, diverse alternative
		
		// Creazione di un array per ENUMERAZIONE
		
		          // 0  1   2   3   4   5  6
		int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		      // Dichiarato array di 5 celle di nome a contemporaneamente
		      // inizializzato con quei valori
		
		// Altro modo, usando la parola chiave new 
		
		// ... quindi in Java l'array E' TRATTATO COME UN OGGETTO !!!
		
		int aa[] = new int[100];
		      // Creato un array di 100 celle (allocata memoria per  
		      // 100 "scatoline" di tipo int), quindi inizializzate al valore 
		      // di default per gli int, che è 0)
				
		// Si accede per indice, come in C, con indici a partire da 0 
		// fino a dimensione-1 (99, in questo caso con 100 celle)
		
		aa[0] = 3;
		int x = aa[1];
		
		// Stampa del contenuto della cella un-esima (indice 1)

		System.out.println(aa[1]); // Equivalente a stampare la variabile x
		                           // in cui ho memorizzato il medesimo valore
		
		System.out.println("Stampa nella console dei contenuto dell'array");
		
		                  // Perchè devo essere io a definire la condizione es. i < 7, 
						  // se 7 sono le celle dell'array? Che succede se il numero di celle cambia?
		
		// for(int i=0; i < 7 ; i++ )
			
		                  // PERCHE' NON LO CHIEDO DIRETTAMENTE ALL'ARRAY
		                  // CHI MEGLIO DELL'ARRAY SA DIRMI QUANTE CELLE CONTENGA?
		                  // DELEGO ALL'ARRAY IL FORNIRE LA PROPRIA DIMENSIONE
		
		for(int i=0; i < a.length ; i++ ) { // IL PROGRAMMA SI ADATTA ALLA DIMENSIONE di a
			int valore = a[i];
			System.out.println(valore); // Anche in forma più compatta volendo, println(a[i]);
		}
	
		           // HO UTILIZZATO LA NOTAZIONE PUNTATA .length SU UN
		           // ARRAY ... POSSIBILE PERCHE' JAVA, COME DETTO, TRATTA 
		           // GLI ARRAY COME SE FOSSERO DEGLI OGGETTI
		
		System.out.println("Se sono qui ho finito ... ");

		// Analogamente, posso creare array di altri oggetti, es. di stringhe
		
		String stringhe[] = new String[10];
		stringhe[0] = "Primo";
		stringhe[1] = "Secondo";
		stringhe[2] = "Terzo";
		
		for(int i=0;i<3;i++) 
			System.out.println(stringhe[i]); // Avrei potuto usare .length 
		                                     // MA ATTENZIONE, length FORNISCE
		                                     // IL NUMERO TOTALE DI CELLE
		                                     // ** NON ** IL NUMERO DI CELLE
		                                     // EFFETTIVAMENTE "UTILIZZATO" 
		
		// Che succede se si cerca di accedere ad una cella al di fuori dell'array?
		
		// L'istruzione che segue genera una ECCEZIONE (di tipo ArrayIndexOutOfBoundsException
		
		// Imparare ad interpretare questo tipo di situazioni/messaggi in rosso, errore alla riga ..., 
		// e dettagli, es. indice cella acceduta

		stringhe[11]="Undicesima, non ci sta"; // Sono andato fuori dai limiti dell'array
		
		
		
		
	}

}
