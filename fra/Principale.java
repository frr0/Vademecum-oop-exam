package perFra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;



public class Principale {
	
	
	List<Macchina> elencoMacchine=new ArrayList<>();
	
	
	
	

	public Macchina addMacchina(String nome,int cod) {
		elencoMacchine.add(new Macchina(nome, cod));
		
		return null;

	}
	
	public Collection<Macchina> ordinaElenco(){
		elencoMacchine.sort(new Comparator<Macchina>() {

			@Override
			public int compare(Macchina o1, Macchina o2) {
				if(o1.nome.compareTo(o2.nome)>0)return 1;
				if(o1.nome.compareTo(o2.nome)<0)return -1;
				return 0;
				
				
			}

			

			
			
		});
		
		return elencoMacchine;
		
	}
	
	public Collection<Macchina> ordinaElencoLambda(){
		elencoMacchine.sort((o1,o2)->o1.getNome().compareTo(o2.getNome()));
		
		return elencoMacchine;
		
	}

	public Collection<Macchina> ordinaElencoReversed(){
		elencoMacchine.sort(Comparator.comparing(Macchina::getNome).reversed().thenComparing(Macchina::getCodice));
		
		return elencoMacchine;
	
	

}
	
}
