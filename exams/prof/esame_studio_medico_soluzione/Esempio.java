import java.util.*;

import studiomedico.*;

public class Esempio {

	public static void main(String[] args) throws EccezioneSuperatoNumeroMassimoAssistiti, EccezioneOrarioVisitaErrato {
			
		Studio s = new Studio();
		
		System.out.println("/***********************************/");
		System.out.println("/**           R1. MEDICI          **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("* Aggiunto nuovo medico");
		
		Medico m1 = s.aggiungiMedico("Dott.", "Stammibene", "Alberto", "Medicina interna");

		System.out.println("\n* Informazioni relative al medico aggiunto:\n");

		System.out.println("Titolo: "+m1.getTitolo());
		System.out.println("Cognome: "+m1.getCognome());
		System.out.println("Nome: "+m1.getNome());
		System.out.println("Specializzazione: "+m1.getSpecializzazione());
		
		System.out.println("\n* Aggiunti altri medici");
		
		s.aggiungiMedico("Dott.ssa", "Sanapelli", "Michela", "Dermatologia");
		s.aggiungiMedico("Dott.", "Curacuori", "Luigi", "Cardiologia");

		System.out.println("\n* Elenco medici aggiunti (ordine alfabetico):\n");

		LinkedList<Medico> listaMedici = new LinkedList<Medico>(s.elencoMediciInOrdineAlfabetico());
		for(Medico m : listaMedici)
			System.out.println(""+m.getTitolo()+" "+m.getCognome()+" "+m.getNome()+" ("+m.getSpecializzazione()+")");
		
		System.out.println("* Cerca il Dott. Curacuori Luigi");
		
		Medico m = s.cercaMedico("Curacuori", "Luigi");
		
		System.out.println("\n* Informazioni relative al medico trovato:\n");

		System.out.println("Titolo: "+m.getTitolo());
		System.out.println("Cognome: "+m.getCognome());
		System.out.println("Nome: "+m.getNome());
		System.out.println("Specializzazione: "+m.getSpecializzazione());

		
		System.out.println("\n\n/***********************************/");
		System.out.println("/**       R2. ORARI DI VISITA     **/");
		System.out.println("/***********************************/\n");

		System.out.println("* Aggiunta di un nuovo orario di visita per il Dott. Stammibene Alberto\n");

		boolean esito = s.aggiungiOrarioVisitaMedico("Stammibene", "Alberto", "MAR", 14, 16);
		if(esito)
			System.out.println("\n* Orario aggiunto (nessuna sovrapposizione)");
		else
			System.out.println("\n* Orario non aggiunto (sovrapposizione)");

		System.out.println("\n* Aggiunti altri orari di visita per il Dott. Stammibene Alberto");

		s.aggiungiOrarioVisitaMedico("Stammibene", "Alberto", "LUN", 9, 11);
		s.aggiungiOrarioVisitaMedico("Stammibene", "Alberto", "VEN", 11, 13);
		s.aggiungiOrarioVisitaMedico("Stammibene", "Alberto", "MAR", 9, 11);

		s.aggiungiOrarioVisitaMedico("Curacuori", "Luigi", "MER", 13, 17);

		System.out.println("\n* Orari di visita Del Dott. Stammibene Alberto (ordine cronologico):\n");

		String orari = s.stampaOrariVisitaMedicoInOrdineCronologico("Stammibene", "Alberto");
		System.out.println(orari);
		
		System.out.println("\n* Orari di visita dei medici dello studio  (ordine cronologico)s:\n");

		orari = s.stampaOrariVisitaStudioInOrdineCronologico();
		System.out.println(orari);

		
		System.out.println("\n/***********************************/");
		System.out.println("/**         R3. ASSISTITI         **/");
		System.out.println("/***********************************/\n");
		
		System.out.println("* Aggiunto nuovo assistito per il Dott. Stammibene Alberto");
		
		Assistito a1 = s.aggiungiAssistito("RSSMRA66H06H501B", "Rossi", "Mario", "19660606", "Stammibene", "Alberto", "20200131");
		
		System.out.println("\n* Informazioni relative all'assistito aggiunto:\n");

		System.out.println("Codice fiscale: "+a1.getCodiceFiscale());
		System.out.println("Cognome: "+a1.getCognome());
		System.out.println("Nome: "+a1.getNome());
		System.out.println("Data di nascita: "+a1.getDataNascita());
		System.out.println("Dal: "+a1.getDal());
		System.out.println("Medico: "+a1.getCognomeMedico()+" "+a1.getNomeMedico());

		System.out.println("\n* Aggiungi altri assistiti per il Dott. Stammibene Alberto");
		
		s.aggiungiAssistito("BNCGNN11S51L219J", "Bianchi", "Giovanna", "19111111", "Stammibene", "Alberto", "20200124");
		s.aggiungiAssistito("VRDMHL77L07F205M", "Verdi", "Michele", "19770707", "Stammibene", "Alberto", "20191210");
		
		System.out.println("\n* Elenco assistiti per il Dott. Stammibene Alberto (ordine alfabetico):\n");
		
		LinkedList<Assistito> listaAssistiti = new LinkedList<Assistito>(s.elencoAssistitiInOrdineAlfabetico("Stammibene", "Alberto"));
		for(Assistito aTemp : listaAssistiti)
			System.out.println(aTemp.getCodiceFiscale()+" "+aTemp.getCognome()+" "+aTemp.getNome()+" "+aTemp.getDataNascita());

		
		System.out.println("\n\n/***********************************/");
		System.out.println("/**       R4. PRENOTAZIONI        **/");
		System.out.println("/***********************************/\n");

		System.out.println("* Nuova prenotazione per il Dott. Stammibene Alberto\n");

		String codicePrenotazione = s.nuovaPrenotazione("RSSMRA66H06H501B", "MAR", 9, 11);
		s.nuovaPrenotazione("RSSMRA66H06H501B", "MAR", 14, 16);

		
		System.out.println("Codice prenotazione: "+codicePrenotazione);

		System.out.println("* Cerca prenotazione "+codicePrenotazione+"\n");
		
		esito = s.verificaEsistenzaPrenotazione(codicePrenotazione);
		
		if(esito)
			System.out.println("Trovata");
		else
			System.out.println("Non trovata");
		
		System.out.println("\n* Prenotazioni dello studio (ordine di inserimento)\n");

		String prenotazioni = s.stampaPrenotazioniStudioInOrdineInserimento();
		
		System.out.println(""+prenotazioni);
		
	}

}
