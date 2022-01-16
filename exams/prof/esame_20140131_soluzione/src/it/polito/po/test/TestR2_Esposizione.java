package it.polito.po.test;

import supermercato.*;
import junit.framework.TestCase;
import java.util.*;

public class TestR2_Esposizione extends TestCase {

	public void testCalcolaPercentualeOccupazione(){
		
		System.out.println("\n*** R2. testCalcolaPercentualeOccupazione() ***\n");

		Supermercato s = new Supermercato();
		
		System.out.println("Definizione corsie");
		
		s.aggiungiCorsia("Pasta e riso", 7900);
		s.aggiungiCorsia("Offerte", 3000);
		s.aggiungiCorsia("Sughi", 3000);

		System.out.println("\nCatalogazione prodotti");
		
		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);
		Prodotto p3 = s.catalogaProdotto("BUI0000PES", "Pesto Buitoni 125g",250, true);
		Prodotto p4 = s.catalogaProdotto("STA0010SUG", "Sugo pronto Star 100g",100, false);

		System.out.println("\nEsposizione prodotti nelle corsie");

		s.esponiProdotto("Pasta e riso", p1, 10);
		s.esponiProdotto("Pasta e riso", p2, 25);
		s.esponiProdotto("Offerte", p1, 50);
		s.esponiProdotto("Sughi", p3, 2);
		s.esponiProdotto("Sughi", p4, 5);

		System.out.println("\nPercentuale di occupazione della corsia Pasta e riso:");
		System.out.print(" "+s.calcolaPercentualeDiOccupazione("Pasta e riso"));
		if(s.calcolaPercentualeDiOccupazione("Pasta e riso")==98)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo testCalcolaPercentualeOccupazione() o dei metodi utilizzati errata", 98,s.calcolaPercentualeDiOccupazione("Pasta e riso"));	
		
		System.out.println("\nPercentuale di occupazione della corsia Offerte:");
		System.out.print(" "+s.calcolaPercentualeDiOccupazione("Offerte"));
		if(s.calcolaPercentualeDiOccupazione("Offerte")==100)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo testCalcolaPercentualeOccupazione() o dei metodi utilizzati errata", 100,s.calcolaPercentualeDiOccupazione("Offerte"));	

