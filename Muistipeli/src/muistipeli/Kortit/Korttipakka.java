/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.Kortit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Luo Kortteja sisältävän Korttipakan. Käskee niin ikään Kortti-luokkaa
 * luomaan kortit.
 * 
 * @author kinkki
 */

public class Korttipakka {
    
    /**
     * Kortit säilötään listaan. 
     */
    private List<Kortti> pakka;
    
    /**
     * Korttipakan konstruktori luo pakka-nimisen ArrayList-listan. Tämän
     * jälkeen se lisää kortit listaan ja lopuksi sekoittaa niiden 
     * järjestyksen.
     */
    public Korttipakka() {
        pakka = new ArrayList();
        laitaKortitPakkaan();
        Collections.shuffle(pakka);        
    }
    
    /**
     * Lisää kortit pakkaan, eli listaan. Korteille annetaan parillinen
     * id-tunniste, jotta pelissä kaikilla korteilla on pari.
     */
    
    private void laitaKortitPakkaan() {
        int i = 0;
        while(i < 20) {
            if(i % 2 != 0) {
                pakka.add(new Kortti(i - 1));
            }
            else {
                pakka.add(new Kortti(i));
            }
            i++;
        }        
    }
    
    /**
     * Palauttaa halutun kortin parametriksi annetusta indeksistä.
     * @param indeksi
     * @return parametriksi annetusta indeksistä löytyvä kortti.
     */
    
    public Kortti getKortti(int indeksi) {
        return pakka.get(indeksi);
    }
    
    /**
     * Palauttaa Korttipakassa olevien korttien määrän.
     * @return Korttipakan koko.
     */
    
    public int koko() {
        return pakka.size();
    }
    
    
}