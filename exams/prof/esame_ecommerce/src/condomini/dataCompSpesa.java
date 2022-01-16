package condomini;

import java.util.*;

public class dataCompSpesa implements Comparator<Spesa>{


	public int compare(Spesa s0, Spesa s1) {
		
		int diffData = s0.getData().compareTo(s1.getData());
		
		return diffData;
	}

	
}
