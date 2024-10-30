package pl.pw.mini.lab2.ostryDyzur.pacjenci;

public class PacjentUbezpieczony extends Pacjent {

    protected int idUbezpieczenia;

    public PacjentUbezpieczony(int limitWieku) {
        super(limitWieku);

        InsuranceIdGenerator insuranceIdGenerator = () -> random.nextInt(10000) + 10440000;

        this.idUbezpieczenia = insuranceIdGenerator.generateInsuranceId();
    }

    @FunctionalInterface
    interface InsuranceIdGenerator{
        int generateInsuranceId();
    }

    public int getIdUbezpieczenia() {
        return idUbezpieczenia;
    }
}
