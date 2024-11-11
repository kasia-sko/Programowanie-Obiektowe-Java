package pl.pw.mini.zpoif.lab3.jachty.generator;

import pl.pw.mini.zpoif.lab3.jachty.model.StatekNawodny;
import pl.pw.mini.zpoif.lab3.jachty.model.jacht.Jacht;
import pl.pw.mini.zpoif.lab3.jachty.model.jacht.JachtKabinowy;
import pl.pw.mini.zpoif.lab3.jachty.model.jacht.JachtMotorowy;
import pl.pw.mini.zpoif.lab3.jachty.model.jacht.JachtZaglowy;

import java.util.List;
import java.util.Set;

public interface Statki {

    // 1. Zwraca najcięższy statek.
    StatekNawodny getNajciezszyStatek();

    // 2. Zwraca statek o najdłuższej nazwie producenta rozpoczynającej się na "R".
    StatekNawodny getStatekONajdluzszejNazwieProducentaNaR();

    // 3. Zwraca jacht motorowy o największej mocy silnika.
    JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika();

    // 4. Zwraca jacht kabinowy o najmniejszej powierzchni ożaglowania spośród tych, które nie są cięższe niż 1000.
    JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu();

    // 5. Zwraca co najwyżej 11 pierwszych napotkanych jachtów nie lżejszych niż 1400 i dłuższych niż 700 cm.
    Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow();

    // 6. Zwraca statki posortowane malejąco względem długości, bez uwzględnienia w sortowaniu dwóch pierwszych na liście bazowej.
    List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2();

    // 7. Zwraca co najwyżej 8 jachtów, począwszy od trzeciego, z już posortowanych malejąco względem powierzchni ożaglowania jachtów kabinowych lub odkrytopokładowych.
    List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych();

    // 8. Oznacza jachty kabinowe o zanurzeniu nie większym niż 30 i masie nie większej niż 1300 komentarzem: "Jachtem [typ] wplyniesz na kazda plycizne!".
    void oznaczJachtyDobreNaPlycizny();

    // 9. Zwraca ciąg znaków powstały z połączonych co najwyżej 12-tu unikalnych nazw typów jachtów cięższych niż 2000, zaczynając od 4-go.
    String get12UnikalnychNazwTypow();

    // 10. Zwraca mapę jachtów motorowych, gdzie klucz to typ, a wartość to referencja na jacht o dłuższej nazwie producenta w przypadku duplikatów.
    Object getMapaJachtowMotorowych();

    // 11. Zwraca listę maksymalnie 10 jachtów odkrytopokładowych oraz motorowych, wyprodukowanych przez "REGAL" (bez względu na wielkość liter).
    List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich();
}
