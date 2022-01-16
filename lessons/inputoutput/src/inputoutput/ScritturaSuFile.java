package inputoutput;

import java.io.*;

public class ScritturaSuFile {

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("output.txt");
		
		fw.write("La mia prima stringa scritta su file");

		fw.flush(); // Forza la scrittura prima della chiusura
		
		fw.close(); // Ricordarsi sempre di chiudere lo stream
	}

}
