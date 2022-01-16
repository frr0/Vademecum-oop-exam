package libreria;

import java.util.*;
import java.io.*;

public class Libreria {

	private Map<String,Editore> editori = new TreeMap<String,Editore>();
	private List<Libro> libri = new LinkedList<Libro>();
	private List<Ordine> ordini = new LinkedList<Ordine>();

    public Editore creaEditore(String nome, int tempoConsegna, String email){
        
    	Editore tempe =  new Editore(nome, tempoConsegna, email);
    	editori.put(nome, tempe);
    	return tempe;
    }

    public Editore getEditore(String nome){
        return editori.get(nome);
    }
    
    public Collection getEditori(){
        return editori.values();
    }

    public Libro creaLibro(String titolo, String autore, int anno, double prezzo, String nomeEditore)
    			throws EditoreInesistente {
    	
    	Editore editore = editori.get(nomeEditore);
    	
    	if(editore==null) //Devo scatenare un'eccezione
    		throw new EditoreInesistente();
    	
    	Libro templ = new Libro(titolo,autore,anno,prezzo,editore, this);
    	
    	libri.add(templ); // Aggiungo il libro alla lista prima di restituirne un riferimento
    	
        return templ;
    }
    
    public Libro getLibro(String autore, String titolo){
        
    	Libro libro = null;
    	for(Iterator<Libro> i = libri.iterator(); i.hasNext();       )
    	{
    		// Qui sto considerando un libro
    		libro = i.next();
    		
    		if(  (autore==null || autore.equals(libro.getAutore())) 
    				&& (titolo==null || titolo.equals(libro.getTitolo())))
    		{
    			return libro;	
    		}
    	}
    	return null; //Libro cercato non trovato
    }
    
    public Collection getClassificaSettimana(final int settimana){
        
    	List<Libro> classifica = new LinkedList<Libro>( libri );
    	Collections.sort(classifica,new Comparator<Object>(){
    		public int compare(Object x, Object y){
  	          Libro a=(Libro)x;
	          Libro b=(Libro)y;
	          return - (a.settimane[settimana-1]-b.settimane[settimana-1]);
    		}
    	});
    	return classifica;
    }
    
    public Collection getClassificaMese(final int mese){
    	List<Libro> classifica = new LinkedList<Libro>( libri );
    	Collections.sort(classifica,new Comparator<Object>(){
    		public int compare(Object x, Object y){
  	          Libro a=(Libro)x;
	          Libro b=(Libro)y;
	          return - (a.mesi[mese-1]-b.mesi[mese-1]);
    		}
    	});
    	return classifica;
    }
    
    public Collection getOrdini(){
    	return ordini;

    }
    
    public void ordineRicevuto(int numOrdine){
    	Ordine o = ordini.get(numOrdine);
    	o.consegna();

    }
    
    public void creaOrdine(Libro libro, int quantita) {

		Ordine o = new Ordine(ordini.size(),libro,quantita);
		ordini.add(o);
	}
    
    
    public void leggi(String file) {
    	
    	try
    	{
    		BufferedReader br = new 
    		     BufferedReader(new FileReader(file));
    		String riga;
    		while( (riga = br.readLine())!=null  )
    		{
    			try
    			{
	    			// Qui ho letto una riga 
	    			
	    			StringTokenizer st = new StringTokenizer(riga,";");
	    			// Non genero un array di stringhe come con split(), ma accedo ai singoli "token" mediante il metodo nextToken();
	    			
	    			String type = st.nextToken(); 
	    			if(type.equals("E")) // Editore
	    			{
	    				String nome  = st.nextToken();
	    				int tempo    = Integer.parseInt(st.nextToken());
	    				String email = st.nextToken();
	    				Editore tempe = this.creaEditore(nome, tempo, email); // Riuso del codice
	    				
	    			}
	    			else if (type.equals("L")) // Libro
	    			{
	    				String titolo  = st.nextToken();
	    				String autore  = st.nextToken();
	    				int anno       = Integer.parseInt(st.nextToken());
	    				double prezzo  = Double.parseDouble(st.nextToken());
	    				String editore = st.nextToken();
	    				int quantita   = Integer.parseInt(st.nextToken());
	    				this.creaLibro(titolo, autore, anno, prezzo, editore);
	    				Libro templ = this.getLibro(autore, titolo);
	    				templ.setQuantita(quantita);
	    			}
    			}
        		catch(EditoreInesistente e){
        			
        		}
        		catch(NoSuchElementException e){
        			
        		}
        		catch(NumberFormatException e){
        			
        		}
    		
    		}
    	}
    	catch(FileNotFoundException e){

    	}
    	catch(IOException e){

    	}
    	
    }
}
