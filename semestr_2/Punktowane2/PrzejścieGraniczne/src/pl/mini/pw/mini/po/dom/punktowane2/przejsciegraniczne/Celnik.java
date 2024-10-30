package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne;

import java.util.List;
import java.util.Random;

import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny.Podrozny;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.Towar;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.TrefnyTowar;

public class Celnik {
	
	protected static final Random random = new Random();
	protected Areszt areszt;
	protected List<Podrozny> podrozni;
	
	public Celnik(Areszt areszt, List<Podrozny> podrozni) {
		this.areszt = areszt;
		this.podrozni = podrozni;
	}
	
	public void control(Podrozny podrozny) throws NieletniException{
		int x  = random.nextInt(10);
		if (x >= 8) {
			System.out.println("Sprawdzam");
			sprawdzTowary(podrozny);
		}
	}
	
	private void sprawdzTowary(Podrozny podrozny) throws NieletniException{
		List<Towar> towary = podrozny.getTowary();
		int sumaWartosciCzarnorynkowej = 0;
		for (Towar towar : towary) {
			if (towar instanceof TrefnyTowar) {
				sumaWartosciCzarnorynkowej += ((TrefnyTowar)towar).getWartoscCzarnorynkowa();
			}
		}
		System.out.println(sumaWartosciCzarnorynkowej);
		if (sumaWartosciCzarnorynkowej > 5000) {
			System.out.println("Aresztuje pana");
			areszt.aresztuj(podrozny);
		}
		else {
			System.out.println("Wszystko ok");
		}
	}

}
