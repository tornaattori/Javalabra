

package muistipeli.pelaaja;

import java.util.Map;

/**
 * Pelaaja-luokka tallentaa pelaajan tiedot. Sinne myös annetaan pelaajan
 * pisteet, jotka tallennetaan TOP-listaan.
 * 
 * @author kinkki
 */

public class Pelaaja {

    private String nimi;
    private int pisteet;
    private Tulos tulos;
    
    /**
     * Konstruktori luo pelaajan. Nimi kysytään pelin asuksi ja
     * laitetaan parametriksi. Pisteet alustetaan nollaan.
     * @param nimi 
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        pisteet = 0;
      
    }
    
    /**
     * Pelaajalle lisätään pisteitä löytyneistä korteista.
     * @param pisteet 
     */
    
    public void lisaaPisteet(int pisteet) {
        this.pisteet = pisteet;
        tulos = new Tulos(nimi, pisteet);
    }
    
    public int getPisteet() {
        return pisteet;
    }

    public String getNimi() {
        return nimi;
    }
    
    public Tulos getTulos() {
        return tulos;
    }
}