package aziendaagricola;

public class Fertilizzante {
	protected String nome;
	protected float costo;
	protected int periodicita;
	protected int quantitaImpiego;

	public Fertilizzante(String nome, float costo, int periodicita, int quantitaImpiego) {
		this.nome = nome;
		this.costo = costo;
		this.periodicita = periodicita;
		this.quantitaImpiego = quantitaImpiego;
	}

	public String getNome() {
		return this.nome;
	}
	
	public float getCosto() {
		return this.costo;
	}
	
	public int getPeriodicita() {
		return this.periodicita;
	}
	
	public int getQuantitaImpiego() {
		return this.quantitaImpiego;
	}

	public void setNome(String nome) {
this.nome = nome;
	}
	
	public void setCosto(float costo) {
this.costo = costo;
	}
	
	public void setPeriodicita(int periodicita) {
this.periodicita = periodicita;
	}

	public void setQuantitaImpiego(int quantitaImpiego) {
this.quantitaImpiego = quantitaImpiego;
	}
	
}
