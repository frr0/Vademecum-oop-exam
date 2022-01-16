package it.polito.po.test;

import ufficiotecnico.*;

import junit.framework.TestCase;
import java.util.*;

public class TestR1_ElementiTopografici extends TestCase {

	BaseDatiTopografica bdt;
	ElementoTopografico et;
	List<ElementoTopografico> listaElementiTopografici;
	List<Strada> listaStrade;
	List<Piazza> listaPiazze;
	
	public void setUp(){
		
		bdt = new BaseDatiTopografica();
    }

	public void testAggiungiElementoTopografico() {
		
		System.out.println("\n*** testAggiungiElementoTopografico() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");

		assertNotNull("Errore nell'aggiunta dell'elemento topografico.",et);

		System.out.println("Aggiunto elemento topografico:");

		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		
		if(et instanceof Strada)
			System.out.println("Classe dell'elemento topografico restituito corretto");
		else
			System.out.println("Classe dell'elemento topografico restituito errato");
		
		assertEquals("Classe dell'elemento topografico restituito errata.","Strada",et.getClass().getSimpleName());
	}	
	
	public void testConfiguraStrada() {
		
		System.out.println("\n*** testConfiguraStrada() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");

		assertNotNull("Errore nell'aggiunta dell'elemento topografico.",et);

		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		
		System.out.println("\nImposto nome e lunghezza della strada");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println("Impostati nome e lunghezza:");
		System.out.println(" Nome: "+et.getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");

		if(et.getNome().compareTo("Roma, Via")==0)
			System.out.println("\nNome corretto");
		else
			System.out.println("\nNome errato");
		
		assertEquals("Nome errato.","Roma, Via",et.getNome());

		if(((Strada)et).getLunghezza()==1500)
			System.out.println("Lunghezza corretta");
		else
			System.out.println("Lunghezza errata");
		
		assertEquals("Lunghezza errata.",1500,((Strada)et).getLunghezza());
	}	
	
	public void testConfiguraPiazza() {
		
		System.out.println("\n*** testConfiguraPiazza() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo piazza");
		et = bdt.aggiungiElementoTopografico("PiAzZa");

		assertNotNull("Errore nell'aggiunta dell'elemento topografico.",et);

		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		
		if(et instanceof Piazza)
			System.out.println("Classe dell'elemento topografico restituito corretto");
		else
			System.out.println("Classe dell'elemento topografico restituito errato");
		
		assertEquals("Classe dell'elemento topografico restituito errata.","Piazza",et.getClass().getSimpleName());
		
		System.out.println("\nImposto nome, forma ed estensione della piazza");
		((Piazza)et).setNome("Napoli, Piazza");
		((Piazza)et).setForma("Rettangolare");
		((Piazza)et).setEstensione(3500);
		System.out.println("Impostati nome, forma ed estensione:");
		System.out.println(" Nome: "+((Piazza)et).getNome());
		System.out.println(" Forma: "+((Piazza)et).getForma());
		System.out.println(" Estensione: "+((Piazza)et).getEstensione()+" m^2");

		if(et.getNome().compareTo("Napoli, Piazza")==0)
			System.out.println("\nNome corretto");
		else
			System.out.println("\nNome errato");
		
		assertEquals("Nome errato.","Napoli, Piazza",et.getNome());

		if(((Piazza)et).getForma().compareTo("Rettangolare")==0)
			System.out.println("Forma corretta");
		else
			System.out.println("Forma errata");
		
		assertEquals("Forma errata.","Rettangolare",((Piazza)et).getForma());

		if(((Piazza)et).getEstensione()==3500.0)
			System.out.println("Estensione corretta");
		else
			System.out.println("Estensione errata");
		
		assertEquals("Estensione errata.",3500.0,((Piazza)et).getEstensione());
	}		

	public void testAggiungiPiuElementiTopografici() {
		
		System.out.println("\n*** testAggiungiPiuElementiTopografici() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

		int primoCodice = et.getCodice();
		
		System.out.println("\nAggiungo un altro elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

		int secondoCodice = et.getCodice();

		if(secondoCodice==primoCodice+1)
			System.out.println("\nIncremento del codice generato per l'elemento topografico corretto");
		else
			System.out.println("\nIncremento del codice generato per l'elemento topografico errato");
		
		assertEquals("Incremento del codice generato per l'elemento topografico errato.",primoCodice+1,secondoCodice);
		
		System.out.println("\nAggiungo elemento topografico di tipo piazza");
		et = bdt.aggiungiElementoTopografico("PIAZZA");
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

		    primoCodice = et.getCodice();
		
		System.out.println("\nAggiungo un altro elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("piazza");
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

		    secondoCodice = et.getCodice();

		if(secondoCodice==primoCodice+1)
			System.out.println("\nIncremento del codice generato per l'elemento topografico corretto");
		else
			System.out.println("\nIncremento del codice generato per l'elemento topografico errato");
		
		assertEquals("Incremento del codice generato per l'elemento topografico errato.",primoCodice+1,secondoCodice);
	}		
	
	public void testElencoElementiTopografici() {

		System.out.println("\n*** testElencoElementiTopografici() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		
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

		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		((Strada)et).setNome("Orbassano, Largo");
		((Strada)et).setLunghezza(700);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

		System.out.println("\nElenco alfabetico di tutti gli elementi topografici:");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoElementiTopografici());
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}		
		
		boolean flagCorretto=false;
		if(listaElementiTopografici.get(0).getNome().compareTo("Napoli, Piazza")==0 &&
				listaElementiTopografici.get(1).getNome().compareTo("Orbassano, Largo")==0 &&
						listaElementiTopografici.get(2).getNome().compareTo("Roma, Via")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco elementi topografici corretto");
		else
			System.out.println("\nElenco elementi topografici errato");

		assertEquals("\nElenco elementi topografici errato.",true,flagCorretto);
	}

	public void testElencoPiazze() {

		System.out.println("\n*** testElencoPiazze() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		
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

		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		((Strada)et).setNome("Orbassano, Largo");
		((Strada)et).setLunghezza(700);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

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
		
		System.out.println("\nElenco alfabetico delle piazze:");
		listaPiazze = new LinkedList<Piazza>(bdt.elencoPiazze());
		for(Piazza ptemp : listaPiazze){
			System.out.println(" "+ptemp.getNome());
		}
		
		boolean flagCorretto=false;
		if(listaPiazze.get(0).getNome().compareTo("Capri, Piazza")==0 &&
				listaPiazze.get(1).getNome().compareTo("Napoli, Piazza")==0 )
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco piazze corretto");
		else
			System.out.println("\nElenco piazze errato");

		assertEquals("\nElenco piazze errato.",true,flagCorretto);
	}	
	
	public void testElencoStradePerNome() {

		System.out.println("\n*** testElencoStradePerNome() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		
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

		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		((Strada)et).setNome("Orbassano, Largo");
		((Strada)et).setLunghezza(700);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("STRADA");
		((Strada)et).setNome("Firenze, Via");
		((Strada)et).setLunghezza(1000);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		
		System.out.println("\nElenco delle strade, ordinate per lunghezza:");
		listaStrade = new LinkedList<Strada>(bdt.elencoStradePerNome());
		for(Strada stemp : listaStrade){
			System.out.println(" "+stemp.getNome()+" ("+stemp.getLunghezza()+" m)");
		}

		boolean flagCorretto=false;
		if(listaStrade.get(0).getNome().compareTo("Firenze, Via")==0 &&
				listaStrade.get(1).getNome().compareTo("Orbassano, Largo")==0 &&
						listaStrade.get(2).getNome().compareTo("Roma, Via")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco strade corretto");
		else
			System.out.println("\nElenco strade errato");

		assertEquals("\nElenco strade errato.",true,flagCorretto);
	}	

	public void testElencoStradePerLunghezza() {

		System.out.println("\n*** testElencoStradePerLunghezza() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		
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

		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		((Strada)et).setNome("Orbassano, Largo");
		((Strada)et).setLunghezza(700);
		System.out.println("Aggiunto elemento topografico:");
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());

		System.out.println("\nAggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("STRADA");
		((Strada)et).setNome("Firenze, Via");
		((Strada)et).setLunghezza(1000);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");
		
		System.out.println("\nElenco delle strade, ordinate per lunghezza:");
		listaStrade = new LinkedList<Strada>(bdt.elencoStradePerLunghezza());
		for(Strada stemp : listaStrade){
			System.out.println(" "+stemp.getNome()+" ("+stemp.getLunghezza()+" m)");
		}

		boolean flagCorretto=false;
		if(listaStrade.get(0).getNome().compareTo("Roma, Via")==0 &&
				listaStrade.get(1).getNome().compareTo("Firenze, Via")==0 &&
						listaStrade.get(2).getNome().compareTo("Orbassano, Largo")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco strade corretto");
		else
			System.out.println("\nElenco strade errato");

		assertEquals("\nElenco strade errato.",true,flagCorretto);
	}	
	
	public void testCercaElementoTopograficoPresente() {

		System.out.println("\n*** testCercaElementoTopograficoPresente() ***\n");

		System.out.println("Aggiungo elemento topografico di tipo strada");
		et = bdt.aggiungiElementoTopografico("strada");
		System.out.println("Aggiunto elemento topografico:");
		((Strada)et).setNome("Roma, Via");
		((Strada)et).setLunghezza(1500);
		System.out.println(" Codice generato: "+et.getCodice());
		System.out.println(" Classe oggetto: "+et.getClass().getSimpleName());
		System.out.println(" Nome: "+((Strada)et).getNome());
		System.out.println(" Lunghezza: "+((Strada)et).getLunghezza()+" m");

		int codice = et.getCodice();
		boolean flagEccezione=false;
		
		System.out.println("\nCerco elemento topografico con codice "+codice);
		try {
			et = bdt.cercaElementoTopografico(codice);
			if(et!=null && et.getCodice()==codice)
			{
				System.out.println("Elemento topografico trovato:");
				System.out.println(" Nome: "+et.getNome());
			}
			else
				System.out.println("Elemento topografico non trovato (codice inesistente)");

		} catch (EccezioneElementoTopograficoInesistente e) {
			System.out.println("Scatenata EccezioneElementoTopograficoInesistente");
			flagEccezione=true;
		}

		if(flagEccezione==false)
			System.out.println("\nElemento correttamente trovato");
		else
			System.out.println("\nElemento erroneamente non trovato");

		assertEquals("\nElemento erroneamente non trovato.",false,flagEccezione);
	}
	
	public void testCercaElementoTopograficoAssente() {

		System.out.println("\n*** testCercaElementoTopograficoAssente() ***\n");

		boolean flagEccezione=false;
		
		System.out.println("Cerco elemento topografico con codice "+10500);
		try {
			et = bdt.cercaElementoTopografico(10500);
			if(et!=null && et.getCodice()==10500)
			{
				System.out.println("Elemento topografico trovato:");
				System.out.println(" Nome: "+et.getNome());
			}
			else
				System.out.println("Elemento topografico non trovato (codice inesistente)");

		} catch (EccezioneElementoTopograficoInesistente e) {
			System.out.println("Scatenata EccezioneElementoTopograficoInesistente");
			flagEccezione=true;
		}

		if(flagEccezione==true)
			System.out.println("\nElemento correttamente non trovato");
		else
			System.out.println("\nGestione della ricerca non corretta");

		assertEquals("\nGestione della ricerca non corretta.",true,flagEccezione);
	}	

	public void testEstensionePiazze() {

		System.out.println("\n*** testEstensionePiazze() ***\n");

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
		
		System.out.println("\nEstensione complessiva delle piazze della citta':");
		double estensione = bdt.estensionePiazze();
		System.out.println(" "+estensione+" m^2");
		
		if(estensione==7500.0)
			System.out.println("\nEstensione complessiva corretta");
		else
			System.out.println("\nEstensione complessiva errata");
		
		assertEquals("Estensione complessiva errata.",7500.0,estensione);

	
	}	
	
}
