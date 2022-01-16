package agenzia_immobiliare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Agenzia {

	TreeMap<String, SchedaImmobile> mappaSchedeImmobile = new TreeMap<String, SchedaImmobile>();
	LinkedList<SchedaImmobile> listaSchedeImmobile = new LinkedList<SchedaImmobile>();
			
	boolean criterioLocaliImpostato = false;
	boolean criterioSuperficieImpostato = false;
	int localiMin = 0;
	int localiMax = 0;
	int superficieMin = 0; 
	int superficieMax = 0;
	
	TreeMap<String, Cliente> mappaClienti = new TreeMap<String, Cliente>();
	
	TreeMap<Integer, Transazione> mappaTransazioni = new TreeMap<Integer, Transazione>();
	LinkedList<Transazione> listaTransazioni = new LinkedList<Transazione>();
	
	int numTransazione = 100;
	
	public SchedaImmobile creaScheda(String comune, String indirizzo, String tipologia, int locali, int superficie, String descrizione) {

		for(int i=0;i<listaSchedeImmobile.size();i++) {
			SchedaImmobile s = listaSchedeImmobile.get(i);
			if(s.getComune().compareTo(comune)==0 && s.getIndirizzo().compareTo(indirizzo)==0 && s.getTipologia().compareTo(tipologia)==0)
					return s;
		}
		
		// Se sono qui, significa che un immobile con quelle caratteristiche non c'era
		// e quindi devo aggiungerlo, creandone uno nuovo (SchedImmobile)
		
		String idSchedaImmobile = "";

		int contaComune = 1;
		for(SchedaImmobile s : listaSchedeImmobile)
			if(s.getComune().compareTo(comune)==0)
				contaComune++;
	
		idSchedaImmobile = comune.toUpperCase() + ""+contaComune;
		
		//System.out.println(idSchedaImmobile);
		
		SchedaImmobile sTemp = new SchedaImmobile(idSchedaImmobile, comune, indirizzo, tipologia, locali, superficie, descrizione);

		mappaSchedeImmobile.put(idSchedaImmobile, sTemp);
		listaSchedeImmobile.add(sTemp);
		
		return sTemp;
	
	}
	
	public SchedaImmobile ottieniScheda(String idSchedaImmobile) {
		return mappaSchedeImmobile.get(idSchedaImmobile);
	}

	public void aggiornaScheda(String idSchedaImmobile, int superficie, String descrizione) {
	
		if(mappaSchedeImmobile.containsKey(idSchedaImmobile)) { // Richiesto dai requisiti
			mappaSchedeImmobile.get(idSchedaImmobile).setSuperficie(superficie);
			mappaSchedeImmobile.get(idSchedaImmobile).setDescrizione(descrizione);
		}
	}

	public Collection<SchedaImmobile> elencoSchedeOrdineDiInserimento(){
		return listaSchedeImmobile; // Se ho solo la lista, devo scandirla tutta con for/for each
	}
	
	public Collection<SchedaImmobile> elencoSchedeOrdineDiIdentificativo(){
		return mappaSchedeImmobile.values();
	}
	
	public Collection<SchedaImmobile> ricercaSchedeTesto(String daCercare){
		
		TreeMap<String, SchedaImmobile> mappaRicerca = new TreeMap<String, SchedaImmobile>();

		for(SchedaImmobile s : listaSchedeImmobile) {
			if(s.getComune().contains(daCercare) || s.getIndirizzo().contains(daCercare) || s.getDescrizione().contains(daCercare))
				mappaRicerca.put(s.getIdSchedaImmobile(), s);
		}
		
		return mappaRicerca.values();
	}
	
	public void impostaCriterio(char criterio, boolean impostato, int min, int max){
	
		if(criterio=='L') {
			criterioLocaliImpostato = impostato;
			localiMin = min;
			localiMax = max;
		}
		else if(criterio=='S') {
			criterioSuperficieImpostato = impostato;
			superficieMin = min;
			superficieMax = max;
		}
		
	}
	
	public Collection<SchedaImmobile> ricercaSchedeCriteri(){
		
		TreeMap<String, SchedaImmobile> mappaRicerca = new TreeMap<String, SchedaImmobile>();
		
		for(SchedaImmobile s : listaSchedeImmobile) {
			
			boolean daScartare = false;
			if(criterioLocaliImpostato && (s.getLocali()<localiMin || s.getLocali()>localiMax) )
				daScartare= true;
			
			if(criterioSuperficieImpostato == true && (s.getSuperficie()<superficieMin || s.getSuperficie()>superficieMax))
				daScartare = true;
			
			if(!daScartare)
				mappaRicerca.put(s.getIdSchedaImmobile(), s);
		}
		
		return mappaRicerca.values();
	}
	
	public Cliente nuovoCliente(String codiceFiscale, String cognome, String nome) {
		
		Cliente cTemp = new Cliente(codiceFiscale, cognome, nome);
		mappaClienti.put(codiceFiscale, cTemp);
		return cTemp;
		
	}
	
	public Collection<Cliente> elencoClientiOrdineDiCodiceFiscale(){
		
		return mappaClienti.values();
	
	}
	
	public int nuovaTransazioneDiVendita(String idSchedaImmobile, String codiceFiscaleVenditore, String codiceFiscaleAcquirente, double importo) throws EccezioneVenditaNonFinalizzabile {
		
		SchedaImmobile s = mappaSchedeImmobile.get(idSchedaImmobile);
		Cliente c1 = mappaClienti.get(codiceFiscaleVenditore);
		Cliente c2 = mappaClienti.get(codiceFiscaleAcquirente);
		
		if(s==null || c1 == null || c2 == null)
			throw new EccezioneVenditaNonFinalizzabile();
		
		// Se siamo qui possiamo creare la transazione
		
		Venditore v = new Venditore(c1.getCodiceFiscale(),c1.getCognome(), c1.getNome());
		Acquirente a = new Acquirente(c2.getCodiceFiscale(), c2.getCognome(), c2.getNome());
		
		Transazione tTemp = new Transazione(numTransazione, s, v, a, importo);
		
		mappaTransazioni.put(numTransazione, tTemp);
		listaTransazioni.add(tTemp);
		
		return numTransazione++;
	}
	
	
	public SchedaImmobile schedaImmobileTransazione(int idTransazione) {
		return mappaTransazioni.get(idTransazione).getSchedaImmobile();
	}
	
	public Venditore venditoreTransazione(int idTransazione) {
		return mappaTransazioni.get(idTransazione).getVenditore();
		
	}
	
	public Acquirente acquirenteTransazione(int idTransazione) {
		return mappaTransazioni.get(idTransazione).getAcquirente();
	}
	
	public double importoTransazione(int idTransazione) {
		return mappaTransazioni.get(idTransazione).getImporto();
	}

	public String stampaTransazioniOrdineDiImportoIdScheda() {

		String risultato="";
		Collections.sort(listaTransazioni);
		
		for(Transazione s : listaTransazioni) {
			if(risultato=="")
				risultato+=s;
			else
				risultato+="\n"+s;
		}
		
		return risultato;
	}
	
	public double calcolaIntroiti(double percentuale) {
		
		double totaleIntroiti = 0;
		
		for(Transazione t : listaTransazioni) {
			
			Cliente v = mappaClienti.get(t.getVenditore().getCodiceFiscale());
			Cliente a = mappaClienti.get(t.getAcquirente().getCodiceFiscale());
			
			if(v.piuDiUnaTransazione || a.piuDiUnaTransazione) {
				// Ridotta
				totaleIntroiti += t.getImporto()*percentuale/100.0*2.0/2.0; // Dimezzata
			}
			else
			{
				totaleIntroiti += t.getImporto()*percentuale/100.0*2.0;
			}
		
			v.piuDiUnaTransazione=true;
			a.piuDiUnaTransazione=true;
		
		}
		
		return totaleIntroiti;
	}
	
	public void leggiDaFile(String nomeFile) {
		
		try {
			
			FileReader fr = new FileReader(nomeFile);
			BufferedReader br = new BufferedReader(fr);
			
			String riga;
			while( (riga = br.readLine())!= null ) {
				
				// Qui ho una riga
				String[] array = riga.split(";");
				
				if(array[0].compareTo("I")==0) {

					// Immobile
					
					String comune = array[1];
					String indirizzo = array[2];
					String tipologia = array[3];
					int locali = Integer.parseInt(array[4]);// array[4];
					int superficie = Integer.parseInt(array[5]);// array[5];
					String descrizione = array[6];
					
					this.creaScheda(comune, indirizzo, tipologia, locali, superficie, descrizione);
					
					
				}else if(array[0].compareTo("C")==0) {
					
					String codiceFiscale = array[1];
					String cognome = array[2];
					String nome = array[3];
					
					this.nuovoCliente(codiceFiscale, cognome, nome);
					
				}if(array[0].compareTo("T")==0) {
					
					String idSchedaImmobile = array[1];
					String codiceFiscaleVenditore = array[2];
					String codiceFiscaleAcquirente = array[3];
					double importo = Double.parseDouble(array[4]);
					
					this.nuovaTransazioneDiVendita(idSchedaImmobile, codiceFiscaleVenditore, codiceFiscaleAcquirente, importo);
				}
			}
			
			br.close();
			fr.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
