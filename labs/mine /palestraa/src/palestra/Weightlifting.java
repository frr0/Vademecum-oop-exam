package palestra;

public class Weightlifting extends Esercizio  {

	private double calorie;

	public double getCalorie() {
		return calorie;
	}

	public Weightlifting(String codice, String descrizione, double calorie) {
		super(codice, descrizione);
		this.calorie = calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}

	public String descriviti() {
		return getCodice() + " " + getDescrizione() + " " + calorie;
	}

}