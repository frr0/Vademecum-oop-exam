package congressi;

import java.util.*;

public class Centro{

	private String id;
	private String nome;
	private String indirizzo;
	
	TreeMap<String, Sala> mappaSale = new TreeMap<String, Sala>();
	
	public Centro(String id, String nome, String indirizzo) {
		this.id=id;
		this.nome = nome;
		this.indirizzo = indirizzo;
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	
	public void definisciSala(Sala s) {
		mappaSale.put(s.getNome(), s);
	}
	
}
