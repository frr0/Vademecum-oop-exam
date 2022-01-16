package piano_vaccinazioni;

public class Cittadino {

	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String regione;
	private String codiceTesseraSanitaria;
	int eta;
	Vaccinazione vaccinazione;
	Vaccinazione richiamo;

	public int getEta() {
		return eta;
	}

	public Cittadino(String nome, String cognome, String dataDiNascita, String regione, String codiceTesseraSanitaria) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.regione = regione;
		this.codiceTesseraSanitaria = codiceTesseraSanitaria;
		int anno = Integer.parseInt(dataDiNascita.substring(0, 4));
		this.eta = 2021 - anno;
	}

	public String getCodiceTesseraSanitaria() {
		return codiceTesseraSanitaria;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public String getRegione() {
		return regione;
	}
	
}
