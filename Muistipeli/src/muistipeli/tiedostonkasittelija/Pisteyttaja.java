
package muistipeli.tiedostonkasittelija;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.pelaaja.Tulos;

/**
 * Pisteyttäjä on tiedostonkäsittelyn kokoava luokka, jolle annetaan kaikki
 * tarvittavat tiedot pistelistojen ylläpitoon.
 * 
 * @author Markku Korhonen
 */

public class Pisteyttaja {
    
    private Lukija lukija;
    private Kirjoittaja kirjoittaja;
    private Pelaaja pelaaja;
    private File tiedosto;
    private List<Tulos>apulista;
    
    /**
     * Konstruktori saa parametreiksi Pelaaja-olion ja int-numeron. Numeroarvoa
     * tarvitaan oikean tiedoston valitsemiseen. Konstruktori alustaa luokkamuuttujat,
     * valitsee oikean tiedoston numeroarvon avulla ja täyttää luokkamuuttujana
     * olevan List-olion asianmukaisen tiedoston TOP-arvoilla.
     * @param pelaaja
     * @param koko
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    public Pisteyttaja(Pelaaja pelaaja, int koko) throws FileNotFoundException, IOException {
        lukija = new Lukija();
        this.pelaaja = pelaaja;
        tiedosto = new File("/Users/kinkki/Opiskelu/Javalabra/Muistipeli/tulokset/top" + 
                koko + ".csv");
        apulista = new ArrayList(lukija.lueTiedosto(tiedosto));
        kirjoittaja = new Kirjoittaja(tiedosto, apulista);    
    }
    
    /**
     * Metodi lisää pelaajan pisteet listaan käskemällä kirjoittaja-oliota.
     * @throws FileNotFoundException 
     */
    
    public void lisaaPisteet() throws FileNotFoundException {
            kirjoittaja.kirjoita(pelaaja.getTulos());      
    }
        
    /**
     * Metodia käytetään tulosten tarkasteluun. Se luuppaa tiedoston läpi
     * StringBuilder-olion ja kamalan algoritmihiriön avulla sekä tuo ruutuun 
     * uuden ikkunan, jossa tulokset näytetään.
     * @throws FileNotFoundException 
     */
    public void naytaTulokset() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        
        for(int i  = 0 ; i < lukija.lueTiedosto(tiedosto).size(); i++) {
            sb.append(i + 1).append(". sija: ").append(lukija.lueTiedosto(tiedosto).get(i).getNimi())
                    .append(", ").append(lukija.lueTiedosto(tiedosto).get(i).getSekuntit()).append(" sekuntia");
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }  
}