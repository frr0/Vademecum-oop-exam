package it.polito.po.test;

import ufficiotecnico.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;

public class TestR4_CaricamentoDaFile extends TestCase {

	BaseDatiTopografica bdt;
	ElementoTopografico et;
	List<ElementoTopografico> listaElementiTopografici;

	public void setUp(){
		
		bdt = new BaseDatiTopografica();
    }

	  /**
	   * Create a new temporary file and write the content
	   * @param content
	   * @return the path of the new file.
	   * @throws IOException
	   */
	  private static String writeFile(String content) throws IOException {          
	          File f = File.createTempFile("off","txt");
	          FileOutputStream fos = new FileOutputStream(f);
	          fos.write(content.getBytes());
	          fos.close();
	          return f.getAbsolutePath();
	  }
	
	
	public void testLeggi() throws IOException, EccezioneElementoTopograficoInesistente, EccezioneIncrocioImpossibile {

		System.out.println("\n*** testLeggi() ***\n");
		
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
		int quintoCodice = et.getCodice();
		
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
			

		String normale = "strada;Aosta, Via;500\n" +
				         "piazza;Cuneo, Piazza;triangolare;10000\n"+
				         "incrocio;"+terzoCodice+";"+(quintoCodice+1)+";true\n"+
				         "strada;Milano, Corso;16000\n"+
				         "strada;Palermo, Via;1200\n"+
				         "incrocio;"+secondoCodice+";"+(quartoCodice+1)+";false\n"+
				         "incrocio;"+(quartoCodice+2)+";"+secondoCodice+";false\n"+
				         "incrocio;"+(quartoCodice+2)+";"+(quartoCodice+3)+";true";
		
	  	String file = writeFile(normale);
		
		System.out.println("\nLeggo altri elementi topografici ed incroci dal file input.txt ed aggiorno la struttura dati");
		bdt.leggi(file);

		System.out.println("\nElenco alfabetico di tutti gli elementi topografici (vecchi e nuovi):");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoElementiTopografici());
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome()+" ("+etemp.getCodice()+")");
		}

		boolean flagCorretto=false;
		if(listaElementiTopografici.get(0).getNome().compareTo("Aosta, Via")==0 &&
				listaElementiTopografici.get(1).getNome().compareTo("Capri, Piazza")==0 &&
						listaElementiTopografici.get(8).getNome().compareTo("Roma, Via")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco elementi topografici corretto");
		else
			System.out.println("\nElenco elementi topografici errato");

		assertEquals("\nElenco elementi topografici errato.",true,flagCorretto);

		System.out.println("\nElenco degli incroci con Napoli, Piazza (prima le strade in ordine alfabetico, poi le piazze):");
		listaElementiTopografici = new LinkedList<ElementoTopografico>(bdt.elencoIncroci(secondoCodice));
		for(ElementoTopografico etemp : listaElementiTopografici){
			System.out.println(" "+etemp.getNome());
		}
		
		        flagCorretto=false;
		if(listaElementiTopografici.get(0).getNome().compareTo("Aosta, Via")==0 &&
				listaElementiTopografici.get(1).getNome().compareTo("Milano, Corso")==0 &&
						listaElementiTopografici.get(2).getNome().compareTo("Roma, Via")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco incroci corretto");
		else
			System.out.println("\nElenco incroci errato");

		assertEquals("\nElenco incroci errato.",true,flagCorretto);
		
		
		
	}		

}
