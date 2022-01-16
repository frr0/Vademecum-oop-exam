package parcheggio;
import parcheggio.Automobile;


public class Parcheggio {

    // Inserire tutti gli attributi necessari, eventualmente creare altre classi
	Automobile lista_auto[] = new Automobile[100];
	String indirizzo = new String();
	double costo_giornaliero;
	/**
	* Crea un nuovo Parcheggio (costruttore)
	*/
	public Parcheggio() {
	}

	/**
	* Imposta l'indirizzo del parcheggio
	*/
	public void setIndirizzo(String i) {
		this.indirizzo = i;
	}

	/**
	* Restituisce l'indirizzo del parcheggio
	*/
	public String getIndirizzo() {
		return this.indirizzo;
	}

	/**
	* Imposta il costo giornaliero del parcheggio
	*/
	public void setCostoGiornaliero(double c) {
		this.costo_giornaliero = c;
	}

	/**
	* Restituisce il costo giornaliero del parcheggio
	*/
	public double getCostoGiornaliero() {
		return this.costo_giornaliero;
	}

	/**
	* Gestisce l'ingresso di una nuova automobile nel parcheggio
	*/  
	public void ingresso(String t, String mm, int p, int ng) {
		int i;
		for (i=0; i<100; i++) {
			if (this.lista_auto[i] == null){
				this.lista_auto[i] = new Automobile(t, mm, p, ng);
				break;
			}
		}
	}

	/**
	* Restituisce le informazioni relative all'ultimo ingresso 
	*/  
	public String ultimo() {
		int i;
		for (i=0; i<100; i++) {
			if (lista_auto[i] == null){
				if (i==0) {
					return null;
				}
				break;
			}
		}
		return lista_auto[i-1].getInfo();
	}

	/**
	* Restituisce le informazioni relative all'automobile la cui targa e' passata come parametro 
	*/  
	public String automobile(String t) {
		int i;	
		for (i=0; i<100; i++) {
			if (lista_auto[i] != null) {
				if (lista_auto[i].getTarga() == t) {
					return lista_auto[i].getInfo();
				}
			}
		}
		return "Auto non trovata";
	}

	/**
	* Restituisce il costo medio della sosta per le automobili parcheggiate 
	*/  
	public double mediaCosti() {
		int i;
		double x = 0;
		int num_auto = 0;
		for (i=0; i<100; i++) {
			if (this.lista_auto[i] != null) {
				x += this.lista_auto[i].getNumeroGiorni() * this.costo_giornaliero;
				num_auto++;
			}
		}
		return x/num_auto;
		
	}

}
