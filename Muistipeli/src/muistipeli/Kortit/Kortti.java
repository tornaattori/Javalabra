

package muistipeli.Kortit;

import java.awt.Color;
import java.awt.Font;
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
        this.setSize(200, 300);
        this.id = id;
        Font fontti = new Font("Courier New", Font.BOLD, 30);
        this.setFont(fontti);
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
    
    public Tila getTila() {
        return tila;
    }

    public int getId() {
        return id;
    }
}