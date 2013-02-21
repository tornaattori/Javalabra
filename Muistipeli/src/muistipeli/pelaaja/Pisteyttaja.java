
package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Pisteyttaja {

    private Lukija lukija;
    private Kirjoittaja kirjoittaja;
    private Pelaaja pelaaja;
    private File tiedosto;
    private List<Tulos>apulista;
    
    public Pisteyttaja(Pelaaja pelaaja, int koko) throws FileNotFoundException, IOException {
        lukija = new Lukija();
        this.pelaaja = pelaaja;
        tiedosto = new File("/Users/kinkki/Opiskelu/Javalabra/Muistipeli/tulokset/top" + 
                koko + ".csv");
        apulista = new ArrayList(lukija.lueTiedosto(tiedosto));
        kirjoittaja = new Kirjoittaja(tiedosto, apulista);    
    }
    
    public void lisaaPisteet() throws FileNotFoundException {
        if(lukija.lueTiedosto(tiedosto).isEmpty()) {
            kirjoittaja.kirjoita(pelaaja.getTulos());
        }
        
        else {
            kirjoittaja.kirjoita(pelaaja.getTulos());
        }      
    }
        
    public void naytaTulokset() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        
        for(int i  = 0 ; i < lukija.lueTiedosto(tiedosto).size(); i++) {
            sb.append(i + 1).append(". sija: ").append(lukija.lueTiedosto(tiedosto).get(i).getNimi())
                    .append(", ").append(lukija.lueTiedosto(tiedosto).get(i).getTulos()).append(" sekuntia");
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }  
}