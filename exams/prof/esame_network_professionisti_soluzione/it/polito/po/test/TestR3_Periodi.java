package it.polito.po.test;
import network_professionisti.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR3_Periodi extends TestCase {

	public void testTitoliFormazioneDateCrescenti(){

		System.out.println("\n*** titoliFormazioneDateCrescenti() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritto nuovo utente al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		System.out.println("\nDefiniti centri di formazione");

		try {
			n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			n.nuovaEntita("Accademia della costruzioni", "Italia", "Piazza delle strutture, Catania");
			n.nuovaEntita("Lycee du brique", "France", "Rue du mur 12, Rennes");
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}		
		
		System.out.println("\nElenco centri di formazione (ordine alfabetico)");
		LinkedList<CentroDiFormazione> listaEntiFormazione = new LinkedList<CentroDiFormazione>(n.elencoCentriDiFormazionePerNome());
		for(CentroDiFormazione e : listaEntiFormazione) {
			System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
		}

		System.out.println("\nDefinita formazione per l'iscritto con identificativo '"+i1.getId()+"'");

		n.nuovoPeriodoDiFormazione(i1.getId(), "Universita' della malta", "19891010", "19840301", "Diploma di Perito del cemento");
		n.nuovoPeriodoDiFormazione(i1.getId(), "Accademia della costruzioni", "20000101", "20011204", "Specializzazione in Costruzioni estreme");
		n.nuovoPeriodoDiFormazione(i1.getId(), "Lycee du brique", "19850911", "19890702", "Diplome de Maitre macon");

		System.out.println("\nFormazione per l'iscritto con identificativo '"+i1.getId()+"' (date decrescenti)");

		String stringaTitoliFormazione = n.titoliFormazioneDateCrescenti(i1.getId());
		System.out.println(stringaTitoliFormazione);
		
		
		boolean corretto = false;
		
		if(stringaTitoliFormazione.compareTo("Lycee du brique;19850911;19890702;Diplome de Maitre macon\nUniversita' della malta;19891010;19840301;Diploma di Perito del cemento\nAccademia della costruzioni;20000101;20011204;Specializzazione in Costruzioni estreme")==0 || 
		   stringaTitoliFormazione.compareTo(" Lycee du brique;19850911;19890702;Diplome de Maitre macon\n Universita' della malta;19891010;19840301;Diploma di Perito del cemento\n Accademia della costruzioni;20000101;20011204;Specializzazione in Costruzioni estreme")==0				)
		{
			System.out.println("\nFormazione descritta in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nFormazione descritta in maniera errata");
			
		assertEquals("Implementazione del metodo titoliFormazioneDateCrescenti() e/o dei metodi correlati errata", true,corretto);	  
		
		
	}
	
	public void testTitoliFormazioneDateDecrescenti(){

		System.out.println("\n*** testTitoliFormazioneDateDecrescenti() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritto nuovo utente al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		System.out.println("\nDefiniti centri di formazione");

		try {
			n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			n.nuovaEntita("Accademia della costruzioni", "Italia", "Piazza delle strutture, Catania");
			n.nuovaEntita("Lycee du brique", "France", "Rue du mur 12, Rennes");
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}		
		
		System.out.println("\nElenco centri di formazione (ordine alfabetico)");
		LinkedList<CentroDiFormazione> listaEntiFormazione = new LinkedList<CentroDiFormazione>(n.elencoCentriDiFormazionePerNome());
		for(CentroDiFormazione e : listaEntiFormazione) {
			System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
		}

		System.out.println("\nDefinita formazione per l'iscritto con identificativo '"+i1.getId()+"'");

		n.nuovoPeriodoDiFormazione(i1.getId(), "Universita' della malta", "19891010", "19840301", "Diploma di Perito del cemento");
		n.nuovoPeriodoDiFormazione(i1.getId(), "Accademia della costruzioni", "20000101", "20011204", "Specializzazione in Costruzioni estreme");
		n.nuovoPeriodoDiFormazione(i1.getId(), "Lycee du brique", "19850911", "19890702", "Diplome de Maitre macon");

		System.out.println("\nFormazione per l'iscritto con identificativo '"+i1.getId()+"' (date dedecrescenti)");

		String stringaTitoliFormazione = n.titoliFormazioneDateDecrescenti(i1.getId());
		System.out.println(stringaTitoliFormazione);
		
		
		boolean corretto = false;
		
		if(stringaTitoliFormazione.compareTo("Accademia della costruzioni;20000101;20011204;Specializzazione in Costruzioni estreme\nUniversita' della malta;19891010;19840301;Diploma di Perito del cemento\nLycee du brique;19850911;19890702;Diplome de Maitre macon") ==0 ||
		   stringaTitoliFormazione.compareTo(" Accademia della costruzioni;20000101;20011204;Specializzazione in Costruzioni estreme\n Universita' della malta;19891010;19840301;Diploma di Perito del cemento\n Lycee du brique;19850911;19890702;Diplome de Maitre macon") ==0 )
		{
			System.out.println("\nFormazione descritta in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nFormazione descritta in maniera errata");
			
		assertEquals("Implementazione del metodo titoliFormazioneDateDecrescenti() e/o dei metodi correlati errata", true,corretto);	  
		
		
	}
	
	
	
	public void testRuoliAziendaDateCrescenti(){

		System.out.println("\n*** testRuoliAziendaDateCrescenti() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritto nuovo utente al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		System.out.println("\nDefinite aziende");

		try {

			n.nuovaEntita("Constructions Institute", "United States of America", "Wall Street, New York", "Constructions", 100);
			n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}		
		
		System.out.println("\nElenco aziende (ordine alfabetico)");
		LinkedList<Azienda> listaAziende = new LinkedList<Azienda>(n.elencoAziendePerNome());
		for(Azienda a : listaAziende) {
			System.out.println(" '"+a.getNome()+"' '"+a.getNazione()+"' '"+a.getIndirizzo()+"' "+a.getSettore()+"' '"+a.getNumeroDipendenti()+"'");
		}
			
		System.out.println("\nDefiniti ruoli in azienda per l'iscritto con identificativo '"+i1.getId()+"'");

		n.nuovoPeriodoInAzienda(i1.getId(), "Constructions Institute", "20020910", "20040315", "Dipendente");
		n.nuovoPeriodoInAzienda(i1.getId(), "Muri Neri S.n.c.", "20040316", "20190214", "Amministratore delegato");

		System.out.println("\nRuoli in azienda per l'iscritto con identificativo '"+i1.getId()+"' (date crescenti)");

		String stringaRuoliAzienda = n.ruoliAziendaDateCrescenti(i1.getId());
		System.out.println(stringaRuoliAzienda);
		
		boolean corretto = false;
		
		if(stringaRuoliAzienda.compareTo("Constructions Institute;20020910;20040315;Dipendente\nMuri Neri S.n.c.;20040316;20190214;Amministratore delegato")==0 || 
		   stringaRuoliAzienda.compareTo(" Constructions Institute;20020910;20040315;Dipendente\n Muri Neri S.n.c.;20040316;20190214;Amministratore delegato")==0				)
		{
			System.out.println("\nRuoli in azienda descritti in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRuoli in azienda descritti in maniera errata");
			
		assertEquals("Implementazione del metodo ruoliAziendaDateCrescenti() e/o dei metodi correlati errata", true,corretto);	  
		
		
	}
	
	public void testRuoliAziendaDateDecrescenti(){

		System.out.println("\n*** testRuoliAziendaDateDecrescenti() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritto nuovo utente al network");
		
		Iscritto i1 = n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		System.out.println("\nDefinite aziende");

		try {

			n.nuovaEntita("Constructions Institute", "United States of America", "Wall Street, New York", "Constructions", 100);
			n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}		
		
		System.out.println("\nElenco aziende (ordine alfabetico)");
		LinkedList<Azienda> listaAziende = new LinkedList<Azienda>(n.elencoAziendePerNome());
		for(Azienda a : listaAziende) {
			System.out.println(" '"+a.getNome()+"' '"+a.getNazione()+"' '"+a.getIndirizzo()+"' "+a.getSettore()+"' '"+a.getNumeroDipendenti()+"'");
		}
			
		System.out.println("\nDefiniti ruoli in azienda per l'iscritto con identificativo '"+i1.getId()+"'");

		n.nuovoPeriodoInAzienda(i1.getId(), "Constructions Institute", "20020910", "20040315", "Dipendente");
		n.nuovoPeriodoInAzienda(i1.getId(), "Muri Neri S.n.c.", "20040316", "20190214", "Amministratore delegato");

		System.out.println("\nRuoli in azienda per l'iscritto con identificativo '"+i1.getId()+"' (date decrescenti)");

		String stringaRuoliAzienda = n.ruoliAziendaDateDecrescenti(i1.getId());
		System.out.println(stringaRuoliAzienda);
		
		boolean corretto = false;
		
		if(stringaRuoliAzienda.compareTo("Muri Neri S.n.c.;20040316;20190214;Amministratore delegato\nConstructions Institute;20020910;20040315;Dipendente")==0 || 
		   stringaRuoliAzienda.compareTo(" Muri Neri S.n.c.;20040316;20190214;Amministratore delegato\n Constructions Institute;20020910;20040315;Dipendente")==0				)
		{
			System.out.println("\nRuoli in azienda descritti in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRuoli in azienda descritti in maniera errata");
			
		assertEquals("Implementazione del metodo ruoliAziendaDateDecrescenti() e/o dei metodi correlati errata", true,corretto);	  
		
		
	}
}

