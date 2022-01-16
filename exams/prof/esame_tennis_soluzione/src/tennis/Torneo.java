package tennis;

import java.util.*;

public class Torneo {

	private String nome;

	private Map<String,Squadra> squadre = new TreeMap<String,Squadra>();
	private Map<Integer,Turno> turni = new TreeMap<Integer,Turno>();
	private Map<String,Giocatore> giocatori = new TreeMap<String,Giocatore>();
	
	public Torneo(String nome, int numeroSquadre, int numeroIncontri, int alMeglioDiQuantiSet){
		
		this.nome=nome;

		int nturni = (int)( Math.log((double)numeroSquadre) / Math.log(2));
				
		for(int i=0;i<nturni;i++)
		{
			Turno ttemp = new Turno(i+1,numeroIncontri,alMeglioDiQuantiSet);
			turni.put(i+1, ttemp);
		}
	}
	
	public String getNome(){
		return nome;
	}
	
	public Squadra aggiungiSquadra(String nomeSquadra){
		Squadra stemp=null;
		if(!squadre.containsKey(nomeSquadra)){
			stemp=new Squadra(nomeSquadra);
			squadre.put(nomeSquadra, stemp);
		}
		else
			stemp=squadre.get(nomeSquadra);
		return stemp;
	}
	
	public Squadra getSquadra(String nomeSquadra){
		if(squadre.containsKey(nomeSquadra))
			return squadre.get(nomeSquadra);
		else
			return null;
	}

	public Collection<Squadra> elencoSquadre(){
		return squadre.values();
	}
	
	public Giocatore iscriviGiocatore(String nome, String cognome, String nomeSquadra){
		Squadra stemp = squadre.get(nomeSquadra);
		if(stemp!=null)
		{	
				Giocatore gtemp = new Giocatore(nome,cognome,stemp);
				giocatori.put(""+cognome+""+nome, gtemp);
				
				return gtemp;
		}
		else
			return null;
	}
	
	public Collection<Giocatore> elencoGiocatori(){
		Collection<Giocatore> result = new LinkedList<Giocatore>(giocatori.values());
		return result;
	}
	
	public Turno getTurno(int numeroTurno){
		return turni.get(numeroTurno);
	}

	public Collection<Turno> elencoTurni(){
		return turni.values();
	}
		
	public Sfida aggiungiSfida(int numeroTurno, String squadraCasa, String squadraOspite) {
		Squadra scasa = squadre.get(squadraCasa);
		if(scasa==null){
			scasa=new Squadra(squadraCasa);
			squadre.put(squadraCasa, scasa);
		}
			
		Squadra sospite = squadre.get(squadraOspite);
		if(sospite==null){
			sospite=new Squadra(squadraOspite);
			squadre.put(squadraOspite, sospite);
		}
		
		Turno ttemp = turni.get(numeroTurno);
		Sfida stemp = ttemp.aggiungiSfida(scasa, sospite);
		return stemp;
	}
	
	public Sfida getSfida(String unaSquadra, String altraSquadra){
		Sfida stemp;
		for(int i=0;i<turni.size();i++){
			Turno ttemp = turni.get(i+1);
			if((stemp=ttemp.getSfida(unaSquadra, altraSquadra))!=null)
				return stemp;
			if((stemp=ttemp.getSfida(altraSquadra, unaSquadra))!=null)
				return stemp;
		}
		return null;
	}

	public Collection<Sfida> elencoSfide(){
		List<Sfida> ltemp = new LinkedList<Sfida>();
		for(int i=0;i<turni.size();i++)
		{
			Turno ttemp = turni.get(i+1);
			ltemp.addAll(ttemp.elencoSfide());
		}
		Collections.sort(ltemp);
		return ltemp;
	}

	public Collection<Sfida> elencoSfide(int numeroTurno){
		Turno ttemp = turni.get(numeroTurno);
		List<Sfida> ltemp = new LinkedList<Sfida>(ttemp.elencoSfide());
		Collections.sort(ltemp);
		return ltemp;
		
	}
	
	public Incontro aggiungiIncontro(int numeroTurno, String squadraCasa, String squadraOspite, char tipo){
		Turno ttemp = turni.get(numeroTurno);
		return ttemp.aggiungiIncontro(squadraCasa, squadraOspite, tipo);
	}

}
