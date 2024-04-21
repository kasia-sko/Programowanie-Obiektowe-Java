package pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca;

import java.util.LinkedHashSet;
import java.util.Set;

import pw.mini.edu.po.dom.punktowane2.dyskoteka.PrzekroczonaPojemnoscException;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.Uczestnik;

public class Sala {
	
	private Set<Uczestnik> uczestnicy = new LinkedHashSet<Uczestnik>();
	protected int maksymalnaPojemnosc;
	private int aktualnaPojemnosc;
	
	public Sala(int maksymalnaPojemnosc) {
		this.maksymalnaPojemnosc = maksymalnaPojemnosc; // co z tym static??
		this.aktualnaPojemnosc = 0;
	}
	
	// dodanie uczestnika z zewnatrz
	public void dodajUczestnika(Uczestnik u) throws PrzekroczonaPojemnoscException{
		if (aktualnaPojemnosc < maksymalnaPojemnosc) {
			uczestnicy.add(u);
			aktualnaPojemnosc++;
//			System.out.println(aktualnaPojemnosc);
		}
		else {
			throw new PrzekroczonaPojemnoscException();
			}
	}
}
