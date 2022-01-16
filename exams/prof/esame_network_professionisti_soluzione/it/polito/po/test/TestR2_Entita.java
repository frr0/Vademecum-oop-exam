package it.polito.po.test;
import network_professionisti.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR2_Entita extends TestCase {
  
	public void testNuovaEntitaCentroDiFormazione(){

		System.out.println("\n*** testNuovaEntitaCentroDiFormazione() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definizione di un nuovo centro di formazione");

		Entita e1 = null;
		try {
			e1 = n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			System.out.println(" Nome: "+e1.getNome());
			System.out.println(" Nazione: "+e1.getNazione());
			System.out.println(" Indirizzo: "+e1.getIndirizzo());		
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		boolean corretto = false;
		
		if(e1!=null && (e1 instanceof CentroDiFormazione) && e1.getNome().compareTo("Universita' della malta")==0 && e1.getNazione().compareTo("Italia")==0 && e1.getIndirizzo().compareTo("Strada del cementificio 14, Torino") == 0)
		{
			System.out.println("\nInformazioni relative al nuovo centro di formazione registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative al nuovo centro di formazione");
			
		assertEquals("Implementazione del metodo nuovaEntita() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testNuovaEntitaAzienda(){

		System.out.println("\n*** testNuovaEntitaAzienda() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definizione di una nuova azienda");

		Entita e1 = null;
		try {
			e1 = n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
			System.out.println(" Nome: "+e1.getNome());
			System.out.println(" Nazione: "+e1.getNazione());
			System.out.println(" Indirizzo: "+e1.getIndirizzo());
			if(e1 instanceof Azienda) {
				System.out.println(" Settore: "+((Azienda)e1).getSettore());
				System.out.println(" Num. dipendenti: "+((Azienda)e1).getNumeroDipendenti());
			}
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		boolean corretto = false;
		
		
		if(e1!=null && (e1 instanceof Azienda) && e1.getNome().compareTo("Muri Neri S.n.c.")==0 && e1.getNazione().compareTo("Italia")==0 && e1.getIndirizzo().compareTo("Via delle case 84, Novara") == 0 && ((Azienda)e1).getSettore().compareTo("Costruzioni")==0  && ((Azienda)e1).getNumeroDipendenti()==10)
		{
			System.out.println("\nInformazioni relative alla nuova azienda registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative alla nuova azienda");
			
		assertEquals("Implementazione del metodo nuovaEntita() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	public void testNuovaEntitaAziendaStessoNomeCentroDiFormazione(){

		System.out.println("\n*** testNuovaEntitaAziendaStessoNomeCentroDiFormazione() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definizione di un nuovo centro di formazione");

		Entita e1 = null;
		try {
			e1 = n.nuovaEntita("Constructions Institute", "United States of America", "Bricks Streets, Los Angeles");
			System.out.println(" Nome: "+e1.getNome());
			System.out.println(" Nazione: "+e1.getNazione());
			System.out.println(" Indirizzo: "+e1.getIndirizzo());		
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		System.out.println("\nDefinizione di una nuova azienda con lo stesso nome");

		boolean eccezione = false;
		
		Entita e2 = null;
		try {
			e2 = n.nuovaEntita("Constructions Institute", "United States of America", "Wall Street, New York", "Constructions", 100);
			System.out.println(" Nome: "+e2.getNome());
			System.out.println(" Nazione: "+e2.getNazione());
			System.out.println(" Indirizzo: "+e2.getIndirizzo());
			if(e2 instanceof Azienda) {
				System.out.println(" Settore: "+((Azienda)e2).getSettore());
				System.out.println(" Num. dipendenti: "+((Azienda)e2).getNumeroDipendenti());
			}
			eccezione = false;
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
			eccezione = true;
		}
		
		boolean corretto = false;
		
		if(eccezione == false && 
		   e1!=null && (e1 instanceof CentroDiFormazione) && e1.getNome().compareTo("Constructions Institute")==0 && e1.getNazione().compareTo("United States of America")==0 && e1.getIndirizzo().compareTo("Bricks Streets, Los Angeles") ==0 && 
		   e2!=null && (e2 instanceof Azienda) && e2.getNome().compareTo("Constructions Institute")==0 && e2.getNazione().compareTo("United States of America")==0 && e2.getIndirizzo().compareTo("Wall Street, New York") == 0 && ((Azienda)e2).getSettore().compareTo("Constructions")==0  && ((Azienda)e2).getNumeroDipendenti()==100)
		{
			System.out.println("\nInformazioni relative alle nuove entita' registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative alle nuove entita'");
			
		assertEquals("Implementazione del metodo nuovaEntita() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	public void testNuovaEntitaCentroDiFormazioneDuplicato(){

		System.out.println("\n*** testNuovaEntitaCentroDiFormazioneDuplicato() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definizione di un nuovo centro di formazione");

		Entita e1 = null;
		try {
			e1 = n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			System.out.println(" Nome: "+e1.getNome());
			System.out.println(" Nazione: "+e1.getNazione());
			System.out.println(" Indirizzo: "+e1.getIndirizzo());		
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		System.out.println("\nDefinizione di un nuovo centro di formazione con lo stesso nome");

		boolean eccezione = false;
		
		Entita e2 = null;
		try {
			e2 = n.nuovaEntita("Universita' della malta", "Italia", "Strada del mattone 28, Milano");
			System.out.println(" Nome: "+e2.getNome());
			System.out.println(" Nazione: "+e2.getNazione());
			System.out.println(" Indirizzo: "+e2.getIndirizzo());		
			eccezione = false;
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
			eccezione = true;
		}
		
		boolean corretto = false;
		
		if(eccezione == true)
		{
			System.out.println("\nDefinizione entita' duplocata gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nDefinizione entita' duplocata gestita in maniera errata");
			
		assertEquals("Implementazione del metodo nuovaEntita() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testElencoCentriDiFormazionePerNome(){

		System.out.println("\n*** testElencoCentriDiFormazionePerNome() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definite entita'");

		try {
			n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
			n.nuovaEntita("Constructions Institute", "United States of America", "Bricks Streets, Los Angeles");
			n.nuovaEntita("Scuola di pasticceria", "Italia", "Via della torta 3, Napoli");
			n.nuovaEntita("Universita' dello sport", "Italia", "Piazza della competizione, Roma");
			n.nuovaEntita("Lycee du brique", "France", "Rue du mur 12, Rennes");
			n.nuovaEntita("Torroni S.p.a.", "Italia", "Piazza delle mandorle, Alba", "Pasticceria", 5);
			n.nuovaEntita("Bar del dolce", "Italia", "Strada dei pasticcini 30, Palermo", "Pasticceria", 3);
			
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		System.out.println("\nElenco centri di formazione (ordine alfabetico)");
		LinkedList<CentroDiFormazione> listaEntiFormazione = new LinkedList<CentroDiFormazione>(n.elencoCentriDiFormazionePerNome());
		for(CentroDiFormazione e : listaEntiFormazione) {
			System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
		}

		Entita e1 = listaEntiFormazione.get(0);
		Entita e2 = listaEntiFormazione.get(1);
		Entita e3 = listaEntiFormazione.get(2);
		Entita e4 = listaEntiFormazione.get(3);
		Entita e5 = listaEntiFormazione.get(4);

		
		boolean corretto = false;
		
		if(listaEntiFormazione.size() == 5 &&
		   e1.getNome().compareTo("Constructions Institute")==0 && 
		   e2.getNome().compareTo("Lycee du brique")==0 && 	
		   e3.getNome().compareTo("Scuola di pasticceria")==0 && 	
		   e4.getNome().compareTo("Universita' della malta")==0 && 	
		   e5.getNome().compareTo("Universita' dello sport")==0 )
		{
			System.out.println("\nElenco centri di formazione gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco centri di formazione gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoCentriDiFormazionePerNome() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	public void testElencoCentriDiFormazioneInNazionePerNome(){

		System.out.println("\n*** testElencoCentriDiFormazioneInNazionePerNome() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definite entita'");

		try {
			n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
			n.nuovaEntita("Constructions Institute", "United States of America", "Bricks Streets, Los Angeles");
			n.nuovaEntita("Scuola di pasticceria", "Italia", "Via della torta 3, Napoli");
			n.nuovaEntita("Universita' dello sport", "Italia", "Piazza della competizione, Roma");
			n.nuovaEntita("Lycee du brique", "France", "Rue du mur 12, Rennes");
			n.nuovaEntita("Torroni S.p.a.", "Italia", "Piazza delle mandorle, Alba", "Pasticceria", 5);
			n.nuovaEntita("Bar del dolce", "Italia", "Strada dei pasticcini 30, Palermo", "Pasticceria", 3);
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		System.out.println("\nElenco centri di formazione in 'Italia' (ordine alfabetico)");
		LinkedList<CentroDiFormazione> listaEntiFormazione = new LinkedList<CentroDiFormazione>(n.elencoCentriDiFormazioneInNazionePerNome("Italia"));
		for(CentroDiFormazione e : listaEntiFormazione) {
			System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
		}

		Entita e1 = listaEntiFormazione.get(0);
		Entita e2 = listaEntiFormazione.get(1);
		Entita e3 = listaEntiFormazione.get(2);

		boolean corretto = false;
		
		if(listaEntiFormazione.size()==3 &&
		   e1.getNome().compareTo("Scuola di pasticceria")==0 && 	
		   e2.getNome().compareTo("Universita' della malta")==0 && 	
		   e3.getNome().compareTo("Universita' dello sport")==0 )
		{
			System.out.println("\nElenco centri di formazione in nazione gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco centri di formazione in nazione gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoCentriDiFormazioneInNazionePerNome() e/o dei metodi correlati errata", true,corretto);	  

		System.out.println("\nElenco centri di formazione in 'France' (ordine alfabetico)");
		listaEntiFormazione = new LinkedList<CentroDiFormazione>(n.elencoCentriDiFormazioneInNazionePerNome("France"));
		for(CentroDiFormazione e : listaEntiFormazione) {
			System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
		}

		e1 = listaEntiFormazione.get(0);

		corretto = false;
		
		if(listaEntiFormazione.size()==1 &&
		   e1.getNome().compareTo("Lycee du brique")==0)
		{
			System.out.println("\nElenco centri di formazione in nazione gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco centri di formazione in nazione gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoCentriDiFormazioneInNazionePerNome() e/o dei metodi correlati errata", true,corretto);	  

	}
	
	
	
	public void testElencoAziendePerNome(){

		System.out.println("\n*** testElencoAziendePerNome() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definite entita'");

		try {
			n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
			n.nuovaEntita("Constructions Institute", "United States of America", "Bricks Streets, Los Angeles");
			n.nuovaEntita("Scuola di pasticceria", "Italia", "Via della torta 3, Napoli");
			n.nuovaEntita("Universita' dello sport", "Italia", "Piazza della competizione, Roma");
			n.nuovaEntita("Lycee du brique", "France", "Rue du mur 12, Rennes");
			n.nuovaEntita("Torroni S.p.a.", "Italia", "Piazza delle mandorle, Alba", "Pasticceria", 5);
			n.nuovaEntita("Bar del dolce", "Italia", "Strada dei pasticcini 30, Palermo", "Pasticceria", 3);
			
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		System.out.println("\nElenco aziende (ordine alfabetico)");
		LinkedList<Azienda> listaAziende = new LinkedList<Azienda>(n.elencoAziendePerNome());
		for(Azienda a : listaAziende) {
			System.out.println(" '"+a.getNome()+"' '"+a.getNazione()+"' '"+a.getIndirizzo()+"' "+a.getSettore()+"' '"+a.getNumeroDipendenti()+"'");
		}

		Entita e1 = listaAziende.get(0);
		Entita e2 = listaAziende.get(1);
		Entita e3 = listaAziende.get(2);

		
		boolean corretto = false;
		
		if(listaAziende.size() == 3 &&
		   e1.getNome().compareTo("Bar del dolce")==0 && 
		   e2.getNome().compareTo("Muri Neri S.n.c.")==0 && 	
		   e3.getNome().compareTo("Torroni S.p.a.")==0 )
		{
			System.out.println("\nElenco aziende per nome gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco aziende per nome gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoAziendePerNome() e/o dei metodi correlati errata", true,corretto);	  
		
	}
	
	
	
	public void testElencoAziendePerNumeroDipendenti(){

		System.out.println("\n*** testElencoAziendePerNumeroDipendenti() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definite entita'");

		try {
			n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
			n.nuovaEntita("Constructions Institute", "United States of America", "Bricks Streets, Los Angeles");
			n.nuovaEntita("Scuola di pasticceria", "Italia", "Via della torta 3, Napoli");
			n.nuovaEntita("Universita' dello sport", "Italia", "Piazza della competizione, Roma");
			n.nuovaEntita("Lycee du brique", "France", "Rue du mur 12, Rennes");
			n.nuovaEntita("Torroni S.p.a.", "Italia", "Piazza delle mandorle, Alba", "Pasticceria", 5);
			n.nuovaEntita("Bar del dolce", "Italia", "Strada dei pasticcini 30, Palermo", "Pasticceria", 3);
			
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		System.out.println("\nElenco aziende (numero dipendenti)");
		LinkedList<Azienda> listaAziende = new LinkedList<Azienda>(n.elencoAziendePerNumeroDipendenti());
		for(Azienda a : listaAziende) {
			System.out.println(" '"+a.getNome()+"' '"+a.getNazione()+"' '"+a.getIndirizzo()+"' "+a.getSettore()+"' '"+a.getNumeroDipendenti()+"'");
		}

		Entita e1 = listaAziende.get(0);
		Entita e2 = listaAziende.get(1);
		Entita e3 = listaAziende.get(2);

		
		boolean corretto = false;
		
		if(listaAziende.size() == 3 &&
		   e1.getNome().compareTo("Bar del dolce")==0 && 
		   e2.getNome().compareTo("Torroni S.p.a.")==0 && 	
		   e3.getNome().compareTo("Muri Neri S.n.c.")==0 )
		{
			System.out.println("\nElenco aziende per numero dipendenti gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco aziende per numero dipendenti gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoAziendePerNumeroDipendenti() e/o dei metodi correlati errata", true,corretto);	  
		
	}
	
	
	
	
	public void testElencoEntita(){

		System.out.println("\n*** testElencoEntita() ***\n");
		
		Network n = new Network();
		
		System.out.println("Definite entita'");

		try {
			n.nuovaEntita("Universita' della malta", "Italia", "Strada del cementificio 14, Torino");
			n.nuovaEntita("Muri Neri S.n.c.", "Italia", "Via delle case 84, Novara", "Costruzioni", 10);
			n.nuovaEntita("Constructions Institute", "United States of America", "Bricks Streets, Los Angeles");
			n.nuovaEntita("Scuola di pasticceria", "Italia", "Via della torta 3, Napoli");
			n.nuovaEntita("Universita' dello sport", "Italia", "Piazza della competizione, Roma");
			n.nuovaEntita("Lycee du brique", "France", "Rue du mur 12, Rennes");
			n.nuovaEntita("Torroni S.p.a.", "Italia", "Piazza delle mandorle, Alba", "Pasticceria", 5);
			n.nuovaEntita("Bar del dolce", "Italia", "Strada dei pasticcini 30, Palermo", "Pasticceria", 3);
			n.nuovaEntita("Constructions Institute", "United States of America", "Wall Street, New York", "Constructions", 100);			
		} catch (EccezioneEntitaGiaDefinita e) {
			System.out.println(" Scatenata eccezione di tipo EccezioneEntitaGiaDefinita dal metodo nuovaEntita()");
		}
		
		System.out.println("\nElenco entita' (ordine alfabetico, in caso di omonimie, prima l'azienda)");
		LinkedList<Entita> listaEntita = new LinkedList<Entita>(n.elencoEntita());
		for(Entita e : listaEntita) {
			if(e instanceof Azienda)
				System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"' "+((Azienda)e).getSettore()+"' '"+((Azienda)e).getNumeroDipendenti()+"'");
			else if(e instanceof CentroDiFormazione)
				System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
			
		}

		Entita e1 = listaEntita.get(0);
		Entita e2 = listaEntita.get(1);
		Entita e3 = listaEntita.get(2);
		Entita e4 = listaEntita.get(3);
		Entita e5 = listaEntita.get(4);
		Entita e6 = listaEntita.get(5);
		Entita e7 = listaEntita.get(6);
		Entita e8 = listaEntita.get(7);
		Entita e9 = listaEntita.get(8);

		
		boolean corretto = false;
		
		if(listaEntita.size() == 9 &&
		   e1.getNome().compareTo("Bar del dolce")==0 && 
		   e2.getNome().compareTo("Constructions Institute")==0 && e2 instanceof Azienda && 
		   e3.getNome().compareTo("Constructions Institute")==0 && e3 instanceof CentroDiFormazione && 
		   e4.getNome().compareTo("Lycee du brique")==0 &&		   
		   e5.getNome().compareTo("Muri Neri S.n.c.")==0 &&		   
		   e6.getNome().compareTo("Scuola di pasticceria")==0 &&		   
		   e7.getNome().compareTo("Torroni S.p.a.")==0 &&		   
		   e8.getNome().compareTo("Universita' della malta")==0 &&		   
		   e9.getNome().compareTo("Universita' dello sport")==0 )
		{
			System.out.println("\nElenco entita' gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco entita' gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoEntita() e/o dei metodi correlati errata", true,corretto);	  
		
	}
}
