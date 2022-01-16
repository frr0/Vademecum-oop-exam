package congressi;

import java.util.*;

public class SessioneOratoriMultipli extends Sessione {

	TreeMap<String,String> 	mappa_nomi_cognomi = new TreeMap<String,String>();

	
	public SessioneOratoriMultipli(int numero, Congresso congresso, Sala sala, String titolo, String data, String daOra, String aOra) {
		super(numero, congresso, sala, titolo, data, daOra, aOra);
		// TODO Auto-generated constructor stub
	}
	
	public void allocaOratore(String cognome, String nome, String ora) {
		mappa_nomi_cognomi.put(ora, cognome+" "+nome); 
	}

	public Collection<String> elencoOratori(){
		return mappa_nomi_cognomi.values();
	}

}
