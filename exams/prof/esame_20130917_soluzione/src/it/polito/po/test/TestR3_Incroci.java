package it.polito.po.test;

import ufficiotecnico.*;

import junit.framework.TestCase;
import java.util.*;

public class TestR3_Incroci extends TestCase {

	BaseDatiTopografica bdt;
	ElementoTopografico et;
	List<ElementoTopografico> listaElementiTopografici;

	public void setUp(){
		
		bdt = new BaseDatiTopografica();
    }
	
	public void testDefinisciIncrocioPossibile() throws EccezioneElementoTopograficoInesistente {

		System.out.println("\n*** testDefinisciIncrocioPossibile() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		int primoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		((Strada)et).setNome("Orbassano, Largo");
		((Strada)et).setLunghezza(700);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		int secondoCodice = et.getCodice();
		
		System.out.println("\nElenco alfabetico di tutti gli elementi topografici:");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoElementiTopografici());
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}

		boolean flagEccezione=false;

		System.out.println("\nDefinisco incrocio Roma, Via - Orbassano, Largo (controllato da semafori)");
		try {
			bdt.definisciIncrocio(primoCodice, secondoCodice, true);
			System.out.println("Incrocio aggiunto");
		} catch (EccezioneIncrocioImpossibile eii) {
			System.out.println("Scatenata EccezioneIncrocioImpossibile");
			flagEccezione=true;
		}

		if(flagEccezione==false)
			System.out.println("\nIncrocio correttamente aggiunto");
		else
			System.out.println("\nIncrocio erroneamente non aggiunto");

