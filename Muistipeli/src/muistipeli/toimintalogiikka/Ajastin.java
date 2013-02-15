
package muistipeli.toimintalogiikka;

public class Ajastin {
    
    private long alkuaika, loppuaika;
    
    void kaynnista() {
        alkuaika = System.currentTimeMillis();
    }
    
    void pysayta() {
        loppuaika = System.currentTimeMillis();
    }
    
    long getKokonaisaika() {
        return ((loppuaika - alkuaika));
    }

}