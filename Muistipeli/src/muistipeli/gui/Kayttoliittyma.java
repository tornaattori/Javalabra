package muistipeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import muistipeli.Kortit.Korttipakka;

public class Kayttoliittyma implements Runnable {

    private Korttipakka pakka;
    private JFrame frame;
    
    public Kayttoliittyma(Korttipakka pakka) {
        this.pakka = pakka;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(800, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);      
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        
        GridLayout leiska = new GridLayout(2, 2);
        container.setLayout(leiska);
        
        for(int i = 0; i < pakka.koko(); i++) {
            container.add(pakka.getKortti(i));                    
        }
    }
}