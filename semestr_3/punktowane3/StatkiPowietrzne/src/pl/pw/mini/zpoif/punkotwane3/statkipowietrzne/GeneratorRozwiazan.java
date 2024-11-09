package pl.pw.mini.zpoif.punkotwane3.statkipowietrzne;

import java.util.*;
import java.util.stream.Collectors;

public class GeneratorRozwiazan {

    private List<StatekPowietrzny>  wszystkieStatkiPowietrzne;
    private List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne;

    public GeneratorRozwiazan(List<StatekPowietrzny> wszystkieStatkiPowietrzne, List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne){
        this.wszystkieStatkiPowietrzne = wszystkieStatkiPowietrzne;
        this.napedzaneStatkiPowietrzne = napedzaneStatkiPowietrzne;
    }

    // zwraca napędzany statek powietrzny o największej prędkości wznoszenia.
    public Optional<NapedzanyStatekPowietrzny> getNajszybciejWznoszacySieStatek(){
        return napedzaneStatkiPowietrzne.stream().max((s1, s2) -> Double.compare(s1.getPredkoscWznoszenia(), s2.getPredkoscWznoszenia()));
    }

    //zwraca samolot o największej powierzchni nosnej, gdzie poszukiwanie zaczyna się dopiero
    //od 6-tego statku powietrznego, z kolekcji napędzanych statków powietrznych.
    public Optional<StatekPowietrzny> getSamolotONajwPowierzchniNosnej(){
        if (wszystkieStatkiPowietrzne.size() < 6) {
            return Optional.empty();
        }

        return wszystkieStatkiPowietrzne.stream()
                .skip(5)
                .filter(statek -> statek instanceof Samolot)
                .max((statek1, statek2) -> {
                    double powierzchniaNosna1 = ((Samolot) statek1).getPowierzchniaNosna();
                    double powierzchniaNosna2 = ((Samolot) statek2).getPowierzchniaNosna();
                    return Double.compare(powierzchniaNosna1, powierzchniaNosna2);
                });
    }

    // zwraca śmigłowiec o najmniejszej masie, którego typ nie zaczyna się na "Mi".
    //Poszukiwania należy zacząć dopiero od 4-go śmigłowca na liście bazowej. Korzystamy z
    //kolekcji napędzanych statków powietrznych.
    public Optional<Smiglowiec> getSmiglowiecONajmniejszejMasie(){
        if(wszystkieStatkiPowietrzne.size() < 4){
            return Optional.empty();
        }
        return wszystkieStatkiPowietrzne.stream().
                skip(4)
                .filter(statek -> statek instanceof Smiglowiec)
                .map(statek -> (Smiglowiec) statek)
                .filter(statek -> statek.getTyp().startsWith("Mi"))
                .min((s1, s2)  -> Integer.compare(s1.getMasa(), s2.getMasa()));
    }

    // Metoda: Set<StatekPowietrzny> getSamolotyLubSmiglowceBezPierwszych4
    //Zwraca nie większy niż 3 zbiór jakichkolwiek samolotów lub śmigłowców o prędkości
    //wznoszenia nie większej niż 15 metrów/s i o masie mniejszej niż 1300 kg, po pominieciu
    //pierwszych czterech statków spełniających podane wyżej parametry.
    public Set<StatekPowietrzny> getSamolotyLubSmiglowceBezPierwszych4(){

        return wszystkieStatkiPowietrzne.stream()
                .skip(4)
                .filter(statek -> statek instanceof Samolot || statek instanceof  Smiglowiec)
                .filter(statek -> ((NapedzanyStatekPowietrzny) statek).getPredkoscWznoszenia() <= 15)
                .filter(statek -> statek.getMasa() < 1300)
                .limit(3)
                .collect(Collectors.toSet());
    }

