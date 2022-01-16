package palestra;

import java.util.Comparator;

public class ComparatoreCorpoLiberoCalorie implements Comparator<Esercizio> {

	@Override
	public int compare(Esercizio o1, Esercizio o2) {
		// TODO Auto-generated method stub
		CorpoLibero c1 = (CorpoLibero) o1;
		CorpoLibero c2 = (CorpoLibero) o2;
		return (int)(c1.getCalorie() - c2.getCalorie());
	}

	
}
