
package muistipeli.toimintalogiikka;

import muistipeli.Kortit.Kortti;

public class Peli {

    private Vuorolaskuri laskuri;
    
    public Peli() {
        laskuri = new Vuorolaskuri();        
    }
    
    public void valitseKortti(Kortti kortti) {
        kortti.kaanna();
        laskuri.kaytaVuoro();
        if(laskuri.getVuorot() == 0) {
            laskuri.uusiVuoro();
            
        }
        System.out.println(laskuri.getVuorot());
    }
    
    
}