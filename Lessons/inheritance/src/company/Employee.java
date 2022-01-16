package company;

public class Employee {

	protected String name; // public, private, o ...?
	protected double wage; // protected, visibile in questa classe e nelle 
	                       // classi da essa derivate (Manager, ecc.)
	
	public Employee(String name, double wage) {
		this.name = name;
		this.wage = wage;
	}
	
	// getter/setter
	
	public void print() {
		System.out.print("\n"+name+" "+wage);
	}
	
	public void incrementWage(){
		wage+=1000;
	}

	// La classe Employee possiede gia' implicitamente
	// una versione del metodo toString() ereditato da Object
	// ma questa versione del metodo stampa solo lo UID
	
	// Il programmatore puo' ridefinire (in override) il metodo
	
	// PATTERN, "REGOLA D'ORO": DOTARE LE CLASSI DI UN METODO 
	// PER DESCRIVERSI, toString() ...

	//@Override
	public String toString() { // Sovrascrive l'implementazione fornita in Object
		return name+", "+wage; // Scegliamo noi come deve descriversi
		
	}
	
	// .. E DI UN METODO PER CONFRONTARSI, equals()
	// SE NECESSARIO, CHIARAMENTE, USUFUIRE DI QUESTE FUNZ.
    
	
}
