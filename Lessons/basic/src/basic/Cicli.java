package basic;

public class Cicli {

	public static void main(String[] args) {
	
		// Costrutti di iterazione: obiettivo, ripetere un certo numero 
		// di istruzioni, es. contenute in un blocco di parentesi { }

		// Costrutti disponibili in Java, quelli del C: for, while, do-while
		
		// Equivalenti, ma, alcuni più adatti di altri in base alla
		// particolare situazione considerata

		// Scrivere una iterazione per stampare i numeri int. da 1 a 10 (es., con un FOR)
		
		
		System.out.println("**** Costrutto FOR ***");
		
		int i; // Contatore
		    
		   //INIZIALIZZAZIONE DELLA CONDIZIONE
		         // VERIFICA DELLA CONDIZIONE (DI PERMANENZA NEL CICLO)
		               // AGGIORNAMENTO DELLA CONDIZIONE
		for(i=0; i<10; i=i+1) { // i=i+2 per stampare solo i dispari
			// QUI, DENTRO LE PARENTESI {}, METTO LE ISTRUZIONI DA RIPETERE
			System.out.print((i+1)+"\n"); // println()
		} // CON UNA SOLA ISTRUZIONE POTREI/AVREI POTUTO OMETTERE LE {}
		
		
		System.out.println("**** Costrutto WHILE ***");

		// INIZIALIZZAZIONE DELLA CONDIZIONE
		int j = 0;
		           // VERIFICA DELLA CONDIZIONE
		while( j<10 ) {
			System.out.println(j+1);
			// AGGIORNAMENTO DELLA CONDIZIONE
			j=j+1; // Anche scrivilbile come j++; in forma più compatta
		}
		
		
		System.out.println("**** Costrutto DO-WHILE");
		
		// Costrutto DO-WHILE (CICLO CHE VIENE ESEGUITO ALMENO 1 VOLTA)

		// INIZIALIZZAZIONE DELLA CONDIZIONE
		int k = 0;
		do {
			System.out.println(k+1);
			k++;
			// AGGIORNAMENTO DELLA CONDIZIONE
		} while ( k<10 ); // VERIFICA DELLA CONDIZIONE

	}

}







