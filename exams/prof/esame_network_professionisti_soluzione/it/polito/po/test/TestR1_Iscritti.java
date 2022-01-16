package it.polito.po.test;

import network_professionisti.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR1_Iscritti extends TestCase {

	public void testIscriviConcorrente(){

		System.out.println("\n*** testNuovoIscritto() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritto nuovo utente al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		
		System.out.println(" Nome: "+i1.getNome());
		System.out.println(" Cognome: "+i1.getCognome());
		System.out.println(" Web: "+i1.getWeb());
		System.out.println(" Email: "+i1.getEmail());
		System.out.println(" Descrizione (abbr.): "+i1.getDescrizione().substring(0, Math.min(i1.getDescrizione().length(), 30))+" ...");
		
		boolean corretto = false;
		
		if(i1.getNome().compareTo("Luigi")==0 && i1.getCognome().compareTo("Neri")==0 && i1.getWeb().compareTo("http://www.luigineri.com")==0 && i1.getEmail().compareTo("lneri@mail.com")==0 && i1.getDescrizione().compareTo("Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.")==0)
		{
			System.out.println("\nInformazioni relative al nuovo iscritto registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al nuovo iscritto");
			
		assertEquals("Implementazione del metodo nuovoIscritto() e/o dei metodi correlati errata", true,corretto);	  
	}

	
	public void testIdentificativoSingoloAssegnato(){

		System.out.println("\n*** testIdentificativoSingoloAssegnato() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritto primo utente 'Luigi' 'Neri' al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		boolean corretto = false;
		
		if(i1.getId().compareTo("Luigi-Neri")==0)
		{
			System.out.println("\nIdentificato assegnato al nuovo iscritto corretto");
			corretto = true;
		}
		else
			System.out.println("\nIdentificato assegnato al nuovo iscritto errato");
			
		assertEquals("Implementazione del metodo nuovoIscritto() e/o dei metodi correlati errata", true,corretto);	
	}

	public void testIdentificativiMultipliAssegnati(){

		System.out.println("\n*** testIdentificativiMultipliAssegnati() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritto primo utente 'Luigi' 'Neri' al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		boolean corretto = false;
		
		if(i1.getId().compareTo("Luigi-Neri")==0)
		{
			System.out.println("\nIdentificato assegnato al nuovo iscritto corretto");
			corretto = true;
		}
		else
			System.out.println("\nIdentificato assegnato al nuovo iscritto errato");
			
		assertEquals("Implementazione del metodo nuovoIscritto() e/o dei metodi correlati errata", true,corretto);	
		
		System.out.println("\nIscritto secondo utente 'Luigi' 'Neri' al network");
		
		i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.ln.it", "ln@posta.it", "Il Dottor Luigi Neri è il primario dell'Ospedale dei Sani.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		corretto = false;
		
		if(i1.getId().compareTo("Luigi-Neri-1")==0)
		{
			System.out.println("\nIdentificato assegnato al nuovo iscritto corretto");
			corretto = true;
		}
		else
			System.out.println("\nIdentificato assegnato al nuovo iscritto errato");
			
		assertEquals("Implementazione del metodo nuovoIscritto() e/o dei metodi correlati errata", true,corretto);	
		
		System.out.println("\nIscritto terzo utente 'Luigi' 'Neri' al network");
		
		i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.lneri.eu", "luigin@mail.eu", "L'Avvocato Luigi Neri difende solo cause indifendibili.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		corretto = false;
		
		if(i1.getId().compareTo("Luigi-Neri-2")==0)
		{
			System.out.println("\nIdentificato assegnato al nuovo iscritto corretto");
			corretto = true;
		}
		else
			System.out.println("\nIdentificato assegnato al nuovo iscritto errato");
			
		assertEquals("Implementazione del metodo nuovoIscritto() e/o dei metodi correlati errata", true,corretto);	
		
		System.out.println("\nIscritto primo utente 'Alessia' 'Azzurri' al network");
		
		i1 = n.nuovoIscritto("Alessia", "Azzurri", "http://www.alessia.com", "ale@mail.com", "Alessia ha studiato al Politecnico di Torino. Adesso si sta occupando di marketing online.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		corretto = false;
		
		if(i1.getId().compareTo("Alessia-Azzurri")==0)
		{
			System.out.println("\nIdentificato assegnato al nuovo iscritto corretto");
			corretto = true;
		}
		else
			System.out.println("\nIdentificato assegnato al nuovo iscritto errato");
			
		assertEquals("Implementazione del metodo nuovoIscritto() e/o dei metodi correlati errata", true,corretto);	
		
	}
	
	
	public void testCercaIscrittoPerNomeCognome(){

		System.out.println("\n*** testCercaIscrittoPerNomeCognome() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritti utenti al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		System.out.println(" '"+i1.getId()+"' '"+i1.getNome()+"' '"+i1.getCognome()+"' '"+i1.getWeb()+"' '"+i1.getEmail()+"' "+i1.getDescrizione().substring(0, Math.min(i1.getDescrizione().length(), 30))+" ...'");
		Iscritto i2 = n.nuovoIscritto("Daniela", "Gialli", "http://www.dg.it", "dg@mail.it", "Daniela Gialli lavora come pasticciera su una nave da crociera.");
		System.out.println(" '"+i2.getId()+"' '"+i2.getNome()+"' '"+i2.getCognome()+"' '"+i2.getWeb()+"' '"+i2.getEmail()+"' "+i2.getDescrizione().substring(0, Math.min(i2.getDescrizione().length(), 30))+" ...'");
		Iscritto i3 = n.nuovoIscritto("Marco", "Blu", "http://www.mblu.eu", "mblu@mail.eu", "Marco Blu gioca come terzino nella squadra di calcetto del quartiere.");
		System.out.println(" '"+i3.getId()+"' '"+i3.getNome()+"' '"+i3.getCognome()+"' '"+i3.getWeb()+"' '"+i3.getEmail()+"' "+i3.getDescrizione().substring(0, Math.min(i3.getDescrizione().length(), 30))+" ...'");

		System.out.println("\nCerca iscritto 'Marco' 'Blu'");
		Iscritto i4 = n.cercaIscrittoPerNomeCognome("Marco", "Blu");

		System.out.println(" '"+i4.getId()+"' '"+i4.getNome()+"' '"+i4.getCognome()+"' '"+i4.getWeb()+"' '"+i4.getEmail()+"' "+i4.getDescrizione().substring(0, Math.min(i3.getDescrizione().length(), 30))+" ...'");
		
		
		boolean corretto = false;
		
		if(i4.getNome().compareTo("Marco")==0 && i4.getCognome().compareTo("Blu")==0)
		{
			System.out.println("\nRicerca iscritto per nome e cognome gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca iscritto  per nome e cognome gestita in maniera errata");
			
		assertEquals("Implementazione del metodo cercaIscrittoPerNomeCognome() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testCercaIscrittoPerNomeCognomeInformazioniParziali(){

		System.out.println("\n*** testCercaIscrittoPerNomeCognomeInformazioniParziali() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritti utenti al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		System.out.println(" '"+i1.getId()+"' '"+i1.getNome()+"' '"+i1.getCognome()+"' '"+i1.getWeb()+"' '"+i1.getEmail()+"' "+i1.getDescrizione().substring(0, Math.min(i1.getDescrizione().length(), 30))+" ...'");
		Iscritto i2 = n.nuovoIscritto("Daniela", "Gialli", "http://www.dg.it", "dg@mail.it", "Daniela Gialli lavora come pasticciera su una nave da crociera.");
		System.out.println(" '"+i2.getId()+"' '"+i2.getNome()+"' '"+i2.getCognome()+"' '"+i2.getWeb()+"' '"+i2.getEmail()+"' "+i2.getDescrizione().substring(0, Math.min(i2.getDescrizione().length(), 30))+" ...'");
		Iscritto i3 = n.nuovoIscritto("Marco", "Blu", "http://www.mblu.eu", "mblu@mail.eu", "Marco Blu gioca come terzino nella squadra di calcetto del quartiere.");
		System.out.println(" '"+i3.getId()+"' '"+i3.getNome()+"' '"+i3.getCognome()+"' '"+i3.getWeb()+"' '"+i3.getEmail()+"' "+i3.getDescrizione().substring(0, Math.min(i3.getDescrizione().length(), 30))+" ...'");

		System.out.println("\nCerca iscritto 'la' 'Gia'");
		Iscritto i4 = n.cercaIscrittoPerNomeCognome("la", "Gia");

		System.out.println(" '"+i4.getId()+"' '"+i4.getNome()+"' '"+i4.getCognome()+"' '"+i4.getWeb()+"' '"+i4.getEmail()+"' "+i4.getDescrizione().substring(0, Math.min(i3.getDescrizione().length(), 30))+" ...'");
		
		
		boolean corretto = false;
		
		if(i4.getNome().compareTo("Daniela")==0 && i4.getCognome().compareTo("Gialli")==0)
		{
			System.out.println("\nRicerca iscritto per nome e cognome con informazioni parziali gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca iscritto  per nome e cognome con informazioni parziali gestita in maniera errata");
			
		assertEquals("Implementazione del metodo cercaIscrittoPerNomeCognome() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testCercaIscrittoPerId(){

		System.out.println("\n*** testCercaIscrittoPerId() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritti utenti al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		System.out.println(" '"+i1.getId()+"' '"+i1.getNome()+"' '"+i1.getCognome()+"' '"+i1.getWeb()+"' '"+i1.getEmail()+"' "+i1.getDescrizione().substring(0, Math.min(i1.getDescrizione().length(), 30))+" ...'");
		Iscritto i2 = n.nuovoIscritto("Daniela", "Gialli", "http://www.dg.it", "dg@mail.it", "Daniela Gialli lavora come pasticciera su una nave da crociera.");
		System.out.println(" '"+i2.getId()+"' '"+i2.getNome()+"' '"+i2.getCognome()+"' '"+i2.getWeb()+"' '"+i2.getEmail()+"' "+i2.getDescrizione().substring(0, Math.min(i2.getDescrizione().length(), 30))+" ...'");
		Iscritto i3 = n.nuovoIscritto("Marco", "Blu", "http://www.mblu.eu", "mblu@mail.eu", "Marco Blu gioca come terzino nella squadra di calcetto del quartiere.");
		System.out.println(" '"+i3.getId()+"' '"+i3.getNome()+"' '"+i3.getCognome()+"' '"+i3.getWeb()+"' '"+i3.getEmail()+"' "+i3.getDescrizione().substring(0, Math.min(i3.getDescrizione().length(), 30))+" ...'");

		System.out.println("\nCerca iscritto con identificativo 'Luigi-Neri'");
		Iscritto i4 = n.cercaIscrittoPerId("Luigi-Neri");

		System.out.println(" '"+i4.getId()+"' '"+i4.getNome()+"' '"+i4.getCognome()+"' '"+i4.getWeb()+"' '"+i4.getEmail()+"' "+i4.getDescrizione().substring(0, Math.min(i3.getDescrizione().length(), 30))+" ...'");
		
		
		boolean corretto = false;
		
		if(i4.getNome().compareTo("Luigi")==0 && i4.getCognome().compareTo("Neri")==0)
		{
			System.out.println("\nRicerca iscritto per identificativo gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca iscritto  per identificativo gestita in maniera errata");
			
		assertEquals("Implementazione del metodo cercaIscrittoPerId() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testElencoIscritti(){

		System.out.println("\n*** testElencoIscritti() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritti utenti al network");
		
		n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		n.nuovoIscritto("Daniela", "Gialli", "http://www.dg.it", "dg@mail.it", "Daniela Gialli lavora come pasticciera su una nave da crociera.");
		n.nuovoIscritto("Marco", "Blu", "http://www.mblu.eu", "mblu@mail.eu", "Marco Blu gioca come terzino nella squadra di calcetto del quartiere.");

		System.out.println("\nElenco iscritti (ordine alfabetico)");
		LinkedList<Iscritto> listaIscritti = new LinkedList<Iscritto>(n.elencoIscritti());
		for(Iscritto i : listaIscritti)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");
		
		Iscritto i1 = listaIscritti.get(0);
		Iscritto i2 = listaIscritti.get(1);
		Iscritto i3 = listaIscritti.get(2);
		
		boolean corretto = false;
		
		if(i1.getNome().compareTo("Daniela")==0 && i1.getCognome().compareTo("Gialli")==0 && 
	       i2.getNome().compareTo("Luigi")==0 && i2.getCognome().compareTo("Neri")==0 && 	
	       i3.getNome().compareTo("Marco")==0 && i3.getCognome().compareTo("Blu")==0)
		{
			System.out.println("\nElenco iscritti gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco iscritti gestito in maniera errata");
			
		assertEquals("Implementazione del metodo cercaIscrittoPerId() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	public void testElencoIscrittiSimiliDuplicati(){

		System.out.println("\n*** testElencoIscrittiSimiliDuplicati() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritti utenti al network");
		
		n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		n.nuovoIscritto("Daniela", "Gialli", "http://www.dg.it", "dg@mail.it", "Daniela Gialli lavora come pasticciera su una nave da crociera.");
		n.nuovoIscritto("Marco", "Blu", "http://www.mblu.eu", "mblu@mail.eu", "Marco Blu gioca come terzino nella squadra di calcetto del quartiere.");
		n.nuovoIscritto("Luigi", "Neri", "http://www.ln.it", "ln@posta.it", "Il Dottor Luigi Neri è il primario dell'Ospedale dei Sani.");
		n.nuovoIscritto("Daniela", "Gialla", "http://www.daniela.com", "daniela@mail.com", "Daniela Gialla allena la nazionale di calcio femminile.");

		System.out.println("\nElenco iscritti (ordine alfabetico)");
		LinkedList<Iscritto> listaIscritti = new LinkedList<Iscritto>(n.elencoIscritti());
		for(Iscritto i : listaIscritti)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");
		
		Iscritto i1 = listaIscritti.get(0);
		Iscritto i2 = listaIscritti.get(1);
		Iscritto i3 = listaIscritti.get(2);
		Iscritto i4 = listaIscritti.get(3);
		Iscritto i5 = listaIscritti.get(4);
		
		boolean corretto = false;
		
		if(i1.getNome().compareTo("Daniela")==0 && i1.getCognome().compareTo("Gialla")==0 && i1.getId().compareTo("Daniela-Gialla") ==0 && 
	       i2.getNome().compareTo("Daniela")==0 && i2.getCognome().compareTo("Gialli")==0 && i2.getId().compareTo("Daniela-Gialli") ==0 && 	
	       i3.getNome().compareTo("Luigi")==0 && i3.getCognome().compareTo("Neri")==0 && i3.getId().compareTo("Luigi-Neri") ==0 && 	
	       i4.getNome().compareTo("Luigi")==0 && i4.getCognome().compareTo("Neri")==0 && i4.getId().compareTo("Luigi-Neri-1") ==0 && 	
	       i5.getNome().compareTo("Marco")==0 && i5.getCognome().compareTo("Blu")==0 && i5.getId().compareTo("Marco-Blu") ==0)
		{
			System.out.println("\nElenco iscritti gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco iscritti gestito in maniera errata");
			
		assertEquals("Implementazione del metodo cercaIscrittoPerId() e/o dei metodi correlati errata", true,corretto);	  	}
}






