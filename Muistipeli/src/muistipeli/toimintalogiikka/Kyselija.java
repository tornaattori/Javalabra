
package muistipeli.toimintalogiikka;

import javax.swing.JOptionPane;

public class Kyselija {
    
    String kysyNimi() {        
        String nimi; 
        while (true) {
            nimi = JOptionPane.showInputDialog("Syötä nimesi: "); 
            
            if(nimi.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ei");
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
           korttienMaara = Integer.parseInt(JOptionPane.showInputDialog("Monella"
                   + "kortilla pelataan? min 8, max 30"));
           
           if(korttienMaara % 2 != 0 && (korttienMaara < 8 || korttienMaara > 30)) {
               JOptionPane.showMessageDialog(null, "Luku on liian pieni, eikä"
                       + "se ole sitä paitsi parillinen");
           }
           
           else if(korttienMaara % 2 != 0) {
               JOptionPane.showMessageDialog(null, "Syötä parillinen luku");
           } 
           
           else if(korttienMaara < 8 || korttienMaara > 30) {
               JOptionPane.showMessageDialog(null, "Kortteja pitää olla 8-30");
           }
           
           else if(korttienMaara.intValue() == 0) {
               JOptionPane.showMessageDialog(null, "Ei käy");
           }
           
           else {
                break;            
           }    
       } 
        
     return korttienMaara;
    }
}