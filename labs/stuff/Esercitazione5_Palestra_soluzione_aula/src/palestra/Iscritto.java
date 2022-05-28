package palestra;

import java.util.ArrayList;
import java.util.Collection;

public class Iscritto {
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	private int codice;
	private String nome;
	private String cognome;
	private String sesso;
	private int eta;
	private double peso;
	ArrayList<SchedaAllenamento> schede;

	public Iscritto(int codice, String nome, String cognome, String sesso, int eta, double peso) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.eta = eta;
		this.peso = peso;
		// TODO Auto-generated constructor stub
		schede = new ArrayList<>();
	}

	public String descriviti() {
		return codice + " " + nome + " " + cognome + " " + sesso + " " + eta + " " + peso;
	}

	public void aggiungiScheda(SchedaAllenamento sa) {
		// TODO Auto-generated method stub
		schede.add(sa);
	}
	
	public Collection<SchedaAllenamento> getSchede(){
		return schede;
	}

}