
package muistipeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import org.jdesktop.layout.GroupLayout;

public class Dialogi implements Runnable {

    private JFrame frame;
    
    public Dialogi() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
        
        
    }
    
    public void luoKomponentit(Container container) {
     
        BoxLayout leiska = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(leiska);

        luoTervehdys(frame);
        luoNimenSyotto(frame);
    }
    
    public void luoTervehdys(Container container) {
        JPanel teksti = new JPanel();
        JLabel tervehdys = new JLabel("Tervetuloa pelaamaan muistipeliä!");
        JLabel kehoitus = new JLabel("Syötä nimesi ja valitse muistipelin koko");
        teksti.add(tervehdys);
        teksti.add(kehoitus);
        
        container.add(teksti);
    }
    
    public void luoNimenSyotto(Container container) {
        JPanel nimenSyotto = new JPanel();
        nimenSyotto.setSize(200, 200);
        JLabel nimi = new JLabel("Syötä nimesi: ");
        JTextField nimialue = new JTextField();
        
        nimialue.setSize(50, 200);
        
        nimenSyotto.add(nimi);
        nimenSyotto.add(nimialue);
        
        container.add(nimenSyotto);
    }

}