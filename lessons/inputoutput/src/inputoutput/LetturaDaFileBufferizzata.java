package inputoutput;

import java.io.*;

public class LetturaDaFileBufferizzata {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("input.txt");

			// Lettura di un file, riga per riga
			
			// Potrei usare un array di char ... oppure un BufferedReader
			
			                    // Riceve come parametro un FileReader
			BufferedReader br = new BufferedReader(fr);
		
			// E mette a disposizione il metodo readLine()
			
			String riga;        // null quando non ci sono piu' righe
			while( (riga = br.readLine()) !=null )
				System.out.println(riga);
			
			// Dovrei chiudere tutti gli stream in ordine 
			// inverso rispetto all'apertura

			br.close();
			fr.close();
			
			// Gestisco in questo caso le eccezioni con approccio "tutto o niente", 
			// unico blocco try-catch intorno a tutto il codice funzionale

            // In alternativa, o in aggiunta, blocco try-catch solo intorno 
			// alla/e istruzione/i "critica/che", gestendo così, ad esempio
			// specifiche righe con errori
		
		} catch (IOException e) {
			// Evitare di lasciare il blocco catch del tutto vuoto !!
			e.printStackTrace();
		}
		
		
		
	}

}
