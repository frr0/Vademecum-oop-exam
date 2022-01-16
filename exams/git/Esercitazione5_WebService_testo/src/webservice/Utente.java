package webservice;
import java.util.Comparator;

public class Utente {
	protected String nome;
	protected String cognome;
	protected String email;
	protected String password;
	protected String dataNascita;

	public Utente(String nome, String cognome, String email, String password, String dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.dataNascita = dataNascita;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public String getDataNascita() {
		return this.dataNascita;
	}
	
	public String toString() {
		return this.email + " - " + this.cognome + " " + this.nome;
	}
	
	public boolean equals(Utente ut2) {
		if (this.email.contentEquals(ut2.getEmail())) {
			return true;
		} else {
			return false;
		}
	}

	public static Comparator<Utente> reverseEmailComparator = new Comparator<Utente>(){
		@Override
		public int compare(Utente ut1, Utente ut2) {
			int res = ut1.getEmail().compareToIgnoreCase(ut2.getEmail());
			return res*-1;
		}
	};
	
	public static Comparator<Utente> ageComparator = new Comparator<Utente>() {
		@Override
		public int compare(Utente ut1, Utente ut2) {
			int res = ut1.getDataNascita().compareTo(ut2.getDataNascita());
			return res;
		}
	};
	
	public static Comparator<Utente> surnameComparator = new Comparator<Utente>() {
		@Override
		public int compare(Utente ut1, Utente ut2) {
			int res = ut1.getCognome().compareTo(ut2.getCognome());
			return res;
		}
	};
	
	
}
