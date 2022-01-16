package polichef;

import java.util.*;


public class Piatto{

	private String nome;
	private Concorrente concorrente;
	private int idPiatto;
	private int numeroIngredienti;
	
	private LinkedList<String> listaIngredienti = new LinkedList<String>();
	private TreeMap<String, String> mappaIngredienti = new TreeMap<String, String>();
	
	public Piatto(int idPiatto, String nome, Concorrente concorrente) {
		this.idPiatto = idPiatto;
		this.nome = nome;
		this.concorrente=concorrente;
		numeroIngredienti = 0;
	}
	
	public String aggiungiIngredientePiatto(String ingrediente){
		if(!mappaIngredienti.containsKey(ingrediente)) {
			listaIngredienti.add(ingrediente);
			mappaIngredienti.put(ingrediente, ingrediente);
			numeroIngredienti++;
			return ingrediente;
		}
		else
			return null;
	}

	public int getIdPiatto() {
		return idPiatto;
	}
	
	public String getNome() {
		return nome;
	}

	public int getNumeroIngredienti() {
		return numeroIngredienti;
	}

	public String getIdConcorrente() {
		return concorrente.getId();
	}

	public Concorrente getConcorrente() {
		return concorrente;
	}
	

	
	
}
