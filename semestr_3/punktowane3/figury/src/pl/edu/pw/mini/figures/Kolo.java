package pl.edu.pw.mini.figures;

import static java.lang.Math.PI;

public class Kolo extends Figura2D {

    public Kolo(int promien) {
        super(promien);
    }

    @Override
    public double polePowierzchni() {
        return PI * wysokosc * wysokosc;
    }

    @Override
    public double obwod() {
        return 2 * PI * wysokosc;
    }

    @Override
    public String toString() {
        return "Koło, " +
                "wysokość = " + wysokosc +
                ", pole = " + polePowierzchni() +
                ", obwód = " + obwod();
    }
}
