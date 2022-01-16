import java.util.*;

import congressi.*;

public class Esempio {

	public static void main(String[] args) throws EccezioneSessioneSovrapposta {
			
		Organizzazione o = new Organizzazione();

		System.out.println("/***********************************/");
		System.out.println("/**       R1. CENTRI E SALE       **/");
		System.out.println("/***********************************/\n");
			
		
		System.out.println("Definito centro");

		Centro ce = o.definisciCentro("Centro 1", "Indirizzo del Centro 1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Indirizzo: "+ ce.getIndirizzo());
		
		System.out.println("\nCerca centro \"CE1\": ");

		ce = o.cercaCentro("CE1");
		System.out.println(" Id: "+ ce.getId());
		System.out.println(" Nome: "+ ce.getNome());
		System.out.println(" Data indirizzo: "+ ce.getIndirizzo());

		System.out.println("\nDefiniti altri centri");
		o.definisciCentro("Centro 3", "Indirizzo del Centro 2b");
		o.definisciCentro("Centro 2", "Indirizzo del Centro 2a");

		System.out.println("\nElenco centri (ordine di definizione)");

		LinkedList<Centro> listaCentri = new LinkedList<Centro>(o.elencoCentri());
		for(Centro c : listaCentri)
			System.out.println(" "+c.getId()+" "+c.getNome()+" "+c.getIndirizzo());

		System.out.println("\nElenco centri contenenti \"entro 2\" nel nome o nell'indirizzo (ordine di definizione)");

		listaCentri = new LinkedList<Centro>(o.elencoCentri("entro 2"));
		for(Centro c : listaCentri)
			System.out.println(" "+c.getId()+" "+c.getNome()+" "+c.getIndirizzo());
		
		System.out.println("\nDefinite sale per il centro \"CE1\" ");
		o.definisciSalaCentro("CE1", "Sala", 100);
		o.definisciSalaCentro("CE1", "Salone", 200);
		o.definisciSalaCentro("CE1", "Salone", 300);
		o.definisciSalaCentro("CE1", "Saletta", 30);
		
		System.out.println("\nElenco sale centro \"CE1\" (capienza)");
		LinkedList<Sala> listaSale = new LinkedList<Sala>(o.elencoSaleCentroPerCapienza("CE1"));
		for(Sala s : listaSale)
			System.out.println(" "+s.getNome()+" "+s.getCapienza());
		
		
		System.out.println("\n/***********************************/");
		System.out.println("/**         R2. CONGRESSI         **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("Definito congresso");
		
		Congresso co = o.definisciCongresso("Congresso A", "20190702", "20190705", "CE1");
		System.out.println(" Nome: "+ co.getNome());
		System.out.println(" Data inizio: "+ co.getDataInizio());
		System.out.println(" Data fine: "+ co.getDataFine());
		System.out.println(" Id centro: "+ co.getIdCentro());

		System.out.println("\nAssegna sale \"Sala\" e \"Salone\" a congresso \"Congresso A\" ");

		o.assegnaSaleCongresso("Congresso A", "Salone");
		o.assegnaSaleCongresso("Congresso A", "Sala");
		
		System.out.println("\nElenco sale congresso \"Congresso A\" (ordine alfabetico)");
		listaSale = new LinkedList<Sala>(o.elencoSaleCongresso("Congresso A"));
		for(Sala s : listaSale)
			System.out.println(" "+s.getNome()+" "+s.getCapienza());

		
		System.out.println("\n/***********************************/");
		System.out.println("/**         R3. SESSIONI          **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("Pianifica sessione \"Sessione X\" (singolo oratore) per \"Congresso A\" ");

		Sessione se = o.pianificaSessioneCongresso("Congresso A", "Salone", 'S', "Sessione del grande oratore", "20190702", "09:00", "09:59");
		System.out.println(" Numero sessione: "+ se.getNumero());
		System.out.println(" Nome: "+ se.getNome());
		System.out.println(" Data: "+ se.getData());
		System.out.println(" Dalle: "+ se.getDaOra());
		System.out.println(" Alle: "+ se.getAdOra());

		System.out.println("\nAlloca oratore sessione (singolo oratore)");

		o.allocaOratoreSessioneCongresso("Congresso A", 1, "Grillo", "Parlante");
		
		System.out.println("\nElenco oratori sessione \"1\" (singolo oratore)");
		LinkedList<String> listaOratori = new LinkedList<String>(o.elencoOratoriSessioneCongresso("Congresso A", 1));
		for(String s : listaOratori)
			System.out.println(" "+s);

		System.out.println("\nPianifica sessione \"Sessione Y\" (oratori multipli) per \"Congresso A\" ");

		se = o.pianificaSessioneCongresso("Congresso A", "Sala", 'M', "Sessione con piu' oratori", "20190702", "10:00", "11:59");
		System.out.println(" Numero sessione: "+ se.getNumero());
		System.out.println(" Nome: "+ se.getNome());
		System.out.println(" Data: "+ se.getData());
		System.out.println(" Dalle: "+ se.getDaOra());
		System.out.println(" Alle: "+ se.getAdOra());

		System.out.println("\nAlloca oratori sessione  (oratori multipli)");
		o.allocaOratoreSessioneCongresso("Congresso A", 2, "Grillo Muto", "Due", "11:00");
		o.allocaOratoreSessioneCongresso("Congresso A", 2, "Grillo Muto", "Uno", "10:00");

		
		System.out.println("\n/***********************************/");
		System.out.println("/**         R4. PROGRAMMA          **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("Programma sessione \"1\" del \"Congresso A\" (oratore singolo)");
		String risultato = o.programmaSessioneCongresso("Congresso A", 1);
		System.out.println(""+risultato);

		System.out.println("\nProgramma sessione \"2\" del \"Congresso A\" (oratori multipli, ordine cronologico)");
		risultato = o.programmaSessioneCongresso("Congresso A", 2);
		System.out.println(""+risultato);

		System.out.println("Programma congresso \"Congresso A\" (ordine cronologico)");
		risultato = o.programmaCongresso("Congresso A");
		System.out.println(""+risultato);
		
		
	}

}
