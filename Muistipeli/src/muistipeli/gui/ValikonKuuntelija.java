

package muistipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public ValikonKuuntelija(Kayttoliittyma kali) {
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent tapahtuma) {
        String valinta = ((JMenuItem)tapahtuma.getSource()).getText();
        
        if(valinta.equals("Uusi peli")) {
            
        }
    }

}