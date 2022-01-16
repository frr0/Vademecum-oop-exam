package supermercato;

public class ProdottoDaFrigo extends Prodotto{

	int temperaturaDiConservazione;

	public ProdottoDaFrigo(String codice, String nome, int volume) {
		super(codice, nome, volume);
	}
	
	public int getTemperaturaDiConservazione(){
		return temperaturaDiConservazione;
	}

	public void setTemperaturaDiConservazione(int temperaturaDiConservazione){
		this.temperaturaDiConservazione = temperaturaDiConservazione;
	}

}
