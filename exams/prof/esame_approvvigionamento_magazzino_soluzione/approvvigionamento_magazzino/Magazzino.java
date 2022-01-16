package approvvigionamento_magazzino;

import java.util.*;

public class Magazzino {

	TreeMap<Integer, Prodotto> mappaProdotti = new TreeMap<Integer, Prodotto>();
	LinkedList<Prodotto> listaProdotti = new LinkedList<Prodotto>();

	TreeMap<String, Fornitore> mappaFornitori = new TreeMap<String, Fornitore>();
	LinkedList<Fornitore> listaFornitori = new LinkedList<Fornitore>();

	TreeMap<String, Ordinazione> mappaOrdinazioni = new TreeMap<String, Ordinazione>();
	public LinkedList<Ordinazione> listaOrdinazioni = new LinkedList<Ordinazione>();
	static int progressivoOrdinazioni = 1;
	
	public Prodotto registraProdotto(int codiceProdotto, String descrizione) {
		
		if(mappaProdotti.containsKey(codiceProdotto)) {
			mappaProdotti.get(codiceProdotto).descrizione=descrizione;
			return mappaProdotti.get(codiceProdotto);
		}

		Prodotto pTemp = new Prodotto(codiceProdotto, descrizione);
		mappaProdotti.put(codiceProdotto, pTemp);
		listaProdotti.add(pTemp);
		
		return pTemp;
			
	}
	
	public int ottieniQuantita(int codiceProdotto) {
		if(mappaProdotti.get(codiceProdotto)!=null)
			return mappaProdotti.get(codiceProdotto).quantita;
		else
			return -1;
	}
	
	public Collection<Prodotto> elencoProdotti(){
		return listaProdotti;
	}

	
	public Collection<Prodotto> cercaProdotti(String daCercare){
		LinkedList<Prodotto> trovati = new LinkedList<Prodotto>();
		for(Prodotto p : listaProdotti)
			if(p.descrizione.toLowerCase().contains(daCercare.toLowerCase()))
				trovati.add(p);
		return trovati;
	}
	
	
	
	public Fornitore registraFornitore(String codiceFornitore, String nome) {
		
		if(mappaFornitori.get(codiceFornitore)!=null)
			return mappaFornitori.get(codiceFornitore);
		
		Fornitore fTemp = new Fornitore(codiceFornitore, nome);
		mappaFornitori.put(codiceFornitore, fTemp);
		listaFornitori.add(fTemp);
		return fTemp;
		
	}
	
	public FornitorePrivilegiato registraFornitore(String codiceFornitore, String nome, double percentualeSconto) {
		
		if(mappaFornitori.get(codiceFornitore)!=null)
			return (FornitorePrivilegiato)mappaFornitori.get(codiceFornitore);
		
		FornitorePrivilegiato fTemp = new FornitorePrivilegiato(codiceFornitore, nome, percentualeSconto);
		mappaFornitori.put(codiceFornitore, fTemp);
		listaFornitori.add(fTemp);
		return fTemp;
		
	}
	

	public Collection<Fornitore> elencoFornitori(){
		return mappaFornitori.values();
	}

	
	
	
	public void definisciFornitura(String codiceFornitore, int codiceProdotto, double costo) {
		
		Fornitore fTemp = mappaFornitori.get(codiceFornitore);
		Prodotto pTemp = mappaProdotti.get(codiceProdotto);
		if(fTemp==null || pTemp == null)
			return;
		
		fTemp.mappaProdottiCosto.put(pTemp.codiceProdotto, costo);
		pTemp.mappaFornitoriCosto.put(fTemp.codiceFornitore, costo);
	}

	public double costoProdottoFornitore(String codiceFornitore, int codiceProdotto) {
		Fornitore fTemp = mappaFornitori.get(codiceFornitore);
		for(Integer p : fTemp.mappaProdottiCosto.keySet())
			if(p==codiceProdotto)
				return fTemp.mappaProdottiCosto.get(p);
		return -1;
	}
	
	
	public Collection<Prodotto> elencoProdottiForniti(String codiceFornitore){
		Fornitore fTemp = mappaFornitori.get(codiceFornitore);
		LinkedList<Prodotto> listaTemp = new LinkedList<Prodotto>();
		for(Integer i : fTemp.mappaProdottiCosto.keySet())
			listaTemp.add(mappaProdotti.get(i));
		return listaTemp;
	}

