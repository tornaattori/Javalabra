package muistipeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import muistipeli.Kortit.Korttipakka;
import muistipeli.toimintalogiikka.Peli;

/**
 * Kayttoliittyma-luokka luo graafisen käyttöliittymän, joka toteuttaa
 * Runnable-rajapinnan.
 * @author kinkki
 */

public class Kayttoliittyma implements Runnable {
    private Korttipakka pakka;
    private JFrame frame;
    private Peli peli;
    
    /**
     * Konstuktorille annetaan parametriksi Korttipakka-olio. Konstruktori
     * alustaa pakka-luokkamuuttujan sen mukaan.
     * @param pakka 
     */
    public Kayttoliittyma(Korttipakka pakka, Peli peli) {
        this.pakka = pakka;  
        this.peli = peli;       
    }
    
    @Override
    public void run() {
        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(haeLeveys(), 500));
       
        luoKomponentit(frame.getContentPane());
        luoValikko();
              
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);      
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Metodi luo käyttöliittymään tulevat komponentit. Ensiksi luodaan
     * layout, joka annetaan Container-parametrinä saatavalle container-
     * oliolle. Tämän jälkeen käyttöliittymään lisätään pakan kortit.
     * @param Container 
     * @see Kortti
     * @see Korttipakka
     */
    
    private void luoKomponentit(Container container) {     
        GridLayout leiska = new GridLayout(2, 2);
        container.setLayout(leiska);
        
        for(int i = 0; i < pakka.koko(); i++) {
            container.add(pakka.getKortti(i));                    
        }        
    }
    
    private void luoValikko() {
        JMenuBar valikko = new JMenuBar();
        
        JMenu valikkoPeli = new JMenu("Peli");
        valikko.add(valikkoPeli);
               
        JMenuItem valikkoUusi = new JMenuItem("Uusi peli");
        valikkoUusi.addActionListener(new ValikonKuuntelija(this, peli));
        valikkoPeli.add(valikkoUusi);
        
        JMenuItem valikkoLopeta = new JMenuItem("Lopeta");
        valikkoLopeta.addActionListener(new ValikonKuuntelija(this, peli));
        valikkoPeli.add(valikkoLopeta);
        
        frame.setJMenuBar(valikko);   
    }
    
    public void sulje() {
        frame.dispose();
    }
    
    private int haeLeveys() {
        return (pakka.koko() / 2) * 200;
        
    }
  
}