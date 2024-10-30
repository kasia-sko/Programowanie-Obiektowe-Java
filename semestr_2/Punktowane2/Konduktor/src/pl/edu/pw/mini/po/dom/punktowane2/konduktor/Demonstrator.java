package pl.edu.pw.mini.po.dom.punktowane2.konduktor;

import java.util.TreeSet;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik.KasownikDoBiletowOffline;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik.SystemSprzedazyBiletow;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon.Podrozny;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon.Wagon;

public class Demonstrator {

	public static void main(String[] args) {

		SystemSprzedazyBiletow system = new SystemSprzedazyBiletow();
		KasownikDoBiletowOffline kasownik = new KasownikDoBiletowOffline(system);
		TreeSet<Podrozny> podrozni = new TreeSet<Podrozny>();{
			for (int i=0; i<50; i++) {
				podrozni.add(new Podrozny(system));
			}
		}
		Wagon wagon = new Wagon(podrozni);
		Konduktor konduktor = new Konduktor(kasownik, wagon);
		konduktor.go();
	
	}

}
