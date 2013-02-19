/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;

public class Pisteyttaja {

    private Lukija lukija;
    private Kirjoittaja kirjoittaja;
    private Pelaaja pelaaja;
    private int koko;
    
    public Pisteyttaja(Pelaaja pelaaja, int koko) throws FileNotFoundException {
        this.pelaaja = pelaaja;
        this.koko = koko;
        File tiedosto = new File("/Users/kinkki/Opiskelu/Javalabra/Muistipeli/tulokset/top" + koko + ".csv");
        
        lukija = new Lukija(tiedosto);
        kirjoittaja = new Kirjoittaja(pelaaja, tiedosto);     
    }
    
    public void pisteyta() {
        if(lisataankoPelaajanPisteet()) {
            kirjoittaja.kirjoita();
        }
    }
    
    private boolean lisataankoPelaajanPisteet() {
        if(pelaaja.getPisteet() > lukija.palautaViimeinenArvo()) {
            return true;
        }
        return false;
    }
    
    public void listaaPisteet() {
        lukija.listaaPisteet();
    }

}