package pl.pw.mini.lab2.psiePudelko.akcesoria;

public class PaczkaKarmy extends Jedzenie {

    public PaczkaKarmy(){
        super();
        setKalorycznosc(initHelper.provideRandomCaloriesGenerator().generateKalorycznosc(300,400));
    }

    @Override
    public String toString() {
        return "Paczka karmy, nazwa producenta= " + getNazwaProducenta() + "{" +
                "kalorycznosc=" + getKalorycznosc() +
                '}';
    }

}
