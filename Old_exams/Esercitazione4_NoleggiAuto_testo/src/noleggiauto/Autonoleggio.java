package noleggiauto;
import myList.LogLista;

public class Autonoleggio {
	private LogLista auto;
	
	private LogLista clienti;
	
	private LogLista noleggi;

	public Autonoleggio(){
		this.auto = new LogLista();

		this.clienti = new LogLista();

		this.noleggi = new LogLista();
	}
	
	public Auto aggiungiAuto(String targa, String marca, String modello, String colore, char tipologia) {
		if (this.cercaAuto(targa) == null) {
			switch(tipologia) {
				case 'B':
					Berlina nuovaBerlina = new Berlina(targa, marca, modello, colore);
					this.auto.add(nuovaBerlina);
					return nuovaBerlina;
				case 'C':
					Compatta nuovaCompatta = new Compatta(targa,marca,modello, colore);
					this.auto.add(nuovaCompatta);
					return nuovaCompatta;
				default:
					break;
			}
		} else {
			this.cercaAuto(targa).setColore(colore);
			return this.cercaAuto(targa);
		}
		return null;
	}
	
	public Auto cercaAuto(String targa) {
		for (int i = 0; i < this.auto.length(); i++) {
			if (((Auto) this.auto.getElement(i)).getTarga().contentEquals(targa)) {
				return (Auto) this.auto.getElement(i);
			}
		}
		return null;
	}

	public String elencoAuto() {
		String res = new String();
		String sp = " ";
		for (int i=0; i<this.auto.length(); i++) {
			res += ((Auto) this.auto.getElement(i)).getTarga() + sp + ((Auto) this.auto.getElement(i)).getMarca() + sp + ((Auto) this.auto.getElement(i)).getModello() + sp + ((Auto) this.auto.getElement(i)).getColore() + sp + ((Auto) this.auto.getElement(i)).getTipologia() + "\n";
		}
		return res.substring(0, res.length()-1);
	}
		
	public Cliente registraCliente(String cognome, String nome, String nazionalita, String numeroPatente) {
		if (numeroPatente.length() < 7 || numeroPatente.length() > 10 || nome.length() < 2 || cognome.length() < 2 || nazionalita.length() < 2) {
			return null;
		} else {
			clienti.add(new Cliente(cognome, nome, nazionalita, numeroPatente));
			return (Cliente) clienti.getElement(this.clienti.length() - 1);
		}
	}
	
	public Cliente cercaCliente(String codiceCliente) {
		for (int i = 0; i < clienti.length(); i++) {
			if (((Cliente) this.clienti.getElement(i)).getCodice().contentEquals(codiceCliente)) {
					return (Cliente) this.clienti.getElement(i);
			}
		}
		return null;
	}
	
	public Auto nuovoNoleggio(String codiceCliente, char tipologiaAuto, String dataInizio, String dataFine) {
		Cliente questoCliente = this.cercaCliente(codiceCliente);
		boolean overlap;
		if (questoCliente == null) {
			return null;
		}
		// check tutte le prenotazioni del cliente
		for (int i=0; i<this.noleggi.length(); i++) {
			Noleggio iNoleggio = (Noleggio) this.noleggi.getElement(i);
			if (!iNoleggio.orderDate(dataInizio, dataFine)) {
				return null;
			}
			if (iNoleggio.getCliente().getCodice().contentEquals(codiceCliente) && iNoleggio.overlapDate(dataInizio, dataFine)) {
				return null;
			}
		}
		// check auto
		for (int i=0; i<this.auto.length(); i++) {
			Auto iAuto = (Auto) this.auto.getElement(i);
			if (iAuto.getTipologia() == tipologiaAuto) {
				overlap = false;
				for (int j=0; j<this.noleggi.length(); j++) {
					Noleggio jNoleggio = (Noleggio) this.noleggi.getElement(j);
					if(jNoleggio.getAuto().equals(iAuto) && jNoleggio.overlapDate(dataInizio, dataFine)) {
						overlap = true;
					}
				}
				if (!overlap) {
					this.noleggi.add(new Noleggio(iAuto, questoCliente, dataInizio, dataFine));
					return iAuto;
				}
			}
		}
		return new Auto(null, null, null, null);
	}

	public String elencoNoleggiCliente(String codiceCliente) {
		String res = new String();
		String sp = " ";
		
		Cliente questoCliente = this.cercaCliente(codiceCliente);
		if (questoCliente == null) {
			return null;
		}
		for (int i=0; i<this.noleggi.length(); i++) {
			Noleggio iNoleggio = (Noleggio) this.noleggi.getElement(i);
			if (iNoleggio.getCliente().getCodice().contentEquals(codiceCliente)) {
				res += iNoleggio.getAuto().getTarga() + sp + iNoleggio.getDataInizio() + sp + iNoleggio.getDataFine() + "\n";
			}
		}
		return res.substring(0, res.length()-1);
	}
	
	public String elencoNoleggiAuto(String targa) {
		String res = new String();
		String sp = " ";
		
		Auto questaAuto = this.cercaAuto(targa);
		if (questaAuto == null) {
			return null;
		}
		for (int i=0; i<this.noleggi.length(); i++) {
			Noleggio iNoleggio = (Noleggio) this.noleggi.getElement(i);
			if (iNoleggio.getAuto().getTarga().contentEquals(targa)) {
				res += iNoleggio.getCliente().getCodice() + sp + iNoleggio.getDataInizio() + sp + iNoleggio.getDataFine() + "\n";
			}
		}
		return res.substring(0, res.length()-1);
	}

	public int calcolaCostoNoleggio(String targa, String codiceCliente, String dataInizio, String dataFine) {
		Auto questaAuto = this.cercaAuto(targa);
		Cliente questoCliente = this.cercaCliente(codiceCliente);
		if (questaAuto == null || questoCliente == null) {
			return -1;
		}
		Noleggio questoNoleggio = new Noleggio(questaAuto, questoCliente, dataInizio, dataFine);
		for (int i = 0; i < this.noleggi.length(); i++) {
			if (((Noleggio) this.noleggi.getElement(i)).contentEquals(questoNoleggio)) {
				return questoNoleggio.calcolaCosto();
			}
		}
		return -1;
	}
}


