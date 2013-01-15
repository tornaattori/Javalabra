
package muistipeli.Kortit;

public class Kortti {

    private int id;
    private Tila tila;
    
    public Kortti(int id) {
        this.id = id;
        tila = Tila.KIINNI;
    }
    
    public void kaanna() {
        if(tila == Tila.AUKI) {
            tila = Tila.KIINNI;
        }
        else if(tila == Tila.KIINNI){
            tila = Tila.AUKI;
        }
    }
    
    public void piilotaLoydetty() {
        tila = Tila.PIILOSSA;
    }
    
    public Tila getTila() {
        return tila;
    }
    
    public int getId() {
        return id;
    }
    
    
}