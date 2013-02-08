

package Pelaaja;

public class Pelaaja {

    private String nimi;
    private int pisteet;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        pisteet = 0;        
    }
    
    public void lisaaPisteet(int pisteet) {
        this.pisteet = pisteet;
    }
    
    public int getPisteet() {
        return pisteet;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    @Override
    public String toString() {
        return nimi + " sai pisteitä " + pisteet + " kappaletta."; 
    }
    
}