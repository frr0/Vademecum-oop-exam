package palestra;

import java.util.Comparator;

public class ComparatoreEsercizioCodice implements Comparator<Esercizio> {

	@Override
	public int compare(Esercizio o1, Esercizio o2) {
		// TODO Auto-generated method stub
		return o1.getCodice().compareTo(o2.getCodice());
	}

}
