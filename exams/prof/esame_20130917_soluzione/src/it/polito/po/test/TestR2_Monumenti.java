package it.polito.po.test;

import ufficiotecnico.*;

import junit.framework.TestCase;
import java.util.*;

public class TestR2_Monumenti extends TestCase {

	BaseDatiTopografica bdt;
	ElementoTopografico et;
	Monumento m;
	List<Monumento> listaMonumenti;
	List<String> listaMateriali;	
	
	public void setUp(){
		
		bdt = new BaseDatiTopografica();
    }

	public void testAggiungiMonumento() {
		
		System.out.println("\n*** testAggiungiMonumento() ***\n");

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
		int codice = et.getCodice();
		
		System.out.println("\nAggiungo un monumento alla piazza "+codice);
		m=((Piazza)et).aggiungiMonumento("San Gennaro", "1994-06-24", "Mario Bianchi", 'C');
		System.out.println("Monumento aggiunto:");
		System.out.println(" Personaggio (o fatto) rappresentato: "+m.getRappresenta());
		System.out.println(" Data costruzione: "+m.getData());
		System.out.println(" Artista: "+m.getArtista());
		System.out.println(" Posizione: "+m.getPosizione());

		assertNotNull("Errore nell'aggiunta del monumento.",m);
		
		if(m.getRappresenta().compareTo("San Gennaro")==0)
			System.out.println("\nPersonaggio (o fatto) rappresentato corretto");
		else
			System.out.println("\nPersonaggio (o fatto) rappresentato errato");
		
		assertEquals("Personaggio (o fatto) rappresentato errato.","San Gennaro",m.getRappresenta());
		
		if(m.getData().compareTo("1994-06-24")==0)
			System.out.println("Data corretta");
		else
			System.out.println("Data errata");
		
		assertEquals("Data errata.","1994-06-24",m.getData());
		
		if(m.getArtista().compareTo("Mario Bianchi")==0)
			System.out.println("Artista corretto");
		else
			System.out.println("Artista errato");
		
		assertEquals("Artista errato.","Mario Bianchi",m.getArtista());
		
		if(m.getPosizione()=='C')
			System.out.println("Posizione corretta");
		else
			System.out.println("Posizione errata");
		
		assertEquals("Posizione errata.",'C',m.getPosizione());
	}

	public void testMateriali() {
		
		System.out.println("\n*** testMateriali() ***\n");
	
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
		int codice = et.getCodice();
		
		System.out.println("\nAggiungo un monumento alla piazza "+codice);
		m=((Piazza)et).aggiungiMonumento("San Gennaro", "1994-06-24", "Mario Bianchi", 'C');
		System.out.println("Monumento aggiunto:");
		System.out.println(" Personaggio (o fatto) rappresentato: "+m.getRappresenta());
		System.out.println(" Data costruzione: "+m.getData());
		System.out.println(" Artista: "+m.getArtista());
		System.out.println(" Posizione: "+m.getPosizione());

		System.out.println("\nAggiungo materiali al monumento");
		m.aggiungiMateriale("Marmo");
		m.aggiungiMateriale("Oro");
		m.aggiungiMateriale("Legno");
		
		System.out.println("Elenco materiali aggiunti:");
		listaMateriali = new LinkedList<String>(m.elencoMateriali());
		for(String mtemp : listaMateriali)
			System.out.println(" "+mtemp);

		boolean flagCorretto=false;
		if(listaMateriali.get(0).compareTo("Marmo")==0 &&
				listaMateriali.get(1).compareTo("Oro")==0 &&
						listaMateriali.get(2).compareTo("Legno")==0) 
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nMateriali corretti");
		else
			System.out.println("\nMateriali errato");

		assertEquals("\nMateriali errati.",true,flagCorretto);		
	}
	
	public void testElencoMonumenti() throws EccezioneElementoTopograficoInesistente {
		
		System.out.println("\n*** testElencoMonumenti() ***\n");

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
		int codice = et.getCodice();
		
		System.out.println("\nAggiungo un monumento alla piazza "+codice);
		m=((Piazza)et).aggiungiMonumento("San Gennaro", "1994-06-24", "Mario Bianchi", 'C');
		System.out.println("Monumento aggiunto:");
		System.out.println(" Personaggio (o fatto) rappresentato: "+m.getRappresenta());
		System.out.println(" Data: "+m.getData());
		System.out.println(" Artista: "+m.getArtista());
		System.out.println(" Posizione: "+m.getPosizione());

		System.out.println("\nAggiungo un altro monumento alla piazza "+codice);
		m=((Piazza)et).aggiungiMonumento("Quattro giornate di Napoli", "1987-05-12", "Alberto Blu", 'E');
		System.out.println("Monumento aggiunto:");
		System.out.println(" Personaggio (o fatto) rappresentato: "+m.getRappresenta());
		System.out.println(" Data: "+m.getData());
		System.out.println(" Artista: "+m.getArtista());
		System.out.println(" Posizione: "+m.getPosizione());

		System.out.println("\nElenco monumenti della piazza "+codice+":");
		listaMonumenti = new LinkedList<Monumento>(bdt.elencoMonumenti(codice));
		for(Monumento mtemp : listaMonumenti)
			System.out.println(" "+mtemp.getRappresenta()+" inaugurato il "+mtemp.getData()+" ("+mtemp.getPosizione()+")");

		boolean flagCorretto=false;
		if(listaMonumenti.get(0).getRappresenta().compareTo("Quattro giornate di Napoli")==0 &&
				listaMonumenti.get(1).getRappresenta().compareTo("San Gennaro")==0 )
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("\nElenco monumenti corretto");
		else
			System.out.println("\nElenco monumenti errato");

		assertEquals("\nElenco monumenti errato.",true,flagCorretto);		
	}	
	
