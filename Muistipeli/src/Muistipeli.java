
import java.io.FileNotFoundException;
import java.io.IOException;
import muistipeli.toimintalogiikka.Peli;



public class Muistipeli {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        
        Peli peli = new Peli();
        peli.pelaa();
        
    }

}