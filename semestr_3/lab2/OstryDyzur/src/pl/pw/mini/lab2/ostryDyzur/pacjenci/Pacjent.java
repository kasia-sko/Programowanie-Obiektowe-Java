package pl.pw.mini.lab2.ostryDyzur.pacjenci;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Pacjent {

    protected int wiek;
    protected Set<Problem> problemy;
    protected static Random random = new Random();

    public enum Problem{pogryzieniePrzezKleszcza, goraczka, spiaczka, ranakluta}

    public enum StopienRozczeniowosci{small, average, big}

    public Pacjent(int limitWieku){
        AgeGenerator ageGenerator = limit -> random.nextInt(limit);

        ProblemGenerator problemGenerator = tick -> {
            Set<Problem> problemy = new HashSet<>();
            problemy.add(Problem.values()[random.nextInt(4)]);
            if(tick){
                problemy.add(Problem.pogryzieniePrzezKleszcza);
            }
            return problemy;
        };

        this.wiek = ageGenerator.generateLimitedAge(limitWieku);
        this.problemy = problemGenerator.generateProblem(random.nextBoolean());
    }

    @FunctionalInterface
    interface AgeGenerator{
        int generateLimitedAge(int limit);
    }

    @FunctionalInterface
    interface ProblemGenerator{
        Set<Problem> generateProblem(boolean tick);
    }

    public void applyDiagnose(Diagnose diagnose){
        diagnose.diagnoseMe(this);
    }

    public interface Diagnose {
        void diagnoseMe(Pacjent pacjent);
    }

    public Set<Problem> getProblemy() {
        return problemy;
    }

    public int getWiek() {
        return wiek;
    }
}
