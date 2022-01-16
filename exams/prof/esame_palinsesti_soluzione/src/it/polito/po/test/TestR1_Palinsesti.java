package it.polito.po.test;

import java.util.LinkedList;

import palinsesti.*;
import junit.framework.*;

public class TestR1_Palinsesti extends TestCase {

	public void testDefinisciPalinsesto(){
		
		System.out.println("\n*** R1. testDefinisciPalinsesto() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito nuovo palinsesto");
		Palinsesto p = gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20180322", "20190921");

		System.out.println("\nDettagli palinsesto:");
		System.out.println(" Nome: "+p.getNome());
		System.out.println(" Canale: "+p.getCanale());
		System.out.println(" Da: "+p.getDa());
		System.out.println(" A: "+p.getA());

		
		boolean corretto = false;
	
		if(p.getNome().compareTo("Primavera/Estate")==0 && p.getCanale().compareTo("Rai Uno")==0 && p.getDa().compareTo("20180322")==0 && p.getA().compareTo("20190921")==0)
		{
			System.out.println("\nInformazioni relative al palinsesto registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al palinsesto");
			
		assertEquals("Implementazione del metodo definisciPalinsesto() e/o dei metodi correlati errata", true,corretto);	
	}	

	
	public void testDefinisciPalinsestoGiaEsistente(){
		
		System.out.println("\n*** R1. testDefinisciPalinsestoGiaEsistente() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definito nuovo palinsesto");
		Palinsesto pPrima = gp.definisciPalinsesto("Primavera/Estate", "Rai Due", "20180322", "20190921");

		System.out.println("\n(Ri-) Definito palinsesto già esistente");
		Palinsesto pDopo = gp.definisciPalinsesto("Primavera/Estate", "Rai Due", "20180321", "20190920");

		System.out.println("\nDettagli palinsesto:");
		System.out.println(" Nome: "+pDopo.getNome());
		System.out.println(" Canale: "+pDopo.getCanale());
		System.out.println(" Da: "+pDopo.getDa());
		System.out.println(" A: "+pDopo.getA());
		
		boolean corretto = false;
	
		if(pPrima==pDopo)
		{
			System.out.println("\nPalinsesto già presente gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione del palinsesto già esistente");
			
		assertEquals("Implementazione del metodo definisciPalinsesto() e/o dei metodi correlati errata", true,corretto);	
	}	

	
	public void testElencoPalinsesti(){
		
		System.out.println("\n*** R1. testElencoPalinsesti() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definiti palinsesti");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20190321", "20200920");
		gp.definisciPalinsesto("Natale", "Rai Uno", "20181223", "20190106");
		gp.definisciPalinsesto("Capodanno", "Rai Tre", "20181231", "20190101");
	    gp.definisciPalinsesto("Primavera/Estate", "Rai Due", "20190321", "20200920");
		
		System.out.println("\nElenco palinsesti (ordine di inserimento):");
		LinkedList<Palinsesto> listaPalinsesti = new LinkedList<Palinsesto>(gp.elencoPalinsesti());
		for(Palinsesto ptemp : listaPalinsesti){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getCanale()+", "+ptemp.getDa()+", "+ptemp.getA());
		}

		boolean corretto = false;
	
		Palinsesto p0 = listaPalinsesti.get(0);
		Palinsesto p1 = listaPalinsesti.get(1);
		Palinsesto p2 = listaPalinsesti.get(2);
		Palinsesto p3 = listaPalinsesti.get(3);
		
		if(p0.getNome().compareTo("Primavera/Estate")==0 && p0.getCanale().compareTo("Rai Uno")==0 && p0.getDa().compareTo("20190321")==0 && 
		   p1.getNome().compareTo("Natale")==0 && p1.getCanale().compareTo("Rai Uno")==0 && p1.getDa().compareTo("20181223")==0 &&
		   p2.getNome().compareTo("Capodanno")==0 && p2.getCanale().compareTo("Rai Tre")==0 && p2.getDa().compareTo("20181231")==0 &&
		   p3.getNome().compareTo("Primavera/Estate")==0 && p3.getCanale().compareTo("Rai Due")==0 && p3.getDa().compareTo("20190321")==0)
		{
			System.out.println("\nElenco palinsesti gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione dell'elenco palinsesti");
			
		assertEquals("Implementazione del metodo elencoPalinsesti() e/o dei metodi correlati errata", true,corretto);	
	}	
	

	public void testElencoPalinsestiGiaEsistente(){
		
		System.out.println("\n*** R1. testElencoPalinsestiGiaEsistente() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definiti palinsesti");
		gp.definisciPalinsesto("Natale", "Rai Uno", "20181223", "20190106");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20190321", "20200920");
		gp.definisciPalinsesto("Capodanno", "Rai Tre", "20181231", "20190101");
	    gp.definisciPalinsesto("Primavera/Estate", "Rai Due", "20190321", "20200920");
		gp.definisciPalinsesto("Natale", "Rai Uno", "20181223", "20190106");
		
		System.out.println("\nElenco palinsesti (ordine di inserimento):");
		LinkedList<Palinsesto> listaPalinsesti = new LinkedList<Palinsesto>(gp.elencoPalinsesti());
		for(Palinsesto ptemp : listaPalinsesti){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getCanale()+", "+ptemp.getDa()+", "+ptemp.getA());
		}

		boolean corretto = false;
	
		Palinsesto p0 = listaPalinsesti.get(0);
		Palinsesto p1 = listaPalinsesti.get(1);
		Palinsesto p2 = listaPalinsesti.get(2);
		Palinsesto p3 = listaPalinsesti.get(3);
		
		if(listaPalinsesti.size()==4 &&
		   p0.getNome().compareTo("Natale")==0 && p0.getCanale().compareTo("Rai Uno")==0 && p0.getDa().compareTo("20181223")==0 && 
		   p1.getNome().compareTo("Primavera/Estate")==0 && p1.getCanale().compareTo("Rai Uno")==0 && p1.getDa().compareTo("20190321")==0 &&
		   p2.getNome().compareTo("Capodanno")==0 && p2.getCanale().compareTo("Rai Tre")==0 && p2.getDa().compareTo("20181231")==0 &&
		   p3.getNome().compareTo("Primavera/Estate")==0 && p3.getCanale().compareTo("Rai Due")==0 && p3.getDa().compareTo("20190321")==0)
		{
			System.out.println("\nElenco palinsesti (con palinsesto già esistente) gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione dell'elenco palinsesti (con palinsesto già esistente)");
			
		assertEquals("Implementazione del metodo elencoPalinsesti() e/o dei metodi correlati errata", true,corretto);	
	}	

	
	public void testCercaPalinsesto(){
		
		System.out.println("\n*** R1. testCercaPalinsesto() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definiti palinsesti");
		gp.definisciPalinsesto("Natale", "Rai Uno", "20181223", "20190106");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20190321", "20200920");
		gp.definisciPalinsesto("Capodanno", "Rai Tre", "20181231", "20190101");
	    gp.definisciPalinsesto("Primavera/Estate", "Rai Due", "20190321", "20200920");
		gp.definisciPalinsesto("Natale", "Rai Uno", "20181223", "20190106");
		
		System.out.println("\nCerca palinsesto 'Capodanno' 'Rai Tre'");
		Palinsesto p = gp.cercaPalinsesto("Capodanno","Rai Tre");
		
		System.out.println("\nPalinsesto trovato:");
		System.out.println(" Nome: "+p.getNome());
		System.out.println(" Canale: "+p.getCanale());
		System.out.println(" Da: "+p.getDa());
		System.out.println(" A: "+p.getA());
		
		boolean corretto = false;
		
		if(p.getNome().compareTo("Capodanno")==0 && p.getCanale().compareTo("Rai Tre")==0)
		{
			System.out.println("\nRicerca palinsesto gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione della ricerca palinsesto");
			
		assertEquals("Implementazione del metodo cercaPalinsesto() e/o dei metodi correlati errata", true,corretto);	
	}	
	
	
	public void testCercaPalinsesti(){
		
		System.out.println("\n*** R1. testCercaPalinsesti() ***\n");
	
		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("Definiti palinsesti");
		gp.definisciPalinsesto("Natale", "Rai Uno", "20181223", "20190106");
		gp.definisciPalinsesto("Natale", "Rai Uno", "20181223", "20190106");
		gp.definisciPalinsesto("Capodanno", "Rai Tre", "20181231", "20190101");
		gp.definisciPalinsesto("Primavera/Estate", "Rai Uno", "20190321", "20200920");
	    gp.definisciPalinsesto("Primavera/Estate", "Rai Due", "20190321", "20200920");
		
		System.out.println("\nCerca palinsesti che contengono 'no' (ordine di inserimento):");
		LinkedList<Palinsesto> listaPalinsesti = new LinkedList<Palinsesto>(gp.cercaPalinsesti("no"));
		for(Palinsesto ptemp : listaPalinsesti){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getCanale()+", "+ptemp.getDa()+", "+ptemp.getA());
		}

		boolean corretto = false;
	
		Palinsesto p0 = listaPalinsesti.get(0);
		Palinsesto p1 = listaPalinsesti.get(1);
		Palinsesto p2 = listaPalinsesti.get(2);
		
		if(listaPalinsesti.size()==3 &&
		   p0.getNome().compareTo("Natale")==0 && p0.getCanale().compareTo("Rai Uno")==0 && p0.getDa().compareTo("20181223")==0 && 
		   p1.getNome().compareTo("Capodanno")==0 && p1.getCanale().compareTo("Rai Tre")==0 && p1.getDa().compareTo("20181231")==0 &&
	       p2.getNome().compareTo("Primavera/Estate")==0 && p2.getCanale().compareTo("Rai Uno")==0 && p2.getDa().compareTo("20190321")==0)
		{
			System.out.println("\nRicerca palinsesti gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella gestione della ricerca palinsesti");
			
		assertEquals("Implementazione del metodo elencoPalinsesti() e/o dei metodi correlati errata", true,corretto);	
	}	
}
