package muistipeli.toimintalogiikka;

import muistipeli.Kortit.Kortti;
import muistipeli.Kortit.Korttipakka;
import muistipeli.gui.Kayttoliittyma;
import muistipeli.gui.NapinKuuntelija;

public class Peli {

    private Kayttoliittyma kali;
    private Korttipakka pakka;
    private NapinKuuntelija kuuntelija;
    private Kortti kortti1, kortti2;

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