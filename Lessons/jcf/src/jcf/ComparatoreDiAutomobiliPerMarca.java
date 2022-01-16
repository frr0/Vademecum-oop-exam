package jcf;

import java.util.*;

public class ComparatoreDiAutomobiliPerMarca implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {

		Automobile a1 = (Automobile)o1;
		Automobile a2 = (Automobile)o2;
	
		return a1.marca.compareTo(a2.marca); // Confronto per marca
		
	}
	
}
