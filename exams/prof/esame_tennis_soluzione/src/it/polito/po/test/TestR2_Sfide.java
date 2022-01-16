package it.polito.po.test;

import junit.framework.TestCase;
import tennis.*;
import java.util.*;

public class TestR2_Sfide extends TestCase {

	Torneo torneo;
	
	public void setUp(){
	    torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);
    }
	
	public void testAggiungiSfida() {

		System.out.println("\n*** testAggiungiSfida() ***\n");

		System.out.println("Aggiungo una sfida al primo turno");
		Sfida sfida = torneo.aggiungiSfida(1, "Italia", "Croazia");

		assertNotNull("Metodo aggiungiSfida() non implementato correttamente.",sfida);

		if(sfida!=null)
			System.out.println("Sfida aggiunta: "+sfida.getSquadraCasa()+"-"+sfida.getSquadraOspite());

		boolean corretto=false;
		
		if(sfida!=null)
			if(sfida.getSquadraCasa().getNome().equals("Italia") && sfida.getSquadraOspite().getNome().equals("Croazia"))
				corretto=true;
		
		assertEquals("Metodo aggiungiSfida() di Torneo o metodi getter di Sfida e Squadra non implementati correttamente.",true, corretto);
	}

	public void testAggiungiPiuSfide() {

		System.out.println("\n*** testAggiungiPiuSfide() ***\n");

		System.out.println("Aggiungo la sfida Italia-Croazia al primo turno");
		torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo altre due sfide (Stati Uniti-Brasile e Svizzera-Repubblica Ceca) al primo turno");
		torneo.aggiungiSfida(1, "Stati Uniti", "Brasile");
		torneo.aggiungiSfida(1, "Svizzera", "Repubblica Ceca");
		
		List<Squadra> squadre = new LinkedList<Squadra>(torneo.elencoSquadre());
		
		System.out.println("\nSquadre aggiunte (o create automaticamente) con le sfide:");
		squadre = new LinkedList<Squadra>(torneo.elencoSquadre());
		for(int i=0;i<squadre.size();i++)
			System.out.println(" "+squadre.get(i).getNome());
		
		boolean corretto=false;
		
		if(squadre!=null)
			if(squadre.get(0).getNome().equals("Brasile") && squadre.get(1).getNome().equals("Croazia") && squadre.get(2).getNome().equals("Italia") && squadre.get(3).getNome().equals("Repubblica Ceca") && squadre.get(4).getNome().equals("Stati Uniti") && squadre.get(5).getNome().equals("Svizzera"))
				corretto=true;
		
		assertEquals("Mteodo aggungiSfida() o elencoSquadre() di Torneo non implementati correttamente.",true, corretto);
	}

	public void testGetSfida() {

		System.out.println("\n*** testGetSfida() ***\n");

		System.out.println("Aggiungo tre sfide al primo turno (Italia-Croazia, Stati Uniti-Brasile e Svizzera-Repubblica Ceca)");
		torneo.aggiungiSfida(1, "Italia", "Croazia");
		torneo.aggiungiSfida(1, "Stati Uniti", "Brasile");
		torneo.aggiungiSfida(1, "Svizzera", "Repubblica Ceca");

		System.out.println("\nRecupero sfida tra Stati Uniti e Brasile (in casa o fuori casa)");
		Sfida sfida = torneo.getSfida("Stati Uniti", "Brasile");

		assertNotNull("Metodo getSfida() di Torneo non implementato correttamente", sfida);
		
		if(sfida!=null)
			System.out.println("Sfida trovata: "+sfida.getSquadraCasa().getNome()+"-"+sfida.getSquadraOspite().getNome());
		else
			System.out.println("Sfida non trovata");
			
		boolean corretto=true;

		if(sfida.getSquadraCasa().getNome().equals("Stati Uniti") && sfida.getSquadraOspite().getNome().equals("Brasile")) 
			corretto=true;
		
		assertEquals("Metodo getSfida() di Torneo non implementato correttamente.", true, corretto);

		System.out.println("\nRecupero sfida tra Brasile e Stati Uniti (invertendo in casa e fuori casa)");
	    sfida = torneo.getSfida("Brasile", "Stati Uniti");

		assertNotNull("Metodo getSfida() di Torneo non implementato correttamente", sfida);
		
		if(sfida!=null)
			System.out.println("Sfida trovata: "+sfida.getSquadraCasa().getNome()+"-"+sfida.getSquadraOspite().getNome());
		else
			System.out.println("Sfida non trovata");

		corretto=false;
		if(sfida!=null)
			if(sfida.getSquadraCasa().getNome().equals("Stati Uniti") && sfida.getSquadraOspite().getNome().equals("Brasile")) 
				corretto=true;
		
		assertEquals("Metodo getSfida() di Torneo non implementato correttamente.", true, corretto);
	}
	
	public void testElencoSfidePerTorneo() {

		System.out.println("\n*** testElencoSfidePerTorneo() ***\n");

		System.out.println("Aggiungo la sfida Italia-Croazia AL PRIMO turno");
		Sfida sfida = torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo due sfide (Stati Uniti-Brasile e Svizzera-Repubblica Ceca) AL SECONDO turno");
		torneo.aggiungiSfida(2, "Stati Uniti", "Brasile");
		torneo.aggiungiSfida(2, "Svizzera", "Repubblica Ceca");
		
		System.out.println("\nSeleziono la sfida Italia-Croazia ed imposto luogo e date di svolgimento");                    
		sfida = torneo.getSfida("Italia", "Croazia");
		sfida.setLuogo("Torino");
		sfida.setDataDa("20130201");
		sfida.setDataA("20130203");
		System.out.println(" Luogo: "+sfida.getLuogo());
		System.out.println(" Dal:   "+sfida.getDataDa());
		System.out.println(" Al:    "+sfida.getDataA());
		
		System.out.println("\nSeleziono la sfida Svizzera-Repubblica Ceca ed imposto luogo e date di svolgimento");                    
		sfida = torneo.getSfida("Svizzera", "Repubblica Ceca");
		sfida.setLuogo("Ginevra");
		sfida.setDataDa("20130201");
		sfida.setDataA("20130203");
		System.out.println(" Luogo: "+sfida.getLuogo());
		System.out.println(" Dal:   "+sfida.getDataDa());
		System.out.println(" Al:    "+sfida.getDataA());

		System.out.println("\nSeleziono la sfida Stati Uniti-Brasile ed imposto luogo e date di svolgimento");                    
		sfida = torneo.getSfida("Stati Uniti", "Brasile");
		sfida.setLuogo("Jacksonville");
		sfida.setDataDa("20130131");
		sfida.setDataA("20130202");
		System.out.println(" Luogo: "+sfida.getLuogo());
		System.out.println(" Dal:   "+sfida.getDataDa());
		System.out.println(" Al:    "+sfida.getDataA());
		
		List<Sfida> sfide = new LinkedList<Sfida>(torneo.elencoSfide());
		
		assertNotNull("Metodo elencoSfide() per torneo non implementato correttamente.", sfide);
		
		System.out.println("\nSfide aggiunte (intero torneo):");
		if(sfide!=null)
			for(int i=0;i<sfide.size();i++)
				System.out.println(" "+sfide.get(i).getDataDa()+" "+sfide.get(i).getSquadraCasa().getNome()+"-"+sfide.get(i).getSquadraOspite().getNome());
		
		boolean corretto=false;
		if(sfide!=null)
			if(sfide.get(0).getSquadraCasa().getNome().equals("Stati Uniti") && sfide.get(0).getSquadraOspite().getNome().equals("Brasile") && sfide.get(1).getSquadraCasa().getNome().equals("Italia") && sfide.get(1).getSquadraOspite().getNome().equals("Croazia") && sfide.get(2).getSquadraCasa().getNome().equals("Svizzera") && sfide.get(2).getSquadraOspite().getNome().equals("Repubblica Ceca"))
				corretto=true;
		
		assertEquals("Metodo elencoSfide() per torneo non implementato correttamente.",true, corretto);
	}
	
	public void testElencoSfidePerTurno() {

		System.out.println("\n*** testElencoSfidePerTurno() ***\n");

		System.out.println("Aggiungo la sfida Italia-Croazia AL PRIMO turno");
		Sfida sfida = torneo.aggiungiSfida(1, "Italia", "Croazia");

		System.out.println("\nAggiungo due sfide (Stati Uniti-Brasile e Svizzera-Repubblica Ceca) AL SECONDO turno");
		torneo.aggiungiSfida(2, "Stati Uniti", "Brasile");
		torneo.aggiungiSfida(2, "Svizzera", "Repubblica Ceca");
		
		System.out.println("\nSeleziono la sfida Italia-Croazia ed imposto luogo e date di svolgimento");                    
		sfida = torneo.getSfida("Italia", "Croazia");
		sfida.setLuogo("Torino");
		sfida.setDataDa("20130201");
		sfida.setDataA("20130203");
		System.out.println(" Luogo: "+sfida.getLuogo());
		System.out.println(" Dal:   "+sfida.getDataDa());
		System.out.println(" Al:    "+sfida.getDataA());
		
		System.out.println("\nSeleziono la sfida Svizzera-Repubblica Ceca ed imposto luogo e date di svolgimento");                    
		sfida = torneo.getSfida("Svizzera", "Repubblica Ceca");
		sfida.setLuogo("Ginevra");
		sfida.setDataDa("20130201");
		sfida.setDataA("20130203");
		System.out.println(" Luogo: "+sfida.getLuogo());
		System.out.println(" Dal:   "+sfida.getDataDa());
		System.out.println(" Al:    "+sfida.getDataA());

		System.out.println("\nSeleziono la sfida Stati Uniti-Brasile ed imposto luogo e date di svolgimento");                    
		sfida = torneo.getSfida("Stati Uniti", "Brasile");
		sfida.setLuogo("Jacksonville");
		sfida.setDataDa("20130131");
		sfida.setDataA("20130202");
		System.out.println(" Luogo: "+sfida.getLuogo());
		System.out.println(" Dal:   "+sfida.getDataDa());
		System.out.println(" Al:    "+sfida.getDataA());
		
		List<Sfida> sfide = new LinkedList<Sfida>(torneo.elencoSfide(2));

		assertNotNull("Metodo elencoSfide() per turno non implementato correttamente.", sfide);
		
		System.out.println("\nSfide aggiunte (secondo turno):");
		if(sfide!=null)
			for(int i=0;i<sfide.size();i++)
				System.out.println(" "+sfide.get(i).getDataDa()+" "+sfide.get(i).getSquadraCasa().getNome()+"-"+sfide.get(i).getSquadraOspite().getNome());
		
		boolean corretto=false;
		if(sfide!=null)
			if(sfide.get(0).getSquadraCasa().getNome().equals("Stati Uniti") && sfide.get(0).getSquadraOspite().getNome().equals("Brasile") && sfide.get(1).getSquadraCasa().getNome().equals("Svizzera") && sfide.get(1).getSquadraOspite().getNome().equals("Repubblica Ceca"))
				corretto=true;
		
		assertEquals("Metodo elencoSfide() per turno non implementato correttamente.",true, corretto);
	}	

}
