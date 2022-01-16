package palestra;

import java.util.ArrayList;
import java.util.Collection;

public class SchedaAllenamento {
	
	private String codice;
	private Iscritto i;
	private ArrayList<Esercizio> eserciziEsistenti;

	public SchedaAllenamento(String codice, Iscritto i, ArrayList<Esercizio> eserciziEsistenti) {
		this.codice = codice;
		this.setI(i);
		this.eserciziEsistenti = eserciziEsistenti;
		// TODO Auto-generated constructor stub
		
	}

	public String getCodice() {
		return codice;
	}

	public void aggiungiEsercizi(ArrayList<Esercizio> esercizi) {
		// TODO Auto-generated method stub
		for (Esercizio ei : esercizi) {
			if (!eserciziEsistenti.contains(ei))
				eserciziEsistenti.add(ei);
		}
	}

	public Collection<Esercizio> getEsercizi() {
		// TODO Auto-generated method stub
		return eserciziEsistenti;
	}

	public Iscritto getI() {
		return i;
	}

	public void setI(Iscritto i) {
		this.i = i;
	}
}
