package pl.pw.mini.lab2.afera.narzedzia;

import pl.pw.mini.lab2.afera.wedliny.Kielbasa;
import pl.pw.mini.lab2.afera.wedliny.Poledwica;
import pl.pw.mini.lab2.afera.wedliny.Szynka;
import pl.pw.mini.lab2.afera.wedliny.Wedlina;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Consumer;

public class SausageFreshmaker {

    private static Random random = new Random();
    private SausageReviewer sausageReviewer;

    public SausageFreshmaker(SausageReviewer sausageReviewer){
        this.sausageReviewer = sausageReviewer;
    }

    public void upgradeHams(){
        Consumer<Wedlina> HamUpgrader = wedlina -> {
            ((Szynka)wedlina).makeMeReadyForConsumption(ham -> ham.setDataPrzydatnosci(LocalDate.now().plusDays(random.nextInt())));
            ((Szynka)wedlina).setBakteriaListeria(false);
        };
        sausageReviewer.getHamUnfit4Consumption().forEach(HamUpgrader);
    }

    public void upgradeDates(){
        Consumer<Wedlina> DateUpgrader = wedlina -> {
            if (wedlina instanceof Szynka) {
                ((Szynka) wedlina).makeMeReadyForConsumption(ham -> ham.setDataPrzydatnosci(LocalDate.now().plusDays(random.nextInt())));
            }
             else if (wedlina instanceof Poledwica) {
                ((Poledwica) wedlina).makeMeReadyForConsumption(poledwica -> poledwica.setDataPrzydatnosci(LocalDate.now().plusDays(random.nextInt())));
            }
        };
        sausageReviewer.getSausageHolder().getWedliny().forEach(DateUpgrader);
    }

    public void upgradeSausages(){
        Consumer<Wedlina> SausageUpgrader = wedlina -> {
            if(wedlina instanceof Kielbasa && ((Kielbasa)wedlina).getStopienUwedzenia()== Kielbasa.StopienUwedzenia.maly){
                ((Kielbasa)wedlina).makeMeReadyForConsumption(kielbasa -> kielbasa.setStopienUwedzenia(Kielbasa.StopienUwedzenia.duzy));
            }
        };
        sausageReviewer.getSausageHolder().getWedliny().forEach(SausageUpgrader);
    }


}
