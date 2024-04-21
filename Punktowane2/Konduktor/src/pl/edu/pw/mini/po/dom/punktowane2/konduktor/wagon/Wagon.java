package pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;

public class Wagon {
	
	private static int liczbaStolikow = 8;
	private Map<Stolik, TreeSet<Podrozny>> pasazerowiePrzyStoliku;
	private List<Stolik> stoliki;{
		stoliki = new ArrayList<Stolik>();
		for (int i=1; i<liczbaStolikow; i++) {
			stoliki.add(Stolik.values()[i]);
		}
	}
	
	public Wagon(TreeSet<Podrozny> podrozni) {
		this.pasazerowiePrzyStoliku = new HashMap<Stolik, TreeSet<Podrozny>>();
		rozsadzPodroznych(podrozni);
	}
	
	private void rozsadzPodroznych(TreeSet<Podrozny> podrozni) {
		for(Podrozny podrozny : podrozni) {
			Bilet bilet = podrozny.getBilet();
			Stolik stolik = bilet.getNazwaStolika();
			if (pasazerowiePrzyStoliku.containsKey(stolik)) {
				TreeSet<Podrozny> juzObecniPodrozni = pasazerowiePrzyStoliku.get(stolik);
				juzObecniPodrozni.add(podrozny);
				pasazerowiePrzyStoliku.put(stolik, juzObecniPodrozni);
			}
			else {
				pasazerowiePrzyStoliku.put(stolik, podrozni);
			}
			
		}
	}
	
	public static int getLiczbaStolikow() {
		return liczbaStolikow;
	}
	
	public TreeSet<Podrozny> getPasazerowiePrzyStoliku(Stolik stolik){
		TreeSet<Podrozny> podrozni = pasazerowiePrzyStoliku.get(stolik);
		return podrozni;
	}
	
	public Map<Stolik, TreeSet<Podrozny>> getWszyscyPasazerowiePrzyStoliku(){
		return pasazerowiePrzyStoliku;
	}

}
