
package muistipeli.tiedostonkasittelija;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import muistipeli.pelaaja.Tulos;

/**
 * Lukija-luokka lukee sille annetun .csv-tiedoston.
 * @author Markku Korhonen
 * 
 */
    class Lukija {
    
    Lukija() throws FileNotFoundException {
    }    
    
    /**
     * Metodi saa parametrikeen tidoston, jonka tulee olla .csv-muotoa. Aluksi
     * luodaan Scanner- ja List-olio. Tiedoston sisältö luetaan listaan. 
     * Lopuksi lista palautetaan.
     * 
     * @param tiedosto
     * @return tuloslista
     * @throws FileNotFoundException 
     */
    
    List<Tulos> lueTiedosto(File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        List<Tulos> tuloslista = new ArrayList();

        while( true ) {            
            if(lukija.hasNext() == false) {
                break;
            }
            String[] aputaulukko = lukija.nextLine().split(",");
            Tulos tulos = new Tulos(aputaulukko[0], Integer.parseInt(aputaulukko[1]));
            
            tuloslista.add(tulos);
        }
        return tuloslista;
    }
    
}