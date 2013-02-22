/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.PelaajaTest;

import muistipeli.pelaaja.Pelaaja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PelaajaTest testaa sekä Pelaaja- että Tulos-luokkaa.
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
    
   @Test
    public void konstruktoriTestaus2() {
        Pelaaja pelaaja = new Pelaaja(nimi);
        assertTrue(pelaaja.getTulos().getSekuntit() == 0);
    }
    
    @Test
    public void pisteidenLisaaminen() {
        testipelaaja.lisaaSekuntit(20);
        assertTrue(testipelaaja.getTulos().getSekuntit() == 20);            
    }
    
    @Test
    public void nimiOnOikea() {
        assertTrue(testipelaaja.getNimi().equals(nimi));
    }
    
    @Test
    public void nimiOnOikea2() {
        assertTrue(testipelaaja.getNimi().equals(testipelaaja.getTulos().getNimi()));
    }
    
    
    
}
