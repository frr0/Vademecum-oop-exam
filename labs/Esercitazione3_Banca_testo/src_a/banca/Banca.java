package banca;

public class Banca {

  Conto conti[] = new Conto[1000];
  Fido[] fidi = new Fido[1000];
  Mutuo[] mutui = new Mutuo[1000];
  Prestito[] prestiti = new Prestito[1000];
  Cliente clienti[] = new Cliente[300];
  int i = -1;
  String I;
  int a = 0;
  int w = 0;
  int ww = 0;
  int www = 0;
  int n_conti = 0;
  int n_clienti = 0;

  public Banca() {
  }

  public Conto nuovoConto(double tassoInteresse, double capitale, String dataApertura, String nomeOperatore, String nomeFiliale) {
    i++;
    if (i < 10) { I = "00" + Integer.toString(i); }
    else if (i > 10 && i < 100) { I = "0" + Integer.toString(i); }
    else if (i > 100 && i < 1000) { I = Integer.toString(i); }
    Conto c = new Conto(I, tassoInteresse, capitale, dataApertura, nomeOperatore, nomeFiliale);
    conti[i] = c;
    return c;
  }

  public Conto cercaConto(String codiceConto) {
    for (int i = 0; i<conti.length; i++) {
      /* System.out.println(conti.length); */

      if (codiceConto.compareTo(conti[i].getCodice()) == 0) {
        return conti[i];
      }
    }
    return null;
  }

  public Conto[] cercaConti(String daCercare) {
  Conto trovati[] = new Conto[1000];
    for (int i = 0; i<conti.length; i++) {
      /* System.out.println(conti.length); */

      Boolean found;
      found = conti[i].getNomeOperatore().contains(daCercare);
      if (found == true) {
        trovati[i] = conti[i];
        found = false;
        return trovati;
      }
      found = conti[i].getNomeFiliale().contains(daCercare);
      if (found == true) {
        trovati[i] = conti[i];
        found = false;
        return trovati;
      }

    }
    return null;
  }
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================

  public Cliente nuovoCliente(String codiceFiscale, String cognome, String nome, String professione) {
	if (n_clienti == 0) {
    i = 0;
		Cliente cc = new Cliente(codiceFiscale, cognome, nome, professione);
		clienti[i] = cc; n_clienti++; i++;
	} else {
      for (int i = 1; i<n_clienti; i++) {
          /* System.out.println("gdfjksghjksdlghsdfjkghsdfklh"); */
        if (codiceFiscale.compareTo(clienti[i].getCodiceFiscale()) == 0) {
          /* System.out.println("gdfjksghjksdlghsdfjkghsdfklh"); */
          clienti[i].setNome(nome);
          clienti[i].setCognome(cognome);
          clienti[i].setProfessione(professione);
          /* System.out.println("gdfjksghjksdlghsdfjkghsdfklh"); */
        }
      }
      Cliente cc = new Cliente(codiceFiscale, cognome, nome, professione);
      clienti[i] = cc; n_clienti++;
    }

  /* System.out.println("gdfjksghjksdlghsdfjkghsdfklh"); */
  return clienti[i];
  }

  public Cliente cercaCliente(String codiceFiscale) {
          /* System.out.println("gdfjksghjksdlghsdfjkghsdfklh"); */
          /* System.out.println("here"); */
    for (int q= 0; q<n_clienti; q++) {
//          System.out.println(clienti[q].getCodiceFiscale());
      if (codiceFiscale.compareTo(clienti[q].getCodiceFiscale()) == 0) {
        return clienti[q];
      }
    }
    /* System.out.println("hh"); */
    return null;
  }
  
  public boolean[] associaClienteConto(String codiceFiscale, String[] codiciConto) {
    boolean[] b = new boolean[1000];
    for (int i = 0; i < n_clienti; i++) {
      if (codiceFiscale.compareTo(clienti[i].getCodiceFiscale()) == 0) {
		for (int j = 0; j<codiciConto.length; j++) {
			for (int k = 0; k<codiciConto.length; k++) {
			  if (codiciConto[j].compareTo(conti[k].getCodice()) == 0) {
          clienti[i].c[k] = conti[k];
          clienti[i].n_of_conti++;
				  b[i] = true;
			  }
			}
		}
      }
    }
	b[i] = false;
	return b;
  }

  public Cliente intestatario(String codiceConto) {
    for (int q= 0; q<n_clienti; q++) {
      for (int u= 0; u<1000; u++) {
        if (codiceConto.compareTo(clienti[q].c[u].getCodice()) == 0) {
          return clienti[u];
        }
      }
    }
    return null;
  }

  public String contiCliente(String codiceFiscale) {
    String aa = "";
    for (int q= 0; q<n_clienti; q++) {
      if (codiceFiscale.compareTo(clienti[q].getCodiceFiscale()) == 0) {
      for (int u = 0; u<clienti[q].n_of_conti; u++) {
          aa += clienti[q].c[u].getCodice() + "\n";
        }
      }
    }
    aa = aa.substring(0, aa.length()-1);
    return aa;
  }

