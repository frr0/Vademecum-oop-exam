import java.util.*;

import piano_vaccinazioni.*;

public class Esempio {

	public static void main(String[] args) throws EccezioneConsegnateMenoDosi, EccezioneDosiVaccinoNonDisponibili {
		
		Piano p = new Piano();
		
		System.out.println("/************************************/");
		System.out.println("/**          R1. CITTADINI         **/");
		System.out.println("/************************************/");

		System.out.println("\n* Registrazione cittadino 1111 Mario Rossi 19751002 Piemonte");
		
		Cittadino c1 = p.registraCittadino("1111", "Mario", "Rossi", "19751002", "Piemonte");
		
		System.out.println("\n* Informazioni cittadino\n");
		System.out.println("Codice tessera san.: "+c1.getCodiceTesseraSanitaria());
		System.out.println("Nome: "+c1.getNome());
		System.out.println("Cognome: "+c1.getCognome());
		System.out.println("Data di nascita: "+c1.getDataDiNascita());
		System.out.println("Regione: "+c1.getRegione());
		
		System.out.println("\n* Registrazione altri cittadini");

		p.registraCittadino("2222", "Gianna", "Azzurri", "20050312", "Piemonte");
		p.registraCittadino("3333", "Laura", "Neri", "20020421", "Liguria");
		p.registraCittadino("4444", "Marco", "Verdi", "19201231", "Piemonte");
		p.registraCittadino("5555", "Anna", "Neri", "19810414", "Piemonte");
		p.registraCittadino("6666", "Luigi", "Blu", "20010118", "Puglia");

		System.out.println("\n* Elenco cittadini (per data di nascita, crescente)\n");
		LinkedList<Cittadino> listaCittadini = new LinkedList<Cittadino>(p.elencoCittadiniPerDataDiNascita());
		for(Cittadino c : listaCittadini)
			System.out.println(c.getCodiceTesseraSanitaria()+"\t"+c.getCognome()+"\t"+c.getNome()+"\t"+c.getDataDiNascita()+"\t"+c.getRegione());
		
		System.out.println("\n* Cerca cittadini eta' minima 18 anni (ordine di registr.)");
		listaCittadini = new LinkedList<Cittadino>(p.cercaCittadiniEtaMinima(18));
		for(Cittadino c : listaCittadini)
			System.out.println(c.getCodiceTesseraSanitaria()+"\t"+c.getCognome()+"\t"+c.getNome()+"\t"+c.getDataDiNascita()+"\t"+c.getRegione());

		
		System.out.println("\n\n/************************************/");
		System.out.println("/**      R2. CENTRI E CONSEGNE     **/");
		System.out.println("/************************************/");

		System.out.println("\n* Attivazione primo centro in Piemonte, numero massimo dosi contemp. 10");
		
		Centro cv1 = p.attivaCentro("Piemonte", 10);
		
		System.out.println("\n* Informazioni centro\n");
		System.out.println("Codice assegnato: "+cv1.getCodice());
		System.out.println("Regione: "+cv1.getRegione());

		System.out.println("\n* Attivazione altro centro in Piemonte, numero massimo dosi contemp. 20");
		
		Centro cv2 = p.attivaCentro("Piemonte", 20);
		
		System.out.println("\n* Informazioni centro\n");
		System.out.println("Codice assegnato: "+cv2.getCodice());
		
		System.out.println("\n* Attivazione altri centri");
		Centro cv3 = p.attivaCentro("Liguria", 20);
		p.attivaCentro("Puglia", 40);

		System.out.println("\n* Consegna 1 dosi vaccino tipo A al centro "+cv1.getCodice());
		
		p.consegnaDosiVaccino(cv1.getCodice(), 'A', 1);

		System.out.println("\n* Dosi vaccino tipo A disponibili nel centro "+cv1.getCodice()+"\n");
		
		System.out.println(""+p.numeroDosiTipoVaccinoCentro(cv1.getCodice(), 'A'));

		System.out.println("\n* Consegna altre dosi ai centri");
		
		p.consegnaDosiVaccino(cv1.getCodice(), 'B', 1);
		p.consegnaDosiVaccino(cv2.getCodice(), 'A', 18);

		System.out.println("\n* Dosi vaccino disponibili nel centro "+cv1.getCodice()+"\n");

		System.out.println(""+p.numeroDosiCentro(cv1.getCodice()));
	
		System.out.println("\n* Consegna di un numero eccessivo di dosi");
		try {
			p.consegnaDosiVaccino(cv3.getCodice(), 'B', 50);
			
		}catch(EccezioneConsegnateMenoDosi ecmd) {
			System.out.println("\nRilevata anomalia");
		}

		
		System.out.println("\n\n/************************************/");
		System.out.println("/**  R3. VACCINAZIONI E RICHIAMI   **/");
		System.out.println("/************************************/");

		System.out.println("\n* Effettuazione vaccinazione di 1111 in data 20210212");

		char tipoVaccinoUtilizzato = p.vaccina("1111", "20210212");
		
		System.out.println("\n* Tipo vaccino scelto ed utilizzato\n");
		
		System.out.println(""+tipoVaccinoUtilizzato);
		
		System.out.println("\n* Effettuazione richiamo di 1111 in data 20210307");

		tipoVaccinoUtilizzato = p.vaccina("1111", "20210307");
		
		System.out.println("\n* Tipo vaccino scelto ed utilizzato per il richiamo\n");
		
		System.out.println(""+tipoVaccinoUtilizzato);
		
		System.out.println("\n* Effettuazione vaccinazione di 2222 in data 20210308");

		tipoVaccinoUtilizzato = p.vaccina("2222", "20210308");
		
		System.out.println("\n* Tipo vaccino scelto ed utilizzato\n");

		System.out.println(""+tipoVaccinoUtilizzato);

		System.out.println("\n* Effettuazione di altre vaccinazioni");

		p.vaccina("4444", "20210308");
		p.vaccina("5555", "20210309");
		p.vaccina("3333", "20210310");

		System.out.println("\n* Effettuazione vaccinazione con dosi non disponibili");
		
		try {
			p.vaccina("6666", "20210322");
		}
		catch(EccezioneDosiVaccinoNonDisponibili edvnd) {
			System.out.println("\nRilevata anomalia");
		}
		
		
		System.out.println("\n\n/************************************/");
		System.out.println("/**    R4. STAMPE E STATISTICHE    **/");
		System.out.println("/************************************/");

		System.out.println("\n* Stampa ultima vaccinazione di 1111\n");
		
		System.out.println(""+p.stampaUltimaVaccinazioneCittadino("1111"));

		System.out.println("\n* Stampa di tutte le vaccinazioni (ordine di effettuazione)\n");

		System.out.println(p.stampaVaccinazioni());

		System.out.println("\n* Percentuale utilizzo dosi in Piemonte\n");
		
		System.out.println(p.percentualeUtilizzoDosi("Piemonte"));
	}

}
