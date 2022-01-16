package it.polito.po.test;

import supermercato.*;
import junit.framework.TestCase;

import java.io.*;
import java.util.*;

public class TestR4_CaricamentoFile extends TestCase {

	private static String writeFile(String content) throws IOException {          
	    File f = File.createTempFile("off","txt");
	    FileOutputStream fos = new FileOutputStream(f);
	    fos.write(content.getBytes());
	    fos.close();
	    return f.getAbsolutePath();
	}
	
	public void testCaricamentoRigaProdotto() throws ProdottoInesistenteException, CorsiaInesistenteException, IOException{
		
		System.out.println("\n*** R4. testCaricamentoRigaProdotto() ***\n");

		Supermercato s = new Supermercato();
		
		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
		p1.setPrezzoListino(1.9);

		String stringa = "PRODOTTO_NO_FRIGO;BAR1000DIT;Ditalini Barilla 1000g;1000;2.5;0";
	  	
	  	String file = writeFile(stringa);

	  	System.out.println("Caricamento da file");
	  	
	  	s.leggiFile(file);
	  	
	  	List<Prodotto> prodotti = new LinkedList<Prodotto>(s.elencoProdotti());
	  	
		System.out.println("\nElenco dei prodotti catalogati dopo la lettura da file (prezzo decrescente):");
		
		for (Prodotto ptemp : prodotti)
		{
			System.out.println(" "+ptemp.getCodice()+"\t"+ptemp.getNome()+"\t"+ptemp.getVolume()+" cm^3"+"\t"+ptemp.getPrezzoListino()+" euro"+"\t"+" (sconto "+ptemp.getPercentualeSconto()+"%)");
		}

		boolean corretto;

		if(prodotti.get(0).getCodice().compareTo("BAR1000DIT")==0 && prodotti.get(1).getCodice().compareTo("VOI1000FUS")==0 && prodotti.get(0).getNome().compareTo("Ditalini Barilla 1000g")==0 && prodotti.get(0).getVolume()==1000 && prodotti.get(0).getPrezzoListino()==2.5 && prodotti.get(0).getPercentualeSconto()==0 && prodotti.get(0).isDaFrigo()==false)
		{
			corretto = true;
			System.out.println("\nCaricamento da file corretto");
		}
		else{
			System.out.println("\nCaricamento da file errato");
			corretto = false;
		}
		
		assertEquals("Implementazione del metodo leggiFile() e/o dei metodi utilizzati errata", true, corretto);	
	}	
	
	
	public void testCaricamentoRigaEsposizione() throws ProdottoInesistenteException, CorsiaInesistenteException, IOException{
		
		System.out.println("\n*** R4. testCaricamentoRigaEsposizione() ***\n");

		Supermercato s = new Supermercato();
		
		s.aggiungiCorsia("Pasta e riso", 7900);

		Prodotto p1 = s.catalogaProdotto("VOI1000FUS", "Fusilli Voiello 1000g",1000, false);
	    s.esponiProdotto("Pasta e riso", p1, 5);

		Prodotto p2 = s.catalogaProdotto("AGN1000SPA", "Spaghetti Agnesi 500g",400, false);
		String stringa = "ESPOSIZI_PRODOTTO;AGN1000SPA;Pasta e riso;3";
	  	
	  	String file = writeFile(stringa);

	  	System.out.println("Caricamento da file");
	  	
	  	s.leggiFile(file);
	  	
		System.out.println("\nElenco dei codici prodotto esposti nella corsia Pasta e riso (ordine alfabetico):");
		
		List<String> codici = new LinkedList<String>(s.elencoCodiciProdottoPerCorsia("Pasta e riso"));

		for (String ctemp : codici)
		{
			System.out.println(" "+ctemp);
		}
		
		boolean corretto = false;
		
		if(codici.get(0).compareTo("AGN1000SPA")==0 && codici.get(1).compareTo("VOI1000FUS")==0)
			corretto=true;
		else
			corretto=false;
		
		assertEquals("Implementazione del metodo leggiFile() e/o dei metodi utilizzati errata", true, corretto);	
		
		System.out.println("\nPercentuale di occupazione della corsia Pasta e riso:");
		System.out.print(" "+s.calcolaPercentualeDiOccupazione("Pasta e riso"));
		if(s.calcolaPercentualeDiOccupazione("Pasta e riso")==78)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo leggiFile() e/o dei metodi utilizzati errata", 78, s.calcolaPercentualeDiOccupazione("Pasta e riso"));	
			
		System.out.println("\nQuantita' di prodotto VOI1000FUS esposto nella corsia Pasta e riso:");
		System.out.print(" "+s.quantitaProdottoEsposto(p2,"Pasta e riso")+" pezzi");
		if(s.quantitaProdottoEsposto(p2,"Pasta e riso")==3)
			System.out.println(" (corretta)");
		else
			System.out.println(" (errata)");
		assertEquals("Implementazione del metodo leggiFile() e/o dei metodi utilizzati errata", 3,s.quantitaProdottoEsposto(p2,"Pasta e riso"));	
	}	
	
}
