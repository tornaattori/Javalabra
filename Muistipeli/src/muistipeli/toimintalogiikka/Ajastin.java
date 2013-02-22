
package muistipeli.toimintalogiikka;

public class Ajastin {
    
    
    private long alkuaika, loppuaika;
    
    /**
     * Ajastin-luokka laskee korttien löytämisessä kuluneen ajan ja kertoo
     * sen sekunteina.
     */
    Ajastin() {
    }
    
    /**
     * Käynnistää laskimen ja rekisteröi alkuajan.
     * @see System.currentTimeMillis();
     */
    void kaynnista() {
        alkuaika = System.currentTimeMillis();
    }
    
    /**
     * Pysäyttää laskimen ja rekisteröi loppuajan.
     * see System.currentTimeMillis();
     */
    void pysayta() {
        loppuaika = System.currentTimeMillis();
    }
    
    /**
     * Asettaa alkuajan ja loppuajan arvoksi 0.
     */
    void nollaa() {
        alkuaika = 0;
        loppuaika = 0;
    }
    
    /**
     * Palauttaa laskimen laskeman ajan sekunteina.
     * @return 
     */
    int getKokonaisaika() {
        return ((int)(loppuaika - alkuaika) / 1000);
    }

}