package jbook;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Utente {
	private String id;
	private String pwd;
	private String nome;
	
	private List<Utente> richieste = new LinkedList<Utente>();
	private List<Utente> amici = new LinkedList<Utente>();
	private List<Messaggio> bacheca = new LinkedList<Messaggio>();
	
	
    public Utente(String id, String pwd) {
    	this.id= id;
    	this.pwd= pwd;
    	this.nome="";
	}

	public String getNome(){
        return nome;
    }
	
	public String getPwd(){
		return pwd;
	}
    
    public void richiestaAmicizia(Utente richiedente){
    	richieste.add(richiedente);
    }
    
    public List<Utente> getRichieste(){
    	return richieste;
    }
    
    public Collection<Utente> amici(){
        return amici;
    }
    
    public List<Messaggio> bacheca(){
    	Collections.sort(bacheca);
        return bacheca;
    }
    
    public boolean haAmico(Utente u){
    	for (int i =0; i<amici.size(); i++)
    		if (amici.get(i).getId().compareTo(u.getId())==0)
    			return true;
    	return false;
    }
    
    
    public double livelloSociale(){
    	
    	List<Integer> numAmici = new LinkedList<Integer>();
    	for (Utente amico : amici){
    		int amiciCondivisi=0;
    		List<Utente> amiciDiAmico = new LinkedList<Utente>();
    		amiciDiAmico.addAll(amico.amici());
    		for (Utente amicoDiAmico : amiciDiAmico)
    			if (this.haAmico(amicoDiAmico))
    				amiciCondivisi++;
    		numAmici.add(amiciCondivisi);
    	}
    	
    	double avg=0;
    	for(Integer num:numAmici){
    		avg+=num;
    	}
        return avg/numAmici.size();
    }

    public double livelloAttivita(){
    	long adesso = System.currentTimeMillis();
    	double livello=0;
    	Collections.sort(bacheca);
    	for (int i=0; i<bacheca.size(); i++)
    		if (adesso-bacheca.get(i).getTime()<60*60*1000)
    			livello++;
        return livello;
    }

	public String getId() {
		return id;
	}

	public void setNome(String nuovoNome) {
		nome = nuovoNome;
	}

	public void addAmico(Utente nuovoAmico) {
		amici.add(nuovoAmico);
	}
	
	public void addMessaggio(Messaggio m){
		bacheca.add(m);
	}
	
}
