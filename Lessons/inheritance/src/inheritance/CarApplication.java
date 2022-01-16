package inheritance;

public class CarApplication {

	public static void main(String[] args) {

		/*
		Car c;
		c.brand="...";
		c.color="...";
		*/
		
		Car c1 = new Car("Red","Ferrari", false);
		
		ElectricCar ec1 = new ElectricCar("White", "Fiat", false, true);
		
		System.out.println("*** c1 ***");
		
		// Potrei accedere ai singoli attributi per stamparli
		// Orrore: meglio usare la delega -> metodo di Car
		System.out.println(c1); // describeYourself()
		                        // toString()
		
		System.out.println("*** ec1 ***");
		
		// SE ESISTE UNA VERSIONE PIU' SPECIFICA DEL METODO toString()
		// O DI ALTRO METODO IN ElectricCar, JAVA INVOCHERA' QUELLO
		
		System.out.println(ec1.toString()); // Qui è stato invocato
		                                    // il metodo di ElectricCar
		                                    // (più specifico), se
		                                    // esiste, altrimenti
		                                    // quello più generale
		                                    // (eriditato)
		
		// Il metodo toString() ha assunto/ha dato un 
		// comportamento che viene definito POLIMORFICO
		
		// POSSO, ALL'INTERNO DI UNA VARIABILE RIFERIMENTO DI TIPO
		// Car, MEMORIZZARE IL RIFERIMENTO AD UN OGGETTO ElectricCar ?
		Car c2 = c1;
		
		Car c3 = ec1; // POSSO FARLO PERCHE' ec1 E' UNA SPECIALIZZAZIONE DI 
	                  // DI CAR, OVVERO PERCHE' ec1 "IS A" Car
		
		// POSSO CREARE DEI CONTENITORI DI TIPO PIU' GENERICO E USARLI
		// PER OSPITARE OGGETTI DI TIPO PIU' SPECIFICO (MA NON
		// VICEVERSA). POSSO FARLO NON SOLO CON VARIABILI, ANCHE ARRAY
		
		// Creo un array di tipo Car, cioè atto a / capace di
		// ospitare riferimenti ad oggetti di tipo Car
		// (ma non solo, anche riferimerimenti di tipo ElectricCar)
		
		Car cars[] = new Car[10];
		cars[0] = c1;
		cars[1] = ec1;
		cars[2] = new Car("Blue","Audi",true);
		cars[3] = new ElectricCar("Black","Tesla",false,false);
		
		System.out.println("******* array *******");
		for(int i=0; i<cars.length;i++)
			if(cars[i]!=null)
				System.out.println(cars[i].toString());
		                // Java va a vedere se in quella particolare
		                // cella dell'array vi sia per caso un oggetto
		                // di tipo più specifico (ElectricCar), 
		                // nel cui caso va a verificare se
		                // questo abbia per caso RIDEFINITO (in OVERRIDE)
					    // quel metodo, e se è così invoca la versione
		                // più specifica di quel metodo
						// (meccanismo noto come DYNAMIC O LATE BINDING)
		
		// PER VERIFICARE IL TIPO DI UN OGGETTO SI PUO' USARE instanceof
		
		for(int i=0;i<cars.length;i++)
			if(cars[i]!=null) {
				if(cars[i] instanceof ElectricCar)
					System.out.println("E' una ElectricCar");
				else
					System.out.println("E' una Car");
			}
		
	}

}







