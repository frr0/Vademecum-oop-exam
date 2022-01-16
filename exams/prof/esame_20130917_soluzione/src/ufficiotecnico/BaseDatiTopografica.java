package ufficiotecnico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BaseDatiTopografica {

	private static int nuovoCodiceStrada = 1;
	private static int nuovoCodicePiazza = 10001;
	
	private Map<Integer,ElementoTopografico> mappaElementiTopografici = new HashMap<Integer,ElementoTopografico>();
	private Map<Integer,Strada> mappaStrade = new HashMap<Integer,Strada>();
	private Map<Integer,Piazza> mappaPiazze = new HashMap<Integer,Piazza>();
	private List<Incrocio> incroci = new LinkedList<Incrocio>();

	
	public ElementoTopografico aggiungiElementoTopografico(String tipologia){
			
		String stringaStrada="STRADA";
		String stringaPiazza="PIAZZA";
		
		ElementoTopografico etemp=null;
		
		if(tipologia.toUpperCase().compareTo(stringaStrada)==0){
			etemp=new Strada();
			etemp.setCodice(nuovoCodiceStrada);
			mappaElementiTopografici.put(nuovoCodiceStrada, etemp);
			mappaStrade.put(nuovoCodiceStrada, (Strada)etemp);
			nuovoCodiceStrada++;
		}
		else if(tipologia.toUpperCase().compareTo(stringaPiazza)==0){
			etemp=new Piazza();	
			etemp.setCodice(nuovoCodicePiazza);
			mappaElementiTopografici.put(nuovoCodicePiazza, etemp);
			mappaPiazze.put(nuovoCodicePiazza, (Piazza)etemp);
			nuovoCodicePiazza++;
		}
		
		return etemp;
	}
	
	public Collection<ElementoTopografico> elencoElementiTopografici(){

		LinkedList<ElementoTopografico> ltemp = new LinkedList<ElementoTopografico>(mappaElementiTopografici.values());
		Collections.sort(ltemp, new ComparatoreDiElementiTopografici());
		return ltemp;
	}
	
	public Collection<Piazza> elencoPiazze(){

		LinkedList<Piazza> ltemp = new LinkedList<Piazza>(mappaPiazze.values());
		Collections.sort(ltemp, new ComparatoreDiPiazze());
		return ltemp;
	}

	public Collection<Strada> elencoStradePerNome(){

		LinkedList<Strada> ltemp = new LinkedList<Strada>(mappaStrade.values());
		Collections.sort(ltemp, new ComparatoreDiStradePerNome());
		return ltemp;
	}
	
	public Collection<Strada> elencoStradePerLunghezza(){

		LinkedList<Strada> ltemp = new LinkedList<Strada>(mappaStrade.values());
		Collections.sort(ltemp, new ComparatoreDiStradePerLunghezza());
		return ltemp;
	}
	
	public ElementoTopografico cercaElementoTopografico(int codice) throws EccezioneElementoTopograficoInesistente{
		
		
		if(mappaElementiTopografici.containsKey(codice))
			return mappaElementiTopografici.get(codice);
		else 
			throw new EccezioneElementoTopograficoInesistente();
	}
	
	public Collection<Monumento> elencoMonumenti(int codicePiazza) throws EccezioneElementoTopograficoInesistente{

		if(mappaPiazze.containsKey(codicePiazza)){
			Piazza ptemp = mappaPiazze.get(codicePiazza);
			List<Monumento> ltemp = new LinkedList<Monumento> (ptemp.elencoMonumenti());
			Collections.sort(ltemp);
			return ltemp;
		}
		else
			throw new EccezioneElementoTopograficoInesistente();
	}

	public double estensionePiazze(){
		
		double totale=0;
		Piazza ptemp;
		List<Piazza> ltemp = new LinkedList<Piazza>(mappaPiazze.values());
		
		for(int i=0;i<ltemp.size();i++){
			ptemp=ltemp.get(i);
			totale+=ptemp.getEstensione();
		}
		return totale;
	}
	
	public void definisciIncrocio(int codiceA, int codiceB, boolean semafori) throws EccezioneElementoTopograficoInesistente, EccezioneIncrocioImpossibile{
		
		ElementoTopografico a = null;
		ElementoTopografico b = null;
		
		if(!mappaElementiTopografici.containsKey(codiceA))
			throw new EccezioneElementoTopograficoInesistente();
		else
		    a = mappaElementiTopografici.get(codiceA);
		
		if(!mappaElementiTopografici.containsKey(codiceB))
			throw new EccezioneElementoTopograficoInesistente();
		else
		    b = mappaElementiTopografici.get(codiceB);
		
		if((a instanceof Piazza) && (b instanceof Piazza))
			throw new EccezioneIncrocioImpossibile();
		else
		{
			Incrocio itemp = new Incrocio(a,b,semafori);
			incroci.add(itemp);
		}

	}
	
	public boolean eliminaIncrocio(int codiceA, int codiceB) throws EccezioneElementoTopograficoInesistente{

		boolean eliminato=false;

		
		if(!mappaElementiTopografici.containsKey(codiceA))
			throw new EccezioneElementoTopograficoInesistente();
		if(!mappaElementiTopografici.containsKey(codiceB))
			throw new EccezioneElementoTopograficoInesistente();

		
		for(int i=0;i<incroci.size();i++)
		{
			Incrocio itemp = incroci.get(i);
			if((itemp.getA().getCodice()==codiceA && itemp.getB().getCodice()==codiceB) || (itemp.getB().getCodice()==codiceA && itemp.getA().getCodice()==codiceB))
			{
				incroci.remove(itemp);
				eliminato=true;
			}
		}
		return eliminato;
	}
	
	public Collection<ElementoTopografico> elencoIncroci(int codice) throws EccezioneElementoTopograficoInesistente{
		
		List<ElementoTopografico> strade = new LinkedList<ElementoTopografico>();
		List<ElementoTopografico> piazze = new LinkedList<ElementoTopografico>();
		List<ElementoTopografico> tutte = new LinkedList<ElementoTopografico>();
		
		if(!mappaElementiTopografici.containsKey(codice))
			throw new EccezioneElementoTopograficoInesistente();
		else 
		{
			for(int i=0;i<incroci.size();i++)
			{
				Incrocio itemp = incroci.get(i);
				if(itemp.getA().getCodice()==codice)
				{
					if(itemp.getB() instanceof Strada)
						strade.add(itemp.getB());
					if(itemp.getB() instanceof Piazza)
						piazze.add(itemp.getB());
				}
				if(itemp.getB().getCodice()==codice)
				{
					if(itemp.getA() instanceof Strada)
						strade.add(itemp.getA());
					if(itemp.getA() instanceof Piazza)
						piazze.add(itemp.getA());
				}
			}

			Collections.sort(strade, new ComparatoreDiElementiTopografici());
			Collections.sort(piazze, new ComparatoreDiElementiTopografici());
			tutte.addAll(strade);
			tutte.addAll(piazze);
			return tutte;
		}
	}
	
	public void leggi(String nomeFile) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		String linea;

		String nome=null;
		String lunghezza=null;
		String forma=null;
		String estensione=null;
		String codiceA = null;
		String codiceB = null;
		String semafori=null;
		
		
		while ((linea = in.readLine()) != null) {
			
			try {
			    StringTokenizer st = new StringTokenizer(linea, ";");
			    String iniziale = st.nextToken().trim();
			    if (iniziale.compareTo("strada")==0) 
			    {
			       nome = st.nextToken().trim();
			       lunghezza = st.nextToken().trim();
			       Strada stemp = (Strada)this.aggiungiElementoTopografico("STRADA");
			       stemp.setNome(nome);
			       stemp.setLunghezza(Integer.parseInt(lunghezza));
			    } 
			    else if (iniziale.compareTo("piazza")==0) 
			    {
				   nome = st.nextToken().trim();
				   forma = st.nextToken().trim();
				   estensione = st.nextToken().trim();
				   Piazza ptemp = (Piazza)this.aggiungiElementoTopografico("PIAZZA");
				   ptemp.setNome(nome);
				   ptemp.setForma(forma);
				   ptemp.setEstensione(Double.parseDouble(estensione));
			    }
			    else if (iniziale.compareTo("incrocio")==0) 
			    {
				   codiceA = st.nextToken().trim();
				   codiceB = st.nextToken().trim();
				   semafori = st.nextToken().trim();
				   
				   this.definisciIncrocio(Integer.parseInt(codiceA), Integer.parseInt(codiceB), Boolean.parseBoolean(semafori));
			    }
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		in.close();
	}	
}



