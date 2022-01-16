package network_professionisti;

import java.util.*;

public class Network {
	
	private TreeMap<String, Iscritto> iscritti;
	private ArrayList<Entita> entita;
	
	public Network() {
		this.iscritti = new TreeMap<String, Iscritto>();
		this.entita = new ArrayList<Entita>();
	}

	public Iscritto nuovoIscritto(String nome, String cognome, String web, String email, String descrizione) {
		String id_codice = "";
		ArrayList<Iscritto> omonimi = new ArrayList<Iscritto>(this.cercaIscrittoPerNomeCognomeStrict(nome, cognome));
		if (omonimi.size() == 0) {
			id_codice = nome + "-" + cognome;
		} else {
			id_codice = nome + "-" + cognome + "-" + omonimi.size();
		}
		Iscritto nuovoIscritto = new Iscritto(id_codice, nome, cognome, web, email, descrizione);
		this.iscritti.put(id_codice, nuovoIscritto);
		return nuovoIscritto;
	}

	public Iscritto cercaIscrittoPerId(String id) {
		return this.iscritti.get(id);
	}
	
	public Collection<Iscritto> cercaIscrittoPerNomeCognomeStrict(String nome, String cognome) {
		ArrayList<Iscritto> res = new ArrayList<Iscritto>();
		for (Iscritto i: this.iscritti.values()) {
			if (i.getNome().contentEquals(nome) && i.getCognome().contentEquals(cognome)) {
				res.add(i);
			}
		}
		return res;
	}
	
	public Collection<Iscritto> cercaIscrittoPerNomeCognome(String nome, String cognome) {
		ArrayList<Iscritto> res = new ArrayList<Iscritto>();
		for (Iscritto i: this.iscritti.values()) {
			if (i.getNome().contains(nome) && i.getCognome().contains(cognome)) {
				res.add(i);
			}
		}
		return res;
	}

	public Collection<Iscritto> elencoIscritti() {
		ArrayList<Iscritto> res = new ArrayList<Iscritto>(this.iscritti.values());
		return res;
	}
	
