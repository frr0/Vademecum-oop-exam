package palestra;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Palestra {
	int codice = 0;
	
	ArrayList<Iscritto> iscritti = new ArrayList<>();
	TreeMap<Integer, Iscritto> iscrittiMap = new TreeMap<>();
	TreeMap<String, Iscritto> iNameMap = new TreeMap<>();
	
	ArrayList<Esercizio> w = new ArrayList<>();
	ArrayList<Esercizio> c = new ArrayList<>();
	ArrayList<Esercizio> l = new ArrayList<>();
	ArrayList<Esercizio> e = new ArrayList<>(); 

	int nEsercizi = 0;
	int nWeight = 0;
	int nCardio = 0;
	int nLibero = 0;

	public Iscritto nuovaIscrizione(String nome, String cognome, String sesso, int eta, double peso) {
		Iscritto i =  new Iscritto(nome, cognome, sesso, eta, peso);
		iscritti.add(i);
		i.setCodice(codice);
		iscrittiMap.put(codice++, i);

		String a = nome + cognome;
		iNameMap.put(a, i);

		return i;
	}
	
	public Iscritto cercaIscrittoPerId(int codice) {
		return iscrittiMap.get(codice);
	}
	
	public Collection<Iscritto> cercaIscrittoPerNomeCognome(String nome, String cognome){
		ArrayList<Iscritto> n = new ArrayList<>();
		for(Iscritto i: iscritti) {
			if(i.getNome().contains(nome) && i.getCognome().contains(cognome)) {
				n.add(i);
			}
		}
//		System.out.println("bhfjdghshl");
		return n;
	}
	
	public Collection<Iscritto> elencoIscritti(){
		return iNameMap.values();
	}
	
	public Cardio nuovoEsercizio(String codice, String descrizione, int minuti) {
		Cardio cc = new Cardio(codice, descrizione, minuti);
		Esercizio ee = new Esercizio(codice, descrizione);
		c.add(cc);
		e.add(ee);
		nCardio++;
		nEsercizi++;
		return cc;
	}
	
	public Weightlifting nuovoEsercizio(String codice, String descrizione, int ripetizioni, int carico) {
		Weightlifting ww = new Weightlifting(codice, descrizione, carico);
		Esercizio ee = new Esercizio(codice, descrizione);
		w.add(ww);
		e.add(ee);
		nWeight++;
		nEsercizi++;
		return ww;
	}
	
	public CorpoLibero nuovoEsercizio(String codice, String descrizione, double calorie) {
		CorpoLibero ll = new CorpoLibero(codice, descrizione, nCardio);
		Esercizio ee = new Esercizio(codice, descrizione);
		l.add(ll);
		e.add(ee);
		nLibero++;
		nEsercizi++;
		return ll;
	}
	
	public Esercizio esercizio(String codice) {
		for (Esercizio a: e) {
			if (a.getCodice() == codice) {
				return a;
			}
		}
		return null;
	}
	
	public Collection<Esercizio> esercizi() {
		return e;
	}
	
	public Collection<Esercizio> elencoEserciziPerCodice() {	
		return e.stream().sorted().toList();
	}
	
	public Collection<Esercizio> elencoEserciziPerTipologia() {
		ArrayList<Esercizio> ex = new ArrayList<>();
		
		e.sort(null);
		
		for (Esercizio i : w) {
			
		}
		
		return e.stream().sorted().toList();
		// not done
	}
	
	public Collection<Esercizio> elencoEserciziCorpoLiberoPerCalorie() {		
		return e.stream().sorted().toList();
		// not done
	}
	
	public SchedaAllenamento nuovaSchedaAllenamento(int codiceIscritto, String data, Collection<String> codiciEsercizi) {
		return null;
	}
	
	public Collection<Esercizio> eserciziScheda(String codiceScheda){
		return null;
	}
	
	public SchedaAllenamento cercaSchedaPerId(String codiceScheda) throws SchedaNonEsistenteException{
		return null;
	}
	
	public Collection<SchedaAllenamento> elencoSchedePerIdIscritto(int codiceIscritto) throws UtenteNonEsistenteException{
		return null;
	}
	
	public void leggiDatiPalestra(String nomeFile) {		
	}
		
}