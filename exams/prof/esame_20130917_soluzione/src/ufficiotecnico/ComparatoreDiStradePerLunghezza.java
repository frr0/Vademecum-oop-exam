package ufficiotecnico;

import java.util.Comparator;

public class ComparatoreDiStradePerLunghezza implements Comparator<Strada>{

	public int compare(Strada s1, Strada s2){
		return -(s1.getLunghezza()-s2.getLunghezza());
	}

	
}
