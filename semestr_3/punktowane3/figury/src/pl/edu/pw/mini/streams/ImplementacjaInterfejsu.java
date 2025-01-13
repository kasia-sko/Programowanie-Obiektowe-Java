package pl.edu.pw.mini.streams;

import pl.edu.pw.mini.figures.Figura2D;
import pl.edu.pw.mini.figures.Figura3D;
import pl.edu.pw.mini.figures.Kolo;
import pl.edu.pw.mini.figures.Szescian;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImplementacjaInterfejsu implements MetodyStrumieniowe {

    List<Figura2D> figury;

    public ImplementacjaInterfejsu(List<Figura2D> fig) {
        this.figury = fig;
    }

    /**
     * 1
     * @return Największa figura względem właściwości wysokosc
     * 0,5 pkt
     */
    @Override
    public Figura2D getNajwiekszaFigure() {
        return figury.stream()
                .max((f1,f2) -> Integer.compare(f1.getWysokosc(), f2.getWysokosc()))
                .orElse(null);
    }

    /**
     * 2
     * @return Figura2D o najmniejszym polu powierzchni
     * 0,5 pkt
     */
    @Override
    public Figura2D getFigureONajmniejszymPolu() {

        return figury.stream()
                // ?????
                .filter(figura -> !(figura instanceof Figura3D))
                .min((f1,f2) -> Double.compare(f1.polePowierzchni(), f2.polePowierzchni()))
                .orElse(null);
    }

    /**
     * 3
     * @return Najwyższa figura 3D
     * 0,5 pkt
     */
    @Override
    public Figura2D getNajwyzszaFigure3D() {

        return figury.stream()
                .filter(figura -> figura instanceof Figura3D)
                .max((f1,f2) -> Integer.compare(f1.getWysokosc(), f2.getWysokosc()))
                .orElse(null);
    }

    /**
     * 4
     * @return Najmniejszy sześcian względem objętości
     * 1 pkt
     */
    @Override
    public Figura2D getNajmniejszySzescian() {

        return figury.stream()
                .filter(figura -> figura instanceof Szescian)
                //.map(figura -> (Szescian)figura)
                .min((f1,f2) -> Double.compare(((Szescian)f1).objetosc(), ((Szescian)f1).objetosc()))
                .orElse(null);
    }

    /**
     * 5
     * @return Lista figur posortowanych względem pola powierzchni
     * 0,5 pkt
     */
    @Override
    public List<Figura2D> getPosortowaneWzgledemPowiezchni() {

        return figury.stream()
                .sorted((f1, f2) -> Double.compare(f1.polePowierzchni(), f2.polePowierzchni()))
                .collect(Collectors.toList());
    }

    /**
     * 6
     * @return Figura z posortowanych malejaco względem obwodu,
     *         nr figury podany w argumencie,
     *         pomijając te, które obwodu nie mają
     * 1 pkt
     */
    @Override
    public Figura2D getFigureZPosortowanychMalejacoWgObwodu(int nr) {

        return figury.stream()
                .filter(f -> f.obwod() > 0)
                .sorted((f1,f2) -> Double.compare(f2.obwod(), f1.obwod()))
                .skip(nr-1)
                .findFirst()
                .orElse(null);

    }

    /**
     * 7
     * @return Lista pierwszych figur posortowanych rosnąco względem pola powierzchni,
     *         o wysokości nie większej niż  i polu powierzchni nie mniejszym niż 10,
     *         ilość zwracanych figur w argumencie
     * 1 pkt
     */
    @Override
    public List<Figura2D> getPierwszePosortowaneRosnacoWgPowierzchni(int ilosc) {

        return figury.stream()
                .filter(figura -> figura.getWysokosc() <= 10 && figura.polePowierzchni() >= 10)
                .sorted((f1,f2) -> Double.compare(f1.polePowierzchni(), f2.polePowierzchni()))
                .limit(ilosc)
                .collect(Collectors.toList());
    }

    /**
     * 8
     * @return Lista wszystkich sześcianów o długości boku nie większej niż bok
     * 1 pkt
     */
    @Override
    public List<Figura2D> getSzesciany(int bok) {
        return figury.stream()
                .filter(figura -> figura instanceof Szescian && figura.getWysokosc() <= bok)
                //.map(figura -> (Szescian)figura)
                .collect(Collectors.toList());
    }

    /**
     * 9
     * @return Koło o najmniejszym polu powierzchni
     * 0,5 pkt
     */
    @Override
    public Figura2D getNajmniejszeKolo() {

        return figury.stream()
                .filter(figura -> figura instanceof Kolo)
                //.map(figura -> (Kolo)figura)
                .min((k1,k2) -> Double.compare(k1.polePowierzchni(),k2.polePowierzchni()))
                .orElse(null);
    }

    /**
     * 10
     * @return Mapa figur względem ID
     * 1 pkt
     */
    @Override
    public Map<Integer, Figura2D> mapaWgId() {

        return figury.stream()
                .collect(Collectors.toMap(
                        figura -> figura.getId(),
                        figura -> figura
                        //, (existing, replacement) -> replacement
                        // uznajemy ze id jest unikalne
                ));
    }

    /**
     * 11
     * @return Ilość figur o polu powierzchni nie większym niż pole
     * 0,5 pkt
     */
    @Override
    public int getiloscMalych(double pole) {

        return (int) figury.stream()
                .filter(figura -> figura.polePowierzchni() <= pole)
                .count();
    }

    /**
     * 12
     * @return Posortowany ciąg figur względem pola powierzchni zaczynając od podanej
     * 0,5 pkt
     */
    @Override
    public List<Figura2D> posortowaneWgPolaZaczynajacOd(int nr) {

        return figury.stream()
                .sorted((f1,f2) -> Double.compare(f1.polePowierzchni(), f2.polePowierzchni()))
                .skip(nr-1)
                .collect(Collectors.toList());
    }
}

