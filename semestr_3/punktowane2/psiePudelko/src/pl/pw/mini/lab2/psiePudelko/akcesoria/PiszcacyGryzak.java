package pl.pw.mini.lab2.psiePudelko.akcesoria;

public class PiszcacyGryzak extends Gryzak {
    private InitHelper.Czestotliwosc czestotliwoscPisku;


    public PiszcacyGryzak(){
        super();
        this.czestotliwoscPisku = initHelper.provideRandomFrequencyGenerator().get();
    }

    public void setCzestotliwoscPisku(InitHelper.Czestotliwosc czestotliwoscPisku) {
        this.czestotliwoscPisku = czestotliwoscPisku;
    }

    public InitHelper.Czestotliwosc getCzestotliwoscPisku() {
        return czestotliwoscPisku;
    }

    @Override
    public String toString() {
        return "Gryzak piszcacy, nazwa producenta= " + getNazwaProducenta() + "{" +
                "czestotliwosc=" + getCzestotliwoscPisku() +
                " ,atest= " + getAtest() +
                '}';
    }

}
