package campionati;

public class Incontro {
	private int squadraCasa;
	private int risultatoCasa;
	private int squadraTrasferta;
	private int risultatoTrasferta;
	
	public Incontro(int squadraCasa, int squadraTrasferta) {
		this.squadraCasa = squadraCasa;
		this.risultatoCasa = -1;
		this.squadraTrasferta = squadraTrasferta;
		this.risultatoTrasferta = -1;
	}
	
	public String getIdentificativo() {
		return new String(this.squadraCasa+"-"+this.squadraTrasferta);
	}
	
	public void setEsito(String esito) {
		String [] arrEsito = esito.split("-");
		this.risultatoCasa = Integer.parseInt(arrEsito[0]);
		this.risultatoTrasferta = Integer.parseInt(arrEsito[1]);
	}
	
	public String getEsito() {
		if (this.risultatoTrasferta == -1 && this.risultatoCasa == -1) {
			return new String("N/D");
		} else {
			return new String(this.risultatoCasa+"-"+this.risultatoTrasferta);
		}
	}

	public int getSquadraCasa() {
		return squadraCasa;
	}

	public int getSquadraTrasferta() {
		return squadraTrasferta;
	}
	
}
