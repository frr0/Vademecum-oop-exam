package tipi_wrapper;

public class Intero {

	// Se volessi utilizzare Java come un linguaggio ad oggetti "puro", quindi
	// solo classi, oggetti, metodi, ecc., potrei pensare di creare un nuovo
	// tipo di dato "contenitore" (es, classe Intero) per memorizzare es. il 
	// corrispondente tipo primitivo int ... con un overhead non trascurabile

	// DATI
	
	private int valore;

	// OPERAZIONI SUI DATI (COSTRUTTORE / METODI GETTER E SETTER)

	public Intero(int valore) {
		this.valore = valore;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}
	
}
