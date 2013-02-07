
package muistipeli.Kortit;

import javax.swing.JButton;

public class Kortti extends JButton{

    private int id;
    private Tila tila;
    
    public Kortti(int id) {
        super("KIINNI");
        this.id = id;
        tila = Tila.KIINNI;
    }
    
    public void kaanna() {
        if(tila == Tila.AUKI) {
            tila = Tila.KIINNI;
            this.setText("KIINNI");
        }
        else if(tila == Tila.KIINNI){
            tila = Tila.AUKI;
            this.setText(Integer.toString(id));
        }
    }
    
    public void piilotaLoydetty() {
        this.setText("PIILOSSA!!");
        tila = Tila.PIILOSSA;
    }
    
    public Tila getTila() {
        return tila;
    }
    
    public int getId() {
        return id;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kortti other = (Kortti) obj;
        return true;
    }
    
}