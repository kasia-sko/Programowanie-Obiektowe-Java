package pl.pw.mini.lab2.ostryDyzur.pacjenci;

public class PacjentRozczeniowy extends PacjentUbezpieczony {

    protected StopienRozczeniowosci stopienRozczeniowosci;

    public PacjentRozczeniowy(int limitWieku) {
        super(limitWieku);

        DemandingLevelGenerator demandingLevelGenerator = () -> {
            if(random.nextInt(10) == 1){
                return StopienRozczeniowosci.big;
            }
            else {
                if(random.nextBoolean()){
                    return StopienRozczeniowosci.small;
                }
                return StopienRozczeniowosci.average;
            }
        };

        this.stopienRozczeniowosci = demandingLevelGenerator.generateDemandingLevel();
    }

    @FunctionalInterface
    interface DemandingLevelGenerator{
        StopienRozczeniowosci generateDemandingLevel();
    }

    public StopienRozczeniowosci getStopienRozczeniowosci() {
        return stopienRozczeniowosci;
    }
}
