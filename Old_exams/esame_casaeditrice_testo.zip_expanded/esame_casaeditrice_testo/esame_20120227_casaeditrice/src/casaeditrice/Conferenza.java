package casaeditrice;

public class Conferenza extends Pubblicazione{
	private String luogo;






	public Conferenza(String titolo, String volume, int anno, Autore proprietario, int contributoProprietario) {
		super(titolo, volume, anno, proprietario, contributoProprietario);
		// TODO Auto-generated constructor stub
	}






	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
}
