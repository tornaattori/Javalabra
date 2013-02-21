
package muistipeli.pelaaja;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Kirjoittaja {

    private PrintWriter kirjoittaja;
    private List<Tulos> lista;
    
    public Kirjoittaja(File tiedosto, List<Tulos> tuloslista) throws IOException {
        lista = new ArrayList(tuloslista);
        kirjoittaja = new PrintWriter(new FileWriter(tiedosto, false));
    }

    public void kirjoita(Tulos tulos) {
        lista.add(tulos);

        List<Tulos> apulista = new ArrayList(jarjestaLista(lista));
        
        for(int i = 0; i < apulista.size(); i++) {
            kirjoittaja.println(apulista.get(i).toString());        
        }
        kirjoittaja.close();
    }
    
    public List<Tulos> jarjestaLista(List<Tulos> tuloslista) {
        int i, j;
        Tulos pienin;
        
        for(j = 0; j < tuloslista.size() - 1; j++) {
            pienin = tuloslista.get(j);
            
            for(i = j + 1; i < tuloslista.size(); i++) {
                if(tuloslista.get(i).getTulos() < pienin.getTulos()) {
                    pienin = tuloslista.get(i);
                }
            }
        }
        return tuloslista;
        
    }
}