package libreria;

public class Libro {

	private String titolo;
	private String autore;
	private int anno;
	private double prezzo;
	private Editore editore; // Riferimento all'editore, non il nome
	
	private int quantita;
	
	private int soglia;
	private int quantitaRiordino;
	
	private Libreria libreria;
	
	
	int[] settimane = new int[52];
	int[] mesi = new int[12];
	
    public Libro(String titolo, String autore, int anno, double prezzo,
			Editore editore, Libreria l) {
    	
    	this.titolo=titolo;
    	this.autore=autore;
    	this.anno=anno;
    	this.prezzo=prezzo;
    	this.editore=editore;
		this.libreria=l;
	}

	public String getTitolo(){
        return titolo;
    }
    
    public String getAutore(){
        return autore;
    }
    
    public int getAnno(){
        return anno;
    }

    public double getPrezzo(){
        return prezzo;
    }
    
    public Editore getEditore(){
        return editore;
    }

    public void setQuantita(int q){
    	this.quantita=q;
    	
    }
    
    public int getQuantita(){
        return this.quantita;	
    }

    public void registraVendita(int settimana, int mese){
    	settimane[settimana-1]++;
    	mesi[mese-1]++;
    	this.quantita--;
    	
    	if(this.quantita==this.soglia)
    	{
    	     libreria.creaOrdine(this, quantitaRiordino);	
    	}

    }
    

    public void setParametri(int soglia, int quantitaRiordino){
    	this.soglia=soglia;
    	this.quantitaRiordino=quantitaRiordino;
    	
    }
    
    public void incrementa(int quantita){
    	this.quantita+=quantita;
    }
    
    
    public String toString(){
    	return ""+titolo+" "+autore+" ecc. ecc.";
    }
    
}
