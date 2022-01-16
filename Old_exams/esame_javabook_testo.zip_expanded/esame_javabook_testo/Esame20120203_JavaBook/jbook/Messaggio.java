package jbook;
import java.util.*;

public class Messaggio {
	private Utente autore;
	private String testo;
	private long time;

    public Messaggio(Utente autore, String testo, long time) {
		this.autore = autore;
		this.testo = testo;
		this.time = time;
	}

	public Utente getAutore(){
        return this.autore;
    }
    
    public String getTesto(){
        return this.testo;
    }
    
    public long getTime(){
        return this.time;
    }
    
    public static String quantoTempoFa(long t){
    	long diff = System.currentTimeMillis() - t;
    	if (diff < 1000*60) {
    		int numS = (int) (diff/1000);
    		return numS + " secondi fa";
    	} else if (diff < 1000*60*60) {
    		int numM = (int) (diff/(1000*60));
    		return numM + " minuti fa";
    	} else {
    		int numH = (int) (diff/(1000*60*60));
    		return numH + " ore fa";
     	}
    }
    
    public static Comparator<Messaggio> comparatorTempo = new Comparator<Messaggio>() {
    	public int compare(Messaggio m1, Messaggio m2) {
    		if (m1.getTime() > m2.getTime()) {
    			return -1;
    		} else if (m1.getTime() == m2.getTime()) {
    			return 0;
    		} else {
    			return 1;
    		}
    	}
    };
}
