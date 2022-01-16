package ristorante;

import java.io.*;
import java.util.*;

public class Ristorante {

	private ArrayList<Cuoco> cuochi;
	private ArrayList<Prodotto> prodotti;
	private ArrayList<Ordinazione> ordinazioni;

	public Ristorante() {
		this.cuochi = new ArrayList<Cuoco>();
		this.prodotti = new ArrayList<Prodotto>();
		this.ordinazioni = new ArrayList<Ordinazione>();
	}

	public Cuoco creaCuoco(String nome, String cognome, String email, String numeroTelefono) {
		Cuoco cercato = this.cercaCuoco(email);
		if (cercato == null) {
			Cuoco nuovoCuoco = new Cuoco(nome, cognome, email, numeroTelefono);
			this.cuochi.add(nuovoCuoco);
			return nuovoCuoco;
		} else {
			return null;
		}
	}

	public Cuoco cercaCuoco(String email) {
		for (Cuoco c : this.cuochi) {
			if (c.getEmail().contentEquals(email)) {
				return c;
			}
		}
		return null;
	}

	public Collection<Cuoco> elencoCuochi() {
		Collections.sort(this.cuochi, Cuoco.comparatorNomeCognome);
		return this.cuochi;
	}

	public Prodotto creaProdotto(String nome, String tipologia, int prezzo) {
		Prodotto cercato = this.cercaProdotto(nome);
		if (cercato == null) {
			if (tipologia.contentEquals("PR")) {
				Primo nuovoPrimo = new Primo(nome, prezzo);
				this.prodotti.add(nuovoPrimo);
				return nuovoPrimo;
			} else if (tipologia.contentEquals("D")) {
				Dolce nuovoDolce = new Dolce(nome, prezzo);
				this.prodotti.add(nuovoDolce);
				return nuovoDolce;
			} else if (tipologia.contentEquals("B")) {
				Bevanda nuovaBevanda = new Bevanda(nome, prezzo);
				this.prodotti.add(nuovaBevanda);
				return nuovaBevanda;
			}
		} else {
			cercato.setPrezzo(prezzo);
			return cercato;
		}
		return null;
	}

	public Prodotto cercaProdotto(String nome) {
		for (Prodotto p : this.prodotti) {
			if (p.getNome().contentEquals(nome)) {
				return p;
			}
		}
		return null;
	}

	public String elencoProdotti() {
		String res = "";
		Collections.sort(this.prodotti, Prodotto.comparatorNome);
		for (Prodotto p : this.prodotti) {
			res += p + "\n";
		}
		if (res.length() == 0) {
			return res;
		} else {
			return res.substring(0, res.length() - 1);
		}
	}

	public Ordinazione nuovaOrdinazione(int numeroTavolo, Collection<String> nomiProdotti) {
		Ordinazione o = this.cercaOrdinazione(numeroTavolo);
		boolean nessunAggiunta = true;
		if (o == null) {
			o = new Ordinazione(numeroTavolo);
			this.ordinazioni.add(o);
		}
		for (String s : nomiProdotti) {
			for (Prodotto p : prodotti) {
				if (p.getNome().contentEquals(s)) {
					o.addProdotto(p);
					nessunAggiunta = false;
					break;
				}
			}
		}

		if (nessunAggiunta) {
			return null;
		}

		// Assegna ordinazioni
		Collections.sort(this.cuochi, Cuoco.comparatorNomeCognome);
		for (int i = 0; i < 2; i++) {
			for (Cuoco c : cuochi) {
				if (c.getOrdinazioniAssegnate()[i] == null) {
					c.getOrdinazioniAssegnate()[i] = o;
					return o;
				}
			}
		}
		return o;
	}

	public Ordinazione cercaOrdinazione(int numeroTavolo) {
		for (Ordinazione o : this.ordinazioni) {
			if (o.getNumeroTavolo() == numeroTavolo) {
				return o;
			}
		}
		return null;
	}

	public Collection<Prodotto> getProdottiOrdinazione(int numeroTavolo) {
		Ordinazione o = this.cercaOrdinazione(numeroTavolo);
		Collections.sort(o.getProdotti(), Prodotto.comparatorNome);
		return o.getProdotti();
	}

	public Collection<Ordinazione> getOrdinazioniCuoco(String email) throws CuocoNonEsistenteException {
		Cuoco c = this.cercaCuoco(email);
		if (c == null) {
			throw new CuocoNonEsistenteException();
		}
		List<Ordinazione> res = new ArrayList<Ordinazione>(Arrays.asList(c.getOrdinazioniAssegnate()));
		while (res.contains(null)) {
			res.remove(null);
		}
		return res;
	}

	public void leggiDatiRistorante(String nomeFile) throws IOException{
		File file = new File(nomeFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String row;
		while((row = br.readLine()) != null) {
			String[] data = row.split(";");
			if (data[0].contentEquals("C")) {
				this.creaCuoco(data[1], data[2], data[3], data[4]);
			} else if (data[0].contentEquals("B")) {
				Bevanda b = (Bevanda) this.creaProdotto(data[1], data[0], Integer.parseInt(data[2]));
				b.setGradi(Integer.parseInt(data[3]));
			} else if (data[0].contentEquals("PR")) {
				Primo p = (Primo) this.creaProdotto(data[1], data[0], Integer.parseInt(data[2]));
				p.setDescrizione(data[3]);
			} else if (data[0].contentEquals("D")) {
				Dolce d = (Dolce) this.creaProdotto(data[1], data[0], Integer.parseInt(data[2]));
				d.setDescrizione(data[3]);
		}
	}
	}
	}
