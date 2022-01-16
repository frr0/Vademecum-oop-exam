package exceptions;

public class ProvaEccezioni {

	public static void main(String[] args) {

		// Provo a generare diversi tipi di eccezioni...
		
		// *** Ad esempio, ArrayIndexOutOfBoundsException

        // Con length (quindi, non i<3, ma i<array.length) 
        // io programmatore posso anticipare l'errore

		int array[] = {10, 30, 70};
		for(int i=0;i<3;i++) //4
			System.out.println(array[i]); // SE ACCEDO A CELLA FUORI DA ARRAY, ECCEZIONE

		
		// *** Altro esempio di eccezione, di tipo NullPointerException, 
		//     invocando un metodo, es. toString(), su un riferimento (cella) a null

		String stringhe[] = new String[4];
		stringhe[0] = "abc";
		stringhe[1] = "bcd";
		stringhe[2] = "efg";
		
		for(int i=0 ;i< stringhe.length; i++) // length restituisce la dim. allocata, non il numero di celle occupate
			if(stringhe[i]!=null) // POSSO AGGIUNGERE UN CONTROLLO, PER EVITARE l'eccezione
				System.out.println(stringhe[i].toString());
		            // Se su una cella null (su un riferimento a null)
		            // io vado ad invocare un metodo toString()
		            // viene scatenata una NullPointerException
			
		// Si tratta di situazioni "prevedibili", che posso evitare, ad esempio,
		// con un if (se non verificassi, eccezione), ma questo e' l'approccio "boring"

		// *** Altro esempio, eccezione di tipo ClassCastException

		// Impiegato i = (Impiegato)new Manager();  // Impiegato <- Manager, UP-CASTING, LECITO, anche senza cast
		
		Manager m;	
		Impiegato i = new Impiegato();
		// m = (Manager) i; // DOWN-CASTING
		
		// Accettata da Java/Eclipse a COMPILE TIME ...
		// ... MA ECCEZIONE A RUN TIME (ClassCastException)
		
		// Potrei evitare l'eccezione facendo opportune verifiche 

		if(i instanceof Manager) // Con istanceof
			m = (Manager) i; // Oppure .getClass()
		
		System.out.println("Qui ho finito!");

	}

}
