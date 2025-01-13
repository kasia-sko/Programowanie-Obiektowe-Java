package pl.edu.pw.mini.jrafalko.workers;

import pl.edu.pw.mini.jrafalko.Pracownik;
import pl.edu.pw.mini.jrafalko.Produkty;
import pl.edu.pw.mini.jrafalko.censor.IntCenzura;
import pl.edu.pw.mini.jrafalko.censor.Ustaw;
import pl.edu.pw.mini.jrafalko.censor.UsunJesliWiekMniejszyNiz30;
import pl.edu.pw.mini.jrafalko.censor.WykonajMetode;

@UsunJesliWiekMniejszyNiz30
@Ustaw(typ = Ustaw.Typ.Produkty)
public class Monter extends Pracownik {

    @IntCenzura
    private int iloscWyprodukowanychElementow;
    private Produkty produkowanyElement;

    public Monter(String imie, String nazwisko, int wiek,
                  int iloscWyprodukowanychElementow, Produkty produkowanyElement) {
        super(imie, nazwisko, wiek);
        this.iloscWyprodukowanychElementow = iloscWyprodukowanychElementow;
        this.produkowanyElement = produkowanyElement;
    }

    @WykonajMetode(liczba = 10)
    @Override
    protected void zwiekszZysk() {
        wypracowanyZysk += 2;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", iloscWyprodukowanychElementow=" + iloscWyprodukowanychElementow +
                ", produkowanyElement=" + produkowanyElement +
                ", monter";
    }
}
