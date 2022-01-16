package it.polito.po.test;

import java.util.LinkedList;

import palinsesti.*;
import junit.framework.*;

public class TestR2_Programmi extends TestCase {

	public void testDefinisciProgramma() throws PalinsestoInesistenteException{
		
		System.out.println("\n*** R2. testDefinisciProgramma() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito nuovo palinsesto");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");

		System.out.println("\nDefinito nuovo programma palinsesto 'Primavera/Estate' per 'Rai Uno'");
		String id = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Finale Europa League", "Partita di calcio");
		System.out.println("\nId assegnato: ");
		System.out.println(" "+id);

		boolean corretto = false;
	
		if(id.compareTo("PR1")==0)
		{
			System.out.println("\nIdentificativo programma assegnato in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nell'assegnazione dell'identificativo programma");
			
		assertEquals("Implementazione del metodo definisciProgramma() e/o dei metodi correlati errata", true,corretto);	
	}

	
	public void testDefinisciProgrammi() throws PalinsestoInesistenteException{
		
		System.out.println("\n*** R2. testDefinisciProgrammi() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito nuovo palinsesto");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");

		System.out.println("\nDefiniti tre programmi palinsesto 'Primavera/Estate' per 'Rai Uno'");
		String ida = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Semifinale Europa League", "Partita di calcio");
		String idb = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Quarti di finale Europa League", "Partita di calcio");
		String idc = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Finale Europa League", "Partita di calcio");

		System.out.println("\nId assegnati: ");
		System.out.println(" "+ida+", "+idb+" "+idc);

		System.out.println("Definito altro palinsesto");
		gp.definisciPalinsesto("Capodanno", "Gulp", "20181231", "20190101");

		System.out.println("\nDefinito programma palinsesto 'Capodanno' per 'Gulp'");
		String idd = gp.definisciProgramma("Capodanno", "Gulp", "Capodanno con Paperino", "Generico");

		System.out.println("\nId assegnato: ");
		System.out.println(" "+idd);
		
		boolean corretto = false;
	
		if(ida.compareTo("PR1")==0 && idb.compareTo("PR2")==0 && idc.compareTo("PR3")==0 && idd.compareTo("CG1")==0)
		{
			System.out.println("\nIdentificativi programma assegnati in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nell'assegnazione degli identificativi programma");
			
		assertEquals("Implementazione del metodo definisciProgramma() e/o dei metodi correlati errata", true,corretto);	
	}

	
	public void testDefinisciProgrammaPalinsestoInesistente(){
		
		System.out.println("*** R2. testDefinisciProgrammaPalinsestoInesistente() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		boolean eccezione = false;
		
		System.out.println("Definito nuovo programma palinsesto per palinsesto inesistente");
		try {
			gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Finale Europa League", "Partita di calcio");
		}
		catch(PalinsestoInesistenteException pie) {
			eccezione = true;
		}

		boolean corretto = false;
	
		if(eccezione == true)
		{
			System.out.println("\nPalinsesto inesistente gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione palinsesto inesistente");
			
		assertEquals("Implementazione del metodo definisciProgramma() e/o dei metodi correlati errata", true,corretto);	
	}
	
	
	public void testCercaProgramma() throws PalinsestoInesistenteException{
		
		System.out.println("\n*** R2. testCercaProgramma() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definiti palinsesti");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");
		gp.definisciPalinsesto("Capodanno", "Gulp", "20181231", "20190101");

		System.out.println("\nDefiniti programmi");
		gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Semifinale Europa League", "Partita di calcio");
		String id = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Quarti di finale Europa League", "Partita di calcio");
		gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Finale Europa League", "Partita di calcio");
		gp.definisciProgramma("Capodanno", "Gulp", "Capodanno con Paperino", "Generico");

		System.out.println("\nCerca programma '"+id+"'");
		Programma pr = gp.cercaProgramma(id);
		
		System.out.println("\nProgramma trovato:");
		System.out.println(" Id: "+pr.getId());
		System.out.println(" Nome programma: "+pr.getNome());
		if(pr instanceof PartitaCalcio)
			System.out.println(" Tipo: Partita di calcio");
		else if(pr instanceof SerieTv)
			System.out.println(" Tipo: Serie TV");
		else
			System.out.println(" Tipo: N/D");
		System.out.println(" Palinsesto: "+pr.getPalinsesto().getNome());
		System.out.println(" Canale: "+pr.getPalinsesto().getCanale());
		
		boolean corretto = false;
	
		if(pr.getNome().compareTo("Quarti di finale Europa League")==0 && pr.getPalinsesto().getNome().compareTo("Primavera/Estate")==0 && pr.getPalinsesto().getCanale().compareTo("Rai Uno")==0)
		{
			System.out.println("\nRicerca programma gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione della ricerca programma");
			
		assertEquals("Implementazione del metodo cercaProgramma() e/o dei metodi correlati errata", true,corretto);	
	}
	
	
	public void testCercaProgrammiTipi() throws PalinsestoInesistenteException{
		
		System.out.println("\n*** R2. testCercaProgrammiTipi() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definiti palinsesti");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");
		gp.definisciPalinsesto("Capodanno", "Gulp", "20181231", "20190101");

		System.out.println("\nDefiniti programmi");
		String ida = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Semifinale Europa League", "Partita di calcio");
		String idb = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Dr. House", "Serie TV");
		String idc = gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Telegiornale", "Generico");

		System.out.println("\nCerca programma '"+ida+"'");
		Programma pra = gp.cercaProgramma(ida);
		
		System.out.println("\nProgramma trovato:");
		System.out.println(" Id: "+pra.getId());
		System.out.println(" Nome programma: "+pra.getNome());
		if(pra instanceof PartitaCalcio)
			System.out.println(" Tipo: Partita di calcio");
		else if(pra instanceof SerieTv)
			System.out.println(" Tipo: Serie TV");
		else
			System.out.println(" Tipo: N/D (Generico)");

		System.out.println("\nCerca programma '"+idb+"'");
		Programma prb = gp.cercaProgramma(idb);
		
		System.out.println("\nProgramma trovato:");
		System.out.println(" Id: "+prb.getId());
		System.out.println(" Nome programma: "+prb.getNome());
		if(prb instanceof PartitaCalcio)
			System.out.println(" Tipo: Partita di calcio");
		else if(prb instanceof SerieTv)
			System.out.println(" Tipo: Serie TV");
		else
			System.out.println(" Tipo: N/D (Generico)");

		System.out.println("\nCerca programma '"+idc+"'");
		Programma prc = gp.cercaProgramma(idc);
		
		System.out.println("\nProgramma trovato:");
		System.out.println(" Id: "+prc.getId());
		System.out.println(" Nome programma: "+prc.getNome());
		if(prc instanceof PartitaCalcio)
			System.out.println(" Tipo: Partita di calcio");
		else if(prc instanceof SerieTv)
			System.out.println(" Tipo: Serie TV");
		else
			System.out.println(" Tipo: N/D (Generico)");
		
		boolean corretto = false;
	
		if(pra instanceof PartitaCalcio && prb instanceof SerieTv && prc instanceof Programma)
		{
			System.out.println("\nTipi programma gestiti in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione dei tipi programma");
			
		assertEquals("Implementazione del metodo definisciProgramma() e/o dei metodi correlati errata", true,corretto);	
	}
	
	
	public void testElencoProgrammi() throws PalinsestoInesistenteException{
		
		System.out.println("\n*** R2. testElencoProgrammi() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definiti palinsesti");
		gp.definisciPalinsesto("Primavera/Estate", "Gulp", "20180322", "20190921");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");
		gp.definisciPalinsesto("Capodanno", "Gulp", "20181231", "20190101");

		System.out.println("\nDefiniti programmi");
		gp.definisciProgramma("Primavera/Estate", "Gulp", "Telegiornale", "Generico");
		gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Semifinale Europa League", "Partita di calcio");
		gp.definisciProgramma("Primavera/Estate", "Rai Uno", "Telegiornale", "Generico");
		gp.definisciProgramma("Capodanno", "Gulp", "Capodanno con Paperino", "Generico");
		gp.definisciProgramma("Capodanno", "Gulp", "Telegiornale", "Generico");

		System.out.println("\nElenco programmi (ordinati per nome programma, nome palinsesto e canale):");
		LinkedList<Programma> listaProgrammi = new LinkedList<Programma>(gp.elencoProgrammi());
		for(Programma ptemp : listaProgrammi){
			System.out.println(" ("+ptemp.getId()+") "+ptemp.getNome()+", "+ptemp.getPalinsesto().getNome()+", "+ptemp.getPalinsesto().getCanale());
		}

		Programma pr0 = listaProgrammi.get(0);
		Programma pr1 = listaProgrammi.get(1);
		Programma pr2 = listaProgrammi.get(2);
		Programma pr3 = listaProgrammi.get(3);
		Programma pr4 = listaProgrammi.get(4);
		
		boolean corretto = false;
	
		if(pr0.getNome().compareTo("Capodanno con Paperino")==0 && pr0.getPalinsesto().getNome().compareTo("Capodanno")==0 && pr0.getPalinsesto().getCanale().compareTo("Gulp")==0 && 
 		   pr1.getNome().compareTo("Semifinale Europa League")==0 && pr1.getPalinsesto().getNome().compareTo("Primavera/Estate")==0 && pr1.getPalinsesto().getCanale().compareTo("Rai Uno")==0 &&
		   pr2.getNome().compareTo("Telegiornale")==0 && pr2.getPalinsesto().getNome().compareTo("Capodanno")==0 && pr2.getPalinsesto().getCanale().compareTo("Gulp")==0 &&
		   pr3.getNome().compareTo("Telegiornale")==0 && pr3.getPalinsesto().getNome().compareTo("Primavera/Estate")==0 && pr3.getPalinsesto().getCanale().compareTo("Gulp")==0 &&
		   pr4.getNome().compareTo("Telegiornale")==0 && pr4.getPalinsesto().getNome().compareTo("Primavera/Estate")==0 && pr4.getPalinsesto().getCanale().compareTo("Rai Uno")==0)
 		{
			System.out.println("\nElenco programmi gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione dell'elenco programmi");
			
		assertEquals("Implementazione del metodo elencoProgrammi() e/o dei metodi correlati errata", true,corretto);	
	}
}
