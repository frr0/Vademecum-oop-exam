package casaeditrice;

import java.util.*;

public class Pubblicazione {
	protected Autore proprietario;
	protected int contributoProprietario;
	protected HashMap<Autore, Integer> coAutori;
	protected String titolo;
	protected String volume;
	protected int anno;
	

	public Pubblicazione(String titolo, String volume, int anno, Autore proprietario, int contributoProprietario) {
		this.proprietario = proprietario;
		this.titolo = titolo;
		this.volume = volume;
		this.anno = anno;
		this.contributoProprietario = contributoProprietario;
		this.coAutori = new HashMap<Autore, Integer>();
	}

	public String getTitolo(){
		return this.titolo;
	}
	
	public String getVolume(){
		return this.volume;
	}
	
	public int getAnno(){
		return this.anno;
	}

	public Autore getProprietario(){
		return this.proprietario;
	}

	public void aggiungiCoautori(Autore a, int contributo) throws AutoreDuplicatoException{
		if (a.getCodice() == this.proprietario.getCodice()) {
			throw new AutoreDuplicatoException();
		}
		for (Autore key: this.coAutori.keySet()) {
			if (a.getCodice() == key.getCodice()) {
				throw new AutoreDuplicatoException();
			}
		}
		this.coAutori.put(a, contributo);
	}
	
	public Collection<Autore> elencoAutori(){
		ArrayList<Autore> res = new ArrayList<Autore>(this.coAutori.keySet());
		Collections.sort(res, Autore.comparatorCognomeNome);
		res.add(0, this.proprietario);
		return res;
	}

	public int getContributo(Autore a){
		if (a.getCodice() == this.proprietario.getCodice()) {
			return this.contributoProprietario;
		} else {
			return this.coAutori.get(a);
		}
	}
	
	public static Comparator<Pubblicazione> comparatorAnno = new Comparator<Pubblicazione>() {
		public int compare(Pubblicazione p1, Pubblicazione p2) {
			return p2.getAnno() - p1.getAnno();
		}
	};
	
}
