package inputoutput;

import java.io.*;

public class LetturaDaFile {

	public static void main(String[] args) { // throws FileNotFoundException {

		// Eclipse/Java ci informano del fatto che l'istruzione 
		// può scatenare eccezioni, es., di tipo FileNotFoundException 
		// che DEVONO essere intercettate/gestite
		
		// Checked exception(s), DEVO necessariamente 
		// mettere try-catch o throws
		
		try {
			
			// Apro il file
			FileReader fr = new FileReader("input.txt");
			
			// Ora posso lavorare sul file, ad esempio per leggere 
			// un carattere nella variabile c, per poi stamparla
			
			// Lettura di un carattere da file
			
			/*
			char c = (char) fr.read(); // Devo "convertirla" in char
		
			System.out.println(c);
			*/

			// Lettura di un intero file, carattere per carattere

			int c;
			while(  (c = fr.read()) !=-1 ) {  // read() restituisce -1 quando non 
				                              // ci sono piu' caratteri
				//c = fr.read(); // Scatena IOException
				System.out.print((char)c);
			}
			
			fr.close(); // Da non dimenticare
		
			// Posso indicare più di un blocco catch
			// Verra' eseguito il piu' specifico (gerarchia)
			
		} catch (FileNotFoundException fnfe) {
			//System.out.println("Eccezione, file inesistente");
			//System.out.println(fnfe);
			fnfe.printStackTrace(); // Stampa la traccia dell'eccezione
		} catch (IOException ioe) { // Più generica
			//System.out.println("Eccezione nella lettura da file");
			ioe.printStackTrace();
		} catch (Exception e) {
			//System.out.println("Eccezione generica");
			e.printStackTrace();
		}		
		
		
		
	}

}
