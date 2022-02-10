package piano_vaccinazioni;

import java.util.*;
import java.util.stream.Collectors;

public class Piano {
	LinkedList<Cittadino> listCittadini = new LinkedList<>();
	LinkedHashMap<String, Cittadino> cittadinopercodice = new LinkedHashMap<>();
	LinkedList<Centro> listCentri = new LinkedList<>();
	LinkedHashMap<String, Centro> centripercodice = new LinkedHashMap<>();

	public Cittadino registraCittadino(String codiceTesseraSanitaria, String nome, String cognome, String dataDiNascita, String regione) {
		Cittadino c = new Cittadino(codiceTesseraSanitaria, nome, cognome, dataDiNascita, regione);
		listCittadini.add(c);
		cittadinopercodice.put(codiceTesseraSanitaria, c);
		return c;
	}

	public Collection<Cittadino> elencoCittadiniPerCognomeNome() {
		return listCittadini.stream().sorted(Comparator.comparing(Cittadino::getCognome).thenComparing(Cittadino::getNome)).collect(Collectors.toList());
	}

	public Collection<Cittadino> elencoCittadiniPerDataDiNascita() {
		return listCittadini.stream().sorted(Comparator.comparing(Cittadino::getDataDiNascita)).collect(Collectors.toList());
	}

	public Collection<Cittadino> cercaCittadiniEtaMinima(int etaMinima){
		return listCittadini.stream().filter(ci -> ci.getEta() >= etaMinima).collect(Collectors.toList());
	}
	
	public Centro attivaCentro(String regione, int numeroMassimoDosi) {
		int n = 1;
		Centro c = null;
		for (Centro ci: listCentri) {
			if (ci.getRegione().compareTo(regione) == 0) {
				ci.setNumREgione(ci.getNumREgione()+1);
				n = ci.getNumREgione();
			}
		}
		String codice = regione.substring(0, 3) + n;
		codice = codice.toUpperCase();
		c = new Centro(regione, numeroMassimoDosi, codice, n);
		listCentri.add(c);
		centripercodice.put(codice, c);
		return c;
	}
	
	public Centro cercaCentro(String codiceCentro) {
		return centripercodice.get(codiceCentro);
	}
	
	public void consegnaDosiVaccino(String codiceCentro, char tipoVaccino, int numeroDosi) throws EccezioneConsegnateMenoDosi {		
		Centro tmp = cercaCentro(codiceCentro);
		if (numeroDosi > tmp.numeroMassimoDosi) {
			if (tipoVaccino == 'A') {
				tmp.setNumA(tmp.numeroMassimoDosi);
				tmp.consegnato = true;
			} else if (tipoVaccino == 'B') {
				tmp.setNumB(tmp.numeroMassimoDosi);
				tmp.consegnato = true;
			}
			throw new EccezioneConsegnateMenoDosi();
		} else {
			if (tipoVaccino == 'A') {
				tmp.setNumA(tmp.getNumA()+numeroDosi);
				tmp.consegnato = true;
			} else if (tipoVaccino == 'B') {
				tmp.setNumB(tmp.getNumB()+numeroDosi);
				tmp.consegnato = true;
			}
		}
	}
	
	public int numeroDosiTipoVaccinoCentro(String codiceCentro, char tipoVaccino){
		Centro tmp = cercaCentro(codiceCentro);
		return tipoVaccino == 'A'?tmp.getNumA():tmp.getNumB();
	}
	
	public int numeroDosiCentro(String codiceCentro) {
		Centro tmp = cercaCentro(codiceCentro);
		int n = tmp.getNumA()+tmp.getNumB();
		return n;
	}
	
	public char vaccina(String codiceTesseraSanitaria, String data) throws EccezioneDosiVaccinoNonDisponibili {
		Vaccinazione v = new Vaccinazione();
		Cittadino tmp = cittadinopercodice.get(codiceTesseraSanitaria);
		String reg = tmp.getRegione();
		if (tmp.getNumVaccini() == 0) {
			tmp.setNumVaccini(tmp.getNumVaccini()+1);
			for(Centro ci: listCentri) {
				if (ci.getRegione().compareTo(reg) == 0) {
					if (numeroDosiCentro(ci.getCodice()) > 0) {
						if (numeroDosiTipoVaccinoCentro(ci.getCodice(), 'A') > 0) {
							tmp.setData1(data);
							tmp.tipovaccino = 'A';
							return 'A';
						} else if (numeroDosiTipoVaccinoCentro(ci.getCodice(), 'A') > 0) {
							tmp.setData1(data);
							tmp.tipovaccino = 'B';
							return 'B';
						} else {
							throw new EccezioneDosiVaccinoNonDisponibili();
						}
					}
				}
			}

		} else if (tmp.getNumVaccini() == 0) {
			tmp.setNumVaccini(tmp.getNumVaccini()+1);
			for(Centro ci: listCentri) {
				if (ci.getRegione().compareTo(reg) == 0) {
					if (numeroDosiCentro(ci.getCodice()) > 0) {
						if (tmp.tipovaccino == 'A') { 
							if (numeroDosiTipoVaccinoCentro(ci.getCodice(), 'A') > 0) {
								tmp.setC(ci.getCodice());
								tmp.setData2(data);
								tmp.tipovaccino = 'A';
								return 'A';
							} else {
								throw new EccezioneDosiVaccinoNonDisponibili();
							}
						} else if (tmp.tipovaccino == 'B') {
							if (numeroDosiTipoVaccinoCentro(ci.getCodice(), 'B') > 0) {
								tmp.setC(ci.getCodice());
								tmp.setData2(data);
								tmp.tipovaccino = 'B';
								return 'B';
							} else {
								throw new EccezioneDosiVaccinoNonDisponibili();
							}
						}
					}
				}
			}
		}
		return ' ';
	}

	public String stampaUltimaVaccinazioneCittadino(String codiceTesseraSanitaria) {
		Cittadino tmp = cittadinopercodice.get(codiceTesseraSanitaria);
		String s = null;
		if (tmp.data2 == null) {
			s = tmp.getCodiceTesseraSanitaria()+" "+tmp.getC()+" "+tmp.getData2()+" "+tmp.getTipovaccino();
		} else {
			s = tmp.getCodiceTesseraSanitaria()+" "+tmp.getC()+" "+tmp.getData2()+" "+tmp.getTipovaccino()+" (R)";
		}
		return s;
	}
	
	public String stampaVaccinazioni() {
		Cittadino tmp = null;
		String s = null;
		s = tmp.getCodiceTesseraSanitaria()+" "+tmp.getC()+" "+tmp.getData2()+" "+tmp.getTipovaccino();
		return s;
	}
	
	public double percentualeUtilizzoDosi(String regione) {
		return -1;
	}

}

