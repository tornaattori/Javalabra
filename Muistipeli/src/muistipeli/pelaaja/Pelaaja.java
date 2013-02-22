

package muistipeli.pelaaja;

/**
 * Pelaaja-luokka tallentaa pelaajan tiedot. Sille annetaan myös pelaajan
 * aika, jotka tallennetaan TOP-listaan.
 * 
 * @author kinkki
 */

public class Pelaaja {

    private String nimi;
    private int sekuntit;
    private Tulos tulos;
    
    /**
     * Konstruktori luo pelaajan. Nimi kysytään pelin asuksi ja
     * laitetaan parametriksi. Sekuntit alustetaan nollaan.
     * @param nimi 
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        sekuntit = 0;
      
    }
    
    /**
     * Metodi lisää pelaajalle korttien löytämiseen käytetyt ja luo uuden
     * Tulos-olion.
     * @param pisteet 
     */
    
    public void lisaaSekuntit(int sekuntit) {
        this.sekuntit = sekuntit;
        tulos = new Tulos(nimi, sekuntit);
    }

    public String getNimi() {
        return nimi;
    }
    
    public Tulos getTulos() {
        return tulos;
    }
}