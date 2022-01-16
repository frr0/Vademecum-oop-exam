import noleggiauto.*;

public class EsempioEnrico {

	public static void main(String[] args) {

		Autonoleggio a = new Autonoleggio();

		// R1. Auto
		
		System.out.println("Aggiunta auto (compatta)");

		System.out.println("\nInformazioni auto aggiunta");

		Auto a1 = a.aggiungiAuto("AA111BB", "Fiat", "500X", "Bianco", 'C');

		System.out.println("Targa: "+a1.getTarga());
		System.out.println("Marca: "+a1.getMarca());
		System.out.println("Modello: "+a1.getModello());
		System.out.println("Colore: "+a1.getColore());
		if(a1 instanceof Compatta)
			System.out.println("Tipologia: Compatta");
		else if(a1 instanceof Berlina)
			System.out.println("Tipologia: Berlina");
		else 
			System.out.println("Tipologia: N/D");

		System.out.println("\nNumero valigie e costo giornaliero per tipologia auto");
		
		System.out.println("Valigie grandi (max): "+a1.getNumeroValigiePiccole());
		System.out.println("Valigie piccole (max): "+a1.getNumeroValigieGrandi());
		System.out.println("Costo giornaliero (euro): "+a1.getCostoGiornaliero());
		
		
		System.out.println("\nAggiunta altra auto");

		Auto a2 = a.aggiungiAuto("CC222DD", "Audi", "A8", "Blu", 'B');

		System.out.println("\nRicerca auto con targa CC222DD (berlina)");

		Auto aTrovata = a.cercaAuto("CC222DD");

		System.out.println("\nInformazioni auto trovata");
		
		System.out.println("Targa: "+aTrovata.getTarga());
		System.out.println("Marca: "+aTrovata.getMarca());
		System.out.println("Modello: "+aTrovata.getModello());
		System.out.println("Colore: "+aTrovata.getColore());
		if(aTrovata instanceof Compatta)
			System.out.println("Tipologia: Compatta");
		else if(aTrovata instanceof Berlina)
			System.out.println("Tipologia: Berlina");
		else 
			System.out.println("Tipologia: N/D");
		
		System.out.println("\nAggiunta altre auto in corso:");
		a.aggiungiAuto("AB333DD", "Audi", "A5", "Rosso", 'B');
		a.aggiungiAuto("BB444DD", "Fiat", "Panda", "Bianco", 'C');
		a.aggiungiAuto("CB555DD", "Ferrari", "SF90", "Nero", 'B');
		
		a.aggiungiAuto("CB555DD", "sjsh", "shjs", "Rosso", 'F');  //controlla che faccia solo setColore
		
		System.out.println("\nElenco auto");

		String elencoAuto = a.elencoAuto();
		System.out.println(elencoAuto+"\nControlla che auto Ferrari abbia colore rosso e non nero");
		
		
		// R2. Clienti
		
		System.out.println("\nRegistrazione cliente");

		Cliente c1 = a.registraCliente("Rossi", "Mario", "Italiana", "UA445566");
		Cliente c2 = a.registraCliente("Greco", "Michele", "Italiana", "AT4355T");
		Cliente c3 = a.registraCliente("Uwuvuweweugwewument", "Ossas", "ND", "TU6NER0");

		System.out.println("\nCodice assegnato: "+c1.getCodice());

		System.out.println("\nInformazioni cliente");
		
		System.out.println("Cognome: "+c1.getCognome());
		System.out.println("Nome: "+c1.getNome());
		System.out.println("Nazionalita': "+c1.getNazionalita());
		System.out.println("Numero patente: "+c1.getNumeroPatente());
		System.out.println("\nCliente2: "+c2.getCodice()+"\n"+c2.getCognome()+" "+c2.getNome()+" "+c2.getNazionalita()+" "+c2.getNumeroPatente());

		System.out.println("\nCerco cliente con codice UWU-OSS-ND*-TU6NER0***:\n"+a.cercaCliente("UWU-OSS-ND*-TU6NER0***").getCognome()+" "+a.cercaCliente("UWU-OSS-ND*-TU6NER0***").getNome());
		
		
		// R3. Noleggi
		
		System.out.println("\nNuovi noleggio in corso");
		Auto n1 = a.nuovoNoleggio(c1.getCodice(), 'C', "20191121", "20191123");
		Auto n2 = a.nuovoNoleggio(c2.getCodice(), 'C', "20191122", "20191125");
		Auto n3 = a.nuovoNoleggio(c1.getCodice(), 'C', "20191020", "20191023");
		Auto n4 = a.nuovoNoleggio(c1.getCodice(), 'B', "20190910", "20190923");
		Auto n5 = a.nuovoNoleggio(c2.getCodice(), 'B', "20190910", "20190923");
		Auto n6 = a.nuovoNoleggio(c3.getCodice(), 'B', "20190910", "20190923");
		Auto n7 = a.nuovoNoleggio(c3.getCodice(), 'B', "20191210", "20191212");
		Auto n8 = a.nuovoNoleggio(c1.getCodice(), 'B', "20190510", "20190508");
		Auto nErrore1 = a.nuovoNoleggio(c1.getCodice(), 'C', "20191019", "20191024");
		Auto nErrore2 = a.nuovoNoleggio(c3.getCodice(), 'C', "20191120", "20191124");
		Auto nErrore3 = a.nuovoNoleggio("bubu", 'C', "20181120", "20181124");
		
		if(n1!=null && n1.getTarga()!=null)
			System.out.println("\nAuto compatta noleggiata (targa "+n1.getTarga()+") da "+c1.getCodice());
		
		if(n2!=null && n2.getTarga()!=null)
			System.out.println("\nAuto compatta noleggiata (targa "+n2.getTarga()+") da "+c2.getCodice());
		
		if(n3!=null && n3.getTarga()!=null)
			System.out.println("\nAuto compatta noleggiata (targa "+n3.getTarga()+") da "+c1.getCodice());
		
		if(n4!=null && n4.getTarga()!=null)
			System.out.println("\nAuto berlina noleggiata (targa "+n4.getTarga()+") da "+c1.getCodice());
		
		if(n5!=null && n5.getTarga()!=null)
			System.out.println("\nAuto berlina noleggiata (targa "+n5.getTarga()+") da "+c2.getCodice());
		
		if(n6!=null && n6.getTarga()!=null)
			System.out.println("\nAuto berlina noleggiata (targa "+n6.getTarga()+") da "+c3.getCodice());
		
		if(n7!=null && n7.getTarga()!=null)
			System.out.println("\nAuto berlina noleggiata (targa "+n7.getTarga()+") da "+c3.getCodice());
		
		if(n8!=null && n8.getTarga()!=null)
			System.out.println("\nAuto berlina noleggiata (targa "+n8.getTarga()+") da "+c1.getCodice());
			
		
		System.out.print("\nDate sovrapposte per stesso cliente\nControlla stampa: ");
		if(nErrore1==null)
			System.out.println("Errore, date sovrapposte!");
		
		System.out.print("\nDate sovrapposte per auto stesso tipo\nControlla stampa: ");
		if(nErrore2!=null && nErrore2.getTarga()==null)
			System.out.println("Tipologia auto non disponibile per quel periodo");
		
		System.out.print("\nCodice cliente inesistente\nControlla stampa: ");
		if(nErrore3==null)
			System.out.println("Cliente non registrato");
		
		System.out.println("\nElenco noleggi cliente "+c1.getCodice());

		String elencoNoleggiCliente = a.elencoNoleggiCliente(c1.getCodice());
		
		System.out.print(elencoNoleggiCliente);
		
		System.out.println("\nElenco noleggi auto "+a2.getTarga());

		String elencoNoleggiAuto = a.elencoNoleggiAuto(a2.getTarga());
		
		System.out.print(elencoNoleggiAuto);
		
		System.out.println("\nCosto noleggio di "+a2.getTarga()+" da parte di "+c3.getCognome()+" "+c3.getNome()+" dal 10/12/2019 al 12/12/2019:");
		
		int costo = a.calcolaCostoNoleggio(a2.getTarga(), c3.getCodice(), "20191210", "20191212");
		
		System.out.println(costo+" euro");
		
        int costoErrore = a.calcolaCostoNoleggio(a2.getTarga(), c1.getCodice(), "20191121", "20191123");
		
		System.out.println("\nNoleggio inesistente\nControlla stampa: "+costoErrore);
				
	}

}
