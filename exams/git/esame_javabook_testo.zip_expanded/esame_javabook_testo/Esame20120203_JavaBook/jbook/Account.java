package jbook;

import java.util.*;


public class Account {
	
	private String id;
	private String password;
	private Utente utente;
	private boolean connesso;
	
	public Account(String id, String password) {
		this.id = id;
		this.password = password;
		this.utente = new Utente();
		this.connesso = false;
	}

    public String getId(){
        return this.id;
    }
    
    public boolean getConnesso() {
    	return this.connesso;
    }
    
    public void setConnesso(boolean b) {
    	this.connesso = b;
    }
    
    public String getNome(){
        return this.utente.getNome();
    }

    public void setNome(String nuovoNome){
    	this.utente.setNome(nuovoNome);
    }
    

    public Utente mioUtente(){
        return this.utente;
    }
    
    public Collection<Utente> richieste(){
        return this.utente.getRichieste();
    }
    
    public void accetto(Utente nuovoAmico) throws RichiestaInesistenteException {
    	if (!this.richieste().contains(nuovoAmico)) {
    		throw new RichiestaInesistenteException();
    	} else {
    		this.utente.aggiungiAmico(nuovoAmico);
    		nuovoAmico.aggiungiAmico(this.utente);
    		this.utente.rimuoviRichiesta(nuovoAmico);
    	}
        
    }
    
    public Messaggio post(String testo){
    	Messaggio nuovoMessaggio = new Messaggio(this.utente, testo, System.currentTimeMillis());
    	this.utente.aggiungiPost(nuovoMessaggio);
        return nuovoMessaggio;
    }
    
    public List<Messaggio> aggiornamenti(){
    	ArrayList<Messaggio> aggiornamenti = new ArrayList<Messaggio>();
    	aggiornamenti.addAll(this.utente.bacheca());
    	for (Utente u: this.utente.amici()) {
    		aggiornamenti.addAll(u.bacheca());
    	}
    	Collections.sort(aggiornamenti, Messaggio.comparatorTempo);
        return aggiornamenti;
    }
    
    public boolean equals(Account a2) {
    	if (this.id.contentEquals(a2.getId())) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public boolean checkPassword(String password) {
    	if (this.password.contentEquals(password)) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
