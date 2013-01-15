package muistipeli.kortit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Tila;
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
public class KorttiTest {
    
    private Kortti testikortti;
    private Kortti testikortti2;
    
    public KorttiTest() {
        testikortti = new Kortti(3);
        testikortti2 = new Kortti(10);
        
    }
    
    /*
     * Alla testataan Kortti-luokan konstruktoria ja id:n gettaamista
     */    
    @Test
    public void luoKorttiTestaaId() {
        Kortti kortti = new Kortti(0);
        assertTrue(kortti.getId() == 0);
    }
    
    @Test
    public void luoKorttiTestaaId2() {
        Kortti kortti = new Kortti(1000);
        assertTrue(kortti.getId() == 1000);
    }
    
    
    /*
     * Seuraavaksi testataan Kortti-luokan Tila-ominaisuutta
     */
    @Test
    public void luoKorttiTestaaTila() {
        Kortti kortti = new Kortti(4);
        assertTrue(kortti.getTila() == Tila.KIINNI);
    }
    
    @Test
    public void kaannaKorttia() {
        testikortti.kaanna();
        assertTrue(testikortti.getTila() == Tila.AUKI);
    }
    
    @Test
    public void kaannaKorttiaKahdesti() {
        testikortti.kaanna();
        testikortti.kaanna();
        assertTrue(testikortti.getTila() == Tila.KIINNI);
    }
    
    @Test
    public void kaannaKorttiaTuhannesti() {
        for(int i = 0; i < 1000; i++) {
            testikortti.kaanna();
        }        
        assertTrue(testikortti.getTila() == Tila.KIINNI);
    }
    
    @Test
    public void piilotaKortti() {
        testikortti.piilotaLoydetty();
        assertTrue(testikortti.getTila() == Tila.PIILOSSA);
    }
    
    @Test
    public void piilotettuKorttiEiKaanny() {
        testikortti2.piilotaLoydetty();
        testikortti2.kaanna();
        assertTrue(testikortti2.getTila() == Tila.PIILOSSA);
    }
}