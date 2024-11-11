package pl.pw.mini.zpoif.lab3.jachty.generator;

import pl.pw.mini.zpoif.lab3.jachty.model.StatekNawodny;
import pl.pw.mini.zpoif.lab3.jachty.model.jacht.*;

import java.util.*;
import java.util.stream.Collectors;

public class StatkiImplementacja implements Statki{

    private List<StatekNawodny> statkiNawodne = GeneratorStatkow.generujStatkiNawodne();

    //  Zwraca najcięższy statek.
    @Override
    public StatekNawodny getNajciezszyStatek() {
        return statkiNawodne.stream()
                .max((s1,s2) -> Integer.compare(s1.getMasa(), s2.getMasa()))
                .orElse(null); // zamiast Optional<StatekNawodny>
    }

    //  Zwraca statek o najdłuższaj nazwie producenta rozpoczynającej się na R
    @Override
    public StatekNawodny getStatekONajdluzszejNazwieProducentaNaR() {
        return statkiNawodne.stream()
                .filter(statek -> statek.getNazwaProducenta().startsWith("R"))
                .max(Comparator.comparingInt(statek -> statek.getNazwaProducenta().length()))
                .orElse(null);
    }

    // Zwraca jacht motorowy o największej mocy silnika.
    @Override
    public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
        return statkiNawodne.stream()
                .filter(statek -> statek instanceof JachtMotorowy)
                .map(statek ->(JachtMotorowy)statek)
                .max(Comparator.comparingInt(statek -> statek.getMocSilnika()))
                .orElse(null);
    }

    //  Zwraca jacht kabinowy o najmniejszej powierzchni ożaglowania spośród nie cięższych niż
    //1000.
    @Override
    public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
        return statkiNawodne.stream()
                .filter(statek -> statek instanceof JachtKabinowy)
                .map(statek -> (JachtKabinowy)statek)
                .filter(statek -> statek.getMasa() <= 1000)
                .min(Comparator.comparingDouble(statek -> statek.getPowierzchniaZagla()))
                .orElse(null);
    }

    //  Zwraca listę co najwyżej 11 pierwszych napotkanych jachtów nie lżejszych niż 1400 i o
    //długości dłuższej niż 700 centymetrów.
    @Override
    public Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow() {
        return statkiNawodne.stream()
                .filter(statek -> statek.getMasa() >= 1400 && statek.getDlugosc() > 700)
                .limit(11)
                .collect(Collectors.toSet());
    }
    //  Zwraca statki posortowane malejąco względem długości  bez uwzględnienia w sortowaniu
    //2-óch pierwszych na liście bazowej.
    @Override
    public List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2() {
        return statkiNawodne.stream()
                .skip(2)
                .sorted(Comparator.comparing(StatekNawodny::getDlugosc))
                .collect(Collectors.toList());
    }

    //  Zwraca co najwyżej pierwszych 8 (począwszy od 3-ciego) z już posortowanych malejąco
    //względem powierzchni ożaglowania jachtów kabinowych lub odkrytopokładowych
    @Override
    public List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych() {
        return statkiNawodne.stream()
                .filter(statek -> statek instanceof JachtKabinowy || statek instanceof JachtOdkrytopokladowy)
                .map(statek -> (JachtZaglowy)statek)
                .sorted(Comparator.comparing(JachtZaglowy::getPowierzchniaZagla).reversed())
                .skip(3)
                .limit(8)
                .collect(Collectors.toList());
    }

    // Dla jachtów kabinowych o zanurzeniu nie większym niż 30 i masie nie większej niż 1300
    //wstawia komentarz: "Jachtem [tutaj jego typ] wplyniesz na kazda plycizne!"
    @Override
    public void oznaczJachtyDobreNaPlycizny() {
        statkiNawodne.stream()
                .filter(statek -> statek instanceof JachtKabinowy)
                .map(statek -> (JachtKabinowy)statek)
                .filter(statek -> statek.getZanurzenie() <= 30 && statek.getMasa() <= 1300)
                .forEach(statek -> statek.setKomentarz("Jachtem " + statek.getTyp() + " wyplyniesz na kazda plycizne"));
    }

    //  Zwraca ciąg znaków powstały z połączonych ze sobą co najwyżej 12-tu unikalnych nazw
    //typów jachtów oddzielonych myślnikiem. Chodzi o jednostki cięższe niż 2000. Łączenie
    //zaczynamy od 4-go jachtu spełniającego w/w warunki
    @Override
    public String get12UnikalnychNazwTypow() {
        return statkiNawodne.stream()
                .filter(statek -> statek instanceof Jacht)
                .map(statek -> (Jacht)statek)
                .filter(statek -> statek.getMasa() > 2000)
                .map(Jacht::getTyp)
                .distinct()
                .skip(3)
                .limit(12)
                .collect(Collectors.joining("-"));
    }

    //  Zwraca mapę jachtów motorowych o wartości klucza (typ) oraz wartość referencji na ten
    //jacht. W przypadku wystąpienia duplikatu (klucza) jako pod uwagę brana jest instancja jachtu o
    //dłuższej nazwie producenta
    @Override
    public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
        return statkiNawodne.stream()
                .filter(statek -> statek instanceof JachtMotorowy)
                .map(statek -> (JachtMotorowy)statek)
                .collect(Collectors.toMap(
                        JachtMotorowy::getTyp,
                        statek -> (JachtMotorowy)statek,
                        (s1, s2) -> s1.getNazwaProducenta().length() >= s2.getNazwaProducenta().length() ? s1 : s2));
    }

    //Zwraca listę jachtów zawierającą co najwyżej 10 odkrytokładowych jachtów oraz
    //motorowych (umieszczonych zaraz za odkrytopokładowymi) wyprodukowanych przez "REGAL".
    //Oryginalnie nazwa producenta jest zapisywana przy pomocy dużych i małych liter więc zakładamy
    //że "
    // REgal" to samo co "
    // Regal" lib "
    // REGAL". "Regale" są wstawiane dopiero od 5-go znalezionego w
    //iloście nie większej niż 4
    @Override
    public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich() {
        List<Jacht> jachty = statkiNawodne.stream()
                .filter(statek -> statek instanceof JachtOdkrytopokladowy || statek instanceof JachtMotorowy)
                .map(statek -> (Jacht)statek)
                .filter(statek -> statek.getNazwaProducenta().toLowerCase().equals("regal"))
                .collect(Collectors.toList());
        List<Jacht> odkrytopokladowe = jachty.stream()
                .filter(statek -> statek instanceof JachtOdkrytopokladowy)
                .limit(10)
                .collect(Collectors.toList());

        List<Jacht> motorowe = jachty.stream()
                .filter(statek -> statek instanceof JachtMotorowy)
                .limit(10 - odkrytopokladowe.size())
                .collect(Collectors.toList());

        // Łączymy wyniki
        odkrytopokladowe.addAll(motorowe);
        return odkrytopokladowe;

    }
}
