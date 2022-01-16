package it.polito.po.test;
import network_professionisti.*;
import java.util.*;
import junit.framework.TestCase;

public class TestR4_Connessioni extends TestCase {

	public void testElencoConnessioni(){

		System.out.println("\n*** testElencoConnessioni() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritti utenti al network");
		
		n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		n.nuovoIscritto("Daniela", "Gialli", "http://www.dg.it", "dg@mail.it", "Daniela Gialli lavora come pasticciera su una nave da crociera.");
		n.nuovoIscritto("Marco", "Blu", "http://www.mblu.eu", "mblu@mail.eu", "Marco Blu gioca come terzino nella squadra di calcetto del quartiere.");
		n.nuovoIscritto("Alessia", "Arancioni", "http://www.ale.com", "arancioni@mail.com", "Alessia Arancioni e' una importante dirigente nel settore moda.");
		n.nuovoIscritto("Giovanni", "Verdi", "http://www.gv.com", "gv@mail.com", "Giovanni Verdi e' noto per le sue fotografie.");
		
		n.nuovaConnessione("Luigi-Neri", "Daniela-Gialli");
		n.nuovaConnessione("Luigi-Neri", "Marco-Blu");
		n.nuovaConnessione("Giovanni-Verdi", "Luigi-Neri");

		System.out.println("\nConnessioni per l'iscritto con identificativo 'Luigi-Neri' (ordine alfabetico)");
		LinkedList<Iscritto> listaConnessioni = new LinkedList<Iscritto>(n.elencoConnessioni("Luigi-Neri"));
		for(Iscritto i : listaConnessioni)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");

		Iscritto i1 = listaConnessioni.get(0);
		Iscritto i2 = listaConnessioni.get(1);
		Iscritto i3 = listaConnessioni.get(2);
		
		boolean corretto = false;
		
		if(i1.getNome().compareTo("Daniela")==0 && i1.getCognome().compareTo("Gialli")==0 && 
	       i2.getNome().compareTo("Giovanni")==0 && i2.getCognome().compareTo("Verdi")==0 && 	
	       i3.getNome().compareTo("Marco")==0 && i3.getCognome().compareTo("Blu")==0)
		{
			System.out.println("\nElenco connessioni gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco connessioni gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoConnessioni() e/o dei metodi correlati errata", true,corretto);	  
		
		System.out.println("\nConnessioni per l'iscritto con identificativo 'Marco-Blu' (ordine alfabetico)");
		listaConnessioni = new LinkedList<Iscritto>(n.elencoConnessioni("Marco-Blu"));
		for(Iscritto i : listaConnessioni)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");

		i1 = listaConnessioni.get(0);
		
		
		corretto = false;
		
		if(listaConnessioni.size()==1 &&
		   i1.getNome().compareTo("Luigi")==0 && i1.getCognome().compareTo("Neri")==0)
		{
			System.out.println("\nElenco connessioni gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco connessioni gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoConnessioni() e/o dei metodi correlati errata", true,corretto);	  
		
	}
	
	
	
	public void testElencoConnessioniSuggerite(){

		System.out.println("\n*** testElencoConnessioniSuggerite() ***\n");
		
		Network n = new Network();
		
		System.out.println("Iscritti utenti al network");
		
		n.nuovoIscritto("Luigi", "Neri", "http://www.luigineri.com", "lneri@mail.com", "Luigi Neri ricopre il ruolo di rappresentante unico sul territorio regionale per la propria azienda di mattoni.");
		n.nuovoIscritto("Daniela", "Gialli", "http://www.dg.it", "dg@mail.it", "Daniela Gialli lavora come pasticciera su una nave da crociera.");
		n.nuovoIscritto("Marco", "Blu", "http://www.mblu.eu", "mblu@mail.eu", "Marco Blu gioca come terzino nella squadra di calcetto del quartiere.");
		n.nuovoIscritto("Alessia", "Arancioni", "http://www.ale.com", "arancioni@mail.com", "Alessia Arancioni e' una importante dirigente nel settore moda.");
		n.nuovoIscritto("Giovanni", "Verdi", "http://www.gv.com", "gv@mail.com", "Giovanni Verdi e' noto per le sue fotografie.");
		
				
		n.nuovaConnessione("Luigi-Neri", "Daniela-Gialli");
		n.nuovaConnessione("Luigi-Neri", "Marco-Blu");
		n.nuovaConnessione("Giovanni-Verdi", "Luigi-Neri");
		n.nuovaConnessione("Marco-Blu", "Alessia-Arancioni");
		n.nuovaConnessione("Marco-Blu", "Daniela-Gialli");

		System.out.println("\nConnessioni suggerite per l'iscritto con identificativo 'Luigi-Neri' (ordine alfabetico)");
		LinkedList<Iscritto> listaConnessioni = new LinkedList<Iscritto>(n.elencoConnessioniSuggerite("Luigi-Neri"));
		for(Iscritto i : listaConnessioni)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");

		Iscritto i1 = listaConnessioni.get(0);
		
		boolean corretto = false;
		
		if(listaConnessioni.size()==1 &&
		   i1.getNome().compareTo("Alessia")==0 && i1.getCognome().compareTo("Arancioni")==0)
			{
				System.out.println("\nElenco connessioni suggerite gestito in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nElenco connessioni suggerite gestito in maniera errata");
					
			assertEquals("Implementazione del metodo elencoConnessioniSuggerite () e/o dei metodi correlati errata", true,corretto);	  
	}
	
}

