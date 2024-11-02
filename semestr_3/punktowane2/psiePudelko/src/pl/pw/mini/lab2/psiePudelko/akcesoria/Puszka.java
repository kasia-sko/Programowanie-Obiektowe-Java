package pl.pw.mini.lab2.psiePudelko.akcesoria;

public class Puszka extends Jedzenie {

    public Puszka(){
        super();
        setKalorycznosc(initHelper.provideRandomCaloriesGenerator().generateKalorycznosc(100,150));
    }


    @Override
    public String toString() {
        return "Puszka, nazwa producenta= " + getNazwaProducenta() + "{" +
                "kalorycznosc=" + getKalorycznosc() +
                '}';
    }

}
