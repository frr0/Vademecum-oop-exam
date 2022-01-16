package piscine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class GestionePrenotazioni {

	TreeMap<String, Piscina> mappaPiscine = new TreeMap<String,Piscina>();
	LinkedList<Piscina> listaPiscine = new LinkedList<Piscina>();

	// Mappa/Lista di prenotazioni "globale", assieme a versioni 
	// "locali" per la particolare piscina nella classe Piscina
	LinkedList<Prenotazione> listaPrenotazioni = new LinkedList<Prenotazione>();
	TreeMap<String,Prenotazione> mappaPrenotazioni = new TreeMap<String, Prenotazione>();

	public Piscina definisciPiscina(String indirizzoPiscina, int numPostiBordoPiscina, int numPostiPrato, int maxOccupantiPosto) {

		if(mappaPiscine.containsKey(indirizzoPiscina))
			return mappaPiscine.get(indirizzoPiscina);
		
		String codice = indirizzoPiscina.toUpperCase();
		codice = codice.replace(" ", "");
		codice = codice.replace(",", "");
		
		Piscina p = new Piscina(codice, indirizzoPiscina, numPostiBordoPiscina, numPostiPrato, maxOccupantiPosto);

		mappaPiscine.put(indirizzoPiscina, p);
		listaPiscine.add(p);
		
		return p;
	}

	public Piscina cercaPiscina(String indirizzoPiscina) {
		return mappaPiscine.get(indirizzoPiscina);
	}
	
	public Collection<Piscina> elencoPiscine(){
		return listaPiscine;
	}
	
	public Collection<Posto> elencoPostiBordoPiscina(String indirizzoPiscina){

		if(mappaPiscine.containsKey(indirizzoPiscina))
			return cercaPiscina(indirizzoPiscina).listaPostiBordo;
		return null;
	}
	
	public Collection<Posto> elencoPostiPrato(String indirizzoPiscina){
		if(mappaPiscine.containsKey(indirizzoPiscina))
			return cercaPiscina(indirizzoPiscina).listaPostiPrato;
		return null;
	}
	
	public Posto cercaPosto(String indirizzoPiscina, String numeroPosto) {
		if(mappaPiscine.containsKey(indirizzoPiscina))
			return cercaPiscina(indirizzoPiscina).mappaPosti.get(numeroPosto);
		return null;
	}
	
	public void configuraPosto(String indirizzoPiscina, String numeroPosto, boolean ombrellone, int numLettini) {
		if(mappaPiscine.containsKey(indirizzoPiscina)) {
			PostoBordo pb = (PostoBordo)cercaPiscina(indirizzoPiscina).mappaPosti.get(numeroPosto);
			pb.ombrellone = ombrellone;
			if(numLettini>cercaPiscina(indirizzoPiscina).maxOccupantiPosto)
				pb.numLettini = cercaPiscina(indirizzoPiscina).maxOccupantiPosto;
			else
				pb.numLettini=numLettini;
		}
	}
	
	public String nuovaPrenotazione(String indirizzoPiscina, String data, char tipoPosto, String nome, String cognome, String cellulare) throws EccezioneTipoPostoEsaurito {

		Piscina pi = this.cercaPiscina(indirizzoPiscina);
		if(pi==null)
			return null;
		
		if(tipoPosto!='B' && tipoPosto!='P')
			return null;
		
		// Altri eventuali controlli, in base al testo		

		int cnt = 0;
		for(Prenotazione pr : pi.listaPrenotazioni) {
			if( (tipoPosto=='B' && pr.posto instanceof PostoBordo )   
			      || (tipoPosto=='P' && pr.posto instanceof PostoPrato))
				if(pr.data.compareTo(data)==0)
					cnt++;
			
		}
		
		String codice = null;
		if( (tipoPosto=='B' && cnt <pi.numPostiBordoPiscina) ||
			(tipoPosto=='P' && cnt <pi.numPostiPrato)) { // Posti liberi
			// Posso aggiungere la prenotazione
			
			Posto po = pi.mappaPosti.get(""+tipoPosto+""+(cnt+1));
			
			codice = pi.codice+"-"+data+"-"+po.numero;
			
			Prenotazione prTemp = new Prenotazione(codice, data, pi, po,
					                                 nome, cognome, cellulare);
		
			pi.listaPrenotazioni.add(prTemp); // Aggiungo sia alle strutture dati locali ...
			pi.mappaPrenotazioni.put(codice, prTemp);
			
			listaPrenotazioni.add(prTemp); // ... che a quelle globali
			mappaPrenotazioni.put(codice, prTemp);
			
		} else
			throw new EccezioneTipoPostoEsaurito(); // Segnalo tutti posti occupati
		
		return codice;
	}
	
	public Piscina piscinaPrenotazione(String codicePrenotazione) {
		return mappaPrenotazioni.get(codicePrenotazione).piscina;
	}

	public String dataPrenotazione(String codicePrenotazione) {
		return mappaPrenotazioni.get(codicePrenotazione).data;
	}

	public Posto postoPrenotazione(String codicePrenotazione) {
		return mappaPrenotazioni.get(codicePrenotazione).posto;
	}
	
	public String stampaPrenotazione(String codicePrenotazione) {

		return mappaPrenotazioni.get(codicePrenotazione).toString();
	}

	public String stampaPrenotazioniPerCodice() {

		String s = "";
		LinkedList<Prenotazione> listaPrenotazione = new LinkedList<Prenotazione>(mappaPrenotazioni.values());
		for(Prenotazione pr : listaPrenotazione) {
			if(s!="")
				s+="\n";
			s+=pr.toString();
		}
		
		return s;
	}

	public String stampaPrenotazioniPerCognomeNome() {

		String s = "";
		LinkedList<Prenotazione> listaPrenotazione = new LinkedList<Prenotazione>(mappaPrenotazioni.values());
		Collections.sort(listaPrenotazione);
		
		for(Prenotazione pr : listaPrenotazione) {
			if(s!="")
				s+="\n";
			s+=pr.toString();
		}
		return s;
	}
	
	public String stampaDatePrenotatePosto(String indirizzoPiscina, String numeroPosto) {

		Piscina pTemp = cercaPiscina(indirizzoPiscina);
		
		String s ="";
		
		for(Prenotazione pr : pTemp.listaPrenotazioni)
			if(pr.posto.numero.compareTo(numeroPosto)==0)
				s+=pr.data+" ";
		
		return s;
	}
	
	public String StampaNumeroPostiLiberiData(String indirizzoPiscina, String data) {
	
		Piscina pTemp = cercaPiscina(indirizzoPiscina);

		int cntPostiBordo = 0;
		int cntPostiPrato = 0;
		
		for(Prenotazione pr : pTemp.listaPrenotazioni)
			if(pr.data.compareTo(data)==0 && pr.posto instanceof PostoBordo)
				cntPostiBordo++;

		for(Prenotazione pr : pTemp.listaPrenotazioni)
			if(pr.data.compareTo(data)==0 && pr.posto instanceof PostoPrato)
				cntPostiPrato++;
		
		return ""+(pTemp.getNumPostiBordoPiscina()-cntPostiBordo)+" "+(pTemp.getNumPostiPrato()-cntPostiPrato);
	}
	
    public void leggi(String filename){
    	
    	try { // Evito che una qualsivoglia eccezione possa venire scatenata da questo metodo
    		
    		FileReader fr = new FileReader(filename);
    		BufferedReader br = new BufferedReader(fr);
    		
    		String riga;
    		while(  (riga = br.readLine())!=null  ) {
    			// Qui ho una riga 

    			String campi[] = riga.split(";"); // La separo in campi
    			
    			if(campi[0].compareTo("PISCINA")==0) {
    				
    				String indirizzo = campi[1];
    				int numPostiBordoPiscina = Integer.parseInt(campi[2]);
    				int numPostiPrato = Integer.parseInt(campi[3]);
    				int maxPostOccupabili = Integer.parseInt(campi[4]);
    				       // Si potrebbero poi inserire anche try-catch "chirurgici", 
    				       // esempio per gestire singole righe con formato errore nel 
    				       // file di input, non rischiesto in questo tema d'esame
    				definisciPiscina(indirizzo, numPostiBordoPiscina, numPostiPrato, maxPostOccupabili);

    			}else if (campi[0].compareTo("PRENOTAZIONE")==0) {
    				
    				String indirizzo = campi[1];
    			    String data = campi[2];
    				char tipoPosto = campi[3].charAt(0);
    				String nome = campi[4];
    				String cognome = campi[5];
    				String cellulare = campi[6];
    						
    				nuovaPrenotazione(indirizzo, data, tipoPosto, nome, cognome, cellulare);		

    			}
    		}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }    	
	
}





















