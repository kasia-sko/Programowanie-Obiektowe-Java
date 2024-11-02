package pl.pw.mini.lab2.ostryDyzur.szpital;

import pl.pw.mini.lab2.ostryDyzur.pacjenci.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

public class PatientHolder {

    private static Random random = new Random();
    protected ArrayList<Pacjent> pacjenci; // nie bedziemy czesto usuwac
    private int diagnozyCounter;

    public PatientHolder(){

        this.pacjenci = new ArrayList<>();

        for(int i=0; i<10; i++){
            pacjenci.add(new PacjentRozczeniowy(100));
            pacjenci.add(new PacjentNiepelnoletni(18));
            pacjenci.add(new PacjentNieubezpieczony(60));
            pacjenci.add(new PacjentWspolpracujacy(55));
        }

        Collections.shuffle(pacjenci);
    }

    public ArrayList<Pacjent> getPatients(){
        return pacjenci;
    }

    public static void isCovidPositive(Pacjent pacjent){
        if(random.nextInt(10) == 1){
            System.out.println("Tak");
        }
        else{
            System.out.println("Nie");
        }
    }

    public void generalDiagnose(Pacjent pacjent){
        diagnozyCounter++;
        if(diagnozyCounter > 10){
            System.out.println("Brak limitu punktów");
        }
        else{
            if(random.nextBoolean()){
                System.out.println("Chory");
            }
            else{
                System.out.println("Zdrowy");
            }
        }
    }

    public int extractDemandingPatients(){
        ArrayList<Pacjent> pacjenciRozczeniowi = new ArrayList<>();
        Consumer<Pacjent> demandingPatientExtractor = p -> {
            if(p instanceof PacjentRozczeniowy && ((PacjentRozczeniowy) p).getStopienRozczeniowosci() != Pacjent.StopienRozczeniowosci.big){
                pacjenciRozczeniowi.add(p);
            }
        };
        pacjenci.forEach(demandingPatientExtractor);
        return pacjenciRozczeniowi.size();
    }

    public void detectNotInsuredPatients(){
        Consumer<Pacjent> notInsuredPatientDetector = p -> {
            if(!(p instanceof PacjentUbezpieczony)){
                System.out.println("Brak ubezpieczonia!");
            }
        };
        pacjenci.forEach(notInsuredPatientDetector);
    }
    
    public void detectTickBiten(){
        pacjenci.forEach(new Consumer<Pacjent>() {
            int counterKleszczy;
            @Override
            public void accept(Pacjent pacjent) {
                Set<Pacjent.Problem> problemyPacjenta = pacjent.getProblemy();
                if(problemyPacjenta.contains(Pacjent.Problem.pogryzieniePrzezKleszcza)){
                    counterKleszczy++;
                }
                if(counterKleszczy % 3 == 0){
                    System.out.println("To juz kolejna trojka pacjentow pogryzionych przez kleszcze w tym tygodniu");
                }
            }
        });

    }

}