	public String effettuaOrdinazione(String codiceFornitore, int codiceProdotto, int quantita) throws EccezioneProdottoNonFornito {
		
		String codiceOrdinazione = progressivoOrdinazioni+"-"+codiceFornitore+"-"+codiceProdotto;
		Fornitore fTemp = mappaFornitori.get(codiceFornitore);
		Prodotto pTemp = mappaProdotti.get(codiceProdotto);
		if(fTemp==null || pTemp == null)
			throw new EccezioneProdottoNonFornito();
		if(!fTemp.mappaProdottiCosto.containsKey(codiceProdotto))
			throw new EccezioneProdottoNonFornito();
			
		if(!pTemp.mappaFornitoriCosto.containsKey(codiceFornitore))
			return null;
		

		Ordinazione oTemp = new Ordinazione(codiceOrdinazione, fTemp, pTemp, quantita);
		mappaOrdinazioni.put(codiceOrdinazione, oTemp);
		listaOrdinazioni.add(oTemp);
		progressivoOrdinazioni++;
		
		fTemp.numeroOrdinazioni++;
		
		return codiceOrdinazione;
	}
	

	
	public String dettagliOrdinazione(String codiceOrdinazione) {
		return mappaOrdinazioni.get(codiceOrdinazione).toString();
	}
	

	public double costoOrdinazione(String codiceOrdinazione) {

		String codiceFornitore = mappaOrdinazioni.get(codiceOrdinazione).fornitore.getCodiceFornitore();

		double costoProdotto = mappaOrdinazioni.get(codiceOrdinazione).prodotto.mappaFornitoriCosto.get(codiceFornitore);
		
		double quantita = mappaOrdinazioni.get(codiceOrdinazione).quantita;
		
		double costoOrdinazione = quantita * costoProdotto;
		
		if(mappaOrdinazioni.get(codiceOrdinazione).fornitore instanceof FornitorePrivilegiato) {
			costoOrdinazione -= costoOrdinazione*((FornitorePrivilegiato)mappaOrdinazioni.get(codiceOrdinazione).fornitore).percentualeSconto/100.0;
		}
		return costoOrdinazione;
		
	}
	
	public String stampaOrdinazioni() {
		
		LinkedList<Ordinazione> listaTemp = new LinkedList<Ordinazione>(listaOrdinazioni);
		Collections.sort(listaTemp);
		
		String risultato="";
		for(Ordinazione o : listaTemp) {
			if(risultato!="")
				risultato+="\n";
			risultato += o.toString();
		}
		return risultato;
	}
	
	
	public boolean ordinazioneConsegnata(String codiceOrdinazione) {
		return mappaOrdinazioni.get(codiceOrdinazione).consegnata;
	}
	
	public void consegnaOrdinazione(String codiceOrdinazione) {
		
		Ordinazione oTemp = mappaOrdinazioni.get(codiceOrdinazione);
		if(oTemp==null)
			return;

		if(oTemp.consegnata==true)
			return;


		

		Prodotto pTemp = mappaProdotti.get(oTemp.prodotto.getCodiceProdotto());
		
		pTemp.quantita+=oTemp.quantita;
		
		oTemp.consegnata = true;
	}
	
	public int numeroOrdinazioniNonConsegnate() {
		int contatore = 0;
		for(Ordinazione o : mappaOrdinazioni.values())
			if(o.consegnata==false)
				contatore++;
		return contatore;

	}
	
	
	public double percentualeOrdinazioniProdottoNonConsegnate(int codiceProdotto) {
		double contatoreTotale = 0;
		double contatoreNonConsegnate = 0;
		
		for(Ordinazione o : mappaOrdinazioni.values())
			if(o.prodotto.codiceProdotto==codiceProdotto) {
				contatoreTotale++;
				if(!o.consegnata)
					contatoreNonConsegnate++;
			}
		
		return contatoreNonConsegnate/contatoreTotale*100.0;
			
	}
	
	

}




