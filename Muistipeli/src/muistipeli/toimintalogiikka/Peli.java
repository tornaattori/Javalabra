
package muistipeli.toimintalogiikka;


import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.Kortit.Tila;
import muistipeli.gui.Kayttoliittyma;
import muistipeli.gui.KlikkaustenKuuntelija;

public class Peli {

    private Vuorolaskuri laskuri;
    private Korttipakka pakka;
    private Kayttoliittyma kl;
    private KlikkaustenKuuntelija kk;
    private Kortti painettu = null;
    
    public Peli() {
        laskuri = new Vuorolaskuri();  
        pakka = new Korttipakka();
        kl = new Kayttoliittyma();     
    }
    
    public void kaynnista() {
        kl.run();
    }
    
    public void kierros() {
        painettu = k
        
        while (true) {
            laskuri.kaytaVuoro();
            if(laskuri.getVuorot() == 0) {
                if(tarkastaPari()) {
                    System.out.println("hojojo");
                }
            }
        }
    }
    
    public boolean tarkastaPari() {
        Kortti apukortti = null;
        int i = 0;
        
        while( apukortti == null ) {
            if(pakka.getKortti(i).getTila() == Tila.AUKI) {
                apukortti = pakka.getKortti(i);
            }
            else {
                i++;
            }
        }
        while( i < pakka.koko() ) {
            if(pakka.getKortti(i).getTila() == Tila.AUKI) {
                if(pakka.getKortti(i).getId() == apukortti.getId()) {
                    return true;
                }
            }
            else {
                i++;
            }
        }
        return false;
  
    }
    
}