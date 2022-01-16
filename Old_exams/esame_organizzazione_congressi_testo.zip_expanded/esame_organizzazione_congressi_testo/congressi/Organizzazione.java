package congressi;
import java.util.*;

public class Organizzazione {
	private Map<String, Centro> centri;
	private Map<String, Congresso> congressi;
	
	
	public Organizzazione() {
		this.centri = new HashMap<String,Centro>();
		this.congressi = new TreeMap<String, Congresso>();
	}
	
	public Centro definisciCentro(String nome, String indirizzo) {
		for(Centro c: this.centri.values()) {
			if (c.getNome().contentEquals(nome)) {
				return null;
			}
		}
		
		Centro nuovoCentro = new Centro(this.centri.size() + 1, nome, indirizzo);
		this.centri.put(nuovoCentro.getId(), nuovoCentro);
		return nuovoCentro;
	}

	public Centro cercaCentro(String id) {
		return this.centri.get(id);
	}

	public Collection<Centro> elencoCentri() {
		ArrayList<Centro> c = new ArrayList<Centro>(this.centri.values());
		Collections.sort(c, Centro.comparatorSeriale);
		return c;
	}
	
	public Collection<Centro> elencoCentri(String sottostringa) {
		ArrayList<Centro> cs = new ArrayList<Centro>();
		for(Centro c: this.centri.values()) {
			if(c.getNome().contains(sottostringa) || c.getIndirizzo().contains(sottostringa)) {
				cs.add(c);
			}
		}
		Collections.sort(cs, Centro.comparatorSeriale);
		return cs;
	}
	
	public Sala definisciSalaCentro(String idCentro, String nome, int capienza) {
		Centro c = this.cercaCentro(idCentro);
		if (c == null || c.getSala(nome) != null) {
			return null;
		}
		Sala s = new Sala(nome, capienza);
		c.putSala(s);
		return s;
	}
	
	public Collection<Sala> elencoSaleCentroPerNome(String idCentro) {
		Centro c = this.cercaCentro(idCentro);
		if (c == null) {
			return null;
		}
		return new ArrayList<Sala>(c.getAllSale().values());
	}
	
	public Collection<Sala> elencoSaleCentroPerCapienza(String idCentro) {
		Centro c = this.cercaCentro(idCentro);
		if (c == null) {
			return null;
		}
		ArrayList<Sala> ss = new ArrayList<Sala>(c.getAllSale().values());
		Collections.sort(ss, Sala.comparatorCapienza);
		return ss;
	}
	
	public Congresso definisciCongresso(String nome, String dataInizio, String dataFine, String idCentro) {
		Congresso c = this.congressi.get(nome);
		Centro ce = this.cercaCentro(idCentro);
		if (ce == null) {
			return null;
		}
		if (c != null) {
			this.congressi.replace(nome, new Congresso(nome, dataInizio, dataFine, ce));
			return this.congressi.get(nome);
		}
		c = new Congresso(nome, dataInizio, dataFine, ce);
		this.congressi.put(nome, c);
		return c;
	}
	
	public void assegnaSaleCongresso(String nomeCongresso, String nomeSala) {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return;
		}
		
		Centro ce = this.cercaCentro(c.getIdCentro());
		if (ce == null || ce.getSala(nomeSala) == null) {
			return;
		}
		
		c.addSala(ce.getSala(nomeSala));
	}
	
	public Collection<Sala> elencoSaleCongresso(String nomeCongresso) {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return null;
		}
		return c.getSale();
	}
	
	public Sessione pianificaSessioneCongresso(String nomeCongresso, String nomeSala, char tipoSessione, String nomeSessione, String data, String daOra, String adOra) throws EccezioneSessioneSovrapposta {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return null;
		}
		
		Sala s = c.getSala(nomeSala);
		if (s == null) {
			return null;
		}
		
		if (c.sessioneOverlaps(data, daOra, adOra)) {
			throw new EccezioneSessioneSovrapposta();
		}
		Sessione res = null;
		switch (tipoSessione) {
		case 'S':
			res = new SessioneSingoloOratore(c.getSessioni().size() + 1, c, s, nomeSessione, data, daOra, adOra);
			c.addSessione(res);
			break;
		case 'M':
			res = new SessioneOratoriMultipli(c.getSessioni().size() + 1, c, s, nomeSessione, data, daOra, adOra);
			c.addSessione(res);

			break;
		}
		
		return res;
	}
	
	public void allocaOratoreSessioneCongresso(String nomeCongresso, int numeroSessione, String cognome, String nome) {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return;
		}
		Sessione s = c.getSessione(numeroSessione);
		if (s == null) {
			return;
		}
		s.allocaOratore(cognome + " " + nome);
	}
	
	public void allocaOratoreSessioneCongresso(String nomeCongresso, int numeroSessione, String cognome, String nome, String ora) {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return;
		}
		Sessione s = c.getSessione(numeroSessione);
		if (s == null) {
			return;
		}
		s.allocaOratore(cognome + " " + nome, ora);
	}
	
	public Collection<String> elencoOratoriSessioneCongresso(String nomeCongresso, int numeroSessione) {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return null;
		}
		Sessione s = c.getSessione(numeroSessione);
		if (s == null) {
			return null;
		}
		ArrayList<String> res = new ArrayList<String>();
		if (s instanceof SessioneSingoloOratore) {
			SessioneSingoloOratore ss = (SessioneSingoloOratore) s;
			res.add(ss.getOratore() + "\n");
		} else if (s instanceof SessioneOratoriMultipli) {
			SessioneOratoriMultipli ss = (SessioneOratoriMultipli) s;
			for (String nc: ss.getOratori()) {
				res.add(nc + "\n");
			}
		}
		return res;
	}
	
	public String programmaSessioneCongresso(String nomeCongresso, int numeroSessione) {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return null;
		}
		Sessione s = c.getSessione(numeroSessione);
		if (s == null) {
			return null;
		}
		String res = "";
		if (s instanceof SessioneSingoloOratore) {
			SessioneSingoloOratore ss = (SessioneSingoloOratore) s;
			res = ss.getDaOra() + " " + ss.getOratore() + "\n";
		} else if (s instanceof SessioneOratoriMultipli) {
			SessioneOratoriMultipli ss = (SessioneOratoriMultipli) s;
			ArrayList<String> keys = new ArrayList<String>(ss.getOrari());
			for (String key: keys) {
				res += key + " " + ss.getOratore(key) + "\n";
			}
		}
		
		return res;
	}

	public String programmaCongresso(String nomeCongresso) {
		Congresso c = this.congressi.get(nomeCongresso);
		if (c == null) {
			return null;
		}
		String res = "";
		ArrayList<Sessione> sessioni = new ArrayList<Sessione>(c.getSessioni());
		Collections.sort(sessioni, Sessione.comparatorDataOra);
		for (Sessione s: sessioni) {
			res += s.getData() + " " + s.getDaOra() + " " + s.getAdOra() + " " + s.getNome() + "\n";
			res += this.programmaSessioneCongresso(nomeCongresso, s.getNumero());
		}
		return res;
	}
	
}
