package supermercato;

import java.util.*;

public class Corsia {

	String nome;
	int capienzaMassima;
	int occupazioneAttuale;
	
	Map<String, Integer> prodottiQuantita = new TreeMap<String, Integer>();
	
	public Corsia(String nome, int capienzaMassima){
		this.nome=nome;
		this.capienzaMassima = capienzaMassima;
		this.occupazioneAttuale=0;
	}
	

	
	public void esponiProdotto(Prodotto prodotto, int quantitaDaEsporre){
		// Si aggiunge il prodotto in corsia, verificando di non superare la capienza massima
		// Se il prodotto è già presente in corsia ne aumento la quantità, se si raggiunge la capienza
		// si espone solo quanto ci sta
	
			int disponibile = capienzaMassima - occupazioneAttuale;
			int maxPezziAggiungibili = disponibile / prodotto.getVolume();

			int quantitaAttuale = 0; 

			if(prodottiQuantita.containsKey(prodotto.codice)){
				quantitaAttuale = prodottiQuantita.get(prodotto.codice);
				prodottiQuantita.remove(prodotto.codice);
				
			}
			
			if(quantitaDaEsporre<=maxPezziAggiungibili)
			{
				// Li posso aggiungere tutti
				prodottiQuantita.put(prodotto.codice, quantitaAttuale+quantitaDaEsporre);
				occupazioneAttuale = occupazioneAttuale + quantitaDaEsporre*prodotto.getVolume();
			}
			else
			{
				// Ne posso aggiungere meno
				if(maxPezziAggiungibili>0){
				prodottiQuantita.remove(prodotto.codice);
				prodottiQuantita.put(prodotto.codice, quantitaAttuale+maxPezziAggiungibili);
				occupazioneAttuale = occupazioneAttuale + maxPezziAggiungibili*prodotto.getVolume();
				}
			}
			
	}
	
	public Collection<String> elencoCodiciProdotto(){
		return new LinkedList<String>(prodottiQuantita.keySet());
	}
	

	public int calcolaPercentualeDiOccupazione(){
		return (int)((double)occupazioneAttuale/(double)capienzaMassima*100.0);
	}

	public int quantitaProdottoEsposto(Prodotto prodotto){
		
		if(prodottiQuantita.containsKey(prodotto.codice))
			return prodottiQuantita.get(prodotto.codice);
		else
			return 0;
	}
	
	
}
