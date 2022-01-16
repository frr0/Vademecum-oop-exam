package portoturistico;

import java.util.Comparator;

public class ComparatorePerDimensioneNome implements Comparator<Barca> {

	@Override
	public int compare(Barca a, Barca b) {
		int diffDim = ((int) (a.getLunghezza()*a.getLarghezza()) - (int)(b.getLunghezza()*b.getLarghezza()));
		if(diffDim != 0)
			return diffDim;
		else
		return a.getNome().compareTo(b.getNome());
	}

}
