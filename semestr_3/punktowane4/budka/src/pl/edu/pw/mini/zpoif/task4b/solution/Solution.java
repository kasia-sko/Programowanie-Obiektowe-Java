package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

public abstract class Solution {
    /**
     * Zadanie 1: Utworzenie obiektu klasy WygodnaBudka przy użyciu jej nazwy tekstowej.
     */
    public abstract Object task1();

    /**
     * Zadanie 2: Wypisanie wartości pola bazgrol z przekazanego obiektu klasy WygodnaBudka.
     */
    public abstract void task2(Object wygodnaBudka);

    /**
     * Zadanie 3: Ustawienie wartości pola szyfrDoSejfu na wartość pola UNIWERSALNY_SZYFR_DO_SEJFU.
     */
    public abstract void task3(Object wygodnaBudka);

    /**
     * Zadanie 4: Wywołanie jednej bezparametrowej metody zwracającej Integer
     * i wypisanie jej nazwy oraz wyniku.
     */
    public abstract void task4(WygodnaBudka wygodnaBudka);

    /**
     * Zadanie 5: Wypisanie prostych nazw wszystkich nadklas w hierarchii
     * obiektu będącego typem pola o nazwie "dobreWyrko".
     */
    public abstract void task5();

    /**
     * Zadanie 6: Utworzenie instancji klasy WygodnaBudka przy użyciu konstruktora
     * z dwoma argumentami typu String.
     */
    public abstract Object task6();

    /**
     * Zadanie 7: Wywołanie metody "open" na obiekcie "sejf" z użyciem wartości
     * pola "szyfrDoSejfu".
     */
    public abstract void task7(WygodnaBudka wygodnaBudka);

    /**
     * Zadanie 8: Wypisanie nazw klas wewnętrznych o zasięgu protected
     * z nadklasy klasy WygodnaBudka.
     */
    public abstract void task8();

    /**
     * Zadanie 9: Obliczenie różnicy między sumą wartości pól Integer
     * w nadklasie WygodnaBudka i sumą pól Integer w samej klasie WygodnaBudka.
     */
    public abstract int task9(WygodnaBudka wygodnaBudka);
}
