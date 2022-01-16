package multisala;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Sala implements Comparable<Sala>{

	private int codiceSala;
	private int numeroFile = 0;
	private int numeroPostiPerFila = 0;

	private Map<String,Proiezione> proiezioni = new TreeMap<String,Proiezione>();
	
	public Sala(int codiceSala, int numeroFile, int numeroPostiPerFila){
		this.codiceSala=codiceSala;
		this.numeroFile=numeroFile;
		this.numeroPostiPerFila=numeroPostiPerFila;
	}
	
	public int getCodiceSala() {
		return codiceSala;
	}

	public int getNumeroFile() {
		return numeroFile;
	}

	public int getNumeroPostiPerFila() {
		return numeroPostiPerFila;
	}
	
	public Collection<Proiezione> elencoProiezioni(){
		return proiezioni.values();
	}
	
	public void addProiezione(Proiezione proiezione){
	     proiezioni.put(""+proiezione.getData()+""+proiezione.getOra(), proiezione);
	}

	public int compareTo(Sala altraSala) {
		int postiQuesta = numeroFile * numeroPostiPerFila;
		int postiAltra = altraSala.getNumeroFile() * altraSala.getNumeroPostiPerFila();
		return postiAltra-postiQuesta;
	}	
}
