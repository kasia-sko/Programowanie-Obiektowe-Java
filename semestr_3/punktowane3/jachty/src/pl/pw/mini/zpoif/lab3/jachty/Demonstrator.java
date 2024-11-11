package pl.pw.mini.zpoif.lab3.jachty;

import pl.pw.mini.zpoif.lab3.jachty.generator.Statki;
import pl.pw.mini.zpoif.lab3.jachty.generator.StatkiImplementacja;

public class Demonstrator {
    public static void main(String[] args) {
        Statki statki = new StatkiImplementacja();

        System.out.println("Najcięższy statek: " + statki.getNajciezszyStatek());
        System.out.println("Statek o najdłuższej nazwie producenta na 'R': " + statki.getStatekONajdluzszejNazwieProducentaNaR());
        System.out.println("Jacht motorowy o największej mocy silnika: " + statki.getJachtMotorowyONajwiekszejMocySilnika());
        System.out.println("Lekki jacht kabinowy o najmniejszym ożaglowaniu: " + statki.getLekkiJachtKabinowyONajmniejszymOzaglowaniu());
        System.out.println("Lista długich i ciężkich jachtów: " + statki.getCoNajwyzej11DlugichICiezkichJachtow());
        System.out.println("Statki posortowane względem długości bez dwóch pierwszych: " + statki.getStatkiPosortowaneWzgledemDlugosciBez2());
        System.out.println("Pierwsze 8 z posortowanych jachtów według ożaglowania (bez 3 pierwszych): " + statki.getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych());

        statki.oznaczJachtyDobreNaPlycizny();

        System.out.println("12 unikalnych nazw typów: " + statki.get12UnikalnychNazwTypow());
        System.out.println("Mapa jachtów motorowych: " + statki.getMapaJachtowMotorowych());
        System.out.println("Jachty odkrytopokładowe i motorowe jedne po drugich: " + statki.getJachtyOdkrytopokladoweIMotoroweJednePoDrugich());
    }
}
