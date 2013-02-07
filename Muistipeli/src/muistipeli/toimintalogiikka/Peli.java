
package muistipeli.toimintalogiikka;


import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.gui.Kayttoliittyma;

public class Peli {

    private Vuorolaskuri laskuri;
    private Korttipakka pakka;
    private Kayttoliittyma kl;
    
    public Peli() {
        laskuri = new Vuorolaskuri();  
        pakka = new Korttipakka();
        kl = new Kayttoliittyma();     
    }
    
    public void kaynnista() {
        kl.run();
    }
    
    public void valitseKortti(Kortti kortti) {
        
       
        laskuri.kaytaVuoro();
        if(laskuri.getVuorot() == 0) {
            laskuri.uusiVuoro();
            
        }
        System.out.println(laskuri.getVuorot());
    }
    
    
}