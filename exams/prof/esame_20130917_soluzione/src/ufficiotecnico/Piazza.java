package ufficiotecnico;

import java.util.*;

public class Piazza extends ElementoTopografico {

	private String forma;
	private double estensione;
	
	private List<Monumento> monumenti = new LinkedList<Monumento>();

	
	public String getForma() {

		return forma;
	}
	
	public void setForma(String forma) {
		this.forma=forma;
	}
	
	public double getEstensione() {

		return estensione;
	}
	
	public void setEstensione(double estensione) {
		this.estensione=estensione;
	}

	public Monumento aggiungiMonumento(String rappresenta, String data, String artista, char posizione){
		
		Monumento nuovoMonumento=null;
		boolean occupato=false;
		int indice=-1;
		for(int i=0;i<monumenti.size();i++){
			Monumento mtemp = monumenti.get(i);
			if(mtemp.getPosizione()==posizione){
				occupato=true;
				indice=i;
			}
		}
		
		if(occupato)
		{
			monumenti.remove(indice);
		}

		nuovoMonumento=new Monumento(rappresenta,data,artista,posizione);
		monumenti.add(nuovoMonumento);
		return nuovoMonumento;
	}

	public Collection<Monumento> elencoMonumenti() {
		
		return monumenti;
	}
	
	public boolean monumentoPresenteInPosizione(char posizione){

		boolean occupato=false;
		for(int i=0;i<monumenti.size();i++){
			Monumento mtemp = monumenti.get(i);
			if(mtemp.getPosizione()==posizione){
				occupato=true;
			}
		}
		if(occupato)
			return true;
		else
			return false;
	}
}
