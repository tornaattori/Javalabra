package muistipeli.kortitTest;

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
    
    public void konstruktorinTestaus2() {
        assertTrue(testipakka.koko()  == 20);
    }
    
    public void konstruktorinTestaus3() {
        Korttipakka pakka = new Korttipakka(0);
        assertTrue(pakka.koko() == 0);
    }

}
