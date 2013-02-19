
import java.io.File;
import java.io.FileNotFoundException;
import muistipeli.Kortit.Korttipakka;
import muistipeli.pelaaja.Kirjoittaja;
import muistipeli.pelaaja.Lukija;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.pelaaja.Pisteyttaja;
import muistipeli.toimintalogiikka.Peli;

public class Muistipeli {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
       
       Peli peli = new Peli();
       peli.pelaa();
        
    }

}