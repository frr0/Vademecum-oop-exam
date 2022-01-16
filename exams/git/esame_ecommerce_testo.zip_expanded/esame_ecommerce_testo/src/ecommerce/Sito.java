package ecommerce;

import java.io.*;
import java.util.*;

public class Sito {
	
	private ArrayList<String> categorie;
	private ArrayList<Prodotto> prodotti;
	private int prossimoProdotto;
	private Map<Integer, Utente> utenti;
	private int prossimoUtente;
	
	public Sito() {
		this.categorie = new ArrayList<String>();
		this.prodotti = new ArrayList<Prodotto>();
		this.prossimoProdotto = 100;
		this.utenti = new TreeMap<Integer, Utente>();
		this.prossimoUtente = 1;
	}

	
	public void nuovaCategoria(String nomeCategoria){
		this.categorie.add(nomeCategoria);
	}

	public Collection<String> elencoCategorie(){
		Collections.sort(this.categorie);
		return this.categorie;
	}
	
	public String nuovoProdotto(String nomeCategoria, String nomeProdotto, String descrizione, double prezzo){
		if (!this.categorie.contains(nomeCategoria)) {
			this.nuovaCategoria(nomeCategoria);
		}
		Prodotto p = new Prodotto(nomeProdotto, nomeCategoria, descrizione, prezzo, prossimoProdotto);
		this.prodotti.add(p);
		this.prossimoProdotto++;
		return p.getCodice();
	}
	
	public Prodotto cercaProdotto(String stringaRicerca){
		for (Prodotto p: this.prodotti) {
			if (p.getCodice().toLowerCase().contains(stringaRicerca.toLowerCase()) ||
					p.getNome().toLowerCase().contains(stringaRicerca.toLowerCase()) ||
					p.getDescrizione().toLowerCase().contains(stringaRicerca.toLowerCase())) {
				return p;
			}
		}
		return null;
	}
	
	public Collection<Prodotto> elencoProdottiPerNome(){
		Collections.sort(this.prodotti, Prodotto.comparatorNome);
		
		return this.prodotti;
	}

	public Collection<Prodotto> elencoProdottiPerPrezzo(){
		Collections.sort(this.prodotti, Prodotto.comparatorPrezzo);
		return this.prodotti;	
		}
	
	public Collection<Prodotto> elencoProdottiPerNome(String nomeCategoria){
		ArrayList<Prodotto> elencoP = new ArrayList<Prodotto>();
		for (Prodotto p: this.prodotti) {
			if (p.getCategoria().contentEquals(nomeCategoria)) {
				elencoP.add(p);
			}
		}
		Collections.sort(elencoP, Prodotto.comparatorNome);
		return elencoP;
	}

	public Collection<Prodotto> elencoProdottiPerPrezzo(String nomeCategoria){
		ArrayList<Prodotto> elencoP = new ArrayList<Prodotto>();
		for (Prodotto p: this.prodotti) {
			if (p.getCategoria().contentEquals(nomeCategoria)) {
				elencoP.add(p);
			}
		}
		Collections.sort(elencoP, Prodotto.comparatorPrezzo);
		return elencoP;
	}
	
	public void nuovoUtente(String nome, String cognome, String email, String indirizzo){
		Utente newUtente = new Utente(nome, cognome, email, indirizzo, prossimoUtente);
		for (Utente u: this.utenti.values()) {
			if (u.equals(newUtente)) {
				return;
			}
		}
		this.utenti.put(prossimoUtente, newUtente);
		prossimoUtente++;
	}
	
	public void nuovoUtente(String nome, String cognome, String email, String indirizzo, String username, String password){
		Utente newUtente = new UtenteRegistrato(nome, cognome, email, indirizzo, username, password, prossimoUtente);
		for (Utente u: this.utenti.values()) {
			if (u.equals(newUtente)) {
				return;
			}
		}
		this.utenti.put(prossimoUtente, newUtente);
		prossimoUtente++;
	}
	
	public Utente cercaUtente(int codiceUtente) throws EccezioneUtenteInesistente{
		Utente u = this.utenti.get(codiceUtente);
		if (u == null) {
			throw new EccezioneUtenteInesistente();
		} else {
			return u;
		}
	}
	
	public String dettagliCarrello(int codiceUtente) throws EccezioneUtenteInesistente{
		Utente questoUtente = this.cercaUtente(codiceUtente);
		ArrayList<Prodotto> prodottiUtente = new ArrayList<Prodotto>(questoUtente.getCarrello().keySet());
		Collections.sort(prodottiUtente, Prodotto.comparatorCodice);
		String res = "";
		for (Prodotto p: prodottiUtente) {
			res += p + " " + questoUtente.getCarrello().get(p) + "\n";
		}
		if (res.length() > 0) {
			return res.substring(0, res.length() - 1);
		} else {
			return res;
		}
		
	}
	
    public void leggiFile(String nomeFile) throws IOException{
    	File file = new File(nomeFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String row;
		while((row = br.readLine()) != null) {
			String[] data = row.split(";");
			if (data[0].contentEquals("P") && data.length == 5) {
				this.nuovoProdotto(data[1], data[2], data[3], Double.parseDouble(data[4]));
			} else if (data[0].contentEquals("U")) {
				if (data.length == 5) {
					this.nuovoUtente(data[1], data[2], data[3], data[4]);
				} else if (data.length == 7) {
					this.nuovoUtente(data[1], data[2], data[3], data[4], data[5], data[6]);
				}
				
			}
			
		}
		
    }	
	
}
