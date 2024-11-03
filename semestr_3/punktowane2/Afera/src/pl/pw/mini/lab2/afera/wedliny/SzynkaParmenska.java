package pl.pw.mini.lab2.afera.wedliny;

public class SzynkaParmenska extends Szynka {

    public enum Certyfikat{tak,nie,niewiadomo}
    protected Certyfikat certyfikat;

    public SzynkaParmenska(){
        super();
        this.certyfikat = Certyfikat.values()[random.nextInt(3)];
    }

    public Certyfikat getCertyfikat() {
        return certyfikat;
    }
}
