
package muistipeli.Kortit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Luo Kortteja sisältävän Korttipakan. Käskee niin ikään Kortti-luokkaa
 * luomaan kortit.
 * 
 * @author Markku Korhonen
 */

public class Korttipakka {
    
    /**
     * Kortit säilötään luokkamuuttujana olevaan listaan. 
     */
    private List<Kortti> pakka;
    
    private int koko;
    
    /**
     * Korttipakan konstruktori alustaa pakka-nimisen ArrayList-listan. Tämän
     * jälkeen se lisää kortit listaan käyttämällä laitaKortitPakkaan()-metodia
     * ja sekoittaa korttien järjestyksen.
     */
    public Korttipakka(int koko) {
        this.koko = koko;     
        pakka = new ArrayList();
        
        laitaKortitPakkaan();
        Collections.shuffle(pakka);        
    }
    
    /**
     * Lisää kortit pakkaan, eli listaan. Korteille annetaan parillinen
     * id-tunniste, jotta pelissä kaikilla korteilla on pari.
     * @see Kortti
     */   
    private void laitaKortitPakkaan() {
        int i = 0;
        
        while(i < koko) {
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
     * Asettaa kaikkien korttien tilaksi KIINNI ja sekoittaa pakan.
     * 
     * @return sekoitettu Korttipakka
     * 
     */   
    public Korttipakka nollaaPakka() {
        Korttipakka uusiPakka = new Korttipakka(koko);
        return uusiPakka;
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
        return koko;
    }
    
    
}