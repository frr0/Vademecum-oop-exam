package conferenze;

import java.util.*;

public class SistemaGestione {
	private TreeMap<String,Conferenza> conferenze;
	private TreeMap<String,Utente> utenti;
	private TreeMap<String,Lavoro> lavori;
	
	

	public SistemaGestione() {
		conferenze=new TreeMap<String,Conferenza>();
		utenti=new  TreeMap<String,Utente>();
		lavori=new TreeMap<String,Lavoro>();
	}

	public Conferenza nuovaConferenza(String nome, String luogo, int anno, String dataInizio, String dataFine, int quotaIscrizione){
		String acronimo=new String("");
		String[] s=nome.split(" ");
		for(String ss:s)
			acronimo=acronimo+ss.substring(0,1).toUpperCase();
		
		acronimo=acronimo+anno;
		
		if(!conferenze.containsKey(acronimo)){
		Conferenza temp=new Conferenza(acronimo, nome,luogo,anno,dataInizio,dataFine,quotaIscrizione);
		conferenze.put(acronimo, temp);
		}
		else{
			Conferenza aggiorna=conferenze.get(acronimo);
			aggiorna.setDataFine(dataFine);
			aggiorna.setDataInizio(dataInizio);
			aggiorna.setLuogo(luogo);
			aggiorna.setQuotaIscrizione(quotaIscrizione);
		}
		
		return conferenze.get(acronimo);
		
	}
	
	public Collection<Conferenza> elencoConferenze(){
		LinkedList<Conferenza> temp=new LinkedList<Conferenza>(conferenze.values());
		Collections.sort(temp,new Conferenza.ComparatoreConferenzeNomeAnno());
		return temp;
	}

	public Collection<Conferenza> elencoConferenze(int annoDa, int annoA){
		LinkedList<Conferenza> temp=new LinkedList<Conferenza>();
		for(Conferenza c:conferenze.values()){
			if(c.getAnno()>=annoDa&&c.getAnno()<=annoA)
				temp.add(c);
		}
		
		Collections.sort(temp,new Conferenza.ComparatoreConferenzeNomeAnno());
		return temp;
	}

	public void nuovoUtente(String nome, String cognome, String organizzazione, String email) throws UtenteDuplicatoException{
		if(utenti.containsKey(email)){
			throw new UtenteDuplicatoException();}
		
		
		Utente temp=new Utente (nome,cognome,organizzazione,email);
		utenti.put(email, temp);
		
	}
	
	public Utente cercaUtente(String daCercare){
		Utente temp=null;
		for(Utente u:utenti.values()){
			if(u.contieneStringa(daCercare))
				temp=u;
		}
		return temp;
	}
	
	public Collection<Utente> elencoUtenti(){
		LinkedList<Utente> temp=new LinkedList<Utente>(utenti.values());
		Collections.sort(temp,new Utente.ComparatoreUtentiCognomeNome());
		
		return temp;
	}
	
	public String sottomettiLavoro(String acronimo, String titolo, char tipologia, String email){
		if(utenti.containsKey(email)&&conferenze.containsKey(acronimo)){
		Lavoro temp=null;
		if(tipologia=='A'){
			int i=conferenze.get(acronimo).getCodiceProgressivo();
			String id=acronimo+"-"+i;
			temp=new Articolo(titolo,id,conferenze.get(acronimo),utenti.get(email));
			lavori.put(id, temp);
			conferenze.get(acronimo).aggiungiLavoro(temp);
			}
		if(tipologia=='P'){
			int i=conferenze.get(acronimo).getCodiceProgressivo();
			String id=acronimo+"-"+i;
			temp=new Poster(titolo,id,conferenze.get(acronimo),utenti.get(email));
			lavori.put(id, temp);
			conferenze.get(acronimo).aggiungiLavoro(temp);
			}
		
		return temp.getId();
		}
		return null;
	}
	
	public Lavoro cercaLavoro(String id){
		return lavori.get(id);
	}

	public void aggiungiAutore(String id, String email){
		if(utenti.containsKey(email)&&lavori.containsKey(id)){
		Lavoro temp=lavori.get(id);
		temp.aggiungiAutore(utenti.get(email));
		}
	}
	
	public Collection<Utente> elencoAutori(String id){
		Lavoro temp=lavori.get(id);
		return temp.collezioneAutori();
	}

	public void nuovaRevisione(String id, String email, String commento, int punteggio) throws RevisioneRifiutataException{
		if(!lavori.containsKey(id)||!utenti.containsKey(email)||punteggio<1||punteggio>5){
			throw new RevisioneRifiutataException();}
		
		lavori.get(id).aggiungiRevisione(punteggio);
	}	
	
	public String generaProgramma(String acronimo){
		return conferenze.get(acronimo).programma();
	}
	
	public void iscrivi(String email, String acronimo){
		if(utenti.containsKey(email)&&conferenze.containsKey(acronimo)){
			conferenze.get(acronimo).iscriviUtente(utenti.get(email));
		}
		
	}
	
	public Collection<Utente> elencoIscritti(String acronimo){
		return conferenze.get(acronimo).ElencoIscritti();
		
	}
	
	public int calcolaIncasso(String acronimo){
		return conferenze.get(acronimo).getQuotaIScrizione()*conferenze.get(acronimo).getNumeroIscritti();
	}
	
}
