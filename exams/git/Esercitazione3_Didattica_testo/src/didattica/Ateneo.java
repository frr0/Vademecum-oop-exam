package didattica;

public class Ateneo {
	
	private Corso corsi[];
	private int ultimoCorso;
	private Docente docenti[];
	private int ultimoDocente;
	private Blocco blocchi[];

	public Ateneo() {
		this.corsi = new Corso[1000];
		this.ultimoCorso = -1;
		this.docenti = new Docente[500];
		this.ultimoDocente = -1;
	}
	
	public Corso nuovoCorso(String nome, int numeroOre, int numeroSquadre, String periodo, String corsoDiLaurea) {
		if (ultimoCorso + 1 < 1000) {
			ultimoCorso++;
			this.corsi[ultimoCorso] = new Corso(ultimoCorso, nome, numeroOre, numeroSquadre, periodo, corsoDiLaurea);
			return corsi[ultimoCorso];
		} else {
			return null;
		}
	}

	public Corso cercaCorso(String codiceCorso) {
		for (int i=0; i<this.ultimoCorso + 1; i++) {
			if (this.corsi[i].getCodice().contentEquals(codiceCorso)) {
				return this.corsi[i];
			}
		}
		return null;
	}

	public Corso[] cercaCorsi(String daCercare) {
		int indiciCorsi [] = new int[this.ultimoCorso + 1];
		int iMax = -1;
		for (int i=0; i<this.ultimoCorso + 1; i++) {
			if (this.corsi[i].getNome().toLowerCase().contains(daCercare.toLowerCase()) || this.corsi[i].getCorsoDiLaurea().toLowerCase().contains(daCercare.toLowerCase())) {
				iMax++;
				indiciCorsi[iMax] = i;
			}
		}
		Corso res [] = new Corso[iMax + 1];
		for (int i=0; i<iMax + 1; i++) {
			res[i] = this.corsi[indiciCorsi[i]];
		}
		return res;
	}
	
	public int nuovoDocente(int codice, String cognome, String nome, String ruolo) {
		Docente questoDocente = new Docente(codice, cognome, nome, ruolo);
		for (int i=0; i<this.ultimoDocente + 1; i++) {
			if (this.docenti[i].getCodice() == codice) {
				this.docenti[i] = questoDocente;
				return this.docenti[i].getCodice();
			}
		}
		this.ultimoDocente++;
		this.docenti[this.ultimoDocente] = questoDocente;
		return this.docenti[this.ultimoDocente].getCodice();
	}
	
	public Docente cercaDocente(int codiceDocente) {
		for (int i=0; i<this.ultimoDocente + 1; i++) {
			if (this.docenti[i].getCodice() == codiceDocente) {
				return this.docenti[i];
			}
		}
		return null;
	}
	
	public boolean assegnaDocenteCorso(String codiceCorso, int codiceDocente) {
		Corso questoCorso = this.cercaCorso(codiceCorso);
		Docente questoDocente = this.cercaDocente(codiceDocente);
		if (questoCorso != null && questoDocente != null && questoCorso.getNumeroDocenti() < 5 && questoDocente.getNumeroCorsi() < 5) {
			questoCorso.inserisciDocente(questoDocente);
			questoDocente.inserisciCorso(questoCorso);
			return true;
		}
		return false;
	}
	
	public Docente titolare(String codiceCorso) {
		Corso questoCorso = this.cercaCorso(codiceCorso);
		if (questoCorso != null) {
			if (questoCorso.getNumeroDocenti() > 0) {
				return questoCorso.getDocenti()[0];
			}
		}
		return null;
		
	}

	public String corsiDocente(int codiceDocente) {
		String res = new String();
		Docente questoDocente = this.cercaDocente(codiceDocente);
		Corso questiCorsiDocente [] = questoDocente.getCorsi();
		for (int i=0; i<questoDocente.getNumeroCorsi(); i++) {
			res += questiCorsiDocente[i].getCodice() + "\n";
		}
		if (res.length() == 0) {
			return null;
		}
		return res.substring(0, res.length() - 1);
	}

	public String docentiCorso(String codiceCorso) {
		String res = new String();
		Corso questoCorso = this.cercaCorso(codiceCorso);
		Docente questiCorsiDocente [] = questoCorso.getDocenti();
		for (int i=0; i<questoCorso.getNumeroDocenti(); i++) {
			res += questiCorsiDocente[i].getCodice() + "\n";
		}
		if (res.length() == 0) {
			return null;
		}
		return res.substring(0, res.length() - 1);
	}
	
