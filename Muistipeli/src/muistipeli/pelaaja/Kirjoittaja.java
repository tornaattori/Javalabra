/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import muistipeli.Kortit.Korttipakka;

public class Kirjoittaja {
    
    private Pelaaja pelaaja;
    private PrintWriter kirjoittaja;
       
    public Kirjoittaja(Pelaaja pelaaja, File tiedosto) throws FileNotFoundException {
        this.pelaaja = pelaaja;

        kirjoittaja = new PrintWriter(tiedosto);       
    }
    
    public void kirjoita() {
        String kirjoitettava = pelaaja.getNimi() + ", " + pelaaja.getPisteet();
        kirjoittaja.println(kirjoitettava); 
    }
    
    public void kirjoitaj() {
        kirjoittaja.println("toimiiks tää?");
    }
    
}