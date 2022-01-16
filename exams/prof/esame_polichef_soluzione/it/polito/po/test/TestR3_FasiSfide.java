package it.polito.po.test;
import polichef.*;
import junit.framework.TestCase;

public class TestR3_FasiSfide extends TestCase {

	  public void testDefinisciFase(){

			System.out.println("\n*** R3. testDefinisciFase() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			Fase f1 = t.definisciFase(1, "Selezioni iniziali", 32);

			System.out.println("Definita nuova fase");

			System.out.println(" "+f1.getNumeroFase()+" "+f1.getNome()+" "+f1.getNumeroMassimoConcorrenti());
			
			boolean corretto = false;
			
			if(f1.getNumeroFase()==1 && f1.getNome().compareTo("Selezioni iniziali")==0 && f1.getNumeroMassimoConcorrenti()==32)
			{
				System.out.println("\nInformazioni relative alla fase registrate in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nErrore nella registrazione delle informazioni relative alla fase");
				
			assertEquals("Implementazione del metodo definisciFase() e/o dei metodi correlati errata", true,corretto);	  
	  }

	  
	  public void testDescriviSfideFase(){

			System.out.println("\n*** R3. descriviSfideFase() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			t.definisciFase(1, "Selezioni iniziali", 32);

			System.out.println("Definita fase 1");
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			String idc1 = c1.getId();
			Concorrente c2 = t.iscriviConcorrente("Giuseppe", "Grigi", "Commercialista");
			String idc2 = c2.getId();

			System.out.println("\nIscritti due concorrenti");

			System.out.println("\nRegistrazione piatti concorrenti");
			
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			int idp2 = t.registraPiattoConcorrente("Pollo al rosmarino", idc2);
			
			System.out.println("\nAggiunti due concorrenti alla fase 1");

			t.assegnaConcorrenteFase(1, idc1);
			t.assegnaConcorrenteFase(1, idc2);

			System.out.println("\nDefinita sfida tra i due concorrenti della fase 1");

			t.definisciSfidaFase(1, idc1, idp1, idc2, idp2, "1-3");
			
			System.out.println("\nSfide della fase 1");
			String descrizioneSfideFase = t.descriviSfideFase(1);
			System.out.println(""+descrizioneSfideFase);

			boolean corretto = false;
			
			if(descrizioneSfideFase.compareTo("Alberto N., 100, Giuseppe G., 101, 1-3")==0 || 
			   descrizioneSfideFase.compareTo("Alberto N., 100, Giuseppe G., 101, 1-3\n")==0 ||
			   descrizioneSfideFase.compareTo(" Alberto N., 100, Giuseppe G., 101, 1-3")==0 ||
			   descrizioneSfideFase.compareTo(" Alberto N., 100, Giuseppe G., 101, 1-3\n")==0 )
			{
				System.out.println("\nDescrizione sfide gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nDescrizione sfide gestita in maniera errata");
				
			assertEquals("Implementazione del metodo descriviSfideFase() e/o dei metodi correlati errata", true,corretto);	  
	  }
	  
	  
	  public void testDescriviSfideFasePiattoInesistente(){

			System.out.println("\n*** R3. testDescriviSfideFasePiattoInesistente() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			t.definisciFase(1, "Selezioni iniziali", 32);

			System.out.println("Definita fase 1");
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			String idc1 = c1.getId();
			Concorrente c2 = t.iscriviConcorrente("Giuseppe", "Grigi", "Commercialista");
			String idc2 = c2.getId();
			Concorrente c3 = t.iscriviConcorrente("Maria", "Arancioni", "Commercialista");
			String idc3 = c3.getId();
			Concorrente c4 = t.iscriviConcorrente("Anna", "Blu", "Avvocato");
			String idc4 = c4.getId();

			System.out.println("\nIscritti concorrenti");

			System.out.println("\nRegistrazione piatti concorrenti");
			
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			int idp2 = t.registraPiattoConcorrente("Pollo al rosmarino", idc2);
			int idp3 = t.registraPiattoConcorrente("Tiramisu", idc3);
			int idp4 = t.registraPiattoConcorrente("Budino", idc4);
			
			System.out.println("\nAggiunti concorrenti alla fase 1");

			t.assegnaConcorrenteFase(1, idc1);
			t.assegnaConcorrenteFase(1, idc2);
			t.assegnaConcorrenteFase(1, idc3);
			t.assegnaConcorrenteFase(1, idc4);

			System.out.println("\nDefinita sfida tra due concorrenti della fase 1");

			t.definisciSfidaFase(1, idc1, idp1, idc2, idp2, "3-1");

			System.out.println("\nDefinita sfida tra altri due concorrenti della fase 1");

			t.definisciSfidaFase(1, idc3, idp3, idc4, idp4, "1-3");

			System.out.println("\nTentativo di definizione sfida tra due concorrenti della fase 1 con piatto inesistente");

			t.definisciSfidaFase(1, idc1, idp1, idc2, -1000, "1-3");

			System.out.println("\nSfide della fase 1");
			String descrizioneSfideFase = t.descriviSfideFase(1);
			System.out.println(""+descrizioneSfideFase);

			boolean corretto = false;
			
			if(descrizioneSfideFase.compareTo("Alberto N., 100, Giuseppe G., 101, 3-1\nMaria A., 102, Anna B., 103, 1-3")==0 || 
			   descrizioneSfideFase.compareTo("Alberto N., 100, Giuseppe G., 101, 3-1\nMaria A., 102, Anna B., 103, 1-3\n")==0 ||
			   descrizioneSfideFase.compareTo(" Alberto N., 100, Giuseppe G., 101, 3-1\n Maria A., 102, Anna B., 103, 1-3")==0 ||
			   descrizioneSfideFase.compareTo(" Alberto N., 100, Giuseppe G., 101, 3-1\n Maria A., 102, Anna B., 103, 1-3\n")==0 )
			{
				System.out.println("\nDescrizione sfide gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nDescrizione sfide gestita in maniera errata");
				
			assertEquals("Implementazione del metodo descriviSfideFase() e/o dei metodi correlati errata", true,corretto);	  
	  }
	  
	  
	  public void testDescriviSfide(){

			System.out.println("\n*** R3. testDescriviSfide() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			t.definisciFase(1, "Selezioni iniziali", 32);
			t.definisciFase(2, "Fase principale", 16);

			System.out.println("Definite fasi");
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			String idc1 = c1.getId();
			Concorrente c2 = t.iscriviConcorrente("Giuseppe", "Grigi", "Commercialista");
			String idc2 = c2.getId();
			Concorrente c3 = t.iscriviConcorrente("Maria", "Arancioni", "Commercialista");
			String idc3 = c3.getId();
			Concorrente c4 = t.iscriviConcorrente("Anna", "Blu", "Avvocato");
			String idc4 = c4.getId();

			System.out.println("\nIscritti concorrenti");

			System.out.println("\nRegistrazione piatti concorrenti");
			
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			int idp2 = t.registraPiattoConcorrente("Pollo al rosmarino", idc2);
			int idp3 = t.registraPiattoConcorrente("Tiramisu", idc3);
			int idp4 = t.registraPiattoConcorrente("Budino", idc4);
			
			System.out.println("\nAggiunti concorrenti alla fase 1");

			t.assegnaConcorrenteFase(1, idc1);
			t.assegnaConcorrenteFase(1, idc2);
			t.assegnaConcorrenteFase(1, idc3);
			t.assegnaConcorrenteFase(1, idc4);

			System.out.println("\nAggiunti concorrenti alla fase 2");

			t.assegnaConcorrenteFase(2, idc1);
			t.assegnaConcorrenteFase(2, idc4);
			
			System.out.println("\nDefinite sfide");

			t.definisciSfidaFase(1, idc3, idp3, idc4, idp4, "1-3");
			t.definisciSfidaFase(2, idc1, idp1, idc4, idp4, "3-1");
			t.definisciSfidaFase(1, idc1, idp1, idc2, idp2, "3-1");
			
			System.out.println("\nSfide di tutte fasi");
			String descrizioneSfide = t.descriviSfide();
			System.out.println(""+descrizioneSfide);

			boolean corretto = false;
			
			if(descrizioneSfide.compareTo("Maria A., 102, Anna B., 103, 1-3\nAlberto N., 100, Giuseppe G., 101, 3-1\nAlberto N., 100, Anna B., 103, 3-1")==0 || 
			   descrizioneSfide.compareTo("Maria A., 102, Anna B., 103, 1-3\nAlberto N., 100, Giuseppe G., 101, 3-1\nAlberto N., 100, Anna B., 103, 3-1\n")==0 ||
			   descrizioneSfide.compareTo(" Maria A., 102, Anna B., 103, 1-3\n Alberto N., 100, Giuseppe G., 101, 3-1\n Alberto N., 100, Anna B., 103, 3-1")==0 || 
			   descrizioneSfide.compareTo(" Maria A., 102, Anna B., 103, 1-3\n Alberto N., 100, Giuseppe G., 101, 3-1\n Alberto N., 100, Anna B., 103, 3-1\n")==0)
			{
				System.out.println("\nDescrizione sfide gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nDescrizione sfide gestita in maniera errata");
				
			assertEquals("Implementazione del metodo descriviSfide() e/o dei metodi correlati errata", true,corretto);	  
	  }

	  
	  public void testDeterminaVincitoreSfida(){

			System.out.println("\n*** R3. testDeterminaVincitoreSfida() ***\n");
			
			Trasmissione t = new Trasmissione();
			
			t.definisciFase(1, "Selezioni iniziali", 32);
			t.definisciFase(2, "Fase principale", 16);

			System.out.println("Definite fasi");
			
			Concorrente c1 = t.iscriviConcorrente("Alberto", "Neri", "Attore");
			String idc1 = c1.getId();
			Concorrente c2 = t.iscriviConcorrente("Giuseppe", "Grigi", "Commercialista");
			String idc2 = c2.getId();
			Concorrente c3 = t.iscriviConcorrente("Maria", "Arancioni", "Commercialista");
			String idc3 = c3.getId();
			Concorrente c4 = t.iscriviConcorrente("Anna", "Blu", "Avvocato");
			String idc4 = c4.getId();

			System.out.println("\nIscritti concorrenti");

			System.out.println("\nRegistrazione piatti concorrenti");
			
			int idp1 = t.registraPiattoConcorrente("Vitello tonnato", idc1);
			int idp2 = t.registraPiattoConcorrente("Pollo al rosmarino", idc2);
			int idp3 = t.registraPiattoConcorrente("Tiramisu", idc3);
			int idp4 = t.registraPiattoConcorrente("Budino", idc4);
			
			System.out.println("\nAggiunti concorrenti alle fasi");

			t.assegnaConcorrenteFase(1, idc1);
			t.assegnaConcorrenteFase(1, idc2);
			t.assegnaConcorrenteFase(1, idc3);
			t.assegnaConcorrenteFase(1, idc4);

			t.assegnaConcorrenteFase(2, idc1);
			t.assegnaConcorrenteFase(2, idc4);
			
			System.out.println("\nDefinite sfide");

			t.definisciSfidaFase(1, idc3, idp3, idc4, idp4, "1-3");
			t.definisciSfidaFase(2, idc1, idp1, idc4, idp4, "3-1");
			t.definisciSfidaFase(1, idc1, idp1, idc2, idp2, "3-1");
			
			System.out.println("\nVincitore sfida tra "+idc1+" e "+idc2);
			String idVincitore1 = t.determinaVincitoreSfida(idc1, idc2);
			System.out.println(" "+idVincitore1);

			System.out.println("\nVincitore sfida tra "+idc4+" e "+idc3);
			String idVincitore2 = t.determinaVincitoreSfida(idc4, idc3);
			System.out.println(" "+idVincitore2);

			System.out.println("\nVincitore sfida tra "+idc4+" e "+idc1);
			String idVincitore3 = t.determinaVincitoreSfida(idc4, idc1);
			System.out.println(" "+idVincitore3);
			
			boolean corretto = false;
			
			if(idVincitore1.compareTo(idc1)==0 && idVincitore2.compareTo(idc4)==0 && idVincitore3.compareTo(idc1)==0)
			{
				System.out.println("\nDeterminazione vincitore sfida gestita in maniera corretta");
				corretto = true;
			}
			else
				System.out.println("\nDeterminazione vincitore sfida gestita in maniera errata");
				
			assertEquals("Implementazione del metodo testDeterminaVincitoreSfida() e/o dei metodi correlati errata", true,corretto);	  
	  }
}

