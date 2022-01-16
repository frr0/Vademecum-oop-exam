package jbook;

import java.util.*;

public class Book {
	private Map<String, Utente> utenti = new HashMap<String, Utente>();
    
    public void nuovoAccount(String id, String pwd){
    	Utente u = new Utente(id, pwd);
    	utenti.put(id, u);
    }
    
    public Account accedi(String id, String pwd)
    		throws AccessoFallitoException {
    	Utente u = utenti.get(id);
    	
    	if (u.getPwd().equals(pwd)){
    		Account a = new Account(u);
    		return a;
    	}
    	else
    		throw new AccessoFallitoException();
    }

    public Collection<Utente> cercaUtenti(String search){
    	List<Utente> output = new LinkedList<Utente>();
    	List<Utente> input = new LinkedList<Utente>(utenti.values());
    	
    	for (int i=0; i<input.size(); i++){
    		Utente u = input.get(i);
    		if (u.getNome().indexOf(search) != -1){
    			output.add(u);
    		}
    	}
    	
        return output;
    }
}
