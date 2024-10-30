package pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.RelacjaPociagu;
import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik.SystemSprzedazyBiletow;

public class Podrozny implements Comparable<Podrozny>{
	
	protected static final Random random = new Random();
	private String imie;
	private String nazwisko;
	private int stopienWyglodzenia;
	private Bilet bilet;
	private SystemSprzedazyBiletow system;
	private static List<String> listaImion = new ArrayList<String>();
	private static List<String> listaNazwisk = new ArrayList<String>();
	
	static {
		stworzListeImion();
		stworzListeNazwisk();
	}
	
	public Podrozny(SystemSprzedazyBiletow system) {
		this.imie = listaImion.get(random.nextInt(listaImion.size()));
		this.nazwisko = listaNazwisk.get(random.nextInt(listaNazwisk.size()));
		this.stopienWyglodzenia = random.nextInt(10) + 1;
		this.system = system;
		this.bilet = system.sprzedajBilet(imie, nazwisko, RelacjaPociagu.values()[random.nextInt(1)]);
	}

	private static void stworzListeImion() {
		listaImion.add("Kasia");
		listaImion.add("Ada");
		listaImion.add("Martyna");
		listaImion.add("Ola");
		listaImion.add("Kuba");
		listaImion.add("Ania");
		listaImion.add("Piotrek");
		listaImion.add("Bartek");
		listaImion.add("Miłosz");
		listaImion.add("Kim");
	}
	
	private static void stworzListeNazwisk() {
		listaNazwisk.add("Skoczylas");
		listaNazwisk.add("Zawadka");
		listaNazwisk.add("Wojterska");
		listaNazwisk.add("Sadowska");
		listaNazwisk.add("Kowalski");
		listaNazwisk.add("Kopiczak");
		listaNazwisk.add("Synoś");
		listaNazwisk.add("Zieliński");
		listaNazwisk.add("Grys");
		listaNazwisk.add("Czado");
	}
	
	
	public String getImie() {
		return imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public int getStopienWyglodzenia() {
		return stopienWyglodzenia;
	}
	
	public Bilet getBilet() {
		return bilet;
	}
	
	public int compareTo(Podrozny p) {
		return stopienWyglodzenia - p.stopienWyglodzenia;
	}
}
