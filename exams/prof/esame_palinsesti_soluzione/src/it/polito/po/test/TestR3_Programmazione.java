package it.polito.po.test;

import palinsesti.*;
import junit.framework.*;

public class TestR3_Programmazione extends TestCase{

	public void testDefinisciProgrammazioneSaltuaria() throws PalinsestoInesistenteException, ProgrammaInesistenteException{
		
		System.out.println("\n*** R3. testDefinisciProgrammazioneSaltuaria() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito nuovo palinsesto");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");

		System.out.println("\nDefinito nuovo programma palinsesto 'Primavera/Estate' per 'Rai Uno'");
		String id = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Finale Europa League", "Partita di calcio");
		System.out.println("\nId assegnato: ");
		System.out.println(" "+id);

		System.out.println("\nDefinisci programmazione saltuaria programma '"+id+"'");
		gp.definisciProgrammazioneSaltuaria(id, "20180329", "2100", 130);

		System.out.println("\nStampa del palinsesto 'Primavera/Estate' di 'Rai Uno'");
		String risultato = gp.stampaPalinsesto("Primavera/Estate", "Rai Uno");
		System.out.println(""+risultato);
		
		boolean corretto = false;
	
		if((risultato.contains("20180330") || risultato.contains("20180329")) && risultato.contains("2100") && risultato.contains("Finale Europa League") && risultato.contains("130") )
		{
			System.out.println("\nInformazioni relative alla programmazione gestite in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione delle informazioni relative alla programmazione");
			
		assertEquals("Implementazione del metodo definisciProgrammazioneSaltuaria() e/o dei metodi correlati errata", true,corretto);	
	}	

	
	public void testStampaPalinsesto() throws PalinsestoInesistenteException, ProgrammaInesistenteException{
		
		System.out.println("\n*** R3. testStampaPalinsesto() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito palinsesto e programmi");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");

		System.out.println("\nDefiniti programmi");
		String ida = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Semifinale Europa League", "Partita di calcio");
		String idb = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Quarti di finale Europa League", "Partita di calcio");
		String idc = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Finale Europa League", "Partita di calcio");
		
		System.out.println("\nDefinisci programmazione saltuaria programmi");
		gp.definisciProgrammazioneSaltuaria(idb, "20180415", "2100", 130);
		gp.definisciProgrammazioneSaltuaria(ida, "20180329", "2100", 130);
		gp.definisciProgrammazioneSaltuaria(idc, "20180701", "1200", 200);
		
		System.out.println("\nStampa del palinsesto 'Primavera/Estate' di 'Rai Uno'");
		String risultato = gp.stampaPalinsesto("Primavera/Estate", "Rai Uno");
		System.out.println(""+risultato);
		
		
		boolean corretto = false;
	
		if(risultato.compareTo("20180330, 2100, Semifinale Europa League, 130\n20180416, 2100, Quarti di finale Europa League, 130\n20180702, 1200, Finale Europa League, 200")==0 ||
		   risultato.compareTo(" 20180330, 2100, Semifinale Europa League, 130\n 20180416, 2100, Quarti di finale Europa League, 130\n 20180702, 1200, Finale Europa League, 200")==0 ||
		   risultato.compareTo("20180329, 2100, Semifinale Europa League, 130\n20180415, 2100, Quarti di finale Europa League, 130\n20180701, 1200, Finale Europa League, 200")==0 ||
		   risultato.compareTo(" 20180329, 2100, Semifinale Europa League, 130\n 20180415, 2100, Quarti di finale Europa League, 130\n 20180701, 1200, Finale Europa League, 200")==0)
		{
			System.out.println("\nStampa palinsesto gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella stampa del palinsesto");
			
		assertEquals("Implementazione del metodo stampaPalinsesto() e/o dei metodi correlati errata", true,corretto);	
	}	

	
	public void testDefinisciProgrammazioneGiornaliera() throws PalinsestoInesistenteException, ProgrammaInesistenteException{
		
		System.out.println("\n*** R3. testDefinisciProgrammazioneGiornaliera() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito nuovo palinsesto");
		gp.definisciPalinsesto("Carnevale", "Gulp", "20180210", "20180215");

		System.out.println("\nDefinito nuovo programma palinsesto 'Carnevale' per 'Gulp'");
		String id = gp.definisciProgramma("Carnevale", "Gulp", "Paperi in famiglia", "Generico");

		System.out.println("\nDefinisci programmazione giornaliera programma '"+id+"'");
		gp.definisciProgrammazioneGiornaliera(id, "1900", 45);

		System.out.println("\nStampa del palinsesto 'Carnevale' di 'Gulp'");
		String risultato = gp.stampaPalinsesto("Carnevale", "Gulp");
		System.out.println(""+risultato);
		
		boolean corretto = false;
		
		if(risultato.compareTo("20180210, 1900, Paperi in famiglia, 45\n20180211, 1900, Paperi in famiglia, 45\n20180212, 1900, Paperi in famiglia, 45\n20180213, 1900, Paperi in famiglia, 45\n20180214, 1900, Paperi in famiglia, 45\n20180215, 1900, Paperi in famiglia, 45")==0 ||
		   risultato.compareTo(" 20180210, 1900, Paperi in famiglia, 45\n 20180211, 1900, Paperi in famiglia, 45\n 20180212, 1900, Paperi in famiglia, 45\n 20180213, 1900, Paperi in famiglia, 45\n 20180214, 1900, Paperi in famiglia, 45\n 20180215, 1900, Paperi in famiglia, 45")==0)
		{
			System.out.println("\nInformazioni relative alla programmazione gestite in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione delle informazioni relative alla programmazione");
			
		assertEquals("Implementazione del metodo definisciProgrammazioneSaltuaria() e/o dei metodi correlati errata", true,corretto);	
	}	
	
	
	public void testDefinisciProgrammazioneSaltuariaGiornaliera() throws PalinsestoInesistenteException, ProgrammaInesistenteException{
		
		System.out.println("\n*** R3. testDefinisciProgrammazioneSaltuariaGiornaliera() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito nuovo palinsesto");
		gp.definisciPalinsesto("Carnevale", "Gulp", "20190230", "20190301");

		System.out.println("\nDefinito nuovo programma palinsesto 'Carnevale' per 'Gulp'");
		String id = gp.definisciProgramma("Carnevale", "Gulp", "Paperi in famiglia", "Generico");

		System.out.println("\nDefinisci programmazione saltuaria programma '"+id+"'");
		gp.definisciProgrammazioneSaltuaria(id, "20190231", "0800", 110);
		
		System.out.println("\nDefinisci programmazione giornaliera programma '"+id+"'");
		gp.definisciProgrammazioneGiornaliera(id, "1900", 45);

		System.out.println("\nStampa del palinsesto 'Carnevale' di 'Gulp'");
		String risultato = gp.stampaPalinsesto("Carnevale", "Gulp");
		System.out.println(""+risultato);
		
		boolean corretto = false;
		 
		if(risultato.compareTo("20190230, 1900, Paperi in famiglia, 45\n20190231, 1900, Paperi in famiglia, 45\n20190301, 0800, Paperi in famiglia, 110\n20190301, 1900, Paperi in famiglia, 45")==0 ||
		   risultato.compareTo(" 20190230, 1900, Paperi in famiglia, 45\n 20190231, 1900, Paperi in famiglia, 45\n 20190301, 0800, Paperi in famiglia, 110\n 20190301, 1900, Paperi in famiglia, 45")==0 ||
		   risultato.compareTo("20190230, 1900, Paperi in famiglia, 45\n20190231, 0800, Paperi in famiglia, 110\n20190231, 1900, Paperi in famiglia, 45\n20190301, 1900, Paperi in famiglia, 45")==0 ||
		   risultato.compareTo(" 20190230, 1900, Paperi in famiglia, 45\n 20190231, 0800, Paperi in famiglia, 110\n 20190231, 1900, Paperi in famiglia, 45\n 20190301, 1900, Paperi in famiglia, 45")==0	)	   
		
			 
		
		
		{
			System.out.println("\nProgrammazione e stampa palinsesto gestiti in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione della programmazione e della stampa palinsesto");
			
		assertEquals("Implementazione dei metodi per la definizione della programmazione e la stampa del palinsesto errata", true,corretto);	
	}	
}
