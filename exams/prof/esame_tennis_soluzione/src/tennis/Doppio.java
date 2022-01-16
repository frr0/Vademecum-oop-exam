package tennis;

public class Doppio extends Incontro {

	public Doppio(Squadra squadraCasa, Squadra squadraOspite, int alMeglioDiQuantiSet) {
		super(squadraCasa, squadraOspite, alMeglioDiQuantiSet);
	}

	public void aggiungiGiocatore(Giocatore giocatore) throws TroppiGiocatoriException {
		if(super.elencoGiocatori().size()==4)
			throw new TroppiGiocatoriException();
		else
			super.elencoGiocatori().add(giocatore);
	}

}
