package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;

public abstract class Departament extends MafiaOrganization{

    protected enum KolorScian {CZERWONY, ZIELONY, NIEBIESKI, BIAŁY};

    protected KolorScian kolorScian;

    public abstract void internalControl();

    protected static class SprzedawcaLegalny extends MafiaWorker{
        protected int transactionSummary;

        public void makeDeal(){
            System.out.println("Legalna transakcja dokonana");
            transactionSummary += 2 * VALUE_OF_SINGLE_LEGAL_TRANSACTION;
        }
    }

    protected class Kontroler extends MafiaWorker{
        // nie wiem czy to powinno byc statyczne skoro chce miec dostep do niestatycznego koloru scian?
        public void check(){
            // equals czy ==
            if(kolorScian == KolorScian.ZIELONY){
                System.out.println("Nie trzeba kontrolowac!");
            }
            else{
                System.out.println("Kontroluje");
            }
        }
    }
}
