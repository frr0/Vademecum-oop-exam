package perFra;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("holaaa");
		
		Principale p=new Principale();
		
		
		p.addMacchina("a", 0);
		p.addMacchina("b", 3);
		p.addMacchina("c", 2);
		p.addMacchina("f", 1);
		p.addMacchina("a", 2);
		
		//System.out.println(p.ordinaElenco());
		//System.out.println(p.ordinaElencoLambda());
		System.out.println(p.ordinaElencoReversed()); //in caso di parità guarda i codici

	}

}
