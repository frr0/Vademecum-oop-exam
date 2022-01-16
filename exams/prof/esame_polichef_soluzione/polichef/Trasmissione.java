package polichef;

import java.util.*;
import java.io.*;

public class Trasmissione {

	int numeroPiatto=100;
	TreeMap<String, Concorrente> mappaConcorrenti = new TreeMap<String, Concorrente>();
	LinkedList<Concorrente> listaConcorrenti = new LinkedList<Concorrente>();
	TreeMap<Integer, Piatto> mappaPiatti = new TreeMap<Integer, Piatto>();

	TreeMap<Integer,Fase> mappaFasi = new TreeMap<Integer,Fase>();
	
	
	public Concorrente iscriviConcorrente(String nome, String cognome, String professione) {
		Concorrente ctemp = new Concorrente(nome, cognome, professione);
		if(!mappaConcorrenti.containsKey(ctemp.getId())) {
			mappaConcorrenti.put(ctemp.getId(), ctemp);
			listaConcorrenti.add(ctemp);
			return ctemp;
		}
		return null;
	}

	public Concorrente cercaConcorrente(String idConcorrente) {
		Concorrente ctemp = mappaConcorrenti.get(idConcorrente);
		return ctemp;
	}

	public Collection<Concorrente> elencoConcorrenti() {
		LinkedList<Concorrente> ltemp = new LinkedList<Concorrente>(mappaConcorrenti.values());
		return ltemp;
	}

	public Collection<Concorrente> elencoConcorrenti(String professione) {
		LinkedList<Concorrente> ltemp = new LinkedList<Concorrente>();

		for(Concorrente ctemp : listaConcorrenti)
			if(ctemp.getProfessione().compareTo(professione)==0)
				ltemp.add(ctemp);
		
		return ltemp;
	}

	public int registraPiattoConcorrente(String nomePiatto, String idConcorrente) {
		Concorrente ctemp = cercaConcorrente(idConcorrente);
		if(ctemp==null)
			return -1;
		
		Piatto ptemp = new Piatto(numeroPiatto, nomePiatto, ctemp);
		mappaPiatti.put(numeroPiatto, ptemp);
		numeroPiatto++;
		return numeroPiatto-1;
	}
	
	public Piatto cercaPiatto(int idPiatto) {
		return mappaPiatti.get(idPiatto);
	}
	
	public void aggiungiIngredientePiatto(int idPiatto, String ingrediente) throws EccezioneIngredienteDuplicato {
		Piatto ptemp = cercaPiatto(idPiatto);
		if(ptemp==null)
			return;
		String risultato = ptemp.aggiungiIngredientePiatto(ingrediente);
		if(risultato==null)
			throw new EccezioneIngredienteDuplicato();
	}
	
	public Collection<Piatto> elencoPiattiPerNome() {
		LinkedList<Piatto> listaPiatti = new LinkedList<Piatto>(mappaPiatti.values());
		Collections.sort(listaPiatti, new ComparatoreDiPiattiPerNome());
		return listaPiatti;
	}
	
	public Collection<Piatto> elencoPiattiPerNumeroIngredienti() {
		LinkedList<Piatto> listaPiatti = new LinkedList<Piatto>(mappaPiatti.values());
		Collections.sort(listaPiatti, new ComparatoreDiPiattiPerNumeroIngredienti());
		return listaPiatti;
	}
	

	public Fase definisciFase(int numero, String nome, int numeroMassimoConcorrenti) {
		Fase ftemp = new Fase(numero, nome, numeroMassimoConcorrenti);
		if(!mappaFasi.containsKey(numero)) {
			mappaFasi.put(numero, ftemp);
			return ftemp;
		}
		else
			return null;
	}
	
	public void assegnaConcorrenteFase(int numeroFase, String idConcorrente) {
		Concorrente ctemp = cercaConcorrente(idConcorrente);
		Fase ftemp = mappaFasi.get(numeroFase);
		if(ctemp==null || ftemp==null)
			return; 
		else {
			if(ftemp.getMappaConcorrentiFase().size()<ftemp.getNumeroMassimoConcorrenti())
				ftemp.aggiungiConcorrenteFase(ctemp);
		}			
	}
	
	public void definisciSfidaFase(int numeroFase, String idConcorrente1, int idPiatto1, String idConcorrente2, int idPiatto2, String esito) {
		Concorrente ctemp1 = cercaConcorrente(idConcorrente1);
		Concorrente ctemp2 = cercaConcorrente(idConcorrente2);
		Piatto ptemp1 = cercaPiatto(idPiatto1);
		Piatto ptemp2 = cercaPiatto(idPiatto2);
		Fase ftemp = mappaFasi.get(numeroFase);
		if(ctemp1==null || ptemp1==null || ctemp2==null || ptemp2==null)
			return;
		else
			ftemp.definisciSfidaFase(ctemp1, ptemp1, ctemp2,ptemp2, esito);
	}
	
	public String descriviSfideFase(int numeroFase) {
		Fase ftemp = mappaFasi.get(numeroFase);
		if(ftemp!=null)	
			return ftemp.descrizioneSfideFase();
		else 
			return "";
	}

	public String descriviSfide() {

		String risultato = "";
		for(Fase ftemp : mappaFasi.values()) {
			risultato+=ftemp.descrizioneSfideFase();
		}
		return risultato;
	}

	public String determinaVincitoreSfida(String idConcorrente1, String idConcorrente2) {
		for(Fase ftemp : mappaFasi.values())
			for(Sfida stemp : ftemp.getListaSfide())
				if((stemp.concorrente1.getId().compareTo(idConcorrente1)==0 && stemp.concorrente2.getId().compareTo(idConcorrente2)==0) ||
				   (stemp.concorrente1.getId().compareTo(idConcorrente2)==0 && stemp.concorrente2.getId().compareTo(idConcorrente1)==0))	
				{
					String[] esito = stemp.esito.split("-");
					if(Integer.parseInt(esito[0])>Integer.parseInt(esito[1]))
						return stemp.concorrente1.getId();
					else
						return stemp.concorrente2.getId();
				}
		return null;
	}

	public void leggiDaFile(String nomeFile) {
		
		FileReader r;
		BufferedReader br;
		
		try {
			r = new FileReader(nomeFile);
			br = new BufferedReader(r);
		
			String riga;
			while((riga = br.readLine())!=null) {

				String campi[] = riga.split(";");
				if(campi[0].compareTo("C")==0) {
					this.iscriviConcorrente(campi[1], campi[2], campi[3]);
				}
				else if(campi[0].compareTo("P")==0) {
					this.registraPiattoConcorrente(campi[1], campi[2]);
				}
			}
			
			br.close();
			r.close();
		
		} catch (Exception e) {
			//e.printStackTrace();
		}

		
	}
	
}








