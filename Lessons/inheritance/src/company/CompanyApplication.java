package company;

public class CompanyApplication {

	public static void main(String[] args) {

		Employee e = new Employee("M. Rossi", 20000);
		e.print();
		e.incrementWage();
		e.print();
		
		
		
		Manager m = new Manager("B. Boss", 75000, "HR");
		m.print(); // Fino a quando non definisco una 
        		   // implementazione piu' specifica
                   // del metodo print(), questo si stamperà
                   // come un "generico" Employee
		
		// MA, SE VIENE FORNITO ALLA CLASSE Manager
        // (PIU' SPECIFICA) UN METODO "AD HOC"
        // (STESSA FIRMA DEL METODO NELLA CLASSE PADRE,
        // QUINDI IN OVERRIDE), ALLORA JAVA
        // INVOCHERA' QUELLA VERSIONE
		
		m.incrementWage();  // SE NON PRESENTE NEL Manager, JAVA
        					// CHIAMA LA VERSIONE PIU' GENERALE
        					// DEFINITA NELL'Employee

		m.print();

		// POSSIAMO CREARE DELLE STRUTTURE DATI PIU' GENERICHE
		// POSSO ** RIMANDARE ** LA SCELTA SUL FATTO CHE NELLA STRUTTURA
		// DATI (ES. ARRAY) VI SIANO Employee O Manager
		
		System.out.println("-----------------");
		Employee emps[] = new Employee[10];
		emps[0] = e;
		emps[1] = m;
		emps[2] = new Manager("Ms. Head", 150000, "All");
		
		MegaManager mm = new MegaManager("Superman", 5000000, "World", "?");
		emps[3] = mm;
		
		// emps[4] = new String("abc"); // Non c'è relazione tra String e Employee
		
		for(int i=0;i<emps.length;i++)
			if(emps[i]!=null)
				emps[i].print(); // Questa istruzione è corretta dal punto
		                         // di vista SINTATTICO perchè Java verifica
		                         // di che tipo sia la cella dell'array (Employee)
		                         // e che quell'oggetto/classe offra il metodo
		                         // invocato (print) [TYPE CHECKING]
		
								 // Dopo il COMPILE TIME viene il RUN TIME
		                         // ovvero quando il programma viene mandato
		                         // in esecuzione. Java cella per cella
		                         // si predispone a chiamare il metodo print():
		                         // a volte trovera' magari degli Employee
		                         // e quindi chiamerà il metodo più GENERALE
		                         // a volte troverà, es., dei Manager, e
		                         // proverà a chiamare il metodo più 
		                         // SPECIFICO (DE DISPONIBILE, se RIDEFINITO
		                         // in OVERRIDE)
								 // [POLIMIRFISMO] tipi diversi in un contenitore
		                         // [DYNAMIC / LATE BINDING] Java rimanda la scelta
		                         //                          del metodo da invocare

	}

}
