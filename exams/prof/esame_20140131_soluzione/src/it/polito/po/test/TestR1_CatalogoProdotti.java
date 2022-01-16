package it.polito.po.test;

import supermercato.*;
import junit.framework.TestCase;
import java.util.*;

public class TestR1_CatalogoProdotti extends TestCase {

	public void testCatalogaProdotto(){
		
		System.out.println("\n*** R1. testCatalogaProdotto() ***\n");

		Supermercato s = new Supermercato();

		System.out.println("Catalogazione prodotto\n");
		
		System.out.println("Prodotto da catalogare");
		System.out.println(" Codice: VOI1000FUS");
		System.out.println(" Nome: Fusilli Voiello 1000g");
		System.out.println(" Volume: 1000");

		Prodotto p = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);

		System.out.println("\nProdotto catalogato");

		System.out.println(" Codice: "+p.getCodice());
		assertEquals("Implementazione del metodo catalogaProdotto() e/o del metodo getCodice() errata", "VOI1000FUS",p.getCodice());	

		System.out.println(" Nome: "+p.getNome());
		assertEquals("Implementazione del metodo catalogaProdotto() e/o del metodo getNome() errata", "Fusilli Voiello 1000g",p.getNome());	

		System.out.println(" Volume: "+p.getVolume());
		assertEquals("Implementazione del metodo catalogaProdotto() e/o del metodo getVolume() errata", 1000,p.getVolume());	
	}

	
	public void testCatalogaProdottoDaFrigo(){
		
		System.out.println("\n*** R1. testCatalogaProdottoDaFrigo() ***\n");

		Supermercato s = new Supermercato();

		System.out.println("Catalogazione prodotto da frigo");
		
		Prodotto p = s.catalogaProdotto("BUI0000PES", "Pesto Buitoni 125g",250, true);

		boolean classeCorretta;
		if(p instanceof ProdottoDaFrigo){
			classeCorretta = true;
			System.out.println("Prodotto catalogato in maniera corretta");
		}
		else{
			System.out.println("Prodotto catalogato in maniera errata");
			classeCorretta = false;
		}
		assertEquals("Implementazione del metodo catalogaProdotto() errata", true,classeCorretta);	
	}
	
	
	public void testMetodiGetterSetterDiProdotto(){
		
		System.out.println("\n*** R1. testMetodiGetterSetterDiProdotto() ***\n");

		Supermercato s = new Supermercato();

		System.out.println("Catalogazione prodotto");

		Prodotto p = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);

		System.out.println("\nImpostazione prezzo di listino (0.8) e percentuale di sconto (10)");

		p.setPrezzoListino(0.8);
		p.setPercentualeSconto(10);

		System.out.println(" Prezzo impostato: "+p.getPrezzoListino());
		System.out.println(" Percentuale di sconto impostata: "+p.getPercentualeSconto());

		assertEquals("Implementazione del metodo catalogaProdotto() e/o del metodo getPrezzoListino() errata", 0.8,p.getPrezzoListino());	
		
		assertEquals("Implementazione del metodo catalogaProdotto() e/o del metodo getPercentualeSconto() errata", 10,p.getPercentualeSconto());	
	}
	

	public void testIsDaFrigo(){
		
		System.out.println("\n*** R1. testIsDaFrigo() ***\n");

		Supermercato s = new Supermercato();

		Prodotto p;

		System.out.println("Catalogazione prodotto");
		
		p = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		
		if(p.isDaFrigo()==false)
			System.out.println("Prodotto catalogato in maniera corretta");
		else
			System.out.println("Prodotto catalogato in maniera errata");
			
		assertEquals("Implementazione del metodo catalogaProdotto() e/o del metodo isDaFrigo() errata", false,p.isDaFrigo());	

		System.out.println("\nCatalogazione prodotto da frigo");
		
		p = s.catalogaProdotto("BUI0000PES", "Pesto Buitoni 125g",250, true);

		if(p.isDaFrigo()==true)
			System.out.println("Prodotto catalogato in maniera corretta");
		else
			System.out.println("Prodotto catalogato in maniera errata");
		
		assertEquals("Implementazione del metodo catalogaProdotto() e/o del metodo isDaFrigo() errata", true,p.isDaFrigo());	
	}
	
	
	public void testCatalogaStessoProdotto(){
		
		System.out.println("\n*** R1. testCatalogaStessoProdotto() ***\n");

		Supermercato s = new Supermercato();

		System.out.println("Catalogazione prodotto");
		
		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		p1.setPrezzoListino(0.8);
		p1.setPercentualeSconto(10);

		System.out.println("\nCatalogazione stesso prodotto");
		
		Prodotto p2 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);

		boolean uguali;
		
		if(p1==p2){
			uguali=true;
			System.out.println("\nCatalogazione stesso prodotto gestita in maniera corretta");
		}
		else{
			uguali=false;
			System.out.println("\nCatalogazione stesso prodotto gestita in maniera errata");
		}
		
		assertEquals("Implementazione del metodo catalogaProdotto() errata", true, uguali);	
	}
	
	
	public void testElencoProdotti(){
		
		System.out.println("\n*** R1. testElencoProdotti() ***\n");

		Supermercato s = new Supermercato();

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);
		Prodotto p3 = s.catalogaProdotto("BUI0000PES", "Pesto Buitoni 125g",250, true);
		Prodotto p4 = s.catalogaProdotto("STA0010SUG", "Sugo pronto Star 100g",100, false);

		System.out.println("Catalogazione prodotti");

		p1.setPrezzoListino(1.9);
		p2.setPrezzoListino(0.6);
		p3.setPrezzoListino(0.9);
		p4.setPrezzoListino(1.5);

		System.out.println("\nElenco dei prodotti catalogati (prezzo decrescente):");
		
		List<Prodotto> prodotti = new LinkedList<Prodotto>(s.elencoProdotti());
		for (Prodotto ptemp : prodotti)
		{
			System.out.println(" "+ptemp.getCodice()+"\t"+ptemp.getNome()+"\t"+ptemp.getVolume()+" cm^3"+"\t"+ptemp.getPrezzoListino()+" euro");
		}
		
		boolean ordinamentoCorretto;
		
		if(prodotti.get(0).getCodice().compareTo("VOI1000FUS")==0  && prodotti.get(1).getCodice().compareTo("STA0010SUG")==0 && prodotti.get(2).getCodice().compareTo("BUI0000PES")==0 && prodotti.get(3).getCodice().compareTo("AGN1000SPA")==0)
		{
			ordinamentoCorretto = true;
			System.out.println("\nOrdinamento corretto");
		}
		else{
			ordinamentoCorretto = false;
			System.out.println("\nOrdinamento errato");
		}
			
		assertEquals("Implementazione del metodo elencoProdotti() e/o del metodo catalogaProdotto() errata", true,ordinamentoCorretto);	
	}

	
	public void testCercaProdotto() {
		
		System.out.println("\n*** R1. testCercaProdotto() ***\n");

		Supermercato s = new Supermercato();

		System.out.println("Catalogazione prodotto VOI1000FUS");
		
		Prodotto p = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);

		boolean trovato;
		boolean eccezione;
		Prodotto prodottoCercato;
		
		eccezione = false;
		prodottoCercato = null;
		
		System.out.println("\nRicerca prodotto VOI1000FUS");
		
		try{
			prodottoCercato = s.cercaProdotto("VOI1000FUS");
		}
		catch(ProdottoInesistenteException e)
		{
			eccezione = true;
		}
		
		if(prodottoCercato!= null && prodottoCercato==p)
		{	
			System.out.println("Prodotto trovato");
			trovato=true;
		}
		else{
			System.out.println("Prodotto non trovato");
			trovato=false;
		}
			
		assertEquals("Implementazione del metodo cercaProdotto() errata", true,trovato);	

		assertEquals("Implementazione del metodo cercaProdotto() errata", false,eccezione);	
		
		eccezione = false;
		prodottoCercato = null;

		System.out.println("\nRicerca prodotto BUI0000PES");
		
		try{
			prodottoCercato = s.cercaProdotto("BUI0000PES");
		}
		catch(ProdottoInesistenteException e)
		{
			eccezione = true;
		}
		
		if(prodottoCercato!=null)
		{	
			System.out.println("Prodotto trovato");
			trovato=true;
		}
		else{
			System.out.println("Prodotto non trovato");
			trovato=false;
		}
		
		assertEquals("Implementazione del metodo cercaProdotto() errata", false,trovato);	
		
		assertEquals("Implementazione del metodo cercaProdotto() errata", true,eccezione);	
	}
}