	public Entita nuovaEntita(String nome, String nazione, String indirizzo) throws EccezioneEntitaGiaDefinita {
		boolean unique = true;
		CentroDiFormazione nuovoCentro = new CentroDiFormazione(nome, nazione, indirizzo);
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'C' && e.getNome().contentEquals(nome)) {
				unique = false;
			}
		}
		
		if (unique) {
			this.entita.add(nuovoCentro);
			return nuovoCentro;
		} else {
			throw new EccezioneEntitaGiaDefinita();
		}
	}

	public Entita nuovaEntita(String nome, String nazione, String indirizzo, String settore, int numeroDipendenti) throws EccezioneEntitaGiaDefinita {
		boolean unique = true;
		Azienda nuovaAzienda = new Azienda(nome, nazione, indirizzo, settore, numeroDipendenti);
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'A' && e.getNome().contentEquals(nome)) {
				unique = false;
			}
		}
		
		if (unique) {
			this.entita.add(nuovaAzienda);
			return nuovaAzienda;
		} else {
			throw new EccezioneEntitaGiaDefinita();
		}
	}
	
	public Collection<Azienda> elencoAziendePerNome(){
		ArrayList<Azienda> elencoAziende = new ArrayList<Azienda>();
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'A') {
				elencoAziende.add((Azienda) e);
			}
		}
		Collections.sort(elencoAziende, Azienda.comparatorDipendenti);
		return elencoAziende;
	}			

	public Collection<Azienda> elencoAziendePerNumeroDipendenti(){
		ArrayList<Azienda> elencoAziende = new ArrayList<Azienda>();
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'A') {
				elencoAziende.add((Azienda) e);
			}
		}
		Collections.sort(elencoAziende, Entita.comparatorNome);
		return elencoAziende;
	}			
	
	public Collection<CentroDiFormazione> elencoCentriDiFormazionePerNome(){
		ArrayList<CentroDiFormazione> elencoCdf = new ArrayList<CentroDiFormazione>();
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'C') {
				elencoCdf.add((CentroDiFormazione) e);
			}
		}
		Collections.sort(elencoCdf, Entita.comparatorNome);
		return elencoCdf;
	}			

	public Collection<CentroDiFormazione> elencoCentriDiFormazioneInNazionePerNome(String nazione){
		ArrayList<CentroDiFormazione> elencoCdf = new ArrayList<CentroDiFormazione>();
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'C' && e.getNazione().contentEquals(nazione)) {
				elencoCdf.add((CentroDiFormazione) e);
			}
		}
		Collections.sort(elencoCdf, Entita.comparatorNome);
		return elencoCdf;
	}			

	public Collection<Entita> elencoEntita(){
		Collections.sort(this.entita, Entita.comparatorNome);
		return this.entita;
	}			
	
	public void nuovoPeriodoDiFormazione(String idIscritto, String nomeCentroFormazione,String da, String a, String titolo) {
		Iscritto i = this.cercaIscrittoPerId(idIscritto);
		CentroDiFormazione cdf = null;
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'C' && e.getNome().contentEquals(nomeCentroFormazione)) {
				cdf = (CentroDiFormazione) e;
				break;
			}
		}
		
		if (i == null || cdf == null) {
			return;
		}		
		i.addPeriodo(cdf, da, a, titolo);
		
	}

	public String titoliFormazioneDateCrescenti(String idIscritto) {
		String s = "";
		Iscritto i = this.cercaIscrittoPerId(idIscritto);
		ArrayList<Periodo> periodi = new ArrayList<Periodo>(i.getPeriodiCentro());
		Collections.sort(periodi, Periodo.comparatorData);
		
		if (periodi.size() == 0) {
			return s;
		}
		
		for (Periodo p: periodi) {
			s += p.getEntita().getNome() + ";" + p.getDa() + ";" + p.getA() + ";" + p.getTitolo() + "\n";
		}
		
		return s.substring(0, s.length()-1);
	}
	
	public String titoliFormazioneDateDecrescenti(String idIscritto) {
		String s = "";
		Iscritto i = this.cercaIscrittoPerId(idIscritto);
		ArrayList<Periodo> periodi = new ArrayList<Periodo>(i.getPeriodiCentro());
		Collections.sort(periodi, Periodo.comparatorData);
		Collections.reverse(periodi);
		
		if (periodi.size() == 0) {
			return s;
		}
		
		for (Periodo p: periodi) {
			s += p.getEntita().getNome() + ";" + p.getDa() + ";" + p.getA() + ";" + p.getTitolo() + "\n";
		}
		
		return s.substring(0, s.length()-1);
	}

	public void nuovoPeriodoInAzienda(String idIscritto, String nomeAzienda,String da, String a, String ruolo) {
		Iscritto i = this.cercaIscrittoPerId(idIscritto);
		Azienda az = null;
		for (Entita e: this.entita) {
			if (e.getTipologia() == 'A' && e.getNome().contentEquals(nomeAzienda)) {
				az = (Azienda) e;
				break;
			}
		}
		
		if (i == null || a == null) {
			return;
		}		
		i.addPeriodo(az, da, a, ruolo);
	}
	
	public String ruoliAziendaDateCrescenti(String idIscritto) {
		String s = "";
		Iscritto i = this.cercaIscrittoPerId(idIscritto);
		ArrayList<Periodo> periodi = new ArrayList<Periodo>(i.getPeriodiAzienda());
		Collections.sort(periodi, Periodo.comparatorData);
		
		if (periodi.size() == 0) {
			return s;
		}
		
		for (Periodo p: periodi) {
			s += p.getEntita().getNome() + ";" + p.getDa() + ";" + p.getA() + ";" + p.getTitolo() + "\n";
		}
		
		return s.substring(0, s.length()-1);
	}
	
	public String ruoliAziendaDateDecrescenti(String idIscritto) {
		String s = "";
		Iscritto i = this.cercaIscrittoPerId(idIscritto);
		ArrayList<Periodo> periodi = new ArrayList<Periodo>(i.getPeriodiAzienda());
		Collections.sort(periodi, Periodo.comparatorData);
		Collections.reverse(periodi);
		
		if (periodi.size() == 0) {
			return s;
		}
		
		for (Periodo p: periodi) {
			s += p.getEntita().getNome() + ";" + p.getDa() + ";" + p.getA() + ";" + p.getTitolo() + "\n";
		}
		
		return s.substring(0, s.length()-1);	}
	
	public void nuovaConnessione(String idIscritto1, String idIscritto2) {
		Iscritto i1 = this.cercaIscrittoPerId(idIscritto1);
		Iscritto i2 = this.cercaIscrittoPerId(idIscritto2);
		
		if (i1 == null || i2 == null) {
			return;
		}
		
		if (!i1.isConnesso(i2)) {
			i1.addConnessione(i2);
			i2.addConnessione(i1);
		}
	}
	
	public Collection<Iscritto> elencoConnessioni(String idIscritto){
		Iscritto i1 = this.cercaIscrittoPerId(idIscritto);
		if (i1 == null) {
			return null;
		}
		
		return i1.getConnessi();
	}
	
	public Collection<Iscritto> elencoConnessioniSuggerite(String idIscritto){
		Iscritto i1 = this.cercaIscrittoPerId(idIscritto);
		if (i1 == null) {
			return null;
		}
		
		ArrayList<Iscritto> res = new ArrayList<Iscritto>();
		ArrayList<Iscritto> esclusi = new ArrayList<Iscritto>(i1.getConnessi());
		esclusi.add(i1);
		
		for (Iscritto i2: esclusi) {
			for (Iscritto sugg: i2.getConnessi()) {
				if (!esclusi.contains(sugg)) {
					res.add(sugg);
				}
			}
		}
		return res;
	}
	
}

