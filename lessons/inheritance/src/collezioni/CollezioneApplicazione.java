package collezioni;

public class CollezioneApplicazione {

	public static void main(String[] args) {

		// Collezione cc = new Collezione();  // TROPPO GENERICA, COSA ME NE FAREI?
        									  // SE DICHIARATA abstract, ECLIPSE
        									  // SI ASSICURA CHE IO NON VADA AD
        									  // INSTANZIARLA (CON new)
		
		//CollezioneArray c = 
		//		new CollezioneArray();
		
		Collezione c = 
				new CollezioneLista(); // RIMANGO GENERICO (ARRAY/LISTA)
        							   // SE SO IL NUM. MASSIMO, SCELGO ES. ARRAY
        							   // ALTRIMENTI LISTA
	
		// Provo ad usare la classe per memorizzare degli oggetti String

		String s = new String("Prima");
		
		/*
		c.aggiungi(s);
		c.aggiungi("Seconda");
		c.aggiungi("Terza");
		*/
		//c.aggiungi(5);
		//c.aggiungi(false);
		
		// Provo ora ad usare la stessa classe per memorizzare degli oggetti Impiegato

		Impiegato i = new Impiegato("L. Neri", 50000);
		
		c.aggiungi(i);
		c.aggiungi(new Impiegato("A. Gialli", 20000));
		c.aggiungi(new Impiegato("M. Blu", 35000));
		c.aggiungi(new Impiegato("C. Rossi", 10000));
		 
		
		int n = c.dimensione();
		System.out.println("Dimensione: "+n);
		
		System.out.println("Contenuto della collezione:");
		System.out.println(c.toString());
		
		/*
		System.out.println("Ricerca di 'Seconda'");
		if(c.contiene("Seconda"))
			System.out.println("Presente");
		else
			System.out.println("Assente");
		*/
		
		System.out.println("Ricerca di A. Gialli, 20000");
		if(c.contiene(new Impiegato("A. Gialli", 20000)))
			System.out.println("Presente");
		else
			System.out.println("Assente");
		
		
		
		
	}

}
