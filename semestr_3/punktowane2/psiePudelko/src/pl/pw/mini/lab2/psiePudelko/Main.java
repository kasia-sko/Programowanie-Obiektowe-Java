package pl.pw.mini.lab2.psiePudelko;

import pl.pw.mini.lab2.psiePudelko.akcesoria.InitHelper;
import pl.pw.mini.lab2.psiePudelko.box.MyExtendedDogBox;

public class Main {
    public static void main(String[] args) {
        MyExtendedDogBox myDogBox = new MyExtendedDogBox();
        System.out.println("Przed zmianą:");
        myDogBox.getGadzety().forEach(akcesorium -> System.out.println(akcesorium));


        myDogBox.detectCaloricFood();
        myDogBox.detectNonAttestationChew();
        myDogBox.getSummarizedDryFoodCalories();

        MyExtendedDogBox myExtendedDogBox = new MyExtendedDogBox();
        myExtendedDogBox.getAverageWetFoodCalories();
        myExtendedDogBox.upgradeFrequency4All();
        myExtendedDogBox.upgradeProducerName(InitHelper.Nazwa.CERBER);
        System.out.println("Po zmianie:");
        myExtendedDogBox.getGadzety().forEach(akcesorium -> System.out.println(akcesorium));

        MyFunnyTools myFunnyTools = new MyFunnyTools();
        System.out.println(myFunnyTools.createMyConcatenation().myConcatenation("Kasia", "Miłosz"));
    }
}
