package congressi;

import java.util.TreeMap;

public class Congresso {

	private String nome;
	private String dataInizio;
	private String dataFine;
	private Centro centro;
	
	TreeMap<String, Sala> mappaSale = new TreeMap<String, Sala>();
	TreeMap<Integer, Sessione> mappaSessioni = new TreeMap<Integer, Sessione>();

	int prossimoNumeroSessione = 1;
	
	public Congresso(String nome, String dataInizio, String dataFine, Centro centro) {
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.centro = centro;
	}

	public String getNome() {
		return nome;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}
	
	public void setCentro(Centro centro) {
		this.centro =centro;
	}
	
	
	public String getIdCentro() {
		return centro.getId();
	}
	
	
	
	
}