  public String clientiConto(String codiceConto) {
    String aaa = "";
    for (int q= 0; q<n_clienti; q++) {
      for (int u = 0; u<clienti[q].n_of_conti; u++) {
        if (codiceConto.compareTo(clienti[q].c[u].getCodice()) == 0) {
          //not done
            aaa += clienti[q].getCodiceFiscale() + "\n";
          }
      }
    }
    if (aaa != null) { aaa = aaa.substring(0, aaa.length()-1); }
    return aaa;
  }

  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // 
/* Per i fidi, il metodo riceve come parametri il codice del conto, il codice di un cliente che dovrà fare da garante, l’importo prestato, */
/*  la rata mensile da pagare e un tasso di rischio, e restituisce un oggetto di classe Fido. Il metodo verifica che il codice conto  */
/*  e il codice cliente esistano, che il cliente sia associato al suddetto conto e che il tasso di rischio non superi lo 0.75.  */
/*  Se tutte le suddette verifiche sono soddisfatte, il metodo attiva il fido e aggiorna il capitale associato al conto sul quale  */
/*  è stato versato l’importo del prestito */

  public Fido nuovoPrestito(String codiceConto, String codiceCliente, double importo, double rataMensile, double tassoRischio) {
  Fido f = new Fido(codiceConto, importo, "F", tassoRischio);
    for (int q= 0; q<n_clienti; q++) {
      if (codiceCliente.compareTo(clienti[q].getCodiceFiscale()) == 0 && tassoRischio <= 0.75) {
      for (int u = 0; u<clienti[q].n_of_conti; u++) {
        if (codiceConto.compareTo(clienti[q].c[u].getCodice()) == 0) {
          clienti[q].c[u].setCapitale(clienti[q].c[u].getCapitale() + importo);
          fidi[w] = f;
          prestiti[ww] = f;
          clienti[q].fc[u] = f;
          clienti[q].pc[u] = f;
          w++;
          ww++;
          return f;
        }
      }
    }
  }

    return null;
  }
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  // 

  
   /* Per i mutui, il metodo riceve invece come parametri il codice del conto, il codice di un cliente che dovrà fare da garante, */
   /*  l’importo prestato, la rata mensile da pagare e il numero di mesi in cui il mutuo verrà estinto, e restituisce un oggetto  */
   /*  di classe Mutuo. Il metodo verifica che il codice conto e il codice cliente esistano, che il cliente sia associato al  */
   /*  suddetto conto e, in questo caso, che il cliente non sia garante di altri prestiti. Se tutte le suddette verifiche */
   /*   sono soddisfatte, il metodo attiva il mutuo e aggiorna il capitale associato al conto sul quale è stato versato l’importo  */
   /*   del prestito. Cercando di attivare un prestito per un conto o un cliente non definiti oppure non associati, il metodo non  */
   /*   sortisce alcun effetto. */

  public Mutuo nuovoPrestito(String codiceConto, String codiceCliente, double importo, double rataMensile, int numeroMesi) {
  Mutuo m = new Mutuo(codiceConto, importo, "M");
    for (int q= 0; q<n_clienti; q++) {
      if (codiceCliente.compareTo(clienti[q].getCodiceFiscale()) == 0) {
      for (int u = 0; u<clienti[q].n_of_conti; u++) {
        if (codiceConto.compareTo(clienti[q].c[u].getCodice()) == 0 && clienti[q].mc[u] == null) {
          clienti[q].c[u].setCapitale(clienti[q].c[u].getCapitale() + importo);
          mutui[www] = m;
          clienti[q].mc[u] = m;
          clienti[q].pc[u] = m;
          prestiti[ww] = m;
          www++;
          ww++;
          return m;
        }
      }
    }
  }

    return null;
  }
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================
  //
  /* Il metodo prestiti() della classe Ateneo restituisce un array contenente tutti i prestiti definiti, in ordine di definizione. */
  /*  Una variante del metodo riceve come parametro un codice cliente e restituisce i soli prestiti definiti per quel cliente */
  /*   (nel medesimo ordine). Un’ulteriore variante riceve oltre al codice di un cliente anche una stringa che identifica un tipo */
  /*    di prestito (F oppure M) e restituisce solo i prestiti di quel tipo associati a tale cliente. */

  public Prestito[] prestiti() {
    return prestiti;

  }
  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================

  public Prestito[] prestiti(String codiceFiscale) {
    for (int q= 0; q<n_clienti; q++) {
      if (codiceFiscale.compareTo(clienti[q].getCodiceFiscale()) == 0) {
        /* for (int u = 0; u<clienti[q].n_of_conti; u++) { */
        /*   if (codiceFiscale.compareTo(clienti[q].c[u].getCodice()) == 0) { */
            return clienti[q].pc;
          /* } */
        /* } */
    }
          /* return prestiti; */
  }
          return null;
}

  // ================================================================================================================================
  // ================================================================================================================================
  // ================================================================================================================================

  public Prestito[] prestiti(String codiceFiscale, String tipo) {
    for (int q= 0; q<n_clienti; q++) {
      if (codiceFiscale.compareTo(clienti[q].getCodiceFiscale()) == 0) {
        /* for (int u = 0; u<clienti[q].n_of_conti; u++) { */
        /*   if (codiceFiscale.compareTo(clienti[q].c[u].getCodice()) == 0) { */
            return clienti[q].pc;
        /*   } */
        /* } */
    }
          /* return prestiti; */
  }
          return null;
  }
}


//creare arrai prestiti, e creare mutuo, fido da inserire in prestiti e fine????