		System.out.println("\nPercentuale di occupazione della corsia Sughi:");
		System.out.print(" "+s.calcolaPercentualeDiOccupazione("Sughi"));
		if(s.calcolaPercentualeDiOccupazione("Sughi")==33)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo testCalcolaPercentualeOccupazione() o dei metodi utilizzati errata", 33,s.calcolaPercentualeDiOccupazione("Sughi"));	
	}
	
	
	public void testElencoCodiciProdottoPerCorsia(){
		
		System.out.println("\n*** R2. testElencoCodiciProdottoPerCorsia() ***\n");

		Supermercato s = new Supermercato();
		
		s.aggiungiCorsia("Pasta e riso", 7900);
		s.aggiungiCorsia("Offerte", 3000);

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);
		Prodotto p3 = s.catalogaProdotto("BAR0500PIP", "Pipe rigate Barilla 500g",500, false);
		Prodotto p4 = s.catalogaProdotto("BAR0500FAR", "Farfalle Barilla 500g",500, false);

		System.out.println("Esposizione prodotti nelle corsie");

		s.esponiProdotto("Pasta e riso", p1, 5);
		s.esponiProdotto("Pasta e riso", p2, 3);
		s.esponiProdotto("Pasta e riso", p3, 5);
		s.esponiProdotto("Pasta e riso", p4, 10);
		s.esponiProdotto("Offerte", p1, 50);

		System.out.println("\nElenco dei codici prodotto esposti nella corsia Pasta e riso (ordine alfabetico):");
		
		List<String> codici = new LinkedList<String>(s.elencoCodiciProdottoPerCorsia("Pasta e riso"));

		for (String ctemp : codici)
		{
			System.out.println(" "+ctemp);
		}

		boolean ordinamentoCorretto;
		
		if(codici.get(0).compareTo("AGN1000SPA")==0  && codici.get(1).compareTo("BAR0500PIP")==0 && codici.get(2).compareTo("VOI1000FUS")==0)
		{
			ordinamentoCorretto = true;
			System.out.println("\nOrdinamento corretto");
		}
		else{
			ordinamentoCorretto = false;
			System.out.println("\nOrdinamento errato");
		}
			
		assertEquals("Implementazione del metodo elencoCodiciProdottoPerCorsia() e/o dei metodi utilizzati errata", true,ordinamentoCorretto);	
		
	}	
	
	public void testQuantitaProdottoEspostaCorsieSpecifiche(){
		
		System.out.println("\n*** R2. testQuantitaProdottoEspostaCorsiaSpecifica() ***\n");

		Supermercato s = new Supermercato();
		
		s.aggiungiCorsia("Pasta e riso", 7900);
		s.aggiungiCorsia("Offerte", 3000);

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);
		Prodotto p3 = s.catalogaProdotto("BAR0500PIP", "Pipe rigate Barilla 500g",500, false);
		Prodotto p4 = s.catalogaProdotto("BAR0500FAR", "Farfalle Barilla 500g",500, false);

		System.out.println("Esposizione prodotti nelle corsie");

		s.esponiProdotto("Pasta e riso", p1, 5);
		s.esponiProdotto("Pasta e riso", p2, 3);
		s.esponiProdotto("Pasta e riso", p3, 5);
		s.esponiProdotto("Pasta e riso", p4, 10);
		s.esponiProdotto("Offerte", p1, 50);

		System.out.println("\nQuantita' di prodotto VOI1000FUS esposto nella corsia Pasta e riso:");
		System.out.print(" "+s.quantitaProdottoEsposto(p1,"Pasta e riso")+" pezzi");
		if(s.quantitaProdottoEsposto(p1,"Pasta e riso")==5)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo quantitaProdottoEsposto() e/o dei metodi utilizzati errata", 5,s.quantitaProdottoEsposto(p1,"Pasta e riso"));	
			
		System.out.println("\nQuantita' di prodotto BAR0500PIP esposto nella corsia Pasta e riso:");
		System.out.print(" "+s.quantitaProdottoEsposto(p3,"Pasta e riso")+" pezzi");
		if(s.quantitaProdottoEsposto(p3,"Pasta e riso")==3)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo quantitaProdottoEsposto() e/o dei metodi utilizzati errata", 3,s.quantitaProdottoEsposto(p3,"Pasta e riso"));	
		
		System.out.println("\nQuantita' di prodotto VOI1000FUS esposto nella corsia Offerte:");
		System.out.print(" "+s.quantitaProdottoEsposto(p1,"Offerte")+" pezzi");
		if(s.quantitaProdottoEsposto(p1,"Offerte")==3)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo quantitaProdottoEsposto() e/o dei metodi utilizzati errata", 3,s.quantitaProdottoEsposto(p1,"Offerte"));	
		
	}	
	
	public void testQuantitaProdottoEspostaInteroSupermercato(){
		
		System.out.println("\n*** R2. testQuantitaProdottoEspostaInteroSupermercato() ***\n");

		Supermercato s = new Supermercato();
		
		s.aggiungiCorsia("Pasta e riso", 7900);
		s.aggiungiCorsia("Offerte", 3000);

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);
		Prodotto p3 = s.catalogaProdotto("BAR0500PIP", "Pipe rigate Barilla 500g",500, false);
		Prodotto p4 = s.catalogaProdotto("BAR0500FAR", "Farfalle Barilla 500g",500, false);

		System.out.println("Esposizione prodotti nelle corsie");

		s.esponiProdotto("Pasta e riso", p1, 5);
		s.esponiProdotto("Pasta e riso", p2, 3);
		s.esponiProdotto("Pasta e riso", p3, 5);
		s.esponiProdotto("Pasta e riso", p4, 10);
		s.esponiProdotto("Offerte", p1, 50);

		System.out.println("\nQuantita' di prodotto VOI1000FUS esposto nell'intero supermercato:");
		System.out.print(" "+s.quantitaProdottoEsposto(p1)+" pezzi");
		if(s.quantitaProdottoEsposto(p1)==8)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo quantitaProdottoEsposto() e/o dei metodi utilizzati errata", 8,s.quantitaProdottoEsposto(p1));	
			
	}		
}
