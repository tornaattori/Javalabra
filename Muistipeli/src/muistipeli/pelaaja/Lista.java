/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lista {

    public static void main(String[] args) throws FileNotFoundException, IOException {
     
        File tiedosto = new File("/Users/kinkki/Opiskelu/Javalabra/Muistipeli/tulokset/top" + 10 + ".csv"); 
        Lukija lukija = new Lukija();
        
        Kirjoittaja kirjoittaja = new Kirjoittaja(tiedosto, lukija.lueTiedosto(tiedosto));

        kirjoittaja.kirjoita(new Tulos("JOOOO", 19999075));
        
    }
}