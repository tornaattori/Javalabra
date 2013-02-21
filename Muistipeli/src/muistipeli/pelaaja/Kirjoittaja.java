
package muistipeli.pelaaja;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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

        //List<Tulos> apulista = new ArrayList(jarjestaLista(lista));
        
        jarjestaLista(lista);
        
        if(lista.size() > 9) {
            lista.remove(10);
        }      
        
        for(int i = 0; i < lista.size(); i++) {
            kirjoittaja.println(lista.get(i).toString());        
        }
       
        kirjoittaja.close();
    }
    
    /**
     * Selection-sort
     * @param tuloslista
     * @return 
     */
    
    public List<Tulos> jarjestaLista(List<Tulos> tuloslista) {
        
        int i, j, indeksi = 0;
        Tulos pienin;
        
        for(i = 0; i < tuloslista.size() - 1; i++) {
            pienin = tuloslista.get(i);
            
            for(j = i + 1; j < tuloslista.size(); j++) {
                if(tuloslista.get(j).getTulos() < pienin.getTulos()) {
                    pienin = tuloslista.get(j);
                    indeksi = j;
                }
            }
            if(!pienin.equals(tuloslista.get(i))){
                Collections.swap(lista, i, indeksi);
            }           
        }
        return tuloslista;
    }
}