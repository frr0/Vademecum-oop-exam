package congressi;
import java.util.*;

public class Organizzazione {

	LinkedList<Centro> listaCentri = new LinkedList<Centro>();
	TreeMap<String,Congresso> mappaCongressi = new TreeMap<String,Congresso>();
	int prossimoNumeroCongresso=1;
	

	
	public Centro definisciCentro(String nome, String indirizzo) {
		boolean trovato=false;
		Centro cTemp = null;
		for(int i=0; i<listaCentri.size();i++) {
			if(listaCentri.get(i).getNome().compareTo(nome)==0)
				trovato = true;
		}
		if(!trovato) {
			
			String id = nome.substring(0,2).toUpperCase()+""+prossimoNumeroCongresso;
			
			cTemp = new Centro(id, nome, indirizzo);
			listaCentri.add(cTemp);
			prossimoNumeroCongresso++;
		}

		return cTemp;
	}




	public Centro cercaCentro(String id) {
		for(int i=0; i<listaCentri.size();i++) {
			if(listaCentri.get(i).getId().compareTo(id)==0)
				return listaCentri.get(i);
		}
		return null;
	}




	public Collection<Centro> elencoCentri() {
		return listaCentri;
	}
	
	public Collection<Centro> elencoCentri(String sottostringa) {

		LinkedList<Centro> listaTemp = new LinkedList<Centro>();
		for(Centro c : listaCentri)
			if(c.getNome().contains(sottostringa) || c.getIndirizzo().contains(sottostringa) )
				listaTemp.add(c);
		
		return listaTemp;
		
	}
	
