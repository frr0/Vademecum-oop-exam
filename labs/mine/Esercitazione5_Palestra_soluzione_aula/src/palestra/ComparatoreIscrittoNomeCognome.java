package palestra;

import java.util.Comparator;

public class ComparatoreIscrittoNomeCognome implements Comparator<Iscritto> {

	@Override
	public int compare(Iscritto o1, Iscritto o2) {
		// TODO Auto-generated method stub
		
		String nc1 = o1.getNome()+o1.getCognome();
		String nc2 = o2.getNome()+o2.getCognome();
		
		return nc1.compareTo(nc2);
	}


}
