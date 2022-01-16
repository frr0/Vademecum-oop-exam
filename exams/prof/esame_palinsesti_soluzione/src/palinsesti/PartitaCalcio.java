package palinsesti;

public class PartitaCalcio extends Programma{

	String squadraCasa;
	String squadraOspite;
	
	public PartitaCalcio(String id, Palinsesto palinsesto, String nome) {
		super(id, palinsesto, nome);
	}
	
	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa=squadraCasa;
	}
	
	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite=squadraOspite;
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}
	
	

}
