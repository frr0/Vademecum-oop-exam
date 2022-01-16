package aziendaagricola;

import java.util.*;

public class Zona{
	private int codice;
	private int ampiezza;
	private int temperaturaMedia;
	private float irraggiamentoMedio;
	private ArrayList<String> caratteristiche;
	private ArrayList<Coltivazione> coltivazioni;
	private ArrayList<Raccolto> raccolti;

	public Zona(int codice) {
		this.codice = codice;
		this.caratteristiche = new ArrayList<String>();
		this.coltivazioni = new ArrayList<Coltivazione>();
		this.raccolti = new ArrayList<Raccolto>();
	}
	public int getCodice() {
		
		return this.codice;
	}
	
	public int getAmpiezza() {
		
		return this.ampiezza;
	}

	public int getTemperaturaMedia() {
		
		return this.temperaturaMedia;
	}

	public float getIrraggiamentoMedio() {
		
		return this.irraggiamentoMedio;
	}
	
	public void setAmpiezza(int ampiezza) {
		this.ampiezza = ampiezza;
	}

	public void setTemperaturaMedia(int temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public void setIrraggiamentoMedio(float irraggiamentoMedio) {
		this.irraggiamentoMedio = irraggiamentoMedio;
	}
	
	public void addCaratteristica(String caratteristica) {
		for (String c: caratteristiche) {
			if (c.contentEquals(caratteristica)) {
				return;
			}
		}
		this.caratteristiche.add(caratteristica);
	}
	
	public int compareTo(Zona z2) {
		return this.codice - z2.getCodice();
	}

	public Collection<String> elencoCaratteristiche(){
		Collections.sort(this.caratteristiche);
		return this.caratteristiche;
	}
	
	public Coltivazione aggiungiColtivazione(String prodotto, int meseSemina, int meseRaccolto) throws ColtivazioneDuplicataException {
		Coltivazione nuovaColtivazione = new Coltivazione(prodotto, meseSemina, meseRaccolto);
		for (Coltivazione c: this.coltivazioni) {
			if (c.equals(nuovaColtivazione)){
				throw new ColtivazioneDuplicataException();
			}
		}
		this.coltivazioni.add(nuovaColtivazione);
		return nuovaColtivazione;
	}

	public Collection<Coltivazione> elencoColtivazioni(){
		return this.coltivazioni;
	}
	
	
	public Raccolto nuovoRaccolto(String prodotto, String data, int quantita){
		boolean giaEsiste = this.cercaRaccolto(prodotto, data) != null;
		Raccolto newRaccolto = new Raccolto(prodotto, data, quantita);
		if (!giaEsiste) {
			this.raccolti.add(newRaccolto);
			return newRaccolto;
		}
		return null;
	}
	
	public Raccolto cercaRaccolto(String prodotto, String data){
		Raccolto questoRaccolto = new Raccolto(prodotto, data, 0);
		for (Raccolto r: this.raccolti) {
			if (r.equals(questoRaccolto)) {
				return r;
			}
		}
		return null;
	}
	
	public Collection<Raccolto>elencoRaccolti(){
		Collections.sort(this.raccolti, Raccolto.comparatorDataQuantita);
		return this.raccolti;
	}
	
	public static Comparator<Zona> comparaCodice = new Comparator<Zona>() {
		@Override
		public int compare(Zona z1, Zona z2) {
			return z1.getCodice() - z2.getCodice();
		}
	};
	
}
