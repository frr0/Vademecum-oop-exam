package attributi_metodi_statici;

public class Book {

	String title; // Eventualmente private, non di interesse per questo esempio
	String author;
	
	// Con static esiste una sola copia della variabile/attributo 
	// numCopie nel programma, "condivisa" tra le diverse istanze create di Book

	static int numCopies;
	
	// Eventualmente costruttore, metodi
	// ...

}
