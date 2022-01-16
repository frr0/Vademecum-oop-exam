package condomini;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GestioneCondomini {
	
	TreeMap<String, Condominio> mappaCondomini = new TreeMap<String, Condominio>();
	

	public Condominio aggiungiCondominio(String indirizzo, int numeroCivico, double saldo){
		
		String codice = "";
		String[] ar = indirizzo.split(" ");
		for(int i=1; i<ar.length; i++)
		{
			codice += ar[i].toUpperCase()+"";
		}
		codice += ""+numeroCivico;
		if(this.mappaCondomini.get(codice)!=null)
			return this.mappaCondomini.get(codice);
		else
		{
			Condominio c = new Condominio(codice, indirizzo, numeroCivico, saldo);
			this.mappaCondomini.put(codice, c);
			return c;
		}
		
	}
	
	public Condominio cercaCondominio(String codiceCondominio){
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);
		
		return c;
	}

	public Condominio cercaCondominioPerIndirizzo(String codiceCondominio){
		
		for(Condominio c: this.mappaCondomini.values())
		{
			if(c.getIndirizzo().contains(codiceCondominio))
			{
				return c;
			}
		}
		
		
		return null;
	}

	public Proprietario aggiungiProprietario(String codiceCondominio, String cognome, String nome, int interno, double millesimi, double debito) 
			throws MillesimiSuperatiException{
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);
		if(c.millesimiTotali+millesimi>1000)
		{
			throw new MillesimiSuperatiException();
		}
		else{
			
			int flag=0;
			Proprietario p = new Proprietario(c, cognome, nome, interno, millesimi, debito);
			for(Proprietario pp: c.listaProprietari)
			{
				if(pp.getInterno()==interno)
				{
					flag=1;
					c.listaProprietari.remove(pp);
					c.listaProprietari.add(p);
				}
			}
			if(flag==0)
			{
				c.listaProprietari.add(p);
				c.millesimiTotali += millesimi;
			}
			return p;
			
		}
		
	}
	
	public Spesa aggiungiSpesa(String codiceCondominio, String descrizione, double importo, String data, boolean pagata,
			double percentualeAmministratore){
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);
		Spesa s = null;
		if(percentualeAmministratore!=0)
			s = new SpesaStraordinaria(c, descrizione, importo, data, pagata, percentualeAmministratore);
		else
			s = new Spesa(c, descrizione, importo, data, pagata);
		if(pagata)
		{
			c.setSaldo(c.getSaldo()-s.getImporto()-s.getImporto()*percentualeAmministratore/100);
			s.pagata=true;
			c.listaSpese.add(s);
			return s;
		}
		else{
			s = new Spesa(c, descrizione, importo, data, pagata);
			c.listaSpese.add(s);
			return s;
		}
		
	}
	
	public void pagaSpese(String codiceCondominio, String da, String a){
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);
		
		for(Spesa s: c.listaSpese)
		{
			if(s.getData().compareTo(da)>=0 && s.getData().compareTo(a)<=0)
			{
				if(s.pagata==false)
				{
					if(s instanceof SpesaStraordinaria)
					{
						c.setSaldo(c.getSaldo()-s.getImporto()-s.getImporto()*((SpesaStraordinaria)s).getPercentualeAmministratore()/100);
						s.pagata = true;
					}
					else{
						c.setSaldo(c.getSaldo()-s.getImporto());
						s.pagata = true;
					}
				}
			}
		}
		
		
	} 
	
	public void pagaSpese(String codiceCondominio){
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);
		
		for(Spesa s: c.listaSpese)
		{
			if(s.pagata==false)
			{
				if(s instanceof SpesaStraordinaria)
				{
					c.setSaldo(c.getSaldo()-s.getImporto()-s.getImporto()*((SpesaStraordinaria)s).getPercentualeAmministratore()/100);
					s.pagata = true;
				}
				else{
					c.setSaldo(c.getSaldo()-s.getImporto());
					s.pagata = true;
				}
			}
		}
	} 
	
	public void calcolaDovutoProprietari(String codiceCondominio){
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);
		
		double totaleSpese = 0;
		
		for(Spesa s: c.listaSpese)
		{
			if(s instanceof SpesaStraordinaria)
			{
				totaleSpese += s.getImporto() + s.getImporto()*((SpesaStraordinaria)s).getPercentualeAmministratore()/100;
			}
			else
			{
				totaleSpese += s.getImporto();
			}
		}
		
		for(Proprietario p: c.listaProprietari)
		{
			p.setDebito(p.getDebito()+ totaleSpese*p.getMillesimi()/1000);
		}
		
		
		
		
	}
	
	public void saldaDebito(String codiceCondominio, String cognomeProprietario, String nomeProprietario, double versato) {
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);

		for(Proprietario p: c.listaProprietari)
		{
			if(p.getCognome().compareTo(cognomeProprietario)==0 && p.getNome().compareTo(nomeProprietario)==0)
			{
				p.setDebito(p.getDebito()-versato);
				c.setSaldo(c.getSaldo()+versato);
			}
		}
		
	}

	public Collection<Proprietario> elencoProprietariMorosi(String codiceCondominio) {
		
		Condominio c = this.mappaCondomini.get(codiceCondominio);

		List<Proprietario> proprietariMorosi = new LinkedList<Proprietario>();
		
		for(Proprietario p: c.listaProprietari)
		{
			if(p.getDebito()>0)
			{
				proprietariMorosi.add(p);
			}
		}
		
		return proprietariMorosi;
	}
	
	public void leggiFile(String nomeFile) throws IOException {
				BufferedReader in = new BufferedReader(new FileReader(nomeFile));
				
				String line; 
				
				while ((line = in.readLine()) != null){
					
					String [] ar = line.split(";");
					
					Condominio c = this.mappaCondomini.get(ar[0]);
					double percentualeAmministratore = Double.parseDouble(ar[5].trim());
					
					if (ar.length == 6 && percentualeAmministratore != 0){
						String codiceCondominio = ar[0].trim();
						String descrizione = ar[1].trim();
						double importo = Double.parseDouble(ar[2].trim());
						String data = ar[3].trim();
						//bool
						boolean pagata = false;
						if(ar[4].trim().compareTo("true")==0)
						{
							pagata = true;
						}
						
						else
						{
							pagata = false;
						}
						
						this.aggiungiSpesa(codiceCondominio, descrizione, importo, data, pagata, percentualeAmministratore);
					
					}
					
					if (ar.length == 6 && percentualeAmministratore == 0){
						String codiceCondominio = ar[0].trim();
						String descrizione = ar[1].trim();
						double importo = Double.parseDouble(ar[2].trim());
						String data = ar[3].trim();
						//bool
						boolean pagata = false;
						if(ar[4].trim().compareTo("true")==0)
						{
							pagata = true;
						}
						
						else
						{
							pagata = false;
						}
						
						this.aggiungiSpesa(codiceCondominio, descrizione, importo, data, pagata, percentualeAmministratore);
					
					}
				}
	}	
}