	public void testAggiungiMonumentoStessaPosizione() throws EccezioneElementoTopograficoInesistente {
		
		System.out.println("\n*** testAggiungiMonumentoStessaPosizione() ***\n");

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
		int codice = et.getCodice();
		
		System.out.println("\nAggiungo un monumento alla piazza "+codice);
		m=((Piazza)et).aggiungiMonumento("San Gennaro", "1994-06-24", "Mario Bianchi", 'C');
		System.out.println("Monumento aggiunto:");
		System.out.println(" Personaggio (o fatto) rappresentato: "+m.getRappresenta());
		System.out.println(" Data: "+m.getData());
		System.out.println(" Artista: "+m.getArtista());
		System.out.println(" Posizione: "+m.getPosizione());

		System.out.println("\nAggiungo un altro monumento alla piazza "+codice+" (nella stessa posizione)");
		m=((Piazza)et).aggiungiMonumento("Quattro giornate di Napoli", "1987-05-12", "Alberto Blu", 'C');
		System.out.println("Monumento aggiunto:");
		System.out.println(" Personaggio (o fatto) rappresentato: "+m.getRappresenta());
		System.out.println(" Data: "+m.getData());
		System.out.println(" Artista: "+m.getArtista());
		System.out.println(" Posizione: "+m.getPosizione());

		System.out.println("\nElenco monumenti della piazza "+codice+":");
		listaMonumenti = new LinkedList<Monumento>(bdt.elencoMonumenti(codice));
		for(Monumento mtemp : listaMonumenti)
			System.out.println(" "+mtemp.getRappresenta()+" inaugurato il "+mtemp.getData()+" ("+mtemp.getPosizione()+")");

		if(listaMonumenti.size()==1)
			System.out.println("\nNumero di monumenti corretto");
		else
			System.out.println("\nNumero di monumenti errato");
		
		assertEquals("Numero di monumenti errato.",1,listaMonumenti.size());
		
		boolean flagCorretto=false;
		if(listaMonumenti.get(0).getRappresenta().compareTo("Quattro giornate di Napoli")==0)
			flagCorretto=true;
		
		if(flagCorretto==true)
			System.out.println("Monumento correttamente rimpiazzato");
		else
			System.out.println("Monumento erroneamente non rimpiazzato");

		assertEquals("\nMonumento erroneamente non rimpiazzato.",true,flagCorretto);		
	}

	public void testMonumentoPresenteInPosizione() {
		
		System.out.println("\n*** testMonumentoPresenteInPosizione() ***\n");

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
		int codice = et.getCodice();
		
		System.out.println("\nAggiungo un monumento alla piazza "+codice+" in posizione 'C'");
		m=((Piazza)et).aggiungiMonumento("San Gennaro", "1994-06-24", "Mario Bianchi", 'C');
		System.out.println("Monumento aggiunto:");
		System.out.println(" Personaggio (o fatto) rappresentato: "+m.getRappresenta());
		System.out.println(" Data: "+m.getData());
		System.out.println(" Artista: "+m.getArtista());
		System.out.println(" Posizione: "+m.getPosizione());

		System.out.println("\nVerifica presenza di un monumento nella posizione 'C' della piazza");
		boolean presente = ((Piazza)et).monumentoPresenteInPosizione('C');

		if(presente)
			System.out.println("\nMonumento correttamente presente");
		else
			System.out.println("\nMonumento erroneamente assente");

		assertEquals("Monumento erroneamente assente.",true,presente);
		
		System.out.println("\nVerifica presenza di un monumento nella posizione 'N' della piazza");
		        presente = ((Piazza)et).monumentoPresenteInPosizione('N');

		if(!presente)
			System.out.println("\nMonumento correttamente assente");
		else
			System.out.println("\nMonumento erroneamente presente");

		assertEquals("Monumento erroneamente presente.",false,presente);
	}
}	
	