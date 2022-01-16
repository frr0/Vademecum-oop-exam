package basic;

public class Classi {

	public static void main(String[] args) {

		// Finora, non una vera applicazione dei dettami della programmazione 
		// ad oggetti: ora, problema reale, guardo ad un mondo fatto di oggetti reali

		// Creare una applicazione per memorizzare le informazioni relative ad
		// un garage, concessionaria, ecc. che contiene un certo numero di 
		// (COLLEZIONE DI) automobili 
		
		// Ogni automobile è caratterizzato da
		//  - targa (stringa)
		//  - marca (stringa)
		//  - modello (stringa)
		
		// Se avessi una sola automobile, potrei utilizzare variabili separate
		
		String targa1 = "AB123CD";
		String marca1 = "VW";
		String modello1 = "T Roc";
		
		String targa2 = "CC444DD";
		String marca2 = "Fiat";
		String modello2 = "Panda";

		// E così via ...
		
		// E se fossero ancora di piu'?
		
		// 1) Potrei continuare a dichiarare variabili 

		// 2) Potrei creare array di stringhe, stringhe, ecc. (array "paralleli")

		// 3) In linguaggio C, si sarebbe forse definita una struct, meglio perche' le 
		//    informazioni relative ad una particolare automobile sono mantenute insieme, 
	    //    Si potrebbero quindi creare strutture piu' sofisticate, aggregando piu' 
		//    istanze della struct 
				
		/*
		 struct Auto {
			char targa[100];
			char marca[100];
			char modello[100];
		}
		*/
		
		// In Java non ci sono le struct ... 
		
		// ... ma l'equivalente concettuale e' rappresentato 
		// dalla Classe, contenitore di dati (e operazioni sui dati), da utilizzare per 
		// creare eventualmente strutture dati piu' sofisticate (come prima, array, 
		// liste, ecc.)
		
		// Quindi, creazione della classe Automobile (processo di astrazione), 
		// si definisce la struttura dei dati, file Automobile.java
		
		// Dopo aver definito la classe, la struttura dell'automobile, per poterla utilizzare 
		// occorre crearne delle istanze, degli oggetti (in fondo, programmazione ad oggetti...)
		
		// Creazione di una istanza, un oggetto della classe Automobile 
		
		Automobile a0 = new Automobile();
		
		// Si potrebbe scrivere su due righe separate

		Automobile a1; // Variabile riferimento, l'oggetto non e' ancora stato creato
		
		a1 = new Automobile();
		
		// Per stampare l'automobile? Come per le stringhe, interi, ...         

		System.out.println(a1); // Stampa basic.Automobile@2f0e140b
								// E' lo UID dell'oggetto (sembra un puntatore del C)

		// Non funziona, perche' non si sta stampando l'oggetto, ma il contenuto 
		// della variabile riferimento. Si vede comparire a video uno strano valore
		
		// Come faccio a stampare targa, marca e modello?
		
		// Avendo il riferimento, si puo' accedere agli attributi (e metodi) 
		// dell'oggetto a1 utilizzando la NOTAZIONE PUNTATA (.)
		
		a1.targa="AB123CD"; // Valorizzo gli attributi, accedendovi in SCRITTURA
		a1.marca="VW";
		a1.modello="T Roc";
		//a1.accesa=false; // Se si volesse accedere ad un attributo della
		a1.spegni(); 	   // classe Automobile definito come private (es. accesa)?
                           // L'approccio basato sulla notazione puntata
		                   // non funziona/non funziona piu', occorre usare metodi (public),
  		                   // in questo caso invocazione del metodo spegni(), 
		                   // MESSAGE PASSING, DELEGA ed uso dell'INFORMATION HIDING
		
		System.out.println("Targa: "+a1.targa); // Accesso in LETTURA, es. per stamparli
		System.out.println("Marca: "+a1.marca);
		System.out.println("Modello: "+a1.modello);
		System.out.println("Accesa: "+a1.dimmiSeSeiAccesa()); //a1.accesa
		
		// Creazione di altri oggetti
		
		Automobile a2 = new Automobile();
		a2.targa="BB444DD";
		a2.marca="Fiat";
		a2.modello="Panda";
		a2.accendi();
		
		System.out.println("Targa: "+a2.targa);
		System.out.println("Marca: "+a2.marca);
		System.out.println("Modello: "+a2.modello);
		System.out.println("Accesa: "+a2.dimmiSeSeiAccesa()); //a2.accesa

		Automobile a3 = new Automobile();
		
		System.out.println("Targa: "+a3.targa);
		System.out.println("Marca: "+a3.marca);
		System.out.println("Modello: "+a3.modello);
		System.out.println("Cilindrata: "+a3.cilindrata);
		System.out.println("Accesa: "+a3.dimmiSeSeiAccesa());
		
		// Tornando al problema iniziale, COLLEZIONE di automobili ... 
		
		// ... si potrebbe continuare a dichiarare variabili di tipo Automobile
		
		// Oppure creare un array di oggetti di tipo Automobile, stabilendo un 
		// parallelismo, es., con la creazione di un array di un tipo primitivo
		
		// Esempio, un array di interi
		
		int arrayInteri[] = new int[10]; // Oppure con { }
		arrayInteri[0]=34;
		arrayInteri[1]=16;
		System.out.println("---- Array di interi ----");
		for(int i=0;i<2;i++) {
			int v = arrayInteri[i]; // Su due istruzioni per comodità
			System.out.println(v);
		}
		
		// Ora, per un array di automobili, uso il tipo 
		// Automobile al posto del tipo int
		
		Automobile arrayAutomobili[] = new Automobile[10];
		arrayAutomobili[0] = a1;
		arrayAutomobili[1] = a2;
		System.out.println("---- Array di automobili ----");
		for(int i=0;i<2;i++) {
			Automobile a = arrayAutomobili[i];
			//System.out.println(a); // Non a, ma a. (notazione puntata), accedendo agli attributi 
			                         // dell'oggetto, altrimenti viene stampato lo UID
			
			// Prima di accedere con . potrei/dovrei verificare che a non sia uguale a null
			System.out.println(a.targa+" "+a.marca+" "+a.modello);
		}
		
		
		
	}

}






