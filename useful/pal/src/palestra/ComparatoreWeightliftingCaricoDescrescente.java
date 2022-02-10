package palestra;

import java.util.Comparator;

public class ComparatoreWeightliftingCaricoDescrescente implements Comparator<Esercizio> {

	@Override
	public int compare(Esercizio o1, Esercizio o2) {
		// TODO Auto-generated method stub
		Weightlifting w1 = (Weightlifting) o1;
		Weightlifting w2 = (Weightlifting) o2;
		return w2.getCarico()-w1.getCarico();
	}



}
