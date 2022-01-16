package condomini;

import java.util.*;

public class Condominio {
	
	private String codice;
	private String indirizzo;
	private int numeroCivico;
	private double saldo;
	double millesimiTotali=0;
	List<Proprietario> listaProprietari = new LinkedList<Proprietario>();
	List<Spesa> listaSpese = new LinkedList<Spesa>();
	

	public Condominio(String codice, String indirizzo, int numeroCivico, double saldo) {
		super();
		this.codice = codice;
		this.indirizzo = indirizzo;
		this.numeroCivico = numeroCivico;
		this.saldo = saldo;
	}

	public String getCodice() {
		return this.codice;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public int getNumeroCivico(){
		return this.numeroCivico;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public Collection<Proprietario> elencoProprietari(){
		
		Collections.sort(this.listaProprietari, new cognNomeCompProp());
		
		return this.listaProprietari;
	}
	
	public Collection<Spesa> elencoSpeseCondominioPerDataCrescente(){
		
		Collections.sort(this.listaSpese, new dataCompSpesa());
		
		return this.listaSpese;
	}
	
	public Collection<Spesa> elencoSpeseCondominioAncoraDaPagare(){
		
		List<Spesa> dapagare = new LinkedList<Spesa>();
		
		for(Spesa s: this.listaSpese)
		{
			if(s.pagata==false)
			{
				dapagare.add(s);
			}
		}
		
		Collections.sort(dapagare, new dataCompSpesa());
		
		return dapagare;
	}

	public Collection<Spesa> elencoSpeseCondominioPerImportoDecrescente(){
		
		Collections.sort(this.listaSpese, new impCompSpesa());
		
		
		return this.listaSpese;
	}
}
