
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
        Tulos vaihdettava;
        
        for(i = 0; i < tuloslista.size() - 1; i++) {
            pienin = tuloslista.get(i);
            
            for(j = i + 1; j < tuloslista.size(); j++) {
                if(tuloslista.get(j).getTulos() < pienin.getTulos()) {
                    pienin = tuloslista.get(j);
                }
            }
            if(!pienin.equals(pienin)){
                System.out.println("!equals");
                vaihdettava  = tuloslista.get(i);
                tuloslista.add(i, pienin);
                tuloslista.add(j, vaihdettava);
            }
            
        }
        return tuloslista;
        
    }
}