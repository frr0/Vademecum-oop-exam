package collezioni;

public class Impiegato {
	
	String nome;
	double paga;
	
	public Impiegato(String nome, double paga) {
		this.nome = nome;
		this.paga = paga;
	}
	
	// Deleghiamo all'Impiegato il compito di 
	// descriversi attrverso il metodo toString()
	
	@Override
	public String toString() {
		return nome+" "+paga;
	}

	
	// ... ed anche il compito di confrontarsi
	// con il metodo equals()
	
	@Override             // DEVE ESSERE Object
	public boolean equals(Object obj) {
		// Qui devo scrivere il MIO ALGORITMO DI CONFRONTO
		// (complicato a piacere, esempio confrontando anche
		// la paga, ecc.)
		
		if(this.nome.compareTo(((Impiegato)obj).nome)==0)
			return true;       // Mi serve un (DOWNCAST) cast a Impiegato
		else                   // perchè Object non ha nome, paga, ...
			return false;
	
	}
	
	
	
}
