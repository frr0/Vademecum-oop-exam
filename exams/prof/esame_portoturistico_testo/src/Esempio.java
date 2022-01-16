import java.io.IOException;
import java.util.*;

import portoturistico.*;

public class Esempio {

	public static void main(String[] args) throws IOException{

		System.out.println("/****** R1. BANCHINE E SPAZI ******/");

		Porto p = new Porto();
		
		Banchina bn;
		Spazio s1, s2;
		Barca br;
		
		System.out.println("\nDefinizione di una banchina");
		bn = p.nuovaBanchina(10);
		System.out.println(" Lettera: "+bn.getLetteraBanchina());
		System.out.println(" Max spazi: "+bn.getNumeroMassimoSpazi());
		
		System.out.println("\nDefinizione di un'altra banchina");
		bn = p.nuovaBanchina(5);
		System.out.println(" Lettera: "+bn.getLetteraBanchina());
		System.out.println(" Max spazi: "+bn.getNumeroMassimoSpazi());
		
		System.out.println("\nConfigurazione di uno spazio per la banchina A");
		s1 = p.nuovoSpazio('A', 18, 4, "permanente");
		System.out.println(" Codice: "+s1.getCodiceSpazio());
		System.out.println(" Dimensione: "+s1.getLunghezza()+" x "+ s1.getLarghezza());
		if(s1 instanceof SpazioPermanente)
			System.out.println(" Tipo: permanente");
		else if(s1 instanceof SpazioDiPassaggio)
			System.out.println(" Tipo: di passaggio");

		System.out.println("\nCerca spazio A100");
		s1 = p.cercaSpazio("A100");

		System.out.println("\nImposta costo spazio A100");
		s1.setCosto(1500.0);
		System.out.println(" Costo: "+s1.getCosto());
		
		System.out.println("\nConfigurazione di un altro spazio per la banchina A");
		s2 = p.nuovoSpazio('A', 20, 6, "di passaggio");
		System.out.println(" Codice: "+s2.getCodiceSpazio());
		System.out.println(" Dimensione: "+s2.getLunghezza()+" x "+ s2.getLarghezza());
		if(s2 instanceof SpazioPermanente)
			System.out.println(" Tipo: permanente");
		else if(s2 instanceof SpazioDiPassaggio)
			System.out.println(" Tipo: di passaggio");
		
		System.out.println("\nDefinizione di altre banchine e configurazione degli spazi");
		p.nuovoSpazio('B', 13, 4, "permanente");
		p.nuovaBanchina(20);
		p.nuovoSpazio('C', 30, 7, "permanente");
		
		System.out.println("\nElenco banchine e spazi (ordine alfabetico)");
		System.out.println(""+p.elencoSpazi());
		
		
		
		System.out.println("\n\n/****** R2. BARCHE ******/");

		System.out.println("\nDefinizione di una barca");
		br = p.nuovaBarca("GF7554644S", "Lasciala andare", 5, 1);
		System.out.println(" Numero immatricolazione: "+br.getNumeroImmatricolazione());
		System.out.println(" Nome: "+br.getNome());
		System.out.println(" Dimensione: "+br.getLunghezza()+" x "+ br.getLarghezza());

		System.out.println("\nDefinizione di una barca");
		br = p.nuovaBarca("TB6537578D", "Lasciala andare", 10, 3);
		System.out.println(" Numero immatricolazione: "+br.getNumeroImmatricolazione());
		System.out.println(" Nome: "+br.getNome());
		System.out.println(" Dimensione: "+br.getLunghezza()+" x "+ br.getLarghezza());

		System.out.println("\nDefinizione di un'altra barca");
		br = p.nuovaBarca("TY1337811M", "A galla", 15, 2);
		System.out.println(" Numero immatricolazione: "+br.getNumeroImmatricolazione());
		System.out.println(" Nome: "+br.getNome());
		System.out.println(" Dimensione: "+br.getLunghezza()+" x "+ br.getLarghezza());

		System.out.println("\nElenco barche (per nome, dimensione)");
		Collection<Barca> barche;
		barche = p.elencoBarchePerNomeDimensione();
		for(Barca bTemp : barche){
			System.out.println(" "+bTemp.getNumeroImmatricolazione()+" "+bTemp.getNome()+" "+bTemp.getLunghezza()+" x "+ bTemp.getLarghezza());
		}
		
		System.out.println("\nElenco barche (per dimensione, nome)");
		barche = p.elencoBarchePerDimensioneNome();
		for(Barca bTemp : barche){
			System.out.println(" "+bTemp.getNumeroImmatricolazione()+" "+bTemp.getNome()+" "+bTemp.getLunghezza()+" x "+ bTemp.getLarghezza());
		}


		
		System.out.println("\n\n/****** R3. PAGAMENTI ED ORMEGGI ******/");

		System.out.println("\nPagamento per lo spazio A100 in data 20150619 importo 1500.0");
		try{
			p.nuovoPagamento("A100", "20150619", 1500.0);
			System.out.println(" Pagamento registrato");
		}
		catch(EccezioneImporto e){
			System.out.println(" Importo errato (eccezione)");
		}
		
		System.out.println("\nOrmeggio della barca TY1337811M nello spazio A100 in data 20140619");
		try{
			System.out.println(" Dimensione barca:  "+br.getLunghezza()+" x "+br.getLarghezza());
			System.out.println(" Dimensione spazio: "+s1.getLunghezza()+" x "+s1.getLarghezza());
			p.ormeggia("TY1337811M", "A100", "20140619");
			System.out.println(" Ormeggio avvenuto");
		}
		catch(EccezioneOrmeggio e){
			System.out.println(" Ormeggio fallito (eccezione)");
		}
		
		
		
		System.out.println("\n\n/****** R4. CARICAMENTO DA FILE ******/");

		System.out.println("\nCaricamento di banchine e spazi da file");

		p.leggiFile("input.txt");
		System.out.println("\nElenco spazi per tutte le banchine (ordine alfabetico)");
		System.out.println(""+p.elencoSpazi());
		
	}
}
