package didattica;

public class Esercitazione extends Blocco {
	private int numeroSquadra;
	

	public Esercitazione(Corso corso, Docente docente, String giorno, String orario, int numeroSquadra) {
		super(corso, docente, giorno, orario);
		this.numeroSquadra = numeroSquadra;
	}


	public String descriviti() {
		String sp = " ";
		return super.descriviti() + " EL " + numeroSquadra + "/" + corso.getNumeroSquadre() + sp + giorno + sp + orario;
	}

}
