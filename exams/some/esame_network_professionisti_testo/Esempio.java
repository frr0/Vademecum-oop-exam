import java.util.*;

import network_professionisti.*;

public class Esempio {

	public static void main(String[] args) throws EccezioneEntitaGiaDefinita {
			
		Network n = new Network();
		
		System.out.println("/***********************************/");
		System.out.println("/**          R1. ISCRITTI         **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("Iscritto nuovo utente al network");
		
		Iscritto i1 = n.nuovoIscritto("Mario", "Rossi", "http://www.mariorossi.com", "mrossi@mail.com", "Mario Rossi ricopre il ruolo di rappresentante unico sul territorio nazionale per la propria azienda di mobili.");
		
		System.out.println(" Nome: "+i1.getNome());
		System.out.println(" Cognome: "+i1.getCognome());
		System.out.println(" Web: "+i1.getWeb());
		System.out.println(" Email: "+i1.getEmail());
		System.out.println(" Descrizione (abbr.): "+i1.getDescrizione().substring(0, Math.min(i1.getDescrizione().length(), 30))+" ...");
		
		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i1.getId());
		
		System.out.println("\nIscritto altro utente");
		Iscritto i2 = n.nuovoIscritto("Mario", "Rossi", "http://www.mr.it", "rossi@email.it", "Mario Rossi e' noto per la propria attività a supporto dello sviluppo del settore delle energie rinnovabili in Italia.");

		System.out.println("\nIdentificativo assegnato");
		System.out.println(" "+i2.getId());
		
		System.out.println("\nIscritti altri utenti");
		n.nuovoIscritto("Gianni",  "Verdi", "http://www.gianniv.eu", "gianni@mail.eu", "Gianni Verdi si occupa da più di 30 anni di diritto comunitario.");
		n.nuovoIscritto("Francesca", "Gialli", "http://www.francesca.it", "fg@email.it", "Francesca Gialli è una giornalista famosa per i propri servizi sulle tecnologie del futuro.");

		System.out.println("\nCerca iscritto 'Francesca' 'Gialli'");
		Iscritto i3 = n.cercaIscrittoPerNomeCognome("Francesca", "Gialli");
		
		System.out.println(" '"+i3.getId()+"' '"+i3.getNome()+"' '"+i3.getCognome()+"' '"+i3.getWeb()+"' '"+i3.getEmail()+"' "+i3.getDescrizione().substring(0, Math.min(i3.getDescrizione().length(), 30))+" ...'");
		
		System.out.println("\nElenco iscritti (ordine alfabetico)");
		LinkedList<Iscritto> listaIscritti = new LinkedList<Iscritto>(n.elencoIscritti());
		for(Iscritto i : listaIscritti)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");
	
		
		System.out.println("\n/***************************************************/");
		System.out.println("/**  R2. ENTITA', CENTRI DI FORMAZIONE ED AZIENDE **/");
		System.out.println("/***************************************************/\n");

		System.out.println("Definito nuovo centro di formazione");

		Entita e2 = n.nuovaEntita("Università del bosco", "Italia", "Strada del fogliame 12, Bolzano");
		
		System.out.println(" Nome: "+e2.getNome());
		System.out.println(" Nazione: "+e2.getNazione());
		System.out.println(" Indirizzo: "+e2.getIndirizzo());		
		
		System.out.println("\nDefinita nuova azienda");

		Entita e1 = n.nuovaEntita("Rossi Mobili S.r.l.", "Italia", "Via del legname 36, Trento", "Lavorazione del legno", 2);
		
		System.out.println(" Nome: "+e1.getNome());
		System.out.println(" Nazione: "+e1.getNazione());
		System.out.println(" Indirizzo: "+e1.getIndirizzo());
		if(e1 instanceof Azienda) {
			System.out.println(" Settore: "+((Azienda)e1).getSettore());
			System.out.println(" Num. dipendenti: "+((Azienda)e1).getNumeroDipendenti());
		}

		System.out.println("\nDefinite altre entita");
		n.nuovaEntita("Scuola di giornalismo", "Italia", "Via del Quotidiano 3, Roma");
		n.nuovaEntita("Liceo del legno", "Italia", "Piazza delle betulle 36, Belluno");
		n.nuovaEntita("Universite' du bois", "France", "Rue de la foret 87, Paris");
		n.nuovaEntita("Technology Institute", "United Kingdom", "Street of Technology 111, London");
		n.nuovaEntita("Technology Institute", "Ireland", "Market District 5678, Dublin", "ICT", 450);

		
		System.out.println("\nElenco centri di formazione in Italia (ordine alfabetico)");
		LinkedList<CentroDiFormazione> listaEntiFormazione = new LinkedList<CentroDiFormazione>(n.elencoCentriDiFormazioneInNazionePerNome("Italia"));
		for(CentroDiFormazione e : listaEntiFormazione) {
			System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
			
		}
		
		System.out.println("\nElenco entita' (ordine alfabetico, in caso di omonimie, prima l'azienda)");
		LinkedList<Entita> listaEntita = new LinkedList<Entita>(n.elencoEntita());
		for(Entita e : listaEntita) {
			if(e instanceof Azienda)
				System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"' "+((Azienda)e).getSettore()+"' '"+((Azienda)e).getNumeroDipendenti()+"'");
			else if(e instanceof CentroDiFormazione)
				System.out.println(" '"+e.getNome()+"' '"+e.getNazione()+"' '"+e.getIndirizzo()+"'");
			
		}

