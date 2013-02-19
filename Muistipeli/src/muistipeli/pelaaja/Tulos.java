/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package muistipeli.pelaaja;

public class Tulos {
    
    private Pelaaja pelaaja;
    
    public Tulos(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }
    
    @Override
    public String toString() {
        return pelaaja.getNimi() + ": " + pelaaja.getPisteet();
    }
    
}