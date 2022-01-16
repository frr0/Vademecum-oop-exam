package collezioni;

//public class CollezioneArray extends Collezione {
public class CollezioneArray implements Collezione {

	// Una possibile implementazione della collezione, con una
	// struttura dati di tipo array di Object (generico)
	
	// Rispetto a Collezione, la classe CollezioneArray
	//  aggiunge l'array
	//  eredita tutti i metodi di Collezione
	//  e li modifica (in override), fornendone una implementazione adatta per l'array
	
	private Object array[];
	private int cnt;
	
	public CollezioneArray() {
		array = new Object[100];
		cnt = 0;
	}

	// Eredita tutti i metodi di Collezione
	// (che pero' sono vuoti, nessuna implementazione)
	
	// Adesso però so dove memorizzare gli oggetti
	
	// Posso fare l'override dei (ridefinire i)  
	// metodi della classe Collezione, fornendo
	// loro una implementazione specifica
	
	// ATTENZIONE ALLE FIRME DEI METODI (QUELLA DEL PADRE)
	
	// In override rispetto al metodo di Collezione
	
	@Override
	public void aggiungi(Object daAggiungere) {
		array[cnt] = daAggiungere;
		cnt++; // Lo uso come indice per inserire, 
		       // e mi dice quanti oggetti ci sono
		
		// Oppure, magari, con un ciclo che cerca la 
		// prima cella vuota dove inserire

	}

	// Anche i metodi che seguono sono in override rispetto 
	// ai metodi di Collezione

	@Override
	public int dimensione() {
		return cnt; 
	}

	@Override
	public String toString() {
		String s = "";
		for(int i=0;i<cnt;i++)
			s+=array[i].toString()+"\n"; // Anche senza esplicitare toString()
		return s;
	} // La collezione si sa descrivere (come contenuto)
	  // a patto che gli oggetti che andiamo a memorizzare
	  // al suo interno sappiano descriversi (toString())
	  // (stiamo DELEGANDO a quegli oggetti il compito di descriversi)

	@Override
	public boolean contiene(Object daCercare) {

		// Con un ciclo for e return true appena trovo un match 

		for(int i=0;i<cnt;i++) // Non con == 
			if(array[i].equals(daCercare)) // Se uguali ...
				return true; // Trovato
		
		// Oppure dichiarando un flag 

		return false; // Non trovato
	}
	
	
	
	
}
