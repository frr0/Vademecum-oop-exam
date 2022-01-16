package jbook;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Account {
	private Utente utente;
	
	
	public Account(Utente u){
		this.utente = u;
	}
	

    public String getId(){
        return utente.getId();
    }
    
    public String getNome(){
        return utente.getNome();
    }

    public void setNome(String nuovoNome){
    	utente.setNome(nuovoNome);
    }
    

    public Utente mioUtente(){
        return utente;
    }
    
    public Collection<Utente> richieste(){
        return utente.getRichieste();
    }
    
    public void accetto(Utente nuovoAmico) throws RichiestaInesistenteException {
    	boolean trovato =false;
    	
    	for (int i=0; i<utente.getRichieste().size();i++){
    		Utente u = utente.getRichieste().get(i);
    		if(u.equals(nuovoAmico)){
    			utente.getRichieste().remove(i); // togliamo il nuovo amico dall lista richiest
    			utente.addAmico(nuovoAmico);
    			nuovoAmico.addAmico(utente);
    			trovato = true;
    			break;
    		}
    	}
    	if (!trovato)
    		throw new RichiestaInesistenteException();
    }
    
    public Messaggio post(String testo){
    	// aggiungiamo un nuovo messaggio
    	Messaggio m = new Messaggio(utente, testo );
    	// lo aggiungiamo all'elenco dei messaggi dell'utente
    	utente.addMessaggio(m);
        return m;
    }
    
    public List<Messaggio> aggiornamenti(){
    	List<Messaggio> listona = new LinkedList<Messaggio>();
    	listona.addAll(utente.bacheca());
    	for (int i =0; i<utente.amici().size(); i++){
    		Utente u = ((List<Utente>)utente.amici()).get(i);
    		listona.addAll(u.bacheca());
    	}
    	Collections.sort(listona);
        return listona;
    }

}
