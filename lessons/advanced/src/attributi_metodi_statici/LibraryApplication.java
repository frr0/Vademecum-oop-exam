package attributi_metodi_statici;

public class LibraryApplication {

	public static void main(String[] args) {

		// int numCopie = 0; // Per tener conto del numero totale di copie potrei 
		                     // dichiare numcopie qui, simile ad una variabile 
		                     // "globale" (del C), ma è una informazione che 
		                     // dovrebbe/potrebbe stare nel libro (Book)
		
		// Dimostrazione uso degli attributi statici
		
		Book b1 = new Book();
		
		//System.out.println(b1.numCopies);
		
		b1.title = "Il nome della rosa";
		b1.author = "U. Eco";
		b1.numCopies++; // Incrementato la var. statica
		
		System.out.println(b1.numCopies);
		
		Book b2 = new Book();
		b2.title = "Il nome della rosa";
		b2.author = "U. Eco";
		b2.numCopies++; // Qui, di nuovo, sempre la stessa

		System.out.println(b2.numCopies);
		
		// Se numCopies è static, accedo sempre alla stessa cella di memoria
		
		// Una sorta di variabile globale, ma con una sintassi OOP

		// Anche quando usiamo System.out stiamo facendo uso di questa caratteristica
		
		// System.out // out è un attributo definito come static dalla classe System
		
	}

}
