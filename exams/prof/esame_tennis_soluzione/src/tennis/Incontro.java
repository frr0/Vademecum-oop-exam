package tennis;

import java.util.*;

public class Incontro {

	private String data;
	private String ora;
	private String punteggio="";
	
	private List<Giocatore> giocatori = new LinkedList<Giocatore>();
	
	private int alMeglioDiQuantiSet;
	private Squadra squadraCasa;
	private Squadra squadraOspite;
	
	public Incontro(Squadra squadraCasa, Squadra squadraOspite, int alMeglioDiQuantiSet){
		this.squadraCasa=squadraCasa;
	    this.squadraOspite=squadraOspite;
		this.alMeglioDiQuantiSet=alMeglioDiQuantiSet;	
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getOra() {
		return ora;
	}

	public void aggiungiGiocatore(Giocatore giocatore) throws TroppiGiocatoriException{
		
	}

	public void setPunteggio(String punteggio){
		this.punteggio=punteggio;
	}
	
	public String getPunteggio(){
		return punteggio;
	}
	
	public Collection<Giocatore> elencoGiocatori(){
		return giocatori;
	}
	
	public Squadra getVincitore(){

		int punteggiSquadraCasa[] = new int[5];
		int punteggiSquadraOspite[] = new int [5];

		for (int i=0; i<alMeglioDiQuantiSet;i++){
			punteggiSquadraCasa[i]=0;
			punteggiSquadraOspite[i]=0;
		}

		String[] set = punteggio.split(" ");
		for(int i=0;i<set.length;i++){
			String[] giochi = set[i].split("-");
			try{ 
				punteggiSquadraCasa[i]= Integer.parseInt(giochi[0]);
				punteggiSquadraOspite[i]= Integer.parseInt(giochi[1]);
			}
			catch (Exception e){
				
			}
		}
		
		int casa=0;
		int ospite=0;

		for(int i=0;i<alMeglioDiQuantiSet;i++){
			if(punteggiSquadraCasa[i]>punteggiSquadraOspite[i] && (punteggiSquadraCasa[i]==6 || punteggiSquadraCasa[i]==7))
				casa++;
			else if(punteggiSquadraCasa[i]<punteggiSquadraOspite[i] && (punteggiSquadraOspite[i]==6 || punteggiSquadraOspite[i]==7))
				ospite++;
		}

		if(casa>alMeglioDiQuantiSet/2)
			return squadraCasa;
		else if(ospite>alMeglioDiQuantiSet/2)
			return squadraOspite;
		else 
			return null;
	}

}
