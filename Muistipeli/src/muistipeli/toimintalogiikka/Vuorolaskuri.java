
package muistipeli.toimintalogiikka;

public class Vuorolaskuri {

    private int vuorot;
    
    public Vuorolaskuri() {
        vuorot = 2;
    }
    
    public void kaytaVuoro() {
        vuorot = vuorot - 1;
    }
    
    public void uusiVuoro() {
        vuorot = 2;
    }
    
    public int getVuorot() {
        return vuorot;
    }    

}