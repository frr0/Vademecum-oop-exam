package piano_vaccinazioni;

import java.util.*;

public class Piano {
	
	LinkedHashMap<String, Cittadino> cittadini;
	LinkedHashMap<String, LinkedList<Centro>> centriPerRegione;
	LinkedHashMap<String, Centro> centriPerid;
	LinkedList<Vaccinazione> vaccinazioni;
	LinkedHashMap<String, Integer> dosiConsegnatePerRegione;
	LinkedHashMap<String, Integer> dosiEffettuatePerRegione;
	
	public Piano() {
		cittadini = new LinkedHashMap<>();
		centriPerRegione = new LinkedHashMap<String, LinkedList<Centro>>();
		centriPerid = new LinkedHashMap<>();
		vaccinazioni = new LinkedList<>();
		dosiConsegnatePerRegione = new LinkedHashMap<>();
		dosiEffettuatePerRegione = new LinkedHashMap<>();
	}

	public Cittadino registraCittadino(String codiceTesseraSanitaria, String nome, String cognome, String dataDiNascita, String regione) {
		
		cittadini.put(codiceTesseraSanitaria, new Cittadino(nome, cognome, dataDiNascita, regione, codiceTesseraSanitaria));
		
		return cittadini.get(codiceTesseraSanitaria);
	}

	public Collection<Cittadino> elencoCittadiniPerCognomeNome() {
		
		LinkedList<Cittadino> cc = new LinkedList<>(cittadini.values());
		Collections.sort(cc, new ComparatoreCittadinoCognomeNome());
		
		return cc;
	}

	public Collection<Cittadino> elencoCittadiniPerDataDiNascita() {
		
		LinkedList<Cittadino> cc = new LinkedList<>(cittadini.values());
		Collections.sort(cc, new ComparatoreCittadinoDataDiNascita());
		
		return cc;
	}

	public Collection<Cittadino> cercaCittadiniEtaMinima(int etaMinima){
		LinkedList<Cittadino> cc = new LinkedList<>();
		
		for (Cittadino ci : cittadini.values()) {
			if (ci.getEta() >= etaMinima) {
				cc.add(ci);
			}
		}
		
		return cc;
	}
	
	public Centro attivaCentro(String regione, int numeroMassimoDosi) {
		
		Centro c = null;
		
		if (!centriPerRegione.containsKey(regione)) {
			centriPerRegione.put(regione, new LinkedList<>());
		}
		
		String codice = regione.substring(0, 3).toUpperCase() + (centriPerRegione.get(regione).size() + 1);
		c = new Centro(codice, regione, numeroMassimoDosi);
		
		centriPerid.put(codice, c);
		centriPerRegione.get(regione).add(c);
		
		return c;
	}
	
	public Centro cercaCentro(String codiceCentro) {
		return centriPerid.get(codiceCentro);
	}
	
	public void consegnaDosiVaccino(String codiceCentro, char tipoVaccino, int numeroDosi) throws EccezioneConsegnateMenoDosi {		
	
		Centro c = cercaCentro(codiceCentro);
		int dosiConsegnate = 0;
		EccezioneConsegnateMenoDosi eccezione = null;
		
		if (c != null) {
			try {
				c.aggiungiDosi(tipoVaccino, numeroDosi);
				dosiConsegnate = numeroDosi;
			} catch (EccezioneConsegnateMenoDosi e) {
				dosiConsegnate = e.dosiConsegnate;
				eccezione = e;
			}
		}
		
		if ( dosiConsegnatePerRegione.containsKey(c.getRegione())){
			int dosiRegione = dosiConsegnatePerRegione.get(c.getRegione()) + dosiConsegnate;
			dosiConsegnatePerRegione.put(c.getRegione(), dosiRegione);
		}
		else {
			dosiConsegnatePerRegione.put(c.getRegione(), dosiConsegnate);
		}
		
		if (eccezione != null)
			throw eccezione;
	}
	
