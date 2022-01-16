package portoturistico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Porto {
	private Map<Integer, Banchina> banchine = new TreeMap<Integer, Banchina>();
	private Map<String, Spazio> spazi = new TreeMap<String, Spazio>();
	private Map<String, Barca> barche = new TreeMap<String, Barca>();
	
	private Integer lettera = 65;
	
	

	public Banchina nuovaBanchina(int numeroMassimoSpazi){
		if(lettera > 90){
			return null;
		}
		Banchina b = new Banchina(lettera, numeroMassimoSpazi);
		banchine.put(lettera, b);
		lettera++;

		return b;
	}

	public Spazio nuovoSpazio(char letteraBanchina, double lunghezza, double larghezza, String tipoSpazio){
      Spazio s = null;
      
		if(!banchine.containsKey((int)letteraBanchina)){
			return null;
		}
		Banchina b = banchine.get((int)letteraBanchina);
		String codiceSpazio = ""+letteraBanchina+b.codice; 
		if(b.getNumeroMassimoSpazi() == 0){
			return null;
		}
		if(tipoSpazio.toUpperCase().compareTo("PERMANENTE")==0){
		 s = new SpazioPermanente(codiceSpazio, lunghezza, larghezza);
		 spazi.put(codiceSpazio, s);
		 b.aggiungiSpazio(s);
		 b.decrementaSpazi();
		 b.codice++;
		}
		else if(tipoSpazio.toUpperCase().compareTo("DI PASSAGGIO")==0){
			 s = new SpazioDiPassaggio(codiceSpazio, lunghezza, larghezza);
			 spazi.put(codiceSpazio, s);
			 b.aggiungiSpazio(s);
			 b.decrementaSpazi();
			 b.codice++;
			}
		return s;
	}

	public Spazio cercaSpazio(String codiceSpazio){

		Spazio s = null;
		if(spazi.containsKey(codiceSpazio)){
			s = spazi.get(codiceSpazio);
		}
		return s;
	}

	public String elencoSpazi(){
		 List<Banchina> btemp = new LinkedList<Banchina>(banchine.values());
		String s = "";
		Collections.sort(btemp);
		for(Banchina b : btemp){
			s += b.getLetteraBanchina()+":";
			for(Spazio s1 : b.getSpazi()){
				s += s1.getCodiceSpazio()+",";
			}
			s = s.substring(0, s.length()-1)+";\n";
		}
		return s.substring(0, s.length()-2)+".";
	}

	public Barca nuovaBarca(String numeroImmatricolazione, String nome, double lunghezza, double larghezza){

		Barca b = null;
		if(barche.containsKey(numeroImmatricolazione)){
			b = barche.get(numeroImmatricolazione);
		}
		else{
			b = new Barca(numeroImmatricolazione, nome, lunghezza, larghezza);
			barche.put(numeroImmatricolazione, b);
		}
		return b;
	}
	
	public Collection<Barca> elencoBarchePerNomeDimensione(){
		List<Barca> btemp = new LinkedList<Barca>(barche.values());
		Collections.sort(btemp, new ComparatorePerNomeDimensione());
		return btemp;
	}
	
	public Collection<Barca> elencoBarchePerDimensioneNome(){
		List<Barca> btemp = new LinkedList<Barca>(barche.values());
		Collections.sort(btemp, new ComparatorePerDimensioneNome());
		return btemp;
	}
	
	public void nuovoPagamento(String codiceSpazio, String data, double importo) throws EccezioneImporto{
		if(!spazi.containsKey(codiceSpazio)){
			return;
		}if(importo != spazi.get(codiceSpazio).getCosto()){
			throw new EccezioneImporto();
		}
	}
	
	public void ormeggia(String numeroImmatricolazione, String codiceSpazio, String data) throws EccezioneOrmeggio{
		
	}
	
    public void leggiFile(String file) throws IOException  {
    	BufferedReader br = new BufferedReader(new FileReader(file)) ;
    	String line;
    	
    	while((line = br.readLine()) != null){
    		try{
    			 StringTokenizer st = new StringTokenizer(line, ",");
    			 String inizio = st.nextToken().trim();
    			 if(inizio.toUpperCase().equals("B")){
    				 String numero = st.nextToken().trim();
    				 
    				 Banchina b = nuovaBanchina(Integer.parseInt(numero));
    				 
    			 }
    			 else if(inizio.toUpperCase().equals("S")){
    				 String codice  = st.nextToken().trim();
    				 String lunghezza  = st.nextToken().trim();
    				 String larghezza  = st.nextToken().trim();
    				 String tipo  = st.nextToken().trim();
    				 
    				 Spazio s = nuovoSpazio(codice.charAt(0), Double.parseDouble(lunghezza), Double.parseDouble(larghezza), tipo);
    			 }
    			
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	br.close();
    }		
	
}

