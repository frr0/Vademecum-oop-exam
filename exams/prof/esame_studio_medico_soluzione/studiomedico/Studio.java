package studiomedico;

import java.util.*;

public class Studio {
	
	TreeMap<String, Medico> medici;
	TreeMap<String, Assistito> assistiti;
	TreeMap<String, Prenotazione> prenotazioni;
	
	public Studio() {
		medici = new TreeMap<String, Medico>();
		assistiti = new TreeMap<String, Assistito>();
		prenotazioni = new TreeMap<String, Prenotazione>();
	}

	public Medico aggiungiMedico(String titolo, String cognome, String nome, String specializzazione) {
		
		Medico m = medici.get(cognome+nome);
		
		if (m == null) {
			m = new Medico(titolo, cognome, nome, specializzazione);
			medici.put(cognome+nome, m);
		}
		
		return m;
	}

	public Collection<Medico> elencoMediciInOrdineAlfabetico() {
		return medici.values();
	}

	public Collection<Medico> elencoMediciInOrdineAlfabetico(String specializzazione) {
		
		LinkedList<Medico> mm = null;
		
		if (!medici.isEmpty()) {
			mm = new LinkedList<Medico>();
			for (Medico mi : elencoMediciInOrdineAlfabetico()) {
				if (mi.getSpecializzazione().equals(specializzazione)) {
					mm.add(mi);
				}
			}
		}
		
		return mm;
	}

	public Medico cercaMedico(String cognome, String nome) {		
		return medici.get(cognome+nome);
	}

	public boolean aggiungiOrarioVisitaMedico(String cognome, String nome, String giorno, int daOra, int aOra) {
		
		Medico m = medici.get(cognome+nome);
		boolean orarioAggiunto = false;
		
		if (m != null) {
			orarioAggiunto = m.aggiungiOrario(giorno, daOra, aOra);
		}
		
		return orarioAggiunto;
	}

	public String stampaOrariVisitaMedicoInOrdineCronologico(String cognome, String nome) {
		
		String orari = null;
		Medico m = cercaMedico(cognome, nome);
		
		if (m != null) {
			orari = m.descriviOrari();
		}
		
		return orari;
	}
	
	public String stampaOrariVisitaStudioInOrdineCronologico() {
		String orari = "";
		
		if (!medici.isEmpty()) {
			for (Medico mi: medici.values()) {
				orari = orari + mi.descriviti() + "\n";
				String orariMedico = stampaOrariVisitaMedicoInOrdineCronologico(mi.cognome, mi.nome);
				if (orariMedico == null) {
					orari = orari + "-\n";
				}
				else {
					orari = orari + orariMedico + "\n";
				}
			}
			orari = orari.substring(0, orari.length()-1);
		}
		
		if (orari == "") {
			orari = null;
		}
		
		return orari;
	}	
	
	public Assistito aggiungiAssistito(String codiceFiscale, String cognome, String nome, String dataNascita, String cognomeMedico, String nomeMedico, String dal) throws EccezioneSuperatoNumeroMassimoAssistiti {
		
		Assistito a = null;
		Medico m = cercaMedico(cognomeMedico, nomeMedico);
		
		if (m != null) {
			if(m.getAssistiti().size() == 100) {
				throw new EccezioneSuperatoNumeroMassimoAssistiti();
			}
			else {
				if (assistiti.get(codiceFiscale)!=null) {
					a = assistiti.get(codiceFiscale);
				}
				else {
					a = new Assistito(codiceFiscale, cognome, nome, dataNascita, dal, null, m);
					assistiti.put(codiceFiscale, a);
					m.aggiungiAssistito(a);
				}
			}
		}
		
		return a;
	}
	
	public void terminaAssistenza(String codiceFiscale, String al) {
		
		Assistito a = assistiti.get(codiceFiscale);
		
		if (a != null) {
			a.setDataFine(al);
		}
		
	}
	
	class ComparatoreAssistitoOrdineAlfabetico implements Comparator<Assistito>{

		@Override
		public int compare(Assistito o1, Assistito o2) {
			String s1 = o1.getCognome()+o1.getNome();
			String s2 = o2.getCognome()+o2.getNome();
			// TODO Auto-generated method stub
			return s1.compareTo(s2);
		}
		
	}
	
	class ComparatoreAssistitoOrdineEta implements Comparator<Assistito>{

		@Override
		public int compare(Assistito o1, Assistito o2) {
			return o1.getDataNascita().compareTo(o2.getDataNascita());
		}
		
	}
	
	public Collection<Assistito> elencoAssistitiInOrdineAlfabetico(String cognome, String nome) {
		
		LinkedList<Assistito> aa = null;
		Medico m = medici.get(cognome+nome);
		
		if (m != null && !m.getAssistiti().isEmpty()) {
			
			aa = new LinkedList<Assistito>(m.getAssistiti());
			Collections.sort(aa, new ComparatoreAssistitoOrdineAlfabetico());
		}
		
		return aa;
	}
	
	public Collection<Assistito> elencoAssistitiInOrdineEta(String cognome, String nome) {
		LinkedList<Assistito> aa = null;
		Medico m = medici.get(cognome+nome);
		
		if (m != null && !m.getAssistiti().isEmpty()) {
			
			aa = new LinkedList<Assistito>(m.getAssistiti());
			Collections.sort(aa, new ComparatoreAssistitoOrdineEta());
		}
		
		return aa;
	}
	
	public Medico cercaMedicoPerAssistito(String codiceFiscale) {
		Assistito a = assistiti.get(codiceFiscale);
		Medico m = null;
		
		if (a != null) {
			 m = a.getMedico();
		}
		
		return m;
	}
	
	public String nuovaPrenotazione(String codiceFiscale, String giorno, int daOra, int aOra) throws EccezioneOrarioVisitaErrato {
		
		Assistito a = assistiti.get(codiceFiscale);
		String codicePrenotazione = null;
		
		if (a != null) {
			Medico m = a.getMedico();
			if (m.getOrario(giorno, daOra, aOra)==null) {				
				throw new EccezioneOrarioVisitaErrato();
			}
			else {
				Orario o = m.getOrario(giorno, daOra, aOra);
				codicePrenotazione = (prenotazioni.size() + 1) + "-" + m.cognome.substring(0, 3).toUpperCase() + "-" + giorno.toUpperCase() + "-" + o.orarioInizio + "-" + o.orarioFine;
				Prenotazione p = new Prenotazione(codicePrenotazione, m, o, a);
				prenotazioni.put(codicePrenotazione, p);
			}
		}
		
		return codicePrenotazione;
	}
	
	public boolean verificaEsistenzaPrenotazione(String codicePrenotazione) {
		return prenotazioni.get(codicePrenotazione) != null;
	}
	
	public String stampaPrenotazioniStudioInOrdineInserimento() {
		
		String elenco = "";
		
		if (!prenotazioni.isEmpty()) {
			for (Prenotazione pi : prenotazioni.values()) {
				elenco = elenco + pi.codicePrenotazione + ", " + pi.assistito.getCodiceFiscale() + ";";
			}	
		}
		
		if (elenco == "")
			elenco = null;
		
		return elenco;
	}
	
	
}
