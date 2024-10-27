package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;

import java.util.ArrayList;
import java.util.List;

public class DepartamentRekrutacyjny extends Departament{

    private final int limitDzienny = 5;
    List<MafiaWorker> rekruterzy =  new ArrayList<>();


    public DepartamentRekrutacyjny() {
        this.kolorScian = KolorScian.BIAŁY;
    }

    @Override
    public void work() {
        class Rekruter extends MafiaWorker{

            public void recruit(){
                if(random.nextBoolean()){
                    System.out.println("Zrekrutowałem!");

                }
                else {
                    System.out.println("Porażka! :(");
                }
            }

        }

        Rekruter r1 = new Rekruter();
        Rekruter r2 = new Rekruter();
        Rekruter r3 = new Rekruter();
        Rekruter r4 = new Rekruter();
        Rekruter r5 = new Rekruter();

        List<Rekruter> rekruterzy =  new ArrayList<>();
        rekruterzy.add(r1);
        rekruterzy.add(r2);
        rekruterzy.add(r3);
        rekruterzy.add(r4);
        rekruterzy.add(r5);





    }

    @Override
    public void internalControl() {
        Kontroler kontroler = new Kontroler();
        kontroler.check();
    }
}
