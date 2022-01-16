package generics;

public class Persona<T> {

	// Se uso dei tipi generici devo dichiararlo
	// all'inizio, aggiungendo < > dopo il nome
	// della classe

	T id; // Rimango "generico", Object sostituito con T(ype)
	String nome;
	int eta;
	              // Era Object
	public Persona(T id, String nome, int eta) {
		this.id = id;
		this.nome = nome;
		this.eta = eta;
	}

	       // Era Object
	public T getId() {
		return id;
	}

	                  // Era Object
	public void setId(T id) {
		this.id = id;
	}
	
	
	
	
	
	
}
