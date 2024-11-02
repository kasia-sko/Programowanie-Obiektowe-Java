package pl.pw.mini.lab2.psiePudelko.akcesoria;

import java.util.Random;

public abstract class PsieAkcesorium {

    private InitHelper.Nazwa nazwaProducenta;
    protected InitHelper initHelper = new InitHelper();
    protected static Random random = new Random();

    public PsieAkcesorium() {
        this.nazwaProducenta = initHelper.provideRandomProducerNameGenerator().get();
    }



    public void setNazwaProducenta(InitHelper.Nazwa nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }

    public InitHelper.Nazwa getNazwaProducenta() {
        return nazwaProducenta;
    }
}
