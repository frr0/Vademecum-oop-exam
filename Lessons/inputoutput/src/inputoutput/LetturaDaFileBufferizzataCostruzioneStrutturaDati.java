package inputoutput;

import java.util.LinkedList;
import java.io.*;

public class LetturaDaFileBufferizzataCostruzioneStrutturaDati {

	// Obiettivo: leggere un file di testo contentente una serie di
	// righe che descrivono altrettante automobili e costruire con essi/e
	// una struttura dati (es. lista) di oggetti di tipo Automobile

	public static void main(String[] args) {

		LinkedList<Automobile> lista = new LinkedList<Automobile>();
		
		try { 
			FileReader fr = new FileReader("auto.txt");

			BufferedReader br = new BufferedReader(fr);
		
			String riga;
			while( (riga = br.readLine()) !=null ) {
				// Qui io ho una riga letta con una automobile
				// nel formato targa, marca, ciclindrata
				// System.out.println(riga);
			
				// Posso ottenere un array in cui ogni cella contiene uno 
				// dei campi della riga (detti "token"), tutti come String
				// (nel caso del file in targa, marca, cilindrata)

				String array[] = riga.split(",");
				// array[0] targa
				// array[1] marca
				// array[2] ciclindrata
				
				try {
					String targa = array[0];
					String marca = array[1];
				    int cilindrata = Integer.parseInt(array[2]);  // Istruzione, potenzialmente "critica", puo'
															  // scatenare NumberFormatException

				    Automobile aTemp = new Automobile(targa, marca, cilindrata);
					
					lista.add(aTemp);
				}
				catch(NumberFormatException nfe) {
					
				}
				
				// Per il parseInt() potrei usare l'approccio "chirurgico", con 
				// try-catch intorno all'istruzione precedente, se ho problemi 
				// a convertire un campo per una riga, le altre righe vengono 
				// comunque elaborate
				
				// Eventuali verifiche di correttezza, es. del numero di token
				// if(array.length == 3) ...
				
				// Se tutto a posto, creazione degli oggetti e popol. della struttura dati

				// Automobile aTemp = new Automobile(targa, marca, cilindrata);
				
				// lista.add(aTemp);
				
			}
			
			br.close();
			fr.close();
		
			// Potrei stampare la lista e verificarne il contenuto
			
			for(Automobile a : lista)
				System.out.println(a.targa+" "+a.marca+" "+a.cilindrata);

			// Gestisco in questo caso le eccezioni con approccio "tutto o niente", 
			// unico blocco try-catch intorno a tutto il codice funzionale

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
