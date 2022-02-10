package perFra;

public class Macchina {
	
	int codice;
	String nome;
	

	
	
	

	public Macchina(String nome2, int codice) {
		// TODO Auto-generated constructor stub
		this.codice = codice;
		this.nome = nome2;
	}




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




	@Override
	public String toString() {
		return "Macchina [codice=" + codice + ", nome=" + nome + "]";
	}
	
	
	
	
}
