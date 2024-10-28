package pl.edu.pw.mini.zpoif.assignment2.commandos;

import pl.edu.pw.mini.zpoif.assignment2.equipment.Jedzenie;

public abstract class KomandosZBeretem extends Commandos{

    protected static class Suchary extends Jedzenie{

        private static final int liczbaKalorii = 100;

        @Override
        public void eat() {
            System.out.println("Chrup, chrup " + liczbaKalorii  );
        }
    }
}
