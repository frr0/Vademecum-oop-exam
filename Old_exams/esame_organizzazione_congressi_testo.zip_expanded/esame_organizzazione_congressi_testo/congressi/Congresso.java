package congressi;

import java.util.*;

public class Congresso {
	
	private String nome;
	private String dataInizio;
	private String dataFine;
	private Centro centro;
	private Map<String, Sala> sale;
	private Map<Integer, Sessione> sessioni;
	
	

	public Congresso(String nome, String dataInizio, String dataFine, Centro centro) {
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.centro = centro;
		this.sale = new TreeMap<String, Sala>();
		this.sessioni = new TreeMap<Integer, Sessione>();
	}

	public String getNome() {
		return this.nome;
	}

	public String getDataInizio() {
		return this.dataInizio;
	}

	public String getDataFine() {
		return this.dataFine;
	}

	public String getIdCentro() {
		return this.centro.getId();
	}
	
	public Collection<Sala> getSale(){
		return this.sale.values();
	}
	
	public void addSala(Sala s) {
		this.sale.put(s.getNome(), s);
	}
	
	public Sala getSala(String nomeSala) {
		return this.sale.get(nomeSala);
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	
	public Collection<Sessione> getSessioni(){
		return this.sessioni.values();
	}
	
	public boolean sessioneOverlaps(String data, String daOra, String adOra) {
		for (Sessione s: this.sessioni.values()) {
			int p1 = daOra.compareTo(s.getAdOra());
			int p2 = adOra.compareTo(s.getDaOra());
			if (data.contentEquals(s.getData()) && p1 < 0 && p2 > 0) {
				return true;
			}
		}
		return false;
	}
	
	public void addSessione(Sessione s) {
		this.sessioni.put(this.sessioni.size() + 1, s);
	}
	
	public Sessione getSessione(int codice) {
		return this.sessioni.get(codice);
	}
}
