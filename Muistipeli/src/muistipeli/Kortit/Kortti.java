

package muistipeli.Kortit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/** 
 * Kortti-luokka luo kortin, jota käytetään Muistipelissä. Kortilla on
 * kolme mahdollista tilaa: AUKI, KIINNI ja PIILOSSA. Jos kortti on AUKI,
 * sen päällä lukee sen ID. Jos se on KIINNI tai PIILOSSA, niin siinä lukee
 * teksti "KIINNI" tai vastaavasti "PIILOSSA".
 * 
 * @author Markku Korhonen
 * 
 */

public class Kortti extends JButton{

    /**
     * Luokkamuuttuja id yksilöi korttiparin: pakassa olevista korteista
     * kahdella on sama id.
     * @see Korttipakka
     * 
     */
    private int id;
    /**
     * @see Tila
     */
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
     * Asettaa kortin tilan Löydetyksi. Kortti piilotetaan pelaajalta,
     * eikä kyseistä korttia voi enää kääntää. Korttia ei voida piilottaa
     * mikäli se on kiinni.
     */    
    public void piilotaLoydetty() {
        if(this.tila == Tila.AUKI) {
            tila = Tila.PIILOSSA;
            this.setVisible(false);
        }
    }
    
    public void setTila(Tila tila) {
        this.tila = tila;
    }
    
    public Tila getTila() {
        return tila;
    }

    public int getId() {
        return id;
    }
}