	public int numeroDosiTipoVaccinoCentro(String codiceCentro, char tipoVaccino){
		
		Centro c = cercaCentro(codiceCentro);
		if (c != null) {
			if (tipoVaccino == 'A')
				return c.dosiA;
			else
				return c.dosiB;
		}
		
		return -1;
	}
	
	public int numeroDosiCentro(String codiceCentro) {
		
		Centro c = cercaCentro(codiceCentro);
		if (c != null) {
			return c.dosiA + c.dosiB;
		}
		
		return -1;
	}
	
	public char vaccina(String codiceTesseraSanitaria, String data) throws EccezioneDosiVaccinoNonDisponibili {
		
		Cittadino c = cittadini.get(codiceTesseraSanitaria);
		Vaccinazione v = null;
		char tipo = ' ';
		
		if (c != null) {
			LinkedList<Centro> centriDellaRegione = centriPerRegione.get(c.getRegione());
			if (c.vaccinazione == null && centriDellaRegione!=null) {
				// prima dose
				for (Centro ci : centriDellaRegione) {
					if (ci.dosiA + ci.dosiB > 0 && v == null) {
						// almeno una dose e disponibile in questo centro
						if (ci.dosiA > 0) {
							// priorita al vaccino A
							v = new Vaccinazione('A', c, ci, data);
							ci.dosiA = ci.dosiA - 1;
							c.vaccinazione = v;
							vaccinazioni.add(v);	
							tipo = 'A';
						}
						else {
							// vaccino B
							v = new Vaccinazione('B', c, ci, data);
							ci.dosiB = ci.dosiB - 1;
							c.vaccinazione = v;
							vaccinazioni.add(v);
							tipo = 'B';
						}
					}
				}
			}
			else if (c.vaccinazione != null && c.richiamo == null && centriDellaRegione!=null) {
				// seconda dose
				char tipolologiaRichiesta = c.vaccinazione.getTipo();
				for (Centro ci : centriDellaRegione) {
					if (tipolologiaRichiesta == 'A' && ci.dosiA > 0 && v == null) {
						// almeno una dose di A e disponibile in questo centro per il richiamo
						v = new Richiamo('A', c, ci, data);
						ci.dosiA = ci.dosiA - 1;
						c.richiamo = v;
						vaccinazioni.add(v);
						tipo = 'A';
					}
					else if (tipolologiaRichiesta == 'B' && ci.dosiB > 0 && v == null) {
						// almeno una dose di B e disponibile in questo centro per il richiamo
						v = new Richiamo('B', c, ci, data);
						ci.dosiB = ci.dosiB - 1;
						c.richiamo = v;
						vaccinazioni.add(v);
						tipo = 'B';
					}
				}
			}
		}
		
		if (v == null) {
			throw new EccezioneDosiVaccinoNonDisponibili();
		}
		else {
			if ( dosiEffettuatePerRegione.containsKey(c.getRegione())){
				dosiEffettuatePerRegione.put(c.getRegione(), dosiEffettuatePerRegione.get(c.getRegione())+1);
			}
			else {
				dosiEffettuatePerRegione.put(c.getRegione(),  1);
			}
		}
		
		return tipo;
	}

	public String stampaUltimaVaccinazioneCittadino(String codiceTesseraSanitaria) {
		
		Cittadino c = cittadini.get(codiceTesseraSanitaria);
		String s = "";
		
		if (c != null) {
			if (c.richiamo != null)
				s = c.richiamo.toString();
			else 
				s = c.vaccinazione.toString();
		}
		
		return s;
	}
	
	public String stampaVaccinazioni() {
		
		String s = "";
		for (Vaccinazione vi : vaccinazioni) {
			s = s + vi.toString() + "\n";
		}
		
		return s;
	}
	
	public double percentualeUtilizzoDosi(String regione) {
		
		double effettuate = dosiEffettuatePerRegione.get(regione);
		double ricevute = dosiConsegnatePerRegione.get(regione);
		
		
		return (effettuate/ricevute)*100;
	}

}

