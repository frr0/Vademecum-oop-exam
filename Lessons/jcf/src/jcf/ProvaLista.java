package jcf;
import java.util.*; // LinkedList

public class ProvaLista {

	// List, contenitore di gruppo del JCF che permette la creazione di 
	// una struttura dati che MANTIENE L'ORDINE DI INSERIMENTO ed i cui 
	// elementi SONO ACCESSIBILI PER INDICE
	
	public static void main(String[] args) {

		// LinkedList l = new LinkedList();
		
		// Le interfacce/classi del JCF sono "raw"
		
		// Ogni volta che le utilizzo dovrei "parametrizzarle" 
		// indicando dopo il nome di ciascuna occorrenza 
		// dell'interfaccia/classe, tra <>, il tipo di dato che 
		// intendero' memorizzare all'interno della struttura dati
		
		// Ad esempio <String>, <Automobile>, <Integer>, ecc.

		// Con la parametrizzazione, diventa impossibile aggiungere 
		// di un tipo diverso da quello definito nei simboli di < >

		// Aiuta a non commettere errori, errori segnalati da Eclipse

		/*
		List<String> l = new LinkedList<String>();
		
		l.add("Seconda");
		l.add("Terza");
		
	    // l.add(34); // Errore segnalato a COMPILE TIME
		
		// L'interfaccia Collection mette a disposizione solo il metodo add()

		// Con l'interfaccia List si ha la possibilità di inserire anche posizione voluta 

		// Ad esempio, si puo' inserire un elemento in posizione 0
		
		l.add(0, "Primo"); 
		
		// Ed anche sostituire elementi in una data posizione
		
		l.set(0, "Prima");
		
		// Posso stampare il contenuto usando toString() sulla collezione
		 
		// Velocemente, per verificare il contenuto, ma 
		// il formato di uscita sara'  [ , , ]

		// Perchè gli oggetti Automobile si stampino, la classe 
		// Automobile deve implementare toString(), pattern !!		

		String s = l.toString();
		System.out.println(s);

		// Se voglio stampare in un altro modo, posso / devo accedere ai singoli 
		// elementi della collezione, esempio utilizzando un costrutto di iterazione

		// Trattandosi di una lista, posso accedere per indice, con un for

		for(int i=0; i<l.size();i++)
		{ 
			Object o = l.get(i); // Nella singola posizione della lista c'è un Object 
			                     // (a meno che non abbia parametrizzato)
			System.out.println(o); // .toString() superfluo
		}
		
		// Posso anche verificare la presenza di un particolare oggetto nella
		// collezione, utilizzando il metodo contains()

		// Perchè la cosa funzioni, la classe Automobile deve implementare 
		// il metodo equals(), pattern !!
	
		if(l.contains("Prima")) // Viene chiamato equals() sugli elementi della lista
			System.out.println("Presente");
		else
			System.out.println("Assente");
		
		*/
		
		// Ora, posso memorizzare altri tipi di dato (struttura dati GENERICA)

		Collection<Automobile> l = new LinkedList<Automobile>(); 

		l.add(new Automobile("AB123CD","Fiat",1000));
		l.add(new Automobile("AA222CC","VW", 1600));
		
		// l.add("abc"); // Anche in questo caso, se parametrizzo con <Automobile>
		                 // il tentativo di inserimento di una stringa sarà
		                 // segnalato come errore da Eclipse a COMPILE TIME
		
		// Posso stampare i singoli elementi anche con un for-each
		
		System.out.println("-- Stampa collezione con for-each --");

		for(Object o : l)
			System.out.println(o.toString());
		
		if(l.contains(new Automobile("AB123CD","Fiat",1000))) 
			System.out.println("Presente");
		else
			System.out.println("Assente");
		
		// Posso spostarmi sui vari elementi della collezione, ad esempio 
		// per stamparli, in un terzo modo, ovvero attraverso un ITERATORE
		
		System.out.println("-- Stampa collezione con iteratori --");
		
		         // Ottengo un iteratore sulla collezione/lista l
		Iterator<Automobile> i = l.iterator(); 

		// L'iteratore, quando inizializzato, punta all'elemento
		// precedente il primo elemento, quindi per poterlo utilizzare
		// devo "muoverlo" (farlo avanzare) almeno una volta con next()
		
		do {
			Object o = i.next(); // Mi muovo sull'elemento successivo
			// Uso l'elemento corrente, ad esempio per stamparlo
			System.out.println(o); //i
		} while(i.hasNext()); // Continuo ad iterare finché ci sono elementi
		
		// L'iteratore è utile come alternativa a for/for-each, ed
		// ESSENZIALE in caso di modifiche alla collezione mentre la si scorre
		
	}

}






