package muistipeli.kortit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import muistipeli.Kortit.Korttipakka;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author kinkki
 */
public class KorttipakkaTest {
    
    private Korttipakka testipakka;
    
    public KorttipakkaTest() {
        testipakka = new Korttipakka();
        
    }
    
    
    /*
     * Testataan ensiksi konstruktoria
     */
    
    @Test
    public void konstruktorinTestaus() {
        Korttipakka pakka = new Korttipakka();
        assertTrue(pakka.koko() == 20);
    }
    
    /*
     * Testataan indeksin perusteella hakemista
     */
    
    public void indeksillaHakeminen() {
        assertTrue(testipakka.getKortti(0).getId() == 0);
    }
    
    public void indeksillaHakeminen2() {
        assertTrue(testipakka.getKortti(12).getId() == 3);
    }
}
