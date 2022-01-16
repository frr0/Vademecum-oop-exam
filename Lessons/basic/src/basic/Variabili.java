package basic;

//Una classe un po' particolare, questa, non un vero contenitore di dati 
//ed operazioni sui dati, pero' possiede il main, puo' essere eseguita 
//(un'applicazione Java possiede almeno una classe dotata di main)


public class Variabili {

	public static void main(String[] args) {

		// Questo è un commento su una riga

		/*
		 * Questo è un commento su più righe
		 */		
		
		int x; // Dichiarazione di una variabile intera (su 32 bit)
		x = 5; // Assegnazione di un valore alla variabile (inizializ.)
		
		int y = 8; // Eventualmente su un'unica riga
		
		y = x * 3; // Anche con espressioni
		
		// Per stampare (nella console, standard output) una variabile in 
		// linguaggio C avrei dovuto scrivere
		
		// printf("%d", y); 
		
		// Eventuali altri modificatori %f %s %c, e concatenazione
		
		// printf("Il valore della variabile y e' %d", y);
		
		// In linguaggio Java, funzione System.out.print(...); 
		
		System.out.print(y);                 
		
		// In Java per concatenare tra piu' stringhe, costanti, variabili, 
		// espressioni, ecc. e' possibile utilizzare l'OPERATORE + 
		// detto "di CONCATENAZIONE" (se usato tra numeri continua a sommare)
		
		System.out.print("Il valore della variabile y e' "+y);
		
		// Altri tipi di dato primitivi di Java, come in C
		
		short z; // Intero su 16 bit 
		long w; // Intero su 64 bit
		
		float f; // Singola precisione
		double d; // Doppia precisione
		
		char c = 'C'; // in C i char sono su 8 bit in ASCII
		              // in Java i char sono su 16 bit e in UNICODE
		
		// Altri tipi di dato di Java, con differenze rispetto al C

		byte b; // Ottetto in CA2 -128 a +127

		boolean bool = true; // false
		
		d = 4.5;
		
		// Sempre con print() si possono stampare altri tipi di dato
		
		System.out.print(bool);                 

		// Piu' funzioni per stampare, es. println() per andare a capo 

		System.out.println(d); // Va a capo dopo aver stampato
		//System.out.print("\n"); // Potrei anche usare caretteri speciali come \n
		System.out.println(y);
		
		//System.out.println(d+"\n"+y); // Conviene essere compatti
		
		// Come creare stringhe in Java?
		
		// In C con un array di caratteri	
		
		// char stringa[100];

		// Lo si potrebbe fare anche in Java, ma si preferisce utilizzare un 
		// altro tipo di dato, specifico per questo tipo di informazioni, 
		// ovvero la classe String
		
		String s; // Dichiarato una variabile s di tipo String
				  // che può fare riferimento ad un oggetto 
		          // di quel tipo/di quella classe 
		          // (String è una CLASSE di Java)
		
		s = new String(); // Oggetto è stato creato in memoria
		                  // da costruttore String() ed inizializzato
		                  // al valore di default (che per le stringhe
		                  // è stringa vuota, ovvero "")
		
		String ss = new String("Ciao!"); // Passaggio di un parametro al costruttore, 
		                                 // stringa inizializzata con un valore specifico

		// Altro modo per creare un oggetto di tipo String

		String sss = "Ciao!"; // Scorciatoia concessa da Java, equivalenti
		
		       sss = "Altro che ciao!"; 
		       
		// Nelle strnghe si possono usare caratteri speciali \n, \t, ecc.
		       
	           sss = "Altro che\nciao!"; 
		       
	    // La funzione di stampa print()/println() continua a poter essere utilizzata

		System.out.println(sss); // La funzione si adatta al tipo di dato da 
		                         // stampare, concetto della OOP noto come POLIMORFISMO
		
		// char stringa[] = new char[100]; // Sintatticamente corretto
                                           // MA NON E' una stringa, è un array di char

		
	}

}
