
package muistipeli.pelaaja;

public class Tulos {
    
    private int tulos;
    private String nimi;
    
    public Tulos(String nimi, int tulos) {
        this.nimi = nimi;
        this.tulos = tulos;
    }
    
    public int getTulos() {
        return tulos;
    }
    
    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        return nimi + "," + tulos;
    }
}