import libreria.EditoreInesistente;
import libreria.Libreria;
import libreria.Libro;

public class Esempio {

    public static void main(String[] args) throws EditoreInesistente {
        
        Libreria lib = new Libreria();
        
        // Creazione della struttura dati
        
        /*
        lib.creaEditore("Adelphi",5,"ordini@adlephi.it");
        lib.creaEditore("Mondadori",10,"richieste@mondadori.it");
        lib.creaLibro("Siddartha","Hesse",2000,5.5,"Adelphi");
        lib.creaLibro("Promessi Sposi","Manzoni",1995,10.2,"Mondadori");
        */
        
        // Oppure, in alternativa, per leggere da file (commentando le righe sopra)
        
        lib.leggi("input.txt");
        
        
        Libro l1 = lib.getLibro("Hesse","Siddartha");
        Libro l2 = lib.getLibro("Manzoni","Promessi Sposi");

        l1.setQuantita(10);
        l2.setQuantita(15);
        
        l1.setParametri(8,10);
        
        l1.registraVendita(1,1);
        l2.registraVendita(1,1);
        l2.registraVendita(1,1);

        l1.registraVendita(3,1);
        l1.registraVendita(4,1);
        l1.registraVendita(4,1);
        
        System.out.println("Sett 1: " + lib.getClassificaSettimana(1));
        System.out.println("Mese 1: " + lib.getClassificaMese(1));
        
        System.out.println("Ordini: " + lib.getOrdini());
        
    }
}