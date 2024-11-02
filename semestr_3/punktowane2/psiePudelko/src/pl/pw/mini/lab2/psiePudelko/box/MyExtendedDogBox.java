package pl.pw.mini.lab2.psiePudelko.box;

import pl.pw.mini.lab2.psiePudelko.akcesoria.InitHelper;
import pl.pw.mini.lab2.psiePudelko.akcesoria.PiszcacyGryzak;
import pl.pw.mini.lab2.psiePudelko.akcesoria.Puszka;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MyExtendedDogBox extends MyDogBox {

    protected static Random random = new Random();
    public MyExtendedDogBox(){
        super();
    }

    public void upgradeProducerName(InitHelper.Nazwa newName){
        gadzety.forEach(akcesorium -> {
            if(akcesorium.getNazwaProducenta().toString().length() <= 5){
                System.out.println("Zmieniam nazwę producenta z " + akcesorium.getNazwaProducenta() + " na " + newName);
                akcesorium.setNazwaProducenta(newName);
            }
        });
    }

    public void upgradeFrequency4All(){
        InitHelper.Czestotliwosc newFreq = InitHelper.Czestotliwosc.values()[random.nextInt(5)];
        gadzety.forEach(akcesorium -> {
            if(akcesorium instanceof PiszcacyGryzak){
                System.out.println("Zmieniam częstotliwość na " + newFreq + " dla " + akcesorium);
                ((PiszcacyGryzak)akcesorium).setCzestotliwoscPisku(newFreq);
            }
        });
    }

    // jak to zrobic bez atomic??
    public void getAverageWetFoodCalories(){
        AtomicInteger counterKalorii = new AtomicInteger();
        AtomicInteger counter = new AtomicInteger();
        gadzety.forEach(akcesorium -> {
            if(akcesorium instanceof Puszka){
                counter.incrementAndGet();
                counterKalorii.addAndGet(((Puszka) akcesorium).getKalorycznosc());
            }
        });
        System.out.println("Srednia kalorycznosc mokrej karmy: " + counterKalorii.get()/counter.get());
    }
}

