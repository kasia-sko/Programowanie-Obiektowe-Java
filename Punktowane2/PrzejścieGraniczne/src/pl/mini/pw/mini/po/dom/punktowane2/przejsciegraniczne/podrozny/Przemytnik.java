package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny;

import java.util.ArrayList;
import java.util.List;

import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.LegalnyTowar;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.Towar;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.TrefnyTowar;

public class Przemytnik extends UzbrojonyPodrozny{
	
	public Przemytnik() {
		super();
		this.towary = generujTowary();
	}

	@Override
	protected List<Towar> generujTowary() {
		int x = random.nextInt(30);
		List<Towar> towary = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			int s = random.nextInt(10);
			if (s >= 6) {
				towary.add(new TrefnyTowar());
			}
			else {
				towary.add(new LegalnyTowar());
			}
		}
		return towary;
	}



	
	

}
