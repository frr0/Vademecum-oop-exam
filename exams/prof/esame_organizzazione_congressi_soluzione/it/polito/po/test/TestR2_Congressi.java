package it.polito.po.test;

import congressi.*;
import java.util.*;

import junit.framework.TestCase;

public class TestR2_Congressi extends TestCase {

	public void testDefinisciCongresso(){

		System.out.println("\n*** testDefinisciCongresso() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		System.out.println("\nDefinito congresso");
		
		Congresso co = o.definisciCongresso("Congress A", "20190705", "20190710", ce.getId());
		System.out.println(" Name: "+ co.getNome());
		System.out.println(" Data inizio: "+ co.getDataInizio());
		System.out.println(" Data fine: "+ co.getDataFine());
		System.out.println(" Id centro: "+ co.getIdCentro());
		
		boolean corretto = false;
		
		if(co.getNome().compareTo("Congress A")==0 && co.getDataInizio().compareTo("20190705")==0 && co.getDataFine().compareTo("20190710")==0 && co.getIdCentro().compareTo(ce.getId())==0)
		{
			System.out.println("\nInformazioni relative al congresso registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al congresso");
			
		assertEquals("Implementazione del metodo definisciCongresso() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testDefinisciCongressoGiaPresente(){

		System.out.println("\n*** testDefinisciCongressoGiaPresente() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");

		System.out.println("\nDefinito congresso");
		
		Congresso co1 = o.definisciCongresso("Congress A", "20190705", "20190710", ce.getId());
		System.out.println(" Name: "+ co1.getNome());
		System.out.println(" Data inizio: "+ co1.getDataInizio());
		System.out.println(" Data fine: "+ co1.getDataFine());
		System.out.println(" Id centro: "+ co1.getIdCentro());

		System.out.println("\nDefinito congresso con medesimo nome");

		Congresso co2 = o.definisciCongresso("Congress A", "20200705", "20200710", ce.getId());
		System.out.println(" Name: "+ co2.getNome());
		System.out.println(" Data inizio: "+ co2.getDataInizio());
		System.out.println(" Data fine: "+ co2.getDataFine());
		System.out.println(" Id centro: "+ co2.getIdCentro());
		
		boolean corretto = false;
		
		if(co2.getNome().compareTo("Congress A")==0 && co2.getDataInizio().compareTo("20200705")==0 && co2.getDataFine().compareTo("20200710")==0 && co2.getIdCentro().compareTo(ce.getId())==0)
		{
			System.out.println("\nDefinizione congresso con nome gia' presente gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nDefinizione congresso con nome gia' presente gestita in maniera errata");
			
		assertEquals("Implementazione del metodo definisciCongresso() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testAssegnaEdElencoSaleCongresso(){

		System.out.println("\n*** testAssegnaEdElencoSaleCongresso() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");

		System.out.println("\nDefinite tre sale per il centro: \"Room\", \"Small room\" ed \"Invisible room\"");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Small room", 10);
		o.definisciSalaCentro(ce.getId(), "Invisible room", 2);
		
		System.out.println("\nDefinito congresso");
		
		Congresso co = o.definisciCongresso("Congress A", "20190705", "20190710", ce.getId());
		System.out.println(" Name: "+ co.getNome());
		System.out.println(" Data inizio: "+ co.getDataInizio());
		System.out.println(" Data fine: "+ co.getDataFine());
		System.out.println(" Id centro: "+ co.getIdCentro());
		
		System.out.println("\nAssegna sale \"Room\", \"Small room\" ed \"Invisible room\" a congresso \"Congress A\" ");

		o.assegnaSaleCongresso("Congress A", "Room");
		o.assegnaSaleCongresso("Congress A", "Small room");
		o.assegnaSaleCongresso("Congress A", "Invisible room");
		
		System.out.println("\nElenco sale congresso \"Congress A\" (ordine alfabetico)");
		LinkedList<Sala> listaSale = new LinkedList<Sala>(o.elencoSaleCongresso("Congress A"));
		for(Sala s : listaSale)
			System.out.println(" "+s.getNome()+" "+s.getCapienza());
		
		Sala sa1 = listaSale.get(0);
		Sala sa2 = listaSale.get(1);
		Sala sa3 = listaSale.get(2);
		
		boolean corretto = false;
		
		if(sa1.getNome().compareTo("Invisible room")==0 &&  sa2.getNome().compareTo("Room")==0 && sa3.getNome().compareTo("Small room")==0)
		{
			System.out.println("\nAssegnazione ed elenco sale gestiti in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nAssegnazione ed elenco sale gestiti in maniera errata");
			
		assertEquals("Implementazione del metodo assegnaSaleCongresso(), elencoSaleCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}
	
	
	public void testAssegnaEdElencoSaleCongressoSaleNonPresenti(){

		System.out.println("\n*** testAssegnaEdElencoSaleCongressoSaleNonPresenti() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");

		System.out.println("\nDefinite due sale per il centro: \"Room\" ed \"Invisible room\"");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Invisible room", 2);
		
		System.out.println("\nDefinito congresso");
		
		Congresso co = o.definisciCongresso("Congress A", "20190705", "20190710", ce.getId());
		System.out.println(" Name: "+ co.getNome());
		System.out.println(" Data inizio: "+ co.getDataInizio());
		System.out.println(" Data fine: "+ co.getDataFine());
		System.out.println(" Id centro: "+ co.getIdCentro());
		
		System.out.println("\nAssegna sale \"Room\", \"Small room\" ed \"Invisible room\" a congresso \"Congress A\" ");

		o.assegnaSaleCongresso("Congress A", "Room");
		o.assegnaSaleCongresso("Congress A", "Small room");
		o.assegnaSaleCongresso("Congress A", "Invisible room");
		
		System.out.println("\nElenco sale congresso \"Congress A\" (ordine alfabetico)");
		LinkedList<Sala> listaSale = new LinkedList<Sala>(o.elencoSaleCongresso("Congress A"));
		for(Sala s : listaSale)
			System.out.println(" "+s.getNome()+" "+s.getCapienza());
		
		int numSale = listaSale.size();
		
		boolean corretto = false;
		
		if(numSale==2)
		{
			System.out.println("\nAssegnazione ed elenco sale gestiti in maniera corretta (numero sale corretto)");
			corretto = true;
		}
		else
			System.out.println("\nAssegnazione ed elenco sale gestiti in maniera errata (numero sale errato)");
			
		assertEquals("Implementazione del metodo assegnaSaleCongresso(), elencoSaleCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
		Sala sa1 = listaSale.get(0);
		Sala sa2 = listaSale.get(1);
		
		corretto = false;
		
		if(sa1.getNome().compareTo("Invisible room")==0 &&  sa2.getNome().compareTo("Room")==0)
		{
			System.out.println("\nAssegnazione ed elenco sale gestiti in maniera corretta (elenco corretto)");
			corretto = true;
		}
		else
			System.out.println("\nAssegnazione ed elenco sale gestiti in maniera errata (elenco errato)");
			
		assertEquals("Implementazione del metodo assegnaSaleCongresso(), elencoSaleCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}

}






