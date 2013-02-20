
package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lukija {
    
    private Scanner lukija;
    private Map<String, Integer> tuloslista;
    
    public Lukija(File tiedosto) throws FileNotFoundException {
        this.lukija = new Scanner(tiedosto);
        tuloslista = new HashMap<String, Integer>();
        
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
        sb.append("TOP10-lista 10 kokoiselle muistipelille: \n \n");
        
        int i = 1;    
        while(lukija.hasNextLine()) {
            
            sb.append(i);
            sb.append(". sija: ");
            sb.append(lukija.nextLine());
            sb.append("\n");
            
            i = i + 1;
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    public StringBuilder listaaPisteetKirjoittajalle() {
        StringBuilder sb = new StringBuilder();
        
        int i = 1;    
        while(lukija.hasNextLine()) {
            
            sb.append(i);
            sb.append(". sija: ");
            sb.append(lukija.nextLine());
            sb.append("\n");
            
            i = i + 1;
        }
        return sb;
    }
    
    public int haeTulostenMaara() {
        int i = 0;
        while(lukija.hasNextLine()) {
            i = i + 1;
        }     
        return i;
    }
    
    public Map<String, Integer> lueLista() {
        while(lukija.hasNextLine()) {
            String[] tulokset = lukija.nextLine().split(",");
            
            tuloslista.put(tulokset[0], Integer.parseInt(tulokset[1]));
            tuloslista.put("m", 1);
        }
        
        return tuloslista;
        
        
    }


}