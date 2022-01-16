package ufficiotecnico;

import java.util.Comparator;

public class ComparatoreDiStradePerNome implements Comparator<Strada>{

	public int compare(Strada s1, Strada s2){
		return s1.getNome().compareTo(s2.getNome());
	}

	
}
