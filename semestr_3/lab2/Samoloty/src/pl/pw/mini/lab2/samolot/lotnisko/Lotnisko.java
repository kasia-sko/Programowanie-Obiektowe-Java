package pl.pw.mini.lab2.samolot.lotnisko;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;

public class Lotnisko {

    protected Random random = new Random();

    protected ArrayList<Samolot> samoloty = new ArrayList<>();

    public Lotnisko(int n) {
        for(int i = 0; i < n; i++){
            int x = random.nextInt(3);
            GenerujacyNazwe generatorNazwy = () -> {
                int dlugosc = random.nextInt(20) + 1;
                StringBuilder nazwa = new StringBuilder();
                for (int j = 0; j < dlugosc; j++) {
                    nazwa.append((char) (random.nextInt(26) + 'a'));
                }
                return nazwa.toString();
            };
            if(x == 0){
                samoloty.add(new SamolotPasażerski(generatorNazwy.generuj(), random.nextInt(500) + 500, random.nextInt(200) + 100));
            }
            else if(x == 1){
                samoloty.add(new SamolotTowarowy(generatorNazwy.generuj(), random.nextInt(400) + 300, random.nextInt(90) + 10));
            }
            else {
                samoloty.add(new Mysliwiec(generatorNazwy.generuj(), random.nextInt(2700) + 300));
            }
        }
    }

    @FunctionalInterface
    public interface GenerujacyNazwe {
        String generuj();
    }

