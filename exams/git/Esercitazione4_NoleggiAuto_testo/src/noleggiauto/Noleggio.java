package noleggiauto;

public class Noleggio {
	private Auto auto;
	private Cliente cliente;
	private String dataInizio;
	private String dataFine;
	
	public Noleggio(Auto auto, Cliente cliente, String dataInizio, String dataFine) {
		this.auto = auto;
		this.cliente = cliente;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Auto getAuto() {
		return auto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}
	
	public boolean overlapDate(String nuovaDataInizio, String nuovaDataFine) {
		// ((StartA <= EndB)  and  (EndA >= StartB))
		// Ritorna true se le date si sovrappongono, false se no
		int startA [] = this.decodificaStringaData(this.dataInizio);
		int endA [] = this.decodificaStringaData(this.dataFine);
		int startB [] = this.decodificaStringaData(nuovaDataInizio);
		int endB [] = this.decodificaStringaData(nuovaDataFine);
		
		boolean checkGiorni = (startA[0] <= endB[0]) && (endA[0] >= startB[0]) ;
		boolean checkMese = (startA[1] == startB[1]) && (endA[1] == endB[1]) && (startA[1] == endB[1]);
		boolean checkAnno = (startA[2] == startB[2]) && (endA[2] == endB[2]) && (startA[2] == endB[2]);
		
		return checkGiorni && checkMese && checkAnno;
	}
	
	private int[] decodificaStringaData(String data) {
		// AAAAMMDD in {D,M,A}
		int d = Integer.parseInt(data.substring(6,8));
		int m = Integer.parseInt(data.substring(4,6));
		int y = Integer.parseInt(data.substring(0,5));
		int res[] = {d, m, y};
		return res;
	}
	
	public boolean orderDate(String dataInizio, String dataFine) {
		int start [] = this.decodificaStringaData(dataInizio);
		int end [] = this.decodificaStringaData(dataFine);
		if (start[0] <= end[0] && start[1] == end[1] && start[2] == end[2]) {
			return true;
		} else {
			return false;
		}
	}
	
	public int calcolaCosto() {
		int dataInizioNum [] = this.decodificaStringaData(this.dataInizio);
		int dataFineNum [] = this.decodificaStringaData(this.dataFine);
		return (dataFineNum[0] - dataInizioNum[0] + 1) * this.auto.getCostoGiornaliero();
	}
	
	public boolean contentEquals(Noleggio altroNoleggio) {
		if (this.auto.getTarga().contentEquals(altroNoleggio.auto.getTarga()) &&
				this.getCliente().getCodice().contentEquals(altroNoleggio.getCliente().getCodice()) &&
				this.getDataInizio().contentEquals(altroNoleggio.getDataInizio()) &&
				this.getDataFine().contentEquals(altroNoleggio.getDataFine())){
			return true;
		} else return false;
	}
}
