package palinsesti;

import java.util.*;
import java.io.*;

public class GestionePalinsesti {
	
	TreeMap<String,Programma> mappaProgrammi = new TreeMap<String,Programma>();

	LinkedList<Palinsesto> listaPalinsesti = new LinkedList<Palinsesto>();
	TreeMap<String, Palinsesto> mappaPalinsesti = new TreeMap<String, Palinsesto>();
	
	public Palinsesto definisciPalinsesto(String nome, String canale, String da, String a) {
		
		Palinsesto ptemp;
		
		if(!mappaPalinsesti.containsKey(""+nome+""+canale)) {
			ptemp = new Palinsesto(nome,canale,da,a);
			mappaPalinsesti.put(""+nome+""+canale, ptemp);
			listaPalinsesti.add(ptemp);
			return ptemp;
		}
		else
		{
			mappaPalinsesti.get(""+nome+""+canale).setDa(da);
			mappaPalinsesti.get(""+nome+""+canale).setA(a);
			for(Palinsesto p : listaPalinsesti) {
				if(p.getNome().compareTo(nome)==0 && p.getCanale().compareTo(canale)==0) {
					p.setDa(da);
					p.setA(a);
					return p;
				
				}
			}
				
		
		}

		return null;
	}
	
	public Collection<Palinsesto> elencoPalinsesti() {

		return listaPalinsesti;

	}
	
	public Palinsesto cercaPalinsesto(String nome, String canale) {

		return mappaPalinsesti.get(""+nome+""+canale);

	}

	
	public Collection<Palinsesto> cercaPalinsesti(String daCercare) {

		LinkedList<Palinsesto> risultato = new LinkedList<Palinsesto>();
		
		for(Palinsesto p : listaPalinsesti)
		{
			if(p.getNome().contains(daCercare) || p.getCanale().contains(daCercare))
				risultato.add(p);
		}
		return risultato;

	}	

	
	
	public String definisciProgramma(String nomePalinsesto, String canale, String nomeProgramma, String tipo) throws PalinsestoInesistenteException{
		Palinsesto pa = this.cercaPalinsesto(nomePalinsesto, canale);
		if(pa==null)
			throw new PalinsestoInesistenteException();

		String id = ""+nomePalinsesto.charAt(0)+""+canale.charAt(0)+""+pa.prossimo_id_programma;
		pa.prossimo_id_programma++;


		Programma pr = null;
		if(tipo.compareTo("Partita di calcio")==0)
			pr = new PartitaCalcio(id, pa, nomeProgramma);
		else if(tipo.compareTo("Serie TV")==0)
			pr = new SerieTv(id, pa, nomeProgramma);
		else
			pr = new Programma(id, pa, nomeProgramma);

		mappaProgrammi.put(id, pr);

		return id;

	}
	
	public Programma cercaProgramma(String id) {
		return mappaProgrammi.get(id);
	}
	
	public Collection<Programma> elencoProgrammi(){
		
		LinkedList<Programma> listaProgrammi = new LinkedList<Programma>(mappaProgrammi.values());
		Collections.sort(listaProgrammi);
		return listaProgrammi;
	}
	
	
	
	public void definisciProgrammazioneSaltuaria(String id, String data, String ora, int durata) throws ProgrammaInesistenteException {

		Programma pr = mappaProgrammi.get(id);
		if(pr==null)
			throw new ProgrammaInesistenteException();
		
		Palinsesto pa = pr.palinsesto;
		
		pa.definisciProgrammazioneSaltuaria(pr, data, ora, durata);
		
	}

	
	public void definisciProgrammazioneGiornaliera(String id, String ora, int durata) throws ProgrammaInesistenteException {
		Programma pr = mappaProgrammi.get(id);
		if(pr==null)
			throw new ProgrammaInesistenteException();

		Palinsesto pa = pr.palinsesto;
		
		pa.definisciProgrammazioneGiornaliera(pr, ora, durata);

	}
	
	
	public String stampaPalinsesto(String nome, String canale) {
		Palinsesto pa = this.cercaPalinsesto(nome, canale);
		return pa.stampaPalinsesto();
	}
	
	

	
    public void leggi(String file) {
    	
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String riga;
			while((riga=br.readLine())!=null){

				StringTokenizer st = new StringTokenizer(riga, ";"); 
				
				try{ 
					
					String type = st.nextToken(); 
					
					if(type.compareTo("PA")==0){
						
						String nome = st.nextToken(); 
						String canale = st.nextToken(); 
						String da = st.nextToken(); 
						String a = st.nextToken(); 

						this.definisciPalinsesto(nome, canale, da, a);
						
					}
					else if(type.compareTo("PR")==0){
						
						String nomePalinsesto = st.nextToken(); 
						String canale = st.nextToken(); 
						String nomeProgramma = st.nextToken(); 
						String tipo = st.nextToken(); 

						this.definisciProgramma(nomePalinsesto, canale, nomeProgramma, tipo);
					}
				}
				catch(Exception nfe){
					System.out.println("Eccezione nella gestione di una riga!");
					//nfe.printStackTrace();
				}
			}
			
			br.close();
    	} catch (Exception e) {
			System.out.println("Eccezione generica!");
			//e.printStackTrace();
		}
    }
}
