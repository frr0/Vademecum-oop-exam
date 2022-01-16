package inheritance;

public class Car {

	String color; // private
	String brand;
	boolean turnedOn;
	
	// Costruttore
	/*public Car() { // "Copia" del costruttore vuoto (l'ho esplicitato)
		color = null;
		brand = null;
		turnedOn = false;
	}*/
	
	// Altri costruttori, magari creati con il wizard di Eclipse
	
	public Car(String c, String b, boolean t) {
		color = c;
		brand = b;
		turnedOn = t;
	}

	// Metodi getter/setter, magari creati con il wizard di Eclipse
	
	// Altri metodi
	
	public void paint(String c) {
		color = c;
	}
	
	public void turnOn() {
		turnedOn = true;
	}
	
	// Metodo per "convertire", descrivere/rappresentare un oggetto
	// (i suoi attribvuti) sotto forma di stringa
	public String toString() { // describeYourself
		return color+" "+brand+" "+turnedOn;
	}
	
}
