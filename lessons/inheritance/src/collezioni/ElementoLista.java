package collezioni;

public class ElementoLista {
	
	// Ogni elemento della lista possiede due attributi
	//  dato: che "contiene", "ospita" il valore da memorizzare, generico
	//  prossimo: "puntatore" (riferimento) all'elemento successivo della lista

	// Potrei / dovrei definirli private ...

	Object dato = null; // Sufficientemente generico
	ElementoLista prossimo = null;  // Sempre di tipo ElementoLista
	

	// ... definendo poi il costruttore e gli eventuali metodi getter / setter necessari

}
