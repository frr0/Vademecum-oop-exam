package agenziaviaggi;

import java.util.*;

public class Agenzia {
	
	private ArrayList<Cliente> clienti;
	private int numPratica;
	
	public Agenzia() {
		this.clienti = new ArrayList<Cliente>();
		this.numPratica = 999;
	}

	public Cliente aggiungiCliente(String cognome, String nome, String indirizzo) throws EccezioneClienteGiaEsistente {
		Cliente cercaCliente = cercaCliente(cognome, nome, indirizzo);
		if (cercaCliente == null) {
			this.clienti.add(new Cliente(cognome, nome, indirizzo));
			return this.clienti.get(this.clienti.size() - 1);
		} else {
			throw new EccezioneClienteGiaEsistente();
		}
	}
	
	public Collection<Cliente> elencoClienti(){
		Collections.sort(this.clienti);
		return this.clienti;
	}
	
	public Cliente cercaCliente(String cognome, String nome, String indirizzo){
		Cliente tempCliente = new Cliente(cognome, nome, indirizzo);
		for (Cliente cliente: clienti) {
			if(cliente.compareTo(tempCliente) == 0) {
				return cliente;
			}
		}
		return null;
	}
	
	public Cliente cercaCliente(String ricerca){
		for (Cliente cliente: clienti) {
			if (cliente.getCognome().contains(ricerca) || cliente.getNome().contains(ricerca) || cliente.getIndirizzo().contains(ricerca)) {
				return cliente;
			}
		}
		return null;
	}
	
	public int nuovaPratica(String descrizione, String cognome, String nome, String indirizzo){
		Cliente cercatoCliente = this.cercaCliente(cognome, nome, indirizzo);
		Cliente questoCliente = null;
		if (cercatoCliente == null) {
			try {
				questoCliente = this.aggiungiCliente(cognome, nome, indirizzo);
			} catch (EccezioneClienteGiaEsistente e) {
				e.printStackTrace();
				return -1;
			}
		} else {
			questoCliente = cercatoCliente;
		}
		
		this.numPratica++;
		
		questoCliente.addPratica(new Pratica(this.numPratica, descrizione));
		
		return this.numPratica;
	}
	
	public Pratica getPratica(int idPratica) throws EccezionePraticaInesistente{
		for (Cliente c: clienti) {
			for (Pratica p: c.elencoPratiche()) {
				if (p.getIdPratica() == idPratica) {
					return p;
				} 
			}
		}
		throw new EccezionePraticaInesistente();
	}
	
	public void eliminaPratica(int idPratica) throws EccezionePraticaInesistente{
		for (Cliente c: clienti) {
			for (Pratica p: c.elencoPratiche()) {
				if (p.getIdPratica() == idPratica) {
					c.removePratica(p);
				}
			}
		}
		throw new EccezionePraticaInesistente();
	}
	
	public Collection<Pratica> elencoPratiche(){
		ArrayList<Pratica> praticheAll = new ArrayList<Pratica>();
		for (Cliente c: this.clienti) {
			praticheAll.addAll(c.elencoPratiche());
		}
		Collections.sort(praticheAll);
		return praticheAll;
	}

	public double calcolaImportoPerPeriodo(String da, String a){
		double res = 0;
		for (Cliente c: this.clienti) {
			for (Pratica p: c.elencoPratiche()) {
				for (Prenotazione pr: p.elencoPrenotazioniPerData()) {
					if (pr.getData().compareTo(da) >= 0 && pr.getData().compareTo(a) <= 0) {
						res += pr.getImporto();
					}
				}
			}
		}
		return res;
	}
	
	public Collection<Cliente> elencoClientiSelezionati(double importo){
		ArrayList<Cliente> clientiAll = new ArrayList<Cliente>();
		for (Cliente c: this.clienti) {
			if (c.getImportoTotale() > importo) {
				clientiAll.add(c);
			}
		}
		Collections.sort(clientiAll);
		return clientiAll;
	}
}
