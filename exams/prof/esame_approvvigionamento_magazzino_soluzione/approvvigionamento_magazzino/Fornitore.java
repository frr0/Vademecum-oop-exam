package approvvigionamento_magazzino;

import java.util.*;

public class Fornitore implements Comparable<Fornitore>{

	String codiceFornitore;
	String nome;
	
	TreeMap<Integer, Double> mappaProdottiCosto = new TreeMap<Integer, Double>();

	int numeroOrdinazioni;
	
	public Fornitore(String codiceFornitore, String nome) {
		this.codiceFornitore = codiceFornitore;
		this.nome = nome;
		
		this.numeroOrdinazioni = 0;
	}

	public String getCodiceFornitore() {
		return codiceFornitore;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int compareTo(Fornitore altro) {
		if(altro.numeroOrdinazioni-this.numeroOrdinazioni!=0)
				return altro.numeroOrdinazioni-this.numeroOrdinazioni;
		else
			return this.codiceFornitore.compareTo(altro.codiceFornitore);
	}
	
	
	
}
