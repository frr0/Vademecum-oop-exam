package palestra;

public class CorpoLibero extends Esercizio {
	
	public double getCalorie() {
		return calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}

	private double calorie;

	public CorpoLibero(String codice, String descrizione, double calorie) {
		super(codice, descrizione);
		this.calorie = calorie;
		// TODO Auto-generated constructor stub
	}

	public String descriviti() {
		return super.descriviti() +  " CPL " + calorie;
	}

}
