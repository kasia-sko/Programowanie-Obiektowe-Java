package pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik;

import java.util.Random;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;

public class KasownikDoBiletowOnline extends KasownikDoBiletow{
	
	private static final Random random = new Random();
 
	public KasownikDoBiletowOnline(SystemSprzedazyBiletow system) {
		super(system);
	}

	@Override
	public boolean walidujBilet(Bilet bilet) throws BrakZasieguException {
		int x = random.nextInt(100);
		if (x < 2) {
			throw new BrakZasieguException();
		}
		return this.getSystem().zweryfikujBilet(bilet);
	}
	

}
