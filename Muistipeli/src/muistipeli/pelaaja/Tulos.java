
package muistipeli.pelaaja;

/**
 * Tulos-luokka tallentaa Pelaajan tuloksen. 
 * @author Markku Korhonen
 */

public class Tulos {
    
    private int sekuntit;
    private String nimi;
    
    /**
     * Konstruktori saa parametrikseen Pelaajan nimen ja korttien löytämiseen
     * käytetyt sekuntit. Luokkamuuttujat alustetaan.
     * @param nimi
     * @param sekuntit 
     */
    public Tulos(String nimi, int sekuntit) {
        this.nimi = nimi;
        this.sekuntit = sekuntit;
    }
    
    public int getSekuntit() {
        return sekuntit;
    }
    
    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        return nimi + "," + sekuntit;
    }
}