	public Sala definisciSalaCentro(String idCentro, String nome, int capienza) {
		
		Centro cTemp = this.cercaCentro(idCentro);
		if(cTemp==null)
			return null;
		
		Sala sTemp = new Sala(nome, capienza);
		cTemp.definisciSala(sTemp);
		
		return sTemp;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	



	public Collection<Sala> elencoSaleCentroPerNome(String idCentro) {

		Centro cTemp = this.cercaCentro(idCentro);
		if(cTemp==null)
			return null;

		return cTemp.mappaSale.values();

	}
	
	
	public Collection<Sala> elencoSaleCentroPerCapienza(String idCentro) {

		Centro cTemp = this.cercaCentro(idCentro);
		if(cTemp==null)
			return null;

		LinkedList<Sala> listaTemp = new LinkedList<Sala>(cTemp.mappaSale.values());
		Collections.sort(listaTemp);
		
		return listaTemp;
		
	}
	
	

	
	public Congresso definisciCongresso(String nome, String dataInizio, String dataFine, String idCentro) {
		
		
		Congresso ctemp = mappaCongressi.get(nome);
		
		if(ctemp==null) {
			Centro cTemp = this.cercaCentro(idCentro);
			if(cTemp!=null) {
				ctemp = new Congresso(nome, dataInizio, dataFine, cTemp);
				mappaCongressi.put(nome, ctemp);
			}
		}
		else {
			if(ctemp.getDataInizio().compareTo(dataInizio)==0 && ctemp.getDataFine().compareTo(dataFine)==0 && idCentro.compareTo(idCentro)==0)
			{	
				// Già presente ed identico, non faccio nulla
			}
			else {
				// Aggiorno
				ctemp.setDataInizio(dataInizio);
				ctemp.setDataFine(dataFine);
				ctemp.setCentro(cercaCentro(idCentro));
			}
		}
		
		return ctemp;
	}
	
	public void assegnaSaleCongresso(String nomeCongresso, String nomeSala) {
		Congresso coTemp = mappaCongressi.get(nomeCongresso);
		Centro ceTemp = this.cercaCentro(coTemp.getIdCentro());
		
		
		
		if(ceTemp.mappaSale.containsKey(nomeSala))
			coTemp.mappaSale.put(nomeSala, ceTemp.mappaSale.get(nomeSala));
		
	}
	
	public Collection<Sala> elencoSaleCongresso(String nomeCongresso) {

		Congresso coTemp = mappaCongressi.get(nomeCongresso);
		if(coTemp==null)
			return null;

		return coTemp.mappaSale.values();

	}
	
	public Sessione pianificaSessioneCongresso(String nomeCongresso, String nomeSala, char tipoSessione, String nomeSessione, String data, String daOra, String adOra) throws EccezioneSessioneSovrapposta {
		Congresso cTemp = mappaCongressi.get(nomeCongresso);
		Sala saTemp = cTemp.mappaSale.get(nomeSala);
		Sessione seTemp = null;
		
		if(tipoSessione == 'S') {
			seTemp = new SessioneSingoloOratore(cTemp.prossimoNumeroSessione++, cTemp, saTemp, nomeSessione, data, daOra, adOra);
		}
		else if(tipoSessione == 'M') {
			seTemp = new SessioneOratoriMultipli(cTemp.prossimoNumeroSessione++, cTemp, saTemp, nomeSessione, data, daOra, adOra);
		}
		
		if(seTemp!=null) {
			
			boolean sovrapposte = false;
			for(Sessione s : cTemp.mappaSessioni.values()) {
				if(s.getData().compareTo(data)==0)
					if((adOra.compareTo(s.getDaOra())>=0 && adOra.compareTo(s.getAdOra())<=0) || (daOra.compareTo(s.getDaOra())>=0 && daOra.compareTo(s.getAdOra())<=0) || (daOra.compareTo(s.getDaOra())<=0 && adOra.compareTo(s.getAdOra())>=0)) 
						sovrapposte=true;

			}
			
			if(!sovrapposte) {
				cTemp.mappaSessioni.put(cTemp.prossimoNumeroSessione-1, seTemp);
				return seTemp;
			}
			else
				throw new EccezioneSessioneSovrapposta();

			
			
		}
		
		
		return null;
	}
	
	public void allocaOratoreSessioneCongresso(String nomeCongresso, int numeroSessione, String cognome, String nome) {

		Congresso cTemp = mappaCongressi.get(nomeCongresso);
		Sessione seTemp = cTemp.mappaSessioni.get(numeroSessione);
		if(seTemp instanceof SessioneOratoriMultipli)
			return;
		
		((SessioneSingoloOratore)seTemp).allocaOratore(cognome, nome);
		
		
	}
	
	public void allocaOratoreSessioneCongresso(String nomeCongresso, int numeroSessione, String cognome, String nome, String ora) {
		Congresso cTemp = mappaCongressi.get(nomeCongresso);
		Sessione seTemp = cTemp.mappaSessioni.get(numeroSessione);
		if(seTemp instanceof SessioneSingoloOratore)
			return;
		
		((SessioneOratoriMultipli)seTemp).allocaOratore(cognome, nome, ora);
		
	}
	
	public Collection<String> elencoOratoriSessioneCongresso(String nomeCongresso, int numeroSessione) {
		Congresso cTemp = mappaCongressi.get(nomeCongresso);
		Sessione seTemp = cTemp.mappaSessioni.get(numeroSessione);
		return seTemp.elencoOratori();
	}
	
	public String programmaSessioneCongresso(String nomeCongresso, int numeroSessione) {
		Congresso cTemp = mappaCongressi.get(nomeCongresso);
		Sessione seTemp = cTemp.mappaSessioni.get(numeroSessione);
		String risultato = "";
		
		if(seTemp instanceof SessioneSingoloOratore)
			risultato = " "+seTemp.getDaOra()+" "+((SessioneSingoloOratore)seTemp).nome_cognome;
		else if(seTemp instanceof SessioneOratoriMultipli) {
			for(String key : ((SessioneOratoriMultipli) seTemp).mappa_nomi_cognomi.keySet())
				risultato+=" "+key+" "+((SessioneOratoriMultipli) seTemp).mappa_nomi_cognomi.get(key)+"\n";
		}
		
		return risultato;
		
	}




	public String programmaCongresso(String nomeCongresso) {
		Congresso cTemp = mappaCongressi.get(nomeCongresso);
		LinkedList<Sessione> listaTemp = new LinkedList<Sessione>(cTemp.mappaSessioni.values());
		Collections.sort(listaTemp);
		String risultato="";
		
		for(Sessione s : listaTemp) {
			risultato+=" "+s.getData()+" "+s.getDaOra()+" "+s.getAdOra()+" "+s.getNome()+"\n";
			risultato+=""+this.programmaSessioneCongresso(nomeCongresso, s.getNumero())+"\n";
		}
		

		return risultato;
	}
	
	
	
}
