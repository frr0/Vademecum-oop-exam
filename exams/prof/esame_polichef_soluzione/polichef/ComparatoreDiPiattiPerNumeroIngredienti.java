package polichef;

import java.util.*;

public class ComparatoreDiPiattiPerNumeroIngredienti implements Comparator<Piatto>{

	public int compare(Piatto p1, Piatto p2) {

		return p1.getNumeroIngredienti()-p2.getNumeroIngredienti();
	}
}
