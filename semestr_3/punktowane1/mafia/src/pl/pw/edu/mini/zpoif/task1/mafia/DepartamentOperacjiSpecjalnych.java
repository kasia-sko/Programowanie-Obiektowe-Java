package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;

import java.util.ArrayList;
import java.util.List;

public class DepartamentOperacjiSpecjalnych extends Departament{

    private int illegalTransactionValue;

    // nie beda czesto usuwane to arraylist
    List<MafiaWorker> brudnaLista = new ArrayList<>();

    public DepartamentOperacjiSpecjalnych() {
        this.kolorScian = KolorScian.CZERWONY;
        this.illegalTransactionValue = random.nextInt(11) + 10;
    }

    private class SprzedawcaNielegalny extends MafiaWorker{

        protected int transactionSalary;

        public void makeDeal(){
            System.out.println("Nielegalna transakcja dokonana");
            transactionSalary += illegalTransactionValue;
        }
    }
    @Override
    public void internalControl() {
        System.out.println("Kontrolna nie jest możliwa");

    }

    @Override
    public void work() {

        // czy tutaj sie daje jakies proctected private ???
        class CzlowiekOdBrudnejRoboty extends MafiaWorker{
            public void doJob(){
                System.out.println("Wykonuje mokra robote!");
            }
        }

        CzlowiekOdBrudnejRoboty c1 = new CzlowiekOdBrudnejRoboty();
        CzlowiekOdBrudnejRoboty c2 = new CzlowiekOdBrudnejRoboty();
        CzlowiekOdBrudnejRoboty c3 = new CzlowiekOdBrudnejRoboty();

        brudnaLista.add(c1);
        brudnaLista.add(c2);
        brudnaLista.add(c3);

        int losowyIndeks = random.nextInt(brudnaLista.size());
        ((CzlowiekOdBrudnejRoboty) brudnaLista.get(losowyIndeks)).doJob();

    }
}
