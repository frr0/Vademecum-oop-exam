package it.polito.po.test;

import agenzia_immobiliare.*;

import junit.framework.TestCase;

public class TestR4_Introiti extends TestCase {

	public void testCalcolaIntroiti(){
		
		System.out.println("\n*** testCalcolaIntroiti() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		SchedaImmobile s2 = a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		
		System.out.println("\n* Definizione clienti");

		a.nuovoCliente("BLUMAR77S66H555T", "Blu", "Maria");
		a.nuovoCliente("ZZRNNA55S77B222T", "Azzurri", "Anna");
		a.nuovoCliente("RSSMCH44S99Y333T", "Rossi", "Michele");
		a.nuovoCliente("GLLALB11S99A111Z", "Gialli", "Alberto");
		
		System.out.println("\n* Definite transazioni");

		try {
			a.nuovaTransazioneDiVendita(s1.getIdSchedaImmobile(), "BLUMAR77S66H555T", "ZZRNNA55S77B222T", 200000);
			a.nuovaTransazioneDiVendita(s2.getIdSchedaImmobile(), "RSSMCH44S99Y333T", "GLLALB11S99A111Z", 100000);
		
		} catch (EccezioneVenditaNonFinalizzabile e1) {
			e1.printStackTrace();
		}

		System.out.println("\n* Introiti calcolati con percentuale di riferimento al 10%:");
		double introiti = a.calcolaIntroiti(10);
		
		System.out.println("\n"+introiti);

		boolean corretto = false;
		
		if(introiti == 60000)
		{
			System.out.println("\nCalcolo introiti gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nCalcolo introiti gestito in maniera errata");
			
		assertEquals("Implementazione del metodo calcolaIntroiti() e/o dei metodi correlati errata", true,corretto);	  
	}
	

	public void testCalcolaIntroitiClientiRipetuti(){
		
		System.out.println("\n*** testCalcolaIntroitiClientiRipetuti() ***\n");
		
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

		try {
			a.nuovaTransazioneDiVendita(s1.getIdSchedaImmobile(), "BLUMAR77S66H555T", "ZZRNNA55S77B222T", 200000);
			a.nuovaTransazioneDiVendita(s2.getIdSchedaImmobile(), "RSSMCH44S99Y333T", "GLLALB11S99A111Z", 100000);
			a.nuovaTransazioneDiVendita(s3.getIdSchedaImmobile(), "BLUMAR77S66H555T", "RSSMCH44S99Y333T", 100000);
		
		} catch (EccezioneVenditaNonFinalizzabile e1) {
			e1.printStackTrace();
		}

		System.out.println("\n* Introiti calcolati con percentuale di riferimento al 10%:");
		double introiti = a.calcolaIntroiti(10);
		
		System.out.println("\n"+introiti);

		boolean corretto = false;
		
		if(introiti == 70000)
		{
			System.out.println("\nCalcolo introiti gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nCalcolo introiti gestito in maniera errata");
			
		assertEquals("Implementazione del metodo calcolaIntroiti() e/o dei metodi correlati errata", true,corretto);	  
	}
	
}


