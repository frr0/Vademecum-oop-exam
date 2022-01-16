package banca;

public class Banca {
	
	Conto[] conti;
	int numeroConti;
	
	Cliente[] clienti;
	int numeroClienti;
	
	Prestito[] prestiti;
	int numeroPrestiti;

	public Banca() {
		this.conti = new Conto[1000];
		this.numeroConti = 0;
		this.clienti = new Cliente[300];
		this.numeroClienti = 0;
		this.prestiti = new Prestito[1000];
		this.numeroPrestiti = 0;
	}
	
	public Conto nuovoConto(double tassoInteresse, double capitale, String dataApertura, String nomeOperatore, String nomeFiliale) {
		
		Conto c = null;
		
		if (this.numeroConti <= 1000) {
			String codiceConto = "";
			if (this.numeroConti < 10) {
				codiceConto = "00" + this.numeroConti;
			}
			else if(this.numeroConti < 100) {
				codiceConto = "0" + this.numeroConti;
			}
			else {
				codiceConto = "" + this.numeroConti;
			}
			c = new Conto(tassoInteresse, capitale, dataApertura, nomeOperatore, nomeFiliale, codiceConto);
			this.conti[numeroConti++] = c;
		}
		
		return c;
	}

	public Conto cercaConto(String codiceConto) {
		
		Conto c = null;
		
		for (int i = 0; i < this.numeroConti ; i++) {
			if(this.conti[i].getCodice().compareTo(codiceConto)==0) {
				c = this.conti[i];
			}
		}
		
		return c;
	}

	public Conto[] cercaConti(String daCercare) {
		
		Conto[] cc = null;
		int cont = 0;
		
		for (int i = 0; i < this.numeroConti ; i++) {
			if(		this.conti[i].getNomeFiliale().toUpperCase().contains(daCercare.toUpperCase()) ||
					this.conti[i].getNomeOperatore().toUpperCase().contains(daCercare.toUpperCase())) {
				cont++;
			}
		} 		
		
		if(cont > 0) {
			cc = new Conto[cont];
			int j = 0;
			for (int i = 0; i < this.numeroConti ; i++) {
				if(		this.conti[i].getNomeFiliale().toUpperCase().contains(daCercare.toUpperCase()) ||
						this.conti[i].getNomeOperatore().toUpperCase().contains(daCercare.toUpperCase())) {
					cc[j++] = this.conti[i];
				
				} 
			}
		}
		
		return cc;
	}


	public Cliente nuovoCliente(String codiceFiscale, String cognome, String nome, String professione) {
		
		Cliente c = this.cercaCliente(codiceFiscale);
		
		if(c != null) {
			c.setProfessione(professione);
			c.setCognome(cognome);
			c.setNome(nome);
		}
		
		else if (this.numeroClienti < 300) {
			c = new Cliente(codiceFiscale, cognome, nome, professione);
			this.clienti[this.numeroClienti++] = c;
		}
				
		return c;
	}
	
	public Cliente cercaCliente(String codiceFiscale) {
		
		Cliente c = null;
		
		for (int i = 0; i < this.numeroClienti; i++) {
			if(this.clienti[i].getCodiceFiscale().compareTo(codiceFiscale)==0) {
				c = this.clienti[i];
			}
		}
		
		return c;
	}
	
	public boolean[] associaClienteConto(String codiceFiscale, String[] codiciConto) {
		
		boolean[] res = new boolean[codiciConto.length];
		
		for (int i = 0; i < codiciConto.length; i++) {
			
			Cliente cliente = this.cercaCliente(codiceFiscale);
			Conto conto = this.cercaConto(codiciConto[i]);
			
			if (cliente != null && conto != null) {
				cliente.aggiungiConto(conto);
				conto.aggiungiCliente(cliente);
				res[i] = true;
			}
		}
		
		return res;
	}
	
	public Cliente intestatario(String codiceConto) {
		
		Conto c = this.cercaConto(codiceConto);
		Cliente cl = null;
		
		if (c != null) {
			cl = c.getIntestatario();
		}
		
		return cl;
	}

	public String contiCliente(String codiceFiscale) {
		
		String res = "";
		Cliente c = this.cercaCliente(codiceFiscale);
		
		if (c != null) {
			Conto[] cc = c.getConti();
			for (Conto ci : cc) {
				res = res + ci.getCodice() + "\n";
			}
		}
		
		return res;
	}

	public String clientiConto(String codiceConto) {
		
		String res = "";
		Conto c = this.cercaConto(codiceConto);
		
		if (c != null) {
			Cliente[] cc = c.getClienti();
			for (Cliente ci : cc) {
				res = res + ci.getCodiceFiscale() + "\n";
			}
		}
		
		return res;
	}
	
	public Fido nuovoPrestito(String codiceConto, String codiceCliente, double importo, double rataMensile, double tassoRischio) {
		
		Fido f = null;
		Cliente c = this.cercaCliente(codiceCliente);
		Conto cn = this.cercaConto(codiceConto);
		
		if (c != null && cn != null) {
			if (c.contieneConto(cn)) {
				if (tassoRischio <= 0.75) {
					f = new Fido(cn, c, importo, rataMensile, tassoRischio);
					cn.capitale = cn.capitale + importo;
					this.prestiti[numeroPrestiti++] = f;
					c.aggiungiPrestito(f);
				}
			}
		}
		
		return f;
	}
	
	public Mutuo nuovoPrestito(String codiceConto, String codiceCliente, double importo, double rataMensile, int numeroMesi) {
		
		Mutuo m = null;
		Cliente c = this.cercaCliente(codiceCliente);
		Conto cn = this.cercaConto(codiceConto);
		
		if (c != null && cn != null) {
			if (c.contieneConto(cn)) {
				if (c.getPrestiti() == null) {
					m = new Mutuo(cn, c, importo, rataMensile, numeroMesi);
					cn.capitale = cn.capitale + importo;
					this.prestiti[numeroPrestiti++] = m;
					c.aggiungiPrestito(m);
				}
			}
		}
		
		return m;
	}

	public Prestito[] prestiti() {
		
		Prestito[] pp = null;
		
		if (this.numeroPrestiti > 0) {
			pp = new Prestito[this.numeroPrestiti];
			
			for (int i = 0; i < this.numeroPrestiti; i++) {
				pp[i] = this.prestiti[i];
			}
		}
		
		return pp;
		
	}
	
	public Prestito[] prestiti(String codiceFiscale) {
		
		Prestito[] pp = null;
		Cliente c = this.cercaCliente(codiceFiscale);
		
		if (c != null) {
			pp = c.getPrestiti();
		}
		
		return pp;
	}
	
	public Prestito[] prestiti(String codiceFiscale, String tipo) {
		
		Prestito[] pp = null;
		Cliente c = this.cercaCliente(codiceFiscale);
		
		if (c != null) {
			pp = c.getPrestiti(tipo);
		}
		
		return pp;
	}
}


