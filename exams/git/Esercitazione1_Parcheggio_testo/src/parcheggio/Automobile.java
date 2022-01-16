package parcheggio;

public class Automobile {
	
	private String targa = new String();
	private String modello = new String();
	private int posto_assegnato;
	private int numero_giorni;
	
	public Automobile(String t, String mm, int p, int ng) {
		this.targa = t;
		this.modello = mm;
		this.posto_assegnato = p;
		this.numero_giorni = ng;
	}
	
	public String getInfo() {
		return targa + ", " + modello + ", " + Integer.toString(posto_assegnato) + ", " + Integer.toString(numero_giorni);

	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getPostoAssegnato() {
		return posto_assegnato;
	}
	public void setPostoAssegnato(int posto_assegnato) {
		this.posto_assegnato = posto_assegnato;
	}
	public int getNumeroGiorni() {
		return numero_giorni;
	}
	public void setNumeroGiorni(int numero_giorni) {
		this.numero_giorni = numero_giorni;
	}
	
	
}
