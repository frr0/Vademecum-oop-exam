package aziendaagricola;
import java.util.*;

public class Coltivazione {
	
	private String prodotto;
	private int meseSemina;
	private int meseRaccolta;
	private ArrayList<Fertilizzante> fertilizzanti;
	
	public Coltivazione(String prodotto, int meseSemina, int meseRaccolta) {
		this.prodotto = prodotto;
		this.meseRaccolta = meseRaccolta;
		this.meseSemina = meseSemina;
		this.fertilizzanti = new ArrayList<Fertilizzante>();
	}

	public String getProdotto() {
		return this.prodotto;
	}

	public int getMeseSemina() {
		return this.meseSemina;
	}

	public int getMeseRaccolta() {
		return this.meseRaccolta;
	}
	
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setMeseSemina(int meseSemina) {
		this.meseSemina = meseSemina;
	}

	public void setMeseRaccolta(int meseRaccolta) {
		this.meseRaccolta = meseRaccolta;
	}

   public Fertilizzante richiedeFertilizzante(char tipo, String nome, float costo, int periodicita, int quantitaImpiego){
	   switch (tipo) {
	   case 'N':
		   this.fertilizzanti.add(new FertilizzanteNaturale(nome, costo, periodicita, quantitaImpiego));
		   break;
	   case 'A':
		   this.fertilizzanti.add(new FertilizzanteArtificiale(nome, costo, periodicita, quantitaImpiego));
		   break;
	   default:
			   break;
	   }
	   return this.fertilizzanti.get(this.fertilizzanti.size() - 1);
   }
   
   public boolean equals(Coltivazione c2) {
	   if (this.prodotto.contentEquals(c2.getProdotto()) &&
			   this.meseSemina == c2.getMeseSemina()){
		   return true;
	   } else {
		   return false;
	   }
   }
	
}
