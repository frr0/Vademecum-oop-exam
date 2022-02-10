package palestra;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Palestra {
	int codice = 0;
	
	LinkedList<Iscritto> listinscritti = new LinkedList<>();
	LinkedHashMap<Integer, Iscritto> iscrittipercodice = new LinkedHashMap<>();
	
	LinkedList<CorpoLibero> listCorpoLibero = new LinkedList<>();
	LinkedList<Cardio> listCardio = new LinkedList<>();
	LinkedList<Weightlifting> listWeightliftings = new LinkedList<>();
	
	LinkedList<Esercizio> listEsercizi = new LinkedList<>();
	LinkedHashMap<String, Esercizio> esercizioperCodice = new LinkedHashMap<>();
	
	LinkedHashMap<String, List<SchedaAllenamento>> schedepercodice = new LinkedHashMap<>();
	
	public Iscritto nuovaIscrizione(String nome, String cognome, String sesso, int eta, double peso) {
		Iscritto i;
		i = new Iscritto(nome, cognome, sesso, eta, peso, codice);
		listinscritti.add(i);
		iscrittipercodice.put(codice++, i);
		return i;
	}
	
	public Iscritto cercaIscrittoPerId(int codice) {
		return iscrittipercodice.get(codice);
	}
	
	public Collection<Iscritto> cercaIscrittoPerNomeCognome(String nome, String cognome){
		List<Iscritto> ii;
		ii = listinscritti.stream().filter(isc -> isc.getCognome().compareTo(cognome) == 0).filter(isc -> isc.getNome().compareTo(nome) == 0).collect(Collectors.toList());
		return ii.stream().sorted(Comparator.comparing(Iscritto::getNome).thenComparing(Iscritto::getCognome)).collect(Collectors.toList());
	}
	
	public Collection<Iscritto> elencoIscritti(){
		return listinscritti.stream().sorted(Comparator.comparing(Iscritto::getNome).thenComparing(Iscritto::getCognome)).collect(Collectors.toList());
	}
	
	public Cardio nuovoEsercizio(String codice, String descrizione, int minuti) {
		Cardio c = new Cardio(codice, descrizione, minuti);
		listCardio.add(c);
		listEsercizi.add(c);
		esercizioperCodice.put(codice, c);
		return c;
	}
	
	public Weightlifting nuovoEsercizio(String codice, String descrizione, int ripetizioni, int carico) {
		Weightlifting w = new Weightlifting(codice, descrizione, ripetizioni, carico);
		listWeightliftings.add(w);
		listEsercizi.add(w);
		esercizioperCodice.put(codice, w);
		return w;
	}
	
	public CorpoLibero nuovoEsercizio(String codice, String descrizione, double calorie) {
		CorpoLibero l = new CorpoLibero(codice, descrizione, calorie);
		listCorpoLibero.add(l);
		listEsercizi.add(l);
		esercizioperCodice.put(codice, l);
		return l;
	}
	
	public Esercizio esercizio(String codice) {
		return esercizioperCodice.get(codice);
	}
	
	public Collection<Esercizio> esercizi() {
		return listEsercizi;
	}
	
	public Collection<Esercizio> elencoEserciziPerCodice() {		
		return listEsercizi.stream().sorted(Comparator.comparing(Esercizio::getCodice)).collect(Collectors.toList());
	}
	
	public Collection<Esercizio> elencoEserciziPerTipologia() {
		List<Weightlifting> ww = listWeightliftings.stream().sorted(Comparator.comparing(Weightlifting::getCarico).reversed()).collect(Collectors.toList());
		LinkedList<Esercizio> tmp = new LinkedList<>();
		tmp.addAll(listCardio);
		tmp.addAll(ww);
		tmp.addAll(listCorpoLibero);
		return tmp;
	}
	
	public Collection<Esercizio> elencoEserciziCorpoLiberoPerCalorie() {		
		return listCorpoLibero.stream().sorted(Comparator.comparing(CorpoLibero::getCalorie).reversed()).collect(Collectors.toList());
	}
	
	public SchedaAllenamento nuovaSchedaAllenamento(int codiceIscritto, String data, Collection<String> codiciEsercizi) {
		for (Iscritto ii: listinscritti) {
			if (ii.getCodice() != codiceIscritto) {
				if (ii.ss.data.compareTo(data) == 0) {
					for (Esercizio ei: listEsercizi) { 
						for (String si: codiciEsercizi) {
							if (ei.getCodice().compareTo(si) == 0) {
								String codice = data+"_"+codiceIscritto;
								SchedaAllenamento s = new SchedaAllenamento(codice, codiceIscritto, data, codiciEsercizi);
								ii.ss = s;
								ii.ss.data = data;
//								schedepercodice.put(codiciEsercizi, s);
								return s;
							}
						}
					}
				} else {
					ii.ss.codiciEsercizi = codiciEsercizi;
				}
			}
		} 
		return null;
	}
	
	public Collection<Esercizio> eserciziScheda(String codiceScheda){
//		return schedepercodice.get(codiceScheda));
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

