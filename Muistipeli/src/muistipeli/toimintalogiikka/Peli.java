package muistipeli.toimintalogiikka;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.gui.Kayttoliittyma;
import muistipeli.gui.Kyselija;
import muistipeli.gui.NapinKuuntelija;
import muistipeli.gui.ValikonKuuntelija;
import muistipeli.pelaaja.Pelaaja;
import muistipeli.tiedostonkasittelija.Pisteyttaja;

/**
 * Peli-luokka on Muistipelin keskeisin luokka, joka käytännössä yhdistää
 * välittömästi tai välilliseti kaikki muut luokat ja mahdollistaa ohjelman 
 * suorittamisen.
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
    
    private Ajastin ajastin;

    private Kyselija kyselija;
    
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
     * Peli-luokan konstruktori alustaa luokkamuuttujat. Se myös selvittää
     * parametrit pelaajalle ja pakalle Kyselija-olion avulla.
     * Lopuksi se lisää pakan korteille NapinKuuntelijat
     * ja käyttöliittymälle ValikonKuuntelijan.
     * 
     * @author Markku Korhonen 
     */
    public Peli() {   
        kyselija = new Kyselija();
        pelaaja = new Pelaaja(kyselija.kysyNimi());
        pakka = new Korttipakka(kyselija.kysyKorttienMaara());
        
        kali = new Kayttoliittyma(pakka, this);
        ajastin = new Ajastin();
        
        napinKuuntelija = new NapinKuuntelija();
        
        for (int i = 0; i < pakka.koko(); i++) {
            pakka.getKortti(i).addActionListener(napinKuuntelija);
        }
        
        valikonKuuntelija = new ValikonKuuntelija(kali, this);   
    }
   
    /**
     * Käynnistää ja lopettaa pelin sekä määrää sen logiikan. 
     * <p>
     * Aluksi käynnistetään graafinen käyttöliittymä. Peli etenee siten,
     * että valitaan kaksi korttia ja tarkistetaan ovatko ne parit.
     * Löydetyt parit ynnätään int-muuttujaan loydetytParit. Samalla lasketaan
     * vuorot.
     * <p>
     * Metodi luuppaa kunnes kaikki parit on löydetty, mikä tarkistetaan
     * jokaisen luupin lopussa kutsumalla peliLoppui()-metodia. Mikäli 
     * metodi palauttaa 'true', kutsutaan lopetaPeli()-metodia.
     * 
     * @throws InterruptedException 
     * @see valitseKortit()
     * @see peliLoppui()
     * @see lopetaPeli()
     */
    
    public void pelaa() throws InterruptedException, FileNotFoundException, IOException {       
        kali.run();
        int loydetytParit = 0;
        int vuorot = 0;
        ajastin.kaynnista();

        while (true) {               
            valitseKortit();
            
            if(tarkastaPari()) {
                loydetytParit++;
                vuorot++;               
            }           
            else {
                vuorot++;
            }
            
            if(peliLoppui(loydetytParit, vuorot)){
                lopetaPeli();           
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
     * Metodi tarkastaa onko peli loppu. Aluksi pakan koko jaetaan kahdella
     * ja tulosta verrataan parametrinä saatuna löydettyjen parien määrään.
     * Mikäli ne ovat samat, metodi pysäyttää ajastimen ja pelin tuloksen sekä
     * palauttaa 'true'.
     * <p>
     * Jos kaikkia pareja ei ole löydetty, palauttaa metodi 'false'.
     * @param loydetytParit
     * @param vuorot
     * @return true, jos kaikki parit ovat löytyneet, muuten false
     */
    
    private boolean peliLoppui(int loydetytParit, int vuorot) {
        if(pakka.koko() / 2 == loydetytParit) {
            ajastin.pysayta();
            JOptionPane.showMessageDialog(null, this.toString());

            return true;
        }
        return false;
    }
    
    /**
     * Metodi kysyy käyttäjältä, että pelataanko uudestaan vai ei.
     * Jos käyttäjä vastaa Kyllä, kutsutaan kaynnistaUudelleen()-metodia.
     * Muussa tapauksessa kutsutaan Kayttoliittyman sulje()-metodia.
     * @see kaynnistaUudelleen()
     * @see Kayttoliittyma.sulje()
     * @throws InterruptedException 
     */
    
    private void lopetaPeli() throws InterruptedException, FileNotFoundException, IOException {
        pelaaja.lisaaSekuntit(ajastin.getKokonaisaika());
        Pisteyttaja pisteyttaja = new Pisteyttaja(pelaaja, pakka.koko());
        pisteyttaja.lisaaPisteet();
        pisteyttaja.naytaTulokset();
        
        int vastaus = JOptionPane.showConfirmDialog(null, "Peli loppui, "
                    + "uudestaan?", null, JOptionPane.YES_NO_OPTION);
            
            if(vastaus == 1) {
                this.kaynnistaUudelleen();
            }            
            else {
                System.exit(0);
            }
    }
    
    
    /**
     * HUOM! Metodi ei vielä toimi (22.2 klo 12:24)
     * 
     * Käynnistää pelin alusta. Varsinainen ohjelma ei kuitenkaan nollaudu,
     * vaan Kortit käännetään piiloon ja sekoitetaan ilman, että käyttäjän
     * tarvitsee syöttää nimeään ja valita vaikeustasoa uudestaan.
     * <p>
     * Pelaajan jo ansaitut pisteet eivät rekisteröidy, vaan nollautuvat.
     * @throws InterruptedException 
     */
    
    public void kaynnistaUudelleen() throws InterruptedException {
        kali.sulje();
        pakka = pakka.nollaaPakka();
       // pelaaja.nollaaPisteet();
        
    }
    
    @Override
    public String toString() {
        return "Peli ohi " + pelaaja.getNimi() + "! Aikaa meni " + ajastin.getKokonaisaika() +
                " sekuntia. ";
                
    }
}