package it.polito.po.test;
import polichef.*;
import java.io.*;
import java.util.*;
import junit.framework.TestCase;

public class TestR4_LetturaDaFile extends TestCase {

	private static String writeFile(String content) throws IOException {          
	    File f = File.createTempFile("dati","txt");
	    FileOutputStream fos = new FileOutputStream(f);
	    fos.write(content.getBytes());
	    fos.close();
	    return f.getAbsolutePath();
	}
	
	public void testLeggiDaFile() throws IOException{
		
		System.out.println("\n*** R4. testLeggiDaFile() ***\n");
		
	    String stringa = "C;Gianni;Azzurri;Pilota\nP;Bucatini all'amatriciana;Gianni A.\nC;Luigi;Blu\n";
	    
	  	String file = writeFile(stringa);
		
		Trasmissione t = new Trasmissione();

	  	System.out.println("Contenuto del file da leggere\n");

	  	System.out.println(""+stringa);	  	
	  	
		System.out.println("Lettura dati da file e costruzione struttura dati");
	  	
	  	t.leggiDaFile(file);
	  	
		System.out.println("\nElenco concorrenti (ordine alfabetico per nome e cognome)");
		LinkedList<Concorrente> listaConcorrenti = new LinkedList<Concorrente>(t.elencoConcorrenti());
		for(Concorrente ctemp : listaConcorrenti)
			System.out.println(" "+ctemp.getNome()+" "+ctemp.getCognome()+" (professione "+ctemp.getProfessione()+")");

		System.out.println("\nElenco piatti (ordine alfabetico per nome)");
		LinkedList<Piatto> listaPiatti = new LinkedList<Piatto>(t.elencoPiattiPerNome());
		for(Piatto ptemp : listaPiatti)
			System.out.println(" "+ptemp.getIdPiatto()+" "+ptemp.getNome()+" (concorrente "+ptemp.getIdConcorrente()+")");

		Concorrente c1 = listaConcorrenti.get(0);
		Concorrente c2 = null;
		try {
			c2 = listaConcorrenti.get(1);
		}
		catch(Exception e) {
			
		}
		
		Piatto p1 = listaPiatti.get(0);
		Piatto p2 = null;
		try {
			listaPiatti.get(1);
		}
		catch(Exception e) {
			
		}
		
		boolean corretto = false;

		if(c1.getNome().compareTo("Gianni")==0 && p1.getNome().compareTo("Bucatini all'amatriciana")==0 && c2==null && p2==null) 
		{
			System.out.println("\nInformazioni lette dal file in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni lette dal file in maniera errata");
			
		assertEquals("Implementazione del metodo leggiDaFile() e/o dei metodi correlati errata", true,corretto);
	}	
}

