package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class SolutionImpl extends Solution{

    // W metodzie task1 utworzyć obiekt klasy
    //"pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka" używając jej nazwy tekstowej i
    //go zwrócić.
    @Override
    protected WygodnaBudka task1() throws Exception {

        return (WygodnaBudka) Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka")
                .getConstructor().newInstance();
    }

    // W metodzie task2 używając przekazanego obiektu klasy WygodnaBudka wypisać na
    //konsolę wartość pola bazgrol.
    @Override
    protected void task2(WygodnaBudka wygodnaBudka) throws Exception {
        Field bazgrol = WygodnaBudka.class.getDeclaredField("bazgrol");
        bazgrol.setAccessible(true);
        System.out.println("Bazgrol: " + bazgrol.get(wygodnaBudka));

    }

    // W metodzie task3 na rzecz przekazanego obiektu klasy WygodnaBudka ustawić wartość
    //pola szyfrDoSejfu wartością pola UNIWERSALNY_SZYFR_DO_SEJFU.
    @Override
    protected void task3(WygodnaBudka wygodnaBudka) throws Exception {
        Class<?> wygodnaBudkaClass = WygodnaBudka.class;
        Field uniwersalnySzyfrDoSejfu = wygodnaBudkaClass.getSuperclass().getDeclaredField("UNIWERSALNY_SZYFR_DO_SEJFU");
        uniwersalnySzyfrDoSejfu.setAccessible(true);
        Field szyfrDoSejfu = wygodnaBudkaClass.getDeclaredField("szyfrDoSejfu");
        szyfrDoSejfu.setAccessible(true);
        System.out.println("Stary szyfr: " + szyfrDoSejfu.get(wygodnaBudka));
        szyfrDoSejfu.set(wygodnaBudka, uniwersalnySzyfrDoSejfu.get(wygodnaBudka));
        System.out.println("Nowy szyfr: " + szyfrDoSejfu.get(wygodnaBudka));

    }

    // W metodzie task4 na rzecz przekazanego obiektu klasy WygodnaBudka uruchomić jedną
    //(pierwszą lepszą) bezparametrową metodę zwracającą Integer oraz wypisać na konsolę jej
    //nazwę i to co zwróciła.
    @Override
    protected void task4(WygodnaBudka wygodnaBudka) throws Exception {
        Class<?> wygodnaBudkaClass = WygodnaBudka.class;
        Method[] methods = wygodnaBudkaClass.getDeclaredMethods();
        for(Method method : methods){
            if(method.getReturnType() == Integer.class && method.getParameterCount() == 0){
                method.setAccessible(true);
                int result = (int) method.invoke(wygodnaBudka);
                System.out.println("Metoda " + method.getName() + " zwraca " + result);
                break;
            }
        }

    }

    // W metodzie task5 wypisać proste nazwy (bez pakietów) wszystkich nadklas w hierarchii
    //obiektu będącego typem pola o nazwie "dobreWyrko".
    @Override
    protected void task5() throws Exception {
        Class<?> clazz = WygodnaBudka.class.getDeclaredField("dobreWyrko").getType();
        System.out.println("Wszystkie nadklasy klasy: " + clazz.getSimpleName());
        while (clazz.getSuperclass() != null){
            clazz = clazz.getSuperclass();
            System.out.println(clazz.getSimpleName());
        }
    }

    // W metodzie task6 odszukać konstruktor klasy WygodnaBudka , który przyjmuje dwa
    //argumenty typu String. Za jego pomocą utworzyć i zwrócić instancję tej klasy przekazując
    //parametry: "Super" oraz "Dobre graty".
    @Override
    protected WygodnaBudka task6() throws Exception {
        Constructor<WygodnaBudka> constructor = WygodnaBudka.class.getDeclaredConstructor(String.class, String.class);
        return constructor.newInstance("Super", "Dobre graty");
    }

    // W metodzie task7 na rzecz przekazanego w demonstratorze obiektu klasy WygodnaBudka
    //(dokładnie tej samej instancji która była przekazana do zadania 3) wywołać metodę "open"
    //na obiekcie "sejf" i przekazać do niej wartość pola: "szyfrDoSejfu".
    @Override
    protected void task7(WygodnaBudka wygodnaBudka) throws Exception {
        Class<?> wygodnaBudkaClass = wygodnaBudka.getClass();

        Field szyfrDoSejfu = wygodnaBudkaClass.getDeclaredField("szyfrDoSejfu");
        szyfrDoSejfu.setAccessible(true);

        Field sejf = wygodnaBudkaClass.getDeclaredField("sejf");
        sejf.setAccessible(true);

        Class<?> sejfClass = sejf.getType();
        Method openMethod = sejfClass.getDeclaredMethod("open", String.class);
        openMethod.setAccessible(true);
        openMethod.invoke(sejf.get(wygodnaBudka), szyfrDoSejfu.get(wygodnaBudka));
    }

    // W metodzie task8 z nadklasy klasy "WygodnaBudka" wypisać nazwy klas wewnętrznych o
    //zasięgu protected
    @Override
    protected void task8() throws Exception {
        Class<?>[] classes = WygodnaBudka.class.getSuperclass().getDeclaredClasses();
        Arrays.stream(classes).filter(c -> Modifier.isProtected(c.getModifiers()))
                .forEach(c -> System.out.println(c.getSimpleName()));

    }

    // W metodzie task9 bazując na przekazanym do metody obiekcie, należy od sumy wartości
    //wszystkich pól (Integer) zadeklarowanych tylko w nadklasie klasy WygodnaBudka odjąć
    //sumę pól zadeklarowanych tylko w klasie WygodnaBudka.
    @Override
    protected int task9(WygodnaBudka wygodnaBudka) throws Exception {
        int nadklasaSum = Arrays.stream(WygodnaBudka.class.getSuperclass().getDeclaredFields())
                .filter(field -> field.getType() == Integer.class)
                .mapToInt(field -> {
                    field.setAccessible(true);
                    try {
                        return (int) field.get(wygodnaBudka);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return 0;
                })
                .sum();

        int wygodnaBudkaSum = Arrays.stream(WygodnaBudka.class.getDeclaredFields())
                .filter(field -> field.getType() == Integer.class && field.getDeclaringClass() == WygodnaBudka.class)
                .mapToInt(field -> {
                    field.setAccessible(true);
                    try {
                        return (int) field.get(wygodnaBudka);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return 0;
                })
                .sum();
        return nadklasaSum - wygodnaBudkaSum;
    }


}
