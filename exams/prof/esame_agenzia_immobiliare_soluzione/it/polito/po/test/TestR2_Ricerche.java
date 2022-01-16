package it.polito.po.test;

import agenzia_immobiliare.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR2_Ricerche extends TestCase {

	public void testRicercaSchedeTesto(){
		
		System.out.println("\n*** ricercaSchedeTesto() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Cercate schede immobile contenenti 'Stazione'");

		System.out.println("\n* Schede trovate (ordinate per identificativo):\n");
		
		LinkedList<SchedaImmobile> listaSchedeTrovate1 = new LinkedList<SchedaImmobile>(a.ricercaSchedeTesto("Stazione"));
		for(SchedaImmobile s : listaSchedeTrovate1)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		SchedaImmobile s10 = listaSchedeTrovate1.get(0);
		SchedaImmobile s11 = listaSchedeTrovate1.get(1);

		System.out.println("\n* Cercate schede immobile contenenti 'Via'");

		System.out.println("\n* Schede trovate (ordinate per identificativo):\n");
		
		LinkedList<SchedaImmobile> listaSchedeTrovate2 = new LinkedList<SchedaImmobile>(a.ricercaSchedeTesto("Via"));
		for(SchedaImmobile s : listaSchedeTrovate2)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		SchedaImmobile s20 = listaSchedeTrovate2.get(0);
		SchedaImmobile s21 = listaSchedeTrovate2.get(1);
		SchedaImmobile s22 = listaSchedeTrovate2.get(2);
		SchedaImmobile s23 = listaSchedeTrovate2.get(3);

		
		boolean corretto = false;
		
		if(listaSchedeTrovate1.size()==2 &&
		   s10.getIdSchedaImmobile().compareTo("MILANO1")==0 &&	
		   s11.getIdSchedaImmobile().compareTo("ROMA1")==0&& 
		   listaSchedeTrovate2.size()==4 &&
		   s20.getIdSchedaImmobile().compareTo("MILANO1")==0 &&	
		   s21.getIdSchedaImmobile().compareTo("MILANO2")==0 &&	
		   s22.getIdSchedaImmobile().compareTo("ROMA1")==0 &&	
		   s23.getIdSchedaImmobile().compareTo("ROMA2")==0 )
		{
			System.out.println("\nRicerca schede gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca schede gestita in maniera errata");
			
		assertEquals("Implementazione del metodo ricercaSchedeTesto() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	
	
	public void testRicercaSchedeCriterioLocali(){
		
		System.out.println("\n*** testRicercaSchedeCriterioLocali() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Impostato criterio di ricerca (da 5 a 7 locali)");
		
		a.impostaCriterio('L', true, 5, 7);
		a.impostaCriterio('S', false, 0, 0);
		
		System.out.println("\n* Cercate schede con il criterio impostato");

		System.out.println("\n* Schede trovate (ordinate per identificativo):\n");
		
		LinkedList<SchedaImmobile> listaSchedeTrovate = new LinkedList<SchedaImmobile>(a.ricercaSchedeCriteri());
		for(SchedaImmobile s : listaSchedeTrovate)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		SchedaImmobile s0 = listaSchedeTrovate.get(0);
		SchedaImmobile s1 = listaSchedeTrovate.get(1);
		SchedaImmobile s2 = listaSchedeTrovate.get(2);

		
		boolean corretto = false;
		
		if(listaSchedeTrovate.size()==3 &&
		   s0.getIdSchedaImmobile().compareTo("MILANO1")==0 &&	
		   s1.getIdSchedaImmobile().compareTo("MILANO2")==0 &&	
		   s2.getIdSchedaImmobile().compareTo("ROMA1")==0) 
		{
			System.out.println("\nRicerca schede gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca schede gestita in maniera errata");
			
		assertEquals("Implementazione del metodo ricercaSchedeCriteri() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	public void testRicercaSchedeCriterioSuperficie(){
		
		System.out.println("\n*** testRicercaSchedeCriterioSuperficie() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Impostato critero di ricerca (da 70 a 250 m^2)");
		
		a.impostaCriterio('L', false, 0, 0);
		a.impostaCriterio('S', true, 70, 250);
		
		System.out.println("\n* Cercate schede con il criterio impostato");

		System.out.println("\n* Schede trovate (ordinate per identificativo):\n");
		
		LinkedList<SchedaImmobile> listaSchedeTrovate = new LinkedList<SchedaImmobile>(a.ricercaSchedeCriteri());
		for(SchedaImmobile s : listaSchedeTrovate)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		SchedaImmobile s0 = listaSchedeTrovate.get(0);
		SchedaImmobile s1 = listaSchedeTrovate.get(1);
		SchedaImmobile s2 = listaSchedeTrovate.get(2);

		
		boolean corretto = false;
		
		if(listaSchedeTrovate.size()==3 &&
		   s0.getIdSchedaImmobile().compareTo("MILANO2")==0 &&	
		   s1.getIdSchedaImmobile().compareTo("ROMA1")==0 &&	
		   s2.getIdSchedaImmobile().compareTo("ROMA2")==0) 
		{
			System.out.println("\nRicerca schede gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca schede gestita in maniera errata");
			
		assertEquals("Implementazione del metodo ricercaSchedeCriteri() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	public void testRicercaSchedeCriteri(){
		
		System.out.println("\n*** testRicercaSchedeCriteri() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Impostati criteri di ricerca (da 4 a 7 locali, da 40 a 120 m^2)");
		
		a.impostaCriterio('L', true, 4, 7);
		a.impostaCriterio('S', true, 40, 120);
		
		System.out.println("\n* Cercate schede con il criterio impostato");

		System.out.println("\n* Schede trovate (ordinate per identificativo):\n");
		
		LinkedList<SchedaImmobile> listaSchedeTrovate = new LinkedList<SchedaImmobile>(a.ricercaSchedeCriteri());
		for(SchedaImmobile s : listaSchedeTrovate)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		SchedaImmobile s0 = listaSchedeTrovate.get(0);
		SchedaImmobile s1 = listaSchedeTrovate.get(1);
		SchedaImmobile s2 = listaSchedeTrovate.get(2);

		
		boolean corretto = false;
		
		if(listaSchedeTrovate.size()==3 &&
		   s0.getIdSchedaImmobile().compareTo("MILANO1")==0 &&	
		   s1.getIdSchedaImmobile().compareTo("MILANO3")==0 &&	
		   s2.getIdSchedaImmobile().compareTo("ROMA1")==0) 
		{
			System.out.println("\nRicerca schede gestita in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nRicerca schede gestita in maniera errata");
			
		assertEquals("Implementazione del metodo ricercaSchedeCriteri() e/o dei metodi correlati errata", true,corretto);	  
	}
}


