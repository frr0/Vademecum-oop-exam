package piano_vaccinazioni;

import java.util.*;

public class Piano {

	public Cittadino registraCittadino(String codiceTesseraSanitaria, String nome, String cognome, String dataDiNascita, String regione) {
		return null;
	}

	public Collection<Cittadino> elencoCittadiniPerCognomeNome() {
		return null;
	}

	public Collection<Cittadino> elencoCittadiniPerDataDiNascita() {
		return null;
	}

	public Collection<Cittadino> cercaCittadiniEtaMinima(int etaMinima){
		return null;
	}
	
	public Centro attivaCentro(String regione, int numeroMassimoDosi) {
		return null;
	}
	
	public Centro cercaCentro(String codiceCentro) {
		return null;
	}
	
	public void consegnaDosiVaccino(String codiceCentro, char tipoVaccino, int numeroDosi) throws EccezioneConsegnateMenoDosi {		
	}
	
	public int numeroDosiTipoVaccinoCentro(String codiceCentro, char tipoVaccino){
		return -1;
	}
	
	public int numeroDosiCentro(String codiceCentro) {
		return -1;
	}
	
	public char vaccina(String codiceTesseraSanitaria, String data) throws EccezioneDosiVaccinoNonDisponibili {
		return ' ';
	}

	public String stampaUltimaVaccinazioneCittadino(String codiceTesseraSanitaria) {
		return null;
	}
	
	public String stampaVaccinazioni() {
		return null;
	}
	
	public double percentualeUtilizzoDosi(String regione) {
		return -1;
	}

}

