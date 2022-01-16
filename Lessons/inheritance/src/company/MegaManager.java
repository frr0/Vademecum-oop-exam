package company;

public class MegaManager extends Manager{

	// Si puo "iterare", e definire un MegaManager ... 
	// ... che e' un Manager... con qualcosa in piu'

	// Si eredita da Manager, che a sua volta ereditava da Employee
	
	String secretary; // Ho aggiunto ciò che serviva (nuovo)
	
	// Potrei usare il wizard per definire il costruttore

	public MegaManager(String n, double w, String mu, String s) {
		
		// La prima istruzione del costruttore di una classe
		// derivata deve sempre essere la chiamata al costruttore
		// della classe di base (padre)
		
		super(n, w, mu);
		secretary = s;
	}

	// Se non si fa altro, la classe eredita i metodi del padre, ovvero
	// del Manager (e quindi di Employee)

	// Posso pero' fornirne una versione in overriding, ad esempio
	// per stampare diversamente (aggiungendo la parte specifica)

	// Esempio usando i Wizard di Eclipse 

	@Override
	public void print() { // Ho cambiato ciò che non mi andava bene
		super.print();
		System.out.print(" "+secretary);
	}
	
	// Ed anche aggiungere metodi specifici, se utile

	// ...
	
}
