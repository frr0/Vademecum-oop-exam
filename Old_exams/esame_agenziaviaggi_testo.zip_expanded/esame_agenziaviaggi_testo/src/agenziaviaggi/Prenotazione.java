package agenziaviaggi;

import java.util.Comparator;

public class Prenotazione {
	protected double importo;
	
	/*
	 * public static Comparator<Utente> reverseEmailComparator = new
	 * Comparator<Utente>(){
	 * 
	 * @Override public int compare(Utente ut1, Utente ut2) { int res =
	 * ut1.getEmail().compareToIgnoreCase(ut2.getEmail()); return res*-1; } };
	 */
	
	public static Comparator<Prenotazione> importoComparator = new Comparator<Prenotazione>() {
		public int compare(Prenotazione p1, Prenotazione p2) {
			double diff = p1.getImporto() - p2.getImporto();
			if (diff > 0) {
				return 1;
			} else if (diff < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	};
	
	public static Comparator<Prenotazione> dataComparator = new Comparator<Prenotazione>() {
		public int compare(Prenotazione p1, Prenotazione p2) {
			int res = p1.getData().compareTo(p2.getData());
			return res;
		}
	};
	
	public String getData() {
		return null;
	}
	
	public Prenotazione(double importo) {
		this.importo = importo;
	}

	public double getImporto(){
		return this.importo;
	}
}
