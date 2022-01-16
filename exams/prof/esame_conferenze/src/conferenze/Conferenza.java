package conferenze;

import java.util.*;

public class Conferenza {
	private String acronimo;
	private String nome;
	private String luogo;
	private int anno;
	private String dataInizio;
	private String dataFine;
	private int quotaIscrizione;
	private LinkedList<String> sponsors;
	private int codiceProgressivo;
	private LinkedList<Lavoro> lavori;
	private LinkedList<Utente> utenti;
	
	public Conferenza(String acronimo, String nome, String luogo, int anno,
			String dataInizio, String dataFine, int quotaIscrizione) {
		super();
		this.acronimo = acronimo;
		this.nome = nome;
		this.luogo = luogo;
		this.anno = anno;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.quotaIscrizione = quotaIscrizione;
		sponsors=new LinkedList<String>();
		codiceProgressivo=1;
		lavori=new LinkedList<Lavoro>();
		utenti= new LinkedList<Utente>();
	}

	

	public int getQuotaIscrizione() {
		return quotaIscrizione;
	}

	public void setQuotaIscrizione(int quotaIscrizione) {
		this.quotaIscrizione = quotaIscrizione;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getNome() {
		return nome;
	}

	public String getLuogo() {
		return luogo;
	}

	public int getAnno() {
		return anno;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}	

	public int getQuotaIScrizione() {
		return quotaIscrizione;
	}	
	
	public String getAcronimo(){
		return acronimo;
	}

	public void aggiungiSponsor(String sponsor){
		if(!sponsors.contains(sponsor))
		sponsors.add(sponsor);
	}
	
	public Collection<String> elencoSponsor(){
		return sponsors;
	}
	static class ComparatoreConferenzeNomeAnno implements Comparator<Conferenza>{

		public int compare(Conferenza arg0, Conferenza arg1) {
			if(arg0.getNome().compareTo(arg1.getNome())!=0)
				return arg0.getNome().compareTo(arg1.getNome());
			if(arg0.getAnno()<arg1.getAnno())
				return -1;
			if(arg0.getAnno()>arg1.getAnno())
				return 1;
			return 0;
		}
		
	}
	public int getCodiceProgressivo() {
		codiceProgressivo=codiceProgressivo +1;
		return codiceProgressivo -1;
	}



	public void aggiungiLavoro(Lavoro temp) {
		lavori.add(temp);
		
	}
	
	public String programma(){
		LinkedList<Poster> poster=new LinkedList<Poster>();
		LinkedList<Articolo> articoli=new LinkedList<Articolo>();
		
		for(Lavoro l:lavori){
			if(l instanceof Poster)
				poster.add((Poster) l);
			if(l instanceof Articolo)
				articoli.add((Articolo) l);
		}
		Collections.sort(poster);
		Collections.sort(articoli);
		LinkedList<Lavoro> tib=new LinkedList<Lavoro>();
		tib.addAll(articoli);
		tib.addAll(poster);
		String s=new String();
		for(int i=0;i<tib.size()-1;i++){
			s=s+tib.get(i).getTitolo()+","+"\n";
		}
		
		s=s+tib.get(tib.size()-1).getTitolo()+".";
		return s.trim();
	}



	public void iscriviUtente(Utente utente) {
		utenti.add(utente);
	}



	public Collection<Utente> ElencoIscritti() {
		
		return utenti;
	}



	public int getNumeroIscritti() {
		
		return utenti.size();
	}



	

}
