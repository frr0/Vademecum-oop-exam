package aziendaagricola;

import java.util.*;
import java.io.*;

public class Azienda {
	private ArrayList<Zona> zone;
	private ArrayList<Magazzino> magazzini;
	private int numZona;
	
	public Azienda() {
		this.zone = new ArrayList<Zona>();
		this.numZona = 1000;
		this.magazzini = new ArrayList<Magazzino>();
	}

	public Zona aggiungiZona(){
		boolean giaEsiste;
		do {
			giaEsiste = false;
			for (Zona z: this.zone) {
				if(z.getCodice() == this.numZona) {
					giaEsiste = true;
					this.numZona++;
					break;
				}
			}
		} while (giaEsiste);
		Zona nuovaZona = new Zona(this.numZona);
		this.zone.add(nuovaZona);
		this.numZona++;
		return nuovaZona;
	}
	
	public Zona cercaZona(int codice){
		for (Zona z: this.zone) {
			if (z.getCodice() == codice) {
				return z;
			}
		}
		Zona nuovaZona = new Zona(codice);
		this.zone.add(nuovaZona);
		return nuovaZona;
	}
	
	public void specificaCaratteristicheZona(int codice, String caratteristica){
		Zona questaZona = this.cercaZona(codice);
		if (questaZona != null) {
			questaZona.addCaratteristica(caratteristica);
		}
	}
	
	public Collection<Zona> elencoZone(){
		Collections.sort(this.zone, Zona.comparaCodice);
		return this.zone;
	}
	
	public Collection<Zona> elencoZone(int ampiezza){
		ArrayList<Zona> questeZone = new ArrayList<Zona>();
		for(Zona z: this.zone) {
			if (z.getAmpiezza() > ampiezza) {
				questeZone.add(z);
			}
		}
		Collections.sort(questeZone, Zona.comparaCodice);
		return questeZone;
	}
	
	public Magazzino aggiungiMagazzino(String nome, String prodotto, int quantitaStoccabile){
		Magazzino newMagazzino = new Magazzino(nome, prodotto, quantitaStoccabile);
		this.magazzini.add(newMagazzino);
		return newMagazzino;		
	}
	
	public int totaleMagazzino(){
		int res = 0;
		for (Magazzino m: this.magazzini) {
			res += m.getQuantitaStoccata();
		}
		return res;
	}
	
	public void leggi(String nomeFile) throws IOException, NumberFormatException, ColtivazioneDuplicataException{
		File file = new File(nomeFile);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String row;
		while((row = br.readLine()) != null) {
			String[] data = row.split(";");
			if (data[0].contentEquals("C")) {
				Zona questaZona = this.cercaZona(Integer.parseInt(data[1]));
				questaZona.aggiungiColtivazione(data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
			} else if (data[0].contentEquals("R")) {
				Zona questaZona = this.cercaZona(Integer.parseInt(data[1]));
				questaZona.nuovoRaccolto(data[2], data[3], Integer.parseInt(data[4]));
			}
		}
	}
	
}
