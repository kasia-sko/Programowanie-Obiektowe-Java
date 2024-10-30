package pw.mini.lab1;

public class Main {
    public static void main(String[] args) {
        OpuszczonySzpital opuszczonySzpital = new OpuszczonySzpital();
        StaryZamek staryZamek = new StaryZamek();
        ZadluzoneMieszkanieWoda zadluzoneMieszkanieWoda= new ZadluzoneMieszkanieWoda();
        ZadluzoneMieszkanieKredyt zadluzoneMieszkanieKredyt = new ZadluzoneMieszkanieKredyt();

        Gosc[] goscie = new Gosc[10];
        for (int i = 0; i < 5; i++) {
            goscie[i] = new Turysta();
        }
        for (int i = 5; i < 10; i++) {
            goscie[i] = new Student();
        }

        for (Gosc gosc : goscie) {
            System.out.println("Nowy gość: " + gosc.getClass().getSimpleName());
            staryZamek.nawiedz(gosc);
            opuszczonySzpital.nawiedz(gosc);
            zadluzoneMieszkanieWoda.nawiedz(gosc);
            zadluzoneMieszkanieKredyt.nawiedz(gosc);
            System.out.println();
        }
    }
}
