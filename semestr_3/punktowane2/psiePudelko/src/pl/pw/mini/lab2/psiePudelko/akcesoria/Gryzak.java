package pl.pw.mini.lab2.psiePudelko.akcesoria;

public class Gryzak extends PsieAkcesorium {
    private InitHelper.ATest atest;

    public Gryzak(){
        super();
        this.atest = initHelper.provideRandomAttestationGenerator(random.nextBoolean()).get();
    }

    public void setAtest(InitHelper.ATest atest) {
        this.atest = atest;
    }

    public InitHelper.ATest getAtest() {
        return atest;
    }

    @Override
    public String toString() {
        return "Gryzak, nazwa producenta= " + getNazwaProducenta() + "{" +
                " ,atest= " + getAtest() +
                '}';
    }
}
