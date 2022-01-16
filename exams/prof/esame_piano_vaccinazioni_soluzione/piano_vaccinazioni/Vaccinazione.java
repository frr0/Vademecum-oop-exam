package piano_vaccinazioni;

public class Vaccinazione {

	private char tipo;
	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Cittadino getCittadino() {
		return cittadino;
	}

	public void setCittadino(Cittadino cittadino) {
		this.cittadino = cittadino;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private Cittadino cittadino;
	private Centro centro;
	private String data;

	public Vaccinazione(char tipo, Cittadino cittadino, Centro centro, String data) {
		this.tipo = tipo;
		this.cittadino = cittadino;
		this.centro = centro;
		this.data = data;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return cittadino.getCodiceTesseraSanitaria() + " " + centro.getCodice() + " " +  data + " " + tipo;
	}
	
}
