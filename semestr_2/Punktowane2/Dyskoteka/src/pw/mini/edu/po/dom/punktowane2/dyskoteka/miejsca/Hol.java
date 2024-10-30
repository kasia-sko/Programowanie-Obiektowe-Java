package pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.CzlowiekZZewnatrz;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.Student;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.Studentka;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.Uczestnik;

public class Hol {
	
	protected List<Uczestnik> uczestnicy;
	
	public Hol() {
		this.uczestnicy = stworzUczestnikow();
	}
	
	private List<Uczestnik> stworzUczestnikow(){
		List<Uczestnik> uczestnicy = new LinkedList<>();
		int i = 0;
		while (i < 33) {
			uczestnicy.add(new Studentka());
			i++;
		}
		while (i < 66) {
			uczestnicy.add(new Student());
			i++;
		}
		while (i < 99) {
			uczestnicy.add(new CzlowiekZZewnatrz());
			i++;
		}
		Collections.shuffle(uczestnicy);
		return uczestnicy;
	}
	
	public List<Uczestnik> getUczestnicy(){
		return uczestnicy;
	}

}
