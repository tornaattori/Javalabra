package muistipeli.kortit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import muistipeli.Kortit.Korttipakka;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        assertTrue(pakka.koko() == 4);
    }
    
    /*
     * Testataan indeksin perusteella hakemista
     */
    
    public void indeksillaHakeminen() {
        assertTrue(testipakka.getKortti(0).getId() == 0);
    }
    
    public void indeksillaHakeminen2() {
        assertTrue(testipakka.getKortti(3).getId() == 3);
    }    
}
