

package muistipeli.pelaaja;

/**
 * Pelaaja-luokka tallentaa pelaajan tiedot. Sinne myös annetaan pelaajan
 * pisteet, jotka tallennetaan TOP-listaan.
 * 
 * @author kinkki
 */

public class Pelaaja {

    private String nimi;
    
    /**
     * Konstruktori luo pelaajan. Nimi kysytään pelin asuksi ja
     * laitetaan parametriksi. Pisteet alustetaan nollaan.
     * @param nimi 
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
      
    }
    
    /**
     * Pelaajalle lisätään pisteitä löytyneistä korteista.
     * @param pisteet 
     */

    public String getNimi() {
        return nimi;
    }
    
}