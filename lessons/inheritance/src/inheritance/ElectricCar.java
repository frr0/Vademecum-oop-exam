package inheritance;

// Potrei creare la classe come fatto per Car ...

// ... oppure utilizzare l'ereditarietà (extends)

// La classe ElectricCar estende Car

public class ElectricCar extends Car {

	// String color; // SE USO L'EREDITARIETA' NON RIPETERE ATTRIBUTI EREDITATI !!!
	// String brand;
	// boolean turnedOn;
	
	// Una classe DERIVATA puo'
	
	// 1) AGGIUNGERE CIO' CHE MANCA (VALE SIA PER GLI ATTRIBUTI CHE PER I METODI)	
		
	boolean cellsCharged; // ATTRIBUTO "NUOVO", SPECIFICO DELLA CLASSE ElectricCar, AGGIUNTO
		
	public ElectricCar(String c, String b, boolean t, boolean cc) {
		
		// Potrei voler inizializzare tutti gli attributi, ma la cosa corretta
		// consiste nel chiedere alla classe padre/parent Car di farlo per me (DELEGA)
		
		// Per costruire una ElectricCar devo prima costruire // "la sua anima" Car 

		// Devo chiamare il costruttore della classe padre/parent Car, ma non con new Car()
			
		 // super() SIGNIFICA IL COSTRUTTORE DEL PADRE/PARENT
		
		super(c, b, t); // Prima istruzione, in pratica  invoca il costruttore 
						// di Car passando i parametri del caso
			
		// MI RESTANO DA INIZIALIZZARE GLI ATTRIBUTI SPECIFICI DI ElectricCar
		
		cellsCharged = cc;
	}

	// METODO "NUOVO", SPECIFICO DI ElectricCar, AGGIUNTO

	public void recharge() {
		cellsCharged=true;
	}
		
	// 2) CAMBIARE CIO' CHE "NON VA BENE"

	// SE NECESSARIO, POSSO RIDEFINIRE LA "VERSIONE" DEFINITA 
	// NELLA CLASSE Car PER STAMPARE ANCHE cellsCharged 

	// Stesso nome/parametri di quello del padre, ma con 
	// un corpo diverso, più specifico
		
	// Si dice che questo metodo, che CAMBIA/SOVRASCRIVE il 
	// comportamento originariamente definito in Car, e quindi
	// erditato da ElectricCar, è "IN OVERRIDE"
		
	public String toString() {
		
		// RIESCO A VEDERE GLI ATTRIBUTI DEL PADRE PERCHE' SONO EREDITATI
		
		//return color+" "+brand+" "+turnedOn+" "+cellsCharged;
		                                    // Stampo anche cellsCharged
		
		// Non molto efficiente, meglio
		
		return super.toString()+" "+cellsCharged;
			
	}
	
	// 3) EREDITARE, IMPLICITAMENTE, QUANTO DEFINITO NELLA/E CLASSE/I DI BASE

	/* 
	public void paint(String c) { SE OK, NON OCCORRE RISCRIVERLO, EREDITATO
	    color=x;
    } 
    */

	
}



