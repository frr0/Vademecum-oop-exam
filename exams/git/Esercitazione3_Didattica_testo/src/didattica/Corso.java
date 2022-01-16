package didattica;

public class Corso {
	private String codice;
	private String nome;
	private int numeroOre;
	private int numeroSquadre;
	private String periodo;
	private String corsoDiLaurea;
	private int numeroDocenti;
	private Docente docenti[];
	

	public Corso(int codice, String nome, int numeroOre, int numeroSquadre, String periodo, String corsoDiLaurea) {
		String pre = String.valueOf(codice);
		while(pre.length() < 4){
			pre = "0" + pre;
		}
		this.codice = pre;
		this.nome = nome;
		this.numeroOre = numeroOre;
		this.numeroSquadre = numeroSquadre;
		this.periodo = periodo;
		this.corsoDiLaurea = corsoDiLaurea;
		this.numeroDocenti = 0;
		this.docenti = new Docente[5];
	}

	public String getCodice() {
		return this.codice;
	}

	public String getNome() {
		return this.nome;
	}

	public int getNumeroOre() {
		return this.numeroOre;
	}

	public int getNumeroSquadre() {
		return this.numeroSquadre;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public String getCorsoDiLaurea() {
		return this.corsoDiLaurea;
	}

	public String descriviti() {
		String sp = " ";
		return this.codice + sp + this.nome + sp + this.numeroOre + sp + this.numeroSquadre + sp + this.periodo + sp + this.corsoDiLaurea;
	}
	
	public void inserisciDocente(Docente nuovoDocente) {
		if (this.numeroDocenti<5) {
			this.docenti[this.numeroDocenti] = nuovoDocente;
			this.numeroDocenti++;
		}
	}
	
	public int getNumeroDocenti() {
		return this.numeroDocenti;
	}
	
	public Docente[] getDocenti() {
		return this.docenti;
	}

}
