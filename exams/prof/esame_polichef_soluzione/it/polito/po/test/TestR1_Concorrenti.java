package it.polito.po.test;

import polichef.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR1_Concorrenti extends TestCase {

	public void testIscriviConcorrente(){

		System.out.println("\n*** testIscriviConcorrente() ***\n");
		
		Trasmissione t = new Trasmissione();
		
		Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
	
		System.out.println("Iscritto nuovo concorrente");
	
		System.out.println(" "+c1.getNome()+" "+c1.getCognome()+" (professione "+c1.getProfessione()+")");
		
		boolean corretto = false;
		
		if(c1.getNome().compareTo("Alberto")==0 && c1.getCognome().compareTo("Neri")==0 && c1.getProfessione().compareTo("Attore")==0)
		{
			System.out.println("\nInformazioni relative al concorrente registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al concorrente");
			
		assertEquals("Implementazione del metodo iscriviConcorrente() e/o dei metodi correlati errata", true,corretto);	  
	}

	
	public void testIdentificativoConcorrente(){

		System.out.println("\n*** testIdentificativoConcorrente() ***\n");
		
		Trasmissione t = new Trasmissione();
		
		Concorrente c1 = t.iscriviConcorrente("alberto", "Neri", "Attore");
	
		System.out.println("Iscritto nuovo concorrente");
	
		System.out.println(" "+c1.getNome()+" "+c1.getCognome()+" (professione "+c1.getProfessione()+")");
		
		System.out.println("\nIdentificativo assegnato");
		String idc1 = c1.getId();
		System.out.println(" "+idc1);
		
		boolean corretto = false;
		
		if(c1.getId().compareTo("alberto N.")==0)
		{
			System.out.println("\nIdentificativo concorrente assegnato in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nell'assegnazione dell'identificativo concorrente");
			
		assertEquals("Implementazione del metodo iscriviConcorrente() e/o dei metodi correlati errata", true,corretto);	  
		
		System.out.println("\nIscritto altro concorrente");
		
		Concorrente c2 = t.iscriviConcorrente("Giuseppe", "grigi", "Commercialista");
		String idc2 = c2.getId();
	
		System.out.println(" "+c2.getNome()+" "+c2.getCognome()+" (professione "+c2.getProfessione()+")");
	
		System.out.println("\nIdentificativo assegnato:");
		System.out.println(" "+idc2);
	
		corretto = false;
		
		if(c2.getId().compareTo("Giuseppe g.")==0)
		{
			System.out.println("\nIdentificativo concorrente assegnato in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nell'assegnazione dell'identificativo concorrente");
			
		assertEquals("Implementazione del metodo iscriviConcorrente() e/o dei metodi correlati errata", true,corretto);	 
	}

	
	public void testIscriviConcorrenteStessiNomeEdInizialeCognome(){

		System.out.println("\n*** testIscriviConcorrenteStessiNomeEdInizialeCognome() ***\n");
		
		Trasmissione t = new Trasmissione();
		
		Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
	
		System.out.println("Iscritto nuovo concorrente");
	
		System.out.println(" "+c1.getNome()+" "+c1.getCognome()+" (professione "+c1.getProfessione()+")");
		
		Concorrente c2 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
	
		System.out.println("\nTentativo di iscrizione concorrente stesso nome e stessa iniziale cognome");
	
		boolean corretto = false;
	
		if(c2==null) {
			System.out.println(" Iscrizione concorrente stesso nome e stessa iniziale cognome gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println(" Iscrizione concorrente stesso nome e stessa iniziale cognome gestita in maniera errata");
				
		assertEquals("Implementazione del metodo iscriviConcorrente() e/o dei metodi correlati errata", true,corretto);	  
	}

	
	public void testCercaConcorrente(){

		System.out.println("\n*** testCercaConcorrente() ***\n");
		
		Trasmissione t = new Trasmissione();
		
		System.out.println("Iscritti concorrenti\n");
		t.iscriviConcorrente("Alberto", "Neri", "Attore");
		t.iscriviConcorrente("Giuseppe", "Grigi", "Avvocato");
		t.iscriviConcorrente("Maria", "Arancioni", "Commercialista");
		t.iscriviConcorrente("Anna", "Blu", "Avvocato");
		t.iscriviConcorrente("Alessio", "Verdi", "Commercialista");
		t.iscriviConcorrente("Cristina", "Gialli", "Commercialista");
	
		System.out.println("Ricerca concorrente 'Maria A.' \n");
		
		Concorrente c = t.cercaConcorrente("Maria A.");
		System.out.println("Concorrente trovato\n "+c.getNome()+" "+c.getCognome()+" (professione "+c.getProfessione()+")");
	
		boolean corretto = false;
		
		if(c.getNome().compareTo("Maria")==0 && c.getCognome().compareTo("Arancioni")==0 && c.getProfessione().compareTo("Commercialista")==0)
		{
			System.out.println("\nInformazioni relative al concorrente cecato corrette");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni relative al concorrente cercato errate");
			
		assertEquals("Implementazione del metodo cercaConcorrente() e/o dei metodi correlati errata", true,corretto);	  
	}
  
  
	public void testElencoConcorrenti(){

		System.out.println("\n*** testElencoConcorrenti() ***\n");
		
		Trasmissione t = new Trasmissione();
		
		System.out.println("Iscritti concorrenti\n");
		t.iscriviConcorrente("Alberto", "Neri", "Attore");
		t.iscriviConcorrente("Giuseppe", "Grigi", "Avvocato");
		t.iscriviConcorrente("Maria", "Arancioni", "Commercialista");
		t.iscriviConcorrente("Anna", "Blu", "Avvocato");
		t.iscriviConcorrente("Alessio", "Verdi", "Commercialista");
		t.iscriviConcorrente("Cristina", "Gialli", "Commercialista");
	
		System.out.println("Elenco concorrenti (ordine alfabetico nome e cognome)");
		LinkedList<Concorrente> listaConcorrenti = new LinkedList<Concorrente>(t.elencoConcorrenti());
		for(Concorrente ctemp : listaConcorrenti)
			System.out.println(" "+ctemp.getNome()+" "+ctemp.getCognome()+" (professione "+ctemp.getProfessione()+")");
		
		Concorrente c1 = listaConcorrenti.get(0);
		Concorrente c2 = listaConcorrenti.get(1);
		Concorrente c3 = listaConcorrenti.get(2);
		Concorrente c4 = listaConcorrenti.get(3);
		Concorrente c5 = listaConcorrenti.get(4);
		Concorrente c6 = listaConcorrenti.get(5);
		
		boolean corretto = false;
		
		if(c1.getNome().compareTo("Alberto")==0 && c1.getCognome().compareTo("Neri")==0 && 
		   c2.getNome().compareTo("Alessio")==0 && c2.getCognome().compareTo("Verdi")==0 &&		
		   c3.getNome().compareTo("Anna")==0 && c3.getCognome().compareTo("Blu")==0 &&		
		   c4.getNome().compareTo("Cristina")==0 && c4.getCognome().compareTo("Gialli")==0 &&		
		   c5.getNome().compareTo("Giuseppe")==0 && c5.getCognome().compareTo("Grigi")==0 &&		
		   c6.getNome().compareTo("Maria")==0 && c6.getCognome().compareTo("Arancioni")==0 )
		{
			System.out.println("\nElenco concorrenti corretto");
			corretto = true;
		}
		else
			System.out.println("\nElenco concorrenti errato");
			
		assertEquals("Implementazione del metodo elencoConcorrenti() e/o dei metodi correlati errata", true,corretto);	  
	}
  
  
	public void testElencoConcorrentiProfessione(){

		System.out.println("\n*** testElencoConcorrentiProfessione() ***\n");
		
		Trasmissione t = new Trasmissione();
		
		System.out.println("Iscritti concorrenti\n");
		t.iscriviConcorrente("Alberto", "Neri", "Attore");
		t.iscriviConcorrente("Giuseppe", "Grigi", "Avvocato");
		t.iscriviConcorrente("Maria", "Arancioni", "Commercialista");
		t.iscriviConcorrente("Anna", "Blu", "Avvocato");
		t.iscriviConcorrente("Alessio", "Verdi", "Commercialista");
		t.iscriviConcorrente("Cristina", "Gialli", "Commercialista");
	
		System.out.println("Elenco concorrenti di professione 'Commercialista' (ordine di iscrizione)");
		LinkedList<Concorrente> listaConcorrenti = new LinkedList<Concorrente>(t.elencoConcorrenti("Commercialista"));
		for(Concorrente ctemp : listaConcorrenti)
			System.out.println(" "+ctemp.getNome()+" "+ctemp.getCognome()+" (professione "+ctemp.getProfessione()+")");
		
		Concorrente c1 = listaConcorrenti.get(0);
		Concorrente c2 = listaConcorrenti.get(1);
		Concorrente c3 = listaConcorrenti.get(2);
		
		boolean corretto = false;
		
		if(c1.getNome().compareTo("Maria")==0 && c1.getCognome().compareTo("Arancioni")==0 && 
		   c2.getNome().compareTo("Alessio")==0 && c2.getCognome().compareTo("Verdi")==0 &&		
		   c3.getNome().compareTo("Cristina")==0 && c3.getCognome().compareTo("Gialli")==0 )
		{
			System.out.println("\nElenco concorrenti corretto");
			corretto = true;
		}
		else
			System.out.println("\nElenco concorrenti errato");
			
		assertEquals("Implementazione del metodo elencoConcorrenti() e/o dei metodi correlati errata", true,corretto);	  
	}

}






