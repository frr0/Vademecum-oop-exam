package it.polito.po.test;

import supermercato.*;
import junit.framework.TestCase;

public class TestR3_AcquistiScontrini extends TestCase {

	public void testApriScontrino(){
		
		System.out.println("\n*** R3. testApriScontrino() ***\n");
		
		Supermercato s = new Supermercato();

		int codice;

		System.out.println("Apertura di uno scontrino");

		codice = s.apriScontrino();
		System.out.print("Codice assegnato: "+codice);
		if(codice==1000)
			System.out.println(" (corretto)");
		else
			System.out.println(" (errato)");
		assertEquals("Implementazione del metodo testApriScontrino() errata", 1000,codice);	

		System.out.println("\nApertura di un'altro scontrino");

		codice = s.apriScontrino();
		System.out.print("Codice assegnato: "+codice);
		if(codice==1001)
			System.out.println(" (corretto)");
		else
			System.out.println(" (errato)");
		assertEquals("Implementazione del metodo testApriScontrino() errata", 1001,codice);	
	}

	
	
	public void testAcquistaProdotto() throws ProdottoInesistenteException, CorsiaInesistenteException{
		
		System.out.println("\n*** R3. testAcquistaProdotto() ***\n");

		Supermercato s = new Supermercato();
		
		s.aggiungiCorsia("Pasta e riso", 7900);
		s.aggiungiCorsia("Offerte", 3000);

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);

		p1.setPrezzoListino(1.9);
		p1.setPercentualeSconto(20);

		p2.setPrezzoListino(0.6);
		
		System.out.println("Esposizione prodotti nelle corsie");

		s.esponiProdotto("Pasta e riso", p1, 5);
		s.esponiProdotto("Pasta e riso", p2, 3);

		System.out.println("\nQuantita' di prodotto VOI1000FUS esposto nella corsia Pasta e riso:");
		System.out.println(" "+s.quantitaProdottoEsposto(p1,"Pasta e riso")+" pezzi");

		System.out.println("\nQuantita' di prodotto AGN1000SPA esposto nella corsia Pasta e riso:");
		System.out.println(" "+s.quantitaProdottoEsposto(p2,"Pasta e riso")+" pezzi");

		System.out.println("\nApertura di uno scontrino");
		s.apriScontrino();

		System.out.println("\nAcquisto prodotti");

		try {
			s.acquistaProdotto(1000, p1, "Pasta e riso", 2);
			s.acquistaProdotto(1000, p2, "Pasta e riso", 10);

		} catch (CorsiaInesistenteException e) {
		}
		
		System.out.println("\nQuantita' di prodotto VOI1000FUS esposto nella corsia Pasta e riso dopo l'acquisto:");
		System.out.print(" "+s.quantitaProdottoEsposto(p1,"Pasta e riso")+" pezzi");
		if(s.quantitaProdottoEsposto(p1,"Pasta e riso")==3)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo acquistaProdotto() e/o dei metodi utilizzati errata", 3,s.quantitaProdottoEsposto(p1,"Pasta e riso"));	
			
		System.out.println("\nQuantita' di prodotto AGN1000SPA esposto nella corsia Pasta e riso dopo l'acquisto:");
		System.out.print(" "+s.quantitaProdottoEsposto(p2,"Pasta e riso")+" pezzi");
		if(s.quantitaProdottoEsposto(p2,"Pasta e riso")==0)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo acquistaProdotto() e/o dei metodi utilizzati errata", 0,s.quantitaProdottoEsposto(p2,"Pasta e riso"));	
	}	
	
	
	public void testDettagliScontrino() throws ProdottoInesistenteException, CorsiaInesistenteException{
		
		System.out.println("\n*** R3. testDettagliScontrino() ***\n");

		Supermercato s = new Supermercato();
		
		s.aggiungiCorsia("Pasta e riso", 7900);
		s.aggiungiCorsia("Offerte", 3000);

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);

		p1.setPrezzoListino(1.9);
		p1.setPercentualeSconto(20);

		p2.setPrezzoListino(0.6);

		s.esponiProdotto("Pasta e riso", p1, 5);
		s.esponiProdotto("Pasta e riso", p2, 3);

		System.out.println("Apertura di uno scontrino");
		s.apriScontrino();

		System.out.println("\nAcquisto prodotti");

		try {
			s.acquistaProdotto(1000, p1, "Pasta e riso", 1);
			s.acquistaProdotto(1000, p2, "Pasta e riso", 2);
		} catch (CorsiaInesistenteException e) {
		}
		
		System.out.println("\nDettagli scontrino:");
		String dettagli = s.dettagliScontrino(1000);
		System.out.println(dettagli);

		boolean formatoCorretto;
		
		if(dettagli.compareTo(" 1000\n AGN1000SPA 2\n VOI1000FUS 1")==0 || dettagli.compareTo("1000\nAGN1000SPA 2\nVOI1000FUS 1")==0 || dettagli.compareTo(" 1000\n VOI1000FUS 1\n AGN1000SPA 2")==0 || dettagli.compareTo("1000\nVOI1000FUS 1\nAGN1000SPA 2")==0)
		{	
			formatoCorretto=true;
			System.out.println("\nDettagli nel formato corretto");
		}
		else
		{	
			formatoCorretto=false;
			System.out.println("\nDettagli nel formato errato");
		}
		
		assertEquals("Implementazione del metodo dettagliScontrino() e/o dei metodi utilizzati errata", true, formatoCorretto);	
	}		
	
	public void testChiudiScontrino() throws ProdottoInesistenteException, CorsiaInesistenteException{
		
		System.out.println("\n*** R3. testChiudiScontrino() ***\n");

		Supermercato s = new Supermercato();
		
		s.aggiungiCorsia("Pasta e riso", 7900);
		s.aggiungiCorsia("Offerte", 3000);

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);

		p1.setPrezzoListino(1.9);
		p1.setPercentualeSconto(10);

		p2.setPrezzoListino(0.6);

		s.esponiProdotto("Pasta e riso", p1, 5);
		s.esponiProdotto("Pasta e riso", p2, 3);

		System.out.println("Apertura di uno scontrino");
		s.apriScontrino();

		System.out.println("\nAcquisto prodotti");
		
		try {
			s.acquistaProdotto(1000, p1, "Pasta e riso", 1);
			s.acquistaProdotto(1000, p2, "Pasta e riso", 2);
		} catch (CorsiaInesistenteException e) {
		}
		
		System.out.println("\nChiusura dello scontrino");

		double importo = s.chiudiScontrino(1000);
		
		System.out.println("\nImporto scontrino:");
		System.out.print(" "+importo);
		if(importo==2.91)
			System.out.println(" (corretto)");
		else
			System.out.println(" (errato)");

		assertEquals("Implementazione del metodo chiudiScontrino() e/o dei metodi utilizzati errata", 2.91, importo);	
	}		
}
