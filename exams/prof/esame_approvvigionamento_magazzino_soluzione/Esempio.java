import java.util.*;

import approvvigionamento_magazzino.*;

public class Esempio {

public static void main(String[] args) throws EccezioneProdottoNonFornito {
		
		Magazzino m = new Magazzino();
		
		System.out.println("/************************************/");
		System.out.println("/**          R1.  PRODOTTI         **/");
		System.out.println("/************************************/");

		System.out.println("\n* Registrazione prodotto 1003 Televisore Sony BRAV12");
		
		Prodotto p = m.registraProdotto(1003, "Televisore Sony BRAV12");

		System.out.println("\n* Informazioni prodotto registrato\n");
		System.out.println("Codice prodotto: "+p.getCodiceProdotto());
		System.out.println("Descrizione: "+p.getDescrizione());

		System.out.println("\n* Quantita' prodotto 1003\n");
		
		int q = m.ottieniQuantita(1003);
		System.out.println(q);

		System.out.println("\n* Registrazione altri prodotti");

		m.registraProdotto(1622, "Lavatrice Samsung WF16");
		m.registraProdotto(1515, "Lavastoviglie Bosh B452");
		m.registraProdotto(3112, "Lavatrice Candy CAN2244");
		
		System.out.println("\n* Elenco prodotti registrati (ordine di registrazione)\n");
		LinkedList<Prodotto> listaProdotti = new LinkedList<Prodotto>(m.elencoProdotti());
		for(Prodotto pTemp : listaProdotti)
			System.out.println(""+pTemp.getCodiceProdotto()+" "+pTemp.getDescrizione());

		
		System.out.println("\n* Ricerca prodotti che contengono 'lavatrice' (ordine di registrazione)\n");
		listaProdotti = new LinkedList<Prodotto>(m.cercaProdotti("lavatrice"));
		for(Prodotto pTemp : listaProdotti)
			System.out.println(""+pTemp.getCodiceProdotto()+" "+pTemp.getDescrizione());
		
		
		System.out.println("\n\n/************************************/");
		System.out.println("/**    R2. FORNITORI E FORNITURE   **/");
		System.out.println("/************************************/");

		System.out.println("\n* Registrazione fornitore AAA Elettrodomestici del Piemonte s.r.l. (privilegiato, sconto 10%)");
		
		Fornitore f = m.registraFornitore("AAA", "Elettrodomestici del Piemonte s.r.l.", 10);

		System.out.println("\n* Informazioni fornitore\n");
		System.out.println("Codice fornitore: "+f.getCodiceFornitore());
		System.out.println("Nome: "+f.getNome());
		if(f instanceof FornitorePrivilegiato)
			System.out.println("Tipologia: privilegiato, sconto "+((FornitorePrivilegiato)f).getPercentualeSconto()+"%");
		else
			System.out.println("Tipologia: non privilegiato");
		
		System.out.println("\n* Registrazione altri fornitori (non privilegiati)");

		m.registraFornitore("CCC", "Televisori di qualita' s.p.a.");
		m.registraFornitore("BBB", "Lavastoviglie Sbiancapiatti s.n.c.");

		System.out.println("\n* Elenco fornitori (in ordine di codice fornitore)\n");
		LinkedList<Fornitore> listaFornitori = new LinkedList<Fornitore>(m.elencoFornitori());
		for(Fornitore fTemp : listaFornitori)
			System.out.println(""+fTemp.getCodiceFornitore()+" "+fTemp.getNome());

		System.out.println("\n* Definizione fornitura prodotto 1003, fornitore BBB, costo 500");

		m.definisciFornitura("BBB", 1003, 500);
		
		System.out.println("\n* Costo prodotto 1003 per il fornitore BBB\n");

		double costo = m.costoProdottoFornitore("BBB", 1003);
		System.out.println(costo);

		System.out.println("\n* Definizione altre forniture");

		m.definisciFornitura("AAA", 1622, 400);
		m.definisciFornitura("AAA", 1003, 550);
		
		System.out.println("\n* Elenco prodotti forniti dal fornitore AAA (in ordine di codice prodotto)\n");
		listaProdotti = new LinkedList<Prodotto>(m.elencoProdottiForniti("AAA"));
		for(Prodotto pTemp : listaProdotti)
			System.out.println(""+pTemp.getCodiceProdotto()+" "+pTemp.getDescrizione());
		
		
		System.out.println("\n\n/************************************/");
		System.out.println("/**         R3. ORDINAZIONI        **/");
		System.out.println("/************************************/");

		System.out.println("\n* Effettuata ordinazione per prodotto 1622, fornitore AAA (privilegiato), quantita' 5");

		String co = m.effettuaOrdinazione("AAA", 1622, 5);
		
		System.out.println("\n* Codice ordinazione\n");
		
		System.out.println(co);
		
		System.out.println("\n* Dettagli ordinazione "+co+"\n");
		
		String dettagliOrdinazione = m.dettagliOrdinazione(co);
		System.out.println(dettagliOrdinazione);

		System.out.println("\n* Valore ordinazione "+co+"\n");
		
		double costoOrdinazione = m.costoOrdinazione(co);
		System.out.println(costoOrdinazione);
		
		System.out.println("\n* Effettuata ordinazione per prodotto 1003, fornitore BBB, quantita' 10");

		co = m.effettuaOrdinazione("BBB", 1003, 10);

		System.out.println("\n* Valore ordinazione "+co+"\n");
		
		costoOrdinazione = m.costoOrdinazione(co);
		System.out.println(costoOrdinazione);
		
		System.out.println("\n* Effettuata altra ordinazione per prodotto 1003, fornitore AAA, quantita' 30");

		co = m.effettuaOrdinazione("AAA", 1003, 30);
		
		System.out.println("\n* Stampa ordinazioni (in ordine di codice ordinazione decrescente)\n");
		
		String stringaOrdinazioni = m.stampaOrdinazioni();
		System.out.println(stringaOrdinazioni);
		
		System.out.println("\n\n/************************************/");
		System.out.println("/**   R4. CONSEGNE E STATISTICHE   **/");
		System.out.println("/************************************/");

		System.out.println("\n* Consegnata ordinazione "+co);
		
		m.consegnaOrdinazione(co);
		
		System.out.println("\n* Quantita' prodotto 1003 dopo la consegna\n");
		
		q = m.ottieniQuantita(1003);
		System.out.println(q);

		System.out.println("\n* Percentuale ordinazioni prodotto 1003 non consegnate\n");
		
		System.out.println(m.percentualeOrdinazioniProdottoNonConsegnate(1003));
		
	}

}
