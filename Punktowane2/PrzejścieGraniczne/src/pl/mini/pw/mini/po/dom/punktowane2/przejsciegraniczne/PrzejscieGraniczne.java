package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny.Podrozny;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny.Przemytnik;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny.Szpieg;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny.Turysta;

import java.util.Iterator;

public class PrzejscieGraniczne {
	
	protected static final Random random = new Random();
	protected List<Podrozny> podrozni;
	protected List<Celnik> celnicy;
	protected Areszt areszt;
	
	public PrzejscieGraniczne() {
		this.areszt = new Areszt();
		this.podrozni = stworzPodroznych();
		this.celnicy = stworzCelnikow();
		
	}
	
	private List<Celnik> stworzCelnikow(){
		List<Celnik> celnicy = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			celnicy.add(new Celnik(areszt, podrozni));
		}
		return celnicy;
	}
	
	private List<Podrozny> stworzPodroznych(){
		List<Podrozny> podrozni = new LinkedList<>();
		int i = 0;
		while (i < 50) {
			podrozni.add(new Turysta());
			i++;
		}
		while (i < 100) {
			podrozni.add(new Szpieg());
			i++;
		}
		while (i < 150) {
			podrozni.add(new Przemytnik());
			i++;
		}
		Collections.shuffle(podrozni);
		return podrozni;
	}
	
	public void doJob(){
		Iterator<Podrozny> iterator = podrozni.iterator();
	    while (iterator.hasNext()) {
	        Podrozny podrozny = iterator.next();
//	        System.out.println(podrozny.getWiek());
	        Celnik celnik = celnicy.get(random.nextInt(celnicy.size()));
	        System.out.println("Kocham Javę");
	        try {
	            celnik.control(podrozny);
	        } catch (NieletniException nieletniException) {
	            System.out.println(nieletniException.getMessage());
	        }
	        iterator.remove(); // Usuń bieżący element z listy
//	        System.out.println(podrozni.size());
	    }
	}
//		for (Podrozny podrozny : podrozni) {
//			Celnik celnik = celnicy.get(random.nextInt(celnicy.size()));
////			System.out.println(podrozni.size());
//			System.out.println("Kocham jave");
//			try {
//				celnik.control(podrozny);
//			}
//			catch (NieletniException nieletniException) {
//				System.out.println(nieletniException.getMessage());
//			}
////			System.out.println("kkkkkkkkk");
//			iterator.remove(podrozny);
//		}
//	}
	
}
