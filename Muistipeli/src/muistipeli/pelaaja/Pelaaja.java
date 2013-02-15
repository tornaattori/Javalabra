

package muistipeli.pelaaja;

/**
 * Pelaaja-luokka tallentaa pelaajan tiedot. Sinne myös annetaan pelaajan
 * pisteet, jotka tallennetaan TOP-listaan.
 * 
 * @author kinkki
 */

public class Pelaaja {

    private String nimi;
    private int pisteet;
    
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
     * Pelin loputtua pelaajalle lisätään pisteet.
     * @param pisteet 
     */
    
    public void lisaaPisteet(int pisteet) {
        this.pisteet = pisteet;
    }
    
    public void nollaaPisteet() {
        this.pisteet = 0;
    }
    
    public int getPisteet() {
        return pisteet;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    @Override
    public String toString() {
        return nimi + " sai pisteitä " + pisteet + " kappaletta."; 
    }
    
}