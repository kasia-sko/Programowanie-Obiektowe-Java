package pl.edu.pw.mini.jrafalko;

import pl.edu.pw.mini.jrafalko.cargo.BagOfPotatoes;
import pl.edu.pw.mini.jrafalko.cargo.Barrel;
import pl.edu.pw.mini.jrafalko.cargo.Cargo;
import pl.edu.pw.mini.jrafalko.cargo.Chest;
import pl.edu.pw.mini.jrafalko.truck.SpareWeel;
import pl.edu.pw.mini.jrafalko.truck.TireCompany;
import pl.edu.pw.mini.jrafalko.truck.Truck;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        /* 1. Wypisz listę konstruktorów wraz z parametrami klasy Barrel
         * korzystając z informacji możliwych do uzyskania z obiektu klasy.*/
        //Class<?> class1 = Class.forName("pl.edu.pw.mini.jrafalko.cargo.Barrel");
        System.out.println("-------1-------");
        Arrays.stream(Barrel.class.getDeclaredConstructors()).toList()
                .forEach(System.out::println);
//            .forEach(c -> {
//            System.out.print(c + ": ");
//            Parameter[] parameters = c.getParameters();
//            for(Parameter parameter : parameters){
//                System.out.print(parameter.getType().getSimpleName() + " ");
//            }
//            System.out.println();
//        });

        /*2.	Ustal, czy klasa Chest posiada konstruktor o modyfikatorze protected,
        przyjmujący dwa parametry: boolean i String. Odpowiedź wypisz w konsoli.*/
        System.out.println("-------2-------");
        try {
            Constructor<?> constructor = Chest.class.getDeclaredConstructor(boolean.class, String.class);
            if(Modifier.isProtected(constructor.getModifiers())){
                System.out.println("Jest taki konstruktor");
            }
            else{
                System.out.println("Brak takiego konstruktora");
            }
        }
        catch (NoSuchMethodException e){
            System.out.println("Brak takiego konstruktora");
        }
