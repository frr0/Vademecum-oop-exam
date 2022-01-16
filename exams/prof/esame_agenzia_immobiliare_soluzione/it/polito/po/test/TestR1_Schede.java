package it.polito.po.test;

import agenzia_immobiliare.*;

import java.util.LinkedList;

import junit.framework.TestCase;

public class TestR1_Schede extends TestCase {

	public void testCreaScheda(){
		
		System.out.println("\n*** testCreaScheda() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione scheda immobile");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
				
		System.out.println("\n* Informazioni:\n");

		System.out.println("Comune: "+s1.getComune());
		System.out.println("Indirizzo: "+s1.getIndirizzo());
		System.out.println("Tipologia: "+s1.getTipologia());
		System.out.println("Numero di locali: "+s1.getLocali());
		System.out.println("Superficie: "+s1.getSuperficie()+" m^2");
		System.out.println("Descrizione: "+s1.getDescrizione());

		boolean corretto = false;
		
		if(s1.getComune().compareTo("Milano") ==0 &&
           s1.getIndirizzo().compareTo("Via Torino 100") ==0 &&
           s1.getTipologia().compareTo("Appartamento") ==0 &&
		   s1.getLocali() == 5 && 
		   s1.getSuperficie() == 50 && 
		   s1.getDescrizione().compareTo("Grazioso appartamento vicino alla Stazione Centrale.") == 0)
		{
			System.out.println("\nInformazioni relative all'immobile registrate in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nella registrazione delle informazioni relative all'immobile");
			
		assertEquals("Implementazione del metodo creaScheda() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	public void testCreaSchedaIdAssegnato(){
		
		System.out.println("\n*** testCreaSchedaIdAssegnato() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione scheda immobile");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
				
		System.out.println("\n* Identificativo assegnato");

		System.out.println("\n"+s1.getIdSchedaImmobile());

		boolean corretto = false;
		
		if(s1.getIdSchedaImmobile().compareTo("MILANO1") == 0)
		{
			System.out.println("\nIdentificativo assegnato in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nell'assegnazione dell'identificativo");
			
		assertEquals("Implementazione del metodo creaScheda() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	public void testCreaSchedaIdAssegnati(){
		
		System.out.println("\n*** testCreaSchedaIdAssegnati() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		SchedaImmobile s2 = a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		SchedaImmobile s3 = a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		SchedaImmobile s4 = a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		SchedaImmobile s5 = a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		SchedaImmobile s6 = a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Identificativi assegnati\n");

		System.out.println(s1.getIdSchedaImmobile());
		System.out.println(s2.getIdSchedaImmobile());
		System.out.println(s3.getIdSchedaImmobile());
		System.out.println(s4.getIdSchedaImmobile());
		System.out.println(s5.getIdSchedaImmobile());
		System.out.println(s6.getIdSchedaImmobile());

		boolean corretto = false;
		
		if(s1.getIdSchedaImmobile().compareTo("MILANO1") == 0 && 
		   s2.getIdSchedaImmobile().compareTo("NAPOLI1") == 0 && 
		   s3.getIdSchedaImmobile().compareTo("MILANO2") == 0 && 
		   s4.getIdSchedaImmobile().compareTo("ROMA1") == 0 && 
		   s5.getIdSchedaImmobile().compareTo("MILANO3") == 0 && 
		   s6.getIdSchedaImmobile().compareTo("ROMA2") == 0 )
		{
			System.out.println("\nIdentificativi assegnato in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nErrore nell'assegnazione degli identificativi");
			
		assertEquals("Implementazione del metodo creaScheda() e/o dei metodi correlati errata", true,corretto);	  
	}

	public void testCreaSchedaImmobileEsistente(){
		
		System.out.println("\n*** testCreaSchedaImmobileEsistente() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile\n");
		
		SchedaImmobile s1 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
						    a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
						    a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
						    a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
						    a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
						    a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");

						    
	    SchedaImmobile s2 = a.creaScheda("Milano", "Via Torino 100", "Appartamento", 0, 0, "");

		System.out.println("* Creazione scheda immobila con stesso comune, indirizzo e tipologia di immobile esistente");

		System.out.println("\n* Informazioni:\n");

		System.out.println("Comune: "+s2.getComune());
		System.out.println("Indirizzo: "+s2.getIndirizzo());
		System.out.println("Tipologia: "+s2.getTipologia());
		System.out.println("Numero di locali: "+s2.getLocali());
		System.out.println("Superficie: "+s2.getSuperficie()+" m^2");
		System.out.println("Descrizione: "+s2.getDescrizione());
		
		boolean corretto = false;
		
		if(s1 == s2)
		{
			System.out.println("\nImmobile gia' presente gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nImmobile gia' presente gestito in maniera errata");
			
		assertEquals("Implementazione del metodo creaScheda() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	public void testOttieniScheda(){
		
		System.out.println("\n*** testOttieniScheda() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		SchedaImmobile s3 = a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Ottieni scheda "+s3.getIdSchedaImmobile());

		SchedaImmobile s = a.ottieniScheda(s3.getIdSchedaImmobile());
		
		System.out.println("\n* Informazioni:\n");

		System.out.println("Comune: "+s.getComune());
		System.out.println("Indirizzo: "+s.getIndirizzo());
		System.out.println("Tipologia: "+s.getTipologia());

		boolean corretto = false;
		
		if(s.getComune().compareTo("Milano") ==0 &&
		   s.getIndirizzo().compareTo("Via Montenapoleone 33") ==0 &&
		   s.getTipologia().compareTo("Casa indipendente") ==0)
		{
			System.out.println("\nScheda ottenuta in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nScheda ottenuta in maniera errata");
			
		assertEquals("Implementazione del metodo ottieniScheda() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	public void testAggiornaScheda(){
		
		System.out.println("\n*** testAggiornaScheda() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile\n");

		SchedaImmobile s4 = a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		
		System.out.println("Superficie: "+s4.getSuperficie()+" m^2");
		System.out.println("Descrizione: "+s4.getDescrizione());
				
		System.out.println("\n* Aggiornamento scheda immobile");

		System.out.println("\n* Informazioni (aggiornate):\n");
		
		a.aggiornaScheda(s4.getIdSchedaImmobile(), 75, "Grande appartamento nei pressi della Stazione Termini.");	

		System.out.println("Superficie: "+s4.getSuperficie()+" m^2");
		System.out.println("Descrizione: "+s4.getDescrizione());

		boolean corretto = false;
		
		if(s4.getSuperficie() == 75 && 
		   s4.getDescrizione().compareTo("Grande appartamento nei pressi della Stazione Termini.")==0)
		{
			System.out.println("\nAggiornamento scheda gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nAggiornamento scheda gestito in maniera errata");
			
		assertEquals("Implementazione del metodo aggiornaScheda() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	
	
	
	public void testElencoSchedeOrdineDiInserimento(){
		
		System.out.println("\n*** testElencoSchedeOrdineDiInserimento() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Elenco schede (ordine di inserimento)\n");
		
		LinkedList<SchedaImmobile> listaSchede = new LinkedList<SchedaImmobile>(a.elencoSchedeOrdineDiInserimento());
		for(SchedaImmobile s : listaSchede)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());

		SchedaImmobile s0 = listaSchede.get(0);
		SchedaImmobile s1 = listaSchede.get(1);
		SchedaImmobile s2 = listaSchede.get(2);
		SchedaImmobile s3 = listaSchede.get(3);
		SchedaImmobile s4 = listaSchede.get(4);
		SchedaImmobile s5 = listaSchede.get(5);
		
		boolean corretto = false;
		
		if(s0.getIdSchedaImmobile().compareTo("MILANO1")==0 && 
		   s1.getIdSchedaImmobile().compareTo("NAPOLI1")==0 && 	
		   s2.getIdSchedaImmobile().compareTo("MILANO2")==0 && 	
		   s3.getIdSchedaImmobile().compareTo("ROMA1")==0 && 	
		   s4.getIdSchedaImmobile().compareTo("MILANO3")==0 && 	
		   s5.getIdSchedaImmobile().compareTo("ROMA2")==0 )
		{
			System.out.println("\nElenco schede gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco schede gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoSchedeOrdineDiIdentificativo() e/o dei metodi correlati errata", true,corretto);	  
	}
	
	
	
	
public void testElencoSchedeOrdineDiIdentificativo(){
		
		System.out.println("\n*** testElencoSchedeOrdineDiIdentificativo() ***\n");
		
		Agenzia a = new Agenzia();

		System.out.println("* Creazione schede immobile");
		
		a.creaScheda("Milano", "Via Torino 100", "Appartamento", 5, 50, "Grazioso appartamento vicino alla Stazione Centrale.");
		a.creaScheda("Napoli", "Piazza del Plebiscito 1/A", "Appartamento", 2, 30, "Minuscolo appartamento in pieno centro.");
		a.creaScheda("Milano", "Via Montenapoleone 33", "Casa indipendente", 6, 150, "Magnifica abitazione sulla via dello shopping.");
		a.creaScheda("Roma", "Via Giolitti 12", "Appartamento", 7, 120, "Enorme appartamento nei pressi della Stazione Termini.");
		a.creaScheda("Milano", "Corso Roma 66", "Appartamento", 4, 40, "Piccolo attico arredato.");
		a.creaScheda("Roma", "Via Giolitti 24", "Appartamento", 2, 70, "Appartamento comodo per chi deve viaggiare.");
				
		System.out.println("\n* Elenco schede (ordinate per identificativo)\n");
		
		LinkedList<SchedaImmobile> listaSchede = new LinkedList<SchedaImmobile>(a.elencoSchedeOrdineDiIdentificativo());
		for(SchedaImmobile s : listaSchede)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());

		SchedaImmobile s0 = listaSchede.get(0);
		SchedaImmobile s1 = listaSchede.get(1);
		SchedaImmobile s2 = listaSchede.get(2);
		SchedaImmobile s3 = listaSchede.get(3);
		SchedaImmobile s4 = listaSchede.get(4);
		SchedaImmobile s5 = listaSchede.get(5);
		
		boolean corretto = false;
		
		if(s0.getIdSchedaImmobile().compareTo("MILANO1")==0 && 
		   s1.getIdSchedaImmobile().compareTo("MILANO2")==0 && 	
		   s2.getIdSchedaImmobile().compareTo("MILANO3")==0 && 	
		   s3.getIdSchedaImmobile().compareTo("NAPOLI1")==0 && 	
		   s4.getIdSchedaImmobile().compareTo("ROMA1")==0 && 	
		   s5.getIdSchedaImmobile().compareTo("ROMA2")==0 )
		{
			System.out.println("\nElenco schede gestito in maniera corretta");
			corretto = true;
		}
		else
			System.out.println("\nElenco schede gestito in maniera errata");
			
		assertEquals("Implementazione del metodo elencoSchedeOrdineDiIdentificativo() e/o dei metodi correlati errata", true,corretto);	  
	}
	
}


