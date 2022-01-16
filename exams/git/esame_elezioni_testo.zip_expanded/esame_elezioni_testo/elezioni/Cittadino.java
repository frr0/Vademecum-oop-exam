package elezioni;

import java.util.*;

public interface Cittadino {
	public String getNome();
	public String getCognome();
	public boolean haVotato();
	public boolean isCapolista();
	public void setCapolista(boolean b);
	public boolean isCandidato();
	public void setCandidato(boolean b);
	public long getNumeroVoti();
	public void addVoto();
	public void vota();
	
}
