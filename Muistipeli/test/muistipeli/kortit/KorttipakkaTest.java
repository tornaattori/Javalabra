package muistipeli.kortit;

import muistipeli.Kortit.Korttipakka;
import static org.junit.Assert.*;
import org.junit.Test;

public class KorttipakkaTest {
    
    private Korttipakka testipakka;
    
    public KorttipakkaTest() {
        testipakka = new Korttipakka(20);
        
    }
    
    /*
     * Testataan ensiksi konstruktoria
     */    
    @Test
    public void konstruktorinTestaus() {
        Korttipakka pakka = new Korttipakka(10);
        assertTrue(pakka.koko() == 10);
    }
    
    /*
     * Testataan, että kortit oikeasti sekoittuvat 
     */
 /*   @Test
    public void konstruktorinTestausKortitSekoittuvat() {
        int samoja = 0;
        Korttipakka pakka = new Korttipakka();
        
        for(int i = 0; i < testipakka.koko(); i++) {
            if(testipakka.getKortti(i).getId() == pakka.getKortti(i).getId()) {
                samoja++;
            }
        }
        assertTrue(samoja < 20);
    }
    */
    @Test 
    public void kokoMetodiToimii() {
        assertTrue(testipakka.koko() == 20);
    }
}
