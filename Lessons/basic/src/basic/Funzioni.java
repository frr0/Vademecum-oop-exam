package basic;

public class Funzioni {


	// main(), funzione/metodo essenziale per avere una applicazione
	
	// in C int argc, char *argv[], qui array di stringhe

	public static void main(String[] args) {
	
		// Metodi, o funzioni, procedure, ecc. strumenti per 
		// fattorizzare codice (MODULARITA')
		
		// Es., calcolare la media di tre variabili/numeri interi

		int a = 4;
		int b = 2;
		int c = 10;
		
		// Si potrebbe scrivere

		//int somma = a + b + c;
		//double media = (double)somma / 3.0;
		//System.out.println("La media vale "+media);
		
		// Ora, se si dovesse calcolare la media di altri tre valori, poi altri tre, ecc.?
		// Copia e incolla, oppure... rendersi conto che puo' convenire fattorizzare quelle 
		// istruzioni in un modulo richiamabile piu' volte all'occorrenza, es. calcolaLaMedia(...);
		
		// Chiamo una funzione/invoco un metodo
		
		
		                                 // Parametri ATTUALI
		double media = calcolaLaMedia(a, b, c*2);
		//System.out.println("La media vale "+media);
		
		                                 // Java all'invocazione **COPIA** il contenuto
		                                 // dei parametri attuali
		                                 // nei parametri formali

		// Ho invocato una funzione "di utilità", calcolaLaMedia() sembra non essere 
		// ancora una "vera" operazione sui dati nella accezione della OOP, di
		// INCAPSULAMENTO, ovvero dati + operazioni sui dati
		
		System.out.println("La media vale: "+media);
		
		// Ora, volendo calcolare la media di un array di interi
		
		int array[] = {4, 4, 4, 67, 72};

		// Si puo' definire un altra funzione, es. calcolaMediaSuUnArray(...);

		media = calcolaLaMedia(array); // Era calcolaLaMediaSuArray, ma posso dare lo stesso nome

		// Comportamenti POLIMORFICI per la funzione calcolaLaMedia()
		// Stesso NOME, diversa FIRMA, in Java è possibile

		System.out.println("La media vale: "+media);
		
		
	} // Fine del main()
	

	
    // Notazione "camelback" i/InizialiDelleParoleMaiuscole
	
	                               // Parametri FORMALI della funzione
	static double calcolaLaMedia(int primo, int secondo, int terzo) { // Per evitare ambiguità, nomi diversi
		
		// int somma = a + b + c;
		// double media = (double)somma / 3.0;
		// return media
		
		// somma = a+b+c; // ERRORE PERCHE' a, b e c NON SAREBBERO VISIBILI
		
		// Anche in forma più compatta 

		return ((double)(primo + secondo + terzo))/3;		
	}

	// Posso cambiare nome a questa seconda funzione e chiamarla come la prima
	// In Java NON posso avere due funzioni con LA STESSA FIRMA
	// FIRMA DI UNA FUNZIONE e' NOME + INSIEME DEI SUOI PARAMETRI (numero, tipo, ordine)
	
	static double calcolaLaMedia( int[] arr ) { // Era calcolaLaMediaSuArray
		
		double somma=0; // Devo inizializzare le variabili nelle funzioni

		// DELEGA, "Chi meglio dell'array conosce le proprie dimensioni?"
		for(int i=0;i<arr.length;i++) // NON i<3, MA arr.length (CODICE CHE SI ADATTA)
			somma=somma+arr[i]; // +=
		return somma/arr.length; // Non divido per 3.0, ma per ...		
	}


}  // Fine della classe
