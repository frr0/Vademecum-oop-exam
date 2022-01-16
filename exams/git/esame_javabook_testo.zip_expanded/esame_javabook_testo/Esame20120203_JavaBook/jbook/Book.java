package jbook;

import java.util.*;

public class Book {
	private ArrayList<Account> accounts;
	
	public Book() {
		this.accounts = new ArrayList<Account>();
	}
    
    public void nuovoAccount(String id, String pwd){
    	Account nuovoAccount = new Account(id, pwd);
    	for (Account a: this.accounts) {
    		if (a.equals(nuovoAccount)){
    			return;
    		}
    	}
    	this.accounts.add(nuovoAccount);

    }
    
    public Account accedi(String id, String pwd) throws AccessoFallitoException {
    	Account dummyAccount = new Account(id, null);
    	for (Account a: this.accounts) {
    		if (a.equals(dummyAccount) && a.checkPassword(pwd)) {
    			a.setConnesso(true);
    			return a;
    		} 
    	}
    	throw new AccessoFallitoException();
    }

    public Collection<Utente> cercaUtenti(String search){
    	ArrayList<Utente> trovati = new ArrayList<Utente>();
    	for (Account a: this.accounts) {
    		if (a.getNome().contains(search)) {
    			trovati.add(a.mioUtente());
    		}
    	}
        return trovati;
    }
}
