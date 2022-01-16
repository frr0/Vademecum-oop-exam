package palinsesti;

public class Programma implements Comparable<Programma>{

	String id;
	String nome;
	Palinsesto palinsesto;
	
	public Programma(String id, Palinsesto palinsesto, String nome) {
		this.id=id;
		this.nome=nome;
		this.palinsesto=palinsesto;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Palinsesto getPalinsesto() {
		return palinsesto;
	}

	@Override
	public int compareTo(Programma altro) {

		if(nome.compareTo(altro.getNome())!=0)
			return nome.compareTo(altro.getNome());

		if(palinsesto.nome.compareTo(altro.palinsesto.nome)!=0)
			return palinsesto.nome.compareTo(altro.palinsesto.nome);
		
		if(palinsesto.canale.compareTo(altro.palinsesto.canale)!=0)
			return palinsesto.canale.compareTo(altro.palinsesto.canale);
		
		return 0;
		
	}
	
	
	
}
