package pl.pw.mini.lab2.afera.wedliny;

import java.util.Random;

public abstract class Wedlina {

    protected static Random random = new Random();
    protected int idProduktu;
    protected static int counter = 0;
    protected IdGenerator idGenerator= () -> counter++;

    public Wedlina(){
        this.idProduktu = idGenerator.generateId();
    }

    public static void printId(Wedlina wedlina){
        System.out.println("Id wedliny: " + wedlina.idProduktu);
    }

    public int getCounter() {
        return counter;
    }

    public int getIdProduktu() {
        return idProduktu;
    }

    @FunctionalInterface
    interface IdGenerator{
        int generateId();
    }


    @FunctionalInterface
    public interface HamMakeUp {
        void makeUp(Szynka szynka);
    }

    @FunctionalInterface
    public interface SausageMakeUp {
        void makeUp(Kielbasa kielbasa);
    }

    @FunctionalInterface
    public interface PolendwicaMakeUp {
        void makeUp(Poledwica poledwica);
    }


}
