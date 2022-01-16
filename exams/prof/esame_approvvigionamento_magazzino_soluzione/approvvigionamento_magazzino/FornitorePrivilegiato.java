package approvvigionamento_magazzino;

public class FornitorePrivilegiato extends Fornitore{

	double percentualeSconto;
	
	public FornitorePrivilegiato(String codiceFornitore, String nome, double percentualeSconto) {
		super(codiceFornitore, nome);
		this.percentualeSconto = percentualeSconto;
	}

	public double getPercentualeSconto() {
		return percentualeSconto;
	}
	
	

}
