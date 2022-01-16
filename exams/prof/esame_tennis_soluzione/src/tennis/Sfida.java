package tennis;

import java.util.*;

public class Sfida implements Comparable<Sfida>{

	private Squadra squadraCasa;
	private Squadra squadraOspite;
	private String dataDa="";
	private String dataA="";
	private String luogo;
	
	private int numeroIncontri;
	
	private Map<Integer,Incontro> incontri = new TreeMap<Integer,Incontro>();
	
	public Sfida(Squadra squadraCasa, Squadra squadraOspite, int numeroIncontri){
		this.squadraCasa=squadraCasa;
		this.squadraOspite=squadraOspite;
		this.numeroIncontri=numeroIncontri;
	}

	public void setLuogo(String luogo){
		this.luogo=luogo;
	}
	
	public String getLuogo(){
		return luogo;
	}
	
	public void setDataDa(String dataDa){
			this.dataDa=dataDa;
	}

	public String getDataDa()
	{
		return dataDa;
	}

	public void setDataA(String dataA){
		this.dataA=dataA;
	}

	public String getDataA()
	{
		return dataA;
	}
	
	public Squadra getSquadraCasa(){
		return squadraCasa;
	}
	
	public Squadra getSquadraOspite(){
		return squadraOspite;
	}
	
	public void aggiungiIncontro(Incontro incontro){
		int nincontro = incontri.size()+1;
		incontri.put(nincontro, incontro);
	}
	
	public Collection<Incontro> elencoIncontri(){
		return incontri.values();
	}
	
	public Incontro getIncontro(int numIncontro){
		return incontri.get(numIncontro);
	}

	public String getPunteggio(){
		int casa=0;
		int ospite=0;
		for(int i=0;i<incontri.size();i++){
			if(incontri.get(i+1).getVincitore()!=null)
			{
				if(incontri.get(i+1).getVincitore().equals(squadraCasa))
					casa++;
				else
					ospite++;
			}
		}
		return ""+casa+"-"+ospite;
	}
	
	public Squadra getVincitore(){
		int casa=0;
		int ospite=0;

		for(int i=0;i<incontri.size();i++){
			if(incontri.get(i+1).getVincitore()!=null)
			{
			if(incontri.get(i+1).getVincitore().equals(squadraCasa))
				casa++;
			else
				ospite++;
			}
		}
		
		if(casa > numeroIncontri/2)
			return squadraCasa;
		else if(ospite > numeroIncontri/2)
			return squadraOspite;
		else 
			return null;
	}

	public int compareTo(Sfida altra) {

		if(this.dataDa.compareTo(altra.dataDa)!=0)
			return this.dataDa.compareTo(altra.dataDa);
		
		return this.squadraCasa.getNome().compareTo(altra.squadraCasa.getNome());
	}
	
}
