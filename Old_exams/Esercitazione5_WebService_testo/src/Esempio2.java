import webservice.*;

public class Esempio2 {

	public static void main(String[] args) {
		WebService w = new WebService();
		WebService x = new WebService();
		
		Utente u1 = w.registraUtente("Gesu", "Cristo", "iesus@cristo.inri", "NbXuY7og5DXj", "00001225");
		Utente u2 = w.registraUtente("Bono", "Vox", "bono@vox.com", "M3VFxOY7t9YCeQ", "19740113");
		Utente u3 = w.registraUtente("Cristiano", "Le Estut", "cleestut2@oracle.com", "lNiEY7tBsfQ3S", "19771023");
		Utente u4 = w.registraUtente("Corby", "Phoebe", "cphoebe3@patch.com", "aIRwKMJY7kv", "19891010");
		Utente u5 = w.registraUtente("Casar", "Duchatel", "cduchatel4@sogou.com", "nSY7sPJ5CWT", "19861027");
		Utente u6 = w.registraUtente("Artus", "Jaher", "ajaher5@moonfruit.com", "0kWrY7s8arfG", "19660119");
		Utente u7 = w.registraUtente("Joann", "Carlson", "jcarlson6@jalbum.net", "QpReC3Y75gl", "19850306");
		Utente u8 = w.registraUtente("Mallorie", "Lottrington", "mlottrington7@wufoo.com", "y0OhVY7HCSrZc", "19671025");
		Utente u9 = w.registraUtente("Erin", "Aldiss", "ealdiss8@kickstarter.com", "sjY75lpPd", "19811124");
		Utente u10 = w.registraUtente("Katharina", "Mauditt", "kmauditt9@etsy.com", "wIPkTY7MgFu9Gk", "19950820");
		Utente u11 = w.registraUtente("Yulma", "Girone", "ygironea@overblog.com", "MSiCCZY7aAmvt", "19780701");
		Utente u12 = w.registraUtente("Corenda", "Prendeguest", "cprendeguestb@canalblog.com", "8rdY73Dg1twm", "19881012");
		Utente u13 = w.registraUtente("Cassey", "Parlour", "cparlourc@barnesandnoble.com", "TkcMY77k", "19740822");
		Utente u14 = w.registraUtente("June", "Filer", "jfilerd@elpais.com", "riIfuA3hY7rBn", "19870812");
		Utente u15 = w.registraUtente("Florry", "Elliston", "fellistone@webmd.com", "Ve6Y7gb4j4", "19890524");
		Utente u16 = w.registraUtente("Dulce", "Gounard", "dgounardf@yahoo.co.jp", "tELY70TZU", "19810111");
		Utente u17 = w.registraUtente("Linnie", "Hanson", "lhansong@webmd.com", "BN3hYowpcOu7", "19680510");
		Utente u18 = w.registraUtente("Walsh", "Mogridge", "wmogridgeh@tripadvisor.com", "Y2vZY7Sl5H", "19910606");
		Utente u19 = w.registraUtente("Ottilie", "Aust", "oausti@printfriendly.com", "hpTtkY7RPie3", "19760208");
		Utente u20 = w.registraUtente("Scarface", "Caney", "scaneyj@hc360.com", "voXwY7G3kT", "19830224");
		
		// password non ha numeri => deve ritornare null
		Utente u21 = w.registraUtente("Reed", "Kenworthey", "rkenwortheyk@360.cn", "tflIOGaVSv", "19880618");
		// password non ha maiuscole => deve ritornare null
		Utente u22 = w.registraUtente("Aurelia", "Whayman", "awhaymanl@printfriendly.com", "9wrxe5bo1", "19720301");
		// password < 8 caratteri => deve ritornare null
		Utente u23 = w.registraUtente("Arv", "Matteoli", "amatteolim@delicious.com", "0u8RUl5", "19710218");
		// email non ha @ => deve ritornare null
		Utente u24 = w.registraUtente("Bethany", "Delos", "bdelosngithub.com", "HvrY7OOkYwFF", "19720724");
		// email già usata => deve ritornare u6
		Utente u25 = w.registraUtente("Alice", "Perham", "ajaher5@moonfruit.com", "I6swrpJ5", "19921028");
		
		// test cercaUtente => deve ritornare u7
		Utente cercaUtenteGiusto = w.cercaUtente("jcarlson6@jalbum.net");
		// test cercaUtente => deve ritornare null
		Utente cercaUtenteSbagliato = w.cercaUtente("augusto.colongo@studenti.polito.it");
		
		//test loginUtente - corretto => deve ritornare u4
		Utente loginUtenteCorretto = w.loginUtente("cphoebe3@patch.com", "aIRwKMJY7kv", "2015-01-09 18:50:33");
		// test loginUtente - utente non esiste => deve ritornare null
		Utente loginUtenteNonEsiste = w.loginUtente("augusto.colongo@studenti.polito.it", "asjdawdAda66", "2019-12-03 00:58:25");
		// test loginUtente - password sbagliata => deve ritornare null
		Utente loginUtentePasswordSbagliata = w.loginUtente("cleestut2@oracle.com", "883asdawDDDD", "2015-01-11 13:33:34");
		// test loginUtente - utente già connesso => deve ritornare null
		Utente loginUtenteGiaConnesso = w.loginUtente("cphoebe3@patch.com", "aIRwKMJY7kv", "2015-01-17 18:15:21");
		
		// test logoutUtente - utente non esistente
		Utente logoutUtenteNonEsistente = w.logoutUtente("allasdar@gmail.com", "2015-01-23 12:49:42");
		// test logoutUtente - utente non connesso
		Utente logoutUtenteNonConnesso = w.logoutUtente("fellistone@webmd.com", "2015-02-06 09:49:00");
		// test logoutUtente - corretto
		Utente logoutUtenteCorretto = w.logoutUtente("cphoebe3@patch.com", "2015-02-14 11:51:44");
		
		w.loginUtente("iesus@cristo.inri", "NbXuY7og5DXj", "2015-03-04 13:37:29");
		w.loginUtente("cleestut2@oracle.com", "lNiEY7tBsfQ3S", "2015-03-17 03:42:40");
		w.loginUtente("bono@vox.com", "M3VFxOY7t9YCeQ", "2015-04-19 14:25:14");
		w.loginUtente("cphoebe3@patch.com", "aIRwKMJY7kv", "2015-05-03 17:37:11");
		w.loginUtente("cduchatel4@sogou.com", "nSY7sPJ5CWT", "2015-05-15 03:07:57");
		w.loginUtente("ajaher5@moonfruit.com", "0kWrY7s8arfG", "2015-05-29 13:14:03");
		
		
		// test verificaConnessioneUtente - utente non esistente
		Utente verificaConnessioneNonEsistente = w.verificaConnessioneUtente("augusto.colongo@gmail.com");
		// test verificaConnessioneUtente - utente non connesso
		Utente verificaConnessioneNonConnesso = w.verificaConnessioneUtente("cparlourc@barnesandnoble.com");
		// test verificaConnessioneUtente - utente connesso
		Utente verificaConnessioneCorretto = w.verificaConnessioneUtente("ajaher5@moonfruit.com");
		
		// test eliminaUtente - richiedente non autorizzato
		Utente eliminaUtenteRichiedenteNonAutorizzato = w.eliminaUtente("cleestut2@oracle.com", "lNiEY7tBsfQ3S", "cphoebe3@patch.com");
		// test eliminaUtente - richiedente non connesso
		Utente eliminaUtenteRichiedenteNonConnesso = w.eliminaUtente("dgounardf@yahoo.co.jp", "tELY70TZU", "cphoebe3@patch.com");
		// test eliminaUtente - richiedente non esiste
		Utente eliminaUtenteRichiedenteNonEsiste = w.eliminaUtente("augusto.colongo@gmail.com", "geasdagAS4", "cphoebe3@patch.com");
		// test eliminaUtente - destinatario non esiste
		Utente eliminaUtenteDestinatarioNonEsiste = w.eliminaUtente("iesus@cristo.inri", "NbXuY7og5DXj", "augusto.colongo@gmail.com"); 
		// test eliminaUtente - corretto con destinatario connesso
		Utente eliminaUtenteDestinatarioCorrettoConnesso = w.eliminaUtente("iesus@cristo.inri", "NbXuY7og5DXj", "bono@vox.com");
		// test eliminaUtente - destinatario elimina se stesso
		Utente eliminaUtenteSeStesso = w.eliminaUtente("cleestut2@oracle.com", "lNiEY7tBsfQ3S", "cleestut2@oracle.com");
		
		
		// un numero di login e logout
		w.logoutUtente("iesus@cristo.inri", "2015-06-03 12:16:40");
		w.logoutUtente("cphoebe3@patch.com", "2015-06-10 02:44:09");
		w.logoutUtente("cduchatel4@sogou.com", "2015-06-10 02:44:09");
		w.logoutUtente("ajaher5@moonfruit.com", "2015-06-16 11:50:01");
		
		w.loginUtente("iesus@cristo.inri", "NbXuY7og5DXj", "2015-06-21 02:21:57");
		w.loginUtente("cphoebe3@patch.com", "aIRwKMJY7kv", "2015-06-23 19:33:44");
		w.loginUtente("cduchatel4@sogou.com", "nSY7sPJ5CWT", "2015-06-27 14:32:00");
		w.loginUtente("ajaher5@moonfruit.com", "0kWrY7s8arfG", "2015-07-03 13:07:14");
		w.loginUtente("jcarlson6@jalbum.net", "QpReC3Y75gl", "2015-07-17 01:42:11");
		w.loginUtente("mlottrington7@wufoo.com", "y0OhVY7HCSrZc", "2015-08-20 21:22:55");
		w.loginUtente("ealdiss8@kickstarter.com", "sjY75lpPd", "2015-08-20 23:48:01");
		
		w.logoutUtente("cduchatel4@sogou.com", "2015-08-30 04:11:21");
		w.logoutUtente("ajaher5@moonfruit.com", "2015-08-30 04:50:21");
		
		String testElencoUtentiPerEmail = "ygironea@overblog.com - Girone Yulma\n" + 
				"wmogridgeh@tripadvisor.com - Mogridge Walsh\n" + 
				"scaneyj@hc360.com - Caney Scarface\n" + 
				"oausti@printfriendly.com - Aust Ottilie\n" + 
				"mlottrington7@wufoo.com - Lottrington Mallorie\n" + 
				"lhansong@webmd.com - Hanson Linnie\n" + 
				"kmauditt9@etsy.com - Mauditt Katharina\n" + 
				"jfilerd@elpais.com - Filer June\n" + 
				"jcarlson6@jalbum.net - Carlson Joann\n" + 
				"iesus@cristo.inri - Cristo Gesu\n" + 
				"fellistone@webmd.com - Elliston Florry\n" + 
				"ealdiss8@kickstarter.com - Aldiss Erin\n" + 
				"dgounardf@yahoo.co.jp - Gounard Dulce\n" + 
				"cprendeguestb@canalblog.com - Prendeguest Corenda\n" + 
				"cphoebe3@patch.com - Phoebe Corby\n" + 
				"cparlourc@barnesandnoble.com - Parlour Cassey\n" + 
				"cduchatel4@sogou.com - Duchatel Casar\n" + 
				"ajaher5@moonfruit.com - Jaher Artus";
		
		String testElencoAccessiUtente1 = "login: 2015-03-04 13:37:29\n" + 
				"logout: 2015-06-03 12:16:40\n" + 
				"login: 2015-06-21 02:21:57";
		String testElencoAccessiUtente2 = "login: 2015-05-15 03:07:57\n" + 
				"logout: 2015-06-10 02:44:09\n" + 
				"login: 2015-06-27 14:32:00\n" + 
				"logout: 2015-08-30 04:11:21";
		String testElencoVuoto = "";

		String testElencoConnessi = "iesus@cristo.inri - Cristo Gesu\n" + 
				"mlottrington7@wufoo.com - Lottrington Mallorie\n" + 
				"ealdiss8@kickstarter.com - Aldiss Erin\n" + 
				"jcarlson6@jalbum.net - Carlson Joann\n" + 
				"cphoebe3@patch.com - Phoebe Corby";
		
		String testElencoCognome = "ealdiss8@kickstarter.com - Aldiss Erin\n" + 
				"oausti@printfriendly.com - Aust Ottilie\n" + 
				"scaneyj@hc360.com - Caney Scarface\n" + 
				"jcarlson6@jalbum.net - Carlson Joann\n" + 
				"iesus@cristo.inri - Cristo Gesu\n" + 
				"cduchatel4@sogou.com - Duchatel Casar\n" + 
				"fellistone@webmd.com - Elliston Florry\n" + 
				"jfilerd@elpais.com - Filer June\n" + 
				"ygironea@overblog.com - Girone Yulma\n" + 
				"dgounardf@yahoo.co.jp - Gounard Dulce\n" + 
				"lhansong@webmd.com - Hanson Linnie\n" + 
				"ajaher5@moonfruit.com - Jaher Artus\n" + 
				"mlottrington7@wufoo.com - Lottrington Mallorie\n" + 
				"kmauditt9@etsy.com - Mauditt Katharina\n" + 
				"wmogridgeh@tripadvisor.com - Mogridge Walsh\n" + 
				"cparlourc@barnesandnoble.com - Parlour Cassey\n" + 
				"cphoebe3@patch.com - Phoebe Corby\n" + 
				"cprendeguestb@canalblog.com - Prendeguest Corenda";
		
		if (u1 instanceof Admin){
			System.out.println("Test registraUtente – Primo utente Admin");
		} else {
			System.err.println("Test registraUtente – Primo utente Admin (Nel caso di prima registrazione, l’utente creato avrà il ruolo di Admin)");
		}

		if (u2 instanceof Acquirente){
			System.out.println("Test registraUtente – Secondo utente Acquirente");
		} else {
			System.err.println("Test registraUtente – Secondo utente Acquirente (mentre per utenti successivi al primo il ruolo sarà quello di Acquirente)");
		}

		if (u3.getPassword() == null){
			System.out.println("Test registraUtente – Password ritornata null");
		} else {
			System.err.println("Test registraUtente – Password ritornata null (nel caso di nuova registrazione, il valore di ritorno sarà invece rappresentato da un oggetto rappresentante il nuovo utente, della tipologia appropriata e con password a null)");
		}

		if (u21 == null){
			System.out.println("Test registraUtente – Password senza numeri");
		} else {
			System.err.println("Test registraUtente – Password senza numeri (che contenga almeno un numero)");
		}

		if (u22 == null){
			System.out.println("Test registraUtente – Password non ha maiuscole");
		} else {
			System.err.println("Test registraUtente – Password non ha maiuscole (che contenga almeno un carattere maiuscolo)");
		}

		if (u23 == null){
			System.out.println("Test registraUtente – Password ha meno di 8 caratteri");
		} else {
			System.err.println("Test registraUtente – Password ha meno di 8 caratteri (ovvero che sia lunga non meno di 8 caratteri)");
		}

		if (u24 == null){
			System.out.println("Test registraUtente – Email non ha @");
		} else {
			System.err.println("Test registraUtente – Email non ha @ (si assuma per semplicità che un’email sia valida qualora contenga il carattere @)");
		}

		if (u25.equals(u6)){
			System.out.println("Test registraUtente – Email già usata");
		} else {
			System.err.println("Test registraUtente – Email già usata (email (univoca))");
		}

		if (cercaUtenteGiusto.equals(u7)){
			System.out.println("Test cercaUtente – Corretto");
		} else {
			System.err.println("Test cercaUtente – Corretto (ritorna l’utente desiderato se esistente)");
		}

		if (cercaUtenteSbagliato == null){
			System.out.println("Test cercaUtente – Utente non esiste");
		} else {
			System.err.println("Test cercaUtente – Utente non esiste (null altrimenti)");
		}

		if (loginUtenteCorretto.equals(u4)){
			System.out.println("Test loginUtente – Corretto");
		} else {
			System.err.println("Test loginUtente – Corretto");
		}

		if (loginUtenteNonEsiste == null){
			System.out.println("Test loginUtente – Non esiste");
		} else {
			System.err.println("Test loginUtente – Non esiste");
		}

		if (loginUtentePasswordSbagliata == null){
			System.out.println("Test loginUtente – Password sbagliata");
		} else {
			System.err.println("Test loginUtente – Password sbagliata");
		}

		if (loginUtenteGiaConnesso == null){
			System.out.println("Test loginUtente – Utente già connesso");
		} else {
			System.err.println("Test loginUtente – Utente già connesso");
		}

		if (logoutUtenteCorretto.equals(u4)){
			System.out.println("Test logoutUtente – Corretto");
		} else {
			System.err.println("Test logoutUtente – Corretto");
		}

		if (logoutUtenteNonEsistente == null){
			System.out.println("Test logoutUtente – Utente non esistente");
		} else {
			System.err.println("Test logoutUtente – Utente non esistente");
		}

		if (logoutUtenteNonConnesso == null){
			System.out.println("Test logoutUtente – Utente non connesso");
		} else {
			System.err.println("Test logoutUtente – Utente non connesso");
		}

		if (verificaConnessioneNonEsistente == null){
			System.out.println("Test verificaConnessioneUtente – Utente non esistente");
		} else {
			System.err.println("Test verificaConnessioneUtente – Utente non esistente");
		}

		if (verificaConnessioneNonConnesso == null){
			System.out.println("Test verificaConnessioneUtente – Utente non connesso");
		} else {
			System.err.println("Test verificaConnessioneUtente – Utente non connesso");
		}

		if (verificaConnessioneCorretto.equals(u6)){
			System.out.println("Test verificaConnessioneUtente – Corretto");
		} else {
			System.err.println("Test verificaConnessioneUtente – Corretto");
		}

		if (eliminaUtenteRichiedenteNonAutorizzato == null){
			System.out.println("Test eliminaUtente – Richiedente non autorizzato");
		} else {
			System.err.println("Test eliminaUtente – Richiedente non autorizzato");
		}

		if (eliminaUtenteRichiedenteNonConnesso == null){
			System.out.println("Test eliminaUtente – Richiedente non connesso");
		} else {
			System.err.println("Test eliminaUtente – Richiedente non connesso");
		}

		if (eliminaUtenteRichiedenteNonEsiste == null){
			System.out.println("Test eliminaUtente – Richiedente non esiste");
		} else {
			System.err.println("Test eliminaUtente – Richiedente non esiste");
		}

		if (eliminaUtenteDestinatarioNonEsiste == null){
			System.out.println("Test eliminaUtente – Destinatario non esiste");
		} else {
			System.err.println("Test eliminaUtente – Destinatario non esiste");
		}

		if (eliminaUtenteDestinatarioCorrettoConnesso.equals(u2)){
			System.out.println("Test eliminaUtente – (1) Destinatario corretto e connesso");
		} else {
			System.err.println("Test eliminaUtente – (1) Destinatario corretto e connesso");
		}

		if (w.verificaConnessioneUtente("bono@vox.com") == null){
			System.out.println("Test eliminaUtente – (1) Verifica che sia disconnesso");
		} else {
			System.err.println("Test eliminaUtente – (1) Verifica che sia disconnesso");
		}

		if (w.cercaUtente("bono@vox.com") == null){
			System.out.println("Test eliminaUtente – (1) Controlla che sia cancellato");
		} else {
			System.err.println("Test eliminaUtente – (1) Controlla che sia cancellato");
		}

		if (eliminaUtenteSeStesso.equals(u3)){
			System.out.println("Test eliminaUtente – (2) Destinatario elimina se stesso");
		} else {
			System.err.println("Test eliminaUtente – (2) Destinatario elimina se stesso");
		}

		if (w.cercaUtente("cleestut2@oracle.com") == null){
			System.out.println("Test eliminaUtente – (2) Controlla che sia cancellato");
		} else {
			System.err.println("Test eliminaUtente – (2) Controlla che sia cancellato");
		}

		if (w.elencoUtentiPerEmail().equals(testElencoUtentiPerEmail)){
			System.out.println("Test elencoUtentiPerEmail");
		} else {
			System.err.println("Test elencoUtentiPerEmail");
		}

		if (x.elencoUtentiPerEmail().equals(testElencoVuoto)){
			System.out.println("Test elencoUtentiPerEmail – Elenco Vuoto");
		} else {
			System.err.println("Test elencoUtentiPerEmail – Elenco Vuoto");
		}

		if (w.elencoAccessiUtentePerTimestamp("iesus@cristo.inri").equals(testElencoAccessiUtente1)){
			System.out.println("Test elencoAccessiUtentePerTimestamp – utente Cristo Gesu (Logged In)");
		} else {
			System.err.println("Test elencoAccessiUtentePerTimestamp – utente Cristo Gesu (Logged In)");
		}

		if (w.elencoAccessiUtentePerTimestamp("cduchatel4@sogou.com").equals(testElencoAccessiUtente2)){
			System.out.println("Test elencoAccessiUtentePerTimestamp – utente Duchatel Casar (Logged Out)");
		} else {
			System.err.println("Test elencoAccessiUtentePerTimestamp – utente Duchatel Casar (Logged Out)");
		}

		if (w.elencoAccessiUtentePerTimestamp("dgounardf@yahoo.co.jp").equals(testElencoVuoto)){
			System.out.println("Test elencoAccessiUtentePerTimestamp – utente Gounard Dulce (No Login)");
		} else {
			System.err.println("Test elencoAccessiUtentePerTimestamp – utente Gounard Dulce (No Login)");
		}

		if (w.elencoAccessiUtentePerTimestamp("ermet.ico@kabala.com").equals(testElencoVuoto)){
			System.out.println("Test elencoAccessiUtentePerTimestamp – utente Non Esistente");
		} else {
			System.err.println("Test elencoAccessiUtentePerTimestamp – utente Non Esistente");
		}

		if (w.elencoUtentiConnessiPerDataNascita().equals(testElencoConnessi)){
			System.out.println("Test elencoUtentiConnessiPerDataDiNascita");
		} else {
			System.err.println("Test elencoUtentiConnessiPerDataDiNascita");
		}

		if (x.elencoUtentiConnessiPerDataNascita().equals(testElencoVuoto)){
			System.out.println("Test elencoUtentiConnessiPerDataDiNascita – Elenco Vuoto");
		} else {
			System.err.println("Test elencoUtentiConnessiPerDataDiNascita – Elenco Vuoto");
		}

		if (w.elencoUtentiPerCognome().equals(testElencoCognome)){
			System.out.println("Test elencoUtentiPerCognome");
		} else {
			System.err.println("Test elencoUtentiPerCognome");
		}

		if (x.elencoUtentiPerCognome().equals(testElencoVuoto)){
			System.out.println("Test elencoUtentiPerCognome – Elenco Vuoto");
		} else {
			System.err.println("Test elencoUtentiPerCognome – Elenco Vuoto");
		}


		
	}

}
