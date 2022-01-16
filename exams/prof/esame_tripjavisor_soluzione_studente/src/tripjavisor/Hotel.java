package tripjavisor;

public class Hotel implements Comparable<Hotel>{
	
	private int codice;
	private String nome;
	private String indirizzo;
	private String citta;
	private int numCamere;
	private double sommaVoti=0.0;
	private int numVoti=0;

	public Hotel(int codice, String nome, String indirizzo, String citta, int numCamere) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.numCamere = numCamere;
	}

	public int getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public int getNumCamere() {
		return numCamere;
	}

	public double mediaVoti() {
		if(numVoti>0)
			return (double) (sommaVoti/numVoti);
		return 0.0;
	}

	public void aggiornaVoto(double votoVecchio, double votoNuovo) {
		sommaVoti=sommaVoti+votoNuovo-votoVecchio;
	}

	public void aggiungiVoto(double voto) {
		sommaVoti+=voto;
		numVoti++;
	}

	public int compareTo(Hotel h) {
		return -(int) ((this.mediaVoti()*1000)-(h.mediaVoti()*1000));
	}
}
