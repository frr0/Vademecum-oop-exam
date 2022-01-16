package aeroporto;

public class Aeroporto {
	
	String denominazione;
	String indirizzo;
	int numeroAerei;
	int numeroDecolli;
	Aereo[] aerei;
	Viaggio[] viaggi;
	int contatoreAerei;
	int contatoreViaggi;
	
	public Aeroporto(String denominazione, String indirizzo, int numeroAerei) {
		this.denominazione = denominazione;
		this.indirizzo = indirizzo;
		this.numeroAerei = numeroAerei;
		this.aerei = new Aereo[numeroAerei];
		this.viaggi = new Viaggio[numeroAerei];
		this.contatoreAerei = 0;
		this.contatoreViaggi = 0;
	}

	public String getDenominazione() {
		return this.denominazione;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}
	
	public int getNumeroAerei () {
		return this.numeroAerei;
	}
	
	public void setNumeroDecolli(int numeroDecolli){
		this.numeroDecolli = numeroDecolli;
	}
	
	public String descrizioneAeroporto() {
		return this.numeroAerei + " (" + this.numeroDecolli + ")";
	}
	
	public int aggiungiAereo(String modello, int capienza, int chilometriAutonomia) {
		
		Aereo a = new Aereo(this.contatoreAerei, modello, capienza, chilometriAutonomia);
		
		if (aereoPresente(a) == -1 && contatoreAerei < this.numeroAerei) {
			this.aerei[contatoreAerei] = a;
			return contatoreAerei++;
		}
		
		else 
			return aereoPresente(a);
	}
	
	private int aereoPresente(Aereo a) {
		int aereoPresente = -1;
		
		for(int i=0; i<this.contatoreAerei; i++)
			if (aerei[i].modello == a.modello && aerei[i].capienza == a.capienza && aerei[i].chilometriAutonomia == a.chilometriAutonomia)
				aereoPresente = i;
		
		return aereoPresente;
	}
	
	public String aereo(int identificativoAereo) {
		String res = null;
		
		if (this.aerei[identificativoAereo] != null)
			res = this.aerei[identificativoAereo].modello + ";" + this.aerei[identificativoAereo].capienza + ";" + this.aerei[identificativoAereo].chilometriAutonomia;
		
		return res;
	}

	public String[] aerei() {
		
		String[] res = null;
		
		if (this.contatoreAerei > 0) {
			res = new String[this.contatoreAerei];
			
			for(int i=0; i<this.contatoreAerei; i++) {
				res[i] = aerei[i].id + ";" + aerei[i].modello;
			}
 		}
		
		return res;
	}

	public String aggiungiViaggio(String nomeTratta, int numeroPasseggeri, int chilometriTratta) {
		
		String res = null;
		Aereo a = cercaAereo(numeroPasseggeri, chilometriTratta);
		
		if (a != null) {
			Viaggio v = new Viaggio(nomeTratta, numeroPasseggeri, chilometriTratta, a.id);
			a.setViaggio(v);
			viaggi[contatoreViaggi++] = v;
			res = a.id + ";" + nomeTratta;
		}
		
		return res;
	}

	private Aereo cercaAereo(int numeroPasseggeri, int chilometriTratta) {
		
		Aereo a = null;
		int migliorePosti = -1;
		int miglioreChilometri = -1;
		
		for (int i=0; i<this.contatoreAerei; i++) {
			if(aerei[i].getViaggio() == null) {
				if (aerei[i].capienza >= numeroPasseggeri && aerei[i].chilometriAutonomia >= chilometriTratta) {
					if (migliorePosti==-1 || miglioreChilometri==-1) {
						a = aerei[i];
						migliorePosti = a.capienza - numeroPasseggeri;
						miglioreChilometri = a.chilometriAutonomia - chilometriTratta;
					}
					else {
						if (aerei[i].capienza - numeroPasseggeri < migliorePosti) {
							a = aerei[i];
							migliorePosti = a.capienza - numeroPasseggeri;
							miglioreChilometri = a.chilometriAutonomia - chilometriTratta;
						}
						else if(aerei[i].capienza - numeroPasseggeri == migliorePosti) {
							if (aerei[i].chilometriAutonomia - chilometriTratta < miglioreChilometri) {
								a = aerei[i];
								migliorePosti = a.capienza - numeroPasseggeri;
								miglioreChilometri = a.chilometriAutonomia - chilometriTratta;
							}
						}
					}
				}
			}
		}
		
		return a;
	}

	public String viaggio(int identificativoAereo, String nomeTratta) {
		
		String res = null;
		Aereo a = this.aerei[identificativoAereo];
		
		if (a != null) {
			Viaggio v = a.getViaggio();
			if (v.nomeTratta == nomeTratta)
				res = v.stampaViaggio();
		}
		return res;
	}
	
	
	public String viaggi() {
		
		String res = "";
		
		for(Viaggio vi : this.viaggi) {
			if (vi != null)
				res = res + vi.stampaViaggio() + "\n";
		}
		
		if (res != null)
			res = res.substring(0, res.length() - 1);
		
		return res;
	}

	public String viaggiPerTratta(String nomeTratta) {
		
		String res = "";
		
		for(Viaggio vi : this.viaggi) {
			if (vi != null)
				if (vi.nomeTratta == nomeTratta)
						res = res + vi.stampaViaggio() + "\n";
				
		}
		
		if (res != null)
			res = res.substring(0, res.length() - 1);
		return res;
	}
}

