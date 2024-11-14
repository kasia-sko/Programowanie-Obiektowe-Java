package pl.pw.mini.zpoif.punkotwane3.statkipowietrzne.Generator;

import pl.pw.mini.zpoif.punkotwane3.statkipowietrzne.*;

import java.util.*;
import java.util.stream.Collectors;

public class GeneratorRozwiazan {
    private List<StatekPowietrzny> wszystkieStatkiPowietrzne;
    private List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne;

    public GeneratorRozwiazan(List<StatekPowietrzny> wszystkieStatkiPowietrzne, List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne){
        this.wszystkieStatkiPowietrzne = wszystkieStatkiPowietrzne;
        this.napedzaneStatkiPowietrzne = napedzaneStatkiPowietrzne;
    }

    // optional albo orElse(null)

    // zwraca napędzany statek powietrzny o największej prędkości wznoszenia.
    public NapedzanyStatekPowietrzny getNajszybciejWznoszacySieStatek(){
        return napedzaneStatkiPowietrzne.stream().
                max(Comparator.comparingDouble(NapedzanyStatekPowietrzny::getPredkoscWznoszenia))
                .orElse(null);
    }

    //zwraca samolot o największej powierzchni nosnej, gdzie poszukiwanie zaczyna się dopiero
    //od 6-tego statku powietrznego, z kolekcji napędzanych statków powietrznych.
    public StatekPowietrzny getSamolotONajwPowierzchniNosnej(){
        return napedzaneStatkiPowietrzne.stream()
                .skip(5)
                .filter(statek -> statek instanceof Samolot)
                .map(statek -> (Samolot)statek)
                .max(Comparator.comparingDouble(Samolot::getPowierzchniaNosna))
                .orElse(null);
    }

    // zwraca śmigłowiec o najmniejszej masie, którego typ nie zaczyna się na "Mi".
    //Poszukiwania należy zacząć dopiero od 4-go śmigłowca na liście bazowej. Korzystamy z
    //kolekcji napędzanych statków powietrznych.
    public Smiglowiec getSmiglowiecONajmniejszejMasie(){
        return napedzaneStatkiPowietrzne.stream().
                skip(4)
                //.filter(Smiglowiec.class::isInstance)
                .filter(statek -> statek instanceof Smiglowiec)
                .map(statek -> (Smiglowiec) statek)
                .filter(statek -> !statek.getTyp().startsWith("Mi"))
                .min(Comparator.comparingInt(StatekPowietrzny::getMasa))
                .orElse(null);
    }

