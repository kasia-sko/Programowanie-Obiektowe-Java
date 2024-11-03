package pl.pw.mini.lab2.afera.wedliny;

public class Poledwica extends ZapakowanaWedlina {

    public Poledwica(){
        super();
    }

    public void makeMeReadyForConsumption(PolendwicaMakeUp makeUp) {
        makeUp.makeUp(this);
    }

}
