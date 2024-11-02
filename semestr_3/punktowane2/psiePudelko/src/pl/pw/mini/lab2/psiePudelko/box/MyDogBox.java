package pl.pw.mini.lab2.psiePudelko.box;

import pl.pw.mini.lab2.psiePudelko.akcesoria.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class MyDogBox {

    protected ArrayList<PsieAkcesorium> gadzety;

    public MyDogBox() {
        this.gadzety = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            gadzety.add(new Gryzak());
            gadzety.add(new PiszcacyGryzak());
        }
        for (int i = 0; i < 40; i++) {
            gadzety.add(new Puszka());
        }
        for (int i = 0; i < 50; i++) {
            gadzety.add(new PaczkaKarmy());
        }
        Collections.shuffle(gadzety);


    }

    public ArrayList<PsieAkcesorium> getGadzety(){
        return gadzety;
    }

    public void detectNonAttestationChew() {
        Consumer<PsieAkcesorium> checkAtest = akcesorium -> {
            if (akcesorium instanceof Gryzak && ((Gryzak) akcesorium).getAtest() == InitHelper.ATest.nie) {
                System.out.println("Brak atestu!!!");
            }
        };
        gadzety.forEach(checkAtest);
    }

    public void detectCaloricFood() {
        final int maxWarnings = 31;
        Consumer<PsieAkcesorium> checkCalories = new Consumer<>() {
            int warnings = 0;

            @Override
            public void accept(PsieAkcesorium akcesorium) {
                if (akcesorium instanceof Jedzenie && ((Jedzenie) akcesorium).getKalorycznosc() > 350) {
                    if (warnings < maxWarnings) {
                        System.out.println("Uwaga na kalorie");
                        warnings++;
                    }
                }

            }
        };
        gadzety.forEach(checkCalories);
    }

    public void getSummarizedDryFoodCalories() {
        class TotalCaloriesConsumer implements Consumer<PsieAkcesorium> {
            private int totalCalories = 0;

            @Override
            public void accept(PsieAkcesorium akcesorium) {
                if (akcesorium instanceof PaczkaKarmy paczkaKarmy) {
                    totalCalories += paczkaKarmy.getKalorycznosc();
                }
            }

            public int getTotalCalories() {
                return totalCalories;
            }
        }

        TotalCaloriesConsumer sumCalories = new TotalCaloriesConsumer();
        gadzety.forEach(sumCalories);
        System.out.println("Suma kalorii suchej karmy: " + sumCalories.getTotalCalories());

    }
}
