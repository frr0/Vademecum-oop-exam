package network_professionisti;

import java.util.Comparator;

public class ComparatoreDiPeriodiPerDataCrescente implements Comparator<Periodo>{

	public int compare(Periodo o1, Periodo o2) {
		return o1.da.compareTo(o2.da);
	}
	
}