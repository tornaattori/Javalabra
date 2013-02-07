
package muistipeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import muistipeli.Kortit.Korttipakka;

public class Kayttoliittyma implements Runnable{

    private Korttipakka korttipakka;
    private JFrame frame;

    
    public Kayttoliittyma() {
        korttipakka = new Korttipakka();
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);       
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        
        GridLayout leiska = new GridLayout(1, 2);
        container.setLayout(leiska);
        
        for(int i = 0; i < 4; i++) {
            container.add(korttipakka.getKortti(i));
            KlikkaustenKuuntelija kk = new KlikkaustenKuuntelija(korttipakka.getKortti(i));
            korttipakka.getKortti(i).addMouseListener(kk);
        }
             
            
        
        }
    

}