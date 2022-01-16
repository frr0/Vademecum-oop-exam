package jcf;

import java.util.*;

public class ProvaOrdinamenti {

	public static void main(String[] args) {

		LinkedList<Automobile> l = new LinkedList<Automobile>();
		
		l.add(new Automobile("AB123CD", "Fiat", 1000));
		l.add(new Automobile("CC666DD", "VW", 1500));
		l.add(new Automobile("AA000AA", "Audi", 500));
		l.add(new Automobile("BB555AA", "Volvo", 1000));
		
		// Immaginiamo di voler ordinare la collezione secondo un qualche criterio

		// Per poter utilizzare sort(), gli elementi  memorizzati nella lista devono 
		// essere ordinabili/confrontabili, ovvero implementare l'interf. Comparable
		
		Collections.sort(l); 
		
		// Dopo aver chiamato questo metodo, la var. lista è ordinata
		// secondo l'algoritmo definito, ma ...
		
		// ... l'ordinamento iniziale E' ANDATO PERSO !!!
		
		// Potrei creare un'altra struttura dati (lista) e ordinare quella
		
		// Potrei copiare gli elementi uno ad uno, oppure ...
		
		// ... utilizzare il costruttore di LinkedList/ArrayList che riceve una coll./lista

		// Posso copiare il contenuto della mia lista in una nuova lista, 
		// e poi ordinare quella, ad esempio con un ciclo ... 
		
		// ... oppure con un costruttore della lista

		LinkedList copiedList = new LinkedList(l);  // Copia i riferimenti in l 
		                                            // nella nuova lista copiedList

		for(Object o : l)
			System.out.println(o);

		// Il metodo sort() invocato con un solo parametro ordina assumendo che la 
		// classe che rappresenta l'oggetto da ordinare implementi l'interfaccia 
		// Comparable, con il metodo compareTo()
		
		// In alternativa, se voglio poter ordinare in modi (con algoritmi) di volta 
		// in volta diversi, posso usare classi dedicate al confronto, dei "comparatori" 
		// che implementano l'interfaccia  Comparator ed il relativo metodo compare()
		
		Collections.sort(l, new ComparatoreDiAutomobiliPerCilindrata());

		// for(Object o : l)
		// 	System.out.println(o);

	}

}
