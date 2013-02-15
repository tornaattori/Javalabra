
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
    
    long getKokonaisaika() {
        return ((loppuaika - alkuaika) / 1000);
    }

}