package it.polito.po.test;

import java.io.*;
import java.util.LinkedList;

import palinsesti.*;
import junit.framework.*;

public class TestR4_LetturaDaFile extends TestCase {

	private static String writeFile(String content) throws IOException {          
	    File f = File.createTempFile("palinsesti","txt");
	    FileOutputStream fos = new FileOutputStream(f);
	    fos.write(content.getBytes());
	    fos.close();
	    return f.getAbsolutePath();
	}

	
	public void testLeggi() throws IOException{
		
		System.out.println("\n*** R4. testLeggi() ***\n");

	    String stringa = "PA;Autunno/Inverno;Rai Uno;20180921;20190320\nPA;Autunno/Inverno;Rai Due;20180921;20190320\nPA;Pasqua;Rai Tre;20180328;20190404\nPR;Pasqua;Rai Tre;Quarti Coppa Italia;Partita calcio\nPR;Pasqua;Rai Tre;Un posto al sole;Serie TV\nPR;Pasqua;Rai Tre;Che tempo che fa;Generico";
	    //String stringa = "PA;Autunno/Inverno;Rai Uno;20180921;20190320\nPA;Autunno/Inverno;Rai Due;20180921;20190320\nPA;Pasqua;Rai Tre;20180328;20190404\nPR;Pasqua;Rai Tre;Un posto al sole;Serie TV\nPR;Pasqua;Rai Tre;Che tempo che fa;Generico";
	    
	  	String file = writeFile(stringa);
		
		GestionePalinsesti gp = new GestionePalinsesti();

	  	System.out.println("Contenuto del file da leggere\n");

	  	System.out.println(""+stringa);	  	
	  	
	  	System.out.println("\nCaricamento delle informazioni relative a palinsesti e programmi da file");
	  	
	  	gp.leggi(file);
	  	
		System.out.println("\nElenco palinsesti (ordine di inserimento):");
		LinkedList<Palinsesto> listaPalinsesti = new LinkedList<Palinsesto>(gp.elencoPalinsesti());
		for(Palinsesto ptemp : listaPalinsesti){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getCanale()+", "+ptemp.getDa());
		}

		System.out.println("\nElenco programmi (ordinati per nome programma, nome palinsesto e canale):");
		LinkedList<Programma> listaProgrammi = new LinkedList<Programma>(gp.elencoProgrammi());
		for(Programma ptemp : listaProgrammi){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getPalinsesto().getNome()+", "+ptemp.getPalinsesto().getCanale());
		}
		
		Palinsesto pa0 = listaPalinsesti.get(0);
		Palinsesto pa1 = listaPalinsesti.get(1);
		Palinsesto pa2 = listaPalinsesti.get(2);

		Programma pr0 = listaProgrammi.get(0);
		Programma pr1 = listaProgrammi.get(1);
		Programma pr2 = null;
		try {
			pr2 = listaProgrammi.get(2);
		}
		catch(Exception e) {
			
		}

		boolean corretto = false;

		if((pa0.getNome().compareTo("Autunno/Inverno")==0 && pa0.getCanale().compareTo("Rai Uno")==0 && pa0.getDa().compareTo("20180921")==0 &&
      	   pa1.getNome().compareTo("Autunno/Inverno")==0 && pa1.getCanale().compareTo("Rai Due")==0 && pa1.getDa().compareTo("20180921")==0 &&
		   pa2.getNome().compareTo("Pasqua")==0 && pa2.getCanale().compareTo("Rai Tre")==0 && pa2.getDa().compareTo("20180328")==0) &&
		   ((pr0.getNome().compareTo("Che tempo che fa")==0 && pr0.getPalinsesto().getNome().compareTo("Pasqua")==0 && pr0.getPalinsesto().getCanale().compareTo("Rai Tre")==0 && 
		   pr1.getNome().compareTo("Un posto al sole")==0 && pr1.getPalinsesto().getNome().compareTo("Pasqua")==0 && pr1.getPalinsesto().getCanale().compareTo("Rai Tre")==0)||
		   (pr0.getNome().compareTo("Che tempo che fa")==0 && pr0.getPalinsesto().getNome().compareTo("Pasqua")==0 && pr0.getPalinsesto().getCanale().compareTo("Rai Tre")==0 && 
		   pr1.getNome().compareTo("Quarti Coppa Italia")==0 && pr1.getPalinsesto().getNome().compareTo("Pasqua")==0 && pr1.getPalinsesto().getCanale().compareTo("Rai Tre")==0 && 
		   pr2.getNome().compareTo("Un posto al sole")==0 && pr2.getPalinsesto().getNome().compareTo("Pasqua")==0 && pr2.getPalinsesto().getCanale().compareTo("Rai Tre")==0))) 
		{
			System.out.println("\nInformazioni lette dal file in maniera corretta.");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni lette dal file in maniera errata.");
			
		assertEquals("Implementazione del metodo leggi() e/o dei metodi correlati errata", true,corretto);
	}		
}
