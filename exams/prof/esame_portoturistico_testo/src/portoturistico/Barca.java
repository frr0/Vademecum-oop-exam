package portoturistico;

public class Barca {
	private String numero;
	private String nome;
	private double lunghezza;
	private double larghezza;

	public Barca(String numero, String nome, double lunghezza, double larghezza) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
	}

	public String getNumeroImmatricolazione() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public double getLunghezza() {
		return lunghezza;
	}

	public double getLarghezza() {
		return larghezza;
	}

}
