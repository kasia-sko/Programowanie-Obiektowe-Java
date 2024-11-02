package pl.pw.mini.lab2.psiePudelko.akcesoria;

import java.util.Random;
import java.util.function.Supplier;

public class InitHelper {

    private static Random random = new Random();

    public enum Nazwa {DINGO, FAFIK, MyPet, LAPA, CERBER, raBIES}

    public enum Czestotliwosc {
        FREQ_16(16),
        FREQ_18(18),
        FREQ_20(20),
        FREQ_22(22),
        FREQ_24(24);

        private final int value;

        Czestotliwosc(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum ATest {tak, nie}

    public Supplier<Nazwa> provideRandomProducerNameGenerator() {
        return () -> Nazwa.values()[random.nextInt(Nazwa.values().length)];
    }

    public Supplier<Czestotliwosc> provideRandomFrequencyGenerator() {
        return () -> Czestotliwosc.values()[random.nextInt(Czestotliwosc.values().length)];
    }

    public Supplier<ATest> provideRandomAttestationGenerator(boolean alwaysTrue) {
        if (alwaysTrue) {
            return () -> ATest.tak;
        }
        return () -> random.nextInt(100) < 95 ? ATest.tak : ATest.nie;
    }

    @FunctionalInterface
    interface KalorycznoscGenerator {
        int generateKalorycznosc(int x, int y);
    }

    public KalorycznoscGenerator provideRandomCaloriesGenerator() {
        return (x,y) -> random.nextInt(y - x + 1) + x;
    }

}
