package portoturistico;

import java.util.Comparator;

public class ComparatorePerNomeDimensione implements Comparator<Barca> {

	@Override
	public int compare(Barca a, Barca b) {
		int diffNome = a.getNome().compareTo(b.getNome());
		if(diffNome != 0)
		return diffNome;
		else
		return ((int) (a.getLunghezza()*a.getLarghezza()) - (int)(b.getLunghezza()*b.getLarghezza()));
	}

}
