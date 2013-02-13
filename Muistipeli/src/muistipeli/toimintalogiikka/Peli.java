package muistipeli.toimintalogiikka;

import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.gui.Kayttoliittyma;
import muistipeli.gui.NapinKuuntelija;
import muistipeli.gui.ValikonKuuntelija;
import muistipeli.pelaaja.Pelaaja;

/**
 * Peli-luokka on Muistipelin tärkein luokka, joka käytännössä yhdistää
 * kaikki muut luokat ja mahdollistaa ohjelman käynnistämisen.
 * 
 * @author kinkki
 */

public class Peli {

    /**
     * Pelin käyttöliittymä. Käynnistetään Peli-luokan kautta.
     * @see Kayttoliittyma
     */
    private Kayttoliittyma kali;
    
    /*
     * Kortit sisältävä pakka. Annetaan "kali"-oliolle, jotta
     * Muistipeli käsittelisi samaa pakkaa.
     * @see Korttipakka
     */
    private Korttipakka pakka;
    
    private Pelaaja pelaaja;

    /*
     * Kuuntelee nappien tapahtumia.
     * @see NapinKuuntelija
     */
    private NapinKuuntelija napinKuuntelija;
    /**
     * Näitä kahta Kortti-oliota tarvitaan pelin logiikan suorittamiseksi.
     */
    private Kortti kortti1, kortti2;

    /**
     * Peli-luokan konstruktori alustaa luokkamuuttujat. Tämän lisäksi se
     * lisää pakan korteille NapinKuuntelija-olion.
     * @author Markku Korhonen
     */
    public Peli() {
        pakka = new Korttipakka();
        kali = new Kayttoliittyma(pakka);
        napinKuuntelija = new NapinKuuntelija();
        
        for (int i = 0; i < pakka.koko(); i++) {
            pakka.getKortti(i).addActionListener(napinKuuntelija);
        }
    }

    /**
     * Käynnistää pelin ja määrää pelin logiikan. 
     * <p>
     * Aluksi käynnistetään graafinen käyttöliittymä. Peli etenee siten,
     * että valitaan kaksi korttia ja tarkistetaan, että ovatko ne parit.
     * Löydetyt parit ynnätään int-muuttujaan. Samalla lasketaan
     * vuorot. Kun löydettyjen parien määrä on sama kuin pakan koko jaettuna
     * kahdella, ts. kaikki parit on löydetty, peli loppuu.
     * 
     * @throws InterruptedException 
     */
    
    public void pelaa() throws InterruptedException {       
        kali.run();
        int loydetytParit = 0;
        int vuorot = 0;

        while (true) {        
            
            System.out.println(vuorot);
            valitseKortit();
            
            if(tarkastaPari()) {
                loydetytParit++;
                vuorot++;
            }
            
            else {
                vuorot++;
            }
            
            if(pakka.koko() / 2 == loydetytParit) {
                System.out.println("PELI OHI! Vuoroja käytit: " + vuorot);
                break;
            }
        }
    }
    /**
     * Metodin avulla valitaan kortit ja käännetään ne.
     */

    private void valitseKortit() {
        Kortti valittuKortti;

        valittuKortti = napinKuuntelija.odotaNappia();
        kortti1 = (Kortti) valittuKortti;
        kortti1.kaanna();

        while (true) {
            valittuKortti = napinKuuntelija.odotaNappia();
            kortti2 = (Kortti) valittuKortti;
            
            if (kortti2 != kortti1) {
                kortti2.kaanna();
                break;
            }
        }
    }
    /**
     * Tarkastaa ovatko valitut kortit pari. Metodi myös keskeyttää ohjelman
     * toiminnan kun kaksi korttia on valittu, jotta käyttäjä ehtii
     * lukea valitsemansa kortit.
     * <p>
     * Mikäli kortit ovat pari, metodi piilottaa ne ja poistaa niistä
     * kuuntelijan. Muussa tapauksessa kortit käännetään kiinni.
     * 
     * @return true, jos kortit ovat parit. Muuten palautetaan false.
     * @throws InterruptedException 
     */
    
    private boolean tarkastaPari() throws InterruptedException {
        Thread.sleep(750);
        
        //new Timer (new ActionListener())
        if(kortti1.getId() == kortti2.getId()) {
            kortti1.piilotaLoydetty();
            kortti1.removeActionListener(napinKuuntelija);
            kortti2.piilotaLoydetty();
            kortti2.removeActionListener(napinKuuntelija);
            return true;
        }
        else {
            kortti1.kaanna();
            kortti2.kaanna();
        }
        return false;
    }
    
    public void kaynnistaUudelleen() throws InterruptedException {
        //pelaaja.nollaaPisteet();
        pakka.nollaaPakka();
        this.pelaa();
    }
}