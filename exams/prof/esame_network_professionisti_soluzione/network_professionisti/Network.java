package network_professionisti;

import java.util.*;

public class Network {

	LinkedList<Iscritto> listaIscritti = new LinkedList<Iscritto>();
	TreeMap<String, Iscritto> mappaIscritti = new TreeMap<String, Iscritto>();
	
	TreeMap<String, Entita> mappaEntita = new TreeMap<String, Entita>();
	TreeMap<String, Azienda> mappaAziende = new TreeMap<String, Azienda>();
	TreeMap<String, CentroDiFormazione> mappaEntiFormazione = new TreeMap<String, CentroDiFormazione>();
	
	
	public Iscritto nuovoIscritto(String nome, String cognome, String web, String email, String descrizione) {
		
		int num = 0;
		String id="";

		for(Iscritto i : listaIscritti)
			if(i.getNome().compareTo(nome)==0 && i.getCognome().compareTo(cognome)==0)
				num++;

		if(num==0)
			id=nome+"-"+cognome;
		else
			id=nome+"-"+cognome+"-"+num;
		
		Iscritto itemp = new Iscritto(id, nome, cognome, web, email, descrizione);
		
		mappaIscritti.put(id, itemp);
		listaIscritti.add(itemp);
		
		return itemp;
	}

	
	public Iscritto cercaIscrittoPerId(String id) {
		return(mappaIscritti.get(id));
	}
	
	public Iscritto cercaIscrittoPerNomeCognome(String nome, String cognome) {
		
		LinkedList<Iscritto> lista = new LinkedList<Iscritto>(mappaIscritti.values());
		for(Iscritto i : lista)
			if(i.getNome().contains(nome) && i.getCognome().contains(cognome))
				return(i);
		return null;
	}

	public Collection<Iscritto> elencoIscritti() {
		
		return mappaIscritti.values();
	}
	
	
	
	
	
	public Entita nuovaEntita(String nome, String nazione, String indirizzo) throws EccezioneEntitaGiaDefinita {
		
		CentroDiFormazione etemp = new CentroDiFormazione(nome, nazione, indirizzo);

		if(mappaEntita.containsKey(nome+"E"))
			throw new EccezioneEntitaGiaDefinita();
		
		mappaEntita.put(nome+"E", etemp); // Per far comparire gli enti di formazione dopo le aziende nell'elenco di entita'
		mappaEntiFormazione.put(nome, etemp);

		return etemp;

	}

	public Entita nuovaEntita(String nome, String nazione, String indirizzo, String settore, int numeroDipendenti) throws EccezioneEntitaGiaDefinita {
		
		Azienda etemp = new Azienda(nome, nazione, indirizzo, settore, numeroDipendenti);
		
		if(mappaEntita.containsKey(nome+"A"))
			throw new EccezioneEntitaGiaDefinita();

		
		mappaEntita.put(nome+"A", etemp); // Per far comparire prima le aziende nell'elenco di entita'
		mappaAziende.put(nome, etemp);
		
		return etemp;
	}
	
	
	
	
	
	public Collection<Azienda> elencoAziendePerNome(){
		
		LinkedList<Azienda> lista = new LinkedList<Azienda>();
		for(Entita e : mappaAziende.values())
			lista.add((Azienda)e);
		return lista;
	}			

	public Collection<Azienda> elencoAziendePerNumeroDipendenti(){
		
		LinkedList<Azienda> lista = new LinkedList<Azienda>();
		for(Entita e : mappaAziende.values())
			lista.add((Azienda)e);

		Collections.sort(lista);

		return lista;
	}			
	
	

	
	public Collection<CentroDiFormazione> elencoCentriDiFormazionePerNome(){
		
		LinkedList<CentroDiFormazione> lista = new LinkedList<CentroDiFormazione>();
		for(Entita e : mappaEntiFormazione.values())
			lista.add((CentroDiFormazione)e);
		return lista;
	}			
	

	public Collection<CentroDiFormazione> elencoCentriDiFormazioneInNazionePerNome(String nazione){
		
		LinkedList<CentroDiFormazione> lista = new LinkedList<CentroDiFormazione>();
		for(Entita e : mappaEntiFormazione.values())
			if(e.getNazione().compareTo(nazione)==0)
				lista.add((CentroDiFormazione)e);
		return lista;
	}			

