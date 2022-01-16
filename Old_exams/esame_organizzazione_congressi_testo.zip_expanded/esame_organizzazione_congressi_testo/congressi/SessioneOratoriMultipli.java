package congressi;

import java.util.*;
public class SessioneOratoriMultipli extends Sessione {

	private Map<String, String> oratori;
	
	public SessioneOratoriMultipli(int numeroSeriale, Congresso congresso, Sala sala, String nome, String data,
			String daOra, String adOra) {
		super(numeroSeriale, congresso, sala, nome, data, daOra, adOra);
		this.oratori = new TreeMap<String, String>();
	}
	
	public void allocaOratore(String cognomeNome, String ora) {
		this.oratori.put(ora, cognomeNome);
	}
	
	public Collection<String> getOratori(){
		return this.oratori.values();
	}
	
	public Collection<String> getOrari(){
		return this.oratori.keySet();
	}
	
	public String getOratore(String key) {
		return this.oratori.get(key);
	}
	

}
