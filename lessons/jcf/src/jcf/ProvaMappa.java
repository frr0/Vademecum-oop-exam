package jcf;

import java.util.*;

public class ProvaMappa {

	public static void main(String[] args) {

		// I contenitori associativi del JCF permettono di creare
		// una struttura dati che ASSOCIA UN VALORE ad una CHIAVE,
		// univoca, FACILITANDO l'ACCESSO / la RICERCA PER CHIAVE
		
		// Parametrizzazione, due tipi tra < , > in questo caso, 
		// per keys (K) e values (V)
		
		// Vantaggio della TreeMap rispetto a HashMap, è ordinata per chiave

		Map<String, Automobile> m 
							= new TreeMap<String, Automobile>();
		
		m.put("ZZ999CC", new Automobile("ZZ999CC", "Audi", 8000));
		m.put("AB123CD", new Automobile("ABC123CD", "Fiat", 1000));
		m.put("AA222EE", new Automobile("AA222EE", "VW", 1600));
		
		System.out.println("Dimensione: "+m.size());
		
		// Per stampare il contenuto della mappa 

		System.out.println("Contenuto:\n"+m); // Stampa nel formato { , , }

		// Object oo = m.get("AB123CD"); // < >
		
		// Automobile a = (Automobile)oo; // Downcast
		
		// Per stampare un elenco di automobili nel formato che voglio, 
		// occorre accedere alla colonna che contiene i valori tramite 
		// il metodo values(), che restituisce una Collection di oggetti 
		// Automobile (per accedere alla colonna delle chiavi, metodo keySet())

		// La Collection può essere scandita con un for-each ...

		for(Object o : m.values()) 
			System.out.println(o);
		
		// ... oppure con un for (ma devo prima ottenere una lista per
		// poter accedere agli elementi per indice)
		
		// Come creare una lista a partire dalla colonna con i valori di una mappa?

		// Usando new ed il costruttore della lista che riceve la collezione

		// LinkedList valori = (LinkedList)m.values();
		
		
		// Posso anche cercare un particolare elemento: ricerca per chiave facilitata

		System.out.println("Cerco l'auto con targa ZZ999CC");

		if(m.containsKey("ZZ999CC")) // Usa equals() sulla chiave
			System.out.println("Presente");
		else
			System.out.println("Assente");
		
		// E per ottenere l'oggetto (il valore), data la chiave
		
		Automobile a = m.get("AB123CD"); 
		System.out.println(a);
		
	}

}