	public Lezione nuovoBlocco(String codiceCorso, int codiceDocente, String giorno, String orario) {
		Corso questoCorso = this.cercaCorso(codiceCorso);
		Docente questoDocente = this.cercaDocente(codiceDocente);
		Lezione nuovaLezione = new Lezione(questoCorso, questoDocente, giorno, orario);
		
		// CHECKS
		if (questoCorso == null || questoDocente == null) {
			return null;
		}
		Boolean corsoEsiste = false;
		Boolean docenteEsiste = false;
		for (Corso c : questoDocente.getCorsi()) {
			if (c == questoCorso) {
				corsoEsiste = true;
			}
		}
		
		for (Docente d : questoCorso.getDocenti()) {
			if (d == questoDocente) {
				docenteEsiste = true;
			}
		}
		
		if (corsoEsiste && docenteEsiste) {
			if (this.blocchi == null) {
				Blocco [] tempBlocco = {nuovaLezione};
				this.blocchi = tempBlocco;
			} else {
				Blocco [] tempBlocco = new Blocco[this.blocchi.length + 1];
				int i = 0;
				for (Blocco b : this.blocchi) {
					tempBlocco[i] = b;
					i++;
				}
				tempBlocco[i] = nuovaLezione;
				this.blocchi = tempBlocco;
			}
			return nuovaLezione;
		}
		return null;
	}
	
	public Esercitazione nuovoBlocco(String codiceCorso, int codiceDocente, String giorno, String orario, int numeroSquadra) {
		Corso questoCorso = this.cercaCorso(codiceCorso);
		Docente questoDocente = this.cercaDocente(codiceDocente);
		Esercitazione nuovaEsercitazione = new Esercitazione(questoCorso, questoDocente, giorno, orario, numeroSquadra);
		
		// CHECKS
		if (questoCorso == null || questoDocente == null) {
			return null;
		}
		Boolean corsoEsiste = false;
		Boolean docenteEsiste = false;
		Boolean squadraEsiste = false;
		for (Corso c : questoDocente.getCorsi()) {
			if (c == questoCorso) {
				corsoEsiste = true;
				break;
			}
		}
		
		for (Docente d : questoCorso.getDocenti()) {
			if (d == questoDocente) {
				docenteEsiste = true;
				break;
			}
		}
		
		if (numeroSquadra <= questoCorso.getNumeroSquadre()) {
			squadraEsiste = true;
		}
		
		if (corsoEsiste && docenteEsiste && squadraEsiste) {
			if (this.blocchi == null) {
				Blocco [] tempBlocco = {nuovaEsercitazione};
			} else {
				Blocco [] tempBlocco = new Blocco[this.blocchi.length + 1];
				int i = 0;
				for (Blocco b : this.blocchi) {
					tempBlocco[i] = b;
					i++;
				}
				tempBlocco[i] = nuovaEsercitazione;
				this.blocchi = tempBlocco;
			}
			return nuovaEsercitazione;
		}
		return null;	
	}

	public Blocco[] blocchi() {
		return this.blocchi;
		
	}
	
	public Blocco[] blocchi(int codiceDocente) {
		Blocco[] res = {};
		for (Blocco b : this.blocchi) {
			if (b.getDocente().getCodice() == codiceDocente) {
				if (res == null) {
					Blocco [] tempRes = {b};
					res = tempRes;
					} else {
						Blocco [] tempRes = new Blocco[res.length + 1];
						int i = 0;
						for (Blocco r : res) {
							tempRes[i] = r;
							i++;
						}
						res = tempRes;
				}
			}
		}
		return res;
	}
	
	public Blocco[] blocchi(String tipo) {
		String tipoClasse = null;
		if (tipo.equals("L")) {
			tipoClasse = "Lezione";
		} else if (tipo.equals("EL")){
			tipoClasse = "Esercitazione";
		}
		Blocco[] res = {};
		for (Blocco b : this.blocchi) {
			if (b.getClass().getSimpleName().equals(tipoClasse)) {
				if (res == null) {
					Blocco [] tempRes = {b};
					res = tempRes;
					} else {
						Blocco [] tempRes = new Blocco[res.length + 1];
						int i = 0;
						for (Blocco r : res) {
							tempRes[i] = r;
							i++;
						}
						tempRes[i] = b;
						res = tempRes;
				}
			}
		}
		return res;
	}
}


