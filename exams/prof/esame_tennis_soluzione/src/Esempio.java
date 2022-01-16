import tennis.*;
import java.util.*;

public class Esempio {

	public static void main(String[] args) throws Exception{

		/* ### R1 - TORNEI, TURNI, SQUADRE E GIOCATORI ### */

		System.out.println("### R1 - TORNEI, TURNI, SQUADRE E GIOCATORI ###");

		System.out.println("\nCreo torneo a 16 squadre, con sfide di 3 incontri ciascuna al meglio dei 5 set");
		Torneo torneo = new Torneo("Coppa Davis 2013 - Gruppo Mondiale", 16, 3, 5);
		System.out.println("Torneo creato: "+torneo.getNome());
		
		System.out.println("\nAggiungo una squadra al torneo");
		Squadra squadra = torneo.aggiungiSquadra("Italia");
		System.out.println("Squadra aggiunta: "+squadra.getNome());

		System.out.println("\nAggiungo un'altra squadra al torneo");
		                  torneo.aggiungiSquadra("Stati Uniti");
		squadra = torneo.getSquadra("Stati Uniti");        
		System.out.println("Squadra aggiunta: "+squadra.getNome());
		
		System.out.println("\nElenco squadre aggiunte:");
		List<Squadra> squadre = new LinkedList<Squadra>(torneo.elencoSquadre());
		for(int i=0;i<squadre.size();i++)
			System.out.println(" "+squadre.get(i).getNome());
		
		System.out.println("\nIscrivo un giocatore al torneo (squadra di appartenenza Italia)");
		Giocatore bolelli = torneo.iscriviGiocatore("Simone", "Bolelli", "Italia");
		System.out.println("Giocatore iscritto: "+bolelli.getNome()+" "+bolelli.getCognome()+", "+bolelli.getSquadra().getNome());

		System.out.println("\nIscrivo altri tre giocatori");
		Giocatore fognini = torneo.iscriviGiocatore("Fabio", "Fognini", "Italia");
		Giocatore seppi =   torneo.iscriviGiocatore("Andreas", "Seppi", "Italia");
                    		torneo.iscriviGiocatore("Paolo", "Lorenzi", "Italia");

        System.out.println("\nElenco giocatori iscritti:");
        List<Giocatore> giocatori = new LinkedList<Giocatore>(torneo.elencoGiocatori());
        for(Giocatore g : giocatori)
        	System.out.println(" "+g.getCognome()+" "+g.getNome()+", "+g.getSquadra());

        List<Turno> turni = new LinkedList<Turno>(torneo.elencoTurni());
		System.out.println("\nCalcolo il numero di turni del torneo (a 16 squadre)");
		System.out.println("Numero di turni: "+turni.size());

		/* ### R2 - SFIDE ### */
		
		System.out.println("\n### R2 - SFIDE ###");

		System.out.println("\nAggiungo una sfida al primo turno");
		Sfida sfida = torneo.aggiungiSfida(1, "Italia", "Croazia");
		System.out.println("Sfida aggiunta: "+sfida.getSquadraCasa()+"-"+sfida.getSquadraOspite());

		System.out.println("\nAggiungo altre due sfide al primo turno, Stati Uniti-Brasile e Svizzera-Repubblica Ceca");
		torneo.aggiungiSfida(1, "Stati Uniti", "Brasile");
		torneo.aggiungiSfida(1, "Svizzera", "Repubblica Ceca");

		System.out.println("\nSquadre aggiunte (o create automaticamente) con le sfide:");
		squadre = new LinkedList<Squadra>(torneo.elencoSquadre());
		for(int i=0;i<squadre.size();i++)
			System.out.println(" "+squadre.get(i).getNome());
		
		System.out.println("\nAggiungo quattro giocatori (squadra di appartenenza Croazia)");
		Giocatore cilic   = torneo.iscriviGiocatore("Marin", "Cilic", "Croazia");
		Giocatore dodig   = torneo.iscriviGiocatore("Ivan", "Dodig", "Croazia");
		Giocatore pavic   = torneo.iscriviGiocatore("Mate", "Pavic", "Croazia");
		                    torneo.iscriviGiocatore("Nikola", "Mektic", "Croazia");

		System.out.println("\nSeleziono la sfida Italia-Croazia ed imposto luogo e date di svolgimento");                    
		sfida = torneo.getSfida("Italia", "Croazia");
		sfida.setLuogo("Torino");
		sfida.setDataDa("20130201");
		sfida.setDataA("20130203");
		System.out.println(" Luogo: "+sfida.getLuogo());
		System.out.println(" Dal:   "+sfida.getDataDa());
		System.out.println(" Al:    "+sfida.getDataA());

		System.out.println("\nImposto luogo e data per le altre due sfide aggiunte");
		sfida = torneo.getSfida("Svizzera", "Repubblica Ceca");
		sfida.setLuogo("Ginevra");
		sfida.setDataDa("20130201");
		sfida.setDataA("20130203");
		
		sfida = torneo.getSfida("Stati Uniti", "Brasile");
		sfida.setLuogo("Jacksonville");
		sfida.setDataDa("20130131");
		sfida.setDataA("20130202");

		System.out.println("\nElenco delle sfide al primo turno");
		List<Sfida> sfide = new LinkedList<Sfida>(torneo.elencoSfide(1));
		for(int i=0;i<sfide.size();i++)
			System.out.println(" "+sfide.get(i).getDataDa()+" "+sfide.get(i).getSquadraCasa().getNome()+"-"+sfide.get(i).getSquadraOspite().getNome());

		/* ### R3 - INCONTRI ### */
		
		System.out.println("\n### R3 - INCONTRI ###");
		
		/* Dettagli sfida Italia - Croazia */

		System.out.println("\nAggiungo incontri alla sfida Italia-Croazia (due singoli ed un doppio)");
		sfida = torneo.getSfida("Italia", "Croazia");

		torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		torneo.aggiungiIncontro(1, "Italia", "Croazia", 's');
		torneo.aggiungiIncontro(1, "Italia", "Croazia", 'd');
		
		List<Incontro> incontri = new LinkedList<Incontro>(sfida.elencoIncontri());
		System.out.println("Numero di incontri aggiunti: "+incontri.size()+"\n");

			/* Dettagli primo incontro (singolo) */
			
			Incontro incontro1 = sfida.getIncontro(1);
			incontro1.setData("20130201");
			incontro1.setOra("11:00");
			incontro1.aggiungiGiocatore(bolelli);
			incontro1.aggiungiGiocatore(cilic);
	
			System.out.println(" Primo incontro: ");
			System.out.println("  Data: "+incontro1.getData());
			System.out.println("  Ora:  "+incontro1.getOra());
			if(incontro1 instanceof Singolo)
				System.out.println("  Tipologia: Singolo");
			else if(incontro1 instanceof Doppio)
				System.out.println("  Tipologia: Doppio");
			
			List<Giocatore> giocatori1 = new LinkedList<Giocatore>(incontro1.elencoGiocatori());
			System.out.print("  Giocatori: ");
			for(int i=0;i<giocatori1.size();i++){
				System.out.print(""+giocatori1.get(i).getNome()+" "+giocatori1.get(i).getCognome()+" ("+giocatori1.get(i).getSquadra().getNome()+")");
				if(i<giocatori1.size()-1)
					System.out.print(", ");
			}
			
			incontro1.setPunteggio("6-1 1-6 5-7 4-6");
			System.out.println("\n  Punteggio: "+incontro1.getPunteggio());
			
			if(incontro1.getVincitore()!=null)
				System.out.println("  Squadra vincitrice incontro: "+incontro1.getVincitore());
			else
				System.out.println("  Squadra vincitrice incontro: [Incontro ancora in corso]");

			System.out.println("");
			
			/* Dettagli secondo incontro (singolo) */
			
			Incontro incontro2 = sfida.getIncontro(2);
	
			incontro2.aggiungiGiocatore(fognini);
			incontro2.aggiungiGiocatore(pavic);
	
			System.out.println(" Secondo incontro: ");
			
			List<Giocatore> giocatori2 = new LinkedList<Giocatore>(incontro2.elencoGiocatori());
			System.out.print("  Giocatori: ");
			for(int i=0;i<giocatori2.size();i++){
				System.out.print(""+giocatori2.get(i).getNome()+" "+giocatori2.get(i).getCognome()+" ("+giocatori2.get(i).getSquadra().getNome()+")");
				if(i<giocatori2.size()-1)
					System.out.print(", ");
			}
	
			incontro2.setPunteggio("6-4 6-3 6-4");
			System.out.println("\n  Punteggio: "+incontro2.getPunteggio());

			if(incontro2.getVincitore()!=null)
				System.out.println("  Squadra vincitrice incontro: "+incontro2.getVincitore());
			else
				System.out.println("  Squadra vincitrice incontro: [Incontro ancora in corso]");
			
			System.out.println("");
			
			/* Dettagli terzo incontro (doppio) */
			
			Incontro incontro3 = sfida.getIncontro(3);
	
			incontro3.aggiungiGiocatore(fognini);
			incontro3.aggiungiGiocatore(seppi);
			incontro3.aggiungiGiocatore(cilic);
			incontro3.aggiungiGiocatore(dodig);
	
			System.out.println(" Terzo incontro: ");
			
			List<Giocatore> giocatori3 = new LinkedList<Giocatore>(incontro3.elencoGiocatori());
			System.out.print("  Giocatori: ");
			for(int i=0;i<giocatori3.size();i++){
				System.out.print(""+giocatori3.get(i).getNome()+" "+giocatori3.get(i).getCognome()+" ("+giocatori3.get(i).getSquadra().getNome()+")");
				if(i<giocatori3.size()-1)
					System.out.print(", ");
			}
	
			incontro3.setPunteggio("1-6 5-7");
			System.out.println("\n  Punteggio (parziale): "+incontro3.getPunteggio());
			
			if(incontro3.getVincitore()!=null)
				System.out.println("  Squadra vincitrice incontro: "+incontro3.getVincitore());
			else
				System.out.println("  Squadra vincitrice incontro: [Incontro ancora in corso]");
			
			incontro3.setPunteggio("1-6 5-7 6-1 6-0 6-0");
			System.out.println("  Punteggio (finale): "+incontro3.getPunteggio());

			if(incontro3.getVincitore()!=null)
				System.out.println("  Squadra vincitrice incontro: "+incontro3.getVincitore());
			else
				System.out.println("  Squadra vincitrice incontro: [Incontro ancora in corso]");

		/* ### R4 - RISULTATI ### */
		
		System.out.println("\n### R4 - RISULTATI ###");

		System.out.println("\nPunteggio sfida Italia-Croazia: "+sfida.getPunteggio());
		
		if(sfida.getVincitore()!=null)
			System.out.println("\nSquadra vincitrice sfida: "+sfida.getVincitore());
		else
			System.out.println("\nSquadra vincitrice sfida: [Sfida ancora in corso]");
		
	}

}
