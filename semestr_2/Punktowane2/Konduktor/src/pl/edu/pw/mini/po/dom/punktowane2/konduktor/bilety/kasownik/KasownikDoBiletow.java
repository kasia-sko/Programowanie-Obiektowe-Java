package pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;

public abstract class KasownikDoBiletow implements SprawdzajacyBilety{
	
	private SystemSprzedazyBiletow system;
	
	public KasownikDoBiletow(SystemSprzedazyBiletow system) {
		this.system = system;
	}
	
	public abstract boolean walidujBilet(Bilet bilet) throws BrakZasieguException;

	public SystemSprzedazyBiletow getSystem() {
		return system;
	}
}
