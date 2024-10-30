package pw.mini.lab1;

import java.util.Random;

public abstract class Gosc {

    public enum Stan{NORMALNY,PRZERAZONY,PANIKA};
    protected static Random random = new Random();

    protected int odpornosc;
    protected Stan stan;

    public Gosc() {
        this.odpornosc = random.nextInt(30);
        this.stan = Stan.NORMALNY;
    }

    public String toString(){
        return "aktualny stan: " + stan;
    }

    public abstract void nastraszMnie(int moc);
}
