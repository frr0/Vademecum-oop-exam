package tennis;

public class Singolo extends Incontro{

	public Singolo(Squadra squadraCasa, Squadra squadraOspite, int alMeglioDiQuantiSet) {
		super(squadraCasa, squadraOspite, alMeglioDiQuantiSet);
	}

	public void aggiungiGiocatore(Giocatore giocatore) throws TroppiGiocatoriException {
		if(super.elencoGiocatori().size()==2)
			throw new TroppiGiocatoriException();
		else
			super.elencoGiocatori().add(giocatore);
	}

}
