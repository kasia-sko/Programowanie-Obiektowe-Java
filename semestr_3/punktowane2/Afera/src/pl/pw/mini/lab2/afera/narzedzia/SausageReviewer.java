package pl.pw.mini.lab2.afera.narzedzia;

import pl.pw.mini.lab2.afera.wedliny.Szynka;
import pl.pw.mini.lab2.afera.wedliny.Wedlina;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class SausageReviewer {

    protected SausageHolder sausageHolder;

    public SausageReviewer(SausageHolder sausageHolder){
        this.sausageHolder = sausageHolder;
    }

    public LinkedList<Wedlina> getHamUnfit4Consumption(){
        LinkedList<Wedlina> szynki = new LinkedList<>();

        Consumer<Wedlina> HamUnfit4Consumption = wedlina -> {
            if(wedlina instanceof Szynka){
                Period period = Period.between(((Szynka)wedlina).getDataPrzydatnosci(), LocalDate.now());
                if(period.getDays() >= 5 && period.getDays() <= 8){
                    szynki.add(wedlina);
                }
            }
        };

        sausageHolder.getWedliny().forEach(HamUnfit4Consumption);
        return szynki;
    }

    public void printTheWorstHams(){
        Consumer<Wedlina> TheWorstHams = wedlina -> {
            if(wedlina instanceof Szynka && !((Szynka)wedlina).isSzczelneOpakowanie() && ((Szynka)wedlina).isBakteriaListeria() && ((Szynka)wedlina).getDataPrzydatnosci().isBefore(LocalDate.now())){
                System.out.println(wedlina);
            }
        };
        sausageHolder.getWedliny().forEach(TheWorstHams);
    }

    public void printLessThanAvg(){
        Consumer<Wedlina> LessThanAvgPrinter = new Consumer<Wedlina>() {
            private int counter = 0;
            private int suma = 0;
            @Override
            public void accept(Wedlina wedlina) {
                counter++;
                if(counter < 10){
                    suma += wedlina.getIdProduktu();
                }
                else{
                    if(wedlina.getIdProduktu() < suma){
                        Wedlina.printId(wedlina);
                    }
                }
            }
        };

        sausageHolder.getWedliny().forEach(LessThanAvgPrinter);
    }

    public Szynka getListeriaNegativeAndFitSingleHam(){
        LinkedList<Wedlina> szynki = new LinkedList<>();

        Consumer<Wedlina> HamConsumer = wedlina -> {
            if(wedlina instanceof Szynka && !(((Szynka) wedlina).isBakteriaListeria()) && ((Szynka)wedlina).getDataPrzydatnosci().isBefore(LocalDate.now())){
                szynki.add(wedlina);
            }
        };

        Comparator<Wedlina> IdCompartor = (w1, w2) -> Integer.compare(w1.getIdProduktu(), w2.getIdProduktu());
        sausageHolder.getWedliny().forEach(HamConsumer);
        szynki.sort(IdCompartor);
        return (Szynka)szynki.getFirst();

    }

    public SausageHolder getSausageHolder() {
        return sausageHolder;
    }
}
