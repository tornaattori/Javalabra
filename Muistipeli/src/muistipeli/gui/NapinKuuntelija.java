

package muistipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import muistipeli.Kortit.Kortti;

public class NapinKuuntelija implements ActionListener{

    private Kortti kortti;
    private Object lukko;
    private boolean odottaa;
    
    public NapinKuuntelija() {
        lukko = new Object();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        kortti = (Kortti)event.getSource();
        odottaa = false;
        
        synchronized(lukko) {
            lukko.notifyAll();
        }
    }
    
    public Kortti odotaNappia() {
        odottaa = true;
        
        try {
            synchronized(lukko) {
                while(odottaa == true) {
                    lukko.wait();
                }
            }
        }
        catch(InterruptedException e) {
            
        }
        
        return kortti;
    }

}