package pl.edu.pw.mini.po.dom.punktowane2.konduktor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik.BrakZasieguException;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik.KasownikDoBiletow;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon.Podrozny;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon.Stolik;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon.Wagon;

public class Konduktor {

	private Map<Podrozny, Bilet> niewazneBilety;
	private KasownikDoBiletow kasownikDoBiletow;
	private Wagon wagon;
	
	public Konduktor(KasownikDoBiletow kasownik, Wagon wagon) {
		this.niewazneBilety = new HashMap<Podrozny, Bilet> ();
		this.kasownikDoBiletow = kasownik;
		this.wagon = wagon;
	}
	
	public void go() {
		Map<Stolik, TreeSet<Podrozny>> pasazerowiePrzyStoliku = wagon.getWszyscyPasazerowiePrzyStoliku();
		for (Stolik stolik : pasazerowiePrzyStoliku.keySet()) {
			TreeSet<Podrozny> podrozni = pasazerowiePrzyStoliku.get(stolik);
			Iterator<Podrozny> i = podrozni.iterator();
			while (i.hasNext()){
				Podrozny podrozny = i.next();
				Bilet bilet = podrozny.getBilet();
				try {
					boolean wazny = kasownikDoBiletow.walidujBilet(bilet);
					if (wazny == false) {
						System.out.println("Bilet nieważny!!!");
						niewazneBilety.put(podrozny, bilet);
						i.remove();
					}
				}
				catch (BrakZasieguException e) {
					System.out.println(e.getMessage());
				}
				}
			}
		System.out.println("Liczba znalezionych niewaznych biletow: " + niewazneBilety.size());
	}
}
