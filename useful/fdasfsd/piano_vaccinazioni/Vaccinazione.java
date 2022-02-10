package piano_vaccinazioni;

public class Vaccinazione {
	char tipov = ' ';
	String datav;
	Cittadino c;
	Centro cc;
	String regione;
	String codice;
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public Vaccinazione(char tipov, String datav, Cittadino c, Centro cc, String regione, String codice) {
		this.tipov = tipov;
		this.datav = datav;
		this.c = c;
		this.cc = cc;
		this.regione = regione;
		this.codice = codice;
	}
	public char getTipov() {
		return tipov;
	}
	public void setTipov(char tipov) {
		this.tipov = tipov;
	}
	public String getDatav() {
		return datav;
	}
	public void setDatav(String datav) {
		this.datav = datav;
	}
	public Cittadino getC() {
		return c;
	}
	public void setC(Cittadino c) {
		this.c = c;
	}
	public Centro getCc() {
		return cc;
	}
	public void setCc(Centro cc) {
		this.cc = cc;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	
}
