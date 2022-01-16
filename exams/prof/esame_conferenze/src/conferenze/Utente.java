package conferenze;

import java.util.Comparator;

public class Utente {
	private String nome;
	private String cognome;
	private String organizzazione;
	private String email;

	

	public Utente(String nome, String cognome, String organizzazione,
			String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.organizzazione = organizzazione;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getOrganizzazione() {
		return organizzazione;
	}

	public String getEmail() {
		return email;
	}
	
	
	public boolean contieneStringa(String cerca) {
		if(nome.contains(cerca)||cognome.contains(cerca)||organizzazione.contains(cerca)||email.contains(cerca))
		return true;
		
		return false;
	}
	
	
	
	static class ComparatoreUtentiCognomeNome implements Comparator<Utente>{

		
		public int compare(Utente arg0, Utente arg1) {
			if(arg0.getCognome().compareTo(arg1.getCognome())!=0)
				return arg0.getCognome().compareTo(arg1.getCognome());
			
			return arg0.getNome().compareTo(arg1.getNome());
		}
		
	}

}
