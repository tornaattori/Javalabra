

package muistipeli.Kortit;

import javax.swing.JButton;

/** 
 * Kortti-luokka luo kortin, jota käytetään Muistipelissä
 * @author Markku Korhonen
 * 
 */

public class Kortti extends JButton{

    private int id;
    private Tila tila;
    
    /**
     *Kortin konstruktori ottaa parametrikseen id-numeron.
     * Samalla asettaa tilaksi "KIINNI".
     * @param id
     * @see Tila
     */
    public Kortti(int id) {
        super("KIINNI");
        this.id = id;
        tila = Tila.KIINNI;
    }
    
    /**
     * Metodi "kääntää" kortin, eli muuttaa sen Tilan joko AUKI-tilasta
     * KIINNI-tilaksi tai päinvastoin.
     * Jos kortti on piilossa, eli löydetty, se ei enää käänny.
     */
    public void kaanna() {
        if(tila == Tila.AUKI) {
            tila = Tila.KIINNI;
            this.setText("KIINNI");
        }
        else if(tila == Tila.KIINNI){
            tila = Tila.AUKI;
            this.setText(Integer.toString(id));
        }
    }
    
    /**
     * Asettaa kortin tilan Löydetyksi. Kortti piilotetaan pelaajalta.
     */    
    public void piilotaLoydetty() {
        this.setText("PIILOSSA!!");
        tila = Tila.PIILOSSA;
    }
    
    /**
     * Palauttaa kortin sen hetkisen Tilan.
     * @return tila
     */  
    public Tila getTila() {
        return tila;
    }
    
    /**
     * Palauttaa kortin yksilöivän id:n.
     * @return id
     */
    public int getId() {
        return id;
    }
}