import noleggiauto.*;

public class Esempio2 {

	public static void main(String[] args) {

		Autonoleggio a = new Autonoleggio();

		// R1. Auto
		
		System.out.println("\n" + 
				" ▄▄▄▄▄▄▄▄▄▄▄     ▄▄▄▄          \n" + 
				"▐░░░░░░░░░░░▌  ▄█░░░░▌         \n" + 
				"▐░█▀▀▀▀▀▀▀█░▌ ▐░░▌▐░░▌         \n" + 
				"▐░▌       ▐░▌  ▀▀ ▐░░▌         \n" + 
				"▐░█▄▄▄▄▄▄▄█░▌     ▐░░▌         \n" + 
				"▐░░░░░░░░░░░▌     ▐░░▌         \n" + 
				"▐░█▀▀▀▀█░█▀▀      ▐░░▌         \n" + 
				"▐░▌     ▐░▌       ▐░░▌         \n" + 
				"▐░▌      ▐░▌  ▄▄▄▄█░░█▄▄▄      \n" + 
				"▐░▌       ▐░▌▐░░░░░░░░░░░▌     \n" + 
				" ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀      \n" + 
				"                               \n" + 
				"");
		
		System.out.println("Aggiungo 15 Auto");
		
		Auto listaAuto [] = new Auto[6];
		listaAuto[0] = a.aggiungiAuto("SJ419AQ", "Mercury", "Grand Marquis", "Grigio", 'B');
		listaAuto[1] = a.aggiungiAuto("OZ858MM", "Chevrolet", "Express", "Blu", 'B');
		listaAuto[2] = a.aggiungiAuto("YZ480YP", "GMC", "Suburban 2500", "Grigio", 'C');
		listaAuto[3] = a.aggiungiAuto("CA415VM", "Mercedes-Benz", "C-Class", "Blu", 'C');
		listaAuto[4] = a.aggiungiAuto("XI767DJ", "GMC", "2500 Club Coupe", "Rosso", 'B');
		listaAuto[5] = a.aggiungiAuto("PJ580FL", "Mazda", "B-Series", "Grigio", 'B');
		
		// CONTROLLA CLASSI BERLINA - COMPATTA
		for(Auto auto: listaAuto) {
			System.out.println("\nTarga: "+auto.getTarga());
			System.out.println("Marca: "+auto.getMarca());
			System.out.println("Modello: "+auto.getModello());
			System.out.println("Colore: "+auto.getColore());
			if(auto instanceof Compatta) {
				System.out.println("Tipologia: compatta");
				if (auto.getNumeroValigieGrandi()!=0) {
					System.err.println("Valigie grandi (max): "+auto.getNumeroValigieGrandi());
				} else {
					System.out.println("Valigie grandi (max): "+auto.getNumeroValigieGrandi());

				}
				if (auto.getNumeroValigiePiccole()!=2) {
					System.err.println("Valigie piccole (max): "+auto.getNumeroValigiePiccole());
				} else {
					System.out.println("Valigie piccole (max): "+auto.getNumeroValigiePiccole());
				}
				if (auto.getCostoGiornaliero()!=50) {
					System.err.println("Costo giornaliero (euro): "+auto.getCostoGiornaliero());
				} else {
					System.out.println("Costo giornaliero (euro): "+auto.getCostoGiornaliero());
				}
			}
			else if(auto instanceof Berlina) {
				System.out.println("Tipologia: berlina");
				if (auto.getNumeroValigieGrandi()!=1) {
					System.err.println("Valigie grandi (max): "+auto.getNumeroValigieGrandi());
				} else {
					System.out.println("Valigie grandi (max): "+auto.getNumeroValigieGrandi());

				}
				if (auto.getNumeroValigiePiccole()!=3) {
					System.err.println("Valigie piccole (max): "+auto.getNumeroValigiePiccole());
				} else {
					System.out.println("Valigie piccole (max): "+auto.getNumeroValigiePiccole());
				}
				if (auto.getCostoGiornaliero()!=75) {
					System.err.println("Costo giornaliero (euro): "+auto.getCostoGiornaliero());
				} else {
					System.out.println("Costo giornaliero (euro): "+auto.getCostoGiornaliero());
				}
			}	
			else {
				System.err.println("Tipologia: N/D");
			}
		}	
		
		// CONTROLLA CHE CAMBI COLORE SE AGGIUNGI STESSA AUTO
		a.aggiungiAuto("OZ858MM", "Fiat", "Panda", "Rosso", 'C');
		if (listaAuto[1].getMarca().contentEquals("Chevrolet") &&
				listaAuto[1].getModello().contentEquals("Express") &&
				listaAuto[1].getColore().contentEquals("Rosso") &&
				listaAuto[1].getTipologia() == 'B'){
			System.out.println("\nCambiato colore a "+listaAuto[1].getTarga());
		} else {
			System.err.println("\nC'è un errore nella funzione di cambio colore");
		}
		
		// TEST CERCA AUTO
		Auto autoCercata = a.cercaAuto("CA415VM");
		if (autoCercata.getMarca().contentEquals("Mercedes-Benz") && 
				autoCercata.getModello().contentEquals("C-Class") &&
				autoCercata.getColore().contentEquals("Blu") &&
				autoCercata.getTipologia() == 'C') {
			System.out.println("\ncercaAuto() funziona - auto trovata!");
		} else {
			System.err.println("\ncercaAuto() NON funziona");
		}
		
		Auto autoNull = a.cercaAuto("ZZ999ZZ");
		if (autoNull == null) {
			System.out.println("\ncercaAuto() funziona - auto non esistente");
		} else {
			System.err.println("\ncercaAuto() NON funziona - auto non esistente non null");
		}
		
		// TEST ELENCO AUTO
		System.out.println("\nElenco auto");

		String elencoAuto = a.elencoAuto();
		String comparaElenco = "SJ419AQ Mercury Grand Marquis Grigio B\nOZ858MM Chevrolet Express Rosso B\nYZ480YP GMC Suburban 2500 Grigio C\nCA415VM Mercedes-Benz C-Class Blu C\nXI767DJ GMC 2500 Club Coupe Rosso B\nPJ580FL Mazda B-Series Grigio B";
		if (elencoAuto.contentEquals(comparaElenco)) {
			System.out.println(elencoAuto);
		} else {
			System.err.println("elencoAuto() NON funziona");
		}
		
		// R2. Clienti
		
		Cliente listaUtenti[] = new Cliente[17];
		
		System.out.println("\n" + 
				" ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" + 
				"▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" + 
				"▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌\n" + 
				"▐░▌       ▐░▌          ▐░▌\n" + 
				"▐░█▄▄▄▄▄▄▄█░▌          ▐░▌\n" + 
				"▐░░░░░░░░░░░▌ ▄▄▄▄▄▄▄▄▄█░▌\n" + 
				"▐░█▀▀▀▀█░█▀▀ ▐░░░░░░░░░░░▌\n" + 
				"▐░▌     ▐░▌  ▐░█▀▀▀▀▀▀▀▀▀ \n" + 
				"▐░▌      ▐░▌ ▐░█▄▄▄▄▄▄▄▄▄ \n" + 
				"▐░▌       ▐░▌▐░░░░░░░░░░░▌\n" + 
				" ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀ \n" + 
				"                          \n" + 
				"");
		
		System.out.println("\nRegistrazione cliente");
		listaUtenti[0] = a.registraCliente("Beaves", "Clémentine", "Indonesia", "EK817464");
		listaUtenti[1] = a.registraCliente("Deniscke", "Björn", "Portugal", "LMWV823604");
		listaUtenti[2] = a.registraCliente("Spondley", "Sòng", "China", "BNQR84609");
		listaUtenti[3] = a.registraCliente("Ellerbeck", "Dà", "Poland", "UOXM07957");
		listaUtenti[4] = a.registraCliente("Abbay", "Maïté", "Finland", "WVYJ565171");
		listaUtenti[5] = a.registraCliente("Spurrett", "Vérane", "China", "ACLT022052");
		listaUtenti[6] = a.registraCliente("Trillo", "Léane", "Philippines", "VXP94062");
		listaUtenti[7] = a.registraCliente("Penniell", "Océane", "Thailand", "YRT849790");
		listaUtenti[8] = a.registraCliente("Lanegran", "Björn", "Poland", "HDS12804");
		listaUtenti[9] = a.registraCliente("Besnardeau", "Ruò", "Indonesia", "RN774690");
		listaUtenti[10] = a.registraCliente("Kilbride", "Bérangère", "China", "NFEQ236985");
		listaUtenti[11] = a.registraCliente("Joplin", "Yénora", "Ivory Coast", "NTIJ037325");
		listaUtenti[12] = a.registraCliente("Redhead", "Nuó", "Mexico", "JGUW11785");
		listaUtenti[13] = a.registraCliente("Gaymer", "Bécassine", "Russia", "OANC70033");

		for(Cliente utente: listaUtenti) {
			if (utente != null) {
				System.out.println("\nInformazioni cliente");
				
				System.out.println("Cognome: "+utente.getCognome());
				System.out.println("Nome: "+utente.getNome());
				System.out.println("Nazionalita': "+utente.getNazionalita());
				System.out.println("Numero patente: "+utente.getNumeroPatente());
				System.out.println("Codice assegnato: "+utente.getCodice());
			}
			
		}
		// prova a registrare
		
		Cliente patenteLunga = a.registraCliente("Clemon", "Nuó", "Indonesia", "XMO951296XXX");
		Cliente patenteCorta = a.registraCliente("Francombe", "Almérinda", "Indonesia", "PVWA");
		Cliente nomeCorto = a.registraCliente("de Quesne", "D", "Portugal", "QCI91359");
		Cliente cognomeCorto = a.registraCliente("F", "Léa", "Greece", "LEC159648");
		
		Cliente cognomeAsterischi = a.registraCliente("Ro", "Marlène", "China", "OHW19647");
		Cliente nomeAsterischi = a.registraCliente("Collet", "To", "Patois", "TO6V8888WS");
		Cliente patenteAsterischi = a.registraCliente("Villa", "Alberto", "Pavarolese", "ABCDEFG");
		Cliente nazionalitaAsterischi = a.registraCliente("COGASD", "NOWKASD", "AS", "NOTHERE///");
		
		if (patenteLunga == null) {
			System.out.println("Controllo patente corretto: patente maggiore di 10");
		} else {
			System.err.println("Contollo patente scorretto: patente maggiore di 10");
		}
		if (patenteCorta == null) {
			System.out.println("Controllo patente corretto: patente minore di 7");
		} else {
			System.err.println("Contollo patente scorretto: patente minore di 7");
		}
		if (nomeCorto == null) {
			System.out.println("Controllo nome corretto: nome minore di 2");
		} else {
			System.err.println("Contollo nome scorretto: nome minore di 2");
		}
		if (cognomeCorto == null) {
			System.out.println("Controllo cognome corretto: cognome minore di 2");
		} else {
			System.err.println("Contollo cognome scorretto: cognome minore di 2");
		}
		
		if (cognomeAsterischi.getCodice().contentEquals("RO*-MAR-CHI-OHW19647**")) {
			System.out.println("Codice corretto: Asterischi giusti nel cognome");
		} else {
			System.err.println("Codice scorretto: Asterischi sbagliati nel cognome");
		}
		if (nomeAsterischi.getCodice().contentEquals("COL-TO*-PAT-TO6V8888WS")) {
			System.out.println("Codice corretto: Asterischi giusti nel nome");
		} else {
			System.err.println("Codice scorretto: Asterischi sbagliati nel nome");
		}
		if (nazionalitaAsterischi.getCodice().contentEquals("COG-NOW-AS*-NOTHERE///")) {
			System.out.println("Codice corretto: Asterischi giusti nella nazionalità");
		} else {
			System.err.println("Codice scorretto: Asterischi sbagliati nella nazionalità");
		}
		if (patenteAsterischi.getCodice().contentEquals("VIL-ALB-PAV-ABCDEFG***")) {
			System.out.println("Codice corretto: Asterischi giusti nella patente");
		} else {
			System.err.println("Codice scorretto: Asterischi sbagliati nella patente");
		}
		
		System.out.println("\n");
		
		
		
		
		// R3. Noleggi
		
		System.out.println("\n" + 
				" ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" + 
				"▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" + 
				"▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌\n" + 
				"▐░▌       ▐░▌          ▐░▌\n" + 
				"▐░█▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌\n" + 
				"▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" + 
				"▐░█▀▀▀▀█░█▀▀  ▀▀▀▀▀▀▀▀▀█░▌\n" + 
				"▐░▌     ▐░▌            ▐░▌\n" + 
				"▐░▌      ▐░▌  ▄▄▄▄▄▄▄▄▄█░▌\n" + 
				"▐░▌       ▐░▌▐░░░░░░░░░░░▌\n" + 
				" ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀ \n" + 
				"                          \n" + 
				"");
		//noleggio accettato
		Auto n1 = a.nuovoNoleggio("LAN-BJÖ-POL-HDS12804**", 'C', "20190621", "20190623");
		if (n1.getTarga().contentEquals("YZ480YP")) {
			System.out.println("Auto del noleggio inserita esatta");
		} else {
			System.err.println("Auto del noleggio inserita sbagliata");
		}
		//noleggio accettato
		Auto n2 = a.nuovoNoleggio("COL-TO*-PAT-TO6V8888WS", 'B', "20190621", "20190623");
		if (n2.getTarga().contentEquals("SJ419AQ")) {
			System.out.println("Auto del noleggio inserita esatta");
		} else {
			System.err.println("Auto del noleggio inserita sbagliata");
		}
		//noleggio accettato
		Auto n3 = a.nuovoNoleggio("PEN-OCÉ-THA-YRT849790*", 'C', "20190621", "20190623");
		if (n3.getTarga().contentEquals("CA415VM")) {
			System.out.println("Auto del noleggio inserita esatta");
		} else {
			System.err.println("Auto del noleggio inserita sbagliata");
		}
		// auto non disponibile - deve ritornare auto (null, null, null, null)
		Auto n5 = a.nuovoNoleggio("ELL-DÀ*-POL-UOXM07957*", 'C', "20190620", "20190622");
		if (n5.getTarga() == null) {
			System.out.println("Auto non disponibile, ha ritornato auto(null,null,null,null)");
		} else {
			System.err.println("Auto non disponibile, non ha ritornato auto(null,null,null,null)");
		}
		
		// date cliente si sovrappongono - valore di ritorno non rilevante
		Auto n6 = a.nuovoNoleggio("COL-TO*-PAT-TO6V8888WS", 'B', "20190620", "20190622");
		if (n6 == null || n6.getTarga() == null) {
			System.out.println("Date cliente si sovrappongono: il valore di ritorno non è rilevante");
		} else {
			System.err.println("Date cliente si sovrappongono: il valore di ritorno non è rilevante");
		}
		Auto n7 = a.nuovoNoleggio("LAN-BJÖ-POL-HDS12804**", 'B', "20200912", "20200920");

		if (a.elencoNoleggiCliente("LAN-BJÖ-POL-HDS12804**").contentEquals("YZ480YP 20190621 20190623\nSJ419AQ 20200912 20200920")) {
			System.out.println("Elenco noleggi cliente giusto");
		} else {
			System.err.println("Elenco noleggi cliente sbagliato");
		}
		if (a.elencoNoleggiAuto("SJ419AQ").contentEquals("COL-TO*-PAT-TO6V8888WS 20190621 20190623\n" + 
				"LAN-BJÖ-POL-HDS12804** 20200912 20200920")) {
			System.out.println("Elenco noleggi auto giusto");
		} else {
			System.err.println("Elenco noleggi auto sbagliato");
		}
		
		if (a.calcolaCostoNoleggio("SJ419AQ", "COL-TO*-PAT-TO6V8888WS", "20190621", "20190623") == 225) {
			System.out.println("Calcolo costo noleggio giusto");

		} else {
			System.err.println("Calcolo costo noleggio sbagliato");
		}
		
		if (a.calcolaCostoNoleggio("FL364TW", "COL-TO*-PAT-TO6V8888WS", "20190621", "20190623") == -1) {
			System.out.println("Calcolo costo noleggio giusto - auto non esistente");

		} else {
			System.err.println("Calcolo costo noleggio sbagliato - - auto non esistente");
		}
		
		if (a.calcolaCostoNoleggio("SJ419AQ", "SPU-VÉR-CHI-ACLT022052", "20190621", "20190623") == -1) {
			System.out.println("Calcolo costo noleggio giusto - cliente non ha noleggiato quest'auto");

		} else {
			System.err.println("Calcolo costo noleggio sbagliato- cliente non ha noleggiato quest'auto");
		}
		
		Auto n8 = a.nuovoNoleggio("SPU-VÉR-CHI-ACLT022052", 'B', "20500710", "20500708");
		if (n8 == null || n8.getTarga() == null) {
			System.out.println("Controllo ordine della data corretto");
		} else {
			System.err.println("Controllo ordine della data scorretto");
		}
		
		System.out.println(a.elencoAuto());
		System.out.println("\n");
		System.out.println(a.elencoNoleggiAuto("SJ419AQ"));
		System.out.println("\n");
		System.out.println(a.elencoNoleggiCliente("LAN-BJÖ-POL-HDS12804**"));		
				
	}

}
