

import java.util.*;

import palinsesti.*;

public class Esempio {

	public static void main(String[] args) throws ProgrammaInesistenteException, PalinsestoInesistenteException {

		GestionePalinsesti gp = new GestionePalinsesti();

		System.out.println("******************************************");
		System.out.println("*             R1. PALINSESTI             *");
		System.out.println("******************************************");
		
		System.out.println("\nDefinito nuovo palinsesto");
		Palinsesto p = gp.definisciPalinsesto("Autunno/Inverno", "Canale 5", "20180921", "20190320");

		System.out.println("\nDettagli palinsesto:");
		System.out.println(" Nome: "+p.getNome());
		System.out.println(" Canale: "+p.getCanale());
		System.out.println(" Da: "+p.getDa());
		System.out.println(" A: "+p.getA());

		System.out.println("\nCerca palinsesto 'Autunno/Inverno' 'Canale 5'");
		p = gp.cercaPalinsesto("Autunno/Inverno","Canale 5");
		
		System.out.println("\nPalinsesto trovato:");
		System.out.println(" Nome: "+p.getNome());
		System.out.println(" Canale: "+p.getCanale());
		System.out.println(" Da: "+p.getDa());
		System.out.println(" A: "+p.getA());
		
		System.out.println("\nDefiniti altri palinsesti");
		gp.definisciPalinsesto("Autunno/Inverno", "Italia 1", "20180901", "20190228");
		gp.definisciPalinsesto("Natale", "Rete 4", "20181224", "20190106");
		gp.definisciPalinsesto("Autunno/Inverno", "Italia 2", "20180901", "20190228");

		System.out.println("\nElenco palinsesti (ordine di inserimento):");
		LinkedList<Palinsesto> listaPalinsesti = new LinkedList<Palinsesto>(gp.elencoPalinsesti());
		for(Palinsesto ptemp : listaPalinsesti){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getCanale()+", "+ptemp.getDa()+", "+ptemp.getA());
		}

		System.out.println("\nCerca palinsesti 'alia'");
		listaPalinsesti = new LinkedList<Palinsesto>(gp.cercaPalinsesti("alia"));
		for(Palinsesto ptemp : listaPalinsesti){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getCanale()+", "+ptemp.getDa()+", "+ptemp.getA());
		}

		System.out.println("\n\n******************************************");
		System.out.println("*              R2. PROGRAMMI             *");
		System.out.println("******************************************");

		
		System.out.println("\nDefinito nuovo programma palinsesto 'Autunno/Inverno' per 'Canale 5'");
		String ida = gp.definisciProgramma("Autunno/Inverno", "Canale 5", "Finale Champions League", "Partita di calcio");
		System.out.println("\nId assegnato: ");
		System.out.println(" "+ida);

		System.out.println("\nCerca programma '"+ida+"'");
		Programma pr = gp.cercaProgramma(ida);
		
		System.out.println("\nProgramma trovato:");
		System.out.println(" Id: "+pr.getId());
		System.out.println(" Nome programma: "+pr.getNome());
		if(pr instanceof PartitaCalcio)
			System.out.println(" Tipo: Partita di calcio");
		else if(pr instanceof SerieTv)
			System.out.println(" Tipo: Serie TV");
		else
			System.out.println(" Tipo: N/D");
		System.out.println(" Palinsesto: "+pr.getPalinsesto().getNome());
		System.out.println(" Canale: "+pr.getPalinsesto().getCanale());
					
		System.out.println("\nDefiniti altri programmi");
		String idb = gp.definisciProgramma("Natale", "Rete 4", "Telegiornale delle dodici", "Generico");
		             gp.definisciProgramma("Autunno/Inverno", "Canale 5", "Partita del cuore", "Partita calcio");
		             gp.definisciProgramma("Autunno/Inverno", "Italia 1", "C.S.I. Miami", "Serie TV");

		System.out.println("\nElenco programmi (ordinati per nome programma, nome palinsesto e canale):");
		LinkedList<Programma> listaProgrammi = new LinkedList<Programma>(gp.elencoProgrammi());
		for(Programma ptemp : listaProgrammi){
			System.out.println(" ("+ptemp.getId()+") "+ptemp.getNome()+", "+ptemp.getPalinsesto().getNome()+", "+ptemp.getPalinsesto().getCanale());
		}

		
		System.out.println("\n\n******************************************");
		System.out.println("*           R3. PROGRAMMAZIONE           *");
		System.out.println("******************************************");

		
		System.out.println("\nDefinisci programmazione saltuaria programma '"+ida+"'");
		gp.definisciProgrammazioneSaltuaria(ida, "20180926", "2045", 120);

		System.out.println("\nStampa del palinsesto 'Autunno/Inverno' di 'Canale 5'");
		String risultato = gp.stampaPalinsesto("Autunno/Inverno", "Canale 5");
		System.out.println(" "+risultato);

		System.out.println("\nDefinisci programmazione giornaliera '"+idb+"'");
		gp.definisciProgrammazioneGiornaliera(idb, "1200", 30);

		System.out.println("\nStampa del palinsesto 'Natale' di 'Rete 4'");
		risultato = gp.stampaPalinsesto("Natale", "Rete 4");
		System.out.println(""+risultato);

		System.out.println("\n\n******************************************");
		System.out.println("*           R4. LETTURA DA FILE          *");
		System.out.println("******************************************");

		System.out.println("\nLettura da file");
		gp.leggi("input.txt");
		
		System.out.println("\nElenco palinsesti (ordine di inserimento):");
		listaPalinsesti = new LinkedList<Palinsesto>(gp.elencoPalinsesti());
		for(Palinsesto ptemp : listaPalinsesti){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getCanale()+", "+ptemp.getDa());
		}

		System.out.println("\nElenco programmi (ordinati per nome programma, nome palinsesto e canale):");
		listaProgrammi = new LinkedList<Programma>(gp.elencoProgrammi());
		for(Programma ptemp : listaProgrammi){
			System.out.println(" "+ptemp.getNome()+", "+ptemp.getPalinsesto().getNome()+", "+ptemp.getPalinsesto().getCanale());
		}

	}

}

