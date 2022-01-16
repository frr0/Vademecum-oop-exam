package collezioni;

public class CollezioneLista implements Collezione {

	// Altra implementazione di Collezione, basata su una 
	// struttura dati di tipo lista (linkata)
	
	// Collezione "dinamica" in grado di evolvere
	// in termini di dimensione, in base
	// al numero di elemento effettivamente
	// da memorizzare

	ElementoLista testa; // = null;
	int cnt;
	
	public CollezioneLista(){
		testa = null; // Inizialmente lista vuota, testa a null
		cnt = 0;
	}
	
	// Implementazione del metodo che aggiunge un nuovo elemento in testa alla lista

	@Override
	public void aggiungi(Object daAggiungere) {
		
		// DOVRO'
		
		// 0) CREARE IL NUOVO ELEMENTO DA INSERIRE NELLA LISTA, DI TIPO
		//    ElementoLista, SCRIVENDOGLI "NELLA PANCIA" IL DATO 
		//    PASSATO COME PARAMETRO, daAggiungere

		ElementoLista eTemp = new ElementoLista();
		eTemp.dato = daAggiungere;
		
		// 1) AGGIORNARE IL SUCCESSORE DEL NUOVO ELEMENTO, 
		//    FACENDOLO PUNTARE A QUELLA CHE ERA LA TESTA
		
		eTemp.prossimo = testa;
		
		// 2) AGGIORNARE LA TESTA, FACENDOLA "PUNTARE" 
		//    AL NUOVO ELEMENTO

		testa = eTemp;
		cnt++;
		
	}

	@Override
	public int dimensione() {
		return cnt;
	}

	@Override
	public String toString() {
		
		String s = "";
		ElementoLista corrente = testa; // INIZIALIZZO EL. CORRENTE ALLA TESTA

		while(corrente!=null) {
			s+=corrente.dato.toString()+"\n"; // STAMPO LA "PANCIA" DELL'EL., NON L'ELEMENTO
			corrente = corrente.prossimo; // MI SPOSTO "SULLE FRECCIE"
		}
		return s;
	}

	@Override
	public boolean contiene(Object daCercare) {
		
		ElementoLista corrente = testa;
		while(corrente!=null)
			if(corrente.dato.equals(daCercare))
				return true;
			else 
				return false;
		
		return false;
	}

	
	
}
