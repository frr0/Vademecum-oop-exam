package condomini;

import java.util.*;

public class impCompSpesa implements Comparator<Spesa>{

	public int compare(Spesa s0, Spesa s1) {
		
		int diffImporto = (int)s0.getImporto()-(int)s1.getImporto();
		
		return -diffImporto;
	}
	
	

}
