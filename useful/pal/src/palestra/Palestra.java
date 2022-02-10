package palestra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Palestra {
	
	LinkedHashMap<Integer, Iscritto> iscritti;
	LinkedHashMap<String, Esercizio> esercizi;
	LinkedHashMap<String, SchedaAllenamento> schede;
	
	public Palestra() {
		iscritti = new LinkedHashMap<>();
		esercizi = new LinkedHashMap<>();
		schede = new LinkedHashMap<>();
	}
	
	public Iscritto nuovaIscrizione(String nome, String cognome, String sesso, int eta, double peso) {
		
		Iscritto i = null;
		int codice = iscritti.size();
		i = new Iscritto(codice, nome, cognome, sesso, eta, peso);
		iscritti.put(codice, i);
		
		return i;
	}
	
	public Iscritto cercaIscrittoPerId(int codice) {
		return iscritti.get(codice);
	}
	
	public Collection<Iscritto> cercaIscrittoPerNomeCognome(String nome, String cognome){
		
		ArrayList<Iscritto> ii = new ArrayList<>();
		
		for (Iscritto i : iscritti.values()) {
			if (i.getNome().contains(nome) && i.getCognome().contains(cognome))
				ii.add(i);
		}
		
		Collections.sort(ii, new ComparatoreIscrittoNomeCognome());
		
		return ii;
	}
	
	public Collection<Iscritto> elencoIscritti(){
		ArrayList<Iscritto> ii = new ArrayList<>(iscritti.values());
		
		Collections.sort(ii, new ComparatoreIscrittoNomeCognome());
		
		return ii;
	}
	
	public Cardio nuovoEsercizio(String codice, String descrizione, int minuti) {
		Cardio c = null;
		
		if (!esercizi.containsKey(codice)) {
			c = new Cardio(codice, descrizione, minuti);
			esercizi.put(codice, c);
		}
		
		return c;
	}
	
	public Weightlifting nuovoEsercizio(String codice, String descrizione, int ripetizioni, int carico) {
		Weightlifting w = null;
		
		if (!esercizi.containsKey(codice)) {
			w = new Weightlifting(codice, descrizione, ripetizioni, carico);
			esercizi.put(codice, w);
		}
		
		return w;
	}
	
	public CorpoLibero nuovoEsercizio(String codice, String descrizione, double calorie) {
		CorpoLibero c = null;
		
		if (!esercizi.containsKey(codice)) {
			c = new CorpoLibero(codice, descrizione, calorie);
			esercizi.put(codice, c);
		}
		
		return c;
	}
	
	public Esercizio esercizio(String codice) {
		return esercizi.get(codice);
	}
	
	public Collection<Esercizio> esercizi() {
		
		if (esercizi.size() == 0)
			return null;
		
		return esercizi.values();
	}
	
	public Collection<Esercizio> elencoEserciziPerCodice() {
		
		ArrayList<Esercizio> ee = new ArrayList<>(esercizi.values());
		Collections.sort(ee, new ComparatoreEsercizioCodice());
		
		return ee;
	}
	
	public Collection<Esercizio> elencoEserciziPerTipologia() {
		
		ArrayList<Esercizio> res = new ArrayList<>();
		ArrayList<Esercizio> car = new ArrayList<>();
		ArrayList<Esercizio> wgt = new ArrayList<>();
		ArrayList<Esercizio> cpl = new ArrayList<>();
		
		for (Esercizio ei : esercizi.values()) {
			if (ei instanceof Cardio)
				car.add(ei);
			if (ei instanceof Weightlifting)
				wgt.add(ei);
			if (ei instanceof CorpoLibero)
				cpl.add(ei);
		}
		
		Collections.sort(wgt, new ComparatoreWeightliftingCaricoDescrescente());
		res.addAll(car);
		res.addAll(wgt);
		res.addAll(cpl);
		
		return res;
	}
	
	public Collection<Esercizio> elencoEserciziCorpoLiberoPerCalorie() {	
		
		ArrayList<Esercizio> cpl = new ArrayList<>();
		
		for (Esercizio ei : esercizi.values()) {
			if (ei instanceof CorpoLibero)
				cpl.add(ei);
		}
		
		Collections.sort(cpl, new ComparatoreCorpoLiberoCalorie());
		
		return cpl;
	}
	
	public SchedaAllenamento nuovaSchedaAllenamento(int codiceIscritto, String data, Collection<String> codiciEsercizi) {
		
		ArrayList<Esercizio> eserciziEsistenti = new ArrayList<>();
		Iscritto i = cercaIscrittoPerId(codiceIscritto);
		SchedaAllenamento sa = null;
		
		for (String s : codiciEsercizi) {
			Esercizio e = esercizio(s);
			if (e != null) {
				eserciziEsistenti.add(e);
			}
		}
		
		if (i != null && eserciziEsistenti.size() > 0) {
			
			String codice = data + "_" + i.getCodice();
			
			if (schede.containsKey(codice)) {
				sa = schede.get(codice);
				sa.aggiungiEsercizi(eserciziEsistenti);
			}
			else {
				sa = new SchedaAllenamento(codice, i, eserciziEsistenti);
				schede.put(codice, sa);
				i.aggiungiScheda(sa);
			}
		}
		
		return sa;
	}
	
	public Collection<Esercizio> eserciziScheda(String codiceScheda){
		
		ArrayList<Esercizio> ee = null;
		SchedaAllenamento sa = schede.get(codiceScheda);
		if (sa != null)
			ee = new ArrayList<>(sa.getEsercizi());
		
		return ee;
	}
	
	public SchedaAllenamento cercaSchedaPerId(String codiceScheda) throws SchedaNonEsistenteException{
		
		SchedaAllenamento sa = schede.get(codiceScheda);
		if (sa==null) {
			throw new SchedaNonEsistenteException();
		}
		
		return sa;
	}
	
	public Collection<SchedaAllenamento> elencoSchedePerIdIscritto(int codiceIscritto) throws UtenteNonEsistenteException{
		Iscritto i = cercaIscrittoPerId(codiceIscritto);
		ArrayList<SchedaAllenamento> ss = null;
		
		if (i == null)
			throw new UtenteNonEsistenteException();
		
		else {
			ss = new ArrayList<>(i.getSchede());
		}
		
		return ss;
	}
	
	public void leggiDatiPalestra(String nomeFile) {	
		
		FileReader f;
		try {
			f = new FileReader(nomeFile);
			try (BufferedReader b = new BufferedReader(f)) {
				String line = "";
				
				while ((line = b.readLine()) != null){
					String[] fields = line.split(";");
					try {
						if (fields[0].compareTo("I")==0) {
							nuovaIscrizione(fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), Double.parseDouble(fields[5]));
						}						
					}
					catch(IndexOutOfBoundsException e){
						e.printStackTrace();						
					}
					catch(NumberFormatException e){
						e.printStackTrace();						
					}
					try {
						if (fields[0].compareTo("C")==0) {
							nuovoEsercizio(fields[1], fields[2], Integer.parseInt(fields[3]));
						}						
					}
					catch(IndexOutOfBoundsException e){
						e.printStackTrace();						
					}
					catch(NumberFormatException e){
						e.printStackTrace();						
					}
					try {
						if (fields[0].compareTo("W")==0) {
							nuovoEsercizio(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
						}						
					}
					catch(IndexOutOfBoundsException e){
						e.printStackTrace();						
					}
					catch(NumberFormatException e){
						e.printStackTrace();						
					}
					try {
						if (fields[0].compareTo("P")==0) {
							nuovoEsercizio(fields[1], fields[2], Double.parseDouble(fields[3]));
						}
					}
					catch(IndexOutOfBoundsException e){
						e.printStackTrace();						
					}
					catch(NumberFormatException e){
						e.printStackTrace();						
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
