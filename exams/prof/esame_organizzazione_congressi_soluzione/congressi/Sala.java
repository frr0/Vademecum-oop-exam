package congressi;

public class Sala implements Comparable<Sala> {
	
	private String nome;
	private int capienza;
	
	public Sala(String nome, int capienza) {
		this.nome = nome;
		this.capienza = capienza;
	}

	public String getNome() {
		return nome;
	}

	public int getCapienza() {
		return capienza;
	}

	@Override
	public int compareTo(Sala o) {
		return this.getCapienza()-o.getCapienza();
	}
	
	
	

}
