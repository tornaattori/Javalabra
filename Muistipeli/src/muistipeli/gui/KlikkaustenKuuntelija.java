
package muistipeli.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import muistipeli.Kortit.Kortti;
import muistipeli.toimintalogiikka.Peli;

public class KlikkaustenKuuntelija implements MouseListener{

    private Kortti kortti;
    private Peli peli;
    
    public KlikkaustenKuuntelija(Kortti kortti) {
        this.kortti = kortti;
        peli = new Peli();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        peli.valitseKortti(kortti);
        System.out.println("käänsit kortin: " + kortti.getId());
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