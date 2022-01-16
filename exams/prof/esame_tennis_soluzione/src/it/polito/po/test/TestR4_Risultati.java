package it.polito.po.test;

import junit.framework.TestCase;
import tennis.*;

public class TestR4_Risultati extends TestCase {
	
	public void testPunteggioIncontro() {

		System.out.println("\n*** testPunteggioIncontro() ***\n");
		
		System.out.println("Creo torneo a 16 squadre, con sfide ...");
		
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);

		System.out.println("\nAggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo un incontro alla sfida Italia-Croazia");

		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');

		System.out.println("\nImposto punteggio");
		incontro.setPunteggio("6-1 1-6 5-7");
		
		String punteggio = incontro.getPunteggio();

		assertNotNull("Metodi setPunteggio() o getPunteggio() di Incontro non implementati correttamente.", punteggio);

		if(punteggio!=null)
			System.out.println(" Punteggio: "+punteggio);

		assertEquals("Metodi setPunteggio() o getPunteggio() di Incontro non implementati correttamente.", "6-1 1-6 5-7", punteggio);
	}

	public void testVincitoreIncontroSquadraCasaMeglioDeiCinqueSet() {

		System.out.println("\n*** testVincitoreIncontroSquadraCasaMeglioDeiCinqueSet() ***\n");
		
		System.out.println("Creo torneo a 16 squadre, con sfide di 3 incontri ciascuna AL MEGLIO DEI 5 SET");
		
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);

		System.out.println("\nAggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo un incontro alla sfida Italia-Croazia");

		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');

		System.out.println("\nImposto punteggio (finale)");
		incontro.setPunteggio("6-1 6-0 6-2");
		System.out.println(" Punteggio: "+incontro.getPunteggio());
		
		Squadra squadra = incontro.getVincitore();

		if(squadra!=null)
			System.out.println("\nSquadra vincitrice incontro: "+squadra.getNome());
		else
			System.out.println("\nSquadra vincitrice incontro: [Incontro ancora in corso]");

        assertEquals("Metodo getVincitore() dell'incontro non implementato correttamente.", "Italia", squadra.getNome());
	}		

	public void testVincitoreIncontroSquadraOspiteMeglioDeiCinqueSet() {

		System.out.println("\n*** testVincitoreIncontroSquadraOspiteMeglioDeiCinqueSet() ***\n");
		
		System.out.println("Creo torneo a 16 squadre, con sfide di 3 incontri ciascuna AL MEGLIO DEI 5 SET");
		
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);

		System.out.println("Aggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo un incontro alla sfida Italia-Croazia");

		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');

		System.out.println("\nImposto punteggio (finale)");
		incontro.setPunteggio("6-1 1-6 5-7 4-6");
		System.out.println(" Punteggio: "+incontro.getPunteggio());
		
		Squadra squadra = incontro.getVincitore();

		if(squadra!=null)
			System.out.println("\nSquadra vincitrice incontro: "+squadra.getNome());
		else
			System.out.println("\nSquadra vincitrice incontro: [Incontro ancora in corso]");

        assertEquals("Metodo getVincitore() dell'incontro non implementato correttamente.", "Croazia", squadra.getNome());
	}
	
	public void testVincitoreIncontroSquadraOspiteMeglioDeiTreSet() {

		System.out.println("\n*** testVincitoreIncontroSquadraOspiteMeglioDeiTreSet() ***\n");
		
		System.out.println("Creo torneo a 16 squadre, con sfide di 3 incontri ciascuna AL MEGLIO DEI 3 SET");
		
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 3);

		System.out.println("\nAggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo un incontro alla sfida Italia-Croazia");

		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');

		System.out.println("\nImposto punteggio (finale)");
		incontro.setPunteggio("0-6 3-6");
		System.out.println(" Punteggio: "+incontro.getPunteggio());
		
		Squadra squadra = incontro.getVincitore();

		if(squadra!=null)
			System.out.println("\nSquadra vincitrice incontro: "+squadra.getNome());
		else
			System.out.println("\nSquadra vincitrice incontro: [Incontro ancora in corso]");

        assertEquals("Metodo getVincitore() dell'incontro non implementato correttamente.", "Croazia", squadra.getNome());
	}
	
	public void testVincitoreIncontroInCorsoMeglioDeiTreSet() {

		System.out.println("\n*** testVincitoreIncontroInCorsoMeglioDeiTreSet() ***\n");
		
		System.out.println("Creo torneo a 16 squadre, con sfide di 3 incontri ciascuna AL MEGLIO DEI 3 SET");
		
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 3);

		System.out.println("\nAggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo un incontro alla sfida Italia-Croazia");

		Incontro incontro = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');

		System.out.println("\nImposto punteggio (parziale)");
		incontro.setPunteggio("0-6");
		System.out.println(" Punteggio: "+incontro.getPunteggio());
		
		Squadra squadra = incontro.getVincitore();

		if(squadra!=null)
			System.out.println("\nSquadra vincitrice incontro: "+squadra.getNome());
		else
			System.out.println("\nSquadra vincitrice incontro: [Incontro ancora in corso]");

        assertEquals("Metodo getVincitore() dell'incontro non implementato correttamente.", null, squadra);

		System.out.println("\nImposto punteggio (ancora parziale)");
		incontro.setPunteggio("0-6 0-1");
		System.out.println(" Punteggio: "+incontro.getPunteggio());
		
		squadra = incontro.getVincitore();

		if(squadra!=null)
			System.out.println("\nSquadra vincitrice incontro: "+squadra.getNome());
		else
			System.out.println("\nSquadra vincitrice incontro: [Incontro ancora in corso]");

        assertEquals("Metodo getVincitore() dell'incontro non implementato correttamente.", null, squadra);
        
		System.out.println("\nImposto punteggio (finale)");
		incontro.setPunteggio("0-6 0-6");
		System.out.println(" Punteggio: "+incontro.getPunteggio());
		
		squadra = incontro.getVincitore();

		if(squadra!=null)
			System.out.println("\nSquadra vincitrice incontro: "+squadra.getNome());
		else
			System.out.println("\nSquadra vincitrice incontro: [Incontro ancora in corso]");

        assertEquals("Metodo getVincitore() dell'incontro non implementato correttamente.", "Croazia", squadra.getNome());
	}	
	
	public void testPunteggioSfida() {

		System.out.println("\n*** testPunteggioSfida() ***\n");
		
		System.out.println("Creo torneo a 16 squadre, con sfide di 3 incontri ciascuna AL MEGLIO DEI 5 SET");
		
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);

		System.out.println("\nAggiungo la sfida Italia-Croazia al primo turno");
		Sfida sfida = torneo.aggiungiSfida(1, "Italia", "Croazia");
		
		System.out.println("\nAggiungo due incontri alla sfida Italia-Croazia");
		
		Incontro incontro1 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		incontro1.setPunteggio("6-1 1-6 5-7 4-6");
		System.out.println(" Punteggio primo incontro: "+incontro1.getPunteggio());

		Incontro incontro2 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		incontro2.setPunteggio("6-4 6-3 6-4");
		System.out.println(" Punteggio secondo incontro: "+incontro2.getPunteggio());

		String punteggio = sfida.getPunteggio();

		assertNotNull("Metodo getPunteggio() della sfida non implementato correttamente.",punteggio);

		if(punteggio!=null)
			System.out.println("\nPunteggio sfida Italia-Croazia: "+sfida.getPunteggio());
		
		assertEquals("Metodo getPunteggio() della sfida non implementato correttamente.","1-1",punteggio);

		System.out.println("\nAggiungo terzo incontro alla sfida Italia-Croazia");
		Incontro incontro3 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');
		incontro3.setPunteggio("1-6 5-7 6-1 6-0");
		System.out.println(" Punteggio terzo incontro (parziale): "+incontro3.getPunteggio());
		
		punteggio = sfida.getPunteggio();

		if(punteggio!=null)
			System.out.println("\nPunteggio sfida Italia-Croazia: "+sfida.getPunteggio());
		
		assertEquals("Metodo getPunteggio() della sfida non implementato correttamente.","1-1",punteggio);

		System.out.println("\nAggiorno punteggio terzo incontro");
		
		incontro3.setPunteggio("1-6 5-7 6-1 6-0 6-2");
		
		System.out.println(" Punteggio terzo incontro (finale): "+incontro3.getPunteggio());
		
		punteggio = sfida.getPunteggio();

		if(punteggio!=null)
			System.out.println("\nPunteggio sfida Italia-Croazia: "+sfida.getPunteggio());
		
		assertEquals("Metodo getPunteggio() non implementato correttamente.","2-1",punteggio);
	}
	
	public void testVincitoreSfida() {

		System.out.println("\n*** testVincitoreSfida() ***\n");
		
		System.out.println("Creo torneo a 16 squadre, con SFIDE DI 3 INCONTRI ciascuna AL MEGLIO DEI 5 SET");
		
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);

		System.out.println("\nAggiungo la sfida Italia-Croazia al primo turno");
		Sfida sfida = torneo.aggiungiSfida(1, "Italia", "Croazia");
		
		System.out.println("\nAggiungo tre incontri alla sfida Italia-Croazia");
		
		Incontro incontro1 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		incontro1.setPunteggio("6-1 1-6 5-7 4-6");
		System.out.println(" Punteggio primo incontro: "+incontro1.getPunteggio());

		Incontro incontro2 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		incontro2.setPunteggio("6-4 6-3 6-4");
		System.out.println(" Punteggio secondo incontro: "+incontro2.getPunteggio());

		Incontro incontro3 = torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');
		incontro3.setPunteggio("1-6 7-5 1-6 6-0 6-2");
		System.out.println(" Punteggio terzo incontro: "+incontro3.getPunteggio());
		
		System.out.println("\nPunteggio sfida Italia-Croazia: "+sfida.getPunteggio());

		Squadra squadra = sfida.getVincitore();
		
		if(squadra!=null)
			System.out.println("\nSquadra vincitrice sfida: "+squadra.getNome());
		else
			System.out.println("\nSquadra vincitrice sfida: [Sfida ancora in corso]");

        assertEquals("Metodo getVincitore() della sfida non implementato correttamente.", "Italia", squadra.getNome());
	}	
	
}
