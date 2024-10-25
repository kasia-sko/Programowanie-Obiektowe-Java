package pw.mini.lab1;

import java.util.Random;

public abstract class ZadluzoneMieszkanie extends NawiedzoneMiejsce{

    protected static Random random = new Random();
    protected int kwotaZaleglosci;

    public class DuchKomornika implements Straszacy{

        @Override
        public void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(Math.round(kwotaZaleglosci/500));
        }
    }
}
