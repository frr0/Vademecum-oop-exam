import elezioni.*;

public class Esempio {

	public static void main(String[] args) {

		Elezione model = new Elezione();
		model.registraLista(new Lista("Partito 1","Motto A"));
		model.registraLista(new Lista("Partito 2", "Motto B"));
		
		model.aggiungiElettore("Giovanni", "Bianchi");
		model.aggiungiElettore("Mario", "Rossi");
		
		GuiCreaListe gui = new GuiCreaListe(model);
		
		gui.setVisible(true);
		
	}

}
