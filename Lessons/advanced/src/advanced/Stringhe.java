package advanced;
import java.lang.String; //Non e' necessario importare questa classe (classi "privilegiate")

public class Stringhe {

	public static void main(String args[]) {
		
		/*char s[] = new char[100]; // Array di char, come in C
		
		for(int i=0;i<s.length;i++)
			s[i] = ' ';
		*/
		
		// String s = new String("ABCDE");
		
		String s = "ABCDE"; // Equivalente, scorciatoia di Java, senza new
		
		s = "ABCDE\n"; // Uso di caratteri speciali, es. \n
		
		System.out.println(s);
		
		int n = s.length(); // Metodo per ottenere la lunghezza effettiva della stringa
		
		System.out.println(n);

		// Come confrontare due stringhe?
		
		String s1 = "ABC";
		String s2 = "ABC";
		
		// Confronto tra oggetti, MAI attraverso == (anche se, per comodita', 
		// su String funziona comunque, scorciatoia di Java)

		// if(s1==s2)
		// ...	
		
		// CON == SI CONFRONTANO GLI UID nella "scatolina", NON IL CONTENUTO 
		// dei due oggetti/istanze nella "scatolona"
		
		//  Ci sono altre strade: metodi nella classe String
		
		//if(s1.equals(s2)) // FUNZIONA CON LE STRINGHE, NON CON TUTTE LE CLASSI

		// Oppure compareTo() per confronto lessicografico

		if(s1.compareTo(s2)==0) // Utili >0 <0 es. per confrontare date nel formato AAAAMMGG
			System.out.println("Uguali");
		else
			System.out.println("Diverse");
		
		// Altri metodi, es. per convertire in maiuscolo (o minuscolo)
		
		String s3 = "sono minuscola";
		
		s3 = s3.toUpperCase();
		
		String s4;
		s4 = s3.toUpperCase();  // Attenzione che molti metodi di questi metodi 
		System.out.println(s4); // restituiscono una nuova stringa a sinistra di ==
		
		// Estrazione di una sotto-stringa da una stringa

		String stringaLunga = "Stringa molto lunga";
		
		String sottoStringa = stringaLunga.substring(8); // A partire dal carattere in posizione ...
		
		System.out.println(sottoStringa);

		// Ricerca di un carattere (o sotto-stringa) in una stringa
		
		int indice = stringaLunga.indexOf('a');
		// int indice = stringaLunga.indexOf("molto");
		
		System.out.println("Indice del carattere a: "+indice);

		// Per accedere al carattere i-esimo

		char c = stringaLunga.charAt(0);
		
		System.out.println("Carattere in posizione 0: "+c);
		
		// Verifica contenimento sotto-stringa
		
		if(stringaLunga.contains("lunga"))
			System.out.println("Sotto-stringa presente");
		else
			System.out.println("Sotto-stringa assente");

		// Verifica inizio della stringa
		
		if(stringaLunga.startsWith("St"))
			System.out.println("La stringa inizia con St");
		else
			System.out.println("La stringa non inizia con St");
		
	}
	
}
