package studiomedico;

public class Assistito {
	
	String codiceFiscale;
	String cognome;
	String nome;
	String dataNascita;
	String dal;
	String al;
	Medico medico;

	
	public Assistito(String codiceFiscale, String cognome, String nome, String dataNascita, String dal, String al, Medico medico) {
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.dal = dal;
		this.al = al;
		this.medico = medico;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public String getDal() {
		return dal;
	}

	public String getAl() {
		return al;
	}

	public String getCognomeMedico() {
		return medico.getCognome();
	}

	public String getNomeMedico() {
		return medico.getNome();
	}

	public void setDataFine(String al) {
		this.al = al;
		
	}

	public Medico getMedico() {
		
		return medico;
	}
}
