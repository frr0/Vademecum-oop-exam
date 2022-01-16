package congressi;

import java.util.*;

public class SessioneSingoloOratore extends Sessione{

	String nome_cognome;
	
	public SessioneSingoloOratore(int numero, Congresso congresso, Sala sala, String titolo, String data, String daOra, String aOra) {
		super(numero, congresso, sala, titolo, data, daOra, aOra);
	}

	public void allocaOratore(String cognome, String nome) {
		nome_cognome = cognome+" "+nome; 
	}

	public Collection<String> elencoOratori(){
		LinkedList<String> listaTemp = new LinkedList<String>();
		listaTemp.add(nome_cognome);
		return listaTemp;
	}

	
}
