package tennis;

import java.util.*;

public class Turno {

	private int numeroTurno;

	private int numeroIncontri;
	private int alMeglioDiQuantiSet;
	
	private Map<String,Sfida> sfide = new HashMap<String,Sfida>();
	
	public Turno(int numeroTurno, int numeroIncontri, int alMeglioDiQuantiSet)
	{
		this.numeroTurno=numeroTurno;
		this.numeroIncontri=numeroIncontri;
		this.alMeglioDiQuantiSet=alMeglioDiQuantiSet;
	}
	
	public int getNumeroTurno()
	{
		return numeroTurno;
	}
	
	public Sfida aggiungiSfida(Squadra squadraCasa, Squadra squadraOspite) {
		
		Sfida stemp= new Sfida(squadraCasa,squadraOspite, numeroIncontri);
		sfide.put(squadraCasa.getNome()+"-"+squadraOspite.getNome(),stemp);
		return stemp;
	}
	
	public Collection<Sfida> elencoSfide(){
		return sfide.values();
	}

	public Sfida getSfida(String squadraCasa, String squadraOspite){
		return sfide.get(squadraCasa+"-"+squadraOspite);
	}

	public Incontro aggiungiIncontro(String squadraCasa, String squadraOspite, char tipo){
		Sfida stemp=sfide.get(squadraCasa+"-"+squadraOspite);
		Incontro itemp=null;
		if(tipo=='s'){
			itemp=new Singolo(stemp.getSquadraCasa(),stemp.getSquadraOspite(),alMeglioDiQuantiSet);
		}
		else if(tipo=='d')
		{
			itemp=new Doppio(stemp.getSquadraCasa(),stemp.getSquadraOspite(),alMeglioDiQuantiSet);
		}
		stemp.aggiungiIncontro(itemp);
		return itemp;
	}
	
}
