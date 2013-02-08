
package muistipeli.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import muistipeli.Kortit.Kortti;

public class NapinKuuntelija implements ActionListener{

    private Kortti kortti;
    private Object lukitse;
    private boolean odottaa;
    
    
    public NapinKuuntelija() {
        lukitse = new Object();
    }
       
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        kortti = (Kortti)ae.getSource();
        odottaa = false;
        
        synchronized(lukitse) {
            lukitse.notifyAll();
        }
    }
    
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