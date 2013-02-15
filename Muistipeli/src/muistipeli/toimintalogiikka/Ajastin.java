
package muistipeli.toimintalogiikka;

public class Ajastin {
    
    private long alkuaika, loppuaika;
    
    void kaynnista() {
        alkuaika = System.currentTimeMillis();
        System.out.println(alkuaika);
    }
    
    void pysayta() {
        loppuaika = System.currentTimeMillis();
        System.out.println(loppuaika);
    }
    
    void nollaa() {
        alkuaika = 0;
        loppuaika = 0;
    }
    
    long getKokonaisaika() {
        return ((loppuaika - alkuaika) / 1000);
    }

}