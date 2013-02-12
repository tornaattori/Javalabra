package muistipeli.toimintalogiikka;

import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.gui.Kayttoliittyma;
import muistipeli.gui.NapinKuuntelija;

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
    /*
     * Kuuntelee nappien tapahtumia.
     * @see NapinKuuntelija
     */
    private NapinKuuntelija kuuntelija;
    /**
     * Näitä kahta Kortti-oliota tarvitaan pelin logiikan suorittamiseksi.
     */
    private Kortti kortti1, kortti2;

    /**
     * Peli-luokan konstruktori alustaa luokkamuuttujat. Tämän lisäksi se
     * lisää pakan korteille NapinKuuntelija
     * @author Markku Korhonen
     */
    public Peli() {
        pakka = new Korttipakka();
        kali = new Kayttoliittyma(pakka);
        kuuntelija = new NapinKuuntelija();

        for (int i = 0; i < pakka.koko(); i++) {
            pakka.getKortti(i).addActionListener(kuuntelija);
        }
    }

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

    private void valitseKortit() {
        Kortti valittuKortti;

        valittuKortti = kuuntelija.odotaNappia();
        kortti1 = (Kortti) valittuKortti;
        kortti1.kaanna();

        while (true) {
            valittuKortti = kuuntelija.odotaNappia();
            kortti2 = (Kortti) valittuKortti;
            
            if (kortti2 != kortti1) {
                kortti2.kaanna();
                break;
            }
        }
    }
    
    private boolean tarkastaPari() throws InterruptedException {
        Thread.sleep(750);
        if(kortti1.getId() == kortti2.getId()) {
            kortti1.piilotaLoydetty();
            kortti1.removeActionListener(kuuntelija);
            kortti2.piilotaLoydetty();
            kortti2.removeActionListener(kuuntelija);
            return true;
        }
        else {
            kortti1.kaanna();
            kortti2.kaanna();
        }
        return false;
    }    
}