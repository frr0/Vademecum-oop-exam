package palinsesti;

public class Programmazione implements Comparable<Programmazione>{

	Programma programma;
	String ora;
	int durata;
	
	public Programmazione(Programma programma, String ora, int durata) {
		this.programma=programma;
		this.ora=ora;
		this.durata=durata;
	}

	@Override
	public int compareTo(Programmazione altra) {
		return ora.compareTo(altra.ora);
	}
	
}
