
package muistipeli.gui;

import javax.swing.JOptionPane;

public class Kyselija {
    
    /**
     * Utelee käyttäjältä peliin tarvittavat tiedot ja tarkistaa syötteiden 
     * kelpaavuuden.
     */
    public Kyselija() {      
    } 
    
    /**
     * Kysyy käyttäjältä nimeä. Jos nimi on tyhjä, kysytään nimeä uudestaan.
     * Ei välitä, vaikka syötettäisiin erikoisia symboleita.
     * @return nimi
     */
    public String kysyNimi() {        
        String nimi; 
        
        while (true) {
            nimi = JOptionPane.showInputDialog("Syötä nimesi: "); 
            
            if(tarkistaNimi(nimi)) {
                return nimi;
            }
        }
    }
    
    /**
     * Kysyy käyttäjältä pelissä käytettävien korttien määrän. Jos määrä
     * ei kelpaa, metodi ilmoittaa asiasta pelaajalle ja kysyy korttien määrää
     * uudestaan.
     *
     * @return korttienMaara
     */
    
    public int kysyKorttienMaara() {
        Integer korttienMaara;
        
        while (true) {
           korttienMaara = Integer.parseInt(JOptionPane.showInputDialog("Monella "
                   + "kortilla pelataan? min 8, max 30"));
           
           if(tarkistaKorttienMaara(korttienMaara)) {
               return korttienMaara;
           }
        }
    }
    
    private boolean tarkistaKorttienMaara(Integer korttienMaara) {    
           if(korttienMaara % 2 != 0 && (korttienMaara < 8 || korttienMaara > 30)) {
               JOptionPane.showMessageDialog(null, "Luku on liian pieni, eikä"
                       + "se ole sitä paitsi parillinen");
               return false;
           }
           
           else if(korttienMaara % 2 != 0) {
               JOptionPane.showMessageDialog(null, "Syötä parillinen luku");
               return false;
           } 
           
           else if(korttienMaara < 8 || korttienMaara > 30) {
               JOptionPane.showMessageDialog(null, "Kortteja pitää olla 8-30");
               return false;
           }
           
           else if(korttienMaara.intValue() == 0) {
               JOptionPane.showMessageDialog(null, "Ei käy");
               return false;
           }
           return true;
    }
    
    private boolean tarkistaNimi(String nimi) {
        if(nimi.isEmpty() || nimi.contains(",")||nimi.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Ei kelpaa");
                return false;
        }           
        return true;

    }
}