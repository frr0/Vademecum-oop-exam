package didattica;

public class Lezione extends Blocco{

	public Lezione(Corso corso, Docente docente, String giorno, String orario) {
		super(corso, docente, giorno, orario);
	}

	public String descriviti() {
		String sp = " ";
		return super.descriviti() + " L " + giorno + sp + orario;
	}

}
