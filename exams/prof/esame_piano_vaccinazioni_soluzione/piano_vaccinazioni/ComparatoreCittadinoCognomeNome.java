package piano_vaccinazioni;

import java.util.Comparator;

public class ComparatoreCittadinoCognomeNome implements Comparator<Cittadino> {

	@Override
	public int compare(Cittadino o1, Cittadino o2) {
		// TODO Auto-generated method stub
		String cn1 = o1.getCognome()+o1.getNome();
		String cn2 = o2.getCognome()+o2.getNome();
		
		return cn1.compareTo(cn2);
	}

}
