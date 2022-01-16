package supermercato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Supermercato {

	Map<String,Corsia> corsie = new HashMap<String, Corsia>();
	Map<String,Prodotto> mappaProdotti = new HashMap<String, Prodotto>();
	List<Prodotto> listaProdotti = new LinkedList<Prodotto>();
	int primoCodiceScontrino = 1000; 
	Map<Integer, Scontrino> scontrini = new HashMap<Integer, Scontrino>();

	public void aggiungiCorsia(String nome, int capienzaMassima){
		Corsia ctemp = new Corsia(nome, capienzaMassima);
		this.corsie.put(nome, ctemp);
	}

	public Prodotto catalogaProdotto(String codiceProdotto, String nomeProdotto, int volume, boolean daFrigo){

		Prodotto ptemp;
		
		if(mappaProdotti.containsKey(codiceProdotto))
			return mappaProdotti.get(codiceProdotto);
		else
		{
			if(daFrigo)
				ptemp = new ProdottoDaFrigo(codiceProdotto, nomeProdotto, volume);
			else
				ptemp = new Prodotto(codiceProdotto, nomeProdotto, volume);
			
			mappaProdotti.put(codiceProdotto, ptemp);
			listaProdotti.add(ptemp);
			return ptemp;
		}
	}	
	
	public Collection<Prodotto> elencoProdotti(){

		Collections.sort(listaProdotti);
		return listaProdotti; 
	}
	
	public Prodotto cercaProdotto(String codiceProdotto) throws ProdottoInesistenteException{
		Prodotto risultato=null;
		if(mappaProdotti.containsKey(codiceProdotto))
			risultato = mappaProdotti.get(codiceProdotto);
		else
			throw new ProdottoInesistenteException();
			
		return risultato;
	}
	
	
	

	
	public void esponiProdotto(String nomeCorsia, Prodotto prodotto, int quantita){

		Corsia ctemp = corsie.get(nomeCorsia);
		ctemp.esponiProdotto(prodotto, quantita);
	}

	public int calcolaPercentualeDiOccupazione(String nomeCorsia){
		Corsia ctemp = corsie.get(nomeCorsia);
		return ctemp.calcolaPercentualeDiOccupazione();
	}
	
	public Collection<String> elencoCodiciProdottoPerCorsia(String nomeCorsia){

		Corsia ctemp = corsie.get(nomeCorsia);
		return ctemp.elencoCodiciProdotto();
	}

	public int quantitaProdottoEsposto(Prodotto prodotto, String nomeCorsia){
		Corsia ctemp = corsie.get(nomeCorsia);
		return ctemp.quantitaProdottoEsposto(prodotto);
	}
	
	public int quantitaProdottoEsposto(Prodotto prodotto){
		int risultato = 0;
		for(Corsia ctemp : corsie.values())
			risultato += 	ctemp.quantitaProdottoEsposto(prodotto);
		return risultato;
	}
	
	public int apriScontrino(){
		int nuovoCodiceScontrino = primoCodiceScontrino;
		primoCodiceScontrino++;
		Scontrino stemp = new Scontrino(nuovoCodiceScontrino);
		scontrini.put(nuovoCodiceScontrino,stemp);
		return nuovoCodiceScontrino;
	}
	
	public void acquistaProdotto(int codiceScontrino, Prodotto prodotto, String nomeCorsia, int quantita) throws CorsiaInesistenteException{
		Scontrino stemp = scontrini.get(codiceScontrino);
		Corsia ctemp = corsie.get(nomeCorsia);
		
		if(ctemp==null)
			throw new CorsiaInesistenteException();

		int quantitaAcquistabile;
		int quantitaEsposta = this.quantitaProdottoEsposto(prodotto, nomeCorsia);
		
		if(quantitaEsposta>=quantita)
			quantitaAcquistabile = quantita;
		else
			quantitaAcquistabile = quantitaEsposta;

		ctemp.prodottiQuantita.remove(prodotto.codice);
		ctemp.prodottiQuantita.put(prodotto.codice, quantitaEsposta-quantitaAcquistabile);
		
		stemp.acquistaProdotto(prodotto, quantitaAcquistabile);
	}
	
	public String dettagliScontrino(int codiceScontrino){
		Scontrino stemp = scontrini.get(codiceScontrino);
		return stemp.dettagliScontrino();
	}
	
	
	

	
	
	
	
	
	


	
	
	

	
	
	
	public double chiudiScontrino(int codiceScontrino) throws ProdottoInesistenteException{
		double risultato=0;
		Scontrino stemp = scontrini.get(codiceScontrino);
		for(String ctemp : (new LinkedList<String>(stemp.prodottiQuantita.keySet())))
		{
			int quantita = stemp.prodottiQuantita.get(ctemp);
			Prodotto ptemp = this.cercaProdotto(ctemp);
			risultato += (ptemp.prezzoListino-ptemp.prezzoListino*(double)ptemp.percentualeSconto/100.0)*(double)quantita;
		}
		
		return risultato;
	}
	
	
	public void leggiFile(String nomeFile) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		String linea;
		
		while ((linea = in.readLine()) != null) {
			
			try {
			    StringTokenizer st = new StringTokenizer(linea, ";");
			    String iniziale = st.nextToken().trim();
			    if (iniziale.toUpperCase().equals("PRODOTTO_NO_FRIGO")) 
			    {
				   String codice = st.nextToken().trim();
				   String nome = st.nextToken().trim();
				   String volume = st.nextToken().trim();
				   String prezzo = st.nextToken().trim();
				   String percentualeSconto = st.nextToken().trim();

				   Prodotto ptemp = this.catalogaProdotto(codice, nome, Integer.parseInt(volume), false);
				   ptemp.prezzoListino = Double.parseDouble(prezzo);
				   ptemp.percentualeSconto = Integer.parseInt(percentualeSconto);
				   
				} 
			    else if (iniziale.toUpperCase().equals("PRODOTTO_DA_FRIGO"))
			    {
					   String codice = st.nextToken().trim();
					   String nome = st.nextToken().trim();
					   String volume = st.nextToken().trim();
					   String prezzo = st.nextToken().trim();
					   String percentualeSconto = st.nextToken().trim();
					   String temperaturaDiConservazione = st.nextToken().trim();

					   Prodotto ptemp = this.catalogaProdotto(codice, nome, Integer.parseInt(volume),true);
					   ((ProdottoDaFrigo)ptemp).prezzoListino = Double.parseDouble(prezzo);
					   ((ProdottoDaFrigo)ptemp).percentualeSconto = Integer.parseInt(percentualeSconto);
					   ((ProdottoDaFrigo)ptemp).setTemperaturaDiConservazione(Integer.parseInt(temperaturaDiConservazione));

			    }
			    else if (iniziale.toUpperCase().equals("ESPOSIZI_PRODOTTO"))
			    {
					   String codiceProdotto = st.nextToken().trim();
					   String nomeCorsia = st.nextToken().trim();
					   String quantita = st.nextToken().trim();
					   this.esponiProdotto(nomeCorsia, this.cercaProdotto(codiceProdotto), Integer.parseInt(quantita));
			    }
					   
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		in.close();		
		
	}	
	
	
	
	
}
