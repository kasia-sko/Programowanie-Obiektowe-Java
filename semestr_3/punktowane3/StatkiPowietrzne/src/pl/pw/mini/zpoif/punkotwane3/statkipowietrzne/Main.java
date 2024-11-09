package pl.pw.mini.zpoif.punkotwane3.statkipowietrzne;

import pl.pw.mini.zpoif.punkotwane3.statkipowietrzne.Generator.GeneratorStatkowPowietrznych;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne = GeneratorStatkowPowietrznych.generujNapedzaneStatkiPowietrzne();
        List<StatekPowietrzny> wszystkieStatkiPowietrzne = GeneratorStatkowPowietrznych.generujWszystkieStatkiPowietrzne();

        GeneratorRozwiazan generatorRozwiazan = new GeneratorRozwiazan(wszystkieStatkiPowietrzne, napedzaneStatkiPowietrzne);

        // 1) Zwraca napędzany statek powietrzny o największej prędkości wznoszenia
        Optional<NapedzanyStatekPowietrzny> najszybciejWznoszacy = generatorRozwiazan.getNajszybciejWznoszacySieStatek();
        System.out.println("Najszybciej wznoszący się statek: " + najszybciejWznoszacy);

        // 2) Zwraca samolot o największej powierzchni nośnej
        Optional<StatekPowietrzny> samolotONajwPowierzchniNosnej = generatorRozwiazan.getSamolotONajwPowierzchniNosnej();
        System.out.println("Samolot o największej powierzchni nośnej: " + samolotONajwPowierzchniNosnej);

        // 3) Zwraca śmigłowiec o najmniejszej masie (typ nie zaczynający się na "Mi")
        Optional<Smiglowiec> smiglowiecONajmniejszejMasie = generatorRozwiazan.getSmiglowiecONajmniejszejMasie();
        System.out.println("Śmigłowiec o najmniejszej masie: " + smiglowiecONajmniejszejMasie);

        // 4) Zwraca zbiór samolotów i śmigłowców po pominięciu 4 pierwszych
        Set<StatekPowietrzny> samolotyLubSmiglowceBezPierwszych4 = generatorRozwiazan.getSamolotyLubSmiglowceBezPierwszych4();
        System.out.println("Samoloty lub śmigłowce bez pierwszych 4: " + samolotyLubSmiglowceBezPierwszych4);

        // 5) Zwraca co najwyżej 4 śmigłowce o największym zasięgu
        List<NapedzanyStatekPowietrzny> smiglowceONajwiekszymZasiegu = generatorRozwiazan.get4SmiglowceOnajwiekszymZasiegu();
        System.out.println("Śmigłowce o największym zasięgu: " + smiglowceONajwiekszymZasiegu);

        // 6) Zwraca spadochron siedzeniowy o najwyższej wysokości minimalnej
        Optional<Spadochron> spadochron = generatorRozwiazan.getSiedzeniowySpadochron();
        System.out.println("Siedzeniowy spadochron o najwyższej wysokości minimalnej: " + spadochron);

        // 7) Zwraca mapę szybowców z doskonałością jako klucz
        Map<Integer, Szybowiec> mapaSzybowcow = generatorRozwiazan.getMapaSzybowcowPerDoskonalosc();
        System.out.println("Mapa szybowców per doskonałość: " + mapaSzybowcow);

        // 8) Zwraca sumę prędkości wznoszenia samolotów (maksymalnie 5, masa <= 15000)
        double sumaPredkosci = generatorRozwiazan.getSumePredkosciWznoszeniaSamolotow();
        System.out.println("Suma prędkości wznoszenia samolotów: " + sumaPredkosci);

        // 9) Zwraca mapę samolotów lub śmigłowców (najlżejsze)
        Map<String, StatekPowietrzny> posortowaneSmiglowceLubSamoloty = generatorRozwiazan.getPosortowaneSmiglowceLubSamoloty();
        System.out.println("Posortowane samoloty i śmigłowce: " + posortowaneSmiglowceLubSamoloty);

        // 10) Zwraca listę stringów z nazwami spadochronów ratowniczych
        List<String> spadochronyNazwy = generatorRozwiazan.zwrocNazwy();
        System.out.println("Spadochrony ratownicze: " + spadochronyNazwy);

        // 11) Modyfikuje nazwy samolotów, otaczając je nawiasami kwadratowymi, jeśli masa > 5 ton
        generatorRozwiazan.modyfikujNazwy();
        System.out.println("Po modyfikacji nazw samolotów: ");
        napedzaneStatkiPowietrzne.forEach(statek -> System.out.println(statek.getTyp()));
    }
}
