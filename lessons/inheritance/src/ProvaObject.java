import company.*;
import inheritance.*;

public class ProvaObject {

	public static void main(String[] args) {

		Object o;
		
		o = new String("abc");
		
		o = new Employee("M. Rossi", 10000);
		
		o = new Car("Fiat","Green", false);
		
		o = 5; // int -> Integer (AUTOBOXING, WRAPPER)

		// GRAZIE AL FATTO CHE TUTTE LE CLASSI EREDITINO DA Object
		
		// POSSO CREARE LA STRUTTURA DATI PIU' GENERICA POSSIBILE
		// E' IN GRADO DI CONTENERE QUALSIASI TIPO DI DATO !!!
		
		Object array[] = new Object[10]; // CELLE NON (PIU') TUTTE DELLO 
        							  	 // STESSO TIPO, O MEGLIO, TUTTE
        							 	 // DISPONIBILI AD ACCOGLIERE RIF. 
									 	 // A Object O AD OGGETTI PIU' SPECIF.
		
		array[0] = new String("abc");
		array[1] = "def";
		array[2] = new Employee("G. Verdi", 20000);
		array[3] = new Car("Volvo","Red", true);
		array[4] = false; // Boolean
		
		/*
		for(int i=0;i<5;i++)
			System.out.println(array[i].toString()); // CORRETTA, A COMPILE TIME
        											 // TUTTI GLI Object (OGGETTI)
        											 // POSSEGGONO/EREDITANO IL
        											 // METODO toString()
        											 // EQUIVALENTEM. println(array[i])
		*/
		
		// ANCHE CON FOR-EACH
		
		for(Object oo : array)
			if(oo!=null)
				System.out.println(oo.toString());
		
		
	}

}
