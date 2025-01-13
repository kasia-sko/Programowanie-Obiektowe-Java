package pl.edu.pw.mini.jrafalko;

import pl.edu.pw.mini.jrafalko.censor.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**jr
 * 1 - 5 - 1p
 * 6,7 - 1.5p
 * 1p - za jakość
 * */
public class Cenzura implements Censorable{
    @Override
    public List<Pracownik> cenzuruj(List<Pracownik> list) {
        Iterator<Pracownik> iterator = list.iterator();
        while(iterator.hasNext()){
            Pracownik pracownik = iterator.next();;
            Class<?> clazz = pracownik.getClass();

            // 7. UsunJesliWiekMniejszyNiz30
            if(clazz.isAnnotationPresent(UsunJesliWiekMniejszyNiz30.class)){
                try {
                    Field wiekField = clazz.getSuperclass().getDeclaredField("wiek");
                    wiekField.setAccessible(true);
                    if((int)wiekField.get(pracownik) < 30){
                        iterator.remove();
                        //System.out.println("usuwam");
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            while (clazz != null){
                for(Field field : clazz.getDeclaredFields()){
                    field.setAccessible(true);
                    // 1. SkasujWszyskieStringi
                    if(pracownik.getClass().isAnnotationPresent(SkasujWszystkieStringi.class)){
                        if (field.getType().equals(String.class)){
                            try {
                                field.set(pracownik, "");
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }

                    // 2. CenzuraPierwsze3Znaki
                    if (field.isAnnotationPresent(CenzuraPierwsze3Znaki.class) && field.getType().equals(String.class)) {
                        try {
                            String string = (String) field.get(pracownik);
                            if (string != null && string.length() > 3) {
                                field.set(pracownik, string.substring(0, 3) + "____");
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // 3. CenzuraNowyTekst
                    if (field.isAnnotationPresent(CenzuraNowyTekst.class) && field.getType().equals(String.class)) {
                        try {
                            field.set(pracownik, field.getAnnotation(CenzuraNowyTekst.class).tekst());
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // 4. IntCenzura
                    if (field.isAnnotationPresent(IntCenzura.class) && field.getType().equals(int.class)) {
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

            // 5. WykonajMetode
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

            // 6. Ustaw
            if(clazz.isAnnotationPresent(Ustaw.class)){
                for(Field field : clazz.getDeclaredFields()){
                    field.setAccessible(true);
                    try {
                        if(clazz.getAnnotation(Ustaw.class).typ().equals(Ustaw.Typ.liczba)){
                            if(field.getType() == Integer.class){
                                field.set(pracownik, -1);
                            }
                        }
                        if(clazz.getAnnotation(Ustaw.class).typ().equals(Ustaw.Typ.Produkty)) {
                            if(field.getType() == Produkty.class){
                                field.set(pracownik, Produkty.BOMBKI);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return list;
    }
}