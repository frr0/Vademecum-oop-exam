package it.polito.po.test;

import congressi.*;

import junit.framework.TestCase;

public class TestR4_Programma extends TestCase {
	
	public void testProgrammaSessioneCongressoOratoreSingolo() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testProgrammaSessioneCongressoOratoreSingolo() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");

		System.out.println("\nDefinite sale per il centro");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Small room", 10);

		System.out.println("\nDefinito congresso");
		
		o.definisciCongresso("Congress A", "20190705", "20190710", ce.getId());
		
		System.out.println("\nAssegna sale a congresso");

		o.assegnaSaleCongresso("Congress A", "Room");
		o.assegnaSaleCongresso("Congress A", "Small room");
		o.assegnaSaleCongresso("Congress A", "Invisible room");
		
		System.out.println("\nPianifica sessione (singolo oratore)");

		o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the great speaker", "20190705", "12:00", "12:59");

		System.out.println("\nAlloca oratore sessione (singolo oratore)");

		o.allocaOratoreSessioneCongresso("Congress A", 1, "Jiminy", "Cricket");
		
		System.out.println("\nProgramma sessione");
		String risultato = o.programmaSessioneCongresso("Congress A", 1);
		System.out.println(""+risultato);
		
		boolean corretto = false;
		
		if(risultato.trim().compareTo("12:00 Jiminy Cricket")==0 || risultato.trim().compareTo("12:00 Jiminy Cricket\n")==0)
		{
			System.out.println("\nGenerazione programma sessione gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nGenerazione programma sessione gestita in maniera errata");
			
		assertEquals("Implementazione del metodo programmaSessioneCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}

	
	public void testProgrammaSessioneCongressoOratoriMultipli() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testProgrammaSessioneCongressoOratoriMultipli() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");

		System.out.println("\nDefinite sale per il centro");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Small room", 10);

		System.out.println("\nDefinito congresso");
		
		o.definisciCongresso("Congress A", "20190705", "20190710", ce.getId());
		
		System.out.println("\nAssegna sale a congresso");

		o.assegnaSaleCongresso("Congress A", "Room");
		o.assegnaSaleCongresso("Congress A", "Small room");
		o.assegnaSaleCongresso("Congress A", "Invisible room");
		
		System.out.println("\nPianifica sessione (oratori multipli)");

		o.pianificaSessioneCongresso("Congress A", "Room", 'M', "Session of the many speakers", "20190705", "12:00", "12:59");

		System.out.println("\nAlloca oratori sessione (oratori multipli)");

		o.allocaOratoreSessioneCongresso("Congress A", 1, "Speaker", "One", "12:00");
		o.allocaOratoreSessioneCongresso("Congress A", 1, "Speaker", "Two", "12:30");
		
		System.out.println("\nProgramma sessione");
		String risultato = o.programmaSessioneCongresso("Congress A", 1);
		System.out.println(""+risultato);
		
		boolean corretto = false;
		
		if(risultato.contains("12:00 Speaker One\n12:30 Speaker Two") ||
		   risultato.contains("12:00 Speaker One\n12:30 Speaker Two\n") ||				
		   risultato.contains(" 12:00 Speaker One\n 12:30 Speaker Two") ||			
		   risultato.contains(" 12:00 Speaker One\n 12:30 Speaker Two\n"))
		{
			System.out.println("\nGenerazione programma sessione gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nGenerazione programma sessione gestita in maniera errata");
			
		assertEquals("Implementazione del metodo programmaSessioneCongresso() e/o dei metodi correlati errata", true,corretto);	  	
	}
	
	
	public void testProgrammaCongresso() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testProgrammaCongresso() ***\n");
		
		Organizzazione o = new Organizzazione();
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Congress Center #1", "Address of the Congress Center #1");

		System.out.println("\nDefinite sale per il centro");
		o.definisciSalaCentro(ce.getId(), "Room", 100);
		o.definisciSalaCentro(ce.getId(), "Small room", 10);

		System.out.println("\nDefinito congresso");
		
		o.definisciCongresso("Congress A", "20190705", "20190710", ce.getId());
		
		System.out.println("\nAssegna sale a congresso");

		o.assegnaSaleCongresso("Congress A", "Room");
		o.assegnaSaleCongresso("Congress A", "Small room");
		o.assegnaSaleCongresso("Congress A", "Invisible room");
		
		System.out.println("\nPianifica sessione (oratori multipli)");

		o.pianificaSessioneCongresso("Congress A", "Room", 'M', "Session of the many speakers", "20190707", "12:00", "12:59");

		System.out.println("\nAlloca oratori sessione (oratori multipli)");

		o.allocaOratoreSessioneCongresso("Congress A", 1, "Speaker", "One", "12:00");
		o.allocaOratoreSessioneCongresso("Congress A", 1, "Speaker", "Two", "12:30");

		System.out.println("\nPianifica altra sessione (oratori multipli)");

		o.pianificaSessioneCongresso("Congress A", "Room", 'M', "Other session of the many speakers", "20190706", "09:00", "10:30");

		System.out.println("\nAlloca oratori sessione (oratori multipli)");

		o.allocaOratoreSessioneCongresso("Congress A", 2, "Speaker", "Three", "09:00");
		o.allocaOratoreSessioneCongresso("Congress A", 2, "Speaker", "Four", "09:30");
		o.allocaOratoreSessioneCongresso("Congress A", 2, "Speaker", "Five", "10:00");
		
		System.out.println("\nProgramma congresso \"Congress A\" (ordine cronologico)");
		String risultato = o.programmaCongresso("Congress A");
		System.out.println(""+risultato);
		
		boolean corretto = false;
		
		if(risultato.replace("\n", "").replace(" ", "").contains("2019070609:0010:30Othersessionofthemanyspeakers09:00SpeakerThree09:30SpeakerFour10:00SpeakerFive2019070712:0012:59Sessionofthemanyspeakers12:00SpeakerOne12:30SpeakerTwo"))		
		{
			System.out.println("\nGenerazione programma congresso gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nGenerazione programma congresso gestita in maniera errata");
			
		assertEquals("Implementazione del metodo programmaCongresso() e/o dei metodi correlati errata", true,corretto);	  	
	}
	
}
