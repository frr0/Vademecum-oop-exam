package it.polito.po.test;

import junit.framework.TestCase;
import tennis.*;
import java.util.*;

public class TestR1_TorneiTurniSquadreGiocatori extends TestCase {

	Torneo torneo;
	
	public void setUp(){
	    torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);
    }
	
	public void testCostruttoreTorneo() {

		System.out.println("\n*** testCostruttoreTorneo() ***\n");

		System.out.println("Creo torneo a 16 squadre, con sfide di 3 incontri ciascuna al meglio dei 5 set");

		assertNotNull("Costruttore di Torneo non implementato correttamente.",torneo);

		if(torneo!=null)
			System.out.println("Torneo creato: "+torneo.getNome());
		
		if(torneo!=null)
			assertEquals("Metodo getNome() di Torneo non implementato correttamente.","Coppa Davis 2013 - Gruppo Mondiale",torneo.getNome());
	}

	public void testAggiungiSquadraAssente() {

		System.out.println("\n*** testAggiungiSquadraAssente() ***\n");
		
		System.out.println("Aggiungo una squadra al torneo");
		Squadra squadra = torneo.aggiungiSquadra("Italia");

		assertNotNull("Metodo aggiungiSquadra() non implementato correttamente.",squadra);
		
		if(squadra!=null)
			System.out.println("Squadra aggiunta: "+squadra.getNome());

		assertEquals("Metodi aggiungiSquadra() di Torneo o getNome() di Squadra non implementati correttamente.","Italia",squadra.getNome());		
	}

	public void testGetSquadraPresente() {

		System.out.println("\n*** testGetSquadraPresente() ***\n");
		
		System.out.println("Aggiungo la squadra Stati Uniti al torneo");
		torneo.aggiungiSquadra("Stati Uniti");

		System.out.println("\nRecupero squadra aggiunta");
		Squadra squadra = torneo.getSquadra("Stati Uniti");
		
		assertNotNull("Metodo getSquadra() diTorneo non implementato correttamente.",squadra);
		
		if(squadra!=null)
			System.out.println("Squadra aggiunta: "+squadra.getNome());

		assertEquals("Metodi getSquadra() di Torneo o getNome() di Squadra non implementati correttamente.","Stati Uniti",squadra.getNome());		
	}

	public void testGetSquadraAssente() {

		System.out.println("\n*** testGetSquadraAssente() ***\n");
		
		System.out.println("Aggiungo la squadra Stati Uniti al torneo");
		torneo.aggiungiSquadra("Stati Uniti");

		System.out.println("\nCerco di recuperare squadra inesistente (Giappone)");
		Squadra squadra = torneo.getSquadra("Giappone");
		
		if(squadra==null)
			System.out.println("Impossibile recuperare squadra inesistente");
		
		assertNull("Metodo getSquadra() di Torneo non implementato correttamente.",squadra);
	}

	public void testElencoSquadre() {

		System.out.println("\n*** testElencoSquadre() ***\n");
		
		System.out.println("Aggiungo una squadra al torneo");
        Squadra squadra = torneo.aggiungiSquadra("Svizzera");
		System.out.println("Squadra aggiunta: "+squadra.getNome());

		System.out.println("\nAggiungo un'altra squadra al torneo");
		squadra = torneo.aggiungiSquadra("Italia");
		System.out.println("Squadra aggiunta: "+squadra.getNome());

		System.out.println("\nAggiungo ancora un'altra squadra al torneo");
		squadra = torneo.aggiungiSquadra("Stati Uniti");
		System.out.println("Squadra aggiunta: "+squadra.getNome());

		List<Squadra> squadre = new LinkedList<Squadra>(torneo.elencoSquadre());
		assertNotNull("Metodo elencoSquadre() non implementato correttamente.",squadre);

		if(squadre!=null) 
			System.out.println("\nNumero di squadre aggiunte: "+squadre.size());

		assertEquals("Metodo elencoSquadre() di Torneo non implementato correttamente.",3,squadre.size());		

		System.out.println("\nElenco squadre aggiunte:");
		for(int i=0;i<squadre.size();i++)
			System.out.println(" "+squadre.get(i).getNome());

		boolean corretto=false;
		
		if(squadre!=null)
			if(squadre.get(0).getNome().equals("Italia") && squadre.get(1).getNome().equals("Stati Uniti") && squadre.get(2).getNome().equals("Svizzera"))
				corretto=true;
		
		assertEquals("Metodi elencoSquadre() di Torneo o getNome() di Squadra non implementati correttamente.",true,corretto);			
	}
	
	public void testAggiungiSquadraPresente() {

		System.out.println("\n*** testAggiungiSquadraPresente() ***\n");
		
		System.out.println("Aggiungo la squadra Italia al torneo");
		Squadra squadra = torneo.aggiungiSquadra("Italia");

		if(squadra!=null)
			System.out.println("Squadra aggiunta: "+squadra.getNome());

		List<Squadra> squadre = new LinkedList<Squadra>(torneo.elencoSquadre());
		
		if(squadre!=null)
			System.out.println("Numero di squadre aggiunte: "+squadre.size());

		System.out.println("\nAggiungo DI NUOVO squadra Italia al torneo");
		squadra = torneo.aggiungiSquadra("Italia");

		squadre = new LinkedList<Squadra>(torneo.elencoSquadre());

		if(squadre!=null)
			System.out.println("Numero di squadre aggiunte: "+squadre.size());
		
		assertEquals("Metodi aggiungiSquadra() o elencoSquadre() di Torneo non implementati correttamente.",1,squadre.size());		
		
		assertEquals("Metodi aggiungiSquadra() di Torneo o getNome() di Squadra non implementati correttamente.","Italia",squadra.getNome());		
	}
	
	public void testIscriviGiocatore() {

		System.out.println("\n*** testIscriviGiocatore() ***\n");
		
		System.out.println("Aggiungo la squadra Italia al torneo");
        torneo.aggiungiSquadra("Italia");

        System.out.println("\nIscrivo un giocatore al torneo (squadra di appartenenza Italia)");
		Giocatore giocatore = torneo.iscriviGiocatore("Simone", "Bolelli", "Italia");
	
		assertNotNull("Metodo iscriviGiocatore() di Torneo non implementato correttamente.",giocatore);
		
		if(giocatore!=null)
			System.out.println("Giocatore iscritto: "+giocatore.getNome()+" "+giocatore.getCognome()+", "+giocatore.getSquadra().getNome());
		
		boolean corretto=false;
		
		if(giocatore!=null)
			if(giocatore.getNome().equals("Simone") && giocatore.getCognome().equals("Bolelli") && giocatore.getSquadra().getNome().equals("Italia"))
				corretto = true;
		
		assertEquals("Metodo iscriviGiocatore() di Torneo o metodi getter di Giocatore non implementati correttamente.", true, corretto);	
	}
	
	
	public void testElencoGiocatori() {

		System.out.println("\n*** testElencoGiocatori() ***\n");
		
		System.out.println("Aggiungo la squadra Italia al torneo");
        torneo.aggiungiSquadra("Italia");

        System.out.println("\nIscrivo quattri giocatori al torneo (squadra di appartenenza Italia)");
		torneo.iscriviGiocatore("Simone", "Bolelli", "Italia");
		torneo.iscriviGiocatore("Andreas", "Seppi", "Italia");
		torneo.iscriviGiocatore("Fabio", "Fognini", "Italia");
		torneo.iscriviGiocatore("Paolo", "Lorenzi", "Italia");

        List<Giocatore> giocatori = new LinkedList<Giocatore>(torneo.elencoGiocatori());
                    		
        System.out.println("\nElenco giocatori iscritti:");
        if(giocatori!=null)
        	for(Giocatore g : giocatori)
        		System.out.println(" "+g.getCognome()+" "+g.getNome()+", "+g.getSquadra());
		
		boolean corretto=false;
		
		if(giocatori!=null)
			if(giocatori.get(0).getCognome().equals("Bolelli") && giocatori.get(1).getCognome().equals("Fognini") && giocatori.get(2).getCognome().equals("Lorenzi") && giocatori.get(3).getCognome().equals("Seppi"))
				corretto = true;
		
		assertEquals("Metodo elencoGiocatori() di Torneo o metodi getter di Giocatore non implementati correttamente.", true, corretto);        
	}
	
	
	public void testElencoTurni() {

		System.out.println("\n*** testElencoTurni() ***\n");
		
		System.out.println("Creo un torneo A 16 SQUADRE, con sfide ...");
		
	    torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);
		
        System.out.println("\nCalcolo il numero di turni del torneo (a 16 squadre)");

        List<Turno> turni = new LinkedList<Turno>(torneo.elencoTurni());

		assertNotNull("\nMetodo elencoTurni() di Torneo non implementato correttamente.", turni);
        
        if(turni!=null)
        	System.out.println("Numero di turni: "+turni.size());

        if(turni!=null)
        	if(turni.size()!=4)
        		System.out.println("Numero di turni non corretto");
        
		assertEquals("Metodo elencoTurni() non implementato correttamente.", 4, turni.size());
        
		System.out.println("\nCreo un altro torneo, MA A 8 SQUADRE, con sfide ...");
	    torneo = new Torneo("Altro torneo", 8, 3, 3);

	    System.out.println("\nCalcolo il numero di turni del torneo (a 8 squadre)");

        turni = new LinkedList<Turno>(torneo.elencoTurni());
	    
        if(turni!=null)
        	System.out.println("Numero di turni: "+turni.size());

        if(turni!=null)
        	if(turni.size()!=2)
        		System.out.println("Numero di turni non corretto");
        
		assertEquals("Metodo elencoTurni() di Torneo non implementato correttamente.", 3, turni.size());
	}	
	
	public void testGetTurnoGetNumeroTurno() {

		System.out.println("\n*** testGetTurnoGetNumeroTurno() ***\n");
		
		System.out.println("Creo un torneo a 16 squadre, con sfide ...");
		
	    torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);

        System.out.println("\nRecupero l'elenco dei turni del torneo (a 16 squadre): ");

	    List<Turno> turni = new LinkedList<Turno>(torneo.elencoTurni());

        for(int i=0;i<turni.size();i++)
        	System.out.println(" Turno "+turni.get(i).getNumeroTurno());

        boolean corretto=false;
        if(turni.get(0).getNumeroTurno()==1 && turni.get(1).getNumeroTurno()==2 && turni.get(2).getNumeroTurno()==3 && turni.get(3).getNumeroTurno()==4)
        	corretto=true;
        
		assertEquals("Metodo getNumeroTurno() di Turno non implementato correttamente.", true, corretto);
 
		System.out.println("\nRecupero il secondo turno");
		Turno turno = torneo.getTurno(2);
		
		assertNotNull("Metodo getTurno() di Torneo non implementato correttamente.", turno);
		
		if(turno!=null)
			System.out.println("Numero del turno recuperato: "+turno.getNumeroTurno());
			
		assertEquals("Metodi getTurno() di Torneo o getNumeroTurno di Turno non implementati correttamente.", 2, turno.getNumeroTurno());	
	}		
	
}
