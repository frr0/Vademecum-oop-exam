package tripjavisor;

import java.util.*;

public class Sistema {
	
	private Map<Integer,Hotel> hotelMap;
	private List<Hotel> hotelList;
	private final int PRIMOCODICEHOTEL = 1;
	private Map<String,Utente> utentiMap;
	private List<Utente> utentiList;
	private Map<Integer,Recensione> recensMap;
	private List<Recensione> recensList;
	private final int PRIMOCODICERECENSIONE = 100;
	
	
	public Sistema() {
		super();
		hotelMap = new TreeMap<Integer,Hotel>();
		hotelList = new LinkedList<Hotel>();
		utentiMap = new TreeMap<String,Utente>();
		utentiList = new LinkedList<Utente>();
		recensMap = new TreeMap<Integer,Recensione>();
		recensList = new LinkedList<Recensione>();
	}

	public Hotel aggiungiHotel(String nome, String indirizzo, String citta, int numCamere) throws HotelGiaPresenteException{
		for(Hotel ht : hotelList)
			if((ht.getNome().compareTo(nome)==0) && (ht.getIndirizzo().compareTo(indirizzo)==0) && (ht.getCitta().compareTo(citta)==0))
				throw new HotelGiaPresenteException();
		
		Hotel h = new Hotel(PRIMOCODICEHOTEL+hotelList.size(), nome, indirizzo, citta, numCamere);
		hotelMap.put(PRIMOCODICEHOTEL+hotelList.size(), h);
		hotelList.add(h);
		return h;
	}

	public Hotel aggiungiHotelPremium(String nome, String indirizzo, String citta, int numCamere, String numeroTelefono, String sitoInternet, String email) 
			throws HotelGiaPresenteException{
		for(Hotel ht : hotelList)
			if((ht.getNome().compareTo(nome)==0) && (ht.getIndirizzo().compareTo(indirizzo)==0) && (ht.getCitta().compareTo(citta)==0))
				throw new HotelGiaPresenteException();
		
		Hotel h = new HotelPremium(PRIMOCODICEHOTEL+hotelList.size(), nome, indirizzo, citta, numCamere, numeroTelefono, sitoInternet, email);
		hotelMap.put(PRIMOCODICEHOTEL+hotelList.size(), h);
		hotelList.add(h);
		return h;
	}
	
	public Hotel cercaHotel(int codice){
		if(hotelMap.keySet().contains(codice))
			return hotelMap.get(codice);
		return null;
	}

	public Collection<Hotel> elencoHotelInOrdineDiInserimento(){
		return hotelList;
	}
	
	public Utente aggiungiUtente(String username){
		if(utentiMap.keySet().contains(username))
			return utentiMap.get(username);
		Utente u = new Utente(username);
		utentiMap.put(username, u);
		utentiList.add(u);
		return u;
	}
	
	public Collection<Utente> elencoUtentiInOrdineAlfabetico(){
		return utentiMap.values();
	}
	
	public Utente cercaUtente(String username){
		if(utentiMap.keySet().contains(username))
			return utentiMap.get(username);
		return null;
	}
	
	public Recensione aggiungiRecensione(String data, String titolo, String testo, double voto, String username, int codiceHotel){
		for(Recensione r : recensList){
			if((r.getUtente().getUsername().compareTo(username)==0) && (r.getHotel().getCodice()==codiceHotel) && (r.getData().compareTo(data)==0)){
				int codice=r.getCodice();
				double votoVecchio=r.getVoto();
				recensList.remove(r);
				Recensione rc = new Recensione(codice, data, titolo, testo, voto, utentiMap.get(username), hotelMap.get(codiceHotel));
				recensMap.put(codice, rc);
				recensList.add(rc);
				hotelMap.get(codiceHotel).aggiornaVoto(votoVecchio, voto);
				return rc;
			}
		}
		Recensione r = new Recensione(PRIMOCODICERECENSIONE+recensList.size(), data, titolo, testo, voto, utentiMap.get(username), hotelMap.get(codiceHotel));
		recensMap.put(PRIMOCODICERECENSIONE+recensList.size(), r);
		recensList.add(r);
		hotelMap.get(codiceHotel).aggiungiVoto(voto);
		return r;
	}

	public Recensione cercaRecensione(String stringa){
		for(Recensione r : recensList){
			if((r.getTitolo().contains(stringa)) || (r.getTesto().contains(stringa)))
				return r;
		}
		return null;
	}

	public int calcolaNumeroRecensioniGiornaliero(String data){
		int numRec=0;
		for(Recensione r : recensList){
			if(r.getData().compareTo(data)==0)
				numRec++;
		}
		return numRec;
	}
	
	public int calcolaNumeroRecensioniUtente(String username){
		int numRec=0;
		for(Recensione r : recensList){
			if(r.getUtente().getUsername().compareTo(username)==0)
				numRec++;
		}
		return numRec;
	}

	public double calcolaMediaVotiRecensioniHotel(int codiceHotel){
		double media = 0.0;
		if(hotelMap.keySet().contains(codiceHotel)){
			media = hotelMap.get(codiceHotel).mediaVoti();
		}
		return media;
	}
	
	public Collection<Hotel> elencoHotelCittaPerMediaVotiRecensioniDecrescenti(String citta){
		List<Hotel> hotemp = new LinkedList<Hotel>();
		for(Hotel h : hotelList){
			if(h.getCitta().compareTo(citta)==0)
				hotemp.add(h);
		}
		Collections.sort(hotemp);
		return hotemp;
	}
	
	public Collection<Hotel> elencoHotelPerMediaVotiRecensioniDecrescenti(){
		Collections.sort(hotelList);
		return hotelList;
	}
	
	public void miPiaceARecensione(int codiceRecensione, String username){
		recensMap.get(codiceRecensione).addReazione(utentiMap.get(username), true);
	}
	
	public void nonMiPiaceARecensione(int codiceRecensione, String username){
		recensMap.get(codiceRecensione).addReazione(utentiMap.get(username), false);
	}
	
	public int calcolaPunteggioUtente(String username){
		return utentiMap.get(username).getPunteggio();
	}

	public Collection<Utente> elencoUtentiPerPunteggioDecrescente(){
		Collections.sort(utentiList);
		return utentiList;
	}
}
