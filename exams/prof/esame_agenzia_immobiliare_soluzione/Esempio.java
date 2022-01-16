import java.util.*;

import agenzia_immobiliare.*;

public class Esempio {

	public static void main(String[] args) throws EccezioneVenditaNonFinalizzabile {
			
		Agenzia a = new Agenzia();
		
		System.out.println("/***********************************/");
		System.out.println("/**           R1. SCHEDE          **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("* Creazione scheda immobile");
		
		SchedaImmobile s1 = a.creaScheda("Torino", "Corso Duca degli Abruzzi 21", "Appartamento", 4, 100, "Luminoso appartamento vicino al Politecnico.");
				
		System.out.println("\n* Informazioni:\n");

		System.out.println("Comune: "+s1.getComune());
		System.out.println("Indirizzo: "+s1.getIndirizzo());
		System.out.println("Tipologia: "+s1.getTipologia());
		System.out.println("Numero di locali: "+s1.getLocali());
		System.out.println("Superficie: "+s1.getSuperficie()+" m^2");
		System.out.println("Descrizione: "+s1.getDescrizione());
		
		System.out.println("\n* Identificativo assegnato");

		System.out.println("\n"+s1.getIdSchedaImmobile());

		System.out.println("\n* Aggiornamento scheda immobile "+s1.getIdSchedaImmobile());

		System.out.println("\n* Informazioni (aggiornate):\n");

		a.aggiornaScheda(s1.getIdSchedaImmobile(), 105, "Luminoso appartamento per studenti del Poli.");	

		System.out.println("Superficie: "+s1.getSuperficie()+" m^2");
		System.out.println("Descrizione: "+s1.getDescrizione());

 		System.out.println("\n* Creazione altre schede immobile");
		
 		SchedaImmobile s2 = a.creaScheda("Torino", "Corso Vinzaglio 36", "Appartamento", 3, 70, "Trilocale ideale per vita studentesca.");
 		SchedaImmobile s3 = a.creaScheda("Alba", "Via Piave 125", "Appartamento", 5, 140, "Ampia metratura nella terra dei vini.");
		a.creaScheda("Torino", "Via Roma 1", "Appartamento", 4, 200, "Attico in pieno centro.");

		System.out.println("\n* Elenco schede (ordinate per identificativo)\n");
		
		LinkedList<SchedaImmobile> listaSchede = new LinkedList<SchedaImmobile>(a.elencoSchedeOrdineDiIdentificativo());
		for(SchedaImmobile s : listaSchede)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		
		System.out.println("\n\n/***********************************/");
		System.out.println("/**         R2. RICERCHE          **/");
		System.out.println("/***********************************/\n");

		System.out.println("* Cercate schede immobile contenenti 'student'");

		System.out.println("\n* Schede trovate (ordinate per identificativo):\n");
		
		LinkedList<SchedaImmobile> listaSchedeTrovate = new LinkedList<SchedaImmobile>(a.ricercaSchedeTesto("student"));
		for(SchedaImmobile s : listaSchedeTrovate)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());

		System.out.println("\n* Impostati criteri di ricerca (da 4 a 5 locali, da 120 a 250 m^2)");
		
		a.impostaCriterio('L', true, 4, 5);
		a.impostaCriterio('S', true, 120, 250);
		
		System.out.println("\n* Cercate schede con i criteri impostati");

		System.out.println("\n* Schede trovate (ordinate per identificativo):\n");
		
		listaSchedeTrovate = new LinkedList<SchedaImmobile>(a.ricercaSchedeCriteri());
		for(SchedaImmobile s : listaSchedeTrovate)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());


		System.out.println("\n\n/***********************************/");
		System.out.println("/**    R3. CLIENTI E TRANSAZIONI  **/");
		System.out.println("/***********************************/\n");

		System.out.println("* Definiti clienti RSSMAR77S66H555V e VRDNNA11T22L333G");
		
		a.nuovoCliente("RSSMAR77S66H555V", "Rossi", "Mario");
		a.nuovoCliente("VRDNNA11T22L333G", "Verdi", "Anna");
		
		System.out.println("\n* Definita trensazione di vendita tra i due clienti dell'immobile "+s1.getIdSchedaImmobile());

		int idt1 = a.nuovaTransazioneDiVendita(s1.getIdSchedaImmobile(), "RSSMAR77S66H555V", "VRDNNA11T22L333G", 300000);
		
		System.out.println("\n* Informazioni transazione:\n");
		
		System.out.println("Identificativo transazione: "+idt1);
		System.out.println("Identificativo immobile: "+a.schedaImmobileTransazione(idt1).getIdSchedaImmobile());
		System.out.println("Codice fiscale venditore: "+a.venditoreTransazione(idt1).getCodiceFiscale());
		System.out.println("Codice fiscale acquirente: "+a.acquirenteTransazione(idt1).getCodiceFiscale());
		System.out.println("Importo: "+a.importoTransazione(idt1)+ "euro");

		System.out.println("\n* Definite altre transazioni");

		a.nuovaTransazioneDiVendita(s2.getIdSchedaImmobile(), "RSSMAR77S66H555V", "VRDNNA11T22L333G", 200000);
		a.nuovaTransazioneDiVendita(s3.getIdSchedaImmobile(), "VRDNNA11T22L333G", "RSSMAR77S66H555V", 400000);

		
		System.out.println("\n* Stampa transazioni (per importo ed identificativo scheda immobile):\n");
		String transazioni = a.stampaTransazioniOrdineDiImportoIdScheda();
		System.out.println(""+transazioni);

		System.out.println("\n\n/***********************************/");
		System.out.println("/**            R4. INTROITI         **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("* Introiti calcolati con percentuale di riferimento al 5%:");
		double introiti = a.calcolaIntroiti(5);
		
		System.out.println("\n"+introiti);
		
		System.out.println("\n/***********************************/");
		System.out.println("/**     R5. LETTURA DA FILE       **/");
		System.out.println("/***********************************/");

		System.out.println("\nLettura dati da file e costruzione struttura dati");
		a.leggiDaFile("input.txt");		

		
		System.out.println("\n* Elenco clienti (ordinati per codice fiscale)\n");
		
		LinkedList<Cliente> listaClienti = new LinkedList<Cliente>(a.elencoClientiOrdineDiCodiceFiscale());
		for(Cliente c : listaClienti)
			System.out.println(c.getCodiceFiscale()+" "+c.getCognome()+" "+c.getNome());

		System.out.println("\n* Elenco schede (ordinate per identificativo)\n");
		
		listaSchede = new LinkedList<SchedaImmobile>(a.elencoSchedeOrdineDiIdentificativo());
		for(SchedaImmobile s : listaSchede)
			System.out.println(s.getIdSchedaImmobile()+", "+s.getIndirizzo()+", "+s.getLocali()+" locali, "+s.getSuperficie()+" m^2, "+s.getDescrizione());
		
		
		System.out.println("\n* Stampa transazioni (per importo ed identificativo scheda immobile):\n");
		transazioni = a.stampaTransazioniOrdineDiImportoIdScheda();
		System.out.println(""+transazioni);
		
		
	}

}
