import noleggiauto.*;

public class Esempio {

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
			System.out.println("Tipologia: compatta");
		else if(a1 instanceof Berlina)
			System.out.println("Tipologia: berlina");
		else 
			System.out.println("Tipologia: N/D");

		System.out.println("\nNumero valigie e costo giornaliero per tipologia auto");
		
		System.out.println("Valigie grandi (max): "+a1.getNumeroValigiePiccole());
		System.out.println("Valigie piccole (max): "+a1.getNumeroValigieGrandi());
		System.out.println("Costo giornaliero (euro): "+a1.getCostoGiornaliero());
		
		
		System.out.println("\nAggiunta altra auto");

		          a.aggiungiAuto("CC222DD", "Audi", "A8", "Blu", 'B');

		System.out.println("\nRicerca auto con targa CC222DD (berlina)");

		Auto aTrovata = a.cercaAuto("CC222DD");

		System.out.println("\nInformazioni auto trovata");
		
		System.out.println("Targa: "+aTrovata.getTarga());
		System.out.println("Marca: "+aTrovata.getMarca());
		System.out.println("Modello: "+aTrovata.getModello());
		System.out.println("Colore: "+aTrovata.getColore());
		if(aTrovata instanceof Compatta)
			System.out.println("Tipologia: compatta");
		else if(aTrovata instanceof Berlina)
			System.out.println("Tipologia: berlina");
		else 
			System.out.println("Tipologia: N/D");

		System.out.println("\nElenco auto");

		String elencoAuto = a.elencoAuto();
		System.out.println(elencoAuto);
		
		// R2. Clienti
		
		System.out.println("\nRegistrazione cliente");

		Cliente c1 = a.registraCliente("Rossi", "Mario", "Italiana", "UA445566");

		System.out.println("\nCodice assegnato: "+c1.getCodice());

		System.out.println("\nInformazioni cliente");
		
		System.out.println("Cognome: "+c1.getCognome());
		System.out.println("Nome: "+c1.getNome());
		System.out.println("Nazionalita': "+c1.getNazionalita());
		System.out.println("Numero patente: "+c1.getNumeroPatente());
		
		// R3. Noleggi
		
		System.out.println("\nNuovo noleggio cliente "+c1.getCodice()+" per berlina");
		Auto autoNoleggiata = a.nuovoNoleggio(c1.getCodice(), 'B', "20191121", "20191123");
		
		if(autoNoleggiata==null)
			System.out.println("\nCliente non registrato");
		else if(autoNoleggiata!=null && autoNoleggiata.getTarga()==null)
			System.out.println("\nTipologia auto non disponibile");
		else
			System.out.println("\nAuto noleggiata (targa "+autoNoleggiata.getTarga()+")");
			
		System.out.println("\nElenco noleggi cliente "+c1.getCodice());

		String elencoNoleggiCliente = a.elencoNoleggiCliente(c1.getCodice());
		
		System.out.println(elencoNoleggiCliente);
		
		System.out.println("\nCalcola costo noleggio specifico");
		
		int costo = a.calcolaCostoNoleggio(autoNoleggiata.getTarga(), c1.getCodice(), "20191121", "20191123");
		
		System.out.println(costo+" euro");
				
	}

}
