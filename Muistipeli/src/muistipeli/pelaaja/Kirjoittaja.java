/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Kirjoittaja {
    
    private Pelaaja pelaaja;
    private PrintWriter kirjoittaja;
       
    public Kirjoittaja(Pelaaja pelaaja, File tiedosto) 
            throws FileNotFoundException, IOException {
        
        this.pelaaja = pelaaja;
        kirjoittaja = new PrintWriter(new FileWriter(tiedosto, true));  
    }
    
    public void kirjoita(Map<String, Integer> tulokset) {
        for(String s: tulokset.keySet()) {
            kirjoittaja.println(s);
        }      
    }
}