package didattica;

public class Blocco {
	protected Corso corso;
	protected Docente docente;
	protected String giorno;
	protected String orario;
	

	public Blocco(Corso corso, Docente docente, String giorno, String orario) {
		this.corso = corso;
		this.docente = docente;
		this.giorno = giorno;
		this.orario = orario;
	}
	
	public Corso getCorso() {
		return corso;
	}




	public Docente getDocente() {
		return docente;
	}




	public String getGiorno() {
		return giorno;
	}




	public String getOrario() {
		return orario;
	}




	public String descriviti() {
		String sp = " ";
		return corso.getCodice() + sp + corso.getNome() + sp + docente.getCodice() + sp + docente.getCognome();
	}
}