package pl.pw.mini.lab2.ostryDyzur.szpital;

import pl.pw.mini.lab2.ostryDyzur.pacjenci.Pacjent;
import pl.pw.mini.lab2.ostryDyzur.pacjenci.PacjentUbezpieczony;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Doctor {

    private static Random random = new Random();
    PatientHolder patientHolder;

    public Doctor(){
        this.patientHolder = new PatientHolder();
    }

    public void diagnoseAll(){
        ArrayList<Pacjent> pacjenci = patientHolder.getPatients();
        Pacjent.Diagnose kleszczDiagnose = p -> {
            if(p.getWiek() < 40){
                if(random.nextInt(10) < 7){
                    System.out.println("Borelioza");
                }
                else {
                    System.out.println("Pacjent zdrowy");
                }
            }
            else {
                if(random.nextInt(10) < 3){
                    System.out.println("Borelioza");
                }
                else {
                    System.out.println("Pacjent zdrowy");
                }
            }
        };

        Pacjent.Diagnose goraczkaDiagnose = p -> {
            PatientHolder.isCovidPositive(p);
        };

        Pacjent.Diagnose spiaczkaDiagnose = p -> {
            patientHolder.generalDiagnose(p);
        };

        Pacjent.Diagnose ranaDiagnose = p -> {
            if (p.getWiek() > 60){
                System.out.println("To nie wygląda dobrze");
            }
            else if (p instanceof PacjentUbezpieczony){
                System.out.println("Pacjent o nr ubezpieczenia: [" + ((PacjentUbezpieczony) p).getIdUbezpieczenia() + "] będzie żył");
            }
            else {
                System.out.println("Pacjent nie jest ubezpieczony ale też będzie żył");
            }
        };

        for (Pacjent pacjent : pacjenci){
            Set<Pacjent.Problem> problemy = pacjent.getProblemy();
            for(Pacjent.Problem problem : problemy){
                if(problem == Pacjent.Problem.pogryzieniePrzezKleszcza){
                    pacjent.applyDiagnose(kleszczDiagnose);
                }
                if(problem == Pacjent.Problem.spiaczka){
                    pacjent.applyDiagnose(spiaczkaDiagnose);
                }
                if(problem == Pacjent.Problem.goraczka){
                    pacjent.applyDiagnose(goraczkaDiagnose);
                }
                if(problem == Pacjent.Problem.ranakluta){
                    pacjent.applyDiagnose(ranaDiagnose);
                }
            }
        }


    }
}
