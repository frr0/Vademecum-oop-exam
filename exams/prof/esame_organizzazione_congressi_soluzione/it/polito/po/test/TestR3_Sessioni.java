package it.polito.po.test;

import congressi.*;
import java.util.*;

import junit.framework.TestCase;

public class TestR3_Sessioni extends TestCase {

	public void testPianificaSessioneCongressoOratoreSingolo() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testPianificaSessioneCongressoOratoreSingolo() ***\n");
		
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
		
		System.out.println("\nPianifica sessione \"Session X\" (singolo oratore)");

		Sessione se = o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the great speaker", "20190705", "12:00", "12:59");
		System.out.println(" Numero sessione: "+ se.getNumero());
		System.out.println(" Nome: "+ se.getNome());
		System.out.println(" Data: "+ se.getData());
		System.out.println(" Dalle: "+ se.getDaOra());
		System.out.println(" Alle: "+ se.getAdOra());

		boolean corretto = false;
		
		if(se instanceof SessioneSingoloOratore && se.getNumero()==1 && se.getNomeCongresso().compareTo("Congress A")==0 && se.getNomeSala().compareTo("Room")==0 && se.getNome().compareTo("Session of the great speaker")==0 && se.getData().compareTo("20190705")==0 && se.getDaOra().compareTo("12:00")==0 && se.getAdOra().compareTo("12:59")==0)
		{
			System.out.println("\nInformazioni relative alla sessione registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni relative alla sessione registrate in maniera errata");
			
		assertEquals("Implementazione del metodo pianificaSessioneCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}
	
	
	public void testPianificaSessioneCongressoOratoriMultipli() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testPianificaSessioneCongressoOratoriMultipli() ***\n");
		
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
		
		System.out.println("\nPianifica sessione \"Session M\" (oratori multipli)");

		Sessione se = o.pianificaSessioneCongresso("Congress A", "Room", 'M', "Session of the many speakers", "20190705", "14:00", "15:59");
		System.out.println(" Numero sessione: "+ se.getNumero());
		System.out.println(" Nome: "+ se.getNome());
		System.out.println(" Data: "+ se.getData());
		System.out.println(" Dalle: "+ se.getDaOra());
		System.out.println(" Alle: "+ se.getAdOra());

		boolean corretto = false;
		
		if(se instanceof SessioneOratoriMultipli)
		{
			System.out.println("\nInformazioni relative alla sessione registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni relative alla sessione registrate in maniera errata");
			
		assertEquals("Implementazione del metodo pianificaSessioneCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}

	
	public void testPianificaSessioneCongressoIdSuccessivi() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testPianificaSessioneCongresso() ***\n");
		
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
		
		System.out.println("\nPianifica sessione \"Session X\" (singolo oratore)");

		Sessione se1 = o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the great speaker", "20190705", "12:00", "12:59");
		System.out.println(" Numero sessione: "+ se1.getNumero());
		System.out.println(" Nome: "+ se1.getNome());
		System.out.println(" Data: "+ se1.getData());
		System.out.println(" Dalle: "+ se1.getDaOra());
		System.out.println(" Alle: "+ se1.getAdOra());

		System.out.println("\nPianifica sessione \"Session Y\" (singolo oratore) stesso congresso");

		Sessione se2 = o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the another speaker", "20190705", "13:00", "13:59");
		System.out.println(" Numero sessione: "+ se2.getNumero());
		System.out.println(" Nome: "+ se2.getNome());
		System.out.println(" Data: "+ se2.getData());
		System.out.println(" Dalle: "+ se2.getDaOra());
		System.out.println(" Alle: "+ se2.getAdOra());
		
		System.out.println("\nDefinito altro congresso");
		
		o.definisciCongresso("Congress B", "20200705", "20200710", ce.getId());
		
		System.out.println("\nAssegna sale ad altro congresso");

		o.assegnaSaleCongresso("Congress A", "Room");
		o.assegnaSaleCongresso("Congress A", "Small room");
		o.assegnaSaleCongresso("Congress A", "Invisible room");
		
		System.out.println("\nPianifica sessione \"Session Z\" (singolo oratore) altro congresso");

		Sessione se3 = o.pianificaSessioneCongresso("Congress B", "Room", 'S', "Session of another great speaker", "20200705", "12:00", "12:59");
		System.out.println(" Numero sessione: "+ se3.getNumero());
		System.out.println(" Nome: "+ se3.getNome());
		System.out.println(" Data: "+ se3.getData());
		System.out.println(" Dalle: "+ se3.getDaOra());
		System.out.println(" Alle: "+ se3.getAdOra());
		
		boolean corretto = false;
		
		if(se1.getNumero()==1 && se2.getNumero()==2 && se3.getNumero()==1)
		{
			System.out.println("\nInformazioni relative alle sessioni registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nInformazioni relative alle sessioni registrate in maniera errata");
			
		assertEquals("Implementazione del metodo pianificaSessioneCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}
	
	
	public void testPianificaSessioneCongressoSovrapposta1() throws EccezioneSessioneSovrapposta {

		System.out.println("\n*** testPianificaSessioneCongressoSovrapposta1() ***\n");
		
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
		
		System.out.println("\nPianifica sessione \"Session X\" (singolo oratore)");

		Sessione se1 = o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the great speaker", "20190705", "12:00", "12:59");
		System.out.println(" Numero sessione: "+ se1.getNumero());
		System.out.println(" Nome: "+ se1.getNome());
		System.out.println(" Data: "+ se1.getData());
		System.out.println(" Dalle: "+ se1.getDaOra());
		System.out.println(" Alle: "+ se1.getAdOra());

		System.out.println("\nPianifica sessione \"Session Y\" (singolo oratore) stesso congresso, orario sovrapposto");

		boolean eccezione = false;
		try {
		Sessione se2 = o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the another speaker", "20190705", "11:30", "12:10");
		System.out.println(" Numero sessione: "+ se2.getNumero());
		System.out.println(" Nome: "+ se2.getNome());
		System.out.println(" Data: "+ se2.getData());
		System.out.println(" Dalle: "+ se2.getDaOra());
		System.out.println(" Alle: "+ se2.getAdOra());
		}
		catch(EccezioneSessioneSovrapposta e) {
			eccezione = true;
			System.out.println("\nEccezione: sessione sovrapposta");
		}
		
		boolean corretto = false;
		
		if(eccezione==true)
		{
			System.out.println("\nPianificazione sessione sovrapposta gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nPianificazione sessione sovrapposta gestita in maniera corretta");
			
		assertEquals("Implementazione del metodo pianificaSessioneCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}

	
	public void testPianificaSessioneCongressoSovrapposta2() throws EccezioneSessioneSovrapposta {

		System.out.println("\n*** testPianificaSessioneCongressoSovrapposta2() ***\n");
		
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
		
		System.out.println("\nPianifica sessione \"Session X\" (singolo oratore)");

		Sessione se1 = o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the great speaker", "20190705", "12:00", "12:59");
		System.out.println(" Numero sessione: "+ se1.getNumero());
		System.out.println(" Nome: "+ se1.getNome());
		System.out.println(" Data: "+ se1.getData());
		System.out.println(" Dalle: "+ se1.getDaOra());
		System.out.println(" Alle: "+ se1.getAdOra());

		System.out.println("\nPianifica sessione \"Session Y\" (singolo oratore) stesso congresso, orario sovrapposto");

		boolean eccezione = false;
		try {
		Sessione se2 = o.pianificaSessioneCongresso("Congress A", "Room", 'S', "Session of the another speaker", "20190705", "11:00", "14:00");
		System.out.println(" Numero sessione: "+ se2.getNumero());
		System.out.println(" Nome: "+ se2.getNome());
		System.out.println(" Data: "+ se2.getData());
		System.out.println(" Dalle: "+ se2.getDaOra());
		System.out.println(" Alle: "+ se2.getAdOra());
		}
		catch(EccezioneSessioneSovrapposta e) {
			eccezione = true;
			System.out.println("\nEccezione: sessione sovrapposta");
		}
		
		boolean corretto = false;
		
		if(eccezione==true)
		{
			System.out.println("\nPianificazione sessione sovrapposta gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nPianificazione sessione sovrapposta gestita in maniera corretta");
			
		assertEquals("Implementazione del metodo pianificaSessioneCongresso() e/o dei metodi correlati errata", true,corretto);	  
	
	}
	
	
	public void testAllocaOratoreSessioneCongressoEdElencoOratori() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testAllocaOratoreSessioneCongressoEdElencoOratori() ***\n");
		
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
		
		System.out.println("\nElenco oratori sessione (singolo oratore)");
		LinkedList<String> listaOratori = new LinkedList<String>(o.elencoOratoriSessioneCongresso("Congress A", 1));
		for(String s : listaOratori)
			System.out.println(" "+s);
		
		String or1 = listaOratori.get(0);
		
		boolean corretto = false;
		
		if(or1.compareTo("Jiminy Cricket")==0 || or1.compareTo("Jiminy Cricket\n")==0)
		{
			System.out.println("\nAllocazione oratore sessione gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nAllocazione oratore sessione gestita in maniera corretta");
			
		assertEquals("Implementazione del metodo allocaOratoreSessioneCongresso, elencoOratoriSessioneCongresso () e/o dei metodi correlati errata", true,corretto);	  
	
	}
	
	
	public void testAllocaOratoreSessioneCongressoEdElencoOratoriMultipli() throws EccezioneSessioneSovrapposta{

		System.out.println("\n*** testAllocaOratoreSessioneCongressoEdElencoOratoriMultipli() ***\n");
		
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
		
		System.out.println("\nElenco oratori sessione (oratori multipli)");
		LinkedList<String> listaOratori = new LinkedList<String>(o.elencoOratoriSessioneCongresso("Congress A", 1));
		for(String s : listaOratori)
			System.out.println(" "+s);
		
		String or1 = listaOratori.get(0);
		String or2 = listaOratori.get(1);
		
		boolean corretto = false;
		
		if((or1.compareTo("Speaker One")==0 && or2.compareTo("Speaker Two")==0) || (or1.compareTo("Speaker Two")==0 && or2.compareTo("Speaker One")==0) || (or1.compareTo("Speaker One\n")==0 && or2.compareTo("Speaker Two\n")==0) || (or1.compareTo("Speaker Two\n")==0 && or2.compareTo("Speaker One\n")==0))
		{
			System.out.println("\nAllocazione oratori sessione gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nAllocazione oratori sessione gestita in maniera corretta");
			
		assertEquals("Implementazione del metodo allocaOratoreSessioneCongresso, elencoOratoriSessioneCongresso () e/o dei metodi correlati errata", true,corretto);	  
	
	}
}






