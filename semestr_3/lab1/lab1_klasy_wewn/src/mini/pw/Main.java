package mini.pw;

import mini.pw.pszczola.Apis;

public class Main {
    public static void main(String[] args) {
        Apis apis = new Apis();

        apis.dodajPszczole(new Apis.KrolowaMatka("Alicja", 7));
        apis.dodajPszczole(apis.new Truten("Leon", 3));
        apis.dodajPszczole(new Apis.Robotnica("Ola", 4));
        apis.dodajPszczole(new Apis.Robotnica("Kasia", 3));


        apis.sortujWgSilyIImienia();

       apis.getInfoApis();

        apis.zyciePszczol();
        apis.dodajZolnierza();
        apis.sortujWgSilyIImienia();


        apis.getInfoApis();

        apis.watkiPszczol();
    }
}