		assertEquals("\nIncrocio erroneamente non aggiunto.",false,flagEccezione);
	}

	public void testDefinisciIncrocioImpossibile() throws EccezioneElementoTopograficoInesistente {

		System.out.println("\n*** testDefinisciIncrocioImpossibile() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo piazza");
		et = bdt.aggiungiElementoTopografico("PiAzzA");
		((Piazza)et).setNome("Napoli, Piazza");
		((Piazza)et).setForma("Rettangolare");
		((Piazza)et).setEstensione(3500);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Piazza)et).getNome());
		System.out.println(" Forma: "+((Piazza)et).getForma());
		System.out.println(" Estensione: "+((Piazza)et).getEstensione()+" m^2");
		int primoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo piazza");
		et = bdt.aggiungiElementoTopografico("PIAZZA");
		((Piazza)et).setNome("Capri, Piazza");
		((Piazza)et).setForma("Quadrata");
		((Piazza)et).setEstensione(4000);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Piazza)et).getNome());
		System.out.println(" Forma: "+((Piazza)et).getForma());
		System.out.println(" Estensione: "+((Piazza)et).getEstensione()+" m^2");
		int secondoCodice = et.getCodice();
		
		System.out.println("\nElenco alfabetico di tutti gli elementi topografici:");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoElementiTopografici());
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}

		boolean flagEccezione=false;

		System.out.println("\nDefinisco incrocio Napoli, Piazza - Capri, Piazza (controllato da semafori)");
		try {
			bdt.definisciIncrocio(primoCodice, secondoCodice, true);
			System.out.println("Incrocio aggiunto");
		} catch (EccezioneIncrocioImpossibile eii) {
			System.out.println("Scatenata EccezioneIncrocioImpossibile");
			flagEccezione=true;
		}

		if(flagEccezione==true)
			System.out.println("\nIncrocio correttamente non aggiunto");
		else
			System.out.println("\nIncrocio erroneamente aggiunto");

		assertEquals("\nIncrocio erroneamente aggiunto.",true,flagEccezione);
	}		


	public void testElencoIncroci() throws EccezioneElementoTopograficoInesistente, EccezioneIncrocioImpossibile {

		System.out.println("\n*** testElencoIncroci() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		int primoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo piazza");
		et = bdt.aggiungiElementoTopografico("PiAzzA");
		((Piazza)et).setNome("Napoli, Piazza");
		((Piazza)et).setForma("Rettangolare");
		((Piazza)et).setEstensione(3500);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Piazza)et).getNome());
		System.out.println(" Forma: "+((Piazza)et).getForma());
		System.out.println(" Estensione: "+((Piazza)et).getEstensione()+" m^2");
		int secondoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		((Strada)et).setNome("Orbassano, Largo");
		((Strada)et).setLunghezza(700);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		int terzoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("STRADA");
		((Strada)et).setNome("Firenze, Via");
		((Strada)et).setLunghezza(1000);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		int quartoCodice = et.getCodice();
		
		System.out.println("\nElenco alfabetico di tutti gli elementi topografici:");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoElementiTopografici());
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}

		System.out.println("\nDefinisco incrocio Roma, Via - Orbassano, Largo (controllato da semafori)");
		bdt.definisciIncrocio(primoCodice, terzoCodice, true);

		System.out.println("Definisco incrocio Roma, Via - Napoli, Piazza (non controllato da semafori)");
		bdt.definisciIncrocio(primoCodice, secondoCodice, false);
		
		System.out.println("Definisco incrocio Roma, Via - Firenze, Via (controllato da semafori)");
		bdt.definisciIncrocio(primoCodice, quartoCodice, true);
		
		System.out.println("\nElenco degli incroci con Roma, Via (prima le strade in ordine alfabetico, poi le piazze):");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoIncroci(primoCodice));
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}	
			
		boolean flagCorretto=false;
		if(listaElementiTopografici.get(0).getNome().compareTo("Firenze, Via")==0 &&
				listaElementiTopografici.get(1).getNome().compareTo("Orbassano, Largo")==0 &&
						listaElementiTopografici.get(2).getNome().compareTo("Napoli, Piazza")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco incroci corretto");
		else
			System.out.println("\nElenco incroci errato");

		assertEquals("\nElenco incroci errato.",true,flagCorretto);
	}
	
	public void testEliminaIncrocio() throws EccezioneElementoTopograficoInesistente, EccezioneIncrocioImpossibile {

		System.out.println("\n*** testEliminaIncrocio() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		int primoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo piazza");
		et = bdt.aggiungiElementoTopografico("PiAzzA");
		((Piazza)et).setNome("Napoli, Piazza");
		((Piazza)et).setForma("Rettangolare");
		((Piazza)et).setEstensione(3500);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Piazza)et).getNome());
		System.out.println(" Forma: "+((Piazza)et).getForma());
		System.out.println(" Estensione: "+((Piazza)et).getEstensione()+" m^2");
		int secondoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		((Strada)et).setNome("Orbassano, Largo");
		((Strada)et).setLunghezza(700);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		int terzoCodice = et.getCodice();
		
		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("STRADA");
		((Strada)et).setNome("Firenze, Via");
		((Strada)et).setLunghezza(1000);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		int quartoCodice = et.getCodice();
		
		System.out.println("\nElenco alfabetico di tutti gli elementi topografici:");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoElementiTopografici());
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}

		System.out.println("\nDefinisco incrocio Roma, Via - Orbassano, Largo (controllato da semafori)");
		bdt.definisciIncrocio(primoCodice, terzoCodice, true);

		System.out.println("Definisco incrocio Roma, Via - Napoli, Piazza (non controllato da semafori)");
		bdt.definisciIncrocio(primoCodice, secondoCodice, false);
		
		System.out.println("Definisco incrocio Roma, Via - Firenze, Via (controllato da semafori)");
		bdt.definisciIncrocio(primoCodice, quartoCodice, true);
		
		System.out.println("\nElenco degli incroci con Roma, Via (prima le strade in ordine alfabetico, poi le piazze):");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoIncroci(primoCodice));
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}	

		System.out.println("\nElimino incrocio Roma, Via - Firenze, Via");
		bdt.eliminaIncrocio(primoCodice, quartoCodice);

		System.out.println("\nElenco degli incroci con Roma, Via (prima le strade in ordine alfabetico, poi le piazze):");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoIncroci(primoCodice));
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}	

		boolean flagCorretto=false;
		if(listaElementiTopografici.get(0).getNome().compareTo("Orbassano, Largo")==0 &&
						listaElementiTopografici.get(1).getNome().compareTo("Napoli, Piazza")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco incroci dopo eliminazione corretto");
		else
			System.out.println("\nElenco incroci dopo eliminazione errato");

		assertEquals("\nElenco incroci dopo eliminazione errato.",true,flagCorretto);
	}

}
