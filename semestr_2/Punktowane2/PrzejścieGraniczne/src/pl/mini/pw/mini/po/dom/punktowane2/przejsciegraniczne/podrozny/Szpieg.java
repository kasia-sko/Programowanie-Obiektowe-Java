package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny;

import java.util.ArrayList;
import java.util.List;

import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.LegalnyTowar;
import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.Towar;

public class Szpieg extends UzbrojonyPodrozny{
		
	public Szpieg() {
		super();
		this.towary = generujTowary();
	}

	@Override
	protected List<Towar> generujTowary() {
		int x = random.nextInt(2) + 2;
		List<Towar> towary = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			towary.add(new LegalnyTowar());
		}
		return towary;
	}

}
