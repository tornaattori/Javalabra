

package muistipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import muistipeli.toimintalogiikka.Peli;

/**
 * Valikonkuuntelija kuuntelee nimensä mukaisesti Muistipelin 
 * valikon painikkeita.
 * @author Markku Korhonen
 */

public class ValikonKuuntelija implements ActionListener {
    
    Kayttoliittyma kali;
    Peli peli;
    
    public ValikonKuuntelija(Kayttoliittyma kali, Peli peli) {
        this.kali = kali;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent tapahtuma) {
        String valinta = ((JMenuItem)tapahtuma.getSource()).getText();
        
        if(valinta.equals("Uusi peli")) {
            try {
                peli.kaynnistaUudelleen();
            } catch (InterruptedException ex) {
                Logger.getLogger(ValikonKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(valinta.equals("Lopeta")) {
            System.exit(0);
            
        }
    }

}