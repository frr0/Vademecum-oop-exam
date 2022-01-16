package portoturistico;


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Banchina implements Comparable<Banchina>{
	private int lettera;
	private int spaziMassimi;
	private List<Spazio> spazi = new LinkedList<Spazio>();
	int codice = 100;

	public Banchina(int lettera, int spaziMassimi) {
		super();
		this.lettera = lettera;
		this.spaziMassimi = spaziMassimi;
	}

	public char getLetteraBanchina(){
		  
		return (char)(lettera);
	}

	public int getNumeroMassimoSpazi(){
		return spaziMassimi;
	}

	public void aggiungiSpazio(Spazio s) {
		spazi.add(s);
		
	}

	public void decrementaSpazi() {
		this.spaziMassimi--;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Banchina altra) {
		// TODO Auto-generated method stub
		return this.lettera - (altra.getLetteraBanchina());
	}

	public Collection<Spazio> getSpazi() {
		Collections.sort(spazi);
		return spazi;
	}

}
