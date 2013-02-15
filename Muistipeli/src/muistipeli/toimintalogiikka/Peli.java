package muistipeli.toimintalogiikka;

import javax.swing.JOptionPane;
import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.gui.Kayttoliittyma;
import muistipeli.gui.NapinKuuntelija;
import muistipeli.gui.ValikonKuuntelija;
import muistipeli.pelaaja.Pelaaja;

/**
 * Peli-luokka on Muistipelin keskeisin luokka, joka käytännössä yhdistää
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
    
    //Pelaaja ei tee vielä mitään.
    private Pelaaja pelaaja;
    
    private Ajastin ajastin;

    private ValikonKuuntelija valikonKuuntelija;
    
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
     * Peli-luokan konstruktori alustaa luokkamuuttujat. Se myös kutsuu
     * kysyTiedot()-metodia. Lopuksi se lisää pakan korteille NapinKuuntelijat
     * ja käyttöliittymälle ValikonKuuntelijan.
     * 
     * @author Markku Korhonen
     * @see kysyTiedot()
     */
    public Peli() {   
        kysyTiedot();
        kali = new Kayttoliittyma(pakka, this);
        
        napinKuuntelija = new NapinKuuntelija();
        
        for (int i = 0; i < pakka.koko(); i++) {
            pakka.getKortti(i).addActionListener(napinKuuntelija);
        }
        
        valikonKuuntelija = new ValikonKuuntelija(kali, this);
        ajastin = new Ajastin();
    }
    
    /**
     * Metodi lyö ruudulle ikkunan, johon pelaaja syöttää nimensä.
     * Tämän jälkeen metodi kysyy vielä uudessa ikkunassa halutun
     * koon.
     */
    
    private void kysyTiedot() {
        pelaaja = new Pelaaja(JOptionPane.showInputDialog("Syötä nimesi!"));
        
        int koko = Integer.parseInt(JOptionPane.showInputDialog("Kuin monel fläbäl säädetää?"));
        pakka = new Korttipakka(koko);
    }

    /**
     * Käynnistää pelin ja määrää pelin logiikan. 
     * <p>
     * Aluksi käynnistetään graafinen käyttöliittymä. Peli etenee siten,
     * että valitaan kaksi korttia ja tarkistetaan ovatko ne parit.
     * Löydetyt parit ynnätään int-muuttujaan loydetytParit. Samalla lasketaan
     * vuorot. Kun löydettyjen parien määrä on sama kuin pakan koko jaettuna
     * kahdella, ts. kaikki parit on löydetty, peli loppuu.
     * 
     * @throws InterruptedException 
     */
    
    public void pelaa() throws InterruptedException {       
        kali.run();
        int loydetytParit = 0;
        int vuorot = 0;
        ajastin.kaynnista();

        while (true) {               
            valitseKortit();
            
            if(tarkastaPari()) {
                loydetytParit++;
                vuorot++;
                pelaaja.lisaaPiste();                
            }           
            else {
                vuorot++;
            }
            
            if(peliLoppui(loydetytParit, vuorot)){
                break;
            }
        }
    }
    /**
     * Metodin avulla valitaan kortit ja käännetään ne.
     * @see NapinKuuntelija
     * @see Kortti
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
        Thread.sleep(750); //keskeyttää ohjelman

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
    
    /**
     * Käynnistää pelin alusta. Varsinainen ohjelma ei kuitenkaan nollaudu,
     * vaan Kortit käännetään piiloon ja sekoitetaan ilman, että käyttäjän
     * tarvitsee syöttää nimeään ja valita vaikeustasoa uudestaan.
     * <p>
     * Pelaajan jo ansaitut pisteet eivät rekisteröidy, vaan nollautuvat.
     * @throws InterruptedException 
     */
    
    private boolean peliLoppui(int loydetytParit, int vuorot) {
        if(pakka.koko() / 2 == loydetytParit) {
            JOptionPane.showMessageDialog(null, this.toString());
            
            ajastin.pysayta();

            return true;
        }
        return false;
    }
    
    
    public void kaynnistaUudelleen() throws InterruptedException {
        pakka.nollaaPakka();
        
    }
    
    @Override
    public String toString() {
        return "Rakas " + pelaaja.getNimi() + ", peli on ohi! Sait pisteitä "
                + (ajastin.getKokonaisaika()/pakka.koko()) * 100;
    }
}