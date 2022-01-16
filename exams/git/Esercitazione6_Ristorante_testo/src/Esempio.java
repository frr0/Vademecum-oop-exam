import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import ristorante.Bevanda;
import ristorante.Cuoco;
import ristorante.Dolce;
import ristorante.Ordinazione;
import ristorante.Prodotto;
import ristorante.Primo;
import ristorante.Ristorante;

public class Esempio {

	public static void main(String[] args) throws Exception{
		
		System.out.println("/****** R1. CUOCHI ******/");
		
		Ristorante r = new Ristorante();
		
		System.out.println("\nNuovo cuoco, Davide Scabin");
		r.creaCuoco("Davide", "Scabin", "davide.scabin@gmail.com", "36678984568");

		Cuoco c = r.cercaCuoco("davide.scabin@gmail.com");
		System.out.println("\nInformazioni cuoco trovato");
		System.out.println("Nome: " + c.getNome());
		System.out.println("Cognome: " + c.getCognome());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Telefono: " + c.getNumeroTelefono());
		
		r.creaCuoco("Carlo", "Cracco", "carlo.cracco@gmail.com", "36678984568");
		r.creaCuoco("Bruno", "Barbieri", "bruno.barbieri@gmail.com", "36678984568");
		
		System.out.println("\nElenco cuochi in ordine alfbetico (nome e cognome)");
		for (Cuoco ci: r.elencoCuochi()) {
			System.out.println(ci.getNome() + " " + ci.getCognome());
		}

		
		System.out.println("\n/****** R2. MENU E PRODOTTI ORDINABILI ******/");
		
		System.out.println("\nNuovi prodotti");
		Prodotto p1 = r.creaProdotto("Pasta al ragu", "PR", 8);
		if (p1 instanceof Primo){
			((Primo) p1).setDescrizione("pasta della tradizione");
		}
		else if (p1 instanceof Dolce){
			((Dolce) p1).setDescrizione("dolce rinfrescante");
		}
		else if (p1 instanceof Bevanda){
			((Bevanda) p1).setGradi(5);
		}
		
		Prodotto p2 = r.creaProdotto("Cannolo alla ricotta", "D", 4);
		if (p2 instanceof Primo){
			((Primo) p2).setDescrizione("pasta della tradizione");
		}
		else if (p2 instanceof Dolce){
			Dolce obj = (Dolce) p2;
			((Dolce) obj).setDescrizione("dolce rinfrescante");
		}
		else if (p2 instanceof Bevanda){
			((Bevanda) p2).setGradi(5);
		}
		
		Prodotto p3 = r.creaProdotto("Birra rossa", "B", 5);
		if (p3 instanceof Primo){
			((Primo) p3).setDescrizione("pasta della tradizione");
		}
		else if (p3 instanceof Dolce){
			Dolce obj = (Dolce) p3;
			((Dolce) obj).setDescrizione("dolce rinfrescante");
		}
		else if (p2 instanceof Bevanda){
			((Bevanda) p3).setGradi(5);
		}
		
		p1 = r.cercaProdotto("Pasta al ragu");
		System.out.println("\nInformazioni prodotto trovato");
		System.out.println("Nome: " + p1.getNome());
		System.out.println("Prezzo: " + p1.getPrezzo());
		if (p1 instanceof Primo){
			System.out.println("Descrizione: " + ((Primo) p1).getDescrizione());
		}
		else if (p1 instanceof Dolce){
			System.out.println("Descrizione: " + ((Dolce) p1).getDescrizione());
		}
		else if (p1 instanceof Bevanda){
			System.out.println("Gradi: " + ((Bevanda) p1).getGradi());
		}
		
		p2 = r.cercaProdotto("Cannolo alla ricotta");
		System.out.println("\nInformazioni prodotto trovato");
		System.out.println("Nome: " + p2.getNome());
		System.out.println("Prezzo: " + p2.getPrezzo());
		if (p2 instanceof Primo){
			System.out.println("Descrizione: " + ((Primo) p2).getDescrizione());
		}
		else if (p2 instanceof Dolce){
			System.out.println("Descrizione: " + ((Dolce) p2).getDescrizione());
		}
		else if (p2 instanceof Bevanda){
			System.out.println("Gradi: " + ((Bevanda) p2).getGradi());
		}
		
		p3 = r.cercaProdotto("Birra rossa");
		System.out.println("\nInformazioni prodotto trovato");
		System.out.println("Nome: " + p3.getNome());
		System.out.println("Prezzo: " + p3.getPrezzo());
		if (p3 instanceof Primo){
			System.out.println("Descrizione: " + ((Primo) p3).getDescrizione());
		}
		else if (p3 instanceof Dolce){
			System.out.println("Descrizione: " + ((Dolce) p3).getDescrizione());
		}
		else if (p3 instanceof Bevanda){
			System.out.println("Gradi: " + ((Bevanda) p3).getGradi());
		}
		
		System.out.println("\nElenco prodotti nel menu");
		String s = r.elencoProdotti();
		System.out.println(s);
		
		
		System.out.println("\n/****** R3. ORDINAZIONI ******/");
		
		System.out.println("\nNuova ordinazione");
		List<String> l1 = new LinkedList<String>();
		l1.add("Birra rossa");
		l1.add("Pasta al ragu");
		r.nuovaOrdinazione(2, l1);
		r.nuovaOrdinazione(3, l1);
		r.nuovaOrdinazione(4, l1);
		r.nuovaOrdinazione(5, l1);
		r.nuovaOrdinazione(6, l1);
		r.nuovaOrdinazione(7, l1);
		r.nuovaOrdinazione(8, l1);




		
		System.out.println("\nInformazioni ordinazione trovata");
		Ordinazione o = r.cercaOrdinazione(2);
		System.out.println("Trovato ordine per il tavolo numero " + o.getNumeroTavolo());
		
		System.out.println("\nInformazioni sui prodotti relativi a una ordinazione");
		Collection<Prodotto> p = r.getProdottiOrdinazione(2);
		System.out.println("I prodotti relativi all'ordinazione sono: ");
		for (Prodotto pi : p) {
			System.out.println(pi.getNome());
		}
		
		System.out.println("\nInformazioni ordinazioni per il cuoco Scabin");
		Collection<Ordinazione> co = r.getOrdinazioniCuoco("bruno.barbieri@gmail.com");
		Collection<Ordinazione> co2 = r.getOrdinazioniCuoco("carlo.cracco@gmail.com");
		System.out.println("\nInformazioni ordinazioni trovate");
		System.out.println("Il cuoco Barbieri è resposnabile per gli ordinazioni:");
		for (Ordinazione oi : co){
			System.out.println("Tavolo numero " + oi.getNumeroTavolo());
		}
		System.out.println("Il cuoco Cracco è resposnabile per gli ordinazioni:");
		for (Ordinazione oi : co2){
			System.out.println("Tavolo numero " + oi.getNumeroTavolo());
		}
		
		
		System.out.println("\n/****** R4. CARICAMENTO DA FILE ******/");
		
		System.out.println("\nCaricamento delle informazioni sul ristorante");
		r.leggiDatiRistorante("input.txt");
		System.out.println("\nElenco cuochi in ordine alfbetico (nome e cognome)");
		for (Cuoco ci: r.elencoCuochi()) {
			System.out.println(ci.getNome() + " " + ci.getCognome());
		}
		System.out.println("\nElenco prodotti in ordine alfbetico");
		System.out.println(r.elencoProdotti());
	}
		
}
