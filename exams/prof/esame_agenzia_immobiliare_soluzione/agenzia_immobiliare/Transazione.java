package agenzia_immobiliare;

public class Transazione implements Comparable<Transazione>{

	int idTransazione;
	SchedaImmobile schedaImmobile;
	Venditore venditore;
	Acquirente acquirente;
	double importo;
	
	public Transazione(int idTransazione, SchedaImmobile schedaImmobile, Venditore venditore, Acquirente acquirente, double importo) {
		this.idTransazione = idTransazione;
		this.schedaImmobile = schedaImmobile;
		this.venditore = venditore;
		this.acquirente = acquirente;
		this.importo = importo;
	}

	public int getIdTransazione() {
		return idTransazione;
	}

	public SchedaImmobile getSchedaImmobile() {
		return schedaImmobile;
	}

	public Venditore getVenditore() {
		return venditore;
	}

	public Acquirente getAcquirente() {
		return acquirente;
	}

	public double getImporto() {
		return importo;
	}
	
	public String toString() {
		return ""+idTransazione+" "+schedaImmobile.getIdSchedaImmobile()+" "+venditore.getCodiceFiscale()+" "+acquirente.getCodiceFiscale()+" "+importo;
	}

	@Override
	public int compareTo(Transazione altra) {

		if(this.importo==altra.getImporto())
			return this.schedaImmobile.getIdSchedaImmobile().compareTo(altra.getSchedaImmobile().getIdSchedaImmobile());
		else
			return (int)(this.importo-altra.getImporto());
	}
	
	
	
}
