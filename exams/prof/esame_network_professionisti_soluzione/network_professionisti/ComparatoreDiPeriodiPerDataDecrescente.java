package network_professionisti;

import java.util.Comparator;

public class ComparatoreDiPeriodiPerDataDecrescente implements Comparator<Periodo>{

	public int compare(Periodo o1, Periodo o2) {
		return o2.da.compareTo(o1.da);
	}
	
}