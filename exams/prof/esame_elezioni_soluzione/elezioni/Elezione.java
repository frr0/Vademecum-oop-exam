package elezioni;

import java.util.*;


public class Elezione {

	Map<String, Cittadino> elettori = new TreeMap<String, Cittadino>();
	Map<String, Lista> liste = new HashMap<String,Lista>();
	
	int numeroVotanti;
	
	public Elezione(){
		numeroVotanti=0;
	}
	
	public Cittadino aggiungiElettore(String nome, String cognome){
		// 1) Creare un cittadino
		Cittadino c = new Elettore(nome, cognome);

		// 2) Aggiungere il cittadino ad una qualche struttura dati
		elettori.put(nome+" "+cognome, c);
		
		return c;
	}
	
	public Collection getElettori(){
		return elettori.values();
	}
	
	public Cittadino getElettore(String nome, String cognome){
		return elettori.get(nome+" "+cognome);
	}
	
	public void registraLista(Lista lista){
		liste.put(lista.getNome(), lista);
		// Dopo aver registrato la lista occorre anche assegnarle l'elezione con il metodo setElezione()  
		lista.setElezione(this);
	}

	public void vota(Cittadino votante, String lista, String nome, String cognome)
		throws TentatoDoppioVoto, TaglioNonPermesso{

		if(votante.haVotato())
			throw new TentatoDoppioVoto();
		
		// Può votare
		Lista l = liste.get(lista);

		//Elettore e = (Elettore)elettori.get(nome+" "+cognome);
		Elettore e = l.getElettore(nome,cognome);
		
		if(e==null)
			throw new TaglioNonPermesso();
		
		// Adesso implemento la "funzione" di voto
		((Elettore)votante).setHaVotato(true); // Il cittandino ha votato
		e.addVoto();                           // Chi?
		l.addVoto();                           // Che cosa?
		
		// Incremento anche il numero totale di votanti
		this.numeroVotanti++;
	}

	public void vota(Cittadino votante, String lista)
		throws TentatoDoppioVoto{
		
		if(votante.haVotato())
			throw new TentatoDoppioVoto();
		
		Lista l = liste.get(lista);

		Elettore e = (Elettore)l.getCapolista();
	
		((Elettore)votante).setHaVotato(true);
		
		e.addVoto();
		l.addVoto();
		
		this.numeroVotanti++;

	}
	
	
	public long getNumeroVotanti(){
		return numeroVotanti;
	}
	
	public Collection getRisultatiListe(){
		
		Collection<Lista> templ = new LinkedList<Lista>(liste.values());
		Collections.sort((List)templ);
		
		return templ;
	}

	public Collection getRisultatiCandidati(){
		LinkedList<Elettore> candidati = new LinkedList<Elettore>();
		for (Iterator iter = liste.values().iterator(); iter.hasNext();) {
      		Lista lista = (Lista) iter.next();
      		candidati.add((Elettore)lista.getCapolista());
      		candidati.addAll(lista.getCandidati());
		}
    	Collections.sort(candidati);
		return candidati;
	}
	
	
	public Lista getLista(String nome){
		return liste.get(nome);
	}
	
	public Cittadino getCittadino(String nomecognome){
		return elettori.get(nomecognome);
	}

	
}