		System.out.println("\n/**********************************************/");
		System.out.println("/**  R3. PERIODI DI FORMAZIONE ED IN AZIENDA **/");
		System.out.println("/**********************************************/\n");

		System.out.println("Definita formazione per l'iscritto con identificativo '"+i1.getId()+"'");

		n.nuovoPeriodoDiFormazione(i1.getId(), "Liceo del legno", "19800903", "19850609", "Diploma di Perito del legno");
		n.nuovoPeriodoDiFormazione(i1.getId(), "Universite' du bois", "19861012", "19900401", "Diplome de Maitre charpentier");

		System.out.println("\nDefiniti ruoli in azienda per l'iscritto con identificativo '"+i1.getId()+"'");

		n.nuovoPeriodoInAzienda(i1.getId(), "Rossi Mobili S.r.l.", "19921008", "20190214", "Amministratore unico");

		
		System.out.println("\nFormazione per l'iscritto con identificativo '"+i1.getId()+"' (date decrescenti)");

		String stringaTitoliFormazione = n.titoliFormazioneDateCrescenti(i1.getId());
		System.out.println(stringaTitoliFormazione);

		System.out.println("\nRuoli in azienda per l'iscritto con identificativo '"+i1.getId()+"' (date crescenti)");

		String stringaRuoliAzienda = n.ruoliAziendaDateCrescenti(i1.getId());
		System.out.println(stringaRuoliAzienda);

		
		System.out.println("\n/***********************************/");
		System.out.println("/**       R4. CONNESSIONI        **/");
		System.out.println("/***********************************/\n");

		System.out.println("Definite connessioni");
		
		n.nuovaConnessione("Mario-Rossi", "Gianni-Verdi");
		n.nuovaConnessione("Francesca-Gialli", "Mario-Rossi");

		n.nuovaConnessione("Francesca-Gialli", "Mario-Rossi-1");

		System.out.println("\nConnessioni per l'iscritto con identificativo 'Mario-Rossi' (ordine alfabetico)");
		LinkedList<Iscritto> listaConnessioni = new LinkedList<Iscritto>(n.elencoConnessioni("Mario-Rossi"));
		for(Iscritto i : listaConnessioni)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");

		System.out.println("\nConnessioni suggerite per l'iscritto con identificativo 'Mario-Rossi' (ordine alfabetico)");
		                 listaConnessioni = new LinkedList<Iscritto>(n.elencoConnessioniSuggerite("Mario-Rossi"));
		for(Iscritto i : listaConnessioni)
			System.out.println(" '"+i.getId()+"' '"+i.getNome()+"' '"+i.getCognome()+"' '"+i.getWeb()+"' '"+i.getEmail()+"' '"+i.getDescrizione().substring(0, Math.min(i.getDescrizione().length(), 30))+" ...'");
		
	}

}
