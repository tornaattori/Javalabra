/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.Kortit;

import java.util.ArrayList;
import java.util.List;

public class Korttipakka {

    private List<Kortti> pakka;
    
    public Korttipakka() {
        pakka = new ArrayList();
        laitaKortitPakkaan();
        
    }
    
    private void laitaKortitPakkaan() {
        int i = 0;
        while(i < 20) {
            if(i % 2 != 0) {
                pakka.add(new Kortti(i - 1));
            }
            else {
                pakka.add(new Kortti(i));
            }
            i++;
        }
        
    }
    
    
    public Kortti getKortti(int indeksi) {
        return pakka.get(indeksi);
    }
    
    public int koko() {
        return pakka.size();
    }
    
    
}