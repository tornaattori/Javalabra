
package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lukija {
    
    private Scanner lukija;
    
    public Lukija(File tiedosto) throws FileNotFoundException {
        this.lukija = new Scanner(tiedosto);
    }
    
    public int palautaViimeinenArvo() {
        String viimeinenArvo = "0";
        
        while(lukija.hasNextLine()) {
            viimeinenArvo = lukija.nextLine();
        }
        return Integer.parseInt(viimeinenArvo);
    }
    
    public void listaaPisteet() {
        StringBuilder sb = new StringBuilder();
        
        while(lukija.hasNextLine()) {
            sb.append(lukija.nextLine());
            sb.append("\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }

}