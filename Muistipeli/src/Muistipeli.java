
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import muistipeli.Kortit.Korttipakka;
import muistipeli.pelaaja.Kirjoittaja;
import muistipeli.pelaaja.Lukija;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.pelaaja.Pisteyttaja;
import muistipeli.toimintalogiikka.Peli;

public class Muistipeli {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
       
       Pelaaja pelaaja = new Pelaaja("make");
       pelaaja.lisaaPisteet(20);
       Korttipakka pakka = new Korttipakka(10);
       File tiedosto = new File("/Users/kinkki/Opiskelu/Javalabra/Muistipeli/tulokset/top" + pakka.koko() + ".csv");
       
       Kirjoittaja kirjoittaja = new Kirjoittaja(pelaaja, tiedosto);
       Lukija lukija = new Lukija(tiedosto);
       kirjoittaja.kirjoita();
       lukija.listaaPisteet();
       
    }

}