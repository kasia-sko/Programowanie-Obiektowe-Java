package pl.pw.edu.mini.zpoif.task1.mafia;

public class DepartamentHandlowy extends Departament{

    protected int iloscPieniedzy;

    public DepartamentHandlowy() {
        this.iloscPieniedzy = random.nextInt(450000) + 100000;
        if(random.nextBoolean()){
            this.kolorScian = KolorScian.ZIELONY;
        }
        else{
            this.kolorScian = KolorScian.NIEBIESKI;
        }
    }

    public void work(){

        if(random.nextInt(10) < 9){
            SprzedawcaLegalny sprzedawcaLegalny = new SprzedawcaLegalny();
            sprzedawcaLegalny.makeDeal();
        }
        else{
            System.out.println("Dealu nie bedzie!");
        }
    }

    public void internalControl(){

        Kontroler kontroler = new Kontroler();
        kontroler.check();
    }
}
