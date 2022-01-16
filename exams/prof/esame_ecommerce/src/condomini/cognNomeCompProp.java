package condomini;

import java.util.*;

public class cognNomeCompProp implements Comparator<Proprietario>{

	
	public int compare(Proprietario p0, Proprietario p1) {
		
		int diffCognome = p0.getCognome().compareTo(p1.getCognome());
		if(diffCognome!=0)
			return diffCognome;
		
		int diffNome = p0.getNome().compareTo(p1.getNome());
		
		return diffNome;
	}
	
	

}
