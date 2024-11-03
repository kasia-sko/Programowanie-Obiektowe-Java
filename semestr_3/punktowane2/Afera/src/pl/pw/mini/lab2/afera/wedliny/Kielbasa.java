package pl.pw.mini.lab2.afera.wedliny;

public class Kielbasa extends Wedlina {

    public enum StopienUwedzenia{maly,sredni,duzy}
    protected StopienUwedzenia stopienUwedzenia;

    public Kielbasa(){
        super();
        this.stopienUwedzenia = StopienUwedzenia.values()[random.nextInt(3)];
    }

    public StopienUwedzenia getStopienUwedzenia() {
        return stopienUwedzenia;
    }

    public void setStopienUwedzenia(StopienUwedzenia stopienUwedzenia) {
        this.stopienUwedzenia = stopienUwedzenia;
    }

    public void makeMeReadyForConsumption(SausageMakeUp makeUp) {
        makeUp.makeUp(this);
    }
}
