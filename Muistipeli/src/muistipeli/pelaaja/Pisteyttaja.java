/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Pisteyttaja {

    private Lukija lukija;
    private Kirjoittaja kirjoittaja;
    private Pelaaja pelaaja;
       
    public Pisteyttaja(Pelaaja pelaaja, int koko) throws FileNotFoundException, IOException {
        this.pelaaja = pelaaja;
        File tiedosto = new File("/Users/kinkki/Opiskelu/Javalabra/Muistipeli/tulokset/top" + koko + ".csv");
        
        lukija = new Lukija(tiedosto);
        kirjoittaja = new Kirjoittaja(pelaaja, tiedosto);     
    }
    
    public void pisteyta() {
        if(lisataankoPelaajanPisteet()) {
            kirjoittaja.kirjoita(lukija.lueLista());  
        }
    }
    
    private boolean lisataankoPelaajanPisteet() {
        if(pelaaja.getPisteet() > lukija.palautaViimeinenArvo() || lukija.haeTulostenMaara() < 10) {
            return true;
        }
        return false;
    }
    
    public void listaaPisteet() {
        lukija.listaaPisteet();
    }
}