
package muistipeli.toimintalogiikka;

import muistipeli.gui.Kayttoliittyma;
import javax.swing.JButton;
import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.gui.NapinKuuntelija;

public class Peli2 {
    
    private Kayttoliittyma kali;
    private NapinKuuntelija kuuntelija;
    private Korttipakka pakka;
    
    public Peli2(Kayttoliittyma kali) {
        this.kali = kali;
        kuuntelija = new NapinKuuntelija();
        pakka = new Korttipakka();
        
        for(int i = 0; i < pakka.koko(); i++) {
            pakka.getKortti(i).addActionListener(kuuntelija);
        }
    }
    
    public void pelaa() {
        int loydetytParit;
        int yritykset;
        Kortti valittuKortti;
        boolean peliJatkuu = true;
        Kortti kortti1, kortti2;
        
        while(peliJatkuu == true) {
            loydetytParit = 0;
            yritykset = 0;
            valittuKortti = null;
            
            while(loydetytParit != pakka.koko() / 2) {
            
                valittuKortti = kuuntelija.odotaNappia();
      
                kortti1 = (Kortti)valittuKortti;
                kortti1.kaanna();
                
                valittuKortti = kuuntelija.odotaNappia();
                
                kortti2 = (Kortti)valittuKortti;
                kortti2.kaanna();
                
                
            }
            
        }
        
    }
    
}