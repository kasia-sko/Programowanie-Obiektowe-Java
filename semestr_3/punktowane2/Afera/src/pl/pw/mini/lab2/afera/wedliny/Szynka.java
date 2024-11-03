package pl.pw.mini.lab2.afera.wedliny;

public abstract class Szynka extends ZapakowanaWedlina {

    protected boolean bakteriaListeria;

    public Szynka() {
        super();
        if (random.nextInt(10) == 1) {
            this.bakteriaListeria = true;
        }
        else {
            this.bakteriaListeria = false;
        }
    }

    public boolean isBakteriaListeria() {
        return bakteriaListeria;
    }

    public void setBakteriaListeria(boolean bakteriaListeria) {
        this.bakteriaListeria = bakteriaListeria;
    }

    public void makeMeReadyForConsumption(HamMakeUp makeUp) {
        makeUp.makeUp(this);
    }
}
