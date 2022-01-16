package polichef;

import java.util.*;

public class ComparatoreDiPiattiPerNome implements Comparator<Piatto>{

	public int compare(Piatto p1, Piatto p2) {

		return p1.getNome().compareTo(p2.getNome());
	}
}
