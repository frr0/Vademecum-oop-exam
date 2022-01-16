package jcf;

import java.util.*;

// ALTERNATIVA all'uso dell'interfaccia Comparable (per la classe da rendere
// CONFRONTABILE/ORDINABILE) è l'interfaccia Comparator

// Piuttosto che, nella classe che descrive l'oggetto (es. Automobile), 
// implementare Comparable che fornisce un'implementazione del metodo 
// compareTo() contenente L'ALGORITMO DI CONFRONTO *** TRA this 
// ED UN ALTRO OGGETTO *** ...

// ... si crea una classe "COMPARATORE" (come questa) che implementa Comparator

// La classe fornisce una implementazione del metodo *** compare() ***, 
// contenente l'ALGORITMO DI CONFRONTO TRA *** DUE OGGETTI ***

public class ComparatoreDiAutomobiliPerCilindrata implements Comparator //  <Automobile>
{
					
	@Override           // Se parametrizz. con <Automobile>, allora (Automobile a1, Automobile a2)
	public int compare(Object o1, Object o2) { // DUE OGGETTI DA CONFRONTARE, IN QUESTO CASO !!

		Automobile a1 = (Automobile)o1;
		Automobile a2 = (Automobile)o2;
	
		return a1.cilindrata-a2.cilindrata; // Confronto per cilindrata
		
	}
	
}
