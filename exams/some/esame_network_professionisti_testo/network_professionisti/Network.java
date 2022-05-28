package network_professionisti;

import java.util.*;

public class Network {

	public Iscritto nuovoIscritto(String nome, String cognome, String web, String email, String descrizione) {
		return null;
	}

	public Iscritto cercaIscrittoPerId(String id) {
		return null;
	}
	
	public Iscritto cercaIscrittoPerNomeCognome(String nome, String cognome) {
		return null;
	}

	public Collection<Iscritto> elencoIscritti() {
		return null;
	}
	
	public Entita nuovaEntita(String nome, String nazione, String indirizzo) throws EccezioneEntitaGiaDefinita {
		return null;
	}

	public Entita nuovaEntita(String nome, String nazione, String indirizzo, String settore, int numeroDipendenti) throws EccezioneEntitaGiaDefinita {
		return null;
	}
	
	public Collection<Azienda> elencoAziendePerNome(){
		return null;
	}			

	public Collection<Azienda> elencoAziendePerNumeroDipendenti(){
		return null;
	}			
	
	public Collection<CentroDiFormazione> elencoCentriDiFormazionePerNome(){
		return null;
	}			

	public Collection<CentroDiFormazione> elencoCentriDiFormazioneInNazionePerNome(String nazione){
		return null;
	}			

	public Collection<Entita> elencoEntita(){
		return null;
	}			
	
	public void nuovoPeriodoDiFormazione(String idIscritto, String nomeCentroFormazione,String da, String a, String titolo) {
	}

	public String titoliFormazioneDateCrescenti(String idIscritto) {
		return null;
	}
	
	public String titoliFormazioneDateDecrescenti(String idIscritto) {
		return null;
	}

	public void nuovoPeriodoInAzienda(String idIscritto, String nomeAzienda,String da, String a, String ruolo) {
	}
	
	public String ruoliAziendaDateCrescenti(String idIscritto) {
		return null;
	}
	
	public String ruoliAziendaDateDecrescenti(String idIscritto) {
		return null;
	}
	
	public void nuovaConnessione(String idIscritto1, String idIscritto2) {
	}
	
	public Collection<Iscritto> elencoConnessioni(String idIscritto){
		return null;
	}
	
	public Collection<Iscritto> elencoConnessioniSuggerite(String idIscritto){
		return null;
	}
	
}

