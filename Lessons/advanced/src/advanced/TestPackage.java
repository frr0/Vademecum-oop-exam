package advanced;
// Superflue, per quanto in java.lang

import java.lang.*; // Con * importo tutto il contenuto 
import java.lang.String; // Così invece una classe specifica

//In linguaggio C, per usare es. la libreria di IO avrei scritto 
//#include <stdio.h>
//#include "string.h"

// In Java

import java.io.*; // Importo tutte le classi del package

//import shoes.String; // Non posso importare due classi con lo stesso nome, ambiguita'

public class TestPackage {

	public static void main(String[] args) {

		// Per dichiarare una stringa posso sfruttare il fatto che la 
		// classe sia stata importata, implicitamente o meno (java.lang)

		//String s;
		
		// Oppure, posso utilizzare il suo FULLY QUALIFIED NAME

		java.lang.String s;
		
		// Non potrei importare una classe (String, ma neanche con altro nome)  
		// se questa fosse nel (default package) ...
		// ...perche' non saprei come indicare la cosa, come chiamarla
		
		// Ma, se volessi, potrei avere una classe String in un altro package, es. shoes

		// Se poi volessi creare un oggetto di tipo shoes.String, potrei scrivere così
		
		shoes.String ss;
		
		// s = ss; // Attenzione che si tratta di tipi diversi, non facilmente convertibili
		
		// Altri esempi di classi native di Java

		java.util.Date d;
		java.io.File f;
		
		// ...

	}

}
