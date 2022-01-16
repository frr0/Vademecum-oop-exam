import java.util.*;

import piscine.*;

public class Esempio {

	public static void main(String[] args) throws EccezioneTipoPostoEsaurito {
			
		GestionePrenotazioni gp = new GestionePrenotazioni();
		
		System.out.println("/***********************************/");
		System.out.println("/**      R1. PISCINE E POSTI      **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("* Definita nuova piscina in Via Bellacqua 33, Torino");
		
		Piscina p1 = gp.definisciPiscina("Via Bellacqua 33, Torino", 9, 6, 4);

		System.out.println("\n* Informazioni relative alla piscina\n");

		System.out.println("Codice: "+p1.getCodice());
		System.out.println("Indirizzo: "+p1.getIndirizzo());
		System.out.println("Num. posti bordo piscina: "+p1.getNumPostiBordoPiscina());
		System.out.println("Num. posti prato: "+p1.getNumPostiPrato());
		System.out.println("Max occupanti posto: "+p1.getMaxOccupantiPosto());
		
		System.out.println("\n* Definite altre piscine");
		             gp.definisciPiscina("Strada Acquafresca 11, Milano", 20, 10, 2);
		             gp.definisciPiscina("Via Secchezza 88, Palermo", 10, 3, 3);
		
		System.out.println("\n* Elenco piscine (ordine di definizione):\n");
		LinkedList<Piscina> listaPiscine = new LinkedList<Piscina>(gp.elencoPiscine());
		for(Piscina pi : listaPiscine) {
			System.out.println(pi.getIndirizzo());
		}
		             
		System.out.println("\n* Elenco posti bordo piscina - Via Bellacqua 33, Torino:\n");
		LinkedList<Posto> listaPosti = new LinkedList<Posto>(gp.elencoPostiBordoPiscina("Via Bellacqua 33, Torino"));
		for(Posto po : listaPosti) {
			System.out.println(po.getNumero());
		}
		
		System.out.println("\n* Elenco posti prato - Via Bellacqua 33, Torino:\n");
		                  listaPosti = new LinkedList<Posto>(gp.elencoPostiPrato("Via Bellacqua 33, Torino"));
		for(Posto p : listaPosti) {
			System.out.println(p.getNumero());
		}
		
		System.out.println("\n* Cerca posto P1 - Via Bellacqua 33, Torino\n");
		Posto pP1 = gp.cercaPosto("Via Bellacqua 33, Torino", "P1");
		if(pP1 instanceof PostoPrato) {
			System.out.println("Tipo posto: prato");
		}
		else if(pP1 instanceof PostoBordo)
		{
			System.out.println("Tipo posto: bordo piscina");
			if(((PostoBordo)pP1).getOmbrellone()) System.out.println("Ombrellone: presente"); else System.out.println("Ombrellone: assente");
			System.out.println("Numero lettini: "+((PostoBordo)pP1).getNumLettini());
		}
			
		System.out.println("\n* Configura posto B4 - Via Bellacqua 33, Torino (ombrellone presente, 2 lettini)");
		gp.configuraPosto("Via Bellacqua 33, Torino", "B4", true, 2);
		
		System.out.println("\n* Cerca posto B4 - Via Bellacqua 33, Torino\n");
		Posto pB4 = gp.cercaPosto("Via Bellacqua 33, Torino", "B4");
		if(pB4 instanceof PostoPrato) {
			System.out.println("Tipo posto: prato");
		}
		else if(pB4 instanceof PostoBordo)
		{
			System.out.println("Tipo posto: bordo piscina");
			if(((PostoBordo)pB4).getOmbrellone()) System.out.println("Ombrellone: presente"); else System.out.println("Ombrellone: assente");
			System.out.println("Numero lettini: "+((PostoBordo)pB4).getNumLettini());
		}
		
		
		System.out.println("\n/***********************************/");
		System.out.println("/**        R2. PRENOTAZIONI       **/");
		System.out.println("/***********************************/\n");

		System.out.println("* Nuova prenotazione - Via Bellacqua 33, Torino - data 20200915 - posto tipo B \n");
		String cp1 = gp.nuovaPrenotazione("Via Bellacqua 33, Torino", "20200915", 'B', "Mario", "Blu", "+39333666666");

		System.out.println("* Codice prenotazione: "+cp1+"\n");

		System.out.println("* Informazioni prenotazione\n");
		System.out.println("Codice creato: "+cp1);
		System.out.println("Piscina: "+gp.piscinaPrenotazione(cp1).getIndirizzo());
		System.out.println("Data: "+gp.dataPrenotazione(cp1));
		System.out.println("Posto assegnato: "+gp.postoPrenotazione(cp1).getNumero());

		System.out.println("\n* Nuova prenotazione - stessa piscina, stessa data, stesso tipo di posto \n");
		String cp2 = gp.nuovaPrenotazione("Via Bellacqua 33, Torino", "20200915", 'B', "Gianna", "Rossi", "+39333444444");

		System.out.println("* Informazioni prenotazione\n");
		System.out.println("Codice creato: "+cp2);
		System.out.println("Piscina: "+gp.piscinaPrenotazione(cp2).getIndirizzo());
		System.out.println("Data: "+gp.dataPrenotazione(cp2));
		System.out.println("Posto assegnato: "+gp.postoPrenotazione(cp2).getNumero());

		
		System.out.println("\n\n/***********************************/");
		System.out.println("/**           R3. STAMPE          **/");
		System.out.println("/***********************************/\n");

		System.out.println("* Stampa dettagli per la prenotazione "+cp2+"\n");

		String stampaPrenotazione = gp.stampaPrenotazione(cp2);
		System.out.println(stampaPrenotazione);

		System.out.println("\n* Stampa dettagli per tutte le prenotazioni (ordine di codice pren.)\n");
		
		String stampaPrenotazioni = gp.stampaPrenotazioniPerCodice();
		System.out.println(stampaPrenotazioni);
		
		System.out.println("\n* Stampa dettagli per tutte le prenotazioni (ordine di cognome - nome)\n");
		
		       stampaPrenotazioni = gp.stampaPrenotazioniPerCognomeNome();
		System.out.println(stampaPrenotazioni);
		
		System.out.println("\n* Stampa date prenotate per Via Bellacqua 33, Torino - posto B1 (ordine di data)\n");

		String stampaDate = gp.stampaDatePrenotatePosto("Via Bellacqua 33, Torino", "B1");
		System.out.println(stampaDate);
		
		System.out.println("\n* Stampa posti liberi per Via Bellacqua 33, Torino in data 20200915\n");

		String stampaNumPostiLiberi = gp.StampaNumeroPostiLiberiData("Via Bellacqua 33, Torino", "20200915");
		System.out.println(stampaNumPostiLiberi);
	
		
		System.out.println("\n\n/***********************************/");
		System.out.println("/**       R4. LETTURA DA FILE     **/");
		System.out.println("/***********************************/\n");
		
        gp.leggi("input.txt");
        
		System.out.println("* Stampa dettagli per tutte le prenotazioni (ordine di codice pren.)\n");
		
		       stampaPrenotazioni = gp.stampaPrenotazioniPerCodice();
		System.out.println(stampaPrenotazioni);
	}
}






