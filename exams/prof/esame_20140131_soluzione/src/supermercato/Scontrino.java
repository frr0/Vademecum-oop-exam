package supermercato;

import java.util.*;

public class Scontrino {

	int codiceScontrino;
	Map<String, Integer> prodottiQuantita = new TreeMap<String, Integer>();

	public Scontrino(int codiceScontrino){
		this.codiceScontrino=codiceScontrino;
	}

	
	public void acquistaProdotto(Prodotto prodotto, int quantita){
		prodottiQuantita.put(prodotto.codice, quantita);
	}
	
	public String dettagliScontrino(){

		String risultato=" "+this.codiceScontrino+"\n";
		boolean primavolta = true; 
		
		for(String ctemp : (new LinkedList<String>(prodottiQuantita.keySet())))
		{
			if(primavolta)
				primavolta=false;
			else
				risultato+="\n";
			int quantita = prodottiQuantita.get(ctemp);
			risultato = risultato+" "+ctemp+" "+quantita;
		}
		return risultato;
		
	}
	
	
}
