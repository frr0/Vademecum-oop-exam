package collezioni;

//public abstract class Collezione {

public interface Collezione {

	// Obiettivo è creare una classe che possa fungere da collezione 
	// di oggetti, così GENERICA da poter RIMANDARE la scelta del 
	// TIPO DI DATO da memorizzare al suo interno ...
	
	// E ANCHE così flessibile da poter rimandare la scelta 
	// della sua DIMENSIONE (NUMERO di oggetti memorizzabili)
		
	// Partiamo dalle operazioni che potrebbero servire in tale collezione

	// Definiamo i metodi (pubblici), l'INTERFACCIA della classe Collezione
	
    							// Object, per restare generici
	public abstract void aggiungi( Object daAggiungere ); 
	// {
	
	// Potrei ora implementare il metodo
	// Dove vado a memorizzare questi oggetti?
	// Es. un array (dim. fissa), che potrei definire in 
	// questa stessa classe Collezione
	
	// Ma, se domani io volessi costruire
	// una struttura dati DINAMICA, la cui dimensione
	// puo' CRESCERE quando necessario? 
	// Se io avessi dichiarato l'array in questa classe
	// Collezione, dovrei andare a creare un'altra classe
	// e riscrivere tutto il codice necessario
	// (CON UN APPROCCIO NON BASATO SULL'EREDITARIETA')
	
	// Per seguire, in generale, un approccio basato sulla
	// ereditarietà, potrei tenere la classe Collezione
	// così come è adesso, e definire una nuova classe
	// es. CollezioneArray come derivata (figlia, extends)
	// di Collezione
	
	// }

	
	public abstract int dimensione();
	/*{
		return -1;
	}*/
	
	public abstract String toString();
	/*{
		return null;
	}*/
	
	public abstract boolean contiene(Object daCercare );
	/*{
		return false;
	}*/
	
	
	
	
	
}