    // zwraca co najwyżej 4 śmigłowce o średnicy wirnika nie mniejszej niż 15 metrów, które
    //mają największy zasięg (z kolekcji napędzanych statków powietrznych). W poszukiwaniach
    //nie uwzględniamy 3 ostatnich śmigłowców na bazowej liście napędzanych statków
    //powietrznych.
    public List<NapedzanyStatekPowietrzny> get4SmiglowceOnajwiekszymZasiegu(){
        return napedzaneStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof Smiglowiec)
                .filter(statek -> ((Smiglowiec)statek).getSrednicaWirnika() >= 15)
                .skip((Math.max(0, napedzaneStatkiPowietrzne.size() - 3)))
                .sorted((s1, s2) -> Integer.compare(((Smiglowiec)s1).getZasieg(), ((Smiglowiec)s2).getZasieg()))
                .limit(4)
                .collect(Collectors.toList());
    }

    // Sposród siedzeniowych spadochronów ratowniczych zwrócić ten o najwyższej wysokości
    //minimalnej.
    public Optional<Spadochron> getSiedzeniowySpadochron(){
        return wszystkieStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof Spadochron)
                .map(statek -> (Spadochron)statek)
                .filter(statek -> statek instanceof SpadochronRatowniczy)
                .max((s1,s2) -> Integer.compare(((SpadochronRatowniczy)s1).getMinimalnaWysokosc(), ((SpadochronRatowniczy)s2).getMinimalnaWysokosc()));
    }

    //Zwraca mapę szybowców (począwszy od 2-giego już po wyeliminowaniu pozostałych
    //statków powietrznych z kolekcji wszystkich statków powietrznych) gdzie kluczem jest ich
    //doskonałość. W przypadku wystąpnienia dupikatów, wstawiamy ten o dluższej nazwie typu.
    public Map<Integer, Szybowiec> getMapaSzybowcowPerDoskonalosc(){
        return wszystkieStatkiPowietrzne.stream()
                .skip(1)  // Pomijamy pierwszy element
                .filter(statek -> statek instanceof Szybowiec)
                .map(statek -> (Szybowiec) statek)
                .collect(Collectors.toMap(
                        Szybowiec::getDoskonalosc,  // Klucz: doskonałość
                        szybowiec -> szybowiec,  // Wartość: szybowiec
                        (s1, s2) -> s1.getTyp().length() >= s2.getTyp().length() ? s1 : s2  // Jeśli są duplikaty, wybieramy szybowiec o dłuższej nazwie
                ));
    }

    //Zwraca sumę prędkości wznoszenia nie więcej niż 5-ciu samolotów o masie nie większej
    //niż 15000. Analiza rozpoczyna od 4-go statku powietrznego. Ostatni samolot o tej masie jest
    //pomijany.
    public double getSumePredkosciWznoszeniaSamolotow(){
        List<Samolot> samoloty = wszystkieStatkiPowietrzne.stream()
                .skip(3)
                .filter(statek -> statek instanceof Samolot)
                .map(statek -> (Samolot) statek)
                .filter(samolot -> samolot.getMasa() <= 15000)
                .limit(5)
                .collect(Collectors.toList());

        // Usuwamy ostatni samolot z listy, jeśli jest
        if (samoloty.size() > 0) {
            samoloty.remove(samoloty.size() - 1);  // Usuwamy ostatni samolot
        }

        return samoloty.stream()
                .mapToDouble(Samolot::getPredkoscWznoszenia)  // Pobieramy prędkość wznoszenia każdego samolotu
                .sum();  // Sumujemy prędkości
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
                .collect(Collectors.toMap(
                        statek -> statek.getClass().getSimpleName(),  // Klucz: typ statku powietrznego
                        statek -> statek,
                        (nowy, stary) -> nowy));
    }

    // Metoda zwraca listę stringów zawierających wszystkie dane spadochronów ratowniczych.
    //Lista ograniczona do dwóch elementów. Ostatni spadochron ratowniczy na liście bazowej
    //nie jest uwzględniany, powtórzenia usunięte.
    public List<String> zwrocNazwy(){
        return wszystkieStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof SpadochronRatowniczy)
                .map(statek -> (SpadochronRatowniczy) statek)
                .map(SpadochronRatowniczy::toString)
                .limit(wszystkieStatkiPowietrzne.size() - 1)
                .distinct()
                .limit(2)
                .collect(Collectors.toList());
    }

    //Z P=0.1 zmienia nazwę statku powietrznego poprzez otoczenie jej nawiasami
    //kwadratowymi, jeśli jego masa jest większa niż 5 ton. Robi to tylko dla 15 statków
    //powietrznych spełniających ryterium masy. Operacje są wykonywane dla samolotów z
    //wyłączeniem pięciu najszybszych.
    public void modyfikujNazwy(){
        List<Samolot> samoloty = wszystkieStatkiPowietrzne.stream()
                .filter(statek -> statek instanceof Samolot)
                .map(statek -> (Samolot) statek)
                .sorted(Comparator.comparingDouble(Samolot::getPredkoscWznoszenia))
                .skip(5)
                .filter(samolot -> samolot.getMasa() > 5000)
                .limit(15)  // Bierzemy tylko pierwsze 15 samolotów
                .collect(Collectors.toList());

        Random rand = new Random();
        for (Samolot samolot : samoloty) {
            if (rand.nextDouble() < 0.1) {
                String nowaNazwa = "[" + samolot.getTyp() + "]";
                samolot.setTyp(nowaNazwa);
            }
        }
    }


}
