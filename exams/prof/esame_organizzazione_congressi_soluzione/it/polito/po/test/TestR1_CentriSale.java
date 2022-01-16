package it.polito.po.test;

import congressi.*;
import java.util.*;

import junit.framework.TestCase;

public class TestR1_CentriSale extends TestCase {

	public void testDefinisciCentro(){

		System.out.println("\n*** testDefinisciCentro() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		boolean corretto = false;
		
		if(ce.getNome().compareTo("Congress Center #1")==0 && ce.getIndirizzo().compareTo("Address of the Congress Center #1")==0)
		{
			System.out.println("\nInformazioni relative al centro (nome, indirizzo) registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al centro (nome, indirizzo)");
			
		assertEquals("Implementazione del metodo definisciCentro() e/o dei metodi correlati errata", true,corretto);	  
	}

	
	public void testDefinisciCentroIdAssegnato(){

		System.out.println("\n*** testDefinisciCentroIdAssegnato() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of Congress Center #1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		boolean corretto = false;
		
		if(ce.getId().compareTo("CO1")==0)
		{
			System.out.println("\nInformazioni relative al centro (id assegnato) registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al centro (id assegnato)");
			
		assertEquals("Implementazione del metodo definisciCentro() e/o dei metodi correlati errata", true,corretto);	  

		System.out.println("\nDefinito secondo centro");

		ce = o.definisciCentro("second", "Address of the second center");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		corretto = false;
		
		if(ce.getId().compareTo("SE2")==0)
		{
			System.out.println("\nInformazioni relative al centro (id assegnato) registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al centro (id assegnato)");
			
		assertEquals("Implementazione del metodo definisciCentro() e/o dei metodi correlati errata", true,corretto);	  
	

		System.out.println("\nDefinito terzo centro");

		ce = o.definisciCentro("th", "Address of the TH center");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		corretto = false;
		
		if(ce.getId().compareTo("TH3")==0)
		{
			System.out.println("\nInformazioni relative al centro (id assegnato) registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al centro (id assegnato)");
			
		assertEquals("Implementazione del metodo testDefinisciCentro() e/o dei metodi correlati errata", true,corretto);	
	
	}
	
	
	public void testCercaCentro(){

		System.out.println("\n*** testCercaCentro() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definiti centri");

		o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		Centro ce1 = o.definisciCentro("Congress Center #3", "Address of the Congress Center #3");
		o.definisciCentro("Congress Center #2", "Address of the Congress Center #2");
		o.definisciCentro("Congress Center #0", "Address of the Congress Center #0");

		System.out.println("\nCerca centro \""+ce1.getId()+"\": ");

		Centro ce2 = o.cercaCentro(ce1.getId());
		System.out.println(" Id: "+ ce2.getId());
		System.out.println(" Nome: "+ ce2.getNome());
		System.out.println(" Data indirizzo: "+ ce2.getIndirizzo());
		
		boolean corretto = false;
		
		if(ce2.getId().compareTo(ce1.getId())==0 && ce2.getNome().compareTo("Congress Center #3")==0 && ce2.getIndirizzo().compareTo("Address of the Congress Center #3")==0)
		{
			System.out.println("\nRicerca del centro implementata in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca del centro implementata in maniera errata");
			
		assertEquals("Implementazione del metodo cercaCentro() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testElencoCentri(){

		System.out.println("\n*** testElencoCentri() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definiti centri");

		o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		o.definisciCentro("Congress Center #3", "Address of the Congress Center #3");
		o.definisciCentro("Congress Center #2", "Address of the Congress Center #2");
		o.definisciCentro("Congress Center #0", "Address of the Congress Center #0");

		System.out.println("\nElenco centri (ordine di definizione)");

		LinkedList<Centro> listaCentri = new LinkedList<Centro>(o.elencoCentri());
		for(Centro c : listaCentri)
			System.out.println(" "+c.getId()+" "+c.getNome()+" "+c.getIndirizzo());

		Centro ce1 = listaCentri.get(0);
		Centro ce2 = listaCentri.get(1);
		Centro ce3 = listaCentri.get(2);
		Centro ce4 = listaCentri.get(3);

		boolean corretto = false;
		
		if(ce1.getNome().compareTo("Congress Center #1")==0 && ce1.getIndirizzo().compareTo("Address of the Congress Center #1")==0 && 
		   ce2.getNome().compareTo("Congress Center #3")==0 && ce2.getIndirizzo().compareTo("Address of the Congress Center #3")==0	&&			
		   ce3.getNome().compareTo("Congress Center #2")==0 && ce3.getIndirizzo().compareTo("Address of the Congress Center #2")==0	&&			
		   ce4.getNome().compareTo("Congress Center #0")==0 && ce4.getIndirizzo().compareTo("Address of the Congress Center #0")==0)
		{
			System.out.println("\nElenco centri implementato in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco centri implementato in maniera errata");
			
		assertEquals("Implementazione del metodo elencoCentri() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testElencoCentriSottostringa(){

		System.out.println("\n*** testElencoCentriSottostringa() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definiti centri");

		o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		o.definisciCentro("Congress        #3", "Address of the Congress Center #3");
		o.definisciCentro("Congress Center #2", "Address of the Congress Center #2");
		o.definisciCentro("Congress        #0", "Address of the Congress        #0");
		o.definisciCentro("Congress Center  4", "Address of the Congress Center  4");
		o.definisciCentro("Congress Center #5", "Address of the Congress        #5");

		System.out.println("\nElenco centri contenenti \"enter #\" nel nome o nell'indirizzo (ordine di definizione)");

		LinkedList<Centro> listaCentri = new LinkedList<Centro>(o.elencoCentri("enter #"));
		for(Centro c : listaCentri)
			System.out.println(" "+c.getId()+" "+c.getNome()+" "+c.getIndirizzo());

		Centro ce1 = listaCentri.get(0);
		Centro ce2 = listaCentri.get(1);
		Centro ce3 = listaCentri.get(2);
		Centro ce4 = listaCentri.get(3);

		boolean corretto = false;
		
		if(ce1.getNome().compareTo("Congress Center #1")==0 && ce1.getIndirizzo().compareTo("Address of the Congress Center #1")==0 && 
		   ce2.getNome().compareTo("Congress        #3")==0 && ce2.getIndirizzo().compareTo("Address of the Congress Center #3")==0	&&			
		   ce3.getNome().compareTo("Congress Center #2")==0 && ce3.getIndirizzo().compareTo("Address of the Congress Center #2")==0	&&
		   ce4.getNome().compareTo("Congress Center #5")==0 && ce4.getIndirizzo().compareTo("Address of the Congress        #5")==0)
		{
			System.out.println("\nElenco centri implementato in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco centri implementato in maniera errata");
			
		assertEquals("Implementazione del metodo elencoCentri() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testDefinisciSalaCentro(){

		System.out.println("\n*** testDefinisciSalaCentro() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		
		System.out.println("\nDefinita sala per il centro \""+ce.getId()+"\" ");
		Sala sa = o.definisciSalaCentro(ce.getId(), "Room", 100);
		System.out.println(" Nome: "+sa.getNome());
		System.out.println(" Capienza: "+sa.getCapienza());
		
		boolean corretto = false;
		
		if(sa.getNome().compareTo("Room")==0 && sa.getCapienza()==100)
		{
			System.out.println("\nInformazioni relative alla sala registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative alla sala");
			
		assertEquals("Implementazione del metodo definisciSalaCentro() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testElencoSaleCentroPerNome(){

		System.out.println("\n*** testElencoSaleCentroPerNome() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		System.out.println("\nDefinite sale per il centro \""+ce.getId()+"\" ");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Big room", 500);
		o.definisciSalaCentro(ce.getId(), "Small room", 10);

		System.out.println("\nElenco sale centro \""+ce.getId()+"\" (per nome)");
		LinkedList<Sala> listaSale = new LinkedList<Sala>(o.elencoSaleCentroPerNome(ce.getId()));
		for(Sala s : listaSale)
			System.out.println(" "+s.getNome()+" "+s.getCapienza());

		Sala sa1 = listaSale.get(0);
		Sala sa2 = listaSale.get(1);
		Sala sa3 = listaSale.get(2);
		
		boolean corretto = false;
		
		if(sa1.getNome().compareTo("Big room")==0 && sa2.getNome().compareTo("Room")==0 && sa3.getNome().compareTo("Small room")==0)
		{
			System.out.println("\nElenco sale gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco sale gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoSaleCentroPerNome() e/o dei metodi correlati errata", true,corretto);	  
	
	}
	
	
	public void testElencoSaleCentroPerCapienza(){

		System.out.println("\n*** testElencoSaleCentroPerCapienza() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		System.out.println("\nDefinite sale per il centro \""+ce.getId()+"\" ");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Big room", 500);
		o.definisciSalaCentro(ce.getId(), "Small room", 10);

		System.out.println("\nElenco sale centro \""+ce.getId()+"\" (per capienza)");
		LinkedList<Sala> listaSale = new LinkedList<Sala>(o.elencoSaleCentroPerCapienza(ce.getId()));
		for(Sala s : listaSale)
			System.out.println(" "+s.getNome()+" "+s.getCapienza());

		Sala sa1 = listaSale.get(0);
		Sala sa2 = listaSale.get(1);
		Sala sa3 = listaSale.get(2);
		
		boolean corretto = false;
		
		if(sa1.getNome().compareTo("Small room")==0 && sa2.getNome().compareTo("Room")==0 && sa3.getNome().compareTo("Big room")==0)
		{
			System.out.println("\nElenco sale gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco sale gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoSaleCentroPerCapienza() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testDefinisciSalaCentroNomeDuplicato(){

		System.out.println("\n*** testDefinisciSalaCentroNomeDuplicato() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());

		System.out.println("\nDefinite sale per il centro \""+ce.getId()+"\" ");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Big room", 500);
		o.definisciSalaCentro(ce.getId(), "Small room", 10);
		o.definisciSalaCentro(ce.getId(), "Room", 200);

		System.out.println("\nNumero sale per il centro \""+ce.getId()+"\" ");
		LinkedList<Sala> listaSale = new LinkedList<Sala>(o.elencoSaleCentroPerCapienza(ce.getId()));
		int numSale = listaSale.size();
		
		System.out.println(" "+numSale);

		boolean corretto = false;
		
		if(numSale==3)
		{
			System.out.println("\nDefinizione sala con nome duplicato gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nDefinizione sala con nome duplicato gestita in maniera corretta");
			
		assertEquals("Implementazione del metodo definisciSalaCentro() e/o dei metodi correlati errata", true,corretto);	  
	}
}






