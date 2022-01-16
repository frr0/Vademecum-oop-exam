package congressi;

import java.util.*;

public class Sessione implements Comparable<Sessione>{

	int numero;
	Congresso congresso;
	Sala sala;
	private String nome;
	private String data;
	private String daOra;
	private String adOra;
	
	public Sessione(int numero, Congresso congresso, Sala sala, String nome, String data, String daOra, String adOra) {
		this.numero=numero;
		this.congresso=congresso;
		this.sala = sala;
		this.nome = nome;
		this.data = data;
		this.daOra = daOra;
		this.adOra = adOra;
		
	}


	public int getNumero() {
		return numero;
	}
	
	public String getNome() {
		return nome;
	}

	public String getNomeCongresso() {
		return congresso.getNome();
	}

	public String getNomeSala() {
		return sala.getNome();
	}

	public String getData() {
		return data;
	}

	public String getDaOra() {
		return daOra;
	}

	public String getAdOra() {
		return adOra;
	}

	public Collection<String> elencoOratori(){
		return null;
	}


	@Override
	public int compareTo(Sessione o) {
		if(this.getData().compareTo(o.getData())!=0)
			return this.getData().compareTo(o.getData());
		else
			return this.getDaOra().compareTo(o.getDaOra());
	}
	
}
