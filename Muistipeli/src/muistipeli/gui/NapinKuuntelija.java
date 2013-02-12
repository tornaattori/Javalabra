
package muistipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.Kortit.Kortti;

/**
 * NapinKuuntelija-luokka kuuntelee käyttäjän antamia syötteitä.
 * @author kinkki
 */
public class NapinKuuntelija implements ActionListener{

    /**
     * Luokkamuuttuja kortille annetaan arvoksi napsautettu kortti.
     */
    private Kortti kortti;
    /**
     * lukitse-objektia käytetään napsautetun napin(kortin)
     * synkronoimiseen.
     */
    private final Object lukitse;
    /**
     * Kertoo odotetaanko toimintoa vai ei.
     */
    private boolean odottaa;
    
    /**
     * Konstruktori alustaa lukitse-objektin.
     */
    public NapinKuuntelija() {
        lukitse = new Object();
    }
       
    /**
     * Metodi kuuntelee mitä nappia painetaan. Se asettaa
     * kortti-luokkamuuttujalle napsautetun napin arvon. Odottaa-booleanille
     * annetaan arvo "false", kun nappia on painettu.
     * <p>
     * 
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        kortti = (Kortti)ae.getSource();
        odottaa = false;
        
        synchronized(lukitse) {
            lukitse.notifyAll();
        }
    }
    
    /**
     * Pysäyttää ohjelman, ja odottaa kunnes nappia painetaan.
     * <p>
     * Palauttaa viitteen painettuun nappiin.
     * @return painettu nappi(Kortti)
     */
    
    public Kortti odotaNappia() {
        odottaa = true;
        
        try {
            synchronized(lukitse) {
                while(odottaa == true) {
                    lukitse.wait();
                }
            }
        }
        
        catch (InterruptedException e) {            
        }
        
        return kortti;
    }

}