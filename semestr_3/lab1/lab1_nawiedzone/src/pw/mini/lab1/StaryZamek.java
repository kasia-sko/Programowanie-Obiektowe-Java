package pw.mini.lab1;

public class StaryZamek extends NawiedzoneMiejsce{

    protected static final int mocBialychDam = 20;

    @Override
    public void nawiedz(Gosc gosc) {

        BialaDama bialaDama = new BialaDama();
        System.out.println("Biala dama straszy");
        bialaDama.nastraszKogos(gosc);

        // lokalna
        class DuchWlascicielaZamku implements Straszacy {
            public void nastraszKogos(Gosc gosc) {
                gosc.nastraszMnie(0);
            }
        }

        DuchWlascicielaZamku duch1 = new DuchWlascicielaZamku();
        DuchWlascicielaZamku duch2 = new DuchWlascicielaZamku();

        System.out.println("Wlasciciel straszy");
        duch1.nastraszKogos(gosc);
        System.out.println("Wlasciciel straszy");
        duch2.nastraszKogos(gosc);


    }

    // wewnetrzna, static???
    public static class BialaDama implements Straszacy{

        public void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(mocBialychDam);
        }
    }


}