//        Constructor<?>[] constructors = class2.getDeclaredConstructors();
//        boolean found = false;
//        for (Constructor constructor : constructors){
//            if(Modifier.isProtected(constructor.getModifiers())){
//                Class<?>[] parameterTypes = constructor.getParameterTypes();
//                if(parameterTypes.length == 2 && parameterTypes[0] == boolean.class && parameterTypes[1] == String.class){
//                    found = true;
//                    break;
//                }
//            }
//        }
//        System.out.println("Czy znaleziono konstruktor? " + found);

        /*3. Uzyskaj informacje o nazwie pakietu klasy Cargo. Wypisz w konsoli. */
        System.out.println("-------3-------");
        System.out.println("Nazwa pakietu klasy Cargo: " + Cargo.class.getPackageName());

        /* 4. Wylistuj prywatne metody klasy BagOfPotatoes wraz z parametrami. */
        System.out.println("-------4-------");
        System.out.println("Prywatne metody klasy BagOfPotatoes z parametrami");
        Arrays.stream(BagOfPotatoes.class.getDeclaredMethods())
                .filter(method -> Modifier.isPrivate(method.getModifiers()))
                .forEach(m -> {
                    System.out.println(m.getName() + ": ");
                    Parameter[] parameters = m.getParameters();
                        for(Parameter parameter : parameters){
                            System.out.println(parameter.getType().getSimpleName() + " ");
                        }
                    });


        /*5. Ustal (pobierz) wartość pola sticker znajdującego się w klasie KoloOdCiezarowki i wypisz na konsoli. */
        // nie ma kola od ciezarowki
        System.out.println("-------5-------");
        try {
            Field stickerField = SpareWeel.class.getDeclaredField("sticker");
            stickerField.setAccessible(true);
            System.out.println("Pole sticker: " + stickerField.get(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        /* 6. 	Wypisz nazwę nadklasy klasy Barrel. */
        System.out.println("-------6-------");
        System.out.println("Nadklasa klasy Barrel: " + Barrel.class.getSuperclass().getSimpleName());

        /*7. Wylistuj interfejsy implementowane przez klasę Cargo. Sprawdź,
        czy któryś z nich pochodzi z tego samego pakietu, co ta klasa. */
        // czy trzeba zrobic liste??
        System.out.println("-------7-------");
        Arrays.stream(Cargo.class.getInterfaces()).forEach(
                i -> {
                    if(i.getPackage() == Cargo.class.getPackage()){
                        System.out.println("Interfejs: " + i + " ten sam pakiet co Cargo");
                    }
                    else {
                        System.out.println("Interfejs: " + i + " inny pakiet niz Cargo");
                    }
                }
        );

        /* 8. Stwórz obiekt klasy KoloOdCiezarowki i sprawdź wartość pola tireSize na tym obiekcie. */
        // chyba chodzi o SpareWeel
        System.out.println("-------8-------");
        try {
            Class<?> class8 = SpareWeel.class;
            Object spareWeel = class8.getDeclaredConstructor().newInstance();
            Field tireSize = class8.getDeclaredField("tireSize");
            tireSize.setAccessible(true);
            System.out.println("Wartosc pola tireSize: " + tireSize.get(spareWeel));
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        /* 9. 	Utwórz kolekcję beczek, skrzyń i worków z ziemniakami używając
        każdego z konstruktorów w tych klasach. */
        System.out.println("-------9-------");
        List<Class<?>> classes = List.of(Barrel.class, Chest.class, BagOfPotatoes.class);
        List<Object> cargos = new ArrayList<>();
        classes.stream()
                .flatMap(c -> Arrays.stream(c.getDeclaredConstructors()))
                .forEach(constructor -> {
                    try {
                        Object instance = createInstance(constructor);
                        if (instance != null) {
                            cargos.add(instance);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        cargos.forEach(System.out::println);

        /* 10. 10.Utwórz obiekt klasy Truck */
        System.out.println("-------10-------");
        Object truck;
        try {
            truck = Truck.class.getConstructor().newInstance();
            System.out.println(truck);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        /* 11. Uzyskaj dostęp do pola loadingBody w utworzonym wcześniej obiekcie i wywołaj na nim
        metodę addCargo, dodając obiekty utworzone w punkcie 9-tym. */
        System.out.println("-------11-------");
        try {
            Field loadingBody = Truck.class.getDeclaredField("loadingBody");
            loadingBody.setAccessible(true);
            Object lBody = loadingBody.get(truck);
            Method method = lBody.getClass().getDeclaredMethod("addTowar", Cargo.class);
            method.setAccessible(true);
            for(Object cargo : cargos) {
                method.invoke(lBody, cargo);
            }
            Method printM = lBody.getClass().getDeclaredMethod("printPaceGoods");
            printM.setAccessible(true);
            System.out.println(printM.invoke(lBody));
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        /* 12. Przypisz polom (instancji klasy Truck) spareWeel i fuelTank instancje stworzonych
        obiektów klas SpareWeel i FuelTank(napełniony). Informację o typach zaczerpnij z klas tych pól.*/
        System.out.println("-------12-------");
        try {
            SpareWeel spareWeel = SpareWeel.class.getDeclaredConstructor().newInstance();
            Truck.FuelTank fuelTank = Truck.FuelTank.class.getDeclaredConstructor(Truck.class, boolean.class).newInstance(truck, true);
            Field fuel = Truck.class.getDeclaredField("fuelTank");
            Field spare = Truck.class.getDeclaredField("spareWeel");
            fuel.setAccessible(true);
            spare.setAccessible(true);
            fuel.set(truck, fuelTank);
            spare.set(truck, spareWeel);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        /*13. Uzyskaj dostęp do pola: driversCabin i sprawdź czy elementy tego pola mają wartość null.
        Jeśli tak, to wstaw tam utworzone obiekty odpowiedniego typu.
        Informację o typach zaczerpnij z klas tych pól. */
        System.out.println("-------13-------");
        try {
            Field driversCabinField = Truck.class.getDeclaredField("driversCabin");
            driversCabinField.setAccessible(true);
            Object driversCabin = driversCabinField.get(truck);
            Field driverField = driversCabin.getClass().getDeclaredField("driver");
            driverField.setAccessible(true);
            Field ignitionSwitch = driversCabin.getClass().getDeclaredField("ignitionSwitch");
            ignitionSwitch.setAccessible(true);

            if(driverField.get(driversCabin) == null){
                Constructor<?> driverConstructor = driverField.getType().getDeclaredConstructor();
                driverConstructor.setAccessible(true);
                Object driverInstance = driverConstructor.newInstance();
                driverField.set(driversCabin, driverInstance);
                System.out.println("Field 'driver' was null and has been initialized.");
            }
            else{
                System.out.println("Field 'driver' is already initialized");
            }

            if(ignitionSwitch.get(driversCabin) == null){
                Constructor<?> ignitionConstructor = ignitionSwitch.getType().getDeclaredConstructor(driversCabin.getClass(),boolean.class);
                ignitionConstructor.setAccessible(true);
                Object ignitionInstance = ignitionConstructor.newInstance(driversCabin,false);
                ignitionSwitch.set(driversCabin, ignitionInstance);
                System.out.println("Field 'ignitionSwitch' was null and has been initialized.");
            }
            else {
                System.out.println("Field 'ignitionSwitch' is already initialized.");
            }
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        /* 14. Wywołaj metodę drive zdefiniowaną dla kierowcy.*/
        System.out.println("-------14-------");
        try {
            Field driversCabinField = Truck.class.getDeclaredField("driversCabin");
            driversCabinField.setAccessible(true);
            Object driversCabin = driversCabinField.get(truck);
            Field driverField = driversCabin.getClass().getDeclaredField("driver");
            driverField.setAccessible(true);
            Object driverInstance = driverField.get(driversCabin);
            if(driverInstance == null){
                System.out.println("Driver not initialized, cant drive");
            }
            else{
                Method driverMethod = driverInstance.getClass().getDeclaredMethod("drive");
                driverMethod.setAccessible(true);
                driverMethod.invoke(driverInstance);
            }
        } catch (NoSuchFieldException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        /* 15. Stwórz adnotację TireCompany działającą podczas wykonania programu zawierającą dwie
        informacje będące ciągami znaków: nazwa producenta oraz rozmiar opony.
        "Ozdób" nią klasę spareWeel. Wstaw dowolne wartości. */
        System.out.println("-------15-------");
        Class<?> spareWeelClass = SpareWeel.class;
        if (spareWeelClass.isAnnotationPresent(TireCompany.class)) {
            TireCompany tireCompany = spareWeelClass.getAnnotation(TireCompany.class);
            System.out.println("Manufacturer: " + tireCompany.manufacturer());
            System.out.println("Tire Size: " + tireCompany.size());
        }
        else {
            System.out.println("TireCompany annotation not present.");
        }


    }

    // Metoda pomocnicza do tworzenia obiektu
    private static Object createInstance(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            if (constructor.getParameterCount() == 0) {
                return constructor.newInstance();
            }
            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] params = Arrays.stream(paramTypes)
                    .map(Main::getDefaultValue)
                    .toArray();
            return constructor.newInstance(params);
        } catch (Exception e) {
            System.err.println("Nie udało się utworzyć instancji dla konstruktora: " + constructor);
            return null;
        }
    }

    // Metoda do generowania wartości domyślnych dla typów parametrów
    private static Object getDefaultValue(Class<?> type) {
        if (type.isPrimitive()) {
            if (type == boolean.class) return false;
            if (type == byte.class) return (byte) 0;
            if (type == short.class) return (short) 0;
            if (type == int.class) return 0;
            if (type == long.class) return 0L;
            if (type == float.class) return 0f;
            if (type == double.class) return 0d;
            if (type == char.class) return '\0';
        }
        return null; // Dla typów obiektowych zwróć null
    }



}

/**
 1.	Wypisz listę konstruktorów wraz z parametrami klasy Barrel
 korzystając z informacji możliwych do uzyskania z obiektu klasy.
 2.	Ustal, czy klasa Chest posiada konstruktor o modyfikatorze protected,
 przyjmujący dwa parametry: boolean i String. Odpowiedź wypisz w konsoli.
 3.	Uzyskaj informacje o nazwie pakietu klasy Cargo. Wypisz w konsoli.
 4.	Wylistuj prywatne metody klasy BagOfPotatoes wraz z parametrami.
 5.	Ustal (pobierz) wartość pola sticker znajdującego się w klasie KoloOdCiezarowki i wypisz na konsoli.
 6.	Wypisz nazwę nadklasy klasy Barrel.
 7.	Wylistuj interfejsy implementowane przez klasę Cargo. Sprawdź,
 czy któryś z nich pochodzi z tego samego pakietu, co ta klasa.
 8.	Stwórz obiekt klasy KoloOdCiezarowki i sprawdź wartość pola tireSize na tym obiekcie.
 9.	Utwórz kolekcję beczek, skrzyń i worków z ziemniakami używając
 każdego z konstruktorów w tych klasach.
 10.Utwórz obiekt klasy Truck.
 11.Uzyskaj dostęp do pola loadingBody w utworzonym wcześniej obiekcie i wywołaj na nim
 metodę addCargo, dodając obiekty utworzone w punkcie 9-tym.
 12.Przypisz polom (instancji klasy Truck) spareWeel i fuelTank instancje stworzonych
 obiektów klas SpareWeel i FuelTank(napełniony). Informację o typach zaczerpnij z klas tych pól.
 13.Uzyskaj dostęp do pola: driversCabin i sprawdź czy elementy tego pola mają wartość null.
 Jeśli tak, to wstaw tam utworzone obiekty odpowiedniego typu.
 Informację o typach zaczerpnij z klas tych pól.
 14.Wywołaj metodę drive zdefiniowaną dla kierowcy.
 15.Stwórz adnotację TireCompany działającą podczas wykonania programu zawierającą dwie
 informacje będące ciągami znaków: nazwa producenta oraz rozmiar opony.
 "Ozdób" nią klasę spareWeel. Wstaw dowolne wartości.
 */

//// task 1
//        System.out.println("--------------------1--------------------");
//Class<?> class1 = Class.forName("Ladunek.Barrel");
//        Arrays.stream(class1.getDeclaredConstructors()).toList().forEach(System.out::println);
//// task 2
//        System.out.println("--------------------2--------------------");
//Class<?> class2 = Class.forName("Ladunek.Chest");
//Class<?>[] parameterTypes = {String.class, boolean.class};
//        try {
//                System.out.println("Jest: " + class2.getDeclaredConstructor(parameterTypes));
//        } catch (NoSuchMethodException e) {
//        System.out.println("Brak");
//        }
//                // task 3
//                System.out.println("--------------------3--------------------");
//Class<?> class3 = Class.forName("Ladunek.Cargo");
//        System.out.println(class3.getPackage());
//        // task 4
//        System.out.println("--------------------4--------------------");
//Class<?> class4 = Class.forName("Ladunek.BagOfPotatoes");
//        Arrays.stream(class4.getDeclaredMethods()).filter(s -> Modifier.isPrivate(s.getModifiers())).toList().forEach(System.out::println);
//// task 5
//        System.out.println("--------------------5--------------------");
//Class<?> class5 = Class.forName("Ciezarowka.KoloOdCiezarowki");
//        try {
//Field field = class5.getDeclaredField("sticker");
//            field.setAccessible(true);
//KoloOdCiezarowki kolo = (KoloOdCiezarowki) class5.getDeclaredConstructor().newInstance();
//            field.set(kolo, "Nalypka");
//            System.out.println(field.get(kolo));
//
//        } catch (NoSuchFieldException | NoSuchMethodException | InvocationTargetException | InstantiationException |
//IllegalAccessException e) {
//        e.printStackTrace();
//        }
//                // task 6
//                System.out.println("--------------------6--------------------");
//Class<?> class6 = Class.forName("Ladunek.Barrel");
//        System.out.println(class6.getSuperclass());
//        // task 7
//        System.out.println("--------------------7--------------------");
//Class<?> class7 = Class.forName("Ladunek.Cargo");
//        Arrays.stream(class7.getInterfaces()).forEach(s -> {
//        if (s.getPackage() == class7.getPackage()){
//        System.out.println(s + ", " + true);
//            } else{
//                    System.out.println(s + ", " + false);
//            }
//                    });
//                    // task 8
//                    System.out.println("--------------------8--------------------");
//Class<?> class8 = Class.forName("Ciezarowka.KoloOdCiezarowki");
//        try {
//KoloOdCiezarowki koloo = (KoloOdCiezarowki) class5.getDeclaredConstructor().newInstance();
//Field field = class8.getDeclaredField("tiresize");
//            field.setAccessible(true);
//            field.set(koloo, 15);
//            System.out.println(field.get(koloo));
//        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
//NoSuchFieldException e) {
//        e.printStackTrace();
//        }
//                // task 9
//                System.out.println("--------------------9--------------------");
//
//List<Class<?>> subclasses = List.of(Barrel.class, Chest.class, BagOfPotatoes.class);
//
//List<Object> cargos = subclasses.stream().flatMap(class9 -> Arrays.stream(class9.getConstructors()))
//        .map(Main::createObject)
//        .toList();
//        cargos.forEach(System.out::println);
//// task 10
//        System.out.println("--------------------10--------------------");
//Class<?> class10 = Class.forName("Ciezarowka.Truck");
//Truck truck = null;
//        try {
//truck = (Truck) class10.getConstructor().newInstance();
//        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//        e.printStackTrace();
//        }
//                System.out.println(truck);
//// task 11
//        System.out.println("--------------------11--------------------");
//Class<?> class11 = Class.forName("Ciezarowka.Truck");
//        try {
//Field field = class11.getDeclaredField("loadingBody");
//            field.setAccessible(true);
//Method method = class11.getDeclaredMethod("addCargos", List.class);
//            method.invoke(truck, cargos);
//        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//        e.printStackTrace();
//        }
//                cargos.forEach(System.out::println);
//// task 12
//        System.out.println("--------------------12--------------------");
//Class<?> class12 = Class.forName("Ciezarowka.SpareWheel");
//Class<?> class12a = Class.forName("Ciezarowka.FuelTank");
//        try {
//SpareWheel spareWheel = (SpareWheel) class12.getConstructor().newInstance();
//FuelTank fueltank = (FuelTank) class12a.getConstructor().newInstance();
//            spareWheel.setTiresize(25);
//            fueltank.setNapelniony(true);
//Field fuel = class10.getDeclaredField("fueltank");
//Field spare = class10.getDeclaredField("spareWheel");
//            fuel.setAccessible(true);
//            spare.setAccessible(true);
//            fuel.set(truck, fueltank);
//            spare.set(truck, spareWheel);
//
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
//NoSuchFieldException e) {
//        e.printStackTrace();
//        }
//                System.out.println(truck);
//// task 13
//        System.out.println("--------------------13--------------------");
//        try {
//Field field = class10.getDeclaredField("driverCabin");
//            field.setAccessible(true);
//Class<?> driver = Class.forName("Ciezarowka.Driver");
//Class<?> cbradio = Class.forName("Ciezarowka.CBRadio");
//Field driverfield =driver.getDeclaredField("trzezwy");
//Field cbradioField = cbradio.getDeclaredField("dziala");
//            driverfield.setAccessible(true);
//            cbradioField.setAccessible(true);
//Driver dr = (Driver) driver.getConstructor().newInstance();
//            driverfield.set(dr, false);
//CBRadio cb = (CBRadio) cbradio.getConstructor().newInstance();
//            cbradioField.set(cb, false);
//            if (field.get(truck) == null){
//Class<?> drivercabin = Class.forName("Ciezarowka.DriverCabin");
//DriverCabin driverCabin = (DriverCabin) drivercabin.getConstructor().newInstance();
//Field driverr = drivercabin.getDeclaredField("driver");
//Field cbb = drivercabin.getDeclaredField("cbRadio");
//                driverr.setAccessible(true);
//                cbb.setAccessible(true);
//                driverr.set(driverCabin, dr);
//                cbb.set(driverCabin, cb);
//Field cabin = class10.getDeclaredField("driverCabin");
//                cabin.setAccessible(true);
//                cabin.set(truck,driverCabin);
//            }
//
//                    } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException |
//InvocationTargetException e) {
//        e.printStackTrace();
//        }
//                System.out.println(truck);
//// task 14
//        System.out.println("--------------------14--------------------");
//        try {
//Field field = class10.getDeclaredField("driverCabin");
//            field.setAccessible(true);
//DriverCabin cabin = (DriverCabin) field.get(truck);
//Class<?> cl = cabin.getClass();
//Field field1 = cl.getDeclaredField("driver");
//            field1.setAccessible(true);
//Driver driver = (Driver) field1.get(cabin);
//            driver.drive();
//        } catch (NoSuchFieldException | IllegalAccessException | NullPointerException e) {
//        e.printStackTrace();
//        }
//                // task 15
//                System.out.println("--------------------15--------------------");
//Field infoField = null;
//        try {
//infoField = SpareWheel.class.getDeclaredField("info");
//TireCompany tireCompanyAnnotation = infoField.getAnnotation(TireCompany.class);
//String manufacturer = tireCompanyAnnotation.manufacturer();
//String tireSize = tireCompanyAnnotation.tireSize();
//            System.out.println(manufacturer);
//            System.out.println(tireSize);
//        } catch (NoSuchFieldException e) {
//        e.printStackTrace();
//        }
//
//
//
//                }
//private static Object createObject(Constructor<?> constructor) {
//    try {
//        constructor.setAccessible(true);
//        int parameterCount = constructor.getParameterCount();
//        Object[] arguments = new Object[parameterCount];
//
//        for (int i = 0; i < parameterCount; i++) {
//
//            arguments[i] = new Random().nextInt(15) + 1;
//        }
//        return constructor.newInstance(arguments);
//
//    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//        e.printStackTrace();
//        return null;
//    }
//
//}
