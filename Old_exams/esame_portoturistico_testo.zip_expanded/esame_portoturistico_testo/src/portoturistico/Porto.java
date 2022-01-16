package portoturistico;

import java.util.*;
import java.io.*;

public class Porto {
	
	public static char[] alfabeto = "ABCDEFGHILMNOPQRSTUVZ".toCharArray();
	
	private TreeMap<Character,Banchina> banchine;
	private ArrayList<Barca> barche;
	private ArrayList<Pagamento> pagamenti;
	
	public Porto() {
		this.banchine = new TreeMap<Character,Banchina>();
		this.barche = new ArrayList<Barca>();
		this.pagamenti = new ArrayList<Pagamento>();
	}

	public Banchina nuovaBanchina(int numeroMassimoSpazi){
		int lunghezza = this.banchine.size();
		if (lunghezza > 26) {
			return null;
		}
		Banchina nuovaBanchina = new Banchina(alfabeto[lunghezza], numeroMassimoSpazi);
		this.banchine.put(alfabeto[lunghezza], nuovaBanchina);
		return nuovaBanchina;
	}

	public Spazio nuovoSpazio(char letteraBanchina, double lunghezza, double larghezza, String tipoSpazio){
		Banchina b = this.banchine.get(letteraBanchina);
		if (b == null || b.getNumeroMassimoSpazi() < b.getSpazi().size() + 1) {
			return null;
		}
		Spazio s = null;
		if (tipoSpazio.contentEquals("permanente")) {
			s = new SpazioPermanente(letteraBanchina, 100 + b.getSpazi().size(), lunghezza, larghezza);
			b.addSpazio(s);
		} else if (tipoSpazio.contentEquals("di passaggio")){
			s = new SpazioDiPassaggio(letteraBanchina, 100 + b.getSpazi().size(), lunghezza, larghezza);
			b.addSpazio(s);
		}
		return s;
	}

	public Spazio cercaSpazio(String codiceSpazio){
		Banchina b = this.banchine.get(codiceSpazio.charAt(0));
		int numeroSpazio = Integer.parseInt(codiceSpazio.substring(1));
		if (b == null || b.cercaSpazio(numeroSpazio) == null) {
			return null;
		} 
		return b.cercaSpazio(numeroSpazio);
	}

	public String elencoSpazi(){
		String res = "";
		for (char key: this.banchine.keySet()) {
			res += key + ":";
			for (Spazio s: this.banchine.get(key).getSpazi()) {
				res += s.getCodiceSpazio() + ",";
			}
			res = res.substring(0, res.length() - 1) + ";\n";
		}
		if (res.length() != 0) {
			res = res.substring(0, res.length() - 2) + ".";
		}
		return res;
	}

	public Barca nuovaBarca(String numeroImmatricolazione, String nome, double lunghezza, double larghezza){
		Barca b = this.cercaBarca(numeroImmatricolazione);
		if (b != null) {
			return b;
		}
		b = new Barca(numeroImmatricolazione, nome, lunghezza, larghezza);
		this.barche.add(b);
		return b;
	}
	
	public Barca cercaBarca(String numeroImmatricolazione) {
		for (Barca b: this.barche) {
			if (b.getNumeroImmatricolazione().contentEquals(numeroImmatricolazione)){
				return b;
			}
		}
		return null;
	}
	
	public Collection<Barca> elencoBarchePerNomeDimensione(){
		ArrayList<Barca> bs = new ArrayList<Barca>(this.barche);
		Collections.sort(bs, Barca.comparatorNomeDimensione);
		return bs;
	}
	
	public Collection<Barca> elencoBarchePerDimensioneNome(){
		ArrayList<Barca> bs = new ArrayList<Barca>(this.barche);
		Collections.sort(bs, Barca.comparatorDimensioneNome);
		return bs;
	}
	
	public void nuovoPagamento(String codiceSpazio, String data, double importo) throws EccezioneImporto{
		Spazio s = this.cercaSpazio(codiceSpazio);
		if (s == null) {
			return;
		}
		
		if (importo != s.getCosto()) {
			throw new EccezioneImporto();
		}
		
		Pagamento p = new Pagamento(s, data, importo);
		this.pagamenti.add(p);
	}

	public void ormeggia(String numeroImmatricolazione, String codiceSpazio, String data) throws EccezioneOrmeggio{
		Barca b = this.cercaBarca(numeroImmatricolazione);
		Spazio s = this.cercaSpazio(codiceSpazio);
		if (b == null || s == null || b.getLarghezza() > s.getLarghezza() || b.getLunghezza() > s.getLunghezza()) {
			throw new EccezioneOrmeggio();
		}
		if (s instanceof SpazioDiPassaggio){
			for (Pagamento p: this.pagamenti) {
				if (p.getSpazio().getCodiceSpazio().contentEquals(codiceSpazio) && p.getData().contentEquals(data)) {
					return;
				}
			}
			throw new EccezioneOrmeggio();
		} else if (s instanceof SpazioPermanente) {
			int trimestre = (Integer.parseInt(data.substring(4, 6)) - 1)/3;
			for (Pagamento p: this.pagamenti) {
				if (p.getSpazio().getCodiceSpazio().contentEquals(codiceSpazio) &&
						p.getAnno() == Integer.parseInt(data.substring(0, 4)) &&
						p.getTrimestre() == trimestre) {
					return;
				}
			}
			throw new EccezioneOrmeggio();
		}
	}
	
    public void leggiFile(String file) throws IOException{
    	File fileO = new File(file);
    	BufferedReader br = new BufferedReader(new FileReader(fileO));
    	
    	String row;
    	while ((row = br.readLine()) != null) {
    		String[] data = row.split(",");
    		switch (data[0].charAt(0)) {
    		case 'B':
    			this.nuovaBanchina(Integer.parseInt(data[1].trim()));
    			break;
    		case 'S':
    			this.nuovoSpazio(data[1].trim().charAt(0), Double.parseDouble(data[2].trim()), Double.parseDouble(data[3].trim()), data[4].trim());
    			break;
    		}
    	}
    	br.close();
    }		
	
}

