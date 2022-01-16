package it.polito.po.test;

import agenzia_immobiliare.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR3_ClientiTransazioni extends TestCase {

	public void testNuovoCliente(){
		
		System.out.println("\n*** testNuovoCliente() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Definizione cliente");

		Cliente c1 = a.nuovoCliente("BLUMAR77S66H555T", "Blu", "Maria");
		
		System.out.println("\n* Informazioni:\n");

		System.out.println("Codice fiscale: "+c1.getCodiceFiscale());
		System.out.println("Cognome: "+c1.getCognome());
		System.out.println("Nome: "+c1.getNome());

		boolean corretto = false;
		
		if(c1.getCodiceFiscale().compareTo("BLUMAR77S66H555T")==0 &&
		   c1.getCognome().compareTo("Blu")==0 &&
		   c1.getNome().compareTo("Maria")==0)
		{
			System.out.println("\nInformazioni relative al cliente registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al cliente");
			
		assertEquals("Implementazione del metodo nuovoCliente() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	public void testElencoClientiOrdineDiCodiceFiscale(){
		
		System.out.println("\n*** testElencoClientiOrdineDiCodiceFiscale() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Definizione clienti\n");

		a.nuovoCliente("BLUMAR22S33H555T", "Blu", "Maria");
		a.nuovoCliente("ZZRNNA55S77B222T", "Azzurri", "Anna");
		a.nuovoCliente("RSSMCH44S99Y333T", "Rossi", "Michele");
		
		LinkedList<Cliente> listaClienti = new LinkedList<Cliente>(a.elencoClientiOrdineDiCodiceFiscale());
		for(Cliente c : listaClienti)
			System.out.println(c.getCodiceFiscale()+" "+c.getCognome()+" "+c.getNome());

		Cliente c0 = listaClienti.get(0);
		Cliente c1 = listaClienti.get(1);
		Cliente c2 = listaClienti.get(2);
		
		boolean corretto = false;
		
		if(c0.getCodiceFiscale().compareTo("BLUMAR22S33H555T")==0 && 
		   c1.getCodiceFiscale().compareTo("RSSMCH44S99Y333T")==0 && 
		   c2.getCodiceFiscale().compareTo("ZZRNNA55S77B222T")==0) 
		{
			System.out.println("\nElenco clienti gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco clienti gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoClientiOrdineDiCodiceFiscale() e/o dei metodi correlati errata", true,corretto);	  
	}

	
	public void testNuovaTransazioneDiVenditaIdImmobileImporto(){
		
		System.out.println("\n*** testNuovaTransazioneDiVenditaIdImmobileImporto() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione scheda immobile");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		
		System.out.println("\n* Definizione clienti");

		a.nuovoCliente("BLUMAR77S66H555T", "Blu", "Maria");
		a.nuovoCliente("ZZRNNA55S77B222T", "Azzurri", "Anna");
		
		System.out.println("\n* Definizione transazione di vendita tra i due clienti per l'immobile "+s1.getIdSchedaImmobile());

		int idt1 = -1;
		boolean eccezione = false;
		try {
			idt1 = a.nuovaTransazioneDiVendita(s1.getIdSchedaImmobile(), "BLUMAR77S66H555T", "ZZRNNA55S77B222T", 200000);

			System.out.println("\n* Informazioni transazione:\n");
			
			System.out.println("Identificativo transazione: "+idt1);
			System.out.println("Identificativo immobile: "+a.schedaImmobileTransazione(idt1).getIdSchedaImmobile());
			System.out.println("Importo: "+a.importoTransazione(idt1)+ " euro");
		
		} catch (EccezioneVenditaNonFinalizzabile e) {
			eccezione = true;
			e.printStackTrace();
		}
		
		boolean corretto = false;
		
		if(eccezione == false && 
		   idt1 == 100 &&
		   a.schedaImmobileTransazione(idt1).getIdSchedaImmobile().compareTo("MILANO1")==0 &&	
		   a.importoTransazione(idt1) == 200000)
		{
			System.out.println("\nIdentificativo, immobile ed importo della transazione registrati in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nIdentificativo, immobile ed importo della transazione registrati in maniera errata");
			
		assertEquals("Implementazione del metodo nuovaTransazioneDiVendita() e/o dei metodi correlati errata", true,corretto);	  
	}
	

	public void testNuovaTransazioneDiVenditaVenditoreAcquirente(){
		
		System.out.println("\n*** testNuovaTransazioneDiVenditaVenditoreAcquirente() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione scheda immobile");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		
		System.out.println("\n* Definizione clienti");

		a.nuovoCliente("BLUMAR77S66H555T", "Blu", "Maria");
		a.nuovoCliente("ZZRNNA55S77B222T", "Azzurri", "Anna");
		
		System.out.println("\n* Definizione transazione di vendita tra i due clienti per l'immobile "+s1.getIdSchedaImmobile());

		int idt1 = -1;
		boolean eccezione = false;
		try {
			idt1 = a.nuovaTransazioneDiVendita(s1.getIdSchedaImmobile(), "BLUMAR77S66H555T", "ZZRNNA55S77B222T", 200000);

			System.out.println("\n* Informazioni transazione:\n");
			
			System.out.println("Codice fiscale venditore: "+a.venditoreTransazione(idt1).getCodiceFiscale());
			System.out.println("Codice fiscale acquirente: "+a.acquirenteTransazione(idt1).getCodiceFiscale());
		
		} catch (EccezioneVenditaNonFinalizzabile e) {
			eccezione = true;
			e.printStackTrace();
		}
		
		boolean corretto = false;
		
		if(eccezione == false && 
		   a.venditoreTransazione(idt1) instanceof Venditore && 
		   a.venditoreTransazione(idt1).getCodiceFiscale().compareTo("BLUMAR77S66H555T")==0 &&
		   a.acquirenteTransazione(idt1) instanceof Acquirente &&
		   a.acquirenteTransazione(idt1).getCodiceFiscale().compareTo("ZZRNNA55S77B222T")==0)
		{
			System.out.println("\nVenditore ed acquirente della transazione registrati in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nVenditore ed acquirente della transazione registrati in maniera errata");
			
		assertEquals("Implementazione del metodo nuovaTransazioneDiVendita() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	public void testNuovaTransazioneDiVenditaEccezione(){
		
		System.out.println("\n*** testNuovaTransazioneDiVenditaEccezione() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione scheda immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		
		System.out.println("\n* Definizione clienti");

		a.nuovoCliente("BLUMAR77S66H555T", "Blu", "Maria");
		a.nuovoCliente("ZZRNNA55S77B222T", "Azzurri", "Anna");
		
		System.out.println("\n* Definizione transazione di vendita tra i due clienti per immobile inesistente");

		int idt1 = -1;
		boolean eccezione = false;
		try {
			idt1 = a.nuovaTransazioneDiVendita("FIRENZE1", "BLUMAR77S66H555T", "ZZRNNA55S77B222T", 200000);

			System.out.println("\n* Informazioni transazione:\n");
			
			System.out.println("Identificativo transazione: "+idt1);
			System.out.println("Identificativo immobile: "+a.schedaImmobileTransazione(idt1).getIdSchedaImmobile());
			System.out.println("Importo: "+a.importoTransazione(idt1)+ " euro");
		
		} catch (EccezioneVenditaNonFinalizzabile e) {
			System.out.println("\n* Errore transazione\n");
			eccezione = true;
			//e.printStackTrace();
		}
		
		boolean corretto = false;
		
		if(eccezione == true)
		{
			System.out.println("\nErrore informazioni transazione gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore informazioni transazione gestita in maniera errata");
			
		assertEquals("Implementazione del metodo nuovaTransazioneDiVendita() e/o dei metodi correlati errata", true,corretto);	  
	}
	

	public void testStampaTransazioniOrdineDiImportoIdScheda(){
		
		System.out.println("\n*** testStampaTransazioniOrdineDiImportoIdScheda() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		SchedaImmobile s2 = a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		SchedaImmobile s3 = a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		
		System.out.println("\n* Definizione clienti");

		a.nuovoCliente("BLUMAR77S66H555T", "Blu", "Maria");
		a.nuovoCliente("ZZRNNA55S77B222T", "Azzurri", "Anna");
		a.nuovoCliente("RSSMCH44S99Y333T", "Rossi", "Michele");
		a.nuovoCliente("GLLALB11S99A111Z", "Gialli", "Alberto");
		
		System.out.println("\n* Definite transazioni");

		boolean eccezione = false;
		try {
			a.nuovaTransazioneDiVendita(s1.getIdSchedaImmobile(), "BLUMAR77S66H555T", "ZZRNNA55S77B222T", 200000);
			a.nuovaTransazioneDiVendita(s2.getIdSchedaImmobile(), "RSSMCH44S99Y333T", "GLLALB11S99A111Z", 100000);
			a.nuovaTransazioneDiVendita(s3.getIdSchedaImmobile(), "ZZRNNA55S77B222T", "RSSMCH44S99Y333T", 100000);
		
		} catch (EccezioneVenditaNonFinalizzabile e1) {
			eccezione = true;
			e1.printStackTrace();
		}

		System.out.println("\n* Stampa transazioni (per importo ed identificativo scheda immobile):\n");
		String transazioni = a.stampaTransazioniOrdineDiImportoIdScheda();
		System.out.println(""+transazioni);

		boolean corretto = false;
		
		if(eccezione == false && 
		   transazioni.compareTo("102 MILANO2 ZZRNNA55S77B222T RSSMCH44S99Y333T 100000.0\n101 NAPOLI1 RSSMCH44S99Y333T GLLALB11S99A111Z 100000.0\n100 MILANO1 BLUMAR77S66H555T ZZRNNA55S77B222T 200000.0")==0)
		{
			System.out.println("\nStampa transazioni gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nStampa transazioni gestita in maniera errata");
			
		assertEquals("Implementazione del metodo stampaTransazioniOrdineDiImportoIdScheda() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
}


