package database;

import java.util.LinkedList;

public class AppUFO {

	// Applicazione che, ignara della presenza di un database, accede
	// ai suoi dati utilizzando una classe DAO, che mette a disposizione
	// metodi che estraggono le informazioni utili (e che può essere
	// riutilizzata anche in altre applicazioni)
	
	public static void main(String[] args) {

		SightingDAO sd = new SightingDAO();
		
		LinkedList<String> l = new LinkedList<String>(sd.readShapes());
		
		for(String s : l)
			System.out.println(s);
		
		int cnt = sd.cntShapes("round");
		
		System.out.println("Numero di forme di tipo round: "+cnt);
		
	}

}
