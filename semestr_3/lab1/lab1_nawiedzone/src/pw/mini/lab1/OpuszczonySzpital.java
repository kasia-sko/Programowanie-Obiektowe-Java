package pw.mini.lab1;

public class OpuszczonySzpital extends NawiedzoneMiejsce{


    @Override
    public void nawiedz(Gosc gosc) {
        Straszacy straszydlak = new Straszacy() {
            @Override
            public void nastraszKogos(Gosc gosc) {
                if(gosc.stan == Gosc.Stan.NORMALNY){
                    System.out.println("Straszydlak straszy");
                    gosc.nastraszMnie(15);
                }
                else {
                    System.out.println("Daje ci spokoj");
                }
            }
        };

    }
}
