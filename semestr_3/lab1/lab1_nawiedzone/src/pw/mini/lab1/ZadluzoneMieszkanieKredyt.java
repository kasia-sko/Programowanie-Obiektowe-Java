package pw.mini.lab1;

public class ZadluzoneMieszkanieKredyt extends ZadluzoneMieszkanie{

    public ZadluzoneMieszkanieKredyt() {
        this.kwotaZaleglosci = random.nextInt(1,10001);
    }

    @Override
    public void nawiedz(Gosc gosc) {
        nawiedzLazienke(gosc);
        nawiedzPralnie(gosc);
    }

    private void nawiedzLazienke(Gosc gosc){
        DuchKomornika duchKomornika1 = new DuchKomornika();
        DuchKomornika duchKomornika2 = new DuchKomornika();
        System.out.println("Komornik straszy");
        duchKomornika1.nastraszKogos(gosc);
        System.out.println("Komornik straszy");
        duchKomornika2.nastraszKogos(gosc);

    }

    private void nawiedzPralnie(Gosc gosc){
        DuchKomornika duchKomornika = new DuchKomornika();
        System.out.println("Komornik straszy");
        duchKomornika.nastraszKogos(gosc);

    }
}
