package jbook;

public class Messaggio implements Comparable<Messaggio>{
	private String testo;
	private Utente utente;
	private long tempo;
	
	public Messaggio(Utente u ,String t){
		utente = u;
		testo = t;
		tempo = System.currentTimeMillis();
	}
	

    public Utente getAutore(){
        return utente;
    }
    
    public String getTesto(){
        return testo;
    }
    
    public long getTime(){
        return tempo;
    }
    
    public static String quantoTempoFa(long t){
    	long adesso = System.currentTimeMillis();
    	
    	if (adesso-t<60*1000)
    		return ""+(adesso-t)/1000+ " secondi fa";
    	else if (adesso-t<60*60*1000)
    		return ""+(adesso-t)/(60*1000)+" minuti fa";
    	else 
    		return ""+(adesso-t)/(60*60*1000)+" ore fa";
    }


	@Override
	public int compareTo(Messaggio altro) {
		return -(int)(tempo-altro.getTime());
	}
}
