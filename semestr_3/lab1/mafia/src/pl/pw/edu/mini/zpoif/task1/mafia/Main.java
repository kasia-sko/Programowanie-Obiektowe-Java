package pl.pw.edu.mini.zpoif.task1.mafia;

public class Main {

    public static void main(String[] args) {

        DepartamentHandlowy departamentHandlowy = new DepartamentHandlowy();
        DepartamentRekrutacyjny departamentRekrutacyjny = new DepartamentRekrutacyjny();
        DepartamentOperacjiSpecjalnych departamentOperacjiSpecjalnych = new DepartamentOperacjiSpecjalnych();
        Zarzad zarzad = new Zarzad();

        departamentHandlowy.work();
        departamentRekrutacyjny.work();
        departamentOperacjiSpecjalnych.work();
        zarzad.work();
    }
}
