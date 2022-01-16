package generics;

public class Applicazione {

	public static void main(String[] args) {

		// A questo punto dobbiamo scegliere che tipo di dato utilizzare

		int matricola = 12345;
		
		// Ogniqualvolta utilizziamo la classe Persona
		// POSSIAMO (DOVREMMO) aggiungere tra < > 
		// (in maniera esplicita) il tipo di dato
		// effettivo che pensiamo di memorizzare in T 
		// nell'attributo id

		Persona<Integer> p1 = new Persona<Integer>(matricola, "Mario Rossi", 22);
		
		
		// String sMatricola = "12345";
		                 // Eventuali errori di tipo "intercettati"
		                 // grazie all'uso dei tipi generici di Java
        // Persona<Integer> p3 = new Persona<Integer>(sMatricola,"Anna Blu", 36);

		// Se al posto di parametrizzare usando Integer, uso String 
		
		String cf = "ABCDEF56H77X333";
		Persona<String> p2 = new Persona<String>(cf, "Abc Def", 56);
		
		String s2 = (String)p2.getId(); //Ok

		// String s1 = (String)p1.getId(); // Downcast "azzardato", errori a 
										   // RUNTIME, che vengono già segnalati
									       // a COMPILE TIME se parametrizzo
		
		// Usando i generics di Java si ha il vantaggio di poter rimanere 
		// generici (Object) ASSIEME al vantaggio del type-checking (meno errori)
		
		
		
	}

}
