package treni;

public class Biglietto {
	
	private int numero;
	private Stazione stazionePartenza;
	private Stazione stazioneArrivo;
	private String data;
	private Treno treno;
	private double prezzo;
	
	

	public Biglietto(int numero, Stazione stazionePartenza, Stazione stazioneArrivo, String data, Treno treno) {
		this.numero = numero;
		this.stazionePartenza = stazionePartenza;
		this.stazioneArrivo = stazioneArrivo;
		this.data = data;
		this.treno = treno;
	}

	public int getNumeroBiglietto() {
		return this.numero;
	}

	public String getNomeStazionePartenza() {
		return this.stazionePartenza.getNome();
	}

	public String getNomeStazioneArrivo() {
		return this.stazioneArrivo.getNome();
	}
	
	public String getData(){
		return this.data;
	}

	public int getNumeroTreno() {
		return this.treno.getNumero();
	}
	
	public String getTipologiaTreno() {
		return this.treno.getTipologia();
	}

	public double getPrezzo() {
		double km1 = this.stazionePartenza.getChilometroNumero();
		double km2 = this.stazioneArrivo.getChilometroNumero();
		
		double totKm = Math.abs(km1 - km2);
		
		if (this.treno.tipologia.contentEquals("AV")) {
			return totKm * 0.3;
		}
		return totKm * 0.15;
	}
}
