package polichef;

import java.util.*;

public class Fase {

	private int numeroFase;
	private String nome;
	private int numeroMassimoConcorrenti;
	
	private TreeMap<String, Concorrente> mappaConcorrentiFase = new TreeMap<String, Concorrente>();
	private LinkedList<Sfida> listaSfide = new LinkedList<Sfida>();
	
	public Fase(int numeroFase, String nome, int numeroMassimoConcorrenti) {
		this.numeroFase = numeroFase;
		this.nome = nome;
		this.numeroMassimoConcorrenti = numeroMassimoConcorrenti;
	}
	
	public void aggiungiConcorrenteFase(Concorrente c) {
		mappaConcorrentiFase.put(c.getId(),c);
	}

	public void definisciSfidaFase(Concorrente c1, Piatto p1, Concorrente c2, Piatto p2, String esito) {
		Sfida stemp = new Sfida(c1, p1, c2, p2, esito);
		listaSfide.add(stemp);
	}

	public String descrizioneSfideFase() {
		String risultato = "";
		for(Sfida stemp : listaSfide) {
			risultato+=" "+stemp.concorrente1.getId()+", "+stemp.piatto1.getIdPiatto()+", "+stemp.concorrente2.getId()+", "+stemp.piatto2.getIdPiatto()+", "+stemp.esito+"\n";
		}
		return risultato;
	}


	public int getNumeroFase() {
		return numeroFase;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMassimoConcorrenti() {
		return numeroMassimoConcorrenti;
	}
	
	public TreeMap<String, Concorrente> getMappaConcorrentiFase() {
		return mappaConcorrentiFase;
	}

	public LinkedList<Sfida> getListaSfide() {
		return listaSfide;
	}

	
	
	
	
}
