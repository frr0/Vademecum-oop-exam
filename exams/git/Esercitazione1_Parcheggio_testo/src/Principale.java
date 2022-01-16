import parcheggio.Parcheggio;

/**
 * Classe con un metodo main() di esempio
 */

public class Principale {

    /**
     * Esempio d'uso della classe Parcheggio
     */
	
	public static void main(String[] args) {

		// PRIMA PARTE
		String targhe[];
		targhe = new String[100];
		
		String modello[];
		modello = new String[100];
		
		int posto_assegnato[] = new int[100];
		int num_giorni[] = new int[100];
		
		int n_max = 100;
		
		// inizializzo prima auto AB123CD, Fiat Panda, 12, 3
		targhe[0] = "AB123CD";
		modello[0] = "Fiat Panda";
		posto_assegnato[0] = 12;
		num_giorni[0] = 3;
				
		// inizializzo seconda auto EF456GH, Alfa Romeo Giulietta, 45, 6
		targhe[1] = "EF456GH";
		modello[1] = "Alfa Romeo Giulietta";
		posto_assegnato[1] = 45;
		num_giorni[1] = 6;
		
		int i;
		int num_occupati = 0;
		String virgola = ", ";
		for (i=0; i < n_max; i++) {
			if (targhe[i] != null) {
				num_occupati++;
				System.out.println(targhe[i] + virgola + modello[i] + virgola + posto_assegnato[i] + virgola + num_giorni[i]);
			}
		}
		
		
		System.out.println("Percentuale posti occupati: " + percentualePostiOccupati(num_occupati, n_max) + "%");
		
		
		

		// SECONDA PARTE - Iniziare a ragionare in termini di classi e oggetti
		
		System.out.println("");
		System.out.println("*************************************************************************************");
		System.out.println("*                                   Seconda parte                                   *");
		System.out.println("*   Modificando la classe Parcheggio (ed eventualmente aggiungendo altre classi),   *");
		System.out.println("*    di seguito verranno mostrate le altre informazioni memorizzate dal sistema     *");
		System.out.println("*************************************************************************************\n");
		
		// Viene creato un nuovo parcheggio, e se ne imposta l'indirizzo ed il costo giornaliero con i metodi setIndirizzo()
		// e setCostoGiornaliero()
		
		Parcheggio p = new Parcheggio();
		p.setIndirizzo("Via dei Parcheggi 99");
		p.setCostoGiornaliero(7.0);
		
		// L'indirizzo ed il costo giornaliero del particolare parcheggio sono accessibili tramite i metodi getIndirizzo() 
		// e getcostoGiornaliero()

		String indirizzo = p.getIndirizzo();
		double costoGiornaliero = p.getCostoGiornaliero();
		System.out.println("Creato parcheggio in "+indirizzo+", costo giornaliero "+costoGiornaliero);
		
		// L'ingresso di un'automobile viene gestito tramite il metodo ingressoAutomobile() che riceve quattro parametri:
		// targa, marca/modello, posto assegnato e numero di giorni
		
		p.ingresso("AB123CD", "Fiat Panda", 12, 3);
		p.ingresso("EF456GH", "Alfa Romeo Giulietta", 45, 6);
		
		// Per accedere alle informazioni relative all'ultimo ingresso si utilizza il metodo ultimo(), che restituisce 
		// una stringa contenente targa, marca/modello, posto e numero di giorni nel formato precedentemente descritto

		System.out.println("");
		System.out.println("Ultimo ingresso:");
		String ultimoIngresso = p.ultimo();
		System.out.println(ultimoIngresso);
		
		// Per accedere alle informazioni relative ad una qualsiasi delle automobili parcheggiate data la targa si 
		// utilizza il metodo automobile(), che riceve come parametro il numero di targa e restituisce una stringa 
		// con lo stesso formato utilizzato dal metodo precedente.  

		System.out.println("");
		System.out.println("Automobile con targa AB123CD:");
		String automobileCercata = p.automobile("AB123CD");
		System.out.println(automobileCercata);
	
		// Il metodo mediaCosti() restituisce un valore di tipo double relativo alla media dei costi di parcheggio, 
		// calcolata considerando il costo giornaliero ed il numero di giorni per le automobili parcheggiate

		System.out.println("");
		System.out.println("Media costi:");
		double valoreMedio = p.mediaCosti();
		System.out.println(valoreMedio);
	
	}
	
	static double percentualePostiOccupati(int occupati, int n_max) {
		double res = (double)occupati/(double)n_max;
		return res*100;
	}

}
