package palinsesti;

public class SerieTv extends Programma{

	int anno;
	int numeroEpisodio;
	
	public SerieTv(String id, Palinsesto palinsesto, String nome) {
		super(id, palinsesto, nome);
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setNumeroEpisodio(int numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}
	
	public int getAnno() {
		return anno;
	}
	
	public int getNumeroEpisodio() {
		return numeroEpisodio;
	}
}
