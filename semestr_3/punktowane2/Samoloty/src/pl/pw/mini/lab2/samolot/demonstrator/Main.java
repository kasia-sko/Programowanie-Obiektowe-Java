package pl.pw.mini.lab2.samolot.demonstrator;

import pl.pw.mini.lab2.samolot.lotnisko.Lotnisko;

public class Main {
    public static void main(String[] args) {
        Lotnisko lotnisko = new Lotnisko(10); // np. 10 samolotów

        System.out.println("Samoloty na lotnisku:");
        System.out.println("---------------------");
        lotnisko.getInfoOLotnisku();

        System.out.println("Próba odlotu:");
        System.out.println("----------------------");
        lotnisko.odlot();

        System.out.println("Odprawa:");
        System.out.println("----------");
        lotnisko.odprawaSamolotow();
        lotnisko.getInfoOLotnisku();


        System.out.println("Odlot:");
        System.out.println("--------");
        lotnisko.odlot();

        System.out.println("Działania lotniskowe:");
        System.out.println("-----------------------");
        lotnisko.dzialaniaLotniskowe();

        System.out.println("Sortowanie samolotów:");
        System.out.println("-----------------------");
        lotnisko.sortowanieSamolotow();

        System.out.println("Sortowanie losowe:");
        System.out.println("--------------------");
        lotnisko.sortowanieLosowe();
    }

}
