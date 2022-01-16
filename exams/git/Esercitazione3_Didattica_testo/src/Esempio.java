import didattica.*;

public class Esempio {

	public static void main(String[] args) {

		Ateneo a = new Ateneo();

		// R1. Ateneo
		
		System.out.println("Definito corso");
		Corso c1 = a.nuovoCorso("Programmazione a oggetti", 80, 2, "I", "Ingegneria Gestionale");

		System.out.println("Codice: "+c1.getCodice());
		System.out.println("Nome: "+c1.getNome());
		System.out.println("Numero di ore: "+c1.getNumeroOre());
		System.out.println("Numero di squadre: "+c1.getNumeroSquadre());
		System.out.println("Periodo didattico: "+c1.getPeriodo());
		System.out.println("Corso di Laurea: "+c1.getCorsoDiLaurea());

		System.out.println("\nDefinito altro corso");
		Corso c2 = a.nuovoCorso("Basi di dati", 60, 1, "II", "Ingegneria Gestionale");

		System.out.println("Codice: "+c2.getCodice());
		System.out.println("Nome: "+c2.getNome());
		System.out.println("Numero di ore: "+c2.getNumeroOre());
		System.out.println("Numero di squadre: "+c2.getNumeroSquadre());
		System.out.println("Periodo didattico: "+c2.getPeriodo());
		System.out.println("Corso di Laurea: "+c2.getCorsoDiLaurea());

		System.out.println("\nRicerca corso 0001");
		Corso corsoTrovato = a.cercaCorso("0001");

		System.out.println("\nInformazioni corso trovato");
		System.out.println(""+corsoTrovato.descriviti());
		
		System.out.println("\nRicerca corsi contenenti 'oggetti'");
		
		Corso corsiTrovati[] = a.cercaCorsi("oggetti");

		System.out.println("\nInformazioni corsi trovati");
		for(Corso c : corsiTrovati)
			if(c!=null) 
				System.out.println(""+c.descriviti());
		
		// R2. Docenza
		
		System.out.println("\nDefinito docente");
		a.nuovoDocente(123, "Lamberti", "Fabrizio", "Professore Associato");

		System.out.println("\nRicerca docente 123");

		Docente d1 = a.cercaDocente(123);
		System.out.println("Cognome: "+d1.getCognome());
		System.out.println("Nome: "+d1.getNome());
		System.out.println("Ruole: "+d1.getRuolo());

		System.out.println("\nAssegnazione docente 123 a corso "+"0000");

		a.assegnaDocenteCorso("0000", 123);
		
		System.out.println("\nCorsi docente 123");
		String corsiDocente = a.corsiDocente(123);
		
		System.out.println(corsiDocente);
		
		// R3. Lezioni ed esercitazioni
		
		System.out.println("\nNuova lezione per il corso 0000 docente 123");
		a.nuovoBlocco("0000", 123, "Lun", "13.00-14.00");
		
		System.out.println("\nBlocchi docente 123");
		Blocco blocchiDocente[] = a.blocchi(123);
		
		for(Blocco b : blocchiDocente)
			if(b!=null) 
				System.out.println(""+b.descriviti());

	}

}