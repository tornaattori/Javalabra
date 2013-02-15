
package muistipeli.toimintalogiikka;

import javax.swing.JOptionPane;

public class Kyselija {
    
    String kysyNimi() {        
        String nimi; 
        while (true) {
            nimi = JOptionPane.showInputDialog("Iske nimee kehii, ei sit mitää kynysii merkkei"); 
            
            if(nimi.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No stikkaa ny jotain nimee kehiin");
            }           
            else {
                break;
            }
        }
        return nimi;
    }
    
    int kysyKorttienMaara() {
        Integer korttienMaara;
        while (true) {
           korttienMaara = Integer.parseInt(JOptionPane.showInputDialog("Kuin"
                   + " monel fläbäl säädetää? Vähintään 8, Enintään 30"));
           
           if(korttienMaara % 2 != 0 && (korttienMaara < 8 || korttienMaara > 30)) {
               JOptionPane.showMessageDialog(null, "Hei mitä sä nyt pelleilet"
                       + "ihan puihin meni toi sun paskalukus!");
           }
           
           else if(korttienMaara % 2 != 0) {
               JOptionPane.showMessageDialog(null, "Heeeeeiii se näin mee daiju!"
                       + " Stikkaa pykälään ny parillinen luku!");
           } 
           
           else if(korttienMaara < 8 || korttienMaara > 30) {
               JOptionPane.showMessageDialog(null, "Mitä vittuu mitä lukui! 8-30");
           }
           
           else if(korttienMaara.intValue() == 0) {
               JOptionPane.showMessageDialog(null, "No älä ny säädä mitään, stikkaa ny jotain lukui!");
           }
           
           else {
                break;            
           }    
       } 
        
     return korttienMaara;
    }
}