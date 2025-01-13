package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

import java.lang.reflect.*;
import java.util.Arrays;

public class MySolution extends Solution{

    @Override
    public Object task1(){
        try {
            Class<?> classWygodnaBudka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
            Object wygodnaBudka = classWygodnaBudka.getDeclaredConstructor().newInstance();
            return wygodnaBudka;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void task2(Object wygodnaBudka) {
        Class<?> clazz = wygodnaBudka.getClass();
        Field bazgrol = null;
        try {
            bazgrol = clazz.getDeclaredField("bazgrol");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        bazgrol.setAccessible(true);
        try {
            System.out.println(bazgrol.get(wygodnaBudka));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void task3(Object wygodnaBudka) {
        Class<?> classWygodnaBudka = wygodnaBudka.getClass();
        Class<?> classBudka = classWygodnaBudka.getSuperclass();
        try {
            Field szyfrDoSejfu = classWygodnaBudka.getDeclaredField("szyfrDoSejfu");
            szyfrDoSejfu.setAccessible(true);
            Field uniwersalnySzyfrDoSejfu = classBudka.getDeclaredField("UNIWERSALNY_SZYFR_DO_SEJFU");
            String szyfr = (String) uniwersalnySzyfrDoSejfu.get(wygodnaBudka);
            uniwersalnySzyfrDoSejfu.setAccessible(true);
            szyfrDoSejfu.set(wygodnaBudka, szyfr);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void task4(WygodnaBudka wygodnaBudka) {
        Class<?> classWygodnaBudka = wygodnaBudka.getClass();
        Method[] methods = classWygodnaBudka.getDeclaredMethods();
        for(Method method : methods){
            if(method.getReturnType() == Integer.class && method.getParameterCount() == 0){
                method.setAccessible(true);
                Integer result = null;
                try {
                    result = (Integer) method.invoke(wygodnaBudka);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Metoda: " + method.getName() + " zwrocila: " + result);
                break;
            }
        }

    }

    @Override
    public void task5() {
        Class<?> classWygodnaBudka = null;
        try {
            classWygodnaBudka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Field fieldDobreWyrko = null;
        try {
            fieldDobreWyrko = classWygodnaBudka.getDeclaredField("dobreWyrko");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        fieldDobreWyrko.setAccessible(true);
        Class<?> dobreWyrkoClass = fieldDobreWyrko.getClass();
        System.out.println("Hierarchia klas dla " + fieldDobreWyrko.getName());
        while(dobreWyrkoClass != null){
            System.out.println(dobreWyrkoClass.getSimpleName());
            dobreWyrkoClass = dobreWyrkoClass.getSuperclass();
        }
    }

    @Override
    public Object task6() {
        try {
            Class<?> classWygodnaBudka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
            Constructor<?> constructor = classWygodnaBudka.getConstructor(String.class, String.class);
            constructor.setAccessible(true);
            Object wygodnaBudka = constructor.newInstance("Super", "Dobre graty");
            return wygodnaBudka;
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void task7(WygodnaBudka wygodnaBudka) {
        try {
            Class<?> classWygodnaBudka = wygodnaBudka.getClass();

            Field sejfField = classWygodnaBudka.getDeclaredField("sejf");
            sejfField.setAccessible(true);
            Object sejf = sejfField.get(wygodnaBudka);
            Class<?> classSejf = sejf.getClass();
            Method openMethod = classSejf.getMethod("open", String.class);

            Field szyfrDoSejfuField = classWygodnaBudka.getDeclaredField("szyfrDoSejfu");
            szyfrDoSejfuField.setAccessible(true);
            String szyfr = (String) szyfrDoSejfuField.get(wygodnaBudka);

            openMethod.invoke(sejf, szyfr);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void task8() {
        try {
            Class<?> classWygodnaBudka = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
            Class<?> nadklasa = classWygodnaBudka.getSuperclass();
            Class<?>[] klasyWewnetrzne = nadklasa.getDeclaredClasses();
            for(Class<?> clazz : klasyWewnetrzne){
                int zasieg = clazz.getModifiers();
                if(Modifier.isProtected(zasieg)){
                    System.out.println(clazz.getSimpleName());
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int task9(WygodnaBudka wygodnaBudka) {
        Class<?> classWygodnaBudka = wygodnaBudka.getClass();
        Class<?> nadklasa = classWygodnaBudka.getSuperclass();

        // co z tym TYLKO w danej klasie
        Field[] nadklasaFields = Arrays.stream(nadklasa.getDeclaredFields())
                .filter(field -> field.getType() == Integer.class). toArray(Field[]::new);
        Field[] wygodnaBudkaFields = Arrays.stream(classWygodnaBudka.getDeclaredFields())
                .filter(field -> field.getType() == Integer.class). toArray(Field[]::new);

        int suma = 0;
        try {
            for (Field field : nadklasaFields){
                field.setAccessible(true);
                suma += (Integer) field.get(wygodnaBudka);
            }
            for(Field field : wygodnaBudkaFields){
                field.setAccessible(true);
                suma -= (Integer) field.get(wygodnaBudka);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
