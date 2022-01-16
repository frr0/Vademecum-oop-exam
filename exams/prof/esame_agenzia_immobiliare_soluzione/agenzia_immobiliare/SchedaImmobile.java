package agenzia_immobiliare;

public class SchedaImmobile {

	private String idSchedaImmobile;
	private String comune;
	private String indirizzo;
	private String tipologia;
	private int locali;
	private int superficie;
	private String descrizione;
	
	public SchedaImmobile(String idSchedaImmobile, String comune, String indirizzo, String tipologia, int locali, int superficie, String descrizione) {
		this.idSchedaImmobile = idSchedaImmobile;
		this.comune = comune;
		this.indirizzo = indirizzo;
		this.tipologia = tipologia;
		this.locali = locali;
		this.superficie = superficie;
		this.descrizione = descrizione;
	}

	public String getIdSchedaImmobile() {
		return idSchedaImmobile;
	}
	
	public String getComune() {
		return comune;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getTipologia() {
		return tipologia;
	}

	public int getLocali() {
		return locali;
	}

	public int getSuperficie() {
		return superficie;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
