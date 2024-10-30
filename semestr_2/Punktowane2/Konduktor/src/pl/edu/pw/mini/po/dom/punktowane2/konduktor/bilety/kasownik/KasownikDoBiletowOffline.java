package pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;

public class KasownikDoBiletowOffline extends KasownikDoBiletow{
	
	private List<Bilet> sprzedaneBilety;
	private Set<Bilet> sprawdzoneBilety;
	
	public KasownikDoBiletowOffline(SystemSprzedazyBiletow system) {
		super(system);
		this.sprzedaneBilety = new LinkedList<>();
		this.sprawdzoneBilety = new HashSet<>();
	}
	
	public boolean walidujBilet(Bilet bilet) throws BrakZasieguException{
		if (sprzedaneBilety.contains(bilet)) {
			sprawdzoneBilety.add(bilet);
			sprzedaneBilety.remove(bilet);
			return true;
		}
		return false;
	}
	
	public void wgrajInformacjeOSprzedanychBiletach() {
		Set<Bilet> sprzedaneBiletyZSystemu = this.getSystem().getSprzedaneBilety();
		sprzedaneBilety.clear();
		sprzedaneBilety.addAll(sprzedaneBiletyZSystemu);
	}

}
