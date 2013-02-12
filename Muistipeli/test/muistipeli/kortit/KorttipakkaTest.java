package muistipeli.kortit;

import muistipeli.Kortit.Korttipakka;
import static org.junit.Assert.*;
import org.junit.Test;

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
     * Testataan, että kortit oikeasti sekoittuvat 
     */
    @Test
    public void konstruktorinTestausKortitSekoittuvat() {
        boolean samat = false;
        Korttipakka pakka = new Korttipakka();
        for(int i = 0; i < testipakka.koko(); i++) {
            if(testipakka.getKortti(i).getId() == pakka.getKortti(i).getId()) {
                samat = true;
                break;
            }
        }
        assertTrue(samat == true);
    }
    
    /*
     * Testataan indeksin perusteella hakemista
     */
    
    @Test
    public void indeksillaHakeminen() {
        assertTrue(testipakka.getKortti(0).getId() == 0);
    }
    
    @Test
    public void indeksillaHakeminen2() {
        assertTrue(testipakka.getKortti(12).getId() == 3);
    }
}
