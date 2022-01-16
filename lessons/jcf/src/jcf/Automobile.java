package jcf;

// Per fare si che una collezione di oggetti Automobile
// sia ordinabile (Collections.sort()), è necessario
// che l'Automobile metta a disposizione un metodo
// per il confronto uno-ad-uno (compareTo()) definito
// nell'interfaccia Comparable

// Java "forza" questa operazione chiedendo a quegli oggetti di
// implementare l'interfaccia Comparable (che definisce proprio quel
// metodo, in maniera astratta)

								   //Posso parametrizzare con <Automobile>
public class Automobile implements Comparable<Automobile> {

	String targa;
	String marca;
	int cilindrata;
	
	public Automobile(String targa, String marca, int cilindrata) {
		this.targa = targa;
		this.marca = marca;
		this.cilindrata = cilindrata;
	}

	// Se voglio che il mio oggetto si "stampi" (si "descriva") 
	// (DELEGA) vado a ridefinire il metodo toString() di Object, 
	// cosi' quando si cerchera' di stampare il contenuto dell'array, 
	// Java invochera' il metodo piu' specifico qui definito, e non
	// la versione generica definita in / ereditata da Object
	// (che stampa solo lo UID)

	@Override
	public String toString() {
		return targa+" - "+marca+" - "+cilindrata;
	}

	// Se voglio confrontare due oggetti in maniera diversa da 
	// == devo andare a ridefinire nella classe che descrive l'oggetto
	// il metodo "standard" per il confronto ereditato da Object, 
	// ovvero equals(), devo dire all'Automobile come confrontarsi
	// con un altro oggetto dello stesso tipo

	@Override
	public boolean equals(Object obj) {

		// Algoritmo di confronto (quando due automobili possono essere dette uguali)

		// Prima cosa, mi creo una variabile temporanea di tipo 
		// Automobile (in questo caso) e ci copio dentro il parametro obj

		Automobile other = (Automobile)obj;

		// Poi, scrivo il MIO algoritmo ... complicato a piacere 

		// Se per me, ad esempio, due oggetti Automobile sono uguali 
		// se possiedono la stessa targa, allora ... 

		if(this.targa.compareTo(other.targa)==0 &&
		   this.marca.compareTo(other.marca)==0 &&
		   this.cilindrata == other.cilindrata) // ... se anche cilindrata ...
			return true; // Uguali
		else
			return false; // Diversi
	
	}

	// Quello che segue e' il metodo di cui devo fornire una implementazione
	// per rendere l'oggetto/la classe Automobile confrontabile (ordinabile)
	
	// <0 se this "precede" obj
	// == 0 se this "e' uguale" ad obj
	// >0 se this "segue" obj

	@Override         
	public int compareTo(Automobile obj) { // Object, se non < >

		// Sta a me definire l'algoritmo di confronto / ordinamento, come per equals()

		Automobile other = (Automobile)obj; // Se parametrizzato posso evitarlo
		
		// Algoritmo semplice, che ordina considerando la cilindrata 

		//return this.cilindrata-other.cilindrata; // -

		// Oppure, algoritmo piu' sofisticato che considera contemporaneamente 
		// (insieme) più attributi della classe Automobile (ordino es. per 
		// cilindrata e, in caso di cilindrata uguale, per targa, ecc.)
		
		if(this.cilindrata-other.cilindrata==0)
			return -this.targa.compareTo(other.targa);
		else
			return this.cilindrata-other.cilindrata;	
		
	}
	
}
