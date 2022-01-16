package ufficiotecnico;

import java.util.*;

public class Monumento implements Comparable<Monumento>{

	private String rappresenta;
	private String data;
	private String artista;
	private char posizione;
	
	private List<String> materiali = new LinkedList<String>();

	public Monumento(String rappresenta, String data, String artista, char posizione) {
		this.rappresenta=rappresenta;
		this.data=data;
		this.artista=artista;
		this.posizione=posizione;
	}
	
	public String getRappresenta() {
		
		return rappresenta;
	}

	public String getData() {
		
		return data;
	}

	public String getArtista() {
		
		return artista;
	}

	public char getPosizione() {
		
		return posizione;
	}

	public void aggiungiMateriale(String materiale){
		materiali.add(materiale);
	}
	
	public Collection<String> elencoMateriali(){

		return materiali;
	}
	
	@Override
	public int compareTo(Monumento m) {
		return data.compareTo(m.getData());
	}

}
