package piano_vaccinazioni;

public class Cittadino {
	String codiceTesseraSanitaria;
	String nome;
	String cognome;
	String dataDiNascita;
	String regione;
	int eta;
	int numVaccini = 0;
	char tipovaccino;
	String c;
	String data1;
	String data2;
	
	
	
	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public char getTipovaccino() {
		return tipovaccino;
	}

	public void setTipovaccino(char tipovaccino) {
		this.tipovaccino = tipovaccino;
	}

	public int getNumVaccini() {
		return numVaccini;
	}

	public void setNumVaccini(int numVaccini) {
		this.numVaccini = numVaccini;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public void setCodiceTesseraSanitaria(String codiceTesseraSanitaria) {
		this.codiceTesseraSanitaria = codiceTesseraSanitaria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public Cittadino(String codiceTesseraSanitaria, String nome, String cognome, String dataDiNascita, String regione) {
		super();
		this.codiceTesseraSanitaria = codiceTesseraSanitaria;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.regione = regione;
		Integer anno = Integer.parseInt(dataDiNascita.substring(0, 4)); 
		this.eta = 2021-anno;
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
