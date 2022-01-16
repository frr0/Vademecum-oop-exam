package agenziaviaggi;

public class PrenotazioneVolo extends Prenotazione{
	private String sigla;
	private String origine;
	private String destinazione;
	private String dataPartenza;
	private String dataArrivo;

	public PrenotazioneVolo(String sigla, String origine, String destinazione, String dataPartenza, String dataArrivo, double importo){
		super(importo);
		this.sigla = sigla;
		this.origine = origine;
		this.destinazione = destinazione;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
	}
	@Override
	public String getData() {
		return this.dataPartenza;
	}
	
	public String getSigla(){
		return this.sigla;
	}
	
	public String getOrigine(){
		return this.origine;
	}
	
	public String getDestinazione(){
		return this.destinazione;
	}
	
	public String getDataPartenza(){
		return this.dataPartenza;
	}
	
	public String getDataArrivo(){
		return this.dataArrivo;
	}
}
