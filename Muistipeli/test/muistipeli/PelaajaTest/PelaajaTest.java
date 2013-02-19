/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.PelaajaTest;

import muistipeli.pelaaja.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kinkki
 */
public class PelaajaTest {
    
    private String nimi = "nimi";
    private Pelaaja testipelaaja;
    
    public PelaajaTest() {
    }
    
    @Before
    public void luoPelaaja() {
        testipelaaja = new Pelaaja(nimi);
    }
    
    @Test
    public void konstruktoriTestaus() {        
        Pelaaja pelaaja = new Pelaaja(nimi);
        assertTrue(pelaaja.getNimi().equals(nimi));
        }
    
   /* @Test
    public void konstruktoriTestaus2() {
        Pelaaja pelaaja = new Pelaaja(nimi);
        assertTrue(pelaaja.getPisteet() == 0);
    }
    
    @Test
    public void pisteidenLisaaminen() {
        for(int i = 0; i < 20; i++) {
            testipelaaja.lisaaPiste();
        }
    }*/
    
}
