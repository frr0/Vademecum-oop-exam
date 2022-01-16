package company;

public class Manager extends Employee {  // Manager (più specifica) extends Employee (più generica) 
	
	// Sbagliato ripetere/ridefinire gli attributi name e
	// wage dell'Employee, essi verranno "ereditati"...

	// Si aggiunge, invece, cio' che caratterizza il Manager,
    // cio' che e' piu' specifico e lo distingue da un Employee "semplice"

	String managedUnit;
	
	public Manager(String n, double w, String mu) {
		
		// PER CREARE UN Manager JAVA UTILIZZA UN APPROCCIO "A CIPOLLA"
		// 1) PRIMA VIENE CREATA (COSTR./INIZIAL.) l’ANIMA Employee
		// 2) POI VIENE CREATA (COSTR./INIZIAL.) LA PARTE SPECIFICA DEL Manager
				
		// 1) NON USANDO new Employee(...), MA ...  

		super(n, w); // COSTRUIRE ED INIZIALIZZARE L'ANIMA Employee
		
		// 2) POI INIZIALIZZO LA PARTE SPECIFICA del Manager
		
		managedUnit = mu;
		
	}

	// La classe derivata puo' anche AGGIUNGERE nuovi metodi

	public void changeManagedUnit(String u) {
		this.managedUnit = u;
	}
	
	// Oppure RIDEFINIRE metodi ereditati da Employee, in OVERRIDE, stessa FIRMA 
	// ma DIVERSA IMPLEMENTAZIONE (diverso da overloading, solo stesso nome)

	@Override
	public void print() {
		
		// System.out.print(name+" "+wage); 
		
		// Con l'istruzione precedente non sto usando la delega ...
		
		// ... sto accedendo direttamente agli attributi
		// dell'Employee, che però sa meglio di me
		// come stamparsi (in effetti possiede un metodo
		// print() proprio con quella finalita')
		
		// Piu' correttamente, dovrei chiedere
		// al padre di stamparsi (DELEGA) ...
		
		// ... invocando il metodo print() dell'oggetto padre
		
		super.print();
		
		// Poi, qui, stampo solo la parte "di competenza" del Manager
		
		System.out.print(" "+managedUnit);
		
	}

	// Fornisco anche in questo caso un'implementazione specifica del metodo 
	// per l'incremento della paga del Manager

	// Se avessi cambiato il nome del metodo o i parametri non sarebbe stato override 
    // (la firma deve essere la stessa del metodo nella classe padre, altrimenti
    // si tratta semplicemente un altro metodo della classe, magari con lo stesso nome)
	
	@Override
	public void incrementWage() {
		wage = wage+25000;
	}

	
	
}
