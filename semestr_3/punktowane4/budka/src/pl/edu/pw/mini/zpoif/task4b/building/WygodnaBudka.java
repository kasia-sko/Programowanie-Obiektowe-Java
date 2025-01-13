package pl.edu.pw.mini.zpoif.task4b.building;

public class WygodnaBudka extends Budka {
    private String bazgrol;
    private String szyfrDoSejfu;
    public Sejf sejf;
    private static Wyrko dobreWyrko;
    private Integer pole1 = 5;
    protected Integer pole2 = 2;

    static {
        dobreWyrko = new WygodnaBudka().new MegaWyrko();
    }

    public WygodnaBudka() {
        this.bazgrol = "Default Bazgrol";
        this.sejf = new Sejf();
    }

    public WygodnaBudka(String param1, String param2) {
        this.bazgrol = param1;
        this.szyfrDoSejfu = param2;
        this.sejf = new Sejf();
    }

    private Integer exampleMethod() {
        return 42;
    }

    protected class Sejf {
        public void open(String szyfr) {
            System.out.println("Sejf otwarty z szyfrem: " + szyfr);
        }
    }

    class Wyrko {
    }

    class SuperWyrko extends Wyrko {
    }

    class MegaWyrko extends SuperWyrko {
    }

    @Override
    public String toString() {
        return "WygodnaBudka{" +
                "bazgrol='" + bazgrol + '\'' +
                ", szyfrDoSejfu='" + szyfrDoSejfu + '\'' +
                ", sejf=" + sejf +
                '}';
    }
}
