package palinsesti;

public class Palinsesto{

	String nome;
	String canale; 
	String da; 
	String a;

	Giorno arrayGiorni[];
	
	public 	int prossimo_id_programma = 1;
	
	public Palinsesto(String nome, String canale, String da, String a) {

		this.nome = nome;
		this.canale = canale;
		this.da = da;
		this.a = a;
		
		String daAnno = da.substring(0, 4);
		String aAnno = a.substring(0, 4);
		String daMese = da.substring(4, 6);
		String aMese = a.substring(4, 6);
		String daGiorno = da.substring(6, 8);
		String aGiorno = a.substring(6, 8);
		
		int diffMesi;
		if(Integer.parseInt(daAnno)!=Integer.parseInt(aAnno))
			diffMesi = 12-Integer.parseInt(daMese)+Integer.parseInt(aMese)-1;
		else
			diffMesi = Integer.parseInt(aMese)-Integer.parseInt(aMese);
			
		int diffGiorni;
		if(Integer.parseInt(daMese)!=Integer.parseInt(aMese))
			diffGiorni = 32-Integer.parseInt(daGiorno)+Integer.parseInt(aGiorno);
		else
			diffGiorni = Integer.parseInt(aGiorno)-Integer.parseInt(daGiorno)+1;
			
		
		int numGiorni = diffMesi*31+diffGiorni;
		
		//System.out.println("diffMesi: "+diffMesi+" diffGiorni:"+diffGiorni+" numGiorni: "+numGiorni);
		
		arrayGiorni = new Giorno[numGiorni];

		int aa = Integer.parseInt(daAnno);
		int mm = Integer.parseInt(daMese);
		int gg = Integer.parseInt(daGiorno);
		
		for(int i=0;i<numGiorni;i++)
		{
			String data = "";
			if(mm<10 && gg<10)
				data =aa+"0"+mm+"0"+gg;
			else if(mm<10 )
				data =aa+"0"+mm+""+gg;
			else if(gg<10 )
				data =aa+""+mm+"0"+gg;
			else
				data =aa+""+mm+""+gg;
				
			arrayGiorni[i] = new Giorno(data);
			gg++;
			if(gg==32) {
				gg=1;
				mm++;
			}
			if(mm==13) {
				mm=1;
				aa++;
			}
			
			//System.out.println(data);
		}
		
	}

	public String getNome() {
		return nome;
	}

	public String getCanale() {
		return canale;
	}

	public String getDa() {
		return da;
	}

	public String getA() {
		return a;
	}


	public void setDa(String da) {
		this.da=da;
	}

	public void setA(String a) {
		this.a=a;
	}

	private int convertiDataInIndice(String data){
		String daMese = da.substring(4, 6);
		String aMese = data.substring(4, 6);
		String daGiorno = da.substring(6, 8);
		String aGiorno = data.substring(6, 8);
		
		int diffMesi= Math.abs(Integer.parseInt(daMese)-Integer.parseInt(aMese))-1;
		int diffGiorni = 32-Integer.parseInt(daGiorno)+Integer.parseInt(aGiorno);

		int numGiorni = diffMesi*31+diffGiorni;

		return numGiorni;
	}

	private String convertiIndiceInData(int indice){

		String daAnno = da.substring(0, 4);
		String daMese = da.substring(4, 6);
		String daGiorno = da.substring(6, 8);

		int aa = Integer.parseInt(daAnno);
		int mm = Integer.parseInt(daMese);
		int gg = Integer.parseInt(daGiorno);
		

		String data = "";
		for(int i=0;i<=indice;i++) {
			if(mm<10 && gg<10)
				data =aa+"0"+mm+"0"+gg;
			else if(mm<10 )
				data =aa+"0"+mm+""+gg;
			else if(gg<10 )
				data =aa+""+mm+"0"+gg;
			else
				data =aa+""+mm+""+gg;
				
			gg++;
			if(gg==32) {
				gg=1;
				mm++;
			}
			if(mm==13) {
				mm=1;
				aa++;
			}	
		}
		
		return data;
	}

	
	public void definisciProgrammazioneSaltuaria(Programma programma, String data, String ora, int durata) {
		
		int indiceGiorno = convertiDataInIndice(data);
		arrayGiorni[indiceGiorno-1].programmazioni.add(new Programmazione(programma, ora, durata));
		
	}
	
	public void definisciProgrammazioneGiornaliera(Programma programma, String ora, int durata) {
		
		for(int i=0;i<arrayGiorni.length;i++)
			arrayGiorni[i].programmazioni.add(new Programmazione(programma, ora, durata));
			
	}
	
	
	public String stampaPalinsesto() {
		String risultato="";
		
		for(int i=0;i<arrayGiorni.length;i++) {
			Giorno g = arrayGiorni[i];
			if(g.programmazioni.size()!=0)
			{
				String data = convertiIndiceInData(i);
				for(Programmazione p : g.programmazioni) {
					
					Programma programma = p.programma;
					String nome = programma.getNome();
					String ora = p.ora;
					int durata = p.durata;

					if(risultato.length()!=0)
						risultato+="\n";
					
					risultato += " "+data+", "+ora+", "+nome+", "+durata;
				}
			}
		}
		
		return risultato;
	}
	
	
}
