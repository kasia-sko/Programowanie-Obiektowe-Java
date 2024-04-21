package pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Uczestnik {
	
	protected static final Random random = new Random();
	private static int counter;
	private int unikalneId;
	private int wiek;
	private String imie;
	private String nazwisko;
	private static List<String> listaImion = new ArrayList<String>();
	private static List<String> listaNazwisk = new ArrayList<String>();
	
	static {
		stworzListeImion();
		stworzListeNazwisk();
	}
	
	public Uczestnik(int wiek) {
		this.wiek = wiek;
		this.imie = listaImion.get(random.nextInt(listaImion.size()));
		this.nazwisko = listaNazwisk.get(random.nextInt(listaNazwisk.size()));
		this.unikalneId = counter++;
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
	
	public int getId() {
		return unikalneId;
	}
	
	public String getImie() {
		return imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public int getWiek() {
		return wiek;
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Uczestnik other = (Uczestnik)o;
		if (unikalneId != other.unikalneId)
			return false;
		return true;
			
	}
	
	public void accept(Visitor visitor) {
	}
}
