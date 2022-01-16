package supermercato;

public class ProdottoDaFrigo extends Prodotto{
	
	private int temperaturaDiConservazione;

	public ProdottoDaFrigo(String codice, String nome, int volume) {
		super(codice, nome, volume);
	}

	public int getTemperaturaDiConservazione(){
		return this.temperaturaDiConservazione;
	}

	public void setTemperaturaDiConservazione(int temperaturaDiConservazione){
		this.temperaturaDiConservazione = temperaturaDiConservazione;
	}
	
	@Override
	public boolean isDaFrigo() {
		return true;
	}

}
