package casaeditrice;

public class Rivista extends Pubblicazione{
	private String isbn;


	public Rivista(String titolo, String volume, int anno, Autore proprietario, int contributoProprietario) {
		super(titolo, volume, anno, proprietario, contributoProprietario);
		// TODO Auto-generated constructor stub
	}


	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	
}
