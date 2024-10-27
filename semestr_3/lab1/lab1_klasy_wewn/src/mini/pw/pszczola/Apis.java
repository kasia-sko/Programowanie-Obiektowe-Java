package mini.pw.pszczola;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Apis {

    private List<Pszczola> listaPszczol;
    protected static Random random = new Random();

    public Apis(){
        this.listaPszczol = new ArrayList<>();
        listaPszczol.add(new KrolowaMatka("Anna", 8));
    }

    public List<Pszczola> getListaPszczol(){
        return listaPszczol;
    }

    public List<Pszczola> znajdzKrolowa(){
        List<Pszczola> krolowe = new ArrayList<>();
        for(Pszczola p : listaPszczol){
            if (p instanceof KrolowaMatka){
                krolowe.add(p);
            }
        }
        return krolowe;
    }


    public void zyciePszczol(){
//        List<Pszczola> trutnie = new ArrayList<>();
//        for (Pszczola p : listaPszczol) {
//            if (p instanceof Truten) {
//                trutnie.add(p);
//            }
//        }
//
//        if (trutnie.isEmpty()) {
//            System.out.println("Brak dostępnych trutni do zapłodnienia.");
//            return;
//        }
//
//        List<Pszczola> krolowe = znajdzKrolowa();
//        if (krolowe.isEmpty()) {
//            System.out.println("Brak królowych do zapłodnienia.");
//            return;
//        }
//
//        for (Pszczola truten : trutnie) {
//            KrolowaMatka krolowa = (KrolowaMatka) krolowe.get(random.nextInt(krolowe.size()));
//            ((Truten) truten).zaplodnienie(krolowa);
//        }
//
//        List<Robotnica> robotnice = new ArrayList<>();
//        for (Pszczola p : listaPszczol) {
//            if (p instanceof Robotnica) {
//                robotnice.add((Robotnica) p);
//            }
//        }
//
//        if (robotnice.isEmpty()) {
//            System.out.println("Brak dostępnych robotnic do zbierania nektaru.");
//            return;
//        }
//
//        for (Robotnica robotnica : robotnice) {
//            robotnica.zbierajNektar(random.nextInt(21)); // Zbierają losową ilość nektaru
//        }
//        Truten truten1 = new Truten("Gucio", 5);
//        Truten truten2 = new Truten("Radek", 4);
//        dodajPszczole(truten1);
//        dodajPszczole(truten2);
//
//       List<Pszczola> krolowe = znajdzKrolowa();
//       truten1.zaplodnienie((KrolowaMatka) krolowe.get(random.nextInt(krolowe.size())));
//       truten2.zaplodnienie((KrolowaMatka) krolowe.get(random.nextInt(krolowe.size())));
//
//
//        Robotnica robotnica1 = new Robotnica("Maja", 20,10);
//        Robotnica robotnica2 = new Robotnica("Basia", 10,12);
//        dodajPszczole(robotnica1);
//        dodajPszczole(robotnica2);
//
//        robotnica1.zbierajNektar(50);
//        robotnica2.zbierajNektar(20);

        int licznikTruten = 2;
        int licznikRobotnica = random.nextInt(10);
        int licznikDostepnychRobotnic = 0;

        for (Pszczola pszczola : listaPszczol) {
            if (pszczola instanceof Robotnica) {
                licznikDostepnychRobotnic++;
            }
        }

        if (licznikRobotnica > licznikDostepnychRobotnic) {
            licznikRobotnica = licznikDostepnychRobotnic; // Ustaw licznik robotnic na maksymalną dostępną liczbę
        }


        for (Pszczola pszczola : listaPszczol){
            if (licznikTruten > 0 && pszczola instanceof Truten){
                pszczola.run();
                licznikTruten--;
            }
            if (licznikRobotnica > 0 && pszczola instanceof Robotnica){
                pszczola.run();
                licznikRobotnica--;
            }
        }
    }

    public void dodajPszczole(Pszczola p){
        listaPszczol.add(p);
    }

    public void watkiPszczol(){
        for (Pszczola p : listaPszczol){
            p.run();
        }
    }

    private static class PorownanieSily implements Comparator<Pszczola>{

        @Override
        public int compare(Pszczola p1, Pszczola p2) {
            return Integer.compare(p2.silaAtaku, p1.silaAtaku);
        }
    }

    public void sortujWgSilyIImienia() {
        listaPszczol.sort(new Comparator<Pszczola>() {
            @Override
            public int compare(Pszczola p1, Pszczola p2) {
                int porownanieSily = new PorownanieSily().compare(p1, p2);
                if (porownanieSily != 0) {
                    return porownanieSily;
                } else {
                    return p1.imie.compareTo(p2.imie);
                }
            }
        });
    }


    public void dodajZolnierza(){
        listaPszczol.add(new Pszczola("Helena", 99,10) {
            @Override
            public void run() {
                System.out.println("Walka to moje życie!!!");
            }

            @Override
            public String toString(){
                return "Żołnierz " + imie + " (atak: " + silaAtaku + "), żyję " + wiek + " dni i potrafię użądlić!";
            }

        });

    }


    public static abstract class Pszczola implements Runnable{

        protected String imie;
        protected int silaAtaku;
        protected int wiek;

        public Pszczola(String imie, int silaAtaku, int wiek) {
            this.imie = imie;
            this.silaAtaku = silaAtaku;
            this.wiek = wiek;
        }

        public Pszczola(String imie, int wiek) {
            this.imie = imie;
            this.wiek = wiek;
        }


    }

    public static class KrolowaMatka extends Pszczola {

        protected int iloscJaj;

        public KrolowaMatka(String imie, int wiek) {
            super(imie, wiek);
            this.silaAtaku = 100;
        }

        public void zaplodnienie() {
            iloscJaj += 1000;
        }

        @Override
        public void run() {
            System.out.println("Lot godowy...");
        }

        @Override
        public String toString() {
            return "Krolowa " + imie + " (atak: " + silaAtaku + "), żyję " + wiek + " dni i będę matką dla " + iloscJaj + " młodych pszczółek";
        }
    }

    public class Truten extends Pszczola{

        protected boolean przydatny;

        public Truten(String imie, int silaAtaku, int wiek) {
            super(imie, silaAtaku, wiek);
            this.przydatny = true;
        }

        public Truten(String imie, int wiek) {
            super(imie, wiek);
            this.przydatny = true;
        }

        private void zaplodnienie(KrolowaMatka krolowa){
            if(!przydatny){
                System.out.println("już spełniłem swoje zadanie :(");
            }
            else{
                krolowa.zaplodnienie();
                System.out.println(imie + " - byłem z Królową!!! Można umierać...");
                przydatny = false;
            }
        }

        @Override
        public void run() {
            if(random.nextInt(10) > 5){
                System.out.println("Jak przyjemnie nie robić nic...");
            }
            else {
                List<Pszczola> krolowe = znajdzKrolowa();
                this.zaplodnienie((KrolowaMatka) krolowe.get(random.nextInt(krolowe.size())));
            }
        }

        @Override
        public String toString() {
            if (przydatny) {
                return "Truten " + imie + " (atak: " + silaAtaku + "), żyję " + wiek + " dni";
            }
            else {
                return "Truten " + imie + " (atak: " + silaAtaku + "), spełniłem swoje zadanie :(";
            }
        }
    }

    public static class Robotnica extends Pszczola{

        protected int iloscWyprodukowanegoMiodu;

        public Robotnica(String imie, int silaAtaku, int wiek) {
            super(imie, silaAtaku, wiek);
        }

        public Robotnica(String imie, int wiek) {
            super(imie, wiek);
        }

        public void zbierajNektar(int ilosc){
            iloscWyprodukowanegoMiodu += ilosc;
            System.out.println(imie + " - kolejna porcja miodu do kubełka...");
        }

        @Override
        public void run() {
            this.zbierajNektar(random.nextInt(21));
        }

        @Override
        public String toString() {
            return "Robotnica " + imie + " (atak: " + silaAtaku + "), żyję " + wiek + " dni i zrobiłam " + iloscWyprodukowanegoMiodu + " baryłek miodu :)";
        }


    }


}
