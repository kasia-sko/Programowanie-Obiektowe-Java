package pl.pw.mini.lab2.psiePudelko;

public class MyFunnyTools {

    @FunctionalInterface
    interface MyConcatenation{
        String myConcatenation(String s1, String s2);
    }

    public MyConcatenation createMyConcatenation() {
        return String::concat;
    }
}
