package multisala;

import java.util.*;

public class Multisala {

	int prossimoCodiceSala=1;
	Map<Integer,Sala> sale = new TreeMap<Integer,Sala>();
	List<Film> film = new LinkedList<Film>();
	Map<String,Proiezione> proiezioni = new TreeMap<String,Proiezione>();
	
	public int nuovaSala(int numeroFile, int numeroPostiPerFila){
		
		if(prossimoCodiceSala<11){
			Sala tempSala = new Sala(prossimoCodiceSala,numeroFile,numeroPostiPerFila);
			sale.put(prossimoCodiceSala, tempSala);
			prossimoCodiceSala++;
			return prossimoCodiceSala-1;
		}
		else
			return -1;
	}

	public Sala cercaSala(int codiceSala){
		if(sale.containsKey(codiceSala))
			return sale.get(codiceSala);
		else
			return null;
	}
	
	public Collection<Sala> elencoSalePerCodice(){
		return sale.values();
	}

	public Collection<Sala> elencoSalePerNumeroDiPosti(){
		List<Sala> tempList = new LinkedList<Sala>(sale.values());
		Collections.sort(tempList);
		return tempList;
	}
	
	public Film nuovoFilm(String titolo, String regista, int anno, int durata){
		for(Film tempFilm:film)
			if( (tempFilm.getTitolo().compareTo(titolo)==0) && (tempFilm.getRegista().compareTo(regista)==0))
				return tempFilm;
		Film tempFilm = new Film(titolo, regista, anno, durata);
		film.add(tempFilm);
		return tempFilm;
	}
	
	public Collection<Film> elencoFilm(){
		return film;
	}

	public Proiezione nuovaProiezione(int codiceSala, Film film, String data, String ora, double prezzoIntero, boolean in3D){
		Sala tempSala = cercaSala(codiceSala);
		if(tempSala==null)
			return null;
		if(film==null)
			return null;
		Proiezione tempProiezione = new Proiezione(tempSala, film, data, ora, prezzoIntero, in3D);
		proiezioni.put(""+codiceSala+""+data+""+ora, tempProiezione);
		tempSala.addProiezione(tempProiezione);
		return tempProiezione;
	}
	
	public Collection<Proiezione> elencoProiezioni(){
		return proiezioni.values();
	}
	
	public Collection<Proiezione> elencoProiezioniInData(String data){

		List<Proiezione> tempList = new LinkedList<Proiezione>();
		for(Proiezione tempProiezione : proiezioni.values())
			if(tempProiezione.getData().compareTo(data)==0)
				tempList.add(tempProiezione);
		return tempList;
	}
	
	public Collection<Proiezione> cercaProiezioni(String daCercare){
		List<Proiezione> tempList = new LinkedList<Proiezione>();
		for(Proiezione tempProiezione : proiezioni.values()){
			Film tempFilm = tempProiezione.getFilm();
			if( tempProiezione.getData().contains(daCercare) || tempProiezione.getOra().contains(daCercare) || tempFilm.getTitolo().contains(daCercare) || tempFilm.getRegista().contains(daCercare) || (new Integer(tempFilm.getAnno())).toString().contains(daCercare) || (new Integer(tempFilm.getDurata())).toString().contains(daCercare) )
				tempList.add(tempProiezione);
		}
		return tempList;
	}
	
	public Biglietto acquistaBiglietto(Proiezione proiezione, int fila, int posto) throws EccezionePostoOccupato, EccezioneProiezioneCompleta{
		if(proiezione.postiLiberi()==0)
			throw new EccezioneProiezioneCompleta();
		if(proiezione.getBiglietto(fila-1, posto-1)!=null)
			throw new EccezionePostoOccupato();
		String codiceBiglietto = ""+proiezione.getSala().getCodiceSala()+"-"+proiezione.getData()+"-"+proiezione.getOra()+"-"+(proiezione.getSala().getNumeroFile()*proiezione.getSala().getNumeroPostiPerFila()-proiezione.postiLiberi());
		Biglietto tempBiglietto = new Biglietto(codiceBiglietto, proiezione, fila, posto);
		proiezione.setBiglietto(fila-1, posto-1, tempBiglietto);
		return tempBiglietto;
	}
	
	public BigliettoScontato acquistaBigliettoScontato(Proiezione proiezione, int fila, int posto, int percentualeSconto, String tipologiaSconto) throws EccezionePostoOccupato, EccezioneProiezioneCompleta{
		if(proiezione.postiLiberi()==0)
			throw new EccezioneProiezioneCompleta();
		if(proiezione.getBiglietto(fila-1, posto-1)!=null)
			throw new EccezionePostoOccupato();
		String codiceBiglietto = ""+proiezione.getSala().getCodiceSala()+"-"+proiezione.getData()+"-"+proiezione.getOra()+"-"+(proiezione.getSala().getNumeroFile()*proiezione.getSala().getNumeroPostiPerFila()-proiezione.postiLiberi());
		BigliettoScontato tempBigliettoScontato = new BigliettoScontato(codiceBiglietto, proiezione, fila, posto);
		proiezione.setBiglietto(fila-1, posto-1, tempBigliettoScontato);
		tempBigliettoScontato.setPercentualeSconto(percentualeSconto);
		tempBigliettoScontato.setTipologiaSconto(tipologiaSconto);
		return tempBigliettoScontato;
	}
	
	public Biglietto cercaBiglietto(Proiezione proiezione, int fila, int posto){
		return proiezione.getBiglietto(fila-1, posto-1);
	}
	
	public Collection<Biglietto> acquistaBiglietti(Proiezione proiezione, int numBiglietti) throws EccezionePostiAdiacentiNonDisponibili, EccezioneProiezioneCompleta{
		boolean acquistati = false;
		List<Biglietto> biglietti = null; 
		if(proiezione.postiLiberi()<numBiglietti)
			throw new EccezioneProiezioneCompleta();
		for(int f=0; f<proiezione.getSala().getNumeroFile() && !acquistati; f++)
			for(int p=0; p<proiezione.getSala().getNumeroPostiPerFila() && !acquistati; p++)
			{
				boolean liberi = true;
				if(p+numBiglietti<=proiezione.getSala().getNumeroPostiPerFila()){
					for(int i=0;i<numBiglietti && !acquistati;i++)
						if(proiezione.getBiglietto(f, p+i)!=null)
							liberi=false;
				}
				else
					liberi=false;
				if(liberi==true){		
					biglietti = new LinkedList<Biglietto>();
					for(int i=0;i<numBiglietti;i++){
						int fila = f;
						int posto = p + i;
						String codiceBiglietto = ""+proiezione.getSala().getCodiceSala()+"-"+proiezione.getData()+"-"+proiezione.getOra()+"-"+(proiezione.getSala().getNumeroFile()*proiezione.getSala().getNumeroPostiPerFila()-proiezione.postiLiberi());
						Biglietto tempBiglietto = new Biglietto(codiceBiglietto, proiezione, fila, posto);
                    	proiezione.setBiglietto(fila, posto, tempBiglietto);
                    	biglietti.add(tempBiglietto);
                    	acquistati=true;
					}
				}
			}
		if(!acquistati)
        	throw new EccezionePostiAdiacentiNonDisponibili();
		return biglietti;
	}

	public double calcolaIncassoInData(String data){
		double incasso=0;
		for(Proiezione tempProiezione : proiezioni.values()){
			if(tempProiezione.getData().compareTo(data)==0)
				incasso += tempProiezione.calcolaIncassoInData();
		}
		return incasso;
	}
}



