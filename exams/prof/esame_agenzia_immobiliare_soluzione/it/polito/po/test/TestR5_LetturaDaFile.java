package it.polito.po.test;

import agenzia_immobiliare.*;

import java.util.LinkedList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

public class TestR5_LetturaDaFile extends TestCase {

	private static String writeFile(String content) throws IOException {          
	    File f = File.createTempFile("dati","txt");
	    FileOutputStream fos = new FileOutputStream(f);
	    fos.write(content.getBytes());
	    fos.close();
	    return f.getAbsolutePath();
	}
	
	public void testLeggiDaFileClienti() throws IOException{
		
		System.out.println("\n*** R4. testLeggiDaFileClienti() ***\n");
		
	    String stringa = "I;VERONA;Via Bra 77;Abitazione indipendente;4;100;Un gioiello accanto all'Arena.\nC;NRIMRT88P11B111B;Neri;Marta\nC;BLUALS12P14B888C;Blu;Alessio\nT;VERONA1;NRIMRT88P11B111B;BLUALS12P14B888C;100000";
	    
	  	String file = writeFile(stringa);
		
		Agenzia a = new Agenzia();

	  	System.out.println("Contenuto del file da leggere\n");

	  	System.out.println(""+stringa);	  	
	  	
		System.out.println("\nLettura da file e costruzione struttura dati");
	  	
	  	a.leggiDaFile(file);
	  	
	  	System.out.println("\n* Elenco clienti (ordinati per codice fiscale)\n");
		
		LinkedList<Cliente> listaClienti = new LinkedList<Cliente>(a.elencoClientiOrdineDiCodiceFiscale());
		for(Cliente c : listaClienti)
			System.out.println(c.getCodiceFiscale()+" "+c.getCognome()+" "+c.getNome());

		boolean corretto = false;

		if(listaClienti.size()==2 && 
		   (listaClienti.get(0).getCodiceFiscale().compareTo("NRIMRT88P11B111B")==0 || listaClienti.get(1).getCodiceFiscale().compareTo("NRIMRT88P11B111B")==0) && 
		   (listaClienti.get(0).getCodiceFiscale().compareTo("BLUALS12P14B888C")==0 || listaClienti.get(1).getCodiceFiscale().compareTo("BLUALS12P14B888C")==0))
		{
			System.out.println("\nInformazioni relative ai clienti lette dal file e memorizzate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni relative ai clienti lette dal file e/o memorizzate in maniera errata");
			
		assertEquals("Implementazione del metodo leggiDaFile() e/o dei metodi correlati errata", true,corretto);
	}	
	
	
	
	
	
	public void testLeggiDaFileImmobile() throws IOException{
		
		System.out.println("\n*** R4. testLeggiDaFileImmobile() ***\n");
		
	    String stringa = "I;VERONA;Via Bra 77;Abitazione indipendente;4;100;Un gioiello accanto all'Arena.\nC;NRIMRT88P11B111B;Neri;Marta\nC;BLUALS12P14B888C;Blu;Alessio\nT;VERONA1;NRIMRT88P11B111B;BLUALS12P14B888C;100000";
	    
	  	String file = writeFile(stringa);
		
		Agenzia a = new Agenzia();

	  	System.out.println("Contenuto del file da leggere\n");

	  	System.out.println(""+stringa);	  	
	  	
		System.out.println("\nLettura da file e costruzione struttura dati");
	  	
	  	a.leggiDaFile(file);
	  	
		System.out.println("\n* Elenco schede (ordinate per identificativo)\n");
		
		LinkedList<SchedaImmobile> listaSchede = new LinkedList<SchedaImmobile>(a.elencoSchedeOrdineDiIdentificativo());
		for(SchedaImmobile s : listaSchede)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		boolean corretto = false;

		if(listaSchede.size() == 1 &&
		   listaSchede.get(0).getIdSchedaImmobile().compareTo("VERONA1")==0)
		   
		{
			System.out.println("\nInformazioni relative all'immobile lette dal file e memorizzate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni relative all'immobile lette dal file e/o memorizzate in maniera errata");
			
		assertEquals("Implementazione del metodo leggiDaFile() e/o dei metodi correlati errata", true,corretto);
	}	
	
	
	
	public void testLeggiDaFileTransazione() throws IOException{
		
		System.out.println("\n*** R4. testLeggiDaFileTransazione() ***\n");
		
	    String stringa = "I;VERONA;Via Bra 77;Abitazione indipendente;4;100;Un gioiello accanto all'Arena.\nC;NRIMRT88P11B111B;Neri;Marta\nC;BLUALS12P14B888C;Blu;Alessio\nT;VERONA1;NRIMRT88P11B111B;BLUALS12P14B888C;100000";
	    
	  	String file = writeFile(stringa);
		
		Agenzia a = new Agenzia();

	  	System.out.println("Contenuto del file da leggere\n");

	  	System.out.println(""+stringa);	  	
	  	
		System.out.println("\nLettura da file e costruzione struttura dati");
	  	
	  	a.leggiDaFile(file);
	  	
	  	System.out.println("\n* Elenco clienti (ordinati per codice fiscale)\n");
		
		LinkedList<Cliente> listaClienti = new LinkedList<Cliente>(a.elencoClientiOrdineDiCodiceFiscale());
		for(Cliente c : listaClienti)
			System.out.println(c.getCodiceFiscale()+" "+c.getCognome()+" "+c.getNome());

		System.out.println("\n* Elenco schede (ordinate per identificativo)\n");
		
		LinkedList<SchedaImmobile> listaSchede = new LinkedList<SchedaImmobile>(a.elencoSchedeOrdineDiIdentificativo());
		for(SchedaImmobile s : listaSchede)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		
		System.out.println("\n* Stampa transazioni (per importo ed identificativo scheda immobile):\n");
		String transazioni = a.stampaTransazioniOrdineDiImportoIdScheda();
		System.out.println(""+transazioni);
	  	
	  	
		
		boolean corretto = false;

		if(listaClienti.size()==2 && 
		   (listaClienti.get(0).getCodiceFiscale().compareTo("NRIMRT88P11B111B")==0 || listaClienti.get(1).getCodiceFiscale().compareTo("NRIMRT88P11B111B")==0) && 
		   (listaClienti.get(0).getCodiceFiscale().compareTo("BLUALS12P14B888C")==0 || listaClienti.get(1).getCodiceFiscale().compareTo("BLUALS12P14B888C")==0) && 
		   listaSchede.size() == 1 &&
		   listaSchede.get(0).getIdSchedaImmobile().compareTo("VERONA1")==0 && 
		   transazioni.contains("100 VERONA1 NRIMRT88P11B111B BLUALS12P14B888C 100000.0"))
		   
		{
			System.out.println("\nInformazioni lette dal file e memorizzate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni lette dal file e/o memorizzate in maniera errata");
			
		assertEquals("Implementazione del metodo leggiDaFile() e/o dei metodi correlati errata", true,corretto);
	}	
	
}


