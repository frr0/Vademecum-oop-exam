package jbook;

import java.util.*;


public class Utente {
	
	private String nome;
	private ArrayList<Utente> friends;
	private ArrayList<Utente> richieste;
	private ArrayList<Messaggio> posts;
	
	
	public Utente() {
		this.nome = "";
		this.friends = new ArrayList<Utente>();
		this.richieste = new ArrayList<Utente>();
		this.posts = new ArrayList<Messaggio>();
	}

    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public void richiestaAmicizia(Utente richiedente){
    	this.richieste.add(richiedente);
    }
    
    public Collection<Utente> getRichieste(){
    	return this.richieste;
    }
    
    public Collection<Utente> amici(){
        return this.friends;
    }
    
    public List<Messaggio> bacheca(){
    	Collections.sort(this.posts, Messaggio.comparatorTempo);
        return this.posts;
    }
    
    public double livelloSociale(){
    	int counter = 0;
    	for (Utente amico1: this.friends) {
    		for (Utente amico2: this.friends) {
    			if (amico1.amici().contains(amico2)) {
    				counter++;
    			}
    		}
    	}
        return (double) (counter/this.amici().size());
    }

    public double livelloAttivita(){
    	double counter = 0;
    	long timenow = System.currentTimeMillis();
    	for (Messaggio m: this.posts) {
    		if ((timenow - m.getTime()) < 1000*60*60) {
    			counter += 1;
    		}
    	}
        return counter;
    }
    
    public void aggiungiAmico(Utente u) {
    	this.friends.add(u);
    }
    
    public void rimuoviRichiesta(Utente u) {
    	this.richieste.remove(u);
    }
    
    public void aggiungiPost(Messaggio m) {
    	this.posts.add(m);
    }
}
