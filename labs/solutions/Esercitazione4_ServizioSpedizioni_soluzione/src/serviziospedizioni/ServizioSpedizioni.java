package serviziospedizioni;

import java.util.ArrayList;
import java.util.Collection;

public class ServizioSpedizioni {
	
	ArrayList<Corriere> corrieri;
	ArrayList<Collo> colli;
	ArrayList<Spedizione> spedizioni;
	
	public ServizioSpedizioni() {
		this.corrieri = new ArrayList<Corriere>();
		this.colli = new ArrayList<Collo>();
		this.spedizioni = new ArrayList<Spedizione>();
	}
	
	public Corriere registraCorriere(String nome, String cognome, int eta, String citta) {
		String codice = this.generaCodiceCorriere(nome, cognome, eta, citta);
		Corriere corriere = null;
		int cont = 0;
		
		//conta quanti corrieri sono già presenti con tale codice
		for (Corriere c : this.corrieri) {
			if (c.getCodiceCorriere().contains(codice)) {
				cont++;
			}
		}	
		
		if (cont > 0) {
			if (cont == 1) {
				for (Corriere c : this.corrieri) {
					if (c.getCodiceCorriere().contains(codice)) {
						c.codiceCorriere = codice + "_" + cont;
					}
				}
				corriere = new Corriere(codice + "_" + (cont + 1), nome, cognome, eta, citta);
				this.corrieri.add(corriere);
			}
			else {
				corriere = new Corriere(codice + "_" + (cont + 1), nome, cognome, eta, citta);
				this.corrieri.add(corriere);
			}
		}
		
		else {
			corriere = new Corriere(codice, nome, cognome, eta, citta);
			this.corrieri.add(corriere);
		}
		
		return corriere;
	}
	
	private String generaCodiceCorriere(String nome, String cognome, int eta, String citta) {
		return nome.toUpperCase().substring(0, 2) + cognome.toUpperCase().substring(0, 2) + eta + citta.toUpperCase().substring(0, 2);
	}

	public Corriere cercaCorriere(String codiceCorriere) {
		Corriere c = null;
		
		for (Corriere ci : this.corrieri) {
			if (ci.getCodiceCorriere().equals(codiceCorriere)) {
				c = ci;
			}
		}
		
		return c;
	}
	
	public Corriere[] cercaCorrieri(){
		return this.corrieri.toArray(new Corriere[this.corrieri.size()]);
	}
	
	public Standard creaCollo(String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario) {
		
		Standard s = null;
		int cont = 0;
		String codice = "";
		
		for (Collo ci : this.colli) {
			if (ci.getCitta().equals(citta)) {
				cont++;
			}
		}
		
		codice = citta.toUpperCase().substring(0, 2) + "_" + (cont + 1);
		s = new Standard(codice, citta, dataDeposito, indirizzoMittente, indirizzoDestinatario);
		this.colli.add(s);
		
		return s;
	}
	
	public Prioritario creaCollo(String citta, String dataDeposito, String indirizzoMittente, String indirizzoDestinatario, String mailMittente) {
		
		Prioritario p = null;
		int cont = 0;
		String codice = "";
		
		for (Collo ci : this.colli) {
			if (ci.getCitta().equals(citta)) {
				cont++;
			}
		}
		
		codice = citta.toUpperCase().substring(0, 2) + "_" + (cont + 1);
		p = new Prioritario(codice, citta, dataDeposito, indirizzoMittente, indirizzoDestinatario, mailMittente);
		this.colli.add(p);
		
		return p;
	}
	
	public Collo cercaCollo(String codiceCollo) {
		
		Collo c = null;
		
		for (Collo ci : this.colli) {
			if (ci.getCodiceCollo().equals(codiceCollo)) {
				c = ci;
			}
		}
		
		return c;
	}
	
	public Collo[] cercaColli() {
		return this.colli.toArray(new Collo[this.colli.size()]);
	}
	
	public Spedizione creaSpedizione(String codiceCollo, String citta, String dataConsegna) {
		
		Spedizione s = null;
		Collo c = this.cercaCollo(codiceCollo);
		int min = 3;
		Corriere cMin = null;
		
		if (c != null) {
			Corriere[] cc = this.corrieriPerCitta(citta);
			if (cc != null) {
				for (Corriere ci : cc) {
					if (ci.getSpedizioniPerData(dataConsegna).size() < 3 && ci.getSpedizioniPerData(dataConsegna).size() < min) {
						min = ci.getSpedizioniPerData(dataConsegna).size();
						cMin = ci;
					}
				}
				if (cMin != null) {
					
					String codice = "";
					int cont = 0;
					
					if (c instanceof Standard) {
						codice = "S_";
						for (Spedizione si : this.spedizioni) {
							if (si.collo instanceof Standard) {
								cont++;
							}
						}
					}
					else if (c instanceof Prioritario) {
						codice = "P_";
						for (Spedizione si : this.spedizioni) {
							if (si.collo instanceof Prioritario) {
								cont++;
							}
						}
					}
					
					codice = codice + citta.toUpperCase().substring(0, 2) + "_" + (cont + 1);
					
					s = new Spedizione(codice, c, cMin, citta, dataConsegna);
					this.spedizioni.add(s);
					cMin.assegnaSpedizione(s);
				}
			}
		}
		
		return s;
	}
	
