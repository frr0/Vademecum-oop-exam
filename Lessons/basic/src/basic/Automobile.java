package basic;

//PROCESSO DI ASTRAZIONE

public class Automobile { // Molto simile alla struct del C ...
                          // ... ma con qualcosa in più

	// Stesse informazioni della struct del C, ma con approccio OOP

	// ATTRIBUTI / DATI
	public String targa;
	public String marca;
	String modello;
	int cilindrata;
	private boolean accesa; // Tutti gli attributi dovrebbero 
	                        // essere dichiarati come private
	                        // ed acceduti attraverso le funzioni
	                        // (INFORMATION HIDING)
	
	// METODI, FUNZIONI o OPERAZIONI SUI DATI (ENCAPSULATION), in genere public
	
	// COSTRUTTORE/I 
	
	// Ogni classe Java viene automaticamente dotata di un costruttore 
	// chiamato "di default", senza parametri, pensato (come tutti i 
	// costruttori) per costruire l'oggetto ed inizializzarlo (anche se non
	// si vede, e' come se ci fosse)
	
	/*public Automobile() {
		targa = null;   // Facendo così ho praticamente riprodotto
		marca = null;   // il comportamento del costruttore di default,
		modello = null; // poco utile se non cambio nulla (come fatto dopo)
		cilindrata = 0;
		accesa = false;
	}
	*/
	
	// Se fosse una funzione "normale" dovrebbe restituire qualcosa
    // ma per i costruttori è superfluo (sarà sicuramente un'Automobile, implicito)
	
	public Automobile() {        // Posso SOVRASCRIVERE il comportamento
		targa = "Non assegnata"; // del costruttore vuoto indicando altre
		marca = "Audi";          // modalità di inizializzazione di mio interesse
		modello = "";
		cilindrata = -1;
		accesa = false; // Es., forzo un'inizializzazione specifica, tutte Audi all'inizio
	}
	
	public Automobile(String t) { // Potrei avere anche altri costruttori
		targa = t;
		marca = "Audi";
		// ... il compito del costruttore inizializzare l'oggetto
	}
	
	// Se non lo facciamo noi, ci pensa Java con il costruttore di default
	// Java GARANTISCE una inizializzazione per tutti gli attributi delle classi
	// int a 0, virgola a 0.0, boolean a false, String a null, ecc.
	
	// ALTRI METODI
	
	// Spesso public, per essere l'interfaccia dell'oggetto (e consentire 
	// un accesso, in lettura e/o scrittura, a dati/attributi magari private)
	
	public void accendi() {        
		// Anche più istruzioni, esempio dei controlli
		// Se la batteria è carica, allora ...
		// altrimenti ...
		accesa = true;      
	}
	
	public void vendi() {
		// Esegue le istruzioni per la vendita
		// ... anche più di una
	}
	
	public void spegni() {
		accesa = false;
	}
	
	public boolean dimmiSeSeiAccesa() {
		return accesa;
	}
	
	// Qui si potrebbero aggiungere altri metodi ancora 

	// Non necessariamente tutti pubblici, es. se non devono essere acceduti dal di fuori della classe)

} // Fine della classe

//Per poter utilizzare la classe definita, occorre crearne delle istanze
//(oggetti), ma non qui, in un'altra classe (nel caso specifico, nel file Classi, 
//dove c'e' il main(), applicazione)

