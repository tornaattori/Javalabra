
package muistipeli.Kortit;

import java.util.ArrayList;
import java.util.List;

public class Korttipakka {

    private List<Kortti> kortit;
    
    public Korttipakka() {
        kortit = new ArrayList<Kortti>();
        
        for(int i = 0; i < 4; i++) {
            kortit.add(new Kortti(i));
        }       
    }
    
    public Kortti getKortti(int indeksi) {
        return kortit.get(indeksi);
    }
    
    public int koko() {
        return kortit.size();
    }
    
}