	private Corriere[] corrieriPerCitta(String citta) {
		
		ArrayList<Corriere> cc = new ArrayList<>();
		Corriere[] cArr = null;
		
		for (Corriere ci : this.corrieri) {
			if (ci.getCitta().equals(citta)) {
				cc.add(ci);
			}
		}
		
		if (cc.size() > 0) {
			cArr = cc.toArray(new Corriere[cc.size()]);
		}
		
		return cArr;
	}

	public Spedizione cercaSpedizione(String codiceSpedizione) {
		
		Spedizione s = null;
		
		for (Spedizione si : this.spedizioni) {
			if (si.codice.equals(codiceSpedizione)) {
				s = si;
			}
		}
		
		return s;
	}
	
	public Spedizione[] cercaSpedizioni() {
		return this.spedizioni.toArray(new Spedizione[this.spedizioni.size()]);
	}
	
	public Collection<Corriere> elencoCorrieriPerEta() {
		
		ArrayList<Corriere> cc = new ArrayList<>();
		int min;
		Corriere cMin = null;
		
		for (int i = 0; i < this.corrieri.size(); i++) {
			min = 0;
			for (Corriere ci : this.corrieri) {
				if (!cc.contains(ci)) {
					if (min == 0) {
						min = ci.getEta();
						cMin = ci;
					}
					else {
						if (ci.getEta() < min) {
							min = ci.getEta();
							cMin = ci;
						}
					}
					
				}
			}
			cc.add(cMin);			
		}
		
		
		return cc;
	}
	
	public Collection<Spedizione> elencoSpedizioniCorrierePerData(String codiceCorriere) {
		ArrayList<Spedizione> ss = new ArrayList<>();
		Corriere c = this.cercaCorriere(codiceCorriere);
		String min = "";
		Spedizione sMin = null;
		
		if (c == null)
			return null;
		
		for (int i = 0; i < c.spedizioni.size(); i++) {
			min = "";
			for (Spedizione si : c.spedizioni) {
				if (!ss.contains(si)) {
					if (min == "") {
						min = si.dataConsegna;
						sMin = si;
					}
					else {
						if (si.dataConsegna.compareTo(min) < 0) {
							min = si.dataConsegna;
							sMin = si;
						}
					}
					
				}
			}
			ss.add(sMin);			
		}
		
		
		return ss;
	}

	public Collection<Spedizione> elencoSpedizioniCittaPerPriorita(String citta) {
		ArrayList<Spedizione> ss = new ArrayList<>();
		
		ArrayList<Spedizione> ssStandard = new ArrayList<>(spedizioniStandard());	
		ssStandard = new ArrayList<>(elencoSpedizioniPerData(ssStandard));
		ArrayList<Spedizione> ssPrioritarie = new ArrayList<>(spedizioniPrioritarie());
		ssPrioritarie = new ArrayList<>(elencoSpedizioniPerData(ssPrioritarie));
		
		for (Spedizione si : ssPrioritarie) {
			if (si.citta.equals(citta)) {
				ss.add(si);
			}
		}
		for (Spedizione si : ssStandard) {
			if (si.citta.equals(citta)) {
				ss.add(si);
			}
		}
		
		return ss;
	}
	
	private Collection<Spedizione> spedizioniStandard(){
		
		ArrayList<Spedizione> ss = new ArrayList<>();
		
		for (Spedizione si : this.spedizioni) {
			if (si.collo instanceof Standard) {
				ss.add(si);
			}
		}
		
		return ss;
	}
	
	private Collection<Spedizione> spedizioniPrioritarie(){
		
		ArrayList<Spedizione> ss = new ArrayList<>();
		
		for (Spedizione si : this.spedizioni) {
			if (si.collo instanceof Prioritario) {
				ss.add(si);
			}
		}
		
		return ss;
	}
	
	private Collection<Spedizione> elencoSpedizioniPerData(Collection<Spedizione> spedizioni) {
		ArrayList<Spedizione> ss = new ArrayList<>();
		String min = "";
		Spedizione sMin = null;
		
		for (int i = 0; i < spedizioni.size(); i++) {
			min = "";
			for (Spedizione si : spedizioni) {
				if (!ss.contains(si)) {
					if (min == "") {
						min = si.dataConsegna;
						sMin = si;
					}
					else {
						if (si.dataConsegna.compareTo(min) < 0) {
							min = si.dataConsegna;
							sMin = si;
						}
					}
					
				}
			}
			ss.add(sMin);			
		}
		
		
		return ss;
	}
}
