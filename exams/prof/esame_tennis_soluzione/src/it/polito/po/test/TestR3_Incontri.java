package it.polito.po.test;

import junit.framework.TestCase;
import tennis.*;
import java.util.*;

public class TestR3_Incontri extends TestCase {

	Torneo torneo;
	
	public void setUp(){
	    torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);
    }
	
	public void testAggiungiIncontro() {

		System.out.println("\n*** testAggiungiIncontro() ***\n");

		System.out.println("Aggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo un incontro singolo alla sfida Italia-Croazia");

		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		
		assertNotNull("Metodo aggiungiIncontro() non implementato correttamente.", incontro);
		
		if(incontro!=null)
			if(incontro instanceof Singolo)
				System.out.println("Tipo dell'incontro aggiunto: singolo");
			else if(incontro instanceof Doppio)
				System.out.println("Tipo dell'incontro aggiunto: doppio");
			else
				System.out.println("Tipo dell'incontro aggiunto: indefinito");
		
		boolean corretto = false;
		
		if(incontro!=null)
			if(incontro instanceof Singolo)
				corretto = true;
		
		assertEquals("Metodo aggiungiIncontro() di Torneo non implementato correttamente.",true, corretto);

		System.out.println("\nAggiungo incontro doppio alla sfida Italia-Croazia");
	    incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');

		if(incontro!=null)
			if(incontro instanceof Singolo)
				System.out.println("Tipo dell'incontro aggiunto: singolo");
			else if(incontro instanceof Doppio)
				System.out.println("Tipo dell'incontro aggiunto: doppio");
			else
				System.out.println("Tipo dell'incontro aggiunto: indefinito");
	    
		corretto = false;
		
		if(incontro!=null)
			if(incontro instanceof Doppio)
				corretto = true;
		
		assertEquals("Metodo aggiungiIncontro() di Torneo non implementato correttamente.",true, corretto);
	}
	
	public void testGetIncontro() {

		System.out.println("\n*** testGetIncontro() ***\n");

		System.out.println("Aggiungo la sfida Italia-Croazia al primo turno");
		Sfida sfida = torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo tre incontri alla sfida Italia-Croazia");
		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		incontro.setData("20130201");
		incontro.setOra("11:00");
		incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		incontro.setData("20130201");
		incontro.setOra("15:00");
		incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');
		incontro.setData("20130202");
		incontro.setOra("12:00");

		System.out.println("\nRecupero il secondo incontro della sfida");
		
		incontro = sfida.getIncontro(2);
		
		assertNotNull("Metodo getIncontro() di Sfida non implementato correttamente.",incontro);

		if(incontro!=null)
			System.out.println(" Data: "+incontro.getData()+"\n Ora: "+incontro.getOra());
		
		boolean corretto = false;
		
		if(incontro!=null)
			if(incontro.getData().equals("20130201") && incontro.getOra().equals("15:00"))
				corretto=true;
		
		assertEquals("Metodo getIncontro() di Sfida o metodi setter/getter di Incontro non implementati correttamente.",true,corretto);
	}	
		
	public void testAggiungiGiocatoriEccezione() {

		System.out.println("\n*** testAggiungiGiocatore() ***\n");

		System.out.println("Aggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo incontro SINGOLO alla sfida Italia-Croazia");

		Incontro incontro1 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');

	    Giocatore bolelli = torneo.iscriviGiocatore("Simone", "Bolelli", "Italia");
		Giocatore cilic   = torneo.iscriviGiocatore("Marin", "Cilic", "Croazia");
		Giocatore fognini = torneo.iscriviGiocatore("Fabio", "Fognini", "Italia");
		Giocatore pavic   = torneo.iscriviGiocatore("Mate", "Pavic", "Croazia");
		Giocatore seppi   = torneo.iscriviGiocatore("Andreas", "Seppi", "Italia");
		Giocatore dodig   = torneo.iscriviGiocatore("Ivan", "Dodig", "Croazia");

		System.out.println("\nAggiungo DUE giocatori all'incontro");

		boolean eccezione=false;
		
		try {
			incontro1.aggiungiGiocatore(bolelli);
			incontro1.aggiungiGiocatore(cilic);
			System.out.println("Giocatori aggiunti");
		} catch (TroppiGiocatoriException e) {
			eccezione=true;
			System.out.println("Errore nell'aggiungere i giocatori");
		}
		
		assertEquals("Metodo aggiungiGiocatore() di Incontro non implementato correttamente.",false,eccezione);
		
		System.out.println("\nAggiungo un altro incontro SINGOLO alla sfida Italia-Croazia");

		Incontro incontro2 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');

		System.out.println("\nAggiungo TRE giocatori all'incontro");
		
		eccezione = false;
		try {
			incontro2.aggiungiGiocatore(fognini);
			incontro2.aggiungiGiocatore(pavic);
			incontro2.aggiungiGiocatore(bolelli);
			System.out.println("Giocatori aggiunti");
		} catch (TroppiGiocatoriException e) {
			eccezione=true;
			System.out.println("Errore nell'aggiungere i giocatori");
		}
		
		assertEquals("Metodo aggiungiGiocatore() di Incontro non implementato correttamente.",true,eccezione);

		System.out.println("\nAggiungo un incontro DOPPIO alla sfida Italia-Croazia");
		
		Incontro incontro3 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');
		
		System.out.println("\nAggiungo QUATTRO giocatori all'incontro");
		
		eccezione=false;
		try {
			incontro3.aggiungiGiocatore(fognini);
			incontro3.aggiungiGiocatore(seppi);
			incontro3.aggiungiGiocatore(cilic);
			incontro3.aggiungiGiocatore(dodig);
			System.out.println("Giocatori aggiunti");
		} catch (TroppiGiocatoriException e) {
			eccezione=true;
			System.out.println("Errore nell'aggiungere i giocatori");
		}
		
		assertEquals("Metodo aggiungiGiocatore() di Incontro non implementato correttamente.",false,eccezione);
	}	
	
	public void testElencoIncontri() throws TroppiGiocatoriException {

		System.out.println("\n*** testElencoIncontri() ***\n");

		System.out.println("Aggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo tre incontri alla sfida Italia-Croazia");
		Sfida sfida = torneo.getSfida("Italia", "Croazia");

		Incontro incontro1 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		Incontro incontro2 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		Incontro incontro3 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');
		
		incontro1.setData("20130201");
		incontro1.setOra("11:00");
		incontro2.setData("20130201");
		incontro2.setOra("15:00");
		incontro3.setData("20130202");
		incontro3.setOra("12:00");
		
		List<Incontro> incontri = new LinkedList<Incontro>(sfida.elencoIncontri());

		assertNotNull("Metodo elencoIncontri() di Sfida non implementato correttamente.", incontri);
		
		if(incontri!=null)
			System.out.println("\nNumero di incontri aggiunti: "+incontri.size());
		
		assertEquals("Metodo elencoIncontri() di Sfida non implementato correttamente.", 3, incontri.size());
		
		if(incontri!=null)
			for(int i=0;i<incontri.size();i++)
				System.out.println(" Incontro "+(i+1)+" il "+incontri.get(i).getData()+" alle "+incontri.get(i).getOra());
		
		boolean corretto=false;
		
		if(incontri!=null)
			if(incontri.get(0).getData().equals("20130201") && incontri.get(0).getOra().equals("11:00") && incontri.get(1).getData().equals("20130201") && incontri.get(1).getOra().equals("15:00") && incontri.get(2).getData().equals("20130202") && incontri.get(2).getOra().equals("12:00") )
				corretto=true;
		
		assertEquals("Metodo elencoIncontri() di Sfida o metodi setter/getter di Incontro non implementati correttamente.", true, corretto);
	}
	
	public void testElencoGiocatori() {

		System.out.println("\n*** testElencoGiocatori() ***\n");

		System.out.println("Aggiungo una sfida al primo turno, Italia-Croazia");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo incontro doppio alla sfida Italia-Croazia");
		
		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');
		
		Giocatore fognini = torneo.iscriviGiocatore("Fabio", "Fognini", "Italia");
		Giocatore seppi   = torneo.iscriviGiocatore("Andreas", "Seppi", "Italia");
		Giocatore cilic   = torneo.iscriviGiocatore("Marin", "Cilic", "Croazia");
		Giocatore dodig   = torneo.iscriviGiocatore("Ivan", "Dodig", "Croazia");
	    Giocatore bolelli = torneo.iscriviGiocatore("Simone", "Bolelli", "Italia");

	    System.out.println("\nAggiungo giocatori all'incontro");
	    
		try {
			incontro.aggiungiGiocatore(fognini);
			incontro.aggiungiGiocatore(seppi);
			incontro.aggiungiGiocatore(cilic);
			incontro.aggiungiGiocatore(dodig);
			incontro.aggiungiGiocatore(bolelli);
		} catch (TroppiGiocatoriException e) {
		}
		
		List<Giocatore> giocatori = new LinkedList<Giocatore>(incontro.elencoGiocatori());

		assertNotNull("Metodo elencoGiocatori() di Incontro non implementato correttamente.", giocatori);

		if(giocatori!=null)
			System.out.println("\nNumero di giocatori aggiunti: "+giocatori.size());
		
		assertEquals("Metodo elencoGiocatori() di Incontro non implementato correttamente.", 4, giocatori.size());
		
		if(giocatori!=null)
			for(int i=0;i<giocatori.size();i++)
				System.out.println(" "+giocatori.get(i).getNome()+" "+giocatori.get(i).getCognome()+" "+giocatori.get(i).getSquadra());
		
		boolean corretto=false;
		
		if(giocatori!=null)
			if(giocatori.get(0).getCognome().equals("Fognini") && giocatori.get(1).getCognome().equals("Seppi") && giocatori.get(2).getCognome().equals("Cilic") && giocatori.get(3).getCognome().equals("Dodig"))
				corretto=true;
		
		assertEquals("Metodo elencoGiocatori() di Incontro o metodi getter di Giocatore non implementati correttamente.", true, corretto);
	}	
	
}
