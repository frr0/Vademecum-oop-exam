package it.polito.po.test;
import polichef.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR2_Piatti extends TestCase {

	  public void testRegistraPiattoConcorrente(){

			System.out.println("\n*** testRegistraPiattoConcorrente() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			
			System.out.println("Iscritto primo concorrente");

			System.out.println(" "+c1.getNome()+" "+c1.getCognome()+" (professione "+c1.getProfessione()+")");
			
			System.out.println("\nIdentificativo assegnato");
			String idc1 = c1.getId();
			System.out.println(" "+idc1);

			Concorrente c2 = t.iscriviConcorrente("Giuseppe", "Grigi", "Commercialista");

			System.out.println("\nIscritto secondo concorrente");

			System.out.println(" "+c2.getNome()+" "+c2.getCognome()+" (professione "+c2.getProfessione()+")");

			System.out.println("\nIdentificativo assegnato:");
			String idc2 = c2.getId();
			System.out.println(" "+idc2);

			System.out.println("\nRegistrazione piatto primo concorrente");
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			
			System.out.println("\nIdentificativo assegnato");
			System.out.println(" "+idp1);
			
			boolean corretto = false;
			
			if(idp1 == 100)
			{
				System.out.println("\nAssegnazione identificativo piatto gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nAssegnazione identificativo piatto gestita in maniera errata");
				
			assertEquals("Implementazione del metodo registraPiattoConcorrente() e/o dei metodi correlati errata", true,corretto);	  
	
			
			System.out.println("\nRegistrazione altro piatto primo concorrente");
			int idp2 = t.registraPiattoConcorrente("Pollo al rosmarino", idc1);
			
			System.out.println("\nIdentificativo assegnato");
			System.out.println(" "+idp2);
			
			corretto = false;
			
			if(idp2 == 101)
			{
				System.out.println("\nAssegnazione identificativo piatto gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nAssegnazione identificativo piatto gestita in maniera errata");
				
			assertEquals("Implementazione del metodo registraPiattoConcorrente() e/o dei metodi correlati errata", true,corretto);	  
			
		  
			System.out.println("\nRegistrazione piatto secondo concorrente");
			int idp3 = t.registraPiattoConcorrente("Pollo al rosmarino", idc2);
			
			System.out.println("\nIdentificativo assegnato");
			System.out.println(" "+idp3);
			
			corretto = false;
			
			if(idp3 == 102)
			{
				System.out.println("\nAssegnazione identificativo piatto gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nAssegnazione identificativo piatto gestita in maniera errata");
				
			assertEquals("Implementazione del metodo registraPiattoConcorrente() e/o dei metodi correlati errata", true,corretto);	  
	  }
	  
	  
	  public void testCercaPiatto(){

			System.out.println("\n*** testCercaPiatto() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			
			System.out.println("Iscritto concorrente");

			System.out.println(" "+c1.getNome()+" "+c1.getCognome()+" (professione "+c1.getProfessione()+")");
			
			System.out.println("\nIdentificativo assegnato");
			String idc1 = c1.getId();
			System.out.println(" "+idc1);

			System.out.println("\nRegistrazione piatto concorrente");
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			
			System.out.println("\nIdentificativo assegnato");
			System.out.println(" "+idp1);
			
			System.out.println("\nRicerca piatto");
			Piatto p = t.cercaPiatto(idp1);
			
			System.out.println(" "+p.getIdPiatto()+" "+p.getNome()+" (concorrente "+p.getIdConcorrente()+")");

			boolean corretto = false;
			
			if(p.getIdPiatto()==idp1 && p.getNome().compareTo("Vitello tonnato")==0 && p.getIdConcorrente().compareTo("Alberto N.")==0)
			{
				System.out.println("\nRicerca piatto gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nRicerca piatto gestita in maniera errata");
				
			assertEquals("Implementazione del metodo cercaPiatto() e/o dei metodi correlati errata", true,corretto);	  
	  }
	 
	  
	  public void testCercaPiattoInesistente(){

			System.out.println("\n*** testCercaPiattoInesistente() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			
			System.out.println("Iscritto concorrente");

			System.out.println(" "+c1.getNome()+" "+c1.getCognome()+" (professione "+c1.getProfessione()+")");
			
			System.out.println("\nIdentificativo assegnato");
			String idc1 = c1.getId();
			System.out.println(" "+idc1);

			System.out.println("\nRegistrazione piatto utilizzando identificativo concorrente inesistente");
			int idp1 = t.registraPiattoConcorrente("Piatto inesistente", "Concorrente I.");
			
			System.out.println("\nIdentificativo assegnato");
			System.out.println(" "+idp1);
			
			System.out.println("\nRicerca piatto");
			Piatto p = t.cercaPiatto(idp1);
			
			boolean corretto = false;
			
			if(p==null)
			{
				System.out.println("\nRicerca piatto gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nRicerca piatto gestita in maniera errata");
			
			assertEquals("Implementazione del metodo cercaPiatto() e/o dei metodi correlati errata", true,corretto);	  
	  }  
	  
	  
	  public void testAggiungiIngredientePiatto(){

			System.out.println("\n*** testAggiungiIngredientePiatto() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			
			String idc1 = c1.getId();

			System.out.println("Registrazione piatto concorrente");
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			
			System.out.println("\nAggiunta ingredienti al piatto");

			boolean corretto = false;

			try{
				t.aggiungiIngredientePiatto(idp1, "Vitello");
				t.aggiungiIngredientePiatto(idp1, "Salsa tonnata");
				corretto = true;
			}
			catch(EccezioneIngredienteDuplicato eid) {
				System.out.println("\nIndividuato ingrediente duplicato");
				corretto = false;
			}
			
			if(corretto)
				System.out.println("\nAggiunta ingredienti al piatto gestita in maniera corretta");
			else
				System.out.println("\nAggiunta ingredienti al piatto gestita in maniera errata");
			
			assertEquals("Implementazione del metodo aggiungiIngredientePiatto() e/o dei metodi correlati errata", true,corretto);	  
	  }    
	  
	  
	  public void testAggiungiIngredienteDuplicatoPiatto(){

			System.out.println("\n*** testAggiungiIngredienteDuplicatoPiatto() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			
			String idc1 = c1.getId();

			System.out.println("Registrazione piatto concorrente");
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			
			System.out.println("\nAggiunta ingredienti al piatto (ingrediente duplicato)");

			boolean corretto = false;

			try{
				t.aggiungiIngredientePiatto(idp1, "Vitello");
				t.aggiungiIngredientePiatto(idp1, "Salsa tonnata");
				t.aggiungiIngredientePiatto(idp1, "Vitello");
				corretto = false;
			}
			catch(EccezioneIngredienteDuplicato eid) {
				System.out.println("\nIndividuato ingrediente duplicato");
				corretto = true;
			}
			
			if(corretto)
				System.out.println("\nAggiunta ingredienti al piatto gestita in maniera corretta");
			else
				System.out.println("\nAggiunta ingredienti al piatto gestita in maniera errata");
			
			assertEquals("Implementazione del metodo aggiungiIngredientePiatto() e/o dei metodi correlati errata", true,corretto);	  
	  }    
	  
	  
	  public void testElencoPiattiPerNome(){

			System.out.println("\n*** testElencoPiattiPerNome() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			String idc1 = c1.getId();

			Concorrente c2 = t.iscriviConcorrente("Giuseppe", "Grigi", "Commercialista");
			String idc2 = c2.getId();
			
			System.out.println("Registrazione piatti concorrenti (con aggiunta ingredienti)");
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			int idp2 = t.registraPiattoConcorrente("Tiramisu", idc1);
			int idp3 = t.registraPiattoConcorrente("Pollo al rosmarino", idc2);
			int idp4 = t.registraPiattoConcorrente("Budino", idc2);

			try{
				t.aggiungiIngredientePiatto(idp1, "Vitello");
				t.aggiungiIngredientePiatto(idp1, "Salsa tonnata");
				t.aggiungiIngredientePiatto(idp2, "Uova");
				t.aggiungiIngredientePiatto(idp2, "Pavisini");
				t.aggiungiIngredientePiatto(idp2, "Caffe");
				t.aggiungiIngredientePiatto(idp2, "Mascarpone");
				t.aggiungiIngredientePiatto(idp3, "Pollo");
				t.aggiungiIngredientePiatto(idp3, "Aglio");
				t.aggiungiIngredientePiatto(idp3, "Rosmarino");
				t.aggiungiIngredientePiatto(idp4, "Latte");
			}
			catch(EccezioneIngredienteDuplicato eid) {
				System.out.println("\nIndividuato ingrediente duplicato");
			}
			
			System.out.println("\nElenco piatti (ordine alfabetico per nome)");
			LinkedList<Piatto> listaPiatti = new LinkedList<Piatto>(t.elencoPiattiPerNome());
			for(Piatto ptemp : listaPiatti)
				System.out.println(" "+ptemp.getIdPiatto()+" "+ptemp.getNome()+" (concorrente "+ptemp.getIdConcorrente()+")");

			Piatto p1 = listaPiatti.get(0);
			Piatto p2 = listaPiatti.get(1);
			Piatto p3 = listaPiatti.get(2);
			Piatto p4 = listaPiatti.get(3);
			
			boolean  corretto = false;
			
			if(p1.getNome().compareTo("Budino")==0 && 
			   p2.getNome().compareTo("Pollo al rosmarino")==0 && 	
			   p3.getNome().compareTo("Tiramisu")==0 &&
			   p4.getNome().compareTo("Vitello tonnato")==0 ) {
				System.out.println("\nElenco piatti per nome gestito in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nElenco piatti per nome gestito in maniera errata");
			
			assertEquals("Implementazione del metodo elencoPiattiPerNome() e/o dei metodi correlati errata", true,corretto);	  
	  }    
	  
	  
	  public void testElencoPiattiPerNumeroIngredienti(){

			System.out.println("\n*** testElencoPiattiPerNumeroIngredienti() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			String idc1 = c1.getId();

			Concorrente c2 = t.iscriviConcorrente("Giuseppe", "Grigi", "Commercialista");
			String idc2 = c2.getId();
			
			System.out.println("Registrazione piatti concorrenti (con aggiunta ingredienti)");
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			int idp2 = t.registraPiattoConcorrente("Tiramisu", idc1);
			int idp3 = t.registraPiattoConcorrente("Pollo al rosmarino", idc2);
			int idp4 = t.registraPiattoConcorrente("Budino", idc2);

			try{
				t.aggiungiIngredientePiatto(idp1, "Vitello");
				t.aggiungiIngredientePiatto(idp1, "Salsa tonnata");
				t.aggiungiIngredientePiatto(idp2, "Uova");
				t.aggiungiIngredientePiatto(idp2, "Pavisini");
				t.aggiungiIngredientePiatto(idp2, "Caffe");
				t.aggiungiIngredientePiatto(idp2, "Mascarpone");
				t.aggiungiIngredientePiatto(idp3, "Pollo");
				t.aggiungiIngredientePiatto(idp3, "Aglio");
				t.aggiungiIngredientePiatto(idp3, "Rosmarino");
				t.aggiungiIngredientePiatto(idp4, "Latte");
			}
			catch(EccezioneIngredienteDuplicato eid) {
				System.out.println("\nIndividuato ingrediente duplicato");
			}
			
			System.out.println("\nElenco piatti (per numero ingredienti crescente)");
			LinkedList<Piatto> listaPiatti = new LinkedList<Piatto>(t.elencoPiattiPerNumeroIngredienti());
			for(Piatto ptemp : listaPiatti)
				System.out.println(" "+ptemp.getIdPiatto()+" "+ptemp.getNome()+" (concorrente "+ptemp.getIdConcorrente()+")");

			Piatto p1 = listaPiatti.get(0);
			Piatto p2 = listaPiatti.get(1);
			Piatto p3 = listaPiatti.get(2);
			Piatto p4 = listaPiatti.get(3);
			
			
			boolean  corretto = false;
			
			if(p1.getNome().compareTo("Budino")==0 && 
			   p2.getNome().compareTo("Vitello tonnato")==0 && 	
			   p3.getNome().compareTo("Pollo al rosmarino")==0 &&
			   p4.getNome().compareTo("Tiramisu")==0 ) {
				System.out.println("\nElenco piatti per numero ingredienti gestito in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nElenco piatti per numero ingredienti gestito in maniera errata");
			
			assertEquals("Implementazione del metodo elencoPiattiPerNumeroIngredienti() e/o dei metodi correlati errata", true,corretto);	  
	}    	  
	  
}
