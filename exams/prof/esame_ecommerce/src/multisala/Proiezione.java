package multisala;

public class Proiezione {

	private Sala sala;
	private Film film;
	private String data;
	private String ora;
	private double prezzoIntero;
	private boolean in3D;
	
	private int postiLiberi;
	private Biglietto mappa[][];
	
	public Proiezione(Sala sala, Film film, String data, String ora, double prezzoIntero, boolean in3D){
		this.sala = sala;
		this.film = film;
		this.data = data;
		this.ora = ora;
		this.prezzoIntero=prezzoIntero;
		this.in3D = in3D;
		
		mappa = new Biglietto[sala.getNumeroFile()][sala.getNumeroPostiPerFila()];
		postiLiberi = sala.getNumeroFile() * sala.getNumeroPostiPerFila();
	}

	public Film getFilm() {
		return film;
	}

	public Sala getSala() {
		return sala;
	}

	public String getData() {
		return data;
	}

	public String getOra() {
		return ora;
	}

	public double getPrezzoIntero() {
		return prezzoIntero;
	}

	public boolean isIn3D() {
		return in3D;
	}
	
	public int postiLiberi(){
		return postiLiberi;
	}

	public String situazione(){
		String risultato="";
		for(int f = 0; f < sala.getNumeroFile(); f++)
		{
			risultato=risultato+" "; 		// carattere ' ' iniziale
			for(int p = 0; p < sala.getNumeroPostiPerFila(); p++)
			{
				if(mappa[f][p]==null)
				  risultato=risultato+"_";
				else
	     		  risultato=risultato+"#";
			}
			if(f<sala.getNumeroFile()-1) 	// per non stampare il \n finale
				risultato=risultato+"\n";
		}
		return risultato;
	}

	public double calcolaIncassoInData(){
		double incasso = 0;
		for (int f =0; f<sala.getNumeroFile();f++)
			for(int p=0; p<sala.getNumeroPostiPerFila();p++){
				Biglietto tempBiglietto = this.getBiglietto(f, p);
				if(tempBiglietto!=null)
				{
					if (tempBiglietto instanceof BigliettoScontato)
						incasso +=this.prezzoIntero - (this.prezzoIntero*((double)((BigliettoScontato)tempBiglietto).getPercentualeSconto()))/100.0;
					else{
						incasso +=this.prezzoIntero;
					}
				}
			}
		return incasso;
	}

	public Biglietto getBiglietto(int fila, int posto){
		return mappa[fila][posto];
	}

	public void setBiglietto(int fila, int posto, Biglietto biglietto){
		mappa[fila][posto] = biglietto;
		this.postiLiberi--;
	}
}
