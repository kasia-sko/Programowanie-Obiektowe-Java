package pw.mini.lab1;

public class ZadluzoneMieszkanieWoda extends ZadluzoneMieszkanie{

    public ZadluzoneMieszkanieWoda() {
        this.kwotaZaleglosci = random.nextInt(1,1001);
    }

    @Override
    public void nawiedz(Gosc gosc) {
        if(random.nextBoolean()){
            nawiedzLazienke(gosc);
        }
        else{
            nawiedzPralnie(gosc);
        }
    }

    private void nawiedzLazienke(Gosc gosc){
        DuchPlywaka duchPlywaka1 = new DuchPlywaka();
        DuchPlywaka duchPlywaka2 = new DuchPlywaka();
        System.out.println("Plywak straszy");
        duchPlywaka1.nastraszKogos(gosc);
        System.out.println("Plywak straszy");
        duchPlywaka2.nastraszKogos(gosc);

    }

    private void nawiedzPralnie(Gosc gosc){
        DuchKomornika duchKomornika = new DuchKomornika();
        System.out.println("Komornik straszy");
        duchKomornika.nastraszKogos(gosc);

    }

    private class DuchPlywaka implements Straszacy{

        @Override
        public void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(random.nextInt(10,31));
        }
    }
}
