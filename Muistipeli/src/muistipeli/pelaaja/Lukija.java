
package muistipeli.pelaaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lukija {
    
    public Lukija() throws FileNotFoundException {

    }    
    
    public List<Tulos> lueTiedosto(File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        List<Tulos> tuloslista = new ArrayList();

        while( true ) {            
            if(lukija.hasNext() == false) {
                break;
            }
            String[] aputaulukko = lukija.nextLine().split(",");
            Tulos tulos = new Tulos(aputaulukko[0], Integer.parseInt(aputaulukko[1]));
            
            tuloslista.add(tulos);
        }
        return tuloslista;
    }
    
}