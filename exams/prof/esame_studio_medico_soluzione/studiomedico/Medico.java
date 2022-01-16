package studiomedico;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Medico {

	String titolo;
	String cognome;
	String nome;
	String specializzazione;
	LinkedHashMap<String, LinkedList<Orario>> orariSettimanali;
	LinkedList<Assistito> assistiti;

	public Medico(String titolo, String cognome, String nome, String specializzazione) {
		this.titolo = titolo;
		this.cognome = cognome;
		this.nome = nome;
		this.specializzazione = specializzazione;
		orariSettimanali = new LinkedHashMap<String, LinkedList<Orario>>();
		
		orariSettimanali.put("LUN", new LinkedList<Orario>());
		orariSettimanali.put("MAR", new LinkedList<Orario>());
		orariSettimanali.put("MER", new LinkedList<Orario>());
		orariSettimanali.put("GIO", new LinkedList<Orario>());
		orariSettimanali.put("VEN", new LinkedList<Orario>());
		
		assistiti = new LinkedList<Assistito>();
	}
	
	public String getTitolo() {
		return titolo;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public boolean aggiungiOrario(String giorno, int daOra, int aOra) {
		
		boolean orarioAggiunto = false;
		Orario o = null;
		
		if (orariSettimanali.get(giorno).isEmpty()) {
			o = new Orario(this, giorno, daOra, aOra);
			orariSettimanali.get(giorno).add(o);
			orarioAggiunto = true;
		}
		else {
			orarioAggiunto = true;
			for (Orario oi : orariSettimanali.get(giorno)) {
				orarioAggiunto = orarioAggiunto && ((daOra > oi.orarioFine) || (aOra < oi.orarioInizio));
			}
			if (orarioAggiunto) {
				o = new Orario(this, giorno, daOra, aOra);
				orariSettimanali.get(giorno).add(o);
			}
		}
		
		return orarioAggiunto;
	}

	class ComparatoreOrariCrescenti implements Comparator<Orario>{

		@Override
		public int compare(Orario o1, Orario o2) {
			return o1.orarioInizio - o2.orarioInizio;
		}
		
	}
	
	public String descriviOrari() {
		
		String orari = "";
		
		for (LinkedList<Orario> oo : orariSettimanali.values()) {
			Collections.sort(oo, new ComparatoreOrariCrescenti());
			for (Orario oi : oo) {
				orari = orari + oi.descriviti() + "\n";
			}
		}
		
		if (orari != "") {
			orari = orari.substring(0, orari.length()-1);
		}
		
		if (orari == "") {
			orari = null;
		}
		
		return orari;
	}
	
	public String descriviti() {
		return titolo + " " + cognome + " " + nome + " (" + specializzazione + ")";
	}
	
	public void aggiungiAssistito(Assistito a) {
		if (assistiti.size() < 100) {
			assistiti.add(a);
		}
	}
	
	public Collection<Assistito> getAssistiti(){
		return assistiti;
	}

	public Orario getOrario(String giorno, int daOra, int aOra) {
		Orario o = null;
		
		if (!orariSettimanali.get(giorno).isEmpty()) {
			for (Orario oi : orariSettimanali.get(giorno)) {
				if (oi.orarioInizio == daOra && oi.orarioFine == aOra) {
					o = oi;
				}
			}
		}
		
		return o;
	}
}
