package pl.edu.pw.mini.jrafalko;

import pl.edu.pw.mini.jrafalko.censor.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class k implements Censorable {
    @Override
    public List<Pracownik> cenzuruj(List<Pracownik> list) {
        Iterator<Pracownik> iterator = list.iterator();
        while (iterator.hasNext()){
            Pracownik pracownik = iterator.next();;
            Class<?> clazz = pracownik.getClass();

            while(clazz != null){
                // 1. Utwórz adnotację dla klasy która sygnalizuje, iż wszystkim polom typu String (zadeklarowanym lub
                // dziedziczonym z nadklasy) należy ustawić wartość pustą
                // Ustaw tą adnotację na klasie Ksiegowa
                if(pracownik.getClass().isAnnotationPresent(SkasujWszystkieStringi.class)){
                    for(Field field : clazz.getDeclaredFields()){
                        if (field.getType().equals(String.class)){
                            field.setAccessible(true);
                            try {
                                field.set(pracownik, "");
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }


                for(Field field : clazz.getDeclaredFields()) {
                    // 2. Stwórz adnotację dla pola, która sygnalizuje że jeśli pole jest typu String, to cenzor dokona
                    // podmiany tekstu na: pierwsze 3 znaki i "___" Np. "Abrakadabra", otrzymamy: "Abr___"
                    //b. Ustaw tą adnotację na polach klas: "Inzynier" - "aktualnyProjekt"
                    // "Dyrektor" - "charakterystykaOsobowosci
                    if (field.isAnnotationPresent(CenzuraPierwsze3Znaki.class) && field.getType().equals(String.class)) {
                        field.setAccessible(true);
                        try {
                            String string = (String) field.get(pracownik);
                            if (string != null && string.length() > 3) {
                                field.set(pracownik, string.substring(0, 3) + "____");
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // 3. Utwórz adnotację dla pola String, która pobiera tekst na podmianę i informuje iż zamiast tekstu w polu,
                    // które jest nią oznaczone wstawia tekst ustawiony jako parametr, a w przypadku jego braku, to używa do tego celu
                    // wykropkowanych ciągów, np. "Ala ma kota" -> "……."
                    //b. Użyj tej adnotacji na polach klasy: "Dyrektor" - "miastoUrodzenia" – Tekst na podmianę: "Władywostok")
                    // "Inzynier" – "opiniaKolegow" – brak tekstu do podmiany
                    if (field.isAnnotationPresent(CenzuraNowyTekst.class) && field.getType().equals(String.class)) {
                        field.setAccessible(true);
                        try {
                            field.set(pracownik, field.getAnnotation(CenzuraNowyTekst.class).tekst());
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // 4. Stwórz adnotację, informującą, że pole o ile jest int-em ma mieć wartość 0
                    //b. Zastosuj tą adnotację do pól klas: "Pracownik" - "wiek" "Monter" - "iloscWyprodukowanychElementow"
                    if (field.isAnnotationPresent(IntCenzura.class) && field.getType().equals(int.class)) {
                        field.setAccessible(true);
                        try {
                            field.set(pracownik, 0);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                clazz = clazz.getSuperclass();

            }
            clazz = pracownik.getClass();
            // 5. a. Utwórz adnotację dla metody informującą, iż metoda ta ma być tyle razy wywołana, ile przekażemy w argumencie adnotacji
            //b. Zastosuj tą adnotację na metodzie "zwiekszZysk" klas Monter (10), oraz Ksiegowa (3)
            for(Method method : clazz.getDeclaredMethods()){
                if(method.isAnnotationPresent(WykonajMetode.class)){
                    method.setAccessible(true);
                    for(int i = 0; i < method.getAnnotation(WykonajMetode.class).liczba(); i++){
                        try {
                            method.invoke(pracownik);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            // 6. Utwórz adnotację dla klasy, która pobiera parametr o dwóch możliwych wartościach
            // (liczba lub Produkty – za pomocą enum) która sygnalizuje, że należy ustawić wartości wszystkich pól liczbowych na -1
            // lub pól z produktami na BOMBKI
            //b. Zastosować tą adnotację na klasie "Monter
            if(clazz.isAnnotationPresent(Ustaw.class)){
                for(Field field : clazz.getDeclaredFields()){
                    field.setAccessible(true);
                    try {
                        if(clazz.getAnnotation(Ustaw.class).typ() == Ustaw.Typ.liczba){
                            if(field.getType() == Integer.class){
                                field.set(pracownik, -1);
                            }
                        }
                        if(clazz.getAnnotation(Ustaw.class).typ() ==  Ustaw.Typ.Produkty) {
                            if(field.getType() == Produkty.class){
                                field.set(pracownik, Produkty.BOMBKI);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // 7. Stwórz adnotację dla klasy informującą, iż obiekt danej klasy, jeżeli będzie miał wartość pola
            // "wiek" < niż 30 zostanie usunięty z listy
            //b. Zastosować tą adnotację na klasie "Monter"
            if(clazz.isAnnotationPresent(UsunJesliWiekMniejszyNiz30.class)){
                try {
                    Field wiekField = clazz.getSuperclass().getDeclaredField("wiek");
                    wiekField.setAccessible(true);
                    if((int)wiekField.get(pracownik) < 30){
                        iterator.remove();
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }





        }

        return list;
    }
}
