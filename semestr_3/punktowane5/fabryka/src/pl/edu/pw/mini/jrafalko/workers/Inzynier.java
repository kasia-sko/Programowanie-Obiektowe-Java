package pl.edu.pw.mini.jrafalko.workers;

import pl.edu.pw.mini.jrafalko.Pracownik;
import pl.edu.pw.mini.jrafalko.censor.CenzuraNowyTekst;
import pl.edu.pw.mini.jrafalko.censor.CenzuraPierwsze3Znaki;

public class Inzynier extends Pracownik {

    @CenzuraPierwsze3Znaki
    private String aktualnyProjekt;
    @CenzuraNowyTekst
    private String opiniaKolegow;
    private int zarobki;


    public Inzynier(String imie, String nazwisko, int wiek,
                    String aktualnyProjekt, String opiniaKolegow, int zarobki) {
        super(imie, nazwisko, wiek);
        this.aktualnyProjekt = aktualnyProjekt;
        this.opiniaKolegow = opiniaKolegow;
        this.zarobki = zarobki;
    }

    @Override
    protected void zwiekszZysk() {
        wypracowanyZysk += 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", aktualnyProjekt='" + aktualnyProjekt + '\'' +
                ", opiniaKolegow='" + opiniaKolegow + '\'' +
                ", zarobki=" + zarobki + " zł " +
                ", inżynier";
    }
}
