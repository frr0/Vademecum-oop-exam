package supermercato;

public class Supermercato {

    // Inserire tutti gli attributi necessari, eventualmente creare altre classi
	
	String indirizzo;
	double costoGiornaliero;
	Vendita[] vendite;
	int numeroVendite;
	
	
	/**
	* Crea un nuovo Supermercato (costruttore)
	*/
	public Supermercato() {
		this.vendite = new Vendita[50];
		this.numeroVendite = 0;
	}
	

	/**
	* Imposta l'indirizzo del supermercato
	*/
	public void setIndirizzo(String i) {
		this.indirizzo = i;
	}

	/**
	* Restituisce l'indirizzo del supermercato
	*/
	public String getIndirizzo() {
		return this.indirizzo;
	}

	/**
	* Imposta il costo giornaliero del supermercato
	*/
	public void setCostoGiornaliero(double s) {
		this.costoGiornaliero = s;
	}

	/**
	* Restituisce il costo giornaliero del supermercato
	*/
	public double getCostoGiornaliero() {
		return this.costoGiornaliero;
	}

	/**
	* Gestisce la vendita di un prodotto del supermercato
	*/  
	public void nuovaVendita(String n, String m, int u, double p) {
		if(this.numeroVendite < 50)
			this.vendite[this.numeroVendite++] = new Vendita(n, m, u, p);
	}

	/**
	* Restituisce le informazioni relative all'ultima vendita
	*/  
	public String ultimaVendita() {
		return this.vendite[this.numeroVendite-1].stampaVendita();
	}

	/**
	* Restituisce le informazioni relative alla vendita di cui nome prodotto e marca sono passati come parametro 
	*/  
	public String vendita(String n, String m) {
		
		String s = null;
		
		for (int i = 0; i < this.numeroVendite; i++)
			if (vendite[i].getNome().compareTo(n) == 0 && vendite[i].getMarca().compareTo(m) == 0)
				s = vendite[i].stampaVendita();
				
		
		return s;
	}

	/**
	* Restituisce il numero di giorni i cui costi sono coperti
	*/  
	public double giorniCoperti() {
		
		double sommaIncassi = 0;
		
		for (int i = 0; i < this.numeroVendite; i++)
			sommaIncassi += vendite[i].getUnita() * vendite[i].getPrezzo();
		
		return sommaIncassi/this.costoGiornaliero;	
	}

}
