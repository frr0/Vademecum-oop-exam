package agenziaviaggi;

public class PrenotazioneAlbergo extends Prenotazione{
	private String hotel;
	private String dataCheckIn;
	private int numNotti;

	public PrenotazioneAlbergo(String hotel, String dataCheckIn, int numNotti, double importo){
		super(importo);
		this.hotel = hotel;
		this.dataCheckIn = dataCheckIn;
		this.numNotti = numNotti;
	}
	
	@Override
	public String getData() {
		return this.dataCheckIn;
	}
	
	public String getHotel(){
		return this.hotel;
	}
	
	public String getDataCheckIn(){
		return this.dataCheckIn;
	}
	
	public int getNumNotti(){
		return this.numNotti;
	}
}
