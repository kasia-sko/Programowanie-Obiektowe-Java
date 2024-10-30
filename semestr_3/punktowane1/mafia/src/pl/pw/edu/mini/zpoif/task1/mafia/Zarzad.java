package pl.pw.edu.mini.zpoif.task1.mafia;

import pl.pw.edu.mini.zpoif.task1.mafia.worker.MafiaWorker;

public class Zarzad extends MafiaOrganization{

    protected boolean czyPosiadaOjcaChrzestnego;

    public Zarzad() {
        this.czyPosiadaOjcaChrzestnego = random.nextBoolean();
    }

    @Override
    public void work() {
        MafiaWorker.Blessable ojciecChrzestny = new MafiaWorker.Blessable(){
            public void bless(){
                System.out.println("Popieram");
            }
        };

        if(random.nextInt(10) < 4){
            ojciecChrzestny.bless();
        }
    }
}