    // Metoda: Set<StatekPowietrzny> getSamolotyLubSmiglowceBezPierwszych4
    //Zwraca nie większy niż 3 zbiór jakichkolwiek samolotów lub śmigłowców o prędkości
    //wznoszenia nie większej niż 15 metrów/s i o masie mniejszej niż 1300 kg, po pominieciu
    //pierwszych czterech statków spełniających podane wyżej parametry.
    public Set<StatekPowietrzny> getSamolotyLubSmiglowceBezPierwszych4(){
        return napedzaneStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof Samolot || statek instanceof  Smiglowiec)
                .filter(statek -> statek.getPredkoscWznoszenia() <= 15 && statek.getMasa() < 13000) // nie bylo nic dla 1300
                .skip(4)
                .limit(3)
                .collect(Collectors.toSet());
    }

    // zwraca co najwyżej 4 śmigłowce o średnicy wirnika nie mniejszej niż 15 metrów, które
    //mają największy zasięg (z kolekcji napędzanych statków powietrznych). W poszukiwaniach
    //nie uwzględniamy 3 ostatnich śmigłowców na bazowej liście napędzanych statków
    //powietrznych.
    public List<NapedzanyStatekPowietrzny> get4SmiglowceOnajwiekszymZasiegu(){
        int rozmiar = napedzaneStatkiPowietrzne.stream()
                .filter(Smiglowiec.class::isInstance)
                .collect(Collectors.toSet()).size();

        return napedzaneStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof Smiglowiec)
                .map(Smiglowiec.class::cast)
                .limit(rozmiar-3)
                .filter(statek -> statek.getSrednicaWirnika() >= 15)
                // domyslnie rosnaco posortowane
                .sorted(Comparator.comparingDouble(NapedzanyStatekPowietrzny::getZasieg).reversed())
                .limit(4)
                .collect(Collectors.toList());
    }

    // Sposród siedzeniowych spadochronów ratowniczych zwrócić ten o najwyższej wysokości
    //minimalnej.
    public Spadochron getSiedzeniowySpadochron(){
        return wszystkieStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof SpadochronRatowniczy)
                .map(SpadochronRatowniczy.class::cast)
                .filter(SpadochronRatowniczy::isSiedzeniowy)
                .max(Comparator.comparingInt(SpadochronRatowniczy::getMinimalnaWysokosc))
                .orElse(null);
    }

    //Zwraca mapę szybowców (począwszy od 2-giego już po wyeliminowaniu pozostałych
    //statków powietrznych z kolekcji wszystkich statków powietrznych) gdzie kluczem jest ich
    //doskonałość. W przypadku wystąpnienia dupikatów, wstawiamy ten o dluższej nazwie typu.
    public Map<Integer, Szybowiec> getMapaSzybowcowPerDoskonalosc(){
        return wszystkieStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof Szybowiec)
                .skip(1)
                .map(Szybowiec.class::cast)
                .collect(Collectors.toMap(
                        Szybowiec::getDoskonalosc,  // Klucz
                        szybowiec -> szybowiec,  // Wartosc
                        (existing, replacement) -> existing.getTyp().length() >= replacement.getTyp().length() ? existing : replacement  // duplikaty - wybieramy szybowiec o dłuższej nazwie
                ));
    }

    //Zwraca sumę prędkości wznoszenia nie więcej niż 5-ciu samolotów o masie nie większej
    //niż 15000. Analiza rozpoczyna od 4-go statku powietrznego. Ostatni samolot o tej masie jest
    //pomijany.
    public double getSumePredkosciWznoszeniaSamolotow(){
        List<Samolot> samoloty = napedzaneStatkiPowietrzne.stream()
                .skip(3)
                .filter(statek -> statek instanceof Samolot)
                .map(Samolot.class::cast)
                .filter(samolot -> samolot.getMasa() <= 15000)
                .collect(Collectors.toList());

        return samoloty.stream()
                .limit(samoloty.size() - 1) // pominiecie ostatniego
                .limit(5)
                .mapToDouble(Samolot::getPredkoscWznoszenia).sum();

    }


    //Zwraca mapę zawierającą samoloty lub śmigłowce, zbudowaną z 10-ciu najlżejszych
    //statków powietrznych. Analiza rozpoczyna się od 11-go statku powietrznego na liście
    //wszystkich statków powietrznych. Wmomencie tworzenia mapy i wcześniej nie powinno
    //być duplikatów. Kluczem jest typ statku powietrznego.
    public Map<String, StatekPowietrzny> getPosortowaneSmiglowceLubSamoloty(){
        return wszystkieStatkiPowietrzne.stream()
                .skip(10)
                .filter(statek -> statek instanceof Samolot || statek instanceof Smiglowiec)
                .sorted(Comparator.comparingDouble(StatekPowietrzny::getMasa))
                .distinct()
                .limit(10)
                // ?????
                .collect(Collectors.toMap(
                        statek -> statek.getClass().getSimpleName(),  // Klucz: typ statku powietrznego
                        statek -> statek,
                        (existing, replacement) -> replacement));
    }

    // Metoda zwraca listę stringów zawierających wszystkie dane spadochronów ratowniczych.
    //Lista ograniczona do dwóch elementów. Ostatni spadochron ratowniczy na liście bazowej
    //nie jest uwzględniany, powtórzenia usunięte.
    public List<String> zwrocNazwy(){
        List<SpadochronRatowniczy> spadochrony = wszystkieStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof SpadochronRatowniczy)
                .map(SpadochronRatowniczy.class::cast)
                .distinct()
                .collect(Collectors.toList());

        return spadochrony.stream()
                .limit(spadochrony.size() - 1)
                .limit(2)
                .map(Spadochron::toString)
                .toList();
    }

    //Z P=0.1 zmienia nazwę statku powietrznego poprzez otoczenie jej nawiasami
    //kwadratowymi, jeśli jego masa jest większa niż 5 ton. Robi to tylko dla 15 statków
    //powietrznych spełniających ryterium masy. Operacje są wykonywane dla samolotów z
    //wyłączeniem pięciu najszybszych.
    public void modyfikujNazwy(){
        Random random = new Random();

        napedzaneStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof Samolot)
                .map(Samolot.class::cast)
                .sorted(Comparator.comparingDouble(Samolot::getPredkoscWznoszenia).reversed())
                .skip(5)
                .filter(samolot -> samolot.getMasa() > 5000)
                .limit(15)
                .forEach(samolot -> {
                    if (random.nextInt(10) < 8) { // testowe prawdopodobienstwo
                        String nowaNazwa = "[" + samolot.getTyp() + "]";
                        samolot.setTyp(nowaNazwa);
                        System.out.println("Zmieniam nazwe");
                    }
                });

    }

}
