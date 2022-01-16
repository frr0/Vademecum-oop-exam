package supermercato;

import java.util.*;
import java.io.*;

public class Supermercato {
	
	private TreeMap<String, Prodotto> prodotti;
	private TreeMap<String, Corsia> corsie;
	private TreeMap<Integer, Scontrino> scontrini;
	
	public Supermercato() {
		this.prodotti = new TreeMap<String, Prodotto>();
		this.corsie = new TreeMap<String, Corsia>();
		this.scontrini = new TreeMap<Integer, Scontrino>();
	}

	public void aggiungiCorsia(String nome, int capienzaMassima){
		if (this.corsie.get(nome) == null) {
			this.corsie.put(nome, new Corsia(nome, capienzaMassima));
		}
	}
	
	public Prodotto catalogaProdotto(String codiceProdotto, String nomeProdotto, int volume, boolean daFrigo){
		Prodotto p = this.prodotti.get(codiceProdotto);
		if (p != null) {
			return p;
		}
		
		if (daFrigo) {
			ProdottoDaFrigo pr = new ProdottoDaFrigo(codiceProdotto, nomeProdotto, volume);
			this.prodotti.put(codiceProdotto, pr);
			return pr;
		} else {
			p = new Prodotto(codiceProdotto, nomeProdotto, volume);
			this.prodotti.put(codiceProdotto, p);
			return p;
		}
	}	
	
	public Collection<Prodotto> elencoProdotti(){
		ArrayList<Prodotto> prs = new ArrayList<Prodotto>(this.prodotti.values());
		Collections.sort(prs, Prodotto.comparatorPrezzo);
		Collections.reverse(prs);
		return prs; 
	}
	
	public Prodotto cercaProdotto(String codiceProdotto) throws ProdottoInesistenteException{
		Prodotto pr = this.prodotti.get(codiceProdotto);
		if (pr == null) {
			throw new ProdottoInesistenteException();
		}
		return pr;
	}
	
	public void esponiProdotto(String nomeCorsia, Prodotto prodotto, int quantita){
		Corsia c = this.corsie.get(nomeCorsia);
		if (c == null) {
			return;
		}
		c.addProdotto(prodotto, quantita);
	}

	public int calcolaPercentualeDiOccupazione(String nomeCorsia){
		Corsia c = this.corsie.get(nomeCorsia);
		if (c == null) {
			return 0;
		}
		double capacitaPercentuale = 100 * c.capienzaOccupata()/c.getCapienzaMassima();
		return (int) (capacitaPercentuale);
	}
	
	public Collection<String> elencoCodiciProdottoPerCorsia(String nomeCorsia){
		Corsia c = this.corsie.get(nomeCorsia);
		if (c == null) {
			return null;
		}
		
		ArrayList<String> res = new ArrayList<String>();
		for (Prodotto p: c.getProdotti()) {
			res.add(p.getCodice());
		}
		
		Collections.sort(res);
		return res;
	}

	public int quantitaProdottoEsposto(Prodotto prodotto, String nomeCorsia){
		Corsia c = this.corsie.get(nomeCorsia);
		if (c == null) {
			return 0;
		}
		return c.getQuantita(prodotto);
	}
	
	public int quantitaProdottoEsposto(Prodotto prodotto){
		int sum = 0;
		for (Corsia c: this.corsie.values()) {
			sum += c.getQuantita(prodotto);
		}
		return sum;
	}
	
	public int apriScontrino(){
		int numScontrino = 1000 + this.scontrini.size();
		this.scontrini.put(numScontrino, new Scontrino(numScontrino));
		return numScontrino;
	}
	
	public void acquistaProdotto(int codiceScontrino, Prodotto prodotto, String nomeCorsia, int quantita) throws CorsiaInesistenteException{
		Corsia c = this.corsie.get(nomeCorsia);
		if (c == null) {
			throw new CorsiaInesistenteException();
		}
		Scontrino s = this.scontrini.get(codiceScontrino);
		if (s == null) {
			return;
		}
		if (c.getProdotti().contains(prodotto)) {
			if (c.getQuantita(prodotto) >= quantita) {
				s.addProdotto(prodotto, quantita);
				c.modificaQuantita(prodotto, quantita);
			} else {
				s.addProdotto(prodotto, c.getQuantita(prodotto));
				c.modificaQuantita(prodotto, c.getQuantita(prodotto));

			}
			
		}
	}
	
	public String dettagliScontrino(int codiceScontrino){
		String res = "";
		Scontrino s = this.scontrini.get(codiceScontrino);
		if (s == null) {
			return null;
		}
		res += s.getCodice() + "\n";
		for (Prodotto p: s.getProdotti().keySet()) {
			res += p.getCodice() + " " + s.getProdotti().get(p) + "\n";
		}
		if (res.length() == 0) {
			return res;
		}
		return res.substring(0, res.length() - 1);
	}
	
	public double chiudiScontrino(int codiceScontrino) throws ProdottoInesistenteException{
		Scontrino s = this.scontrini.get(codiceScontrino);
		if (s == null) {
			return 0;
		}
		
		double sum = 0;
		for (Prodotto p: s.getProdotti().keySet()) {
			double coeffSconto = 1 - (new Double(p.getPercentualeSconto())/100);
			sum += s.getProdotti().get(p) * (p.getPrezzoListino() * coeffSconto);
		}
		return sum;
	}
	
	public void leggiFile(String nomeFile) throws IOException {
		File file = new File(nomeFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String row;
		while ((row = br.readLine())!=null) {
			String[] data = row.split(";");
			if (data[0].contentEquals("PRODOTTO_NO_FRIGO")) {
				Prodotto p = new Prodotto(data[1], data[2], Integer.parseInt(data[3]));
				p.setPrezzoListino(Double.parseDouble(data[4]));
				p.setPercentualeSconto(Integer.parseInt(data[5]));
				this.prodotti.put(data[1], p);
			} else if (data[0].contentEquals("PRODOTTO_DA_FRIGO")) {
				ProdottoDaFrigo p = new ProdottoDaFrigo(data[1], data[2], Integer.parseInt(data[3]));
				p.setPrezzoListino(Double.parseDouble(data[4]));
				p.setPercentualeSconto(Integer.parseInt(data[5]));
				p.setTemperaturaDiConservazione(Integer.parseInt(data[6]));
				this.prodotti.put(data[1], p);
			} else if (data[0].contentEquals("ESPOSIZI_PRODOTTO")) {
				Prodotto p = this.prodotti.get(data[1]);
				this.esponiProdotto(data[2], p, Integer.parseInt(data[3]));
			}
		}
	}	
	
}
