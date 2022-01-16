package piano_vaccinazioni;

import java.util.Comparator;

public class ComparatoreCittadinoDataDiNascita implements Comparator<Cittadino> {

	@Override
	public int compare(Cittadino o1, Cittadino o2) {
		// TODO Auto-generated method stub
		return o1.getDataDiNascita().compareTo(o2.getDataDiNascita());
	}

}
