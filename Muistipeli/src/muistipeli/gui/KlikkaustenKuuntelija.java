
package muistipeli.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import muistipeli.Kortit.Kortti;

public class KlikkaustenKuuntelija implements MouseListener{
    
    private Kortti kortti;
    public KlikkaustenKuuntelija(Kortti kortti) {
        this.kortti = kortti;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        kortti.kaanna();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}