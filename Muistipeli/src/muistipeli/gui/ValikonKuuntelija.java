

package muistipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class ValikonKuuntelija implements ActionListener {
    
    Kayttoliittyma kali;
    
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