    public void getInfoOLotnisku(){
        samoloty.forEach(samolot -> System.out.println(samolot.toString()));

    }
    public void odprawaSamolotow(){
        for (Samolot s : samoloty) {
            try {
                if (s instanceof SamolotPasażerski) {
                    //System.out.println("Odprawiam samolot pasazerski");
                    s.odprawa(random.nextInt(400));
                } else if (s instanceof SamolotTowarowy) {
                    //System.out.println("Odprawiam samolot towarowy");
                    s.odprawa(200);
                } else {
                    s.odprawa(10);
                }
            } catch (Samolot.WyjatekLotniczy e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void odlot(){
        for(Samolot s : samoloty){
            s.lec(random.nextInt(12));
        }
    }

    public void dzialaniaLotniskowe(){
        // a) toString
        Consumer<Samolot> wyswietlInfo = samolot -> System.out.println(samolot.toString());
        samoloty.forEach(wyswietlInfo);

        // b) laduj
        Consumer<Samolot> ladujSamolot = samolot -> samolot.laduj();
        samoloty.forEach(ladujSamolot);
        samoloty.forEach(wyswietlInfo);

        // c) odprawa
        Consumer<Samolot> odprawSamolot = samolot -> {
            try {
                samolot.odprawa(400);
            } catch (Samolot.WyjatekLotniczy e) {
                e.getMessage();
            }
        };
        samoloty.forEach(odprawSamolot);
        samoloty.forEach(wyswietlInfo);

        // d) lec
        Consumer<Samolot> lecSamolot = samolot -> samolot.lec(10);
        samoloty.forEach(lecSamolot);
        samoloty.forEach(wyswietlInfo);

        // e) atak
        Consumer<Samolot> atakujSamolot = samolot -> {
            if(samolot instanceof Mysliwiec){
                ((Mysliwiec) samolot).atak();
            }
        };
        samoloty.forEach(atakujSamolot);
        samoloty.forEach(wyswietlInfo);

    }

    public void sortowanieSamolotow(){
        Comparator<Samolot> sortowaniePoPredkosci = (s1,s2) -> Integer.compare(s1.predkoscMax, s2.predkoscMax);
        samoloty.sort(sortowaniePoPredkosci);
        System.out.println("Samoloty posortowane po predkosci");
        samoloty.forEach(samolot -> System.out.println(samolot.toString()));

        Comparator<Samolot> sortowaniePoNazwie = (s1,s2) -> {
            if(s1.nazwa.length() > 5 && s2.nazwa.length() > 5) {
                return s1.nazwa.compareTo(s2.nazwa);
            }
            return 0;
        };
        samoloty.sort(sortowaniePoNazwie);
        System.out.println("Samoloty posortowane po nazwie");
        samoloty.forEach(samolot -> System.out.println(samolot.toString()));
    }

    public interface ComparatorGenerator{
        Comparator<Samolot> generujKomparator();
    }

    public void sortowanieLosowe(){
        ComparatorGenerator generator = () -> {
            if (random.nextBoolean()) {
                return (s1, s2) -> Integer.compare(s1.predkoscMax, s2.predkoscMax);
            } else {
                return (s1, s2) -> {
                    if (s1.nazwa.length() > 5 && s2.nazwa.length() > 5) {
                        return s1.nazwa.compareTo(s2.nazwa);
                    }
                    return 0;
                };
            }
        };

        Comparator<Samolot> komparator = generator.generujKomparator();
        samoloty.sort(komparator);

        System.out.println("Samoloty posortowane losowo:");
        samoloty.forEach(samolot -> System.out.println(samolot.toString()));

    }

    public static abstract class Samolot {

        protected Random random = new Random();
        protected String nazwa;
        protected int predkoscMax;
        protected int iloscGodzinWPowietrzu;
        protected boolean czyWPowietrzu = false;
        protected boolean czyOdprawiony = false;

        public Samolot(String nazwa, int predkoscMax) {
            this.nazwa = nazwa;
            this.predkoscMax = predkoscMax;
        }

        public void lec(int iloscGodzin){
            iloscGodzinWPowietrzu += iloscGodzin;
            if(czyOdprawiony && !czyWPowietrzu){
                System.out.println("Startujemy...");
                czyWPowietrzu = true;
            }
            else if(czyWPowietrzu){
                System.out.println("Lecimy");
            }
            else{
                System.out.println("Nie możemy wystartować");
            }
        }

        public void laduj(){
            if(czyWPowietrzu){
                System.out.println("Ladujemy");
                czyWPowietrzu = false;
            }
            else {
                System.out.println("I tak jesteśmy na ziemi");
            }
        }

        public abstract void odprawa(int i) throws WyjatekLotniczy;

        public static class WyjatekLotniczy extends Exception{
            public WyjatekLotniczy(String message){
                super(message);
            }
        }

    }

    public static class SamolotPasażerski extends Samolot{

        protected final int maxLiczbaPasazerow;
        protected int aktualnaLiczbaPasazerow;

        public SamolotPasażerski(String nazwa, int predkoscMaksymalna, int maxLiczbaPasazerow) {
            super(nazwa, predkoscMaksymalna);
            this.maxLiczbaPasazerow = maxLiczbaPasazerow;
        }

        @Override
        public void odprawa(int iloscPasazerow) throws WyjatekEkonomiczny{
            this.aktualnaLiczbaPasazerow = iloscPasazerow;
            if(aktualnaLiczbaPasazerow < maxLiczbaPasazerow/2){
                throw new WyjatekEkonomiczny("Zbyt mały ładunek, nie opłaca się lecieć");
            }
            else if(aktualnaLiczbaPasazerow > maxLiczbaPasazerow){
                czyOdprawiony = true;
                throw new WyjatekEkonomiczny("Za dużo o " + (aktualnaLiczbaPasazerow - maxLiczbaPasazerow) + " pazażerów");
            }
            czyOdprawiony = true;
            //System.out.println("Odprawiony");

        }

        public static class WyjatekEkonomiczny extends WyjatekLotniczy{
            public WyjatekEkonomiczny(String message) {
                super(message);
            }
        }

        @Override
        public String toString() {
            return "Samolot pasażerski o nazwie '" + nazwa + "'. " +
                    "Prędkość maksymalna " + predkoscMax + ", " +
                    "w powietrzu spędził łącznie " + iloscGodzinWPowietrzu + " godzin, " +
                    "może zabrać na pokład " + maxLiczbaPasazerow + " pasażerów. " +
                    "Aktualnie " + (!czyWPowietrzu ? "uziemiony." : "w powietrzu.");
        }
    }

    public static class SamolotTowarowy extends Samolot{

        protected int maxLadunek;
        protected int aktualnyLadunek;

        public SamolotTowarowy(String nazwa, int predkoscMax, int maxLadunek) {
            super(nazwa, predkoscMax);
            this.maxLadunek = maxLadunek;
        }

        @Override
        public void odprawa(int iloscLadunku) throws SamolotPasażerski.WyjatekEkonomiczny {
            this.aktualnyLadunek = iloscLadunku;
            if(aktualnyLadunek < maxLadunek / 2){
                throw new SamolotPasażerski.WyjatekEkonomiczny("Zbyt mały ładunek, nie opłaca się lecieć");
            }
            else if (aktualnyLadunek > maxLadunek){
                czyOdprawiony = true;
                throw new SamolotPasażerski.WyjatekEkonomiczny("Za dużo o " + (aktualnyLadunek - maxLadunek) + " ton");
            }
            czyOdprawiony = true;

        }

        @Override
        public String toString() {
            return "Samolot towarowy o nazwie '" + nazwa + "'. " +
                    "Prędkość maksymalna " + predkoscMax + ", " +
                    "w powietrzu spędził łącznie " + iloscGodzinWPowietrzu + " godzin, " +
                    "może zabrać na pokład " + maxLadunek + " ton ładunku. " +
                    "Aktualnie " + (!czyWPowietrzu ? "uziemiony." : "w powietrzu.");
        }
    }

    public static class Mysliwiec extends Samolot{
         protected int iloscRakiet;

        public Mysliwiec(String nazwa, int predkoscMax) {
            super(nazwa, predkoscMax);
        }

        public void odprawa(int iloscRakiet){
            this.iloscRakiet = iloscRakiet;
            czyOdprawiony = true;
        }

        public void atak(){
            if (czyWPowietrzu) {
                System.out.println("Ataaaaak");
                iloscRakiet--;
                if(iloscRakiet == 0){
                    laduj();
                }
            }
        }

        @Override
        public String toString() {
            return "Myśliwiec o nazwie '" + nazwa + "'. " +
                    "Prędkość maksymalna " + predkoscMax + ", " +
                    "w powietrzu spędził łącznie " + iloscGodzinWPowietrzu + " godzin, " +
                    "Aktualnie " + (!czyWPowietrzu ? "uziemiony." : "w powietrzu.");
        }

    }

}
