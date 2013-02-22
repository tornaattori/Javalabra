
package muistipeli.tiedostonkasittelija;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import muistipeli.pelaaja.Tulos;

/**
 * Kirjoittaja-luokka kirjoittaa tiedostoon Muistipelin tulokset.
 * 
 * @author Markku Korhonen
 */

class Kirjoittaja {

    /**
     * Tiedostoon kirjoittamiseen kykenevä PrintWriter-olio, jonka avulla 
     * listaa kirjoitetaan. Olio saa parametrikseen FileWriter-olion, joka
     * jokaisella kirjoituskerralla tyhjentää tiedoston ennen kirjoittamista.
     * 
     */
    private PrintWriter kirjoittaja;
    /**
     * Lista, johon konstruktorin parametrinä saatu tuloslista kopioidaan.
     */
    private List<Tulos> lista;
    
    /**
     * Konstruktori alustaa luokkamuuttujat. 
     * @param tiedosto
     * @param tuloslista
     * @throws IOException 
     */
    
    Kirjoittaja(File tiedosto, List<Tulos> tuloslista) throws IOException {
        lista = new ArrayList(tuloslista);
        kirjoittaja = new PrintWriter(new FileWriter(tiedosto, false));
    }
    
    /**
     * Kirjoita-metodin avulla lisätään uusi Tulos tiedostoon. Aluksi tulos
     * lisätään konstruktorin parametrinä saatuun List-olioon, minkä
     * jälkeen se järjestetään Tulosten sekuntimäärän mukaan pienimmästä suurimpaan.
     * <p>
     * Mikäli listassa on jo 10 tulosta, viimeisin tulos poistetaan. Ts. listaan
     * lisätään joka pelin jälkeen Tulos, lista järjestetään ja huonoin tulos
     * poistetaan.
     * <p>
     * Lopuksi metodi kutsuu PrinWriter-olion println()-metodia, jota luupataan
     * niin kauan, kuin listassa on tavaraa.
     * @param tulos 
     * @see PrintWriter.println()
     */

    void kirjoita(Tulos tulos) {
        lista.add(tulos);
        
        jarjestaLista(lista);
        
        if(lista.size() > 9) {
            lista.remove(10);
        }      
        
        for(int i = 0; i < lista.size(); i++) {
            kirjoittaja.println(lista.get(i).toString());        
        }
       
        kirjoittaja.close();
    }
    
    /**
     * Metodi järjestää sille parametrinä annetun listan käyttäen
     * Valintalajittelu-lajittelualgoritmia.
     * @param tuloslista
     * @return lajiteltu tuloslista
     */
    
    private List<Tulos> jarjestaLista(List<Tulos> tuloslista) {
        
        int i, j, indeksi = 0;
        Tulos pienin;
        
        for(i = 0; i < tuloslista.size() - 1; i++) {
            pienin = tuloslista.get(i);
            
            for(j = i + 1; j < tuloslista.size(); j++) {
                if(tuloslista.get(j).getSekuntit() < pienin.getSekuntit()) {
                    pienin = tuloslista.get(j);
                    indeksi = j;
                }
            }
            if(!pienin.equals(tuloslista.get(i))){
                Collections.swap(lista, i, indeksi);
            }           
        }
        return tuloslista;
    }
}