	public Collection<Entita> elencoEntita(){
		return mappaEntita.values();
	}			


	
	public void nuovoPeriodoDiFormazione(String idIscritto, String nomeCentroFormazione,String da, String a, String titolo) {
		Iscritto itemp = mappaIscritti.get(idIscritto);
		CentroDiFormazione etemp = mappaEntiFormazione.get(nomeCentroFormazione);
		
		itemp.nuovoPeriodoDiFormazione(etemp, da, a, titolo);
	}


	public String titoliFormazioneDateCrescenti(String idIscritto) {
		Iscritto itemp = mappaIscritti.get(idIscritto);

		Collections.sort(itemp.listaPeriodiDiFormazione, new ComparatoreDiPeriodiPerDataCrescente());
		
		String risultato="";
		
		for(Periodo p : itemp.listaPeriodiDiFormazione) {
			if(risultato.compareTo("")!=0)
				risultato+="\n";
			risultato+=" "+p.entita.getNome()+";"+p.da+";"+p.a+";"+p.ruolo_titolo;
		}

		return risultato;
		
	}
	
	public String titoliFormazioneDateDecrescenti(String idIscritto) {
		Iscritto itemp = mappaIscritti.get(idIscritto);

		Collections.sort(itemp.listaPeriodiDiFormazione, new ComparatoreDiPeriodiPerDataDecrescente());
		
		String risultato="";
		
		for(Periodo p : itemp.listaPeriodiDiFormazione) {
			if(risultato.compareTo("")!=0)
				risultato+="\n";
			risultato+=" "+p.entita.getNome()+";"+p.da+";"+p.a+";"+p.ruolo_titolo;
		}

		return risultato;
		
	}

	public void nuovoPeriodoInAzienda(String idIscritto, String nomeAzienda,String da, String a, String ruolo) {
		Iscritto itemp = mappaIscritti.get(idIscritto);
		Azienda etemp = mappaAziende.get(nomeAzienda);
		
		itemp.nuovoPeriodoInAzienda(etemp, da, a, ruolo);
	}
	
	
	public String ruoliAziendaDateCrescenti(String idIscritto) {
		Iscritto itemp = mappaIscritti.get(idIscritto);

		Collections.sort(itemp.listaPeriodiInAzienda, new ComparatoreDiPeriodiPerDataCrescente());
		
		String risultato="";
		
		for(Periodo p : itemp.listaPeriodiInAzienda) {
			if(risultato.compareTo("")!=0)
				risultato+="\n";
			risultato+=" "+p.entita.getNome()+";"+p.da+";"+p.a+";"+p.ruolo_titolo;
		}

		return risultato;
		
	}
	
	public String ruoliAziendaDateDecrescenti(String idIscritto) {
		Iscritto itemp = mappaIscritti.get(idIscritto);

		Collections.sort(itemp.listaPeriodiInAzienda, new ComparatoreDiPeriodiPerDataDecrescente());
		
		String risultato="";
		
		for(Periodo p : itemp.listaPeriodiInAzienda) {
			if(risultato.compareTo("")!=0)
				risultato+="\n";
			risultato+=" "+p.entita.getNome()+";"+p.da+";"+p.a+";"+p.ruolo_titolo;
		}

		return risultato;
		
	}
	
	
	public void nuovaConnessione(String idIscritto1, String idIscritto2) {
		Iscritto itemp1 = mappaIscritti.get(idIscritto1);
		Iscritto itemp2 = mappaIscritti.get(idIscritto2);
		
		itemp1.nuovaConnessione(itemp2);
		itemp2.nuovaConnessione(itemp1);
		
	}
	
	public Collection<Iscritto> elencoConnessioni(String idIscritto){
		
		Iscritto itemp = mappaIscritti.get(idIscritto);
		return itemp.mappaConnessioni.values();
	}
	
	public Collection<Iscritto> elencoConnessioniSuggerite(String idIscritto){

		TreeMap<String, Iscritto> mappa = new TreeMap<String, Iscritto>();

		Iscritto itemp = mappaIscritti.get(idIscritto);

		
		for(Iscritto i1 : itemp.mappaConnessioni.values())
			for(Iscritto i2 : i1.mappaConnessioni.values())
				if(!itemp.mappaConnessioni.containsKey(i2.getId()) && i2.getId().compareTo(idIscritto)!=0)
					mappa.put(i2.getId(), i2);
			
		return mappa.values();
	}
	
}

