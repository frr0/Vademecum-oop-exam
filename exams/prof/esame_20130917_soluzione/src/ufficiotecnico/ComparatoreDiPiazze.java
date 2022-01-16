package ufficiotecnico;

import java.util.Comparator;

public class ComparatoreDiPiazze implements Comparator<Piazza>{

	public int compare(Piazza p1, Piazza p2){
		return p1.getNome().compareTo(p2.getNome());
	